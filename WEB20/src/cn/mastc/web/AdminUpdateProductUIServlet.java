package cn.mastc.web;

import cn.mastc.domain.Category;
import cn.mastc.domain.Product;
import cn.mastc.service.AdminProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 21:40 2018/9/8
 * @Modified By:
 */
@WebServlet(name = "AdminUpdateProductUIServlet", urlPatterns = {"/adminUpdateProductUI"})
public class AdminUpdateProductUIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 获得要查询Product的pid
        String pid = request.getParameter("pid");
        // 传递pid查询商品信息
        AdminProductService service = new AdminProductService();
        Product product = null;
        try {
            product = service.findProductByPid(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 获得所有的商品的类别数据
        List<Category> categoryList = null;
        try {
            categoryList = service.findAllCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("categoryList", categoryList);

        request.setAttribute("product", product);

        request.getRequestDispatcher("/admin/product/edit.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
