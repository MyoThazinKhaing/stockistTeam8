package sg.edu.iss.team8.service;

import java.util.ArrayList;

import sg.edu.iss.team8.model.Product;

public interface ProductService {
	
	ArrayList<Product> findAllProducts();
	
	Product findProductByNo(int pNo);
	
	ArrayList<Product> findProductByColour(String pColour);
	
	ArrayList<Product> findProductByDescription(String pdescription);
	
	ArrayList<Product> findProductByManufacturer(String pManufacturer);
	
	Product createProduct(Product product);
	
	Product changeProduct(Product product);
	
	void removeEmployee(Product product);
	
	
	

}
