package org.total.service;


import org.total.entity.HotSale;

import java.util.List;


public interface TotalService {
    List<HotSale> queryhotsale();
    HotSale queryById(int id);
    List<HotSale> queryById2(int id);
}
