package cn.mastc.mybatis.junit;

import cn.mastc.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 15:31 2018/11/9
 * @Modified By:
 */
public class MybatisFirstTest {

    @Test
    public void testMybatis() throws Exception {
        //加载核心配置文件
        String resource = "SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行Sql语句
        User user = sqlSession.selectOne("test.findUserById", 10);

        System.out.println(user);

    }

    // 根据用户名称模糊查询用户列表
    @Test
    public void testFindUserByUsername() throws Exception {
        //加载核心配置文件
        String resource = "SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> users = sqlSession.selectList("test.findUserByUsername", "五");
        for (User user2 : users) {
            System.out.println(user2);
        }

    }

    // 添加用户
    @Test
    public void testInsertUser() throws Exception {
        //加载核心配置文件
        String resource = "SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行SQL语句
        User user = new User();
        user.setUsername("学海无涯");
        user.setBirthday(new Date());
        user.setAddress("安徽省马鞍山市雨山区");
        user.setSex("男");
        int i = sqlSession.insert("test.insertUser", user);
        sqlSession.commit();

        System.out.println(user.getId());
    }

    // 更新用户
    @Test
    public void testUpdateUserById() throws Exception {
        //加载核心配置文件
        String resource = "SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行SQL语句
        User user = new User();
        user.setId(28);
        user.setUsername("睿智的ta");
        user.setBirthday(new Date());
        user.setAddress("安徽省界首市");
        user.setSex("男");
        int i = sqlSession.update("test.updateUserById", user);
        sqlSession.commit();
    }

    // 删除用户
    @Test
    public void testDeleteUser() throws Exception {
        //加载核心配置文件
        String resource = "SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();


        int i = sqlSession.delete("test.deleteUserById", 27);
        sqlSession.commit();
    }

}
