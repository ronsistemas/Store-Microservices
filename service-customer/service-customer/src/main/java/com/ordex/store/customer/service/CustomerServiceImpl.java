package com.ordex.store.customer.service;

import com.ordex.store.customer.repository.CustomerRepository;
import com.ordex.store.customer.repository.entity.Customer;
import com.ordex.store.customer.repository.entity.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findCustomerAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer == null) return null;
        return customer;
    }

    @Override
    public List<Customer> findCustomersByRegion(Region region) {
        return customerRepository.findByRegion(region);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Customer customerDb = customerRepository.findByNumberId(customer.getNumberId());
        if(customerDb != null) {
            return customerDb;
        }
        customer.setState(("CREATED"));
        customerDb = customerRepository.save(customer);
        return customerDb;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        //Customer customerDb =getCustomer(customer.getId());
        Customer customerDb = customerRepository.findById(customer.getId()).orElse(null);
        if(customerDb == null) {
            return null;
        }
        customerDb.setFirstName(customer.getFirstName());
        customerDb.setLastName(customer.getLastName());
        customerDb.setEmail(customer.getEmail());
        customerDb.setPhotoUrl(customer.getPhotoUrl());
        return customerRepository.save(customerDb);
    }


    @Override
    public Customer deleteCustomer(Customer customer) {
        Customer customerDb = customerRepository.findById(customer.getId()).orElse(null);

        if(customerDb == null) {
            return null;
        } else {
           customer.setState("DELETED");
           return  customerRepository.save(customer);
        }
    }

}
