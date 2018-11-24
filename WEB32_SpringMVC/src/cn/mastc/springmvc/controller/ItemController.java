package cn.mastc.springmvc.controller;

import cn.mastc.springmvc.pojo.Items;
import cn.mastc.springmvc.pojo.QueryVo;
import cn.mastc.springmvc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author X_JinL
 * @version 1.0.0
 * @ClassName ItemController.java
 * @Description 商品管理
 * @createTime 2018/11/20 21:45
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    //入门程序 第一   包类 + 类包 + 方法名
    @RequestMapping(value = "/item/itemlist.action")
    public ModelAndView itemList() {
        //从Mysql中查询
        List<Items> list = itemService.selectItemsList();

        ModelAndView mav = new ModelAndView();
        //数据
        mav.addObject("itemList", list);
        mav.setViewName("itemList");
        return mav;
    }

    // 去修改页面入参id
    @RequestMapping(value = "/itemEdit.action")
    public ModelAndView toEdit(Integer id, HttpServletRequest request, HttpServletResponse response,
                               HttpSession session, Model model) {
        // Servlet时代开发
        // String id = request.getParameter("id");

        // 查询一个商品
        // Items items = itemService.selectItemsById(Integer.parseInt(id));
        Items items = itemService.selectItemsById(id);
        ModelAndView mav = new ModelAndView();
        // 数据
        mav.addObject("item", items);
        mav.setViewName("editItem");
        return mav;

    }

    // 提交修改页面 入参 为Items对象
    @RequestMapping(value = "/updateItem.action")
    public ModelAndView updateItem(Items items) {

        // 修改
        itemService.updayeItemsById(items);

        ModelAndView mav = new ModelAndView();
        // 数据
        mav.setViewName("success");
        return mav;
    }

    // 删除多个
    @RequestMapping(value = "/deletes.action")
    public ModelAndView deletes(QueryVo vo) {

        ModelAndView mav = new ModelAndView();
        // 数据
        mav.setViewName("success");
        return mav;
    }

}
