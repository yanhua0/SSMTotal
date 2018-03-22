package org.total.service;


import com.github.pagehelper.PageInfo;
import org.total.dto.Exposer;
import org.total.entity.HotSale;

import java.util.List;


public interface TotalService {
    List<HotSale> queryhotsale();
    HotSale queryById(int id);
    List<HotSale> queryById2(int id);
    Exposer exposerUrl(int id,String md5,String name);
    PageInfo<HotSale> findpage(Integer page);
}
