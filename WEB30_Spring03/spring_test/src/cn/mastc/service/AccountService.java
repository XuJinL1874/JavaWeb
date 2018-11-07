package cn.mastc.service;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 16:23 2018/11/7
 * @Modified By:
 */
public interface AccountService {

    // 转账方法
    void transfer(Integer from, Integer to, Double money);


}
