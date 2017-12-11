package sg.edu.iss.team8.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.team8.model.TransactionDetails;

public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Integer>{
	@Query("SELECT t from TransactionDetails t WHERE t.partNumber = :eid")
	ArrayList<TransactionDetails> findTransactionDetailsByPartNumber(@Param("eid") String eid);

}
