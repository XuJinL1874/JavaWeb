package cn.mastc.test;

import cn.mastc.bean.User;
import com.sun.org.apache.bcel.internal.util.ClassPath;
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
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {

    // 将名为User的对象注入到u变量中
    @Resource(name = "user")
    private User u;

    @Test
    public void fun1() {
        System.out.println(u);
    }

}
