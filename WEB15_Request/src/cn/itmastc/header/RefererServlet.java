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
 * @Date: Created in 13:24 2018/8/28
 * @Modified By:
 */
@WebServlet(name = "RefererServlet", urlPatterns = {"/referer"})
public class RefererServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 对该新闻的来源进行判断
        String header = request.getHeader("referer");
        String http = "http://localhost";
        if (header != null && header.startsWith(http)) {
            // 是从我自己的网站跳转过来的 可以看新闻
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("中国确实已经拿到100块金牌...");
        } else {
            response.getWriter().write("你是盗链者,可耻!!!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
