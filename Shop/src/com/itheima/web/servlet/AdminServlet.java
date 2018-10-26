package com.itheima.web.servlet;

import com.google.gson.Gson;
import com.itheima.domain.Category;
import com.itheima.domain.Order;
import com.itheima.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 16:46 2018/10/25
 * @Modified By:
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/admin"})
public class AdminServlet extends BaseServlet {


    /**
     * 根据订单id查询订单项和商品信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOrderInfoByOid(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 获得oid
        String oid = request.getParameter("oid");

        AdminService service = new AdminService();
        List<Map<String, Object>> mapList = service.findOrderInfoByOid(oid);

        // ajax访问, 回显
        Gson gson = new Gson();
        String json = gson.toJson(mapList);

        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().write(json);
    }

    /**
     *  获得所有的订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findAllOrders(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获得所有订单信息----List<Order>
        AdminService service = new AdminService();
        List<Order> orderList = service.findAllOrders();

        request.setAttribute("orderList", orderList);

        request.getRequestDispatcher("/admin/order/list.jsp").forward(request, response);

    }

    public void findAllCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 提供一个List<Category>转成json字符串
        AdminService service = new AdminService();
        List<Category> categoryList = service.findAllCategory();

        Gson gson = new Gson();
        String json = gson.toJson(categoryList);

        response.setContentType("type/html;charset=UTF-8");

        response.getWriter().write(json );
    }

}
