package cn.mastc.service;

import cn.mastc.dao.UserDao;
import cn.mastc.domain.User;

import java.sql.SQLException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 16:21 2018/10/8
 * @Modified By:
 */
public class UserService {
    public boolean regist(User user) {

        UserDao dao = new UserDao();
        int row = 0;
        try {
            row = dao.regist(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row > 0 ? true : false;
    }

    //激活
    public void active(String activeCode) {
        UserDao dao = new UserDao();
        try {
            dao.active(activeCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
