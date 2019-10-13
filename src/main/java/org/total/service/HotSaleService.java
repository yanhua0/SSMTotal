package org.total.service;

import com.github.pagehelper.PageInfo;
import org.total.entity.HotSale;


public interface HotSaleService {
    org.total.entity.PageInfo<HotSale> findByPage(Integer page, Integer pageSize);

    PageInfo<HotSale> findByPage2(Integer page, Integer pageSize);
}
