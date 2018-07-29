package org.total.dao;

import java.util.List;

import org.aspectj.weaver.ast.Or;
import org.total.entity.Customer;
import org.total.entity.Orders;


public interface CustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer id);
    List<Customer> findAll();

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
     Customer selectByUsernameAndPassword(Customer customer);
//     List<Orders> queryOrdersByUserId(int id);
     List<Orders> selectInfo(String u);
}