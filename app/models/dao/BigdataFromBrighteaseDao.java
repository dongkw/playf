package models.dao;

import cn.org.rapid_framework.page.Page;
import common.ibatis3.BaseIbatis3Dao;
import models.model.BigdataFromBrightease;
import models.vo.query.BigdataFromBrighteaseQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BigdataFromBrighteaseDao extends BaseIbatis3Dao<BigdataFromBrightease, Long> {

    @Override
    public String getIbatisMapperNamesapce() {
        return "BigdataFromBrightease";
    }

    public void saveOrUpdate(BigdataFromBrightease entity) {
        if (entity.getId() == null)
            save(entity);
        else
            update(entity);
    }

    public Page findPage(BigdataFromBrighteaseQuery query) {
        return pageQuery("BigdataFromBrightease.findPage", query);
    }


    public List<Map<String, Object>> findList(Map<String, Object> map) {

        return (List<Map<String, Object>>)getSqlSessionTemplate().selectList(getIbatisMapperNamesapce() + ".findAll", map);
    }
    public Map<String, Object> findCount(Map<String, Object> map) {

        return (Map<String, Object>)getSqlSessionTemplate().selectOne(getIbatisMapperNamesapce() + ".findCount", map);
    }

}