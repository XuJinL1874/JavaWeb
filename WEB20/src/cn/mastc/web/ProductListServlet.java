package cn.mastc.web;

import cn.mastc.domain.Product;
import cn.mastc.service.ProductListService;
import cn.mastc.vo.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 18:44 2018/9/10
 * @Modified By:
 */
@WebServlet(name = "ProductListServlet", urlPatterns = {"/productList"})
public class ProductListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductListService service = new ProductListService();
        PageBean pageBean = null;
        try {
            pageBean = service.findPageBean();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("pageBean", pageBean);

        request.getRequestDispatcher("/product_list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
