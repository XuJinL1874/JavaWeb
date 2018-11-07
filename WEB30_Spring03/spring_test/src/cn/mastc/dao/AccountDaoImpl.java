package cn.mastc.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 16:02 2018/11/7
 * @Modified By:
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Override
    public void increaseMoney(Integer id, Double money) {

        getJdbcTemplate().update("update account set money = money+? where id = ? ", money,id);

    }

    @Override
    public void decreaseMoney(Integer id, Double money) {

        getJdbcTemplate().update("update account set money = money-? where id = ? ", money,id);
    }
}
