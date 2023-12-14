package org.perscholas.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.CustomerDAO;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.database.entity.User;
import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.perscholas.springboot.security.AuthenticatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDao;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    public Customer createCustomer(CreateCustomerFormBean form){
        log.debug("id: " + form.getId());
        log.debug("firstName: " + form.getFirstName());
        log.info("lastName: " + form.getLastName());
        log.info("phone: " + form.getPhone());
        log.info("city: " + form.getCity());

        //if the form.id is null then this is a create- if it is not null then it is an edit
        //first we attempt to load it from the database (basically we assume that it is going to be an edit)
        //if it was found in the database we know the incoming id was valid so we can edit it
        Customer customer = customerDao.findById(form.getId());

        //if the customer is null then we know that this is a create and we have to make a new object
        if ( customer == null){
            customer = new Customer();

            //this line of code loads the current logged in user record from the database
            User user = authenticatedUserService.loadCurrentUser();

            //then we can set the user id onto the customer record we are about to create
            //I am doing here because I only want to update the userid on the customer when it is being created

            //this line gets commented out because we established a one-to-many relationship in user and customer entities
            //customer.setUserId(user.getId());
            customer.setUser(user);
        }

        customer.setFirstName(form.getFirstName());
        customer.setLastName(form.getLastName());
        customer.setPhone(form.getPhone());
        customer.setCity(form.getCity());
        customer.setImageUrl(form.getImageUrl());

        return customerDao.save(customer);
    }
}
