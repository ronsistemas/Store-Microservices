package com.ordex.store.customer.service;

import com.ordex.store.customer.repository.entity.Customer;
import com.ordex.store.customer.repository.entity.Region;

import java.util.List;

public interface CustomerService {
    public List<Customer> findCustomerAll();

    public Customer getCustomer(Long id);
    public List<Customer> findCustomersByRegion(Region region);
    public Customer createCustomer(Customer customer);

    public Customer updateCustomer(Customer customer);

    public Customer deleteCustomer(Customer customer);
}
