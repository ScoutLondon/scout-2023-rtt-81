package org.perscholas.springboot.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.perscholas.springboot.database.dao.CustomerDAO;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.database.entity.User;
import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.perscholas.springboot.security.AuthenticatedUserService;
import org.perscholas.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
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

    @Autowired
    private AuthenticatedUserService authenticatedUserService;





    //formbean method is safer so you can't input harmful code into url
    @GetMapping("/customer/createSubmit")
    public ModelAndView createCustomerSubmit(@Valid CreateCustomerFormBean form, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            log.info("######################### In create customer submit - has errors #########################");
            ModelAndView response = new ModelAndView("customer/create");

            for ( ObjectError error : bindingResult.getAllErrors() ) {
                log.info("error: " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("errors", bindingResult);
            return response;
        }

        log.info("############ In create customer submit - no error found #############");

        Customer c = customerService.createCustomer(form);

        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/customer/edit/" + c.getId() + "?success=Customer Saved Successfully");

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
    //use this for edit/id/x vs edit?id=x
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
            form.setImageUrl(form.getImageUrl());
        } else {
            log.warn("Customer with id " + id + " was not found");
        }

        response.addObject("form", form);

        return response;
    }

    @GetMapping("/customer/MyCustomers")
    public void myCustomers(){
        log.info("################# In my customers #############");

        //1) Use the authenticated user service to find the logged in user
        User user = authenticatedUserService.loadCurrentUser();

        // 2) Create a DAO method that will find by userId

        // 3) use the authenticated user id to find a list of all customers created by this user
        List<Customer> customers = customerDao.findByUserId(user.getId());

        // 4) loop over the customers created and log.debug the customer id and customer last name
        for(Customer customer : customers){
            log.debug("First Name = " + customer.getFirstName() + " Last name = " + customer.getLastName() + " Id = " +customer.getId());
        }
    }

    @GetMapping("/customer/detail")
    public ModelAndView detail(@RequestParam Integer id){
        ModelAndView response = new ModelAndView("customer/detail");

        Customer customer = customerDao.findById(id);

        if (customer == null){
            log.warn("Customer with id " + id + " was not found");
            response.setViewName("redirect:/error/404");
            return response;
        }
        response.addObject("customer", customer);

        return response;

    }

    @GetMapping("/customer/fileupload")
    //use this for customer/fileupload?id=x urls as opposed to customer/fileupload/x
    public ModelAndView fileUpload(@RequestParam Integer id) {
        ModelAndView response = new ModelAndView("customer/fileupload");

        Customer customer = customerDao.findById(id);
        response.addObject("customer", customer);

        log.info(" In fileupload with no Args");
        return response;
    }

    @PostMapping("/customer/fileUploadSubmit")
    public ModelAndView fileUploadSubmit(@RequestParam("file") MultipartFile file, @RequestParam Integer id) {
        ModelAndView response = new ModelAndView("redirect:/customer/detail?id="+id);

        log.info("Filename = " + file.getOriginalFilename());
        log.info("Size     = " + file.getSize());
        log.info("Type     = " + file.getContentType());


        // Get the file and save it somewhere
        File f = new File("./src/main/webapp/pub/images/" + file.getOriginalFilename());
        try (OutputStream outputStream = new FileOutputStream(f.getAbsolutePath())) {
            IOUtils.copy(file.getInputStream(), outputStream);
        } catch (Exception e) {


            e.printStackTrace();
        }

        //these 3 lines of code will load customer by id passed in
        //update the image url field and then save the customer to the database
        Customer customer = customerDao.findById(id);
        customer.setImageUrl("/pub/images/" + file.getOriginalFilename());
        customerDao.save(customer);

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
