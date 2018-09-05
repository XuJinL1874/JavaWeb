package cn.itmastc.transfer.service;

import cn.itmastc.transfer.dao.TransferDao;
import cn.itmastc.utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 20:20 2018/9/5
 * @Modified By:
 */
public class TransferService {

    public boolean transfer(String out, String in, double money) {

        TransferDao dao = new TransferDao();

        boolean isTranferSuccess = true;
        Connection conn = null;
        try {

            //开启事务
            conn = DataSourceUtils.getConnection();
            conn.setAutoCommit(false);

            //开启事务
           //  DataSourceUtils.startTransaction();

            //转出钱的方法
            dao.out(conn, out,money);
            int i = 1/0;
            //转入钱的方法
            dao.in(conn, in,money);

        } catch (Exception e) {
            isTranferSuccess = false;
            //回滚事务
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally{
            try {
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isTranferSuccess;
    }
}
