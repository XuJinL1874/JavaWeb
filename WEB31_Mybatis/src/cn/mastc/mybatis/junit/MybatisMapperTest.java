package cn.mastc.mybatis.junit;

import cn.mastc.mybatis.mapper.OrderMapper;
import cn.mastc.mybatis.mapper.UserMapper;
import cn.mastc.mybatis.pojo.Orders;
import cn.mastc.mybatis.pojo.QueryVo;
import cn.mastc.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


public class MybatisMapperTest {


	@Test
	public void testMapper() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//SqlSEssion帮我生成一个实现类  （给接口）
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);


		User user = userMapper.findUserById(10);
		System.out.println(user);
	}
	@Test
	public void testMapperQueryVo() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//SqlSEssion帮我生成一个实现类  （给接口）
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		QueryVo vo = new QueryVo();
		User user = new User();
		user.setUsername("五");
		vo.setUser(user);

		List<User> us = userMapper.findUserByQueryVo(vo);
		for (User u : us) {
			System.out.println(u);

		}
	}
	@Test
	public void testMapperQueryVoCOunt() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//SqlSEssion帮我生成一个实现类  （给接口）
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		Integer i = userMapper.userCount();
		System.out.println(i);
	}
	//	查询订单表order的所有数据
	@Test
	public void testOrderList() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

		List<Orders> ordersList = mapper.selectOrdersList();
		for (Orders orders : ordersList) {
			System.out.println(orders);
		}
	}

	@Test
	public void testFindUserBySexAndUsername() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setSex("1");
		user.setUsername("张小明");

		List<User> users = userMapper.selectUserBySexAndUsername(user);
		for (User user2 : users) {
			System.out.println(user2);
		}

	}

}
