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

	/*
	 * (non-Javadoc)
	 * 
	 * @see sg.edu.iss.team8.service.ProductService#findAllProducts()
	 */
	@Override
	@Transactional
	public ArrayList<Product> findAllProducts() {
		ArrayList<Product> pl = (ArrayList<Product>) pRepository.findAll();
		return pl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sg.edu.iss.team8.service.ProductService#findProduct(java.lang.Integer)
	 */
	@Override
	@Transactional
	public Product findProduct(Integer partNumber) {
		return pRepository.findOne(partNumber);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sg.edu.iss.team8.service.ProductService#createUser(sg.edu.iss.team8.model.
	 * Product)
	 */
	@Override
	@Transactional
	public Product createUser(Product product) {
		return pRepository.saveAndFlush(product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sg.edu.iss.team8.service.ProductService#changeUser(sg.edu.iss.team8.model.
	 * Product)
	 */
	@Override
	@Transactional
	public Product changeUser(Product product) {
		return pRepository.saveAndFlush(product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sg.edu.iss.team8.service.ProductService#removeUser(sg.edu.iss.team8.model.
	 * Product)
	 */
	@Override
	@Transactional
	public void removeUser(Product product) {
		pRepository.delete(product);
	}

	@Override
	public ArrayList<Product> searchProductByDescription(String pDescription) {
		return pRepository.searchProductByDescription(pDescription);
	}

	// SEARCH PRODUCT ALL IN ONE IN REPOSITORY
	/*
	 * @Override public ArrayList<Product> searchProduct(String searchCriteria,
	 * String searchValue) { // return pRepository.findProduct(searchCriteria,
	 * searchValue); return pRepository.findProduct(searchCriteria, searchValue); }
	 */
	@Override
	public ArrayList<Product> searchProducts(String criteria, String description) {
		ArrayList<Product> searchResult = new ArrayList<Product>();
		switch (criteria) {
		case "partNumber":
			try {
				searchResult = pRepository.searchProductByNo(Integer.parseInt(description));

			} catch (Exception e) {
				searchResult = null;
			}
			break;
		case "description":
			searchResult = pRepository.searchProductByDescription(description);
			break;
		case "colour":
			searchResult = pRepository.searchProductByColour(description);
			break;
		case "manufacturer":
			searchResult = pRepository.searchProductByManufacturer(description);
			break;
		default:
			pRepository.searchProductByDescription(description);
			break;
		}

		return searchResult;
	}
	@Override
	@Transactional
	public ArrayList<Product> findAllProduct() {
		ArrayList<Product> l = (ArrayList<Product>) pRepository.findAll();
		return l;
	}
	@Override
	@Transactional
	public ArrayList<Product> findAllProductBySupplierId(int sid) {
		ArrayList<Product> l = (ArrayList<Product>) pRepository.findProductBySupplierId(sid);
		return l;
	}

}
