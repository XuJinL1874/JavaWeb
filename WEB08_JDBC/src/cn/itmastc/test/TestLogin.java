package cn.itmastc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
/**
 * @Author: X_JinL
 * @Description: 测试sql注入问题
 * @Date: Created in 13:40 2018/8/21
 * @Modified By:
 */
public class TestLogin {

    @Test
    public void testLogin(){
        try {
            login1("zs'or'zs","123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 用户登录方法
     * @param username
     * @param password
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void login(String username, String password) throws ClassNotFoundException, SQLException {
        // 1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2. 获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web08", "root",
                "123456");
        // 3.创建sql语句执行对象
        Statement stmt = conn.createStatement();
        // 4.书写sql语句
        String sql = "select * from tbl_user where " + "uname='" + username + "' and upassword='" + password + "'";
        // 5.执行sql语句
        ResultSet rs = stmt.executeQuery(sql);
        // 6.对结果集进行处理
        if (rs.next()){
            System.out.println("恭喜您," + username + ",登录成功!");
            System.out.println(sql);
        }else {
            System.out.println("账号或密码错误");
        }
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
    public void login1(String username, String password) throws ClassNotFoundException, SQLException {
        // 1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2.获取连接
        Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/web08", "root",
                "123456");
        // 3.编写sql语句
        String sql = "select * from tbl_user where uname=? and upassword=?";
        // 4.创建预处理对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        // 5.(给占位符)设置参数
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        // 6.执行查询操作
        ResultSet rs = pstmt.executeQuery();
        // 6.对结果集进行处理
        if (rs.next()){
            System.out.println("恭喜您," + username + ",登录成功!");
            System.out.println(sql);
        }else {
            System.out.println("账号或密码错误");
        }
        if (rs != null) {
            rs.close();
        }
        if (pstmt != null) {
            pstmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}
