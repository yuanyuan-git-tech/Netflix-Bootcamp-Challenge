package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;

    @Before
    public void setUp() {
        customerRepository.deleteAll();
    }
    @Test
    public void addCustomer() {
        // Arrange
        Customer customer = new Customer();
        customer.setCity("Charlottesville");
        customer.setCompany("UVA");
        customer.setAddress1("University of Virginia");
        customer.setAddress2("Fontaine Ave");
        customer.setCountry("USA");
        customer.setState("VA");
        customer.setEmail("qsn7pu");
        customer.setFirstName("Yuanyuan");
        customer.setLastName("Zhao");
        customer.setPhone("434-257-6072");
        customer.setPostalCode("22903");
        customerRepository.save(customer);
        // Act
        Optional<Customer> customer1 = customerRepository.findById(customer.getId());
        // Assert
        assertEquals(customer1.get(), customer);
    }
    @Test
    public void updateCustomer() {
        // Arrange
        Customer customer = new Customer();
        customer.setCity("Charlottesville");
        customer.setCompany("UVA");
        customer.setAddress1("University of Virginia");
        customer.setAddress2("Fontaine Ave");
        customer.setCountry("USA");
        customer.setState("VA");
        customer.setEmail("qsn7pu");
        customer.setFirstName("Yuanyuan");
        customer.setLastName("Zhao");
        customer.setPhone("434-257-6072");
        customer.setPostalCode("22903");
        customerRepository.save(customer);
        // Act
        customer.setCompany("Amazon");
        customerRepository.save(customer);
        Optional<Customer> customer1 = customerRepository.findById(customer.getId());
        // Assert
        assertEquals(customer1.get(), customer);
    }
    @Test
    public void deleteCustomer() {
        // Arrange
        Customer customer = new Customer();
        customer.setCity("Charlottesville");
        customer.setCompany("UVA");
        customer.setAddress1("University of Virginia");
        customer.setAddress2("Fontaine Ave");
        customer.setCountry("USA");
        customer.setState("VA");
        customer.setEmail("qsn7pu");
        customer.setFirstName("Yuanyuan");
        customer.setLastName("Zhao");
        customer.setPhone("434-257-6072");
        customer.setPostalCode("22903");
        customerRepository.save(customer);
        // Act
        customerRepository.deleteById(customer.getId());
        // Assert
        Optional<Customer> customer1 = customerRepository.findById(customer.getId());
        assertFalse(customer1.isPresent());
    }
    @Test
    public void findCustomerByState() {
        // Arrange
        Customer customer = new Customer();
        customer.setCity("Charlottesville");
        customer.setCompany("UVA");
        customer.setAddress1("University of Virginia");
        customer.setAddress2("Fontaine Ave");
        customer.setCountry("USA");
        customer.setState("VA");
        customer.setEmail("qsn7pu");
        customer.setFirstName("Yuanyuan");
        customer.setLastName("Zhao");
        customer.setPhone("434-257-6072");
        customer.setPostalCode("22903");
        customerRepository.save(customer);
        Customer customer1 = new Customer();
        customer1.setCity("Charlottesville");
        customer1.setCompany("UVA");
        customer1.setAddress1("University of Virginia");
        customer1.setAddress2("Copeley");
        customer1.setCountry("USA");
        customer1.setState("VA");
        customer1.setEmail("gnh4ku");
        customer1.setFirstName("Xinrun");
        customer1.setLastName("Miao");
        customer1.setPhone("434-257-6000");
        customer1.setPostalCode("22903");
        customerRepository.save(customer1);
        // Act
        List<Customer> customerList = customerRepository.findCustomersByState(customer.getState());
        // Assert
        assertEquals(2, customerList.size());
    }

}