package cn.itmastc.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 22:07 2018/8/30
 * @Modified By:
 */
@WebServlet(name = "SessionServlet2", urlPatterns = {"/session2"})
public class SessionServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 从session中获得存储数据
        HttpSession session = request.getSession();

        String attribute = (String) session.getAttribute("name");
        response.getWriter().write(attribute);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
