package org.total.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.total.dao.HotSaleDao;
import org.total.entity.HotSale;
import org.total.service.HotSaleService;

import java.util.List;

@Service
public class HotSaleServiceImpl implements HotSaleService {
    @Autowired
    private HotSaleDao hotSaleDao;
    @Override
    public org.total.entity.PageInfo<HotSale> findByPage(Integer page, Integer pageSize) {
        Long count =hotSaleDao.findAllCount();
        //实例化时传入第几页、每页显示数量、总记录数
        org.total.entity.PageInfo<HotSale> pageInfo = new org.total.entity.PageInfo<HotSale>(page, pageSize, count.intValue());
        System.out.println(pageInfo);
        List<HotSale> list=hotSaleDao.queryAll(pageInfo);
        pageInfo.setList(list);
        return pageInfo;
    }


    @Override
    public PageInfo<HotSale> findByPage2(Integer page, Integer pageSize) {
        Page p=PageHelper.startPage(page,pageSize);
        System.out.println(p);
        List<HotSale> list=hotSaleDao.queryAll2();
        //return new PageInfo<HotSale>(list);
        return new PageInfo<>(list);
    }
}
