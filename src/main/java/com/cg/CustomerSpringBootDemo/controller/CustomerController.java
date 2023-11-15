package com.cg.CustomerSpringBootDemo.controller;


import com.cg.CustomerSpringBootDemo.entity.Customer;
import com.cg.CustomerSpringBootDemo.repo.CustomerRepo;
import com.cg.CustomerSpringBootDemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.cg.CustomerSpringBootDemo.service.CustomerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class CustomerController {

    @Autowired
    private CustomerService customerservice;

    @GetMapping("/")
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
    public String saveCustomer(Customer customer){
        customerservice.saveCustomer(customer);
            return "redirect:/";

    }


    @RequestMapping("/edit/{id}")
    public ModelAndView editCustomer(@PathVariable("id") Integer id){
        ModelAndView mv = new ModelAndView("editCustomer");
        Customer customer = customerservice.getCustomerById(id);
        mv.addObject(customer);
        return mv;

    }


    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Integer id){

        customerservice.deleteCustomer(id);
        return "redirect:/";

    }


}
