package sg.edu.iss.team8.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team8.model.Supplier;
import sg.edu.iss.team8.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements  SupplierService{

	@Resource
	SupplierRepository supplierRepository;
	
	@Override
	@Transactional
	public ArrayList<Integer> findAllSupplierIDs() {
	
		return supplierRepository.findAllSupplierIDs();
	}

	@Override
	@Transactional
	public ArrayList<String> findAllSupplierNames() {
		
		return supplierRepository.findAllSupplierNames();
	}

	@Override
	@Transactional
    public ArrayList<Supplier> findAllSupplier() {
		// TODO Auto-generated method stub
		return  supplierRepository.findAllSuppliers();
	}

	@Override
	public ArrayList<Supplier> findAllSupplierByStatus() {
		// TODO Auto-generated method stub
		return supplierRepository.findAllSupplierByStatus();
	}

	

	
}
