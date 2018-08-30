package cn.itmastc.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 21:40 2018/8/30
 * @Modified By:
 */
@WebServlet(name = "SessionServlet", urlPatterns = {"/session"})
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * request.getSession()方法内部会判断,该客户端是否在服务器端已经存在session
         * 如果该客户端在此服务器不存在session,那么就会创建一个新的session对象
         * 如果该客户端在此服务器已经存在session,获得已经存在的该session返回
         */

        // 创建属于该客户端(会话)的私有的session区域
        HttpSession session = request.getSession();

        session.setAttribute("name", "Jerry");

        // 该session对象的编号id
        String id = session.getId();

        // 手动创建一个存储JSESSIONID的cookie 为该cookie设置持久化时间
        Cookie cookie = new Cookie("JSESSIONID", id);
        cookie.setPath("/WEB16_Cookie/");
        cookie.setMaxAge(60 * 10);
        response.addCookie(cookie);

        response.getWriter().write("JSESSIONID:" + id);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
