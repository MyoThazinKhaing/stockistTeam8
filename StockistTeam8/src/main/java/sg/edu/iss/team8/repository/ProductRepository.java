package sg.edu.iss.team8.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.team8.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{


    @Query("SELECT p from Product p where p.supplierId = :sId")
    ArrayList<Product> findProductBySupplierId(@Param("sId") int sId);

	
}
