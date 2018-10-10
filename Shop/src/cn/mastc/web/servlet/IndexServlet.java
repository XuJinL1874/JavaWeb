package cn.mastc.web.servlet;

import cn.mastc.domain.Category;
import cn.mastc.domain.Product;
import cn.mastc.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 21:05 2018/10/9
 * @Modified By:
 */
@WebServlet(name = "IndexServlet", urlPatterns = {"/index"})
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductService service = new ProductService();

        // 准备热门商品
        List<Product> hotProductList = service.findHotProductList();

        // 准备最新商品
        List<Product> newProductList = service.newHotProductList();

        // 准备分类数据
        List<Category> categoryList = service.findAllCategory();


        request.setAttribute("categoryList", categoryList);
        request.setAttribute("hotProductList", hotProductList);
        request.setAttribute("newProductList", newProductList);

        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
