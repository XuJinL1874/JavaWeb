package cn.mastc.springmvc.service;

import cn.mastc.springmvc.dao.ItemsMapper;
import cn.mastc.springmvc.pojo.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author X_JinL
 * @version 1.0.0
 * @ClassName ItemServiceImpl.java
 * @Description  查询商品信息
 * @createTime 2018/11/21 20:31
 */
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemsMapper itemsMapper;

    // 查询商品列表
    @Override
    public List<Items> selectItemsList() {
        return itemsMapper.selectByExampleWithBLOBs(null);
    }

}
