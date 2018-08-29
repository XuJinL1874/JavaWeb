package cn.itmastc.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 20:57 2018/8/29
 * @Modified By:
 */
@WebServlet(name = "SendCookieServlet", urlPatterns = {"/sendCookie"})
public class SendCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1.创建Cookie对象
        Cookie cookie = new Cookie("name", "zhangsan");

        // 1.1为Cookie设置持久化时间----cookie信息在硬盘上保存的时间
        // 时间设置为0代表删除该cookie
        cookie.setMaxAge(60 * 10);
        // 1.2为Cookie设置携带路径
        // ----访问sendCookie这个资源时才携带这个cookie
        cookie.setPath("WEB16_Cookie/sendCookie");
        // cookie.setPath("/WEB16_Cookie");//访问WEB16下的任何资源时都携带这个cookie
        //cookie.setPath("/");//访问服务器下的所有的资源都携带这个cookie

        // 2.将Cookie中存储的信息发送到客户端---头
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
