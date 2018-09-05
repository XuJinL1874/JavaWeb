package cn.itmastc.transfer.dao;

import cn.itmastc.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 20:26 2018/9/5
 * @Modified By:
 */
public class TransferDao {


    public void out(Connection conn, String out, double money) throws SQLException {

        QueryRunner runner = new QueryRunner();
        // Connection conn = DataSourceUtils.getCurrentConnection();
        String sql = "update account set money=money-? where name=?";
        runner.update(conn, sql, money,out);

    }

    public void in(Connection conn, String in, double money) throws SQLException {
        QueryRunner runner = new QueryRunner();
       //  Connection conn = DataSourceUtils.getCurrentConnection();
        String sql = "update account set money=money+? where name=?";
        runner.update(conn, sql, money,in);
    }
}
