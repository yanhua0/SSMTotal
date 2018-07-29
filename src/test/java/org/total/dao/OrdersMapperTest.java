package org.total.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class OrdersMapperTest {
    @Autowired
    private  OrdersMapper ordersMapper;

    @Test
    public void selectCustomerById() {
        System.out.println(ordersMapper.selectByPrimaryKey(1).getCustomer());
    }


}