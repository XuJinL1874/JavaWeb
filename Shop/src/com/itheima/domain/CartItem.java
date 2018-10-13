package com.itheima.domain;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 20:09 2018/10/13
 * @Modified By:
 */
public class CartItem {

    private Product product;
    private int buyNum;
    private double subtotal;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int butNum) {
        this.buyNum = buyNum;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
