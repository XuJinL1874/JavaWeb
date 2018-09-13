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
 * @Date: Created in 17:00 2018/9/13
 * @Modified By:
 */
@WebServlet(name = "TestCustomerActiveServlet", urlPatterns = {"/test2"})
public class TestCustomerActiveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        // 将customer放到session中
        Customer customer = new Customer();
        customer.setId("100");
        customer.setName("lucy");
        session.setAttribute("customer", customer);
        System.out.println("customer被放到session域中");



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
