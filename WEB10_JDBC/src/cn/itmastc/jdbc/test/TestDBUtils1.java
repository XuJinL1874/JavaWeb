package cn.itmastc.jdbc.test;

import cn.itmastc.domain.User;
import cn.itmastc.jdbc.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author: X_JinL
 * @Description: 测试DBUtils工具类查询操作
 * @Date: Created in 15:08 2018/8/23
 * @Modified By:
 */
public class TestDBUtils1 {

    /**
     * 查询所有
     */
    @Test
    public void testQueryAll() {
        try {
            // 1.获取核心类QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            // 2.编写sql语句
            String sql = "select * from tbl_user";
            // 3.执行查询操作
            List<User> users = qr.query(sql, new BeanListHandler<User>(User.class));
            // 4.对结果集进行遍历
            for (User user : users) {
                System.out.println(user.getUname()+"..."+user.getUpassword());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据id查询用户方法
     */
    @Test
    public void testQueryById() {
        try {
            // 1.获取核心类QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            // 2.编写sql语句
            String sql = "select * from tbl_user where uid=?";
            // 3.设置参数
            Object[] params = {5};
            // 4.执行查询操作
            User user = qr.query(sql, new BeanHandler<User>(User.class), params);
            System.out.println(user.getUname()+"..."+user.getUpassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有用户的总个数
     */
    @Test
    public void testQueryCount() {
        try {
            // 1.获取核心类QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            // 2.编写sql语句
            String sql = "select count(*) from tbl_user";
            // 3.执行查询操作
            Object count = qr.query(sql, new ScalarHandler());
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有
     */
    @Test
    public void testQueryAll_01() {
        try {
            // 1.获取核心类QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            // 2.编写sql语句
            String sql = "select * from tbl_user";
            // 3.执行查询操作
            List<Map<String, Object>> list = qr.query(sql, new MapListHandler());
            // 4.对结果集进行遍历
            for (Map<String, Object> map: list){
                System.out.println(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有
     */
    @Test
    public void testQueryAll_02() {
        try {
            // 1.获取核心类QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            // 2.编写sql语句
            String sql = "select * from tbl_user";
            // 3.执行查询操作
            List<Object> list = qr.query(sql, new ColumnListHandler<Object>("uname"));
            // 4.对结果集进行遍历
            for (Object object: list) {
                System.out.println(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
