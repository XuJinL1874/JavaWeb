package cn.mastc.mybatis.dao;


import cn.mastc.mybatis.pojo.User;

public interface UserDao {

	//通过用户ID查询一个用户
	public User selectUserById(Integer id);
}
