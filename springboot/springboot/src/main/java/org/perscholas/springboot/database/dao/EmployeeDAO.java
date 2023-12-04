package org.perscholas.springboot.database.dao;

import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long> {
    public Employee findById(Integer id);

    @Query("SELECT c from Employee c WHERE " +
            "(LOWER(c.firstName) = LOWER(:firstName)) OR " +
            "(LOWER(c.lastName) = LOWER(:lastName))")
    List<Employee> findByFirstNameOrLastName(String firstName, String lastName);
}
