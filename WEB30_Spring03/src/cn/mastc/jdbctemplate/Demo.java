package cn.mastc.jdbctemplate;

import cn.mastc.bean.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.beans.PropertyVetoException;

/**
 * @Author: X_JinL
 * @Description:  演示JDBC模板
 * @Date: Created in 17:33 2018/11/5
 * @Modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {

    @Resource(name = "userDao")
    private UserDao ud;

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

    @Test
    public void fun2(){
        User u = new User();
        u.setName("X_JinL");
        ud.save(u);
    }

    @Test
    public void fun3(){
        User u = new User();
        u.setId(2);
        u.setName("jack");
        ud.update(u);
    }

    @Test
    public void fun4(){
        ud.delete(2);
    }

    @Test
    public void fun5(){
        System.out.println(ud.getTotalCount());
    }

    @Test
    public void fun6(){
        System.out.println(ud.getById(1));
    }

    @Test
    public void fun7(){
        System.out.println(ud.getAll());
    }

}
