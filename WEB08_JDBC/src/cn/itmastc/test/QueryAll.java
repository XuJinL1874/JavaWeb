package cn.itmastc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * @Author: X_JinL
 * @Description: 测试查询所有用户的类
 * @Date: Created in 0:30 2018/8/21
 * @Modified By:
 */
public class QueryAll {
    /**
     * 执行SQL语句
     * int executeUpdate(String sql) 执行insert update delete语句(DML语句)
     * ResultSet executeQuery(String sql) 执行select语句(DQL语句)
     * boolean execute(String sql) 执行select返回true,执行其他语句返回false
     *      如果返回true,需要使用getResultSet()获得查询结果
     *      如果返回false,需要使用getUpdateCount()获得影响行数
     */

    @Test
    public void testQueryAll(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            String url ="jdbc:mysql://127.0.0.1:3306/web08?useUnicode=true&characterEncoding=utf8";
            String username="root";
            String password="123456";
            conn = DriverManager.getConnection(url,username,password);
            //3.获取执行sql语句对象
            stmt = conn.createStatement();
            //4.编写sql语句
            String sql = "select * from product";
            //5.执行sql语句
            rs = stmt.executeQuery(sql);
            //6.处理结果集
            while(rs.next()){
                System.out.println("用户名："+rs.getString(2)+" 价格："+rs.getString(
                        "price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt!=null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
