package cn.itmastc.dbutils;

import cn.itmastc.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 15:34 2018/9/5
 * @Modified By:
 */
public class DBUtilsDemo {
    public static void main(String[] args) {

        Connection conn = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            /*java.sql.SQLException: QueryRunner requires a DataSource to be invoked in this way, or a Connection should be passed in
            at org.apache.commons.dbutils.AbstractQueryRunner.prepareConnection(AbstractQueryRunner.java:153)
            ----获得一个DataSource(连接池)or Connection*/

            // 获得一个connection
            conn = DataSourceUtils.getConnection();

            // 开启事务
            conn.setAutoCommit(false);

            queryRunner.update(conn,"update account set money=15000 where name='tom'");
            // 提交或回滚事务
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

    }
}
