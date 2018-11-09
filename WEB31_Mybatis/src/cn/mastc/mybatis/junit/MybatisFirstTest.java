package cn.mastc.mybatis.junit;

import cn.mastc.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

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

}
