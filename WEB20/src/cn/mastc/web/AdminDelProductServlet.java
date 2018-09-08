package cn.mastc.web;

import cn.mastc.service.AdminProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 20:52 2018/9/8
 * @Modified By:
 */
@WebServlet(name = "AdminDelProductServlet", urlPatterns = {"/adminDelProduct"})
public class AdminDelProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取删除的pid
        String pid = request.getParameter("pid");

        // 传递pid到service层
        AdminProductService service = new AdminProductService();
        try {
            service.delProductByPid(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath()+"/adminProductList");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
