package org.total.dao.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.total.dao.HotSaleDao;
import org.total.entity.HotSale;

import static org.junit.Assert.*;
//Spring与junit整合
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit Spring配置文件的位置
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class RedisDaoTest {
    @Autowired
    private RedisDao redisDao;
    @Autowired
    private HotSaleDao hotSaleDao;
    @Test
    public void testHotSale() {
        int id=4;
          HotSale hotSale=redisDao.getHotSale(id);
          if(hotSale==null)
          {
              hotSale=hotSaleDao.queryById(id);
              System.out.println(hotSale);
              if(hotSale!=null)
              {
                   String result=redisDao.putHotSale(hotSale);
                   System.out.println(result);
                   hotSale=redisDao.getHotSale(id);
                   System.out.println(hotSale);
              }
         }
         System.out.println(id+"号商品存于Redis中");

    }

}