package cn.itmastc.jdbc.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: X_JinL
 * @Description: C3P0工具类
 * @Date: Created in 0:26 2018/8/23
 * @Modified By:
 */
public class C3P0Utils {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
