package org.total.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.total.dao.HotSaleDao;
import org.total.entity.HotSale;

import java.util.Date;

@Service
public class TotalThread extends Thread {
    @Autowired
    private HotSaleDao hotSaleDao;
    public void run(){
        System.out.println("打开了线程");
        HotSale hotSale=new HotSale();
        String s= String.valueOf(0);
        hotSale.setBimg(s);
        hotSale.setBuycarimg(s);
        hotSale.setCreateTime(new Date());
        hotSale.setImg(s);
        hotSale.setName(s);
        hotSale.setPrice(0);
        hotSale.setWimg(s);
        System.out.println("执行sql");
//        ApplicationContext ctx=new AnnotationConfigApplicationContext(HotSaleDao.class);
//        HotSaleDao hotSaleDao=ctx.getBean(HotSaleDao.class);
        //System.out.println(hotSaleDao.queryAll());
        hotSaleDao.insert(hotSale);
    }
}
