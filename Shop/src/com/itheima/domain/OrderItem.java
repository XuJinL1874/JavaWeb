package com.itheima.domain;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 20:09 2018/10/15
 * @Modified By:
 */
public class OrderItem {


	/*`itemid` varchar(32) NOT NULL,
	  `count` int(11) DEFAULT NULL,
	  `subtotal` double DEFAULT NULL,
	  `pid` varchar(32) DEFAULT NULL,
	  `oid` varchar(32) DEFAULT NULL*/

    // 订单项的id

    private String itemid;

    // 订单项内商品的购买数量

    private  int count;

    // 订单项小计

    private  double subtotal;

    // 订单项内部的商品

    private Product product;

    // 该订单输入哪个订单

    private Order order;

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
