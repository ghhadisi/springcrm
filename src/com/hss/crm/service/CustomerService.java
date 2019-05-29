package com.hss.crm.service;

import com.hss.crm.pojo.Customer;
import com.hss.crm.pojo.QueryVo;
import com.hss.crm.util.Page;

public interface CustomerService {
    Page<Customer> queryCustomerByQueryVo(QueryVo queryVo);

    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    Customer queryCustomerById(Long id);


    void updateCustomerById(Customer customer);
}
