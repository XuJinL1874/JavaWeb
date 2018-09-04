package cn.itmastc.service;

import cn.itmastc.dao.ProductDao;
import cn.itmastc.domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 22:35 2018/9/4
 * @Modified By:
 */
public class ProductService {
    public List<Product> findAllProduct() throws SQLException {
        // 没有复杂业务
        // 传递请求到dao层
        ProductDao dao = new ProductDao();
        List<Product> productList = dao.findAllProduct();
        return productList;
    }
}
