package cn.mastc.demo;

import oracle.jdbc.OracleTypes;
import org.junit.Test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author X_JinL
 * @version 1.0.0
 * @ClassName TestOracle.java
 * @Description 用java程序调用存储过程,存储函数
 * @createTime 2018/12/16 21:42
 */
@SuppressWarnings("all")
public class TestOracle {

    /**
     * 存储过程
     * CREATE OR REPLACE procedure queryEmpInformation(eno in number,
     * 													pename out varchar2,
     * 													psal out number,
     * 													pjob out varchar2)
     */
    @Test
    public void testProcedure() {
        // {call <procedure-name>[<arg1>,<arg2>,...]}
        String sql = "{call queryEmpInformation(?,?,?,?)}";

        Connection conn = null;
        CallableStatement call = null;

        try {
            conn = JDBCUtils.getConnection();
            call = conn.prepareCall(sql);

            // 对in参数进行赋值
            call.setInt(1, 7839);

            // 对out参数,申明
            call.registerOutParameter(2, OracleTypes.VARCHAR);
            call.registerOutParameter(3, OracleTypes.NUMBER);
            call.registerOutParameter(4, OracleTypes.VARCHAR);

            // 执行
            call.execute();

            // 输出
            String name = call.getString(2);
            double sal = call.getDouble(3);
            String job = call.getString(4);

            System.out.println(name+"\t"+sal+"\t"+job);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn, call, null);
        }

    }

    /**
     * 存储函数
     * CREATE OR REPLACE function queryEmpIncome(eno in number)
     * return number
     */
    @Test
    public void testFunction() {

        // {?= call <procedure-name>[<arg1>,<arg2>,...]}
        String sql = "{?=call queryEmpIncome(?)}";

        Connection conn = null;
        CallableStatement call = null;

        try {
            conn = JDBCUtils.getConnection();
            call = conn.prepareCall(sql);

            call.registerOutParameter(1, OracleTypes.NUMBER);
            call.setInt(2, 7839);

            // 执行
            call.execute();

            double income = call.getDouble(1);

            System.out.println(income);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn, call, null);
        }

    }

}
