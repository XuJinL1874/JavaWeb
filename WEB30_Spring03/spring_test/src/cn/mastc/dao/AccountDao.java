package cn.mastc.dao;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 15:50 2018/11/7
 * @Modified By:
 */
public interface AccountDao {

    // 加钱
    void increaseMoney(Integer id, Double money);
    // 减钱
    void decreaseMoney(Integer id, Double money);

}
