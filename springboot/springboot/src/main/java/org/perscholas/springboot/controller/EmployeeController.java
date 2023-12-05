package org.perscholas.springboot.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.EmployeeDAO;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.database.entity.Employee;
import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.perscholas.springboot.formbean.CreateEmployeeFormBean;
import org.perscholas.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDao;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/create")
    public ModelAndView createEmployee() {
        ModelAndView response = new ModelAndView("employee/create");
        log.info("In create employee with no args");
        return response;
    }

    @GetMapping("/employee/createSubmit")
    public ModelAndView createEmployeeSubmit(@Valid CreateEmployeeFormBean form, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            log.info("######################### In create employee submit - has errors #########################");
            ModelAndView response = new ModelAndView("employee/create");

            for ( ObjectError error : bindingResult.getAllErrors() ) {
                log.info("error: " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("errors", bindingResult);
            return response;
        }

        log.info("############ In create employee submit - no error found #############");

        Employee e = employeeService.createEmployee(form);

        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/employee/edit/" + e.getId() + "?success=Employee Saved Successfully");

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

    @GetMapping("/employee/edit/{id}")
    public ModelAndView editEmployee(@PathVariable int id){
        ModelAndView response = new ModelAndView("employee/create");

        Employee employee = employeeDao.findById(id);

        CreateEmployeeFormBean form = new CreateEmployeeFormBean();

        if ( employee != null) {
            form.setId(employee.getId());
            form.setFirstName(employee.getFirstName());
            form.setLastName(employee.getLastName());
            form.setDepartment(employee.getDepartment());
        } else {
            log.warn("Employee with id " + id + " was not found");
        }

        response.addObject("form", form);

        return response;
    }
}
