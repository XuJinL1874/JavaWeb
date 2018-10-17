package com.itheima.web.servlet;

import com.google.gson.Gson;
import com.itheima.domain.*;
import com.itheima.service.ProductService;
import com.itheima.utils.CommonsUtils;
import com.itheima.utils.JedisPoolUtils;
import org.apache.commons.beanutils.BeanUtils;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 14:51 2018/10/14
 * @Modified By:
 */
@SuppressWarnings("all")
@WebServlet(name = "ProductServlet")
public class ProductServlet extends BaseServlet {

    /*public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获得请求的哪个方法的method
		String methodName = request.getParameter("method");
		if("productList".equals(methodName)){
			productList(request,response);
		}else if("categoryList".equals(methodName)){
			categoryList(request,response);
		}else if("index".equals(methodName)){
			index(request,response);
		}else if("productInfo".equals(methodName)){
			productInfo(request,response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	 */

    // 确认订单----更新收货人信息+在线支付
    public void confirmOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 更新收货人信息
        Map<String, String[]> properties = request.getParameterMap();
        Order order = new Order();
        try {
            BeanUtils.populate(order,properties);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        ProductService service = new ProductService();
        service.updateOrderAdrr(order);

        // 在线支付

    }


    // 提交订单
    public void submitOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        // 判断用户是否已经登录,未登录代码不执行
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 没登录
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }


        // 封装好一个Order对象,传递到service层
        Order order = new Order();

        //1、private String oid;//该订单的订单号
        String oid = CommonsUtils.getUUID();
        order.setOid(oid);

        //2、private Date ordertime;//下单时间
        order.setOrdertime(new Date());

        //3、private double total;//该订单的总金额
        //获得session中的购物车
        Cart cart = (Cart) session.getAttribute("cart");
        double total = cart.getTotal();
        order.setTotal(total);

        //4、private int state;//订单支付状态 1代表已付款 0代表未付款
        order.setState(0);

        //5、private String address;//收货地址
        order.setAddress(null);

        //6、private String name;//收货人
        order.setName(null);

        //7、private String telephone;//收货人电话
        order.setTelephone(null);

        //8、private User user;//该订单属于哪个用户
        order.setUser(user);

        // 9.该订单中有多少订单项  List<OrderItem> orderItems = new ArrayList<OrderItem>();
        // 获得购物车中的购物项的集合map
        Map<String, CartItem> cartItems = cart.getCartItems();
        for (Map.Entry<String, CartItem> entry : cartItems.entrySet()) {
            // 取出每一个购物项
            CartItem cartItem = entry.getValue();
            // 创建新的订单项
            OrderItem orderItem = new OrderItem();
            // 1)订单项的id private String itemid;
            orderItem.setItemid(CommonsUtils.getUUID());

            // 2)订单项内商品的购买数量 private  int count;
            orderItem.setCount(cartItem.getBuyNum());

            // 3)订单项小计 private  double subtotal;
            orderItem.setSubtotal(cartItem.getSubtotal());

            // 4)订单项内部的商品 private Product product;
            orderItem.setProduct(cartItem.getProduct());

            // 5)该订单输入哪个订单  private Order order;
            orderItem.setOrder(order);

            // 将该订单项添加到订单的订单项集合中
            order.getOrderItems().add(orderItem);

        }

        // order对象封装完毕
        // 传递数据到service层
        ProductService service = new ProductService();
        service.submitOrder(order);

        session.setAttribute("order", order);

        // 页面跳转
        response.sendRedirect(request.getContextPath() + "/order_info.jsp");

    }

    //清空购物车
    public void clearCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("cart");

        //跳转回cart.jsp
        response.sendRedirect(request.getContextPath()+"/cart.jsp");

    }

    //删除单一商品
    public void delProFromCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得要删除的item的pid
        String pid = request.getParameter("pid");
        //删除session中的购物车中的购物项集合中的item
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart!=null){
            Map<String, CartItem> cartItems = cart.getCartItems();
            //需要修改总价
            cart.setTotal(cart.getTotal()-cartItems.get(pid).getSubtotal());
            //删除
            cartItems.remove(pid);
            cart.setCartItems(cartItems);

        }

        session.setAttribute("cart", cart);

        //跳转回cart.jsp
        response.sendRedirect(request.getContextPath()+"/cart.jsp");
    }


    //将商品添加到购物车
    public void addProductToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        ProductService service = new ProductService();


        //获得要放到购物车的商品的pid
        String pid = request.getParameter("pid");
        //获得该商品的购买数量
        int buyNum = Integer.parseInt(request.getParameter("buyNum"));

        //获得product对象
        Product product = service.findProductByPid(pid);
        //计算小计
        double subtotal = product.getShop_price()*buyNum;
        //封装CartItem
        CartItem item = new CartItem();
        item.setProduct(product);
        item.setBuyNum(buyNum);
        item.setSubtotal(subtotal);

        //获得购物车---判断是否在session中已经存在购物车
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart==null){
            cart = new Cart();
        }

        //将购物项放到车中---key是pid
        //先判断购物车中是否已将包含此购物项了 ----- 判断key是否已经存在
        //如果购物车中已经存在该商品----将现在买的数量与原有的数量进行相加操作
        Map<String, CartItem> cartItems = cart.getCartItems();

        double newsubtotal = 0.0;

        if(cartItems.containsKey(pid)){
            //取出原有商品的数量
            CartItem cartItem = cartItems.get(pid);
            int oldBuyNum = cartItem.getBuyNum();
            oldBuyNum+=buyNum;
            cartItem.setBuyNum(oldBuyNum);
            cart.setCartItems(cartItems);
            //修改小计
            //原来该商品的小计
            double oldsubtotal = cartItem.getSubtotal();
            //新买的商品的小计
            newsubtotal = buyNum*product.getShop_price();
            cartItem.setSubtotal(oldsubtotal+newsubtotal);

        }else{
            //如果车中没有该商品
            cart.getCartItems().put(product.getPid(), item);
            newsubtotal = buyNum*product.getShop_price();
        }

        //计算总计
        double total = cart.getTotal()+newsubtotal;
        cart.setTotal(total);


        //将车再次访问session
        session.setAttribute("cart", cart);

        //直接跳转到购物车页面
        response.sendRedirect(request.getContextPath()+"/cart.jsp");
    }

    //显示商品的类别的的功能
    public void categoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    //显示首页的功能
    //显示商品的类别的的功能
    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    //显示商品的详细信息功能
    public void productInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
                    String[] split = pids.split("-");//{3,1,2}
                    List<String> asList = Arrays.asList(split);//[3,1,2]
                    LinkedList<String> list = new LinkedList<String>(asList);//[3,1,2]
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
                        sb.append("-");//3-1-2-
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

    //根据商品的类别获得商品的列表
    public void productList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获得cid
        String cid = request.getParameter("cid");

        String currentPageStr = request.getParameter("currentPage");
        if(currentPageStr==null) currentPageStr="1";
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
                    String pids = cookie.getValue();//3-2-1
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
