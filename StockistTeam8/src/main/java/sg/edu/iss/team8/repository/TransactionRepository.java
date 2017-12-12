package sg.edu.iss.team8.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sg.edu.iss.team8.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	
	@Query(value = "SELECT * FROM transaction ORDER BY transactionid DESC LIMIT 1", nativeQuery = true)
	Transaction findLastRow();

	@Query("SELECT t from Transaction t WHERE t.transactionId = :eid")
	ArrayList<Transaction> findTransactionsByEID(@Param("eid") String eid);
	
	@Query("SELECT t from Transaction t WHERE t.consumeDate BETWEEN :eid AND :eid2")
	ArrayList<Transaction> findTransactionsByDate(@Param("eid") String eid, @Param("eid2") String eid2);
	
	@Query("SELECT DISTINCT t.transactionId FROM Transaction t")
	ArrayList<String> findAllTransactionIDs();
	
	//Transaction
//	@Query("SELECT t.transactionid FROM transaction t")
//	ArrayList<String> findTransactionByDateRange();
//	
//	@Query("SELECT td.partnumber from transactiondetails td WHERE td.partnumber = :partNumber")
//	ArrayList<Integer> findTDByPartNumber(@Param("partNumber") Integer partNumber);
//	
//	@Query("SELECT td.transactionid from transactiondetails td WHERE td.transactionid = :tid")
//	ArrayList<Integer> findTDById(@Param("tid") Integer tid);


}
