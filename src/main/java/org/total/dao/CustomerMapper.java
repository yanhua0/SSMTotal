package org.total.dao;

import org.apache.ibatis.annotations.Param;
import org.total.entity.Customer;
import org.total.entity.Orders;
import org.total.entity.PageInfo;

import java.util.List;


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

     List<Customer> findAll(PageInfo pageInfo);
    List<Customer> findAll2(@Param("start")int start,@Param("end")int end);
      int count2();
}