package cn.mastc.service;

import cn.mastc.dao.ProductDao;
import cn.mastc.domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 16:04 2018/9/12
 * @Modified By:
 */
public class ProductService {
    //根据关键字查询商品
    public List<Object> findProductByWord(String word) throws SQLException {
        ProductDao dao = new ProductDao();
        return dao.findProductByWord(word);
    }
}
