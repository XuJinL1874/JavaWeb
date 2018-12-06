package cn.mastc.controller;

import cn.mastc.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author X_JinL
 * @version 1.0.0
 * @ClassName UsersController.java
 * @Description
 * @createTime 2018/12/6 18:15
 */
@Controller
public class UsersController {

    @Resource
    private UsersService usersServiceImpl;

    @RequestMapping("show")
    public String show(Model model) {
        model.addAttribute("list", usersServiceImpl.show());
        return "index.jsp";
    }

}
