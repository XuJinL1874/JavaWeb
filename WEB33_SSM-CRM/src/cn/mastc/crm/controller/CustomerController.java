package cn.mastc.crm.controller;

import cn.mastc.common.utils.Page;
import cn.mastc.crm.pojo.BaseDict;
import cn.mastc.crm.pojo.Customer;
import cn.mastc.crm.pojo.QueryVo;
import cn.mastc.crm.service.BaseDictService;
import cn.mastc.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author X_JinL
 * @version 1.0.0
 * @ClassName CustomerController.java
 * @Description
 * @createTime 2018/11/29 18:58
 */
@Controller
public class CustomerController {


        @Autowired
        private BaseDictService baseDictService;
        @Autowired
        private CustomerService customerService;

        //注解在成员变量上
        @Value("${fromType.code}")
        private String fromTypeCode;


        //入口
        @RequestMapping(value = "/customer/list")
        public String list(QueryVo vo,Model model){

            List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(fromTypeCode);
            List<BaseDict> industryType = baseDictService.selectBaseDictListByCode("001");
            List<BaseDict> levelType = baseDictService.selectBaseDictListByCode("006");
            model.addAttribute("fromType", fromType);
            model.addAttribute("industryType", industryType);
            model.addAttribute("levelType", levelType);


            //通过四个条件  查询分页对象
            Page<Customer> page = customerService.selectPageByQueryVo(vo);
            model.addAttribute("page", page);
            model.addAttribute("custName", vo.getCustName());
            model.addAttribute("custSource", vo.getCustSource());
            model.addAttribute("custIndustry", vo.getCustIndustry());
            model.addAttribute("custLevel", vo.getCustLevel());

            return "customer";
        }
        //去修改页面
        @RequestMapping(value = "/customer/edit.action")
        public @ResponseBody
        Customer edit(Integer id){
            return customerService.selectCustomerById(id);
        }
        //修改保存
        @RequestMapping(value = "/customer/update.action")
        public @ResponseBody
        String update(Customer customer){
            //修改
            customerService.updateCustomerById(customer);
            return "OK";
        }
        //删除
        @RequestMapping(value = "/customer/delete.action")
        public @ResponseBody
        String delete(Integer id){
            //删除
            customerService.deleteCustomerById(id);
            return "OK";
        }

}
