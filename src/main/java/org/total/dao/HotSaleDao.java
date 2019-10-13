package org.total.dao;

import org.apache.ibatis.annotations.Param;
import org.total.entity.HotSale;
import org.total.entity.PageInfo;

import java.util.List;

public interface HotSaleDao {
    /**
     * --         select
     * --         *from
     * --        hotsale
     * --        where
     * --         id <![CDATA[ <= ]]> (select id from hotsale order by id desc limit #{start}, 1 )
     * --        order by id desc
     * --        limit #{pageSize}
     * @param pageInfo
     * @return
     */
    List<HotSale> queryAll(PageInfo pageInfo);
    List<HotSale> queryAll2();
    HotSale queryById(int id);
    List<HotSale> queryById2(int id);
    HotSale queryByIdOrNumber(String id);
    int insert(HotSale hotSale);
    List<HotSale> dynamic(@Param("hotSale") HotSale hotSale);
    void insertList(List<HotSale> hotSales);
    Long findAllCount();

}
