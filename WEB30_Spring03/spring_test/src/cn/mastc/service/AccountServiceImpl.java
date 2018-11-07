package cn.mastc.service;

import cn.mastc.dao.AccountDao;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 16:25 2018/11/7
 * @Modified By:
 */
public class AccountServiceImpl implements AccountService {

    public void setAd(AccountDao ad) {
        this.ad = ad;
    }

    private AccountDao ad;

    @Override
    public void transfer(Integer from, Integer to, Double money) {

        // 减钱
        ad.decreaseMoney(from, money);
        // 加钱
        ad.increaseMoney(to, money);

    }

}
