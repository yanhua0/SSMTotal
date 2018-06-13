package org.total.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.total.dto.Exposer;
import org.total.entity.HotSale;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class TotalServiceTest {
     @Autowired
     private TotalService totalService;
    @Test
    public void queryhotsale() {
        List<HotSale> hotSale=totalService.queryhotsale();
        System.out.println(hotSale);
    }

    @Test
    public void queryById() {
        HotSale hotSale=totalService.queryById(1);
        System.out.println(hotSale);
    }

    @Test
    public void exposerUrl() {
        Exposer exposer=totalService.exposerUrl(1,"2","2");
        System.out.println(exposer);
    }

    @Test
    public void getTitle() {
        String s="https://jingyan.baidu.com/article/219f4bf798e0cfde442d3831.html";
        System.out.println(totalService.getTitle(s));
    }

}