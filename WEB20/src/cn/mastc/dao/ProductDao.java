package cn.mastc.dao;

import cn.mastc.domain.Product;
import cn.mastc.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

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

    // 获取全部商品个数
    public int getTotalCount() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from product";
        Long query = (Long) runner.query(sql, new ScalarHandler());
        return query.intValue();
    }

    public List<Product> findProductListForPageBean( int index, int currentCount) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product limit ?,?";
        return runner.query(sql, new BeanListHandler<Product>(Product.class), index, currentCount);
    }

    public List<Object> findProductByWord(String word) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where pname like ? limit 0,8";
        List<Object> query = runner.query(sql, new ColumnListHandler("pname"), "%"+word+"%");
        return query;
    }
}
