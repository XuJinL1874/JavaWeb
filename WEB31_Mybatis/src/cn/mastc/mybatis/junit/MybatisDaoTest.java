package cn.mastc.mybatis.junit;

import cn.mastc.mybatis.dao.UserDao;
import cn.mastc.mybatis.dao.UserDaoImpl;
import cn.mastc.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class MybatisDaoTest {

	public SqlSessionFactory sqlSessionFactory;
	@Before
	public void before() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	}
	@Test
	public void testDao() throws Exception {
		
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		
		User user = userDao.selectUserById(10);
		System.out.println(user);
	}
}
