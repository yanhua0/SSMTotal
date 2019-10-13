package org.total.dao;

import mybatis.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class OrdersMapperTest {
    @Autowired
    private  OrdersMapper ordersMapper;
    @Autowired
    private UserMapper userMapper;


    @Test
    public void selectCustomerById() throws ParseException {
        String s="2018-09-01";
        SimpleDateFormat ds=new SimpleDateFormat("yyyy-MM-dd");


        System.out.println(userMapper.between(ds.parse(s),new Date()).get(0).getCreateTime());
    }


}