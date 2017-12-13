package sg.edu.iss.team8.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.team8.model.TransactionDetails;
import sg.edu.iss.team8.model.TransactionId;

public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, TransactionId>{
	@Query("SELECT t from TransactionDetails t WHERE t.partNumber = :eid")
	ArrayList<TransactionDetails> findTransactionDetailsByPartNumber(@Param("eid") int eid);

}