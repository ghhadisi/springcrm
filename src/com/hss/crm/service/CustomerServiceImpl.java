package com.hss.crm.service;

import com.hss.crm.mapper.CustomerMapper;
import com.hss.crm.pojo.Customer;
import com.hss.crm.pojo.QueryVo;
import com.hss.crm.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo) {
        // 设置查询条件,从哪一条数据开始查
        queryVo.setStart((queryVo.getPage()-1)*queryVo.getRows());
        // 查询数据结果集
        List<Customer> list = customerMapper.queryCustomerByQueryVo(queryVo);
        int total = customerMapper.queryCountByQueryVo(queryVo);

        Page<Customer> page = new Page<>(total,queryVo.getPage(),queryVo.getRows(), list);
        return page;
    }

    @Override
    public Customer queryCustomerById(Long id) {
        return customerMapper.queryCustomerById(id);
    }

    @Override
    public void updateCustomerById(Customer customer) {
        customerMapper.updateCustomerById(customer);
    }
}
