package org.total.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.total.entity.HotSale;
import org.total.service.TotalThread;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class HotSaleDaoTest{

    @Autowired
    private HotSaleDao hotSaleDao;
    @Resource
    private TotalThread totalThread;

    private ExecutorService executorService= Executors.newFixedThreadPool(5);
    @Test
    public void queryAll() {
        List<HotSale> hotSale=hotSaleDao.queryAll2();
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
    @Test
    public void insert() throws IOException {
       // HotSale hotSale=new HotSale();
        for(int i=0;i<5;i++){
//           String s= String.valueOf(i);
//            hotSale.setBimg(s);
//            hotSale.setBuycarimg(s);
//            hotSale.setCreateTime(new Date());
//            hotSale.setImg(s);
//            hotSale.setName(s);
//            hotSale.setPrice(i);
//            hotSale.setWimg(s);
          executorService.execute(() -> {
              System.out.println(Thread.currentThread()+"开始执行");
              try {
                  save();
              } catch (IOException e) {
                  e.printStackTrace();
              }
             System.out.println(Thread.currentThread().getName()+"插入数据完毕");
          });
      }
        System.in.read();
    }
    @Test
    public void save() throws IOException {
        HotSale hotSale = new HotSale();
        List<HotSale> hotSales=new ArrayList<>();
        for(int i=0;i<10000000;i++) {
            String s = String.valueOf(i);
            hotSale.setBimg(s);
            hotSale.setBuycarimg(s);
            hotSale.setCreateTime(new Date());
            hotSale.setImg(s);
            hotSale.setName(s);
            hotSale.setPrice(i);
            hotSale.setWimg(s);
            hotSale.setUsername(s);
            hotSales.add(hotSale);
           // hotSaleDao.insert(hotSale);
            if(hotSales.size()==1000){
                hotSaleDao.insertList(hotSales);
                System.out.println(Thread.currentThread().getName()+"插入数据成功");
                hotSales=new ArrayList<>();
            }


        }
        //hotSaleDao.insertList(hotSales);
       // totalThread.start();//线程还没有开始启动，而主线程已经关闭了
        //System.in.read();

    }
}