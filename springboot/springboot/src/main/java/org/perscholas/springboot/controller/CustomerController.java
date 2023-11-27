package org.perscholas.springboot.controller;

import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

//    @GetMapping("/customer/create") //this customer create shows up in URL
//    public ModelAndView createCustomer(@RequestParam(required = false) String firstName,
//                                       @RequestParam(required = false) String lastName,
//                                       @RequestParam(required = false) String phone,
//                                       @RequestParam(required = false) String city){
//        ModelAndView response = new ModelAndView("customer/create"); //this customer create is where jsp file is
//
//        System.out.println("firstName: " + firstName);
//        System.out.println("lastName: " + lastName);
//        System.out.println("phone: " + phone);
//        System.out.println("city: " + city);
//
//        return response;
//    }


    //formbean method is safer so you can't input harmful code into url
    @GetMapping("/customer/create")
    public ModelAndView createCustomer(CreateCustomerFormBean form){
        ModelAndView response = new ModelAndView("customer/create");

        System.out.println("firstName: " + form.getFirstName());
        System.out.println("lastName: " + form.getLastName());
        System.out.println("phone: " + form.getPhone());
        System.out.println("city: " + form.getCity());

        return response;
    }
}
