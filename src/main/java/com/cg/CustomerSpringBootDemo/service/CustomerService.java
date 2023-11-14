package com.cg.CustomerSpringBootDemo.service;

import com.cg.CustomerSpringBootDemo.entity.Customer;
import com.cg.CustomerSpringBootDemo.repo.CustomerRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerRepo repo;

    public List<Customer> listall(){

        return new ArrayList<Customer>(repo.findAll());
    }

    public Customer getCustomerById(Integer id){
        return repo.findById(id).get();

    }

    public boolean saveCustomer(Customer customer){
        Customer savedCustomer = repo.save(customer);
        return repo.findById(savedCustomer.getId()).isPresent();
    }

    public boolean deleteCustomer(Integer id){
        repo.deleteById(id);
        return repo.findById(id).isPresent();



    }

}
