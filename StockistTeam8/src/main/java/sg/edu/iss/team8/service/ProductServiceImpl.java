package sg.edu.iss.team8.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team8.model.Product;
import sg.edu.iss.team8.repository.ProductRepository;

public class ProductServiceImpl implements ProductService{
	
	@Resource
	ProductRepository productRepository;

	@Override
	public ArrayList<Product> findAllProducts() {
		
		return (ArrayList<Product>) productRepository.findAll();
	}

	@Override
	public Product findProductByNo(int pNo) {
		
		return productRepository.findProductByNo(pNo);
	}

	@Override
	@Transactional
	public ArrayList<Product> findProductByColour(String pColour) {
		
		return productRepository.findProductByColour(pColour);
	}

	@Override
	@Transactional
	public ArrayList<Product> findProductByDescription(String pDescription) {
		
		return productRepository.findProductByDescrption(pDescription);
	}

	@Override
	@Transactional
	public ArrayList<Product> findProductByManufacturer(String pManufacturer) {
		
		return productRepository.findProductByManufacturer(pManufacturer);
	}

	@Override
	@Transactional
	public Product createProduct(Product product) {
		
		return  productRepository.saveAndFlush(product);
	}

	@Override
	public Product changeProduct(Product product) {
		
		return productRepository.saveAndFlush(product);
	}

	@Override
	public void removeEmployee(Product product) {
		productRepository.delete(product);
		
	}

}
