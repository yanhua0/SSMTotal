package org.total.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.total.entity.HotSale;
import org.total.service.HotSaleService;

@RestController
public class TestPageFast {
    @Autowired
    private HotSaleService hotSaleService;
    @RequestMapping("/page/hotsale")
    public org.total.entity.PageInfo<HotSale> find(@RequestParam(required = true,defaultValue = "1",value = "page") Integer page,
                                  @RequestParam(required = true,defaultValue = "5",value = "page_size") Integer pageSize){
        return hotSaleService.findByPage(page,pageSize);
    }
    @RequestMapping("/page/hotsale2")
    public PageInfo<HotSale> find2(@RequestParam(required = true,defaultValue = "1",value = "page") Integer page,
                                  @RequestParam(required = true,defaultValue = "5",value = "page_size") Integer pageSize){
        return hotSaleService.findByPage2(page,pageSize);
    }
}
