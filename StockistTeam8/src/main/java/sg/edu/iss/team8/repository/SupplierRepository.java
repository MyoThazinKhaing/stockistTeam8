package sg.edu.iss.team8.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.team8.model.Supplier;


public interface SupplierRepository extends JpaRepository<Supplier,Integer>{

	
	@Query("SELECT s.supplierId from Supplier s")
	   ArrayList<Integer> findAllSupplierIDs();
	
	@Query("SELECT s.supplierName from Supplier s")
	   ArrayList<String> findAllSupplierNames();
	
	@Query("SELECT s from Supplier s")
	   ArrayList<Supplier> findAllSuppliers();
	
	@Query(value = "SELECT * FROM supplier WHERE suppliername like %?1%", nativeQuery = true)
	ArrayList<Supplier> findSupplierByName(@Param("name") String name);
	
	@Query(value = "select * from supplier where status like 'Active'",nativeQuery=true)
	   ArrayList<Supplier> findAllSupplierByStatus();
	@Query("SELECT s FROM Supplier s where s.supplierId = :id")
	Supplier findSupplierById(@Param("id") int id);
}
