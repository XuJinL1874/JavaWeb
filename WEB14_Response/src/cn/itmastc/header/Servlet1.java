package cn.itmastc.header;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 22:31 2018/8/26
 * @Modified By:
 */
@WebServlet(name = "Servlet1", urlPatterns = "/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        /**
         * 没有响应 告知客户端去重定向到servlet2
         *      1.设置状态码302
         *          response.setStatus(302);
         *      2.设置响应头Location
         *          response.setHeader("Location", "/WEB14_Response/servlet2");
         */

        // 封装成一个重定向的方法sendRedirect(url)
        response.sendRedirect("/WEB14_Response/servlet2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        doGet(request, response);
    }
}
