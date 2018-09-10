package cn.mastc.dao;

import cn.mastc.domain.Product;
import cn.mastc.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 18:51 2018/9/10
 * @Modified By:
 */
public class ProductDao {
    public List<Product> findAllProduct() throws SQLException {
        return new QueryRunner(DataSourceUtils.getDataSource()).query("select * from product",
                new BeanListHandler<Product>(Product.class));
    }
}
