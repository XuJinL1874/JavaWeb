package cn.mastc.spring_01.create;

import cn.mastc.spring_01.bean.User;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 17:38 2018/10/30
 * @Modified By:
 */
public class UserFactory {

    public static User createUser() {

        System.out.println("静态工厂创建User");
        return new User();

    }

    public User createUser2() {

        System.out.println("实例工厂创建User");
        return new User();

    }

}
