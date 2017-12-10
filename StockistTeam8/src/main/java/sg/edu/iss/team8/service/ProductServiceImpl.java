package sg.edu.iss.team8.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team8.model.Product;
import sg.edu.iss.team8.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductRepository pRepository;

	/* (non-Javadoc)
	 * @see sg.edu.iss.team8.service.ProductService#findAllProducts()
	 */
	@Override
	@Transactional
	public ArrayList<Product> findAllProducts() {
		ArrayList<Product> pl = (ArrayList<Product>) pRepository.findAll();
		return pl;
	}

	/* (non-Javadoc)
	 * @see sg.edu.iss.team8.service.ProductService#findProduct(java.lang.Integer)
	 */
	@Override
	@Transactional
	public Product findProduct(Integer partNumber) {
		return pRepository.findOne(partNumber);
	}

	/* (non-Javadoc)
	 * @see sg.edu.iss.team8.service.ProductService#createUser(sg.edu.iss.team8.model.Product)
	 */
	@Override
	@Transactional
	public Product createUser(Product product) {
		return pRepository.saveAndFlush(product);
	}

	/* (non-Javadoc)
	 * @see sg.edu.iss.team8.service.ProductService#changeUser(sg.edu.iss.team8.model.Product)
	 */
	@Override
	@Transactional
	public Product changeUser(Product product) {
		return pRepository.saveAndFlush(product);
	}

	/* (non-Javadoc)
	 * @see sg.edu.iss.team8.service.ProductService#removeUser(sg.edu.iss.team8.model.Product)
	 */
	@Override
	@Transactional
	public void removeUser(Product product) {
		pRepository.delete(product);
	}
	
	public ArrayList<Product> searchProductByDescrption(String pDescription) {
		return pRepository.findProductByDescrption(pDescription);
	}
	
	/*@Override
	public	ArrayList<Product> searchProduct(String searchCriteria, String searchValue){
		return pRepository.findProduct(searchCriteria, searchValue);
	}*/
}
