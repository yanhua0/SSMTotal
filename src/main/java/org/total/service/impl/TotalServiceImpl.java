package org.total.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.total.dao.HotSaleDao;
import org.total.dao.cache.RedisDao;
import org.total.dto.Exposer;
import org.total.entity.HotSale;
import org.total.exception.TotalException;
import org.total.service.TotalService;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TotalServiceImpl implements TotalService{
    @Autowired
    private HotSaleDao hotSaleDao;
    @Autowired
    private RedisDao redisDao;
     private Logger logger= LoggerFactory.getLogger(this.getClass());
    private final String slat="askjfnasj*()kfa@34893749817$dasopisfkCASOKV$%^@!";
    public List<HotSale> queryhotsale() {
        try {
            logger.info("查询成功！");
            return hotSaleDao.queryAll();
        }catch (Exception e)
        {   logger.warn("系统错误！");
            throw new TotalException("系统错误!");
        }

    }

    public HotSale queryById(int id) {
       try {
           HotSale hotSale=redisDao.getHotSale(id);
           if(hotSale==null)
           {
               hotSale=hotSaleDao.queryById(id);
               if(hotSale==null)
               {
                   return null;
               }
               else {
                   String result=redisDao.putHotSale(hotSale);
                   logger.warn(result);
                   return hotSale;
               }
           }
           return hotSale;
       }catch (Exception e)
       {
           throw new TotalException("查询失败！");
       }
 }

    public List<HotSale> queryById2(int id) {
        if(id==0)
        {
            return hotSaleDao.queryAll();
        }
        return hotSaleDao.queryById2(id);
    }

    public Exposer exposerUrl(int id,String md5,String name) {
        md5=getMD5(id);
        return new Exposer(md5,id,name);
    }
    public PageInfo<HotSale> findpage(Integer page) {
        PageHelper.startPage(page, 5);
        List<HotSale> list=queryhotsale();
        return new PageInfo<HotSale>(list);
    }
    private String getMD5(long id)
    {
        String base=id+"/"+slat;
        String md5=DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
    public String getTitle(final String s)
    {
        String regex;
        String title = "";
        final List<String> list = new ArrayList<String>();
        regex = "<title>.*?</title>";
        final Pattern pa = Pattern.compile(regex, Pattern.CANON_EQ);
        final Matcher ma = pa.matcher(s);
        while (ma.find())
        {
            list.add(ma.group());
        }
        for (int i = 0; i < list.size(); i++)
        {
            title = title + list.get(i);
        }
        title.replaceAll("<.*?>", "");
        return title;
    }
}
