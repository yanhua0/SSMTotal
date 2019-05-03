package org.total.service.impl;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.total.entity.Customer;
import org.total.entity.PageInfo;
import org.total.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class TestDbToExcelTest {
    @Autowired
    private TestDbToExcel testDbToExcel;
    @Autowired
    private CustomerService customerService;
    @Test
    public void main() {
        PageInfo<Customer> pageInfo=customerService.findAll(1);
        System.out.println(pageInfo.getTotalPage());
        System.out.println(pageInfo.getTotalCount());
        System.out.println(customerService.findAll1(1).getTotalCount());
        System.out.println(customerService.findAll1(1).getTotalPage());

    }
}