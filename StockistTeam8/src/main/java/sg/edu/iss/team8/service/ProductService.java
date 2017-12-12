package sg.edu.iss.team8.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team8.model.Product;

public interface ProductService {

	ArrayList<Product> findAllProduct();
	ArrayList<Product> findAllProductBySupplierId(int sid);
}