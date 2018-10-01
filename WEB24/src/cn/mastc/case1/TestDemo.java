package cn.mastc.case1;

import org.junit.Test;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 15:44 2018/10/1
 * @Modified By:
 */
public class TestDemo {
    // 程序员开发中测试用的

    @Test
    public void test1() {
        System.out.println("test1 running...");
    }

    @MyTest
    public void test2() {
        System.out.println("test2 running...");
    }

    @MyTest
    public void test3() {
        System.out.println("test3 running...");
    }
}
