package sg.edu.iss.team8.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team8.model.Product;
import sg.edu.iss.team8.model.Supplier;
import sg.edu.iss.team8.repository.ProductRepository;
import sg.edu.iss.team8.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService {
	@Resource
	SupplierRepository supplierRepository;
	
	/* (non-Javadoc)
	 * @see sg.edu.iss.team8.service.ProductService#findAllCourseEvents()
	 */
	
	/* (non-Javadoc)
	 * @see sg.edu.iss.team8.service.SupplierService#findAllSupplier()
	 */
	@Override
	@Transactional
	public ArrayList<Supplier> findAllSupplier() {
		ArrayList<Supplier> l = (ArrayList<Supplier>) supplierRepository.findAll();
		return l;
	}

}
