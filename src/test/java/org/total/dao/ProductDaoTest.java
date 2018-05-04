package org.total.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.total.entity.Product;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})

public class ProductDaoTest {
   @Autowired
   private ProductDao productDao;
   /*
   批量删除
    */
    @Test
    public void delete() {
        int id[]={1,2,3,4};
        productDao.delete(id);
    }
/*
查询某一字段的列
 */
    @Test
    public void queryName() {
        List<Product> productList=productDao.queryName();
        System.out.println(productList.get(1));//获取productList第2个name
        System.out.println(productList);
    }
/*
批量添加
 */
    @Test
    public void insert() {
        int id[]={1,2,3,4};
       String name[]={"1","2","3","4"};
        int price[]={29,30,31,32};
        List<Product> product=new ArrayList<Product>();
        Product[] product1=new Product[id.length];
        for (int i=0;i<id.length;i++)
        {   product1[i]=new Product();
            product1[i].setId(id[i]);
            product1[i].setName(name[i]);
            product1[i].setPrice(price[i]);
            product.add(product1[i]);
        }
       productDao.insert(product);
    }
 /*
   批量查询
    */
    @Test
    public void query() {
        int id[]={1,2,322,422};
        List<Product> list=productDao.query(id);
        System.out.println(list);
    }
/*
批量修改
 */
    @Test
    public void update() {
        int id[]={1,2,3,4};
        String name[]={"12","22","32","224"};
        int price[]={292,302,312,322};
        List<Product> product=new ArrayList<Product>();
        Product[] product1=new Product[id.length];
        for (int i=0;i<id.length;i++)
        {   product1[i]=new Product();
            product1[i].setId(id[i]);
            product1[i].setName(name[i]);
            product1[i].setPrice(price[i]);
            product.add(product1[i]);
        }
        productDao.update(product);
    }


}