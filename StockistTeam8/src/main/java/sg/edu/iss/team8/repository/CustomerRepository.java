package sg.edu.iss.team8.repository;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.team8.model.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query("SELECT e FROM Customer e where e.customerId = :id")
	Customer findCustomerById(@Param("id") int id);
	
	@Query("SELECT DISTINCT e.customerId FROM Customer e")
	ArrayList<String> findAllCustomerIDs();

}
