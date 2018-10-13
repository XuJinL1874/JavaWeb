package com.itheima.web.servlet;

import com.google.gson.Gson;
import com.itheima.domain.*;
import com.itheima.service.ProductService;
import com.itheima.utils.JedisPoolUtils;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 14:52 2018/10/13
 * @Modified By:
 */
@SuppressWarnings("all")
@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends BaseServlet {
    /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 获得请求的那个方法的method
        String methodName = request.getParameter("method");
        if ("productList".equals(methodName)) {
            productList(request, response);
        } else if ("categoryList".equals(methodName)) {
            categoryList(request, response);
        } else if ("index".equals(methodName)) {
            index(request, response);
        } else if ("productInfo".equals(methodName)) {
            productInfo(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }*/


    // 模块中的功能通过方法进行区分的


    /**
     * 将商品添加到购物车
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    public void addProductToCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        ProductService service = new ProductService();

        // 获得放到购物车里的商品的pid
        String pid = request.getParameter("pid");
        // 获得该商品的购买数量
        int buyNum = Integer.parseInt(request.getParameter("buyNum"));

        // 获得product对象
        Product product = service.findProductByPid(pid);
        // 计算小计
        double subtotal = product.getShop_price() * buyNum;
        // 封装CartItem
        CartItem item = new CartItem();
        item.setBuyNum(buyNum);
        item.setProduct(product);
        item.setSubtotal(subtotal);

        // 获得购物车----判断是否在session存在购物车
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }

        // 将购物项放到车中----key是pid
        // 先判断购物车中是否已包含此购物项了   判断key是否已存在
        // 如果购物车中已存在该商品----将现在买的数量与原有的数量进行相加操作
        Map<String, CartItem> cartItems = cart.getCartItems();

        double newsubtotal = 0.0;

        if (cartItems.containsKey(pid)) {
            // 取出原有商品的数量
            CartItem cartItem = cartItems.get(pid);
            int oldBuyNum = cartItem.getBuyNum();
            oldBuyNum += buyNum;
            cartItem.setBuyNum(oldBuyNum);
            cart.setCartItems(cartItems);
            // 修改小计
            // 原先的商品的小计
            double oldsubtotal = cartItem.getSubtotal();
            // 新买的商品的小计
            newsubtotal = buyNum * product.getShop_price();
            cartItem.setSubtotal(oldsubtotal + newsubtotal);
        } else {
            // 如果车中没有该商品
            cart.getCartItems().put(product.getPid(), item);
            newsubtotal = buyNum * product.getShop_price();
        }



        // 计算总计
        double total = cart.getTotal() + newsubtotal;
        cart.setTotal(total);

        // 将车再次放回session
        session.setAttribute("cart", cart);

        // 直接跳转到购物车页面
        response.sendRedirect(request.getContextPath()+"/cart.jsp");

    }

    /**
     * 显示商品类别的功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void categoryList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductService service = new ProductService();

        //先从缓存中查询categoryList 如果有直接使用 没有在从数据库中查询 存到缓存中
        //1、获得jedis对象 连接redis数据库
        Jedis jedis = JedisPoolUtils.getJedis();
        String categoryListJson = jedis.get("categoryListJson");
        //2、判断categoryListJson是否为空
        if(categoryListJson==null){
            System.out.println("缓存没有数据 查询数据库");
            //准备分类数据
            List<Category> categoryList = service.findAllCategory();
            Gson gson = new Gson();
            categoryListJson = gson.toJson(categoryList);
            jedis.set("categoryListJson", categoryListJson);
        }

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(categoryListJson);
    }

    /**
     * 显示首页的功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductService service = new ProductService();

        //准备热门商品---List<Product>
        List<Product> hotProductList = service.findHotProductList();

        //准备最新商品---List<Product>
        List<Product> newProductList = service.findNewProductList();

        //准备分类数据
        //List<Category> categoryList = service.findAllCategory();

        //request.setAttribute("categoryList", categoryList);
        request.setAttribute("hotProductList", hotProductList);
        request.setAttribute("newProductList", newProductList);

        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }

    /**
     * 显示商品的详细信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void productInfo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //获得当前页
        String currentPage = request.getParameter("currentPage");
        //获得商品类别
        String cid = request.getParameter("cid");

        //获得要查询的商品的pid
        String pid = request.getParameter("pid");

        ProductService service = new ProductService();
        Product product = service.findProductByPid(pid);

        request.setAttribute("product", product);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("cid", cid);


        //获得客户端携带cookie---获得名字是pids的cookie
        String pids = pid;
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie cookie : cookies){
                if("pids".equals(cookie.getName())){
                    pids = cookie.getValue();
                    //1-3-2 本次访问商品pid是8----->8-1-3-2
                    //1-3-2 本次访问商品pid是3----->3-1-2
                    //1-3-2 本次访问商品pid是2----->2-1-3
                    //将pids拆成一个数组

                    //{3,1,2}
                    String[] split = pids.split("-");

                    //[3,1,2]
                    List<String> asList = Arrays.asList(split);

                    //[3,1,2]
                    LinkedList<String> list = new LinkedList<String>(asList);
                    //判断集合中是否存在当前pid
                    if(list.contains(pid)){
                        //包含当前查看商品的pid
                        list.remove(pid);
                        list.addFirst(pid);
                    }else{
                        //不包含当前查看商品的pid 直接将该pid放到头上
                        list.addFirst(pid);
                    }
                    //将[3,1,2]转成3-1-2字符串
                    StringBuffer sb = new StringBuffer();
                    for(int i=0;i<list.size()&&i<7;i++){
                        sb.append(list.get(i));
                        //3-1-2-
                        sb.append("-");
                    }
                    //去掉3-1-2-后的-
                    pids = sb.substring(0, sb.length()-1);
                }
            }
        }


        Cookie cookie_pids = new Cookie("pids",pids);
        response.addCookie(cookie_pids);



        request.getRequestDispatcher("/product_info.jsp").forward(request, response);

    }

    /**
     * 根据商品的类别获得商品的列表
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void productList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //获得cid
        String cid = request.getParameter("cid");

        String currentPageStr = request.getParameter("currentPage");
        if(currentPageStr==null) {
            currentPageStr="1";
        }
        int currentPage = Integer.parseInt(currentPageStr);
        int currentCount = 12;

        ProductService service = new ProductService();
        PageBean pageBean = service.findProductListByCid(cid,currentPage,currentCount);

        request.setAttribute("pageBean", pageBean);
        request.setAttribute("cid", cid);

        //定义一个记录历史商品信息的集合
        List<Product> historyProductList = new ArrayList<Product>();

        //获得客户端携带名字叫pids的cookie
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if("pids".equals(cookie.getName())){
                    //3-2-1
                    String pids = cookie.getValue();
                    String[] split = pids.split("-");
                    for(String pid : split){
                        Product pro = service.findProductByPid(pid);
                        historyProductList.add(pro);
                    }
                }
            }
        }

        //将历史记录的集合放到域中
        request.setAttribute("historyProductList", historyProductList);


        request.getRequestDispatcher("/product_list.jsp").forward(request, response);

    }

}
