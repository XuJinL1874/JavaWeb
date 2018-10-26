package com.itheima.service;

import com.itheima.dao.AdminDao;
import com.itheima.domain.Category;
import com.itheima.domain.Order;
import com.itheima.domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 16:52 2018/10/25
 * @Modified By:
 */
public class AdminService {

    public List<Category> findAllCategory() {
        AdminDao dao = new AdminDao();
        try {
            return dao.findAllCategory();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveProduct(Product product) throws SQLException {
        AdminDao dao = new AdminDao();
        dao.saveProduct(product);
    }

    public List<Order> findAllOrders() {
        AdminDao dao = new AdminDao();
        List<Order> orderList = null;
        try {
            orderList = dao.findAllOrders();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }
}
