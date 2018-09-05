package cn.itmastc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 14:47 2018/9/5
 * @Modified By:
 */
public class JBDCDemo {
    public static void main(String[] args) {

        // 通过jdbc去控制事物

        Connection conn = null;

        // 1.注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获得连接
            conn = DriverManager.getConnection("jdbc:mysql:///web19", "root", "123456");

            // 手动开启事物
            conn.setAutoCommit(false);

            // 3.获得执行平台
            Statement stmt = conn.createStatement();

            // 4.操作sql
            stmt.executeUpdate("update account set money=5000 where name='tom'");

            // 提交事物
            conn.commit();

            // 5.关闭资源
            stmt.close();
            conn.close();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }


    }
}
