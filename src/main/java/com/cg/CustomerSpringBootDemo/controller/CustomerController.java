package com.cg.CustomerSpringBootDemo.controller;


import com.cg.CustomerSpringBootDemo.entity.Customer;
import com.cg.CustomerSpringBootDemo.repo.CustomerRepo;
import com.cg.CustomerSpringBootDemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.cg.CustomerSpringBootDemo.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class CustomerController {

    @Autowired
    private CustomerService customerservice;

    @GetMapping("/index")
    public String getCustomers(Model model){
         List<Customer> customers = customerservice.listall();
         model.addAttribute("customers",customers);
//         System.out.println(customers.toString());


         return "index";
    }


    @GetMapping("/addCustomer")
    public String addCustomer(Model model){
        model.addAttribute("customer",new Customer());
        return "addCustomer";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(Customer customer, RedirectAttributes redirectAttributes){
        if(customerservice.saveCustomer(customer)){
            return "redirect:index";
        }
        return "addCustomer";
    }




}
