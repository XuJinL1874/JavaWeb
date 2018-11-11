package cn.mastc.mybatis.dao;

import cn.mastc.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author X_JinL
 * @version 1.0.0
 * @ClassName UserDaoImpl
 * @Description
 * @createTime 2018/11/10 17:02
 */
public class UserDaoImpl implements UserDao {

    //注入
    private SqlSessionFactory sqlSessionFactory;
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    //通过用户ID查询一个用户
    @Override
    public User selectUserById(Integer id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectOne("test.findUserById", id);
    }

    //通过用户ID查询一个用户
    public List<User> selectUserByUsername(Integer id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectList("test.findUserByUsername", id);
    }

}
