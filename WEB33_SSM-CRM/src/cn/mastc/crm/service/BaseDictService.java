package cn.mastc.crm.service;

import cn.mastc.crm.pojo.BaseDict;

import java.util.List;

/**
 * @author X_JinL
 * @version 1.0.0
 * @ClassName BaseDictService.java
 * @Description
 * @createTime 2018/11/29 19:07
 */
public interface BaseDictService {

    //查询
    public List<BaseDict> selectBaseDictListByCode(String code);

}
