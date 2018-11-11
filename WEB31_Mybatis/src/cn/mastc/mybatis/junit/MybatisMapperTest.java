package cn.mastc.mybatis.junit;

import cn.mastc.mybatis.mapper.UserMapper;
import cn.mastc.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author X_JinL
 * @version 1.0.0
 * @ClassName
 * @Description
 * @createTime 2018/11/11 15:14
 */
public class MybatisMapperTest {

    @Test
    public void testMapper() throws IOException {
        //加载核心配置文件
        String resource = "SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // SqlSession帮我们生成一个实现类(前提:要给接口)
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserById(10);
        System.out.println(user);

    }

    @Test
    public void testMapperQueyVo() throws IOException {
        //加载核心配置文件
        String resource = "SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // SqlSession帮我们生成一个实现类(前提:要给接口)
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserByQueryVo();
        System.out.println(user);

    }

}
