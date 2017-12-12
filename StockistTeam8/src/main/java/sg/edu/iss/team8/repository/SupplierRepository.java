package sg.edu.iss.team8.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import sg.edu.iss.team8.model.Supplier;



public interface SupplierRepository extends JpaRepository<Supplier, Integer>{
	
	@Query("SELECT s FROM Supplier s where s.supplierId = :id")
	Supplier findSupplierById(@Param("id") int id);
	
	@Query(value = "SELECT * FROM supplier WHERE suppliername like %?1%", nativeQuery = true)
	ArrayList<Supplier> findSupplierByName(@Param("name") String name);


}
