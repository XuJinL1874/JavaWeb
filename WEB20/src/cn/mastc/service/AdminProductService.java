package cn.mastc.service;

import cn.mastc.dao.AdminProductDao;
import cn.mastc.domain.Category;
import cn.mastc.domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 14:09 2018/9/7
 * @Modified By:
 */
public class AdminProductService {

    //查询所有的商品
    public List<Product> findAllProduct() throws SQLException {
        //因为没有复杂业务 直接传递请求到dao层
        AdminProductDao dao = new AdminProductDao();
        return dao.findAllProduct();
    }

    // 获得所有的类别
    public List<Category> findAllCategory() throws SQLException {
        AdminProductDao dao = new AdminProductDao();
        return dao.findAllCategory();
    }

    // 添加数据
    public void addProduct(Product product) throws SQLException {
        AdminProductDao dao = new AdminProductDao();
        dao.addProduct(product);
    }
}