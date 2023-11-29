package org.perscholas.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.EmployeeDAO;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.database.entity.Employee;
import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.perscholas.springboot.formbean.CreateEmployeeFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDao;

    @GetMapping("/employee/create")
    public ModelAndView createEmployee() {
        ModelAndView response = new ModelAndView("employee/create");
        log.info("In create employee with no args");
        return response;
    }

    @GetMapping("/employee/createSubmit")
    public ModelAndView createCustomerSubmit(CreateEmployeeFormBean form){
        ModelAndView response = new ModelAndView("employee/create");

        System.out.println("firstName: " + form.getFirstName());
        System.out.println("lastName: " + form.getLastName());
        System.out.println("department: " + form.getDepartment());

        Employee employee = new Employee();
        employee.setFirstName(form.getFirstName());
        employee.setLastName(form.getLastName());
        employee.setDepartment(form.getDepartment());

        employeeDao.save(employee);

        log.info("In create employee with incoming args");
        return response;
    }

    @GetMapping("/employee/search")
    public ModelAndView search(@RequestParam(required = false) String search3, @RequestParam(required = false) String search4) { //search is matching input name in search.jsp
        ModelAndView response = new ModelAndView("employee/search");
        log.debug("In the employee search controller method : firstName search= " + search3 + " lastName search= " +search4);

        if((search3 != null) || (search4 != null)){
            List<Employee> employees = employeeDao.findByFirstNameOrLastName(search3, search4);
            response.addObject("employeeVar", employees); //key/value pair, this key refers to jstl in search.jsp, this value refers to declared list
            response.addObject("search3", search3);
            response.addObject("search4" , search4);
            for (Employee employee : employees){
                log.debug("employee: id = " + employee.getId() + " first name = " + employee.getFirstName() + " last name = " + employee.getLastName());
            }

        }
        return response;
    }
}
