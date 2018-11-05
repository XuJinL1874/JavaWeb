package cn.mastc.jdbctemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

/**
 * @Author: X_JinL
 * @Description:  演示JDBC模板
 * @Date: Created in 17:33 2018/11/5
 * @Modified By:
 */
public class Demo {

    @Test
    public void fun1() throws PropertyVetoException {

        // 0.准备连接池
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql:///web23");
        dataSource.setUser("root");
        dataSource.setPassword("123456");

        // 1.创建JDBC模板对象
        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(dataSource);

        // 2.书写SQL并执行
        String sql = "insert into user values(null,'rose')";
        jt.update(sql);
    }

}
