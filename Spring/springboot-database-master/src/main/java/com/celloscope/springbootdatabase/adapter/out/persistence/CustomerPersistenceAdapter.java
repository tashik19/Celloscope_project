package com.celloscope.springbootdatabase.adapter.out.persistence;

import com.celloscope.springbootdatabase.application.port.out.CustomerPersistencePort;
import com.celloscope.springbootdatabase.domain.Customer;
import com.celloscope.springbootdatabase.exception.ResourceNotFoundException;
import com.celloscope.springbootdatabase.repository.CustomerRepository;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerPersistenceAdapter implements CustomerPersistencePort {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer get(String customerId) {
        return customerRepository.findById(customerId).orElseThrow(() ->
                new ResourceNotFoundException("Customer", "Id", customerId));
    }
    @Override
    public String save(Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        return "Successfully Saved!";
    }

    @Override
    public String getCustomerId(Customer customer) {
        String customerId = customerRepository.findCustomerById(customer.getName(), customer.getPhoneNo());
        return customerId;
    }
}
