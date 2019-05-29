package com.hss.crm.controller;

import com.hss.crm.pojo.BaseDict;
import com.hss.crm.pojo.Customer;
import com.hss.crm.pojo.QueryVo;
import com.hss.crm.service.BaseDictService;
import com.hss.crm.service.CustomerService;
import com.hss.crm.util.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("customer")

public class CustomerController {

    @Value("${fromType.code}")
    private String fromTypeCode;
    @Value("${industryType.code}")
    private String industryTypeCode;
    @Value("${levelType.code}")
    private String levelTypeCode;

    @Autowired
    BaseDictService baseDictService;

    @Autowired
    CustomerService customerService;
    @RequestMapping("list")
    public String queryCustomerList(QueryVo queryVo, Model model) {
// 客户来源
        List<BaseDict> fromType = this.baseDictService.queryBaseDictByDictTypeCode(fromTypeCode);
        List<BaseDict> industryType  = this.baseDictService.queryBaseDictByDictTypeCode(industryTypeCode);
        List<BaseDict> levelType  = this.baseDictService.queryBaseDictByDictTypeCode(levelTypeCode);

// 把前端页面需要显示的数据放到模型中
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);



        try {
            // 解决get请求乱码问题
            if (StringUtils.isNotBlank(queryVo.getCustName())) {
                queryVo.setCustName(new String(queryVo.getCustName().getBytes("ISO-8859-1"), "UTF-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 分页查询数据
        Page<Customer> page = this.customerService.queryCustomerByQueryVo(queryVo);
        // 把分页查询的结果放到模型中
        model.addAttribute("page", page);
// 数据回显
        model.addAttribute("custName", queryVo.getCustName());
        model.addAttribute("custSource", queryVo.getCustSource());
        model.addAttribute("custIndustry", queryVo.getCustIndustry());
        model.addAttribute("custLevel", queryVo.getCustLevel());
        return "customer";
    }

    @RequestMapping("edit")
    @ResponseBody
    public Customer  editCustomer(Long id){
        Customer customer = customerService.queryCustomerById(id);
        return customer;
    }


    @RequestMapping("update")
    @ResponseBody
    public String  updateCustomer(Customer customer){
        customerService.updateCustomerById(customer);
        return "ok";
    }
}
