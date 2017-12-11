package sg.edu.iss.team8.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team8.model.Customer;

public interface CustomerService {

	ArrayList<Customer> findAllCustomers();

	Customer findCustomer(String empid);

	Customer createCustomer(Customer emp);

	Customer changeCustomer(Customer emp);

	void removeCustomer(Customer emp);

	Customer findCustomerById(String s);

	ArrayList<Integer> findAllCustomerIDs();

}
