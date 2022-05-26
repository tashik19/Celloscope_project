package com.celloscope.springbootdatabase.repository;

import com.celloscope.springbootdatabase.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query(value="Select c.id from Customer c where c.name = :name and c.phoneNo = :phoneNo")
    String findCustomerById(@Param("name") String name, @Param("phoneNo") String phoneNo);
}