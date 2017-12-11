package sg.edu.iss.team8.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team8.model.Product;
import sg.edu.iss.team8.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Resource
	ProductRepository productRepository;

	@Override
	@Transactional
	public ArrayList<Product> findAllProducts() {
		
		return (ArrayList<Product>) productRepository.findAll();
	}

	@Override
	@Transactional
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
	@Transactional
	public Product changeProduct(Product product) {
		
		return productRepository.saveAndFlush(product);
	}

	@Override
	@Transactional
	public void removeEmployee(Product product) {
		productRepository.delete(product);
		
	}

	@Override
	@Transactional
	public ArrayList<Integer> findAllProductIDs() {
		
		return productRepository.findAllProductIDs();
	}

	@Override
	public ArrayList<Integer> findAllSupplierIDs() {
		// TODO Auto-generated method stub
		return productRepository.findAllSupplierIDs();
	}

	
}
