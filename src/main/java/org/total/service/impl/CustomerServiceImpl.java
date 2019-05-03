package org.total.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.total.dao.CustomerMapper;
import org.total.entity.Customer;
import org.total.entity.PageInfo;
import org.total.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 使用数据库查询语句计算总记录数
     * @param page
     * @return
     */
    public PageInfo<Customer> findAll(int page) {
        int totalCount = customerMapper.count2();//总记录数，count2方法使用的sql语句:select count(*) from customer
        //实例化时传入第几页、每页显示数量、总记录数
        PageInfo<Customer> pageInfo = new PageInfo<Customer>(page, PageInfo.size, totalCount);
        //分页查询,findAll使用的sql语句 select *from customer limit #{start},#{end}
        List<Customer> list = customerMapper.findAll(pageInfo);
        pageInfo.setList(list);
        return pageInfo;
    }

    /**
     * 分页查询计算总记录数，少写sql语句
     * @param page
     * @return
     */
    public PageInfo<Customer> findAll1(int page) {
        int pageSize = PageInfo.size;
        int sta = 0;
        int totalP = 0;
        int totalC = 0;
        while (true) {
            List<Customer> customerList = customerMapper.findAll2(sta, pageSize);
            if (customerList.size() != pageSize && customerList.size() != 0) {
                totalP = sta / 5 + 1;
                totalC = customerList.size() + pageSize * (totalP - 1);
                break;
            } else if (customerList.size() != pageSize) {
                totalP = sta / 5;
                totalC = pageSize * totalP;
                break;
            }
            sta += 5;
        }
        PageInfo<Customer> pageInfo = new PageInfo<Customer>(page, pageSize, totalC,totalP);
        List<Customer> c2= customerMapper.findAll2((page-1)*pageSize, pageSize);
        pageInfo.setList(c2);
        return pageInfo;
    }
}
