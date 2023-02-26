package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    // Create a new customer record.
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    // Update an existing customer record.
    public void updateCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
    }

    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    // Delete an existing customer record.
    public void deleteCustomer(@PathVariable int id) {
        customerRepository.deleteById(id);
    }
    @GetMapping(value = "/customers", params = {"id"})
    // Find a customer record by id.
    public Customer findCustomerById(@RequestParam(value = "id") int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) return customer.get();
        return null;
    }
    // Find customer records by state
    @GetMapping(value ="customers", params = {"state"})
    public List<Customer> findCustomerByState(@RequestParam(value = "state") String state) {
        List<Customer> customerList = customerRepository.findCustomersByState(state);
        return customerList;
    }
}
