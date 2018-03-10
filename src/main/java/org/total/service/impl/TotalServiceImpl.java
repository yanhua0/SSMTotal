package org.total.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.total.dao.HotSaleDao;
import org.total.dao.cache.RedisDao;
import org.total.entity.HotSale;
import org.total.exception.TotalException;
import org.total.service.TotalService;

import java.util.List;

@Service
public class TotalServiceImpl implements TotalService{
    @Autowired
    private HotSaleDao hotSaleDao;
    @Autowired
    private RedisDao redisDao;
     private Logger logger= LoggerFactory.getLogger(this.getClass());
    public List<HotSale> queryhotsale() {
        try {
            return hotSaleDao.queryAll();
        }catch (Exception e)
        {   logger.warn("系统错误！");
            throw new TotalException("系统错误!");
        }

    }

    public HotSale queryById(int id) {
       try {
           HotSale hotSale=redisDao.getHotSale(id);
           if(hotSale==null)
           {
               hotSale=hotSaleDao.queryById(id);
               if(hotSale==null)
               {
                   return null;
               }
               else {
                   String result=redisDao.putHotSale(hotSale);
                   logger.warn(result);
                   return hotSale;
               }
           }
           return hotSale;
       }catch (Exception e)
       {
           throw new TotalException("查询失败！");
       }
 }

    public List<HotSale> queryById2(int id) {
        if(id==0)
        {
            return hotSaleDao.queryAll();
        }
        return hotSaleDao.queryById2(id);
    }
}
