package cn.mastc.controller;

import cn.mastc.service.PicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author X_JinL
 * @version 1.0.0
 * @ClassName PicController.java
 * @Description
 * @createTime 2018/12/8 14:51
 */
@Controller
public class PicController {

    @Resource
    private PicService picServiceImpl;

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("list", picServiceImpl.show());
        return "/index.jsp";
    }

}
