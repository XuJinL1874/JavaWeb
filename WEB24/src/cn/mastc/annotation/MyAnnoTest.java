package cn.mastc.annotation;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 14:40 2018/10/1
 * @Modified By:
 */
public class MyAnnoTest {

    @MyAnno(name = "zhangsan")
    // @MyAnno({"xxx","yyy"})
    public void show(String str) {
        System.out.println("show running...");
    }

}
