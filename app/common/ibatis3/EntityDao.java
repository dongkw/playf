package common.ibatis3;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DaoSupport;

public interface EntityDao<E, PK extends Serializable> {

	public E getById(PK id) throws DataAccessException;

	public boolean deleteById(PK id) throws DataAccessException;

	/** 插入数据 
	 * @return */
	public boolean save(E entity) throws DataAccessException;

	/** 更新数据 
	 * @return */
	public boolean update(E entity) throws DataAccessException;

	/** 根据id检查是否插入或是更新数据 
	 * @return */
	public void saveOrUpdate(E entity) throws DataAccessException;

	public boolean isUnique(E entity, String uniquePropertyNames) throws DataAccessException;

	/** 用于hibernate.flush() 有些dao实现不需要实现此类 */
	public void flush() throws DataAccessException;

	public List<E> findAll() throws DataAccessException;

}
