package org.total.dao;

import org.total.entity.Nk;

import java.util.List;

public interface NkDao {
    int insert(Nk nk);
    List<Nk> findAll();
    List<Nk> findLimit(int start,int end);
    Nk findById(int id);
    int delete(int id);
    int update(Nk nk);
}
