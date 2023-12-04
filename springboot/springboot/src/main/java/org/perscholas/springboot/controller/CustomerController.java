package org.perscholas.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.CustomerDAO;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.perscholas.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

// create an employee table with the following columns: id, first_name, last_name, department_name
// create an entity and a dao for the employee table
// create a controller for the employee table
// create a form bean for the employee table
// create an html page with the form on it

@Slf4j //logger
@Controller
public class CustomerController {
    @Autowired
    private CustomerDAO customerDao;

    @Autowired
    private CustomerService customerService;





    //formbean method is safer so you can't input harmful code into url
    @GetMapping("/customer/createSubmit")
    public ModelAndView createCustomerSubmit(CreateCustomerFormBean form){
        ModelAndView response = new ModelAndView("customer/create");

        customerService.createCustomer(form);

        log.info("In create customer with incoming args");
        return response;
    }

    @GetMapping("/customer/create")
    public ModelAndView createCustomer() {
        ModelAndView response = new ModelAndView("customer/create");
        log.info("In create customer with no args");
        return response;
    }

    @GetMapping("/customer/search")
    public ModelAndView search(@RequestParam(required = false) String search, @RequestParam(required = false) String search2) { //search is matching input name in search.jsp
        ModelAndView response = new ModelAndView("customer/search");
        log.debug("In the customer search controller method : firstName search= " + search + " lastName search= " +search2);

        if((search != null) || (search2 != null)){
            List<Customer> customers = customerDao.findByFirstNameOrLastName(search, search2);
            response.addObject("customerVar", customers); //key/value pair, this key refers to jstl in search.jsp, this value refers to declared list
            response.addObject("search", search);
            response.addObject("search2" , search2);
            for (Customer customer : customers){
                log.debug("customer: id = " + customer.getId() + " first name = " + customer.getFirstName() + " last name = " + customer.getLastName());
            }

        }
        return response;
    }

    @GetMapping("/customer/edit/{id}")
    public ModelAndView editCustomer(@PathVariable int id){
        ModelAndView response = new ModelAndView("customer/create");

        Customer customer = customerDao.findById(id);

        CreateCustomerFormBean form = new CreateCustomerFormBean();

        if ( customer != null) {
            form.setId(customer.getId());
            form.setFirstName(customer.getFirstName());
            form.setLastName(customer.getLastName());
            form.setPhone(customer.getPhone());
            form.setCity(customer.getCity());
        } else {
            log.warn("Customer with id " + id + " was not found");
        }

        response.addObject("form", form);

        return response;
    }


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
}
