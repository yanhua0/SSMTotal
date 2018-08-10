package org.total.dao;

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
    }
}