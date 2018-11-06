package cn.mastc.jdbctemplate;

import cn.mastc.bean.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: X_JinL
 * @Description:  使用JDBC模板实现增删改查
 * @Date: Created in 13:57 2018/11/6
 * @Modified By:
 */
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

    /*private JdbcTemplate jt;

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }*/

    @Override
    public void save(User u) {
        String sql = "insert into user values(null,?)";
        super.getJdbcTemplate().update(sql, u.getName());
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from user where id= ?";
        super.getJdbcTemplate().update(sql, id);
    }

    @Override
    public void update(User u) {
        String sql = "update user set name = ? where id = ?";
        super.getJdbcTemplate().update(sql, u.getName(), u.getId());
    }

    @Override
    public User getById(Integer id) {
        String sql = "select * from user where id = ?";
        return super.getJdbcTemplate().queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User u = new User();
                u.setId(resultSet.getInt("id"));
                u.setName(resultSet.getString("name"));
                return u;
            }
        }, id);
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(*) from user";
        Integer count = super.getJdbcTemplate().queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<User> getAll() {
        String sql = "select * from user";
        List<User> list = super.getJdbcTemplate().query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User u = new User();
                u.setId(resultSet.getInt("id"));
                u.setName(resultSet.getString("name"));
                return u;
            }
        });
        return list;
    }
}
