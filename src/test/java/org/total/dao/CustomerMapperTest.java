package org.total.dao;

import mybatis.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.total.entity.Customer;
import org.total.entity.Orders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CustomerMapperTest {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrdersMapper ordersMapper;

    @Test
    public void selectInfo() {

        System.out.println(customerMapper.count2());
    }

    @Test
    public void selectOrdersById() {
        System.out.println(customerMapper.selectByPrimaryKey(5));
    }

    @Test
    public void selectInfo1() {
        System.out.println(userMapper.selectByPrimaryKey("1"));
    }

    @Test
    public void print() {
        List<Orders> orders=ordersMapper.findAll();
        Customer c=new Customer();
        c.setOrders(orders);
        List<Customer> customerList=new ArrayList<Customer>();
        customerList.add(c);
        int id[]={1,2,3};
        System.out.println(customerMapper.findTest(c));
    }
    @Test
    public void print1() {
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        map.put(1,5);

        System.out.println(customerMapper.findTest1(map));
    }
}