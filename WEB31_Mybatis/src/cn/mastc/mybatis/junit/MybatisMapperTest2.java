package cn.mastc.mybatis.junit;

import cn.mastc.mybatis.mapper.OrderMapper;
import cn.mastc.mybatis.pojo.Orders;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

@SuppressWarnings("all")
public class MybatisMapperTest2 {


	@Test
	public void testOrderList() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// sqlSession帮我们生成一个实现类(接口)
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<Orders> selectOrdersList = orderMapper.selectOrders();

		for (Orders orders : selectOrdersList) {
			System.out.println(orders);

		}

	}


}
