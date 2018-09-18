package cn.mastc.service;

import cn.mastc.dao.UserDao;
import cn.mastc.domain.User;

import java.sql.SQLException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 16:55 2018/9/18
 * @Modified By:
 */
public class UserService {
    public User login(String username, String password) throws SQLException {

        UserDao dao = new UserDao();
        return dao.login(username, password);

    }
}
