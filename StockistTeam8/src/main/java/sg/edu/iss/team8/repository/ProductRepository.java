package sg.edu.iss.team8.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.team8.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{
	
	    @Query("SELECT p from Product p where p.partNumber = :pNo")
          Product findProductByNo(@Param("pNo") int pNo);
	   
	    @Query("SELECT p from Product p where p.colour = :pColour")
        ArrayList<Product> findProductByColour(@Param("pColour") String pColour);
	    

	    @Query("SELECT p from Product p where p.description LIKE %:pDescription%")
	    ArrayList<Product>findProductByDescrption(@Param("pDescription") String pDescription);
	    
	    @Query("SELECT p from Product p where p.manufacturer = :pManufacturer")
	    ArrayList<Product> findProductByManufacturer(@Param("pManufacturer") String pDescription);
	    
	    /*@Query("SELECT p from Product p where p.:criteria LIKE %:searchValue%")
	    ArrayList<Product> findProduct(@Param("criteria") String criteria, @Param("searchValue") String searchValue);*/
	    
}