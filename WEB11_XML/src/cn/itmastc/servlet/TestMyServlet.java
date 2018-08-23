package cn.itmastc.servlet;

import org.junit.Test;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 22:52 2018/8/23
 * @Modified By:
 */
public class TestMyServlet {

    @Test
    public void testMyServlet() {
        MyServletImpl my = new MyServletImpl();
        my.init();
        my.servlet();
        my.destory();
    }
}
