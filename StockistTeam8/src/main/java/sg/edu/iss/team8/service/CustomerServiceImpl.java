package sg.edu.iss.team8.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team8.model.Customer;
import sg.edu.iss.team8.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Resource
	private CustomerRepository customerRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see sg.edu.iss.team8.service.CustomerService#findAllCustomers()
	 */
	@Override
	@Transactional
	public ArrayList<Customer> findAllCustomers() {
		ArrayList<Customer> l = (ArrayList<Customer>) customerRepository.findAll();
		return l;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sg.edu.iss.team8.service.CustomerService#findCustomer(java.lang.String)
	 */
	@Override
	@Transactional
	public Customer findCustomer(String empid) {
		return customerRepository.findOne(empid);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sg.edu.iss.team8.service.CustomerService#createCustomer(sg.edu.iss.team8.
	 * model.Customer)
	 */
	@Override
	@Transactional
	public Customer createCustomer(Customer emp) {
		return customerRepository.saveAndFlush(emp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sg.edu.iss.team8.service.CustomerService#changeCustomer(sg.edu.iss.team8.
	 * model.Customer)
	 */
	@Override
	@Transactional
	public Customer changeCustomer(Customer emp) {
		return customerRepository.saveAndFlush(emp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sg.edu.iss.team8.service.CustomerService#removeCustomer(sg.edu.iss.team8.
	 * model.Customer)
	 */
	@Override
	@Transactional
	public void removeCustomer(Customer emp) {
		customerRepository.delete(emp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sg.edu.iss.team8.service.CustomerService#findCustomerById(java.lang.String)
	 */
	@Override
	@Transactional
	public Customer findCustomerById(String s) {
		return customerRepository.findCustomerById(s);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sg.edu.iss.team8.service.CustomerService#findAllCustomerIDs()
	 */
	@Override
	public ArrayList<Integer> findAllCustomerIDs() {
		return customerRepository.findAllCustomerIDs();
	}

}