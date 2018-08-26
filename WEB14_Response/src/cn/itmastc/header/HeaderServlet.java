package cn.itmastc.header;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 22:10 2018/8/26
 * @Modified By:
 */
public class HeaderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        /**
         * addHeader,setHeader
         *      addHeader相同不会覆盖
         *      serHeader相同会覆盖
         */
        Date date = new Date();
        // 设置响应头
        response.addHeader("name", "zhangsan");
        response.addHeader("name", "lisi");
        // response.addIntHeader("age", 28);
        // response.addDateHeader("birthday", date.getTime());

        response.setHeader("age", "28");
        response.setHeader("age", "50");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        doGet(request, response);
    }
}
