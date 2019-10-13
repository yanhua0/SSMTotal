package org.total.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.total.dao.HotSaleDao;
import org.total.entity.HotSale;
import org.total.service.TotalThread;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class TaskController {
    @Autowired
    private HotSaleDao hotSaleDao;
    @Autowired
    private TotalThread totalThread;
    private ExecutorService executorService= Executors.newFixedThreadPool(4);
    @RequestMapping("/save1")
    public void insert(){
        totalThread.start();
    }
    public void save(){
        HotSale hotSale=new HotSale();
        for(int i=0;i<10000;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String s= String.valueOf(i);
            hotSale.setBimg(s);
            hotSale.setBuycarimg(s);
            hotSale.setCreateTime(new Date());
            hotSale.setImg(s);
            hotSale.setName(s);
            hotSale.setPrice(i);
            hotSale.setWimg(s);
            hotSaleDao.insert(hotSale);
        }
    }
}
