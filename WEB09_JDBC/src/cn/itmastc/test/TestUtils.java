package cn.itmastc.test;

import cn.itmastc.jdbc.JDBCUtils_V1;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: X_JinL
 * @Description: 测试工具类
 * @Date: Created in 16:32 2018/8/22
 * @Modified By:
 */
public class TestUtils {
    /**
     * 根据id查询用户信息
     */
    @Test
    public void testFindUserById() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // 1.获取连接
            conn = JDBCUtils_V1.getConnection();
            // 2.编写sql语句
            String sql = "select * from tbl_user where uid=?";
            // 3.获取执行sql语句对象
            pstmt = conn.prepareStatement(sql);
            // 4.设置参数
            pstmt.setInt(1, 2);
            // 5.执行查询操作
            rs = pstmt.executeQuery();
            // 6.处理结果集
            while (rs.next()) {
                System.out.println(rs.getString(2)+"..."+rs.getString("upassword"));
            }
            // 释放资源不能放在try内
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 7.释放资源
            JDBCUtils_V1.release(conn, pstmt, rs);
        }
    }
}
