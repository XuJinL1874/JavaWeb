package cn.mastc.springmvc.controller;

import cn.mastc.springmvc.pojo.Items;
import cn.mastc.springmvc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author X_JinL
 * @version 1.0.0
 * @ClassName ItemController.java
 * @Description  商品管理
 * @createTime 2018/11/20 21:45
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;
    //入门程序 第一   包类 + 类包 + 方法名
    @RequestMapping(value = "/item/itemlist.action")
    public ModelAndView itemList(){
        //从Mysql中查询
        List<Items> list = itemService.selectItemsList();

        ModelAndView mav = new ModelAndView();
        //数据
        mav.addObject("itemList", list);
        mav.setViewName("itemList");
        return mav;
    }

}
