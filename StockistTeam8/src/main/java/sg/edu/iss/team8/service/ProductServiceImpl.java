package sg.edu.iss.team8.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team8.model.Product;
import sg.edu.iss.team8.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService  {
	@Resource
	ProductRepository productRepository;
	
	/* (non-Javadoc)
	 * @see sg.edu.iss.team8.service.ProductService#findAllCourseEvents()
	 */
	@Override
	@Transactional
	public ArrayList<Product> findAllProduct() {
		ArrayList<Product> l = (ArrayList<Product>) productRepository.findAll();
		return l;
	}
	@Override
	@Transactional
	public ArrayList<Product> findAllProductBySupplierId(int sid) {
		ArrayList<Product> l = (ArrayList<Product>) productRepository.findProductBySupplierId(sid);
		return l;
	}

}
