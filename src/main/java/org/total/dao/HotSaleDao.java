package org.total.dao;

import org.apache.ibatis.annotations.Param;
import org.total.entity.HotSale;

import java.util.List;

public interface HotSaleDao {
    List<HotSale> queryAll();
    HotSale queryById(int id);
    List<HotSale> queryById2(int id);
    HotSale queryByIdOrNumber(String id);
    int insert(HotSale hotSale);
}
