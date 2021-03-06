package common.ibatis3;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.util.Assert;

import cn.org.rapid_framework.beanutils.PropertyUtils;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;


public abstract class BaseIbatis3Dao<E, PK extends Serializable> extends DaoSupport implements
		EntityDao<E, PK> {
	protected final Log log = LogFactory.getLog(getClass());
	
	private SqlSessionFactory sqlSessionFactory;
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	protected void checkDaoConfig() throws IllegalArgumentException {
		Assert.notNull(sqlSessionFactory,"sqlSessionFactory must be not null");
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
		this.sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
	}
	
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public E getById(PK primaryKey) {
		E object = (E)getSqlSessionTemplate().selectOne(
				getFindByPrimaryKeyStatement(), primaryKey);
		return object;
	}

	public boolean deleteById(PK id) {
		@SuppressWarnings("unused")
		int affectCount = getSqlSessionTemplate().delete(getDeleteStatement(),id);
		if(affectCount>0)
		{
			return true;
		}else
		{
			return false;
		}
	}

	public boolean save(E entity) {
		prepareObjectForSaveOrUpdate(entity);
		@SuppressWarnings("unused")
		int affectCount = getSqlSessionTemplate().insert(getInsertStatement(),entity);
		if(affectCount>0)
		{
			return true;
		}else
		{
			return false;
		}
	}

	public boolean update(E entity) {
		prepareObjectForSaveOrUpdate(entity);
		@SuppressWarnings("unused")
		int affectCount = getSqlSessionTemplate().update(getUpdateStatement(),entity);
		if(affectCount>0)
		{
			return true;
		}else
		{
			return false;
		}
	}

	/**
	 * 用于子类覆盖,在insert,update之前调用
	 * 
	 * @param o
	 */
	protected void prepareObjectForSaveOrUpdate(E o) {
	}

	public abstract String getIbatisMapperNamesapce();

	public String getFindByPrimaryKeyStatement() {
		return getIbatisMapperNamesapce() + ".getById";
	}

	public String getInsertStatement() {
		return getIbatisMapperNamesapce() + ".insert";
	}

	public String getUpdateStatement() {
		return getIbatisMapperNamesapce() + ".update";
	}

	public String getDeleteStatement() {
		return getIbatisMapperNamesapce() + ".delete";
	}

	public String getCountStatementForPaging(String statementName) {
		return statementName + ".count";
	}

	protected Page<E> pageQuery(String statementName, PageRequest pageRequest) {
		return pageQuery(getSqlSessionTemplate(), statementName,
				getCountStatementForPaging(statementName), pageRequest);
	}

	public static Page pageQuery(SqlSessionTemplate sqlSessionTemplate,
			String statementName, String countStatementName,
			PageRequest pageRequest) {

		Number totalCount = (Number) sqlSessionTemplate.selectOne(
				countStatementName, pageRequest);
		if (totalCount == null || totalCount.longValue() <= 0) {
			return new Page(pageRequest, 0);
		}

		Page page = new Page(pageRequest, totalCount.intValue());

		// 其它分页参数,用于不喜欢或是因为兼容性而不使用方言(Dialect)的分页用户使用.
		// 与getSqlMapClientTemplate().queryForList(statementName,
		// parameterObject)配合使用
		Map filters = new HashMap();
//		filters.put("offset", page.getFirstResult());
//		filters.put("pageSize", page.getPageSize());
//		filters.put("lastRows", page.getFirstResult() + page.getPageSize());
//		filters.put("sortColumns", pageRequest.getSortColumns());
//
//		Map parameterObject = PropertyUtils.describe(pageRequest);
//		filters.putAll(parameterObject);
//
//		List list = sqlSessionTemplate.selectList(statementName, filters,
//				page.getFirstResult(), page.getPageSize());
		
		//以上分页会对没有的页进行显示最后一页，例如数据只有24页，选择25及25之后的页面，就显示24页的内容。
		int offset=0;
		if(pageRequest.getPageNumber()>=1){
			offset=(pageRequest.getPageNumber()-1)*pageRequest.getPageSize();
		}
		
		filters.put("pageSize", page.getPageSize());
		filters.put("lastRows", page.getFirstResult() + page.getPageSize());
		filters.put("sortColumns", pageRequest.getSortColumns());

		Map parameterObject = PropertyUtils.describe(pageRequest);
		filters.putAll(parameterObject);

		List list = sqlSessionTemplate.selectList(statementName, filters,
				offset, page.getPageSize());
		page.setResult(list);
		return page;
	}

	public List findAll() {
		throw new UnsupportedOperationException();
	}

	public boolean isUnique(E entity, String uniquePropertyNames) {
		throw new UnsupportedOperationException();
	}

	public void flush() {
		throw new UnsupportedOperationException();
	}
	
	public static class SqlSessionTemplate {
	
		SqlSessionFactory sqlSessionFactory;
		
		public SqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
			this.sqlSessionFactory = sqlSessionFactory;
		}

		public Object execute(SqlSessionCallback action) {
			SqlSession session = null;
			try {
				session = sqlSessionFactory.openSession();
				Object result = action.doInSession(session);
				session.commit();
				return result;
			} finally {
				if (session != null)
					session.close();
			}
		}

		public Object selectOne(final String statement, final Object parameter) {
			return execute(new SqlSessionCallback() {
				public Object doInSession(SqlSession session) {
					return session.selectOne(statement, parameter);
				}
			});
		}

		public List selectList(final String statement, final Object parameter) {
			return (List) execute(new SqlSessionCallback() {
				public Object doInSession(SqlSession session) {
					return session.selectList(statement, parameter);
				}
			});
		}
		
		public List selectList(final String statement, final Object parameter,
				final int offset, final int limit) {
			return (List) execute(new SqlSessionCallback() {
				public Object doInSession(SqlSession session) {
					return session.selectList(statement, parameter,
							new RowBounds(offset, limit));
				}
			});
		}
		

		public int delete(final String statement, final Object parameter) {
			return (Integer) execute(new SqlSessionCallback() {
				public Object doInSession(SqlSession session) {
					return session.delete(statement, parameter);
				}
			});
		}

		public int update(final String statement, final Object parameter) {
			return (Integer) execute(new SqlSessionCallback() {
				public Object doInSession(SqlSession session) {
					return session.update(statement, parameter);
				}
			});
		}

		public int insert(final String statement, final Object parameter) {
			return (Integer) execute(new SqlSessionCallback() {
				public Object doInSession(SqlSession session) {
					return session.insert(statement, parameter);
				}
			});
		}
	}

	public static interface SqlSessionCallback {

		public Object doInSession(SqlSession session);

	}

}
