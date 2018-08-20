package cn.itmastc.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 14:55 2018/8/20
 * @Modified By:
 */
public class TestJunit {
    public static void main(String[] args) {
        System.out.println("HelloWord");
    }
    @Test
    public void testJunit(){
        System.out.println("HelloJunit");
    }
    @Before
    public void testBefore(){
        System.out.println("before!");
    }
    @After
    public void testAfter(){
        System.out.println("after!");
    }
}
