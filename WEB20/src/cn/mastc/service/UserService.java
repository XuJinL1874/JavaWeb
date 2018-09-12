package cn.mastc.service;

import cn.mastc.dao.UserDao;

import java.sql.SQLException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 15:01 2018/9/12
 * @Modified By:
 */
public class UserService {
    public boolean checkUsername(String username) throws SQLException {
        UserDao dao = new UserDao();
        Long isExist = dao.checkUsername(username);
        return isExist > 0 ? true : false;
    }
}
