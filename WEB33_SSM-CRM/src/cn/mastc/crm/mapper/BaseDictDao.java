package cn.mastc.crm.mapper;

import cn.mastc.crm.pojo.BaseDict;

import java.util.List;

/**
 * @author X_JinL
 * @version 1.0.0
 * @ClassName BaseDictDao.java
 * @Description
 * @createTime 2018/11/29 18:59
 */
public interface BaseDictDao {

    //查询
    public List<BaseDict> selectBaseDictListByCode(String code);

}
