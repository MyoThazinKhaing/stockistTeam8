package sg.edu.iss.team8.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team8.model.Product;
import sg.edu.iss.team8.repository.ProductRepository;


import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  


@Service
public class ProductServiceImpl implements ProductService {

	JdbcTemplate template;  
	
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
			if(description=="") {
				return searchResult =(ArrayList<Product>) pRepository.findAll();
				
			}
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
	
	public ArrayList<Product> getProductByPage(int pageid,int total){  
	    String sql="select * from Product limit "+(pageid-1)+","+total;  
	    return (ArrayList<Product>) template.query(sql,new RowMapper<Product>(){  
	        public Product mapRow(ResultSet rs, int row) throws SQLException {  
	            Product p=new Product();  
	            p.setPartNumber(rs.getInt(1));  
	            p.setUnitPrice(rs.getDouble(2));  
	            p.setDescription(rs.getString(3)); 
	            p.setColour(rs.getString(4));
	            return p;  
	        }  
	    });  
	}  

}
