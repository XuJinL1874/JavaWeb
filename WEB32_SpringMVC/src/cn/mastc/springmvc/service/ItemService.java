package cn.mastc.springmvc.service;

import cn.mastc.springmvc.pojo.Items;

import java.util.List;

/**
 * @author X_JinL
 * @version 1.0.0
 * @ClassName ItemService.java
 * @Description
 * @createTime 2018/11/21 20:31
 */
public interface ItemService {

    // 查询商品列表
    public List<Items> selectItemsList();

}
