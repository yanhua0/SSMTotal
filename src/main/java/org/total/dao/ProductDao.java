package org.total.dao;


import org.total.entity.Product;

import java.util.List;

public interface ProductDao {
    int delete(int[] id);
    List<Product> queryName();
    int insert(List<Product> product);
    List<Product> query(int[] id);
    List<Product> queryMul(List<Product> product);
    int update(List<Product> product);


}
