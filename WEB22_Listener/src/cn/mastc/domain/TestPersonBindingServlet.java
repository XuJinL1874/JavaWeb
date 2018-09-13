package cn.mastc.domain;

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
 * @Date: Created in 16:32 2018/9/13
 * @Modified By:
 */
@WebServlet(name = "TestPersonBindingServlet", urlPatterns = {"/testBinding"})
public class TestPersonBindingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        // 将person对象绑定到session中
        Person p = new Person();
        p.setId("100");
        p.setName("zhangsanfeng");

        session.setAttribute("person", p);

        // 将person对象从session中解绑
        session.removeAttribute("person");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
