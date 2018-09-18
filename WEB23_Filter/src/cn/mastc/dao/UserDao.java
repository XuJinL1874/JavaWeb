package cn.mastc.dao;

import cn.mastc.domain.User;
import cn.mastc.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 16:57 2018/9/18
 * @Modified By:
 */
public class UserDao {
    public User login(String username, String password) throws SQLException {

        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where username=? and password=?";
        return runner.query(sql, new BeanHandler<User>(User.class), username,password);
    }

}
