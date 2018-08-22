package cn.itmastc.jdbc.test;

import cn.itmastc.jdbc.datasource.MyDataSource;
import cn.itmastc.jdbc.datasource.MyDataSource1;
import cn.itmastc.jdbc.utils.JDBCUtils;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @Author: X_JinL
 * @Description: 测试连接池
 * @Date: Created in 22:08 2018/8/22
 * @Modified By:
 */
public class TestMyDataSource {



    /**
     * 添加用户
     * 使用未改造过的Connection
     */
    @Test
    public void testAddUser() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        // 1.创建自定义连接池对象
        MyDataSource dataSource = new MyDataSource();
        try {
            // 2.从池子中获取连接
            conn = dataSource.getConnection();
            String sql = "insert into tbl_user values(null, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"吕布");
            pstmt.setString(2, "貂蝉");
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            dataSource.backConnection(conn);
        }
    }

    /**
     * 添加用户
     * 使用改造过的Connection
     */
    @Test
    public void testAddUser1() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        // 1.创建自定义连接池对象
        DataSource dataSource = new MyDataSource1();
        try {
            // 2.从池子中获取连接
            conn = dataSource.getConnection();
            String sql = "insert into tbl_user values(null, ?, ?)";
            // 3.必须在自定义的Connection类中重写prepareStatement(sql)方法
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"王炸");
            pstmt.setString(2, "四个A");
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
