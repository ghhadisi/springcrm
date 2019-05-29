package com.hss.crm.mapper;

import com.hss.crm.pojo.Customer;
import com.hss.crm.pojo.QueryVo;

import java.util.List;

public interface CustomerMapper {
    /**
     * 根据queryVo分页查询数据
     *
     * @param queryVo
     * @return
     */
    List<Customer> queryCustomerByQueryVo(QueryVo queryVo);

    int queryCountByQueryVo(QueryVo queryVo);

    Customer queryCustomerById(Long id);

    void updateCustomerById(Customer customer);
}
