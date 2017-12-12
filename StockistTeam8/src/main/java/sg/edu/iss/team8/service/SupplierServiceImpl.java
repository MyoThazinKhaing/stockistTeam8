package sg.edu.iss.team8.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team8.model.Product;
import sg.edu.iss.team8.model.Supplier;
import sg.edu.iss.team8.repository.ProductRepository;
import sg.edu.iss.team8.repository.SupplierRepository;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team8.model.Supplier;
import sg.edu.iss.team8.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService {
	@Resource
	private SupplierRepository supplierRepository;
	
	/* (non-Javadoc)
	 * @see sg.edu.iss.team8.service.SupplierService#findAllSuppliers()
	 */
	@Override
	@Transactional
	public ArrayList<Supplier> findAllSuppliers() {
		ArrayList<Supplier> l = (ArrayList<Supplier>) supplierRepository.findAll();
		return l;
	}
	/* (non-Javadoc)
	 * @see sg.edu.iss.team8.service.SupplierService#findSupplier(java.lang.Integer)
	 */
	@Override
	@Transactional
	public Supplier findSupplier(Integer sid) {
		return supplierRepository.findOne(sid);

	}
	/* (non-Javadoc)
	 * @see sg.edu.iss.team8.service.SupplierService#createSupplier(sg.edu.iss.team8.model.Supplier)
	 */
	@Override
	@Transactional
	public Supplier createSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}
	
	/* (non-Javadoc)
	 * @see sg.edu.iss.team8.service.SupplierService#changeSupplier(sg.edu.iss.team8.model.Supplier)
	 */
	@Override
	@Transactional
	public Supplier changeSupplier(Supplier supplier) {
		return supplierRepository.saveAndFlush(supplier);
	}
	
	/* (non-Javadoc)
	 * @see sg.edu.iss.team8.service.SupplierService#removeSupplier(sg.edu.iss.team8.model.Supplier)
	 */
	@Override
	@Transactional
	public void removeSupplier(Supplier supplier) {
		supplierRepository.delete(supplier);
	}
	
	/* (non-Javadoc)
	 * @see sg.edu.iss.team8.service.SupplierService#searchSupplierById(int)
	 */
	@Override
	@Transactional
	public Supplier searchSupplierById(int id) {
		return supplierRepository.findSupplierById(id);
	}
	
	/* (non-Javadoc)
	 * @see sg.edu.iss.team8.service.SupplierService#searchSupplierByName(java.lang.String)
	 */
	@Override
	@Transactional
	public ArrayList<Supplier> searchSupplierByName(String name) {
		return supplierRepository.findSupplierByName(name);
	}
}
