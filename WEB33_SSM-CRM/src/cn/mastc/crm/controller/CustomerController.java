package cn.mastc.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author X_JinL
 * @version 1.0.0
 * @ClassName CustomerController.java
 * @Description  客户管理
 * @createTime 2018/11/26 20:02
 */
@Controller
public class CustomerController {

    @RequestMapping(value = "/customer/list")
    public String list() {
        return "customer";
    }

}
