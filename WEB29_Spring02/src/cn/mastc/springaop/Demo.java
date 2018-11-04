package cn.mastc.springaop;

import cn.mastc.bean.User;
import cn.mastc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 14:38 2018/11/4
 * @Modified By:
 */
// 帮我们创建容器
@RunWith(SpringJUnit4ClassRunner.class)
// 指定创建容器时使用哪个配置文件
@ContextConfiguration("classpath:cn/mastc/springaop/applicationContext.xml")
public class Demo {

    // 将名为User的对象注入到u变量中
    @Resource(name = "userService")
    private UserService us;

    @Test
    public void fun1() {
        us.save();
    }

}
