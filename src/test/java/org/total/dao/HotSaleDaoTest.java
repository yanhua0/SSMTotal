package org.total.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.total.entity.HotSale;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class HotSaleDaoTest {
    @Autowired
    private HotSaleDao hotSaleDao;
    @Test
    public void queryAll() {
        List<HotSale> hotSale=hotSaleDao.queryAll();
        System.out.println(hotSale);
    }
}