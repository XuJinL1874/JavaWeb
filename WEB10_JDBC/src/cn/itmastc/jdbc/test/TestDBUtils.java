package cn.itmastc.jdbc.test;

import cn.itmastc.jdbc.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @Author: X_JinL
 * @Description: 测试DBUtils工具类的增删改操作
 * @Date: Created in 14:26 2018/8/23
 * @Modified By:
 */
public class TestDBUtils {



    /**
     * 添加用户方法
     */
    @Test
    public void  testAddUser(){
        try {
            // 1.创建核心类QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            // 2.编写sql语句
            String sql = "insert into tbl_user values(null, ?, ?)";
            // 3.为占位符设置值
            Object[] params = {"余淮", "耿耿"};
            // 4.执行添加操作
            int rows = qr.update(sql, params);
            if (rows > 0) {
                System.out.println("添加成功!");
            } else {
                System.out.println("添加失败!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 修改用户方法
     */
    @Test
    public void testUpdateUserById() {
        try {
            // 1.创建核心类QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            // 2.编写sql语句
            String sql = "update tbl_user set upassword=? where uid=?";
            // 3.为占位符设置值
            Object[] params = {"xxx", 2};
            // 4.执行添加操作
            int rows = qr.update(sql, params);
            if (rows > 0) {
                System.out.println("修改成功!");
            } else {
                System.out.println("修改失败!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除用户方法
     */
    @Test
    public void testDeleteUserById() {
        try {
            // 1.创建核心类QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            // 2.编写sql语句
            String sql = "delete from tbl_user where uid=?";
            // 3.为占位符设置值
            Object[] params = {6};
            // 4.执行添加操作
            int rows = qr.update(sql, params);
            if (rows > 0) {
                System.out.println("删除成功!");
            } else {
                System.out.println("删除失败!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
