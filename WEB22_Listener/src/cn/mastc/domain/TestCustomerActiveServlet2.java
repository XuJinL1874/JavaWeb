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
 * @Date: Created in 17:09 2018/9/13
 * @Modified By:
 */
@WebServlet(name = "TestCustomerActiveServlet2", urlPatterns = {"/test3"})
public class TestCustomerActiveServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        //从session域中获得customer
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");

        System.out.println(customer.getName());


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
