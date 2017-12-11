package sg.edu.iss.team8.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team8.model.Supplier;

public interface SupplierService {

	ArrayList<Supplier> findAllSuppliers();

	Supplier findSupplier(Integer sid);

	Supplier createSupplier(Supplier supplier);

	Supplier changeSupplier(Supplier supplier);

	void removeSupplier(Supplier supplier);

	Supplier searchSupplierById(int id);

	ArrayList<Supplier> searchSupplierByName(String name);

}