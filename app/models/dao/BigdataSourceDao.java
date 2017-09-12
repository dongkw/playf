package models.dao;

import cn.org.rapid_framework.page.Page;
import common.ibatis3.BaseIbatis3Dao;
import models.model.BigdataSource;
import models.vo.query.BigdataSourceQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BigdataSourceDao extends BaseIbatis3Dao<BigdataSource,Long> {
	
	@Override
	public String getIbatisMapperNamesapce() {
		return "BigdataSource";
	}
	
	public void saveOrUpdate(BigdataSource entity) {
		if(entity.getId() == null) 
			save(entity);
		else 
			update(entity);
	}
	
	public Page findPage(BigdataSourceQuery query) {
		return pageQuery("BigdataSource.findPage",query);
	}
	public List<Map<String, Object>> findList(Map<String, Object> map) {

		return (List<Map<String, Object>>)getSqlSessionTemplate().selectList(getIbatisMapperNamesapce() + ".findAll", map);
	}

}