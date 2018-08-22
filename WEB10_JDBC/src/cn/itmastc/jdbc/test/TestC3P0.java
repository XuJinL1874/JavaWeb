package cn.itmastc.jdbc.test;

import cn.itmastc.jdbc.utils.C3P0Utils;
import cn.itmastc.jdbc.utils.JDBCUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @Author: X_JinL
 * @Description: 测试C3P0
 * @Date: Created in 0:12 2018/8/23
 * @Modified By:
 */
public class TestC3P0 {

    @Test
    public void testAddUser() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        // 1.创建自定义连接池对象
        /*加载默认的配置*/
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        // ComboPooledDataSource dataSource = new ComboPooledDataSource("itmastc");// 加载有名称的配置
        try {
            // 2.从池子中获取连接
            conn= dataSource.getConnection();
            String sql = "insert into tbl_user values(null, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"大王");
            pstmt.setString(2, "小王");
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.release(conn, pstmt, null);
        }
    }

    @Test
    public void testAddUser1() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 2.从池子中获取连接
            conn = C3P0Utils.getConnection();
            String sql = "insert into tbl_user values(null, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"C3P0");
            pstmt.setString(2, "Utils");
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.release(conn, pstmt, null);
        }
    }
}
