package cn.itmastc.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 15:06 2018/9/6
 * @Modified By:
 */
public class MyDataSourceUtils {

    // 获得Connection ----- 从连接池中
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    // 创建ThreadLocal

    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    // 开启事务
    public static void startTransaction() throws SQLException {
        Connection conn = getCurrentConnection();
        conn.setAutoCommit(false);
    }

    // 获得当前线程上绑定的conn
    public static Connection getCurrentConnection() throws SQLException {
        // 从ThreadLocal寻找 当前线程是否有对应Connection
        Connection conn = tl.get();
        if (conn == null) {
            // 获得新的Connection
            conn = getConnection();
            // 将conn资源绑定到 ThreadLocal(map)上
            tl.set(conn);
        }
        return conn;
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // 回滚事务
    public static void rollback() throws SQLException {
        getCurrentConnection().rollback();
    }

    // 提交事务
    public static void commit() throws SQLException {
        Connection conn = getCurrentConnection();
        conn.commit();
        // 将Connection从ThreadLocal中移除
        tl.remove();
        conn.close();
    }
}
