package com.cg.CustomerSpringBootDemo.repo;

import com.cg.CustomerSpringBootDemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CustomerRepo extends JpaRepository<Customer,Integer> {

}
