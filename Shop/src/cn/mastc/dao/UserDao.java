package cn.mastc.dao;

import java.sql.SQLException;

import cn.mastc.domain.User;
import cn.mastc.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;


public class UserDao {

    public int regist(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
        int update = runner.update(sql, user.getUid(),user.getUsername(),user.getPassword(),
                user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),
                user.getSex(),user.getState(),user.getCode());
        return update;
    }

    //激活
    public void active(String activeCode) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update user set state=? where code=?";
        runner.update(sql, 1,activeCode);
    }


}
