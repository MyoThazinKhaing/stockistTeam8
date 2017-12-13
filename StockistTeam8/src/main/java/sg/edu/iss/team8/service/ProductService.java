package sg.edu.iss.team8.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team8.model.Product;

public interface ProductService {

	ArrayList<Product> findAllProducts();

	// For SEARCH
	ArrayList<Product> searchProductByDescription(String description);

	ArrayList<Product> searchProducts(String criteria, String description);

	// ArrayList<Product> searchProductByDescription(String like, String
	// description);

	// SEARCH PRODUCT ALL IN ONE
	//ArrayList<Product> searchProduct(String searchCriteria, String searchValue);
	Product reduceStock(Integer partNumber, Integer sentNumber);
	Product increaseStock(Integer partNumber, Integer receivedNumber);
	Product findProduct(Integer partNumber);
	int UpdateStock(int partNumber,int stock);
	Product createUser(Product product);

	Product changeUser(Product product);

	void removeUser(Product product);

	ArrayList<Product> findAllProduct();
	ArrayList<Product> findAllProductBySupplierId(int sid);
	
	Product findProductByNo(int pNo);
	
	ArrayList<Product> findProductByColour(String pColour);
	
	
	ArrayList<Product> findProductByManufacturer(String pManufacturer);
	
	Product createProduct(Product product);
	
	Product changeProduct(Product product);
	
	void removeEmployee(Product product);
	
	ArrayList<Integer> findAllProductIDs();
	
	ArrayList<Integer> findAllSupplierIDs();
	
	
	

}
