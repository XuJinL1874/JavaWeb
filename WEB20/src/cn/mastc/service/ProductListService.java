package cn.mastc.service;

import cn.mastc.dao.ProductDao;
import cn.mastc.domain.Product;
import cn.mastc.vo.PageBean;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 18:49 2018/9/10
 * @Modified By:
 */
public class ProductListService {


    public List<Product> findAllProduct() throws SQLException {
        ProductDao dao = new ProductDao();
        return dao.findAllProduct();
    }

    // 分页操作
    public PageBean findPageBean() {
        return null;
    }
}
