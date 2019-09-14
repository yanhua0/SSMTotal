package org.total.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.total.entity.HotSale;

import java.util.HashMap;
import java.util.List;

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
    @Test
    public void map()
    {
        HashMap<String,String> map=new HashMap<String,String>();
        map.put("1","重庆");
        map.put("2","北京");
        map.put(null,null);
//        Object[] obj= (Object[]) map.get(key);
//        System.out.println("key= "+key+" and value= "+map.get(key)+"and object="+ Arrays.toString(obj));
        for(String key :map.keySet())
        {
            System.out.println("key="+key+"value="+ map.get(key));
        }
    }

    @Test
    public void queryByIdOrNumber() {
        HotSale hotSale=hotSaleDao.queryByIdOrNumber("2");
        System.out.println(hotSale);
    }
    @Test
    public void dynamic(){
        HotSale hotSale=new HotSale();
        hotSale.setId(1);
        hotSale.setBimg("/resources/img/c-i.jpg");
        System.out.println(hotSaleDao.dynamic(hotSale).size());
        System.out.println(hotSaleDao.dynamic(hotSale));
    }
}