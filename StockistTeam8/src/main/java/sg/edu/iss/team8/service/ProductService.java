package sg.edu.iss.team8.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team8.model.Product;

public interface ProductService {

	ArrayList<Product> findAllProducts();

	ArrayList<Product> searchProductByDescrption(String description);
	
	/*ArrayList<Product> searchProduct(String searchCriteria, String searchValue);*/

	Product findProduct(Integer partNumber);

	Product createUser(Product product);

	Product changeUser(Product product);

	void removeUser(Product product);

}