package org.total.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.total.dao.HotSaleDao;
import org.total.entity.HotSale;

import java.util.Date;
@Component
public class TotalThread extends Thread {
    @Autowired
    private HotSaleDao hotSaleDao;
    public void run(){
        HotSale hotSale=new HotSale();

        String s= String.valueOf(0);
        hotSale.setBimg(s);
        hotSale.setBuycarimg(s);
        hotSale.setCreateTime(new Date());
        hotSale.setImg(s);
        hotSale.setName(s);
        hotSale.setPrice(0);
        hotSale.setWimg(s);
        hotSaleDao.insert(hotSale);
    }
}
