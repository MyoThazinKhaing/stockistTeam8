package sg.edu.iss.team8.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.team8.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("SELECT p from Product p where p.partNumber = :pNo")
	Product findProductByNo(@Param("pNo") int pNo);

	@Query("SELECT p from Product p where p.colour = :pColour")
	ArrayList<Product> findProductByColour(@Param("pColour") String pColour);

	// SEARCH PRODUCT ALL IN ONE
	// @Query("SELECT p from Product p where :pCriteria LIKE %:pDescription%")
	// ArrayList<Product>findProductByDescription(@Param("pCriteria") String
	// pCriteria, @Param("pDescription") String pDescription);

	@Query("SELECT p from Product p where p.description = :pDescription")
	ArrayList<Product> findProductByDescription(@Param("pDescription") String pDescription);

	@Query("SELECT p from Product p where p.manufacturer = :pManufacturer")
	ArrayList<Product> findProductByManufacturer(@Param("pManufacturer") String pDescription);

	@Query("SELECT p from Product p where :criteria = :searchValue")
	ArrayList<Product> findProduct(@Param("criteria") String criteria, @Param("searchValue") String searchValue);

	// SEARCH USING LIKE %SOMETHING%
	@Query("SELECT p from Product p where p.partNumber = :pNo")
	ArrayList<Product> searchProductByNo(@Param("pNo") int pNo);

	@Query("SELECT p from Product p where p.colour LIKE %:pColour%")
	ArrayList<Product> searchProductByColour(@Param("pColour") String pColour);

	@Query("SELECT p from Product p where p.description LIKE %:pDescription%")
	ArrayList<Product> searchProductByDescription(@Param("pDescription") String pDescription);

	@Query("SELECT p from Product p where p.manufacturer like %:pManufacturer%")
	ArrayList<Product> searchProductByManufacturer(@Param("pManufacturer") String pManufacturer);

	/*@Query("SELECT p from Product p where :criteria LIKE %:searchValue%")
	ArrayList<Product> searchProduct(@Param("criteria") String criteria, @Param("searchValue") String searchValue);*/

}