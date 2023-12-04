package org.perscholas.springboot.database.dao;

import org.perscholas.springboot.database.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> {
    public Customer findById(Integer id);

    @Query("SELECT c from Customer c WHERE " +
            "(LOWER(c.firstName) = LOWER(:firstName)) OR " +
            "(LOWER(c.lastName) = LOWER(:lastName))")
    List<Customer> findByFirstNameOrLastName(String firstName, String lastName);
}
