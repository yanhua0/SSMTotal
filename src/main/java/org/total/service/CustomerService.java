package org.total.service;

import org.total.entity.Customer;
import org.total.entity.PageInfo;

public interface CustomerService {
    PageInfo<Customer> findAll(int page);
    PageInfo<Customer> findAll1(int page);
}
