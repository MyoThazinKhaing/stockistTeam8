package sg.edu.iss.team8.service;

import java.util.ArrayList;

import sg.edu.iss.team8.model.Supplier;


public interface SupplierService {
	
	ArrayList<Integer> findAllSupplierIDs();
	
	ArrayList<String> findAllSupplierNames();
	
	ArrayList<Supplier> findAllSupplier();
	
	ArrayList<Supplier> findAllSupplierByStatus();
	

}
