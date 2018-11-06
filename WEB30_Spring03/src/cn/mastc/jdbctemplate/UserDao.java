package cn.mastc.jdbctemplate;

import cn.mastc.bean.User;

import java.util.List;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 13:46 2018/11/6
 * @Modified By:
 */
public interface UserDao {

    // 增
    void save(User u);

    // 删
    void delete(Integer id);

    // 改
    void update(User u);

    // 查
    User getById(Integer id);

    // 查
    int getTotalCount();

    // 查
    List<User> getAll();


}
