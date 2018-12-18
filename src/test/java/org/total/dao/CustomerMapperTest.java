package org.total.dao;

import mybatis.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CustomerMapperTest {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private UserMapper userMapper;
    @Test
    public void selectInfo() {
        System.out.println(customerMapper.selectInfo("八戒222"));
    }

    @Test
    public void selectOrdersById() {
        System.out.println(customerMapper.selectByPrimaryKey(5));
    }

    @Test
    public void selectInfo1() {
        System.out.println(userMapper.selectByPrimaryKey("1"));
    }
}