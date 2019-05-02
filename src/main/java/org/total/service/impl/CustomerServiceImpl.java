package org.total.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.total.dao.CustomerMapper;
import org.total.entity.Customer;
import org.total.entity.PageInfo;
import org.total.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    public PageInfo<Customer> findAll(int page) {
        int totalCount = customerMapper.count2();//总记录1数
        //实例化时传入第几页、每页显示数量、总记录数
        PageInfo<Customer> pageInfo=new PageInfo<Customer>(page,PageInfo.size,totalCount);
        //分页查询
        List<Customer>  list = customerMapper.findAll(pageInfo);
        pageInfo.setList(list);
        return pageInfo;

    }
}
