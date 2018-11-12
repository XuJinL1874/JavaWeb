package cn.mastc.mybatis.mapper;

import cn.mastc.mybatis.pojo.Orders;

import java.util.List;

/**
 * @author X_JinL
 * @version 1.0.0
 * @ClassName OrderMapper.java
 * @Description
 * @createTime 2018/11/12 15:49
 */
public interface OrderMapper {

    // 查询订单表order的所有数据
    public List<Orders> selectOrdersList();

}
