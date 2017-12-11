package sg.edu.iss.team8.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team8.model.TransactionDetails;

public interface TransactionDetailsService {

	/* (non-Javadoc)
	 * @see edu.iss.cats.service.TransactionService#findAllTransactions()
	 */
	ArrayList<TransactionDetails> findAllTransactions();

	/* (non-Javadoc)
	 * @see edu.iss.cats.service.TransactionService#findTransaction(java.lang.String)
	 */
	TransactionDetails findTransaction(Integer ceid);

	/* (non-Javadoc)
	 * @see edu.iss.cats.service.TransactionService#createTransaction(edu.iss.cats.model.TransactionDetails)
	 */
	TransactionDetails createTransaction(TransactionDetails transaction);

	/* (non-Javadoc)
	 * @see edu.iss.cats.service.TransactionService#changeTransaction(edu.iss.cats.model.TransactionDetails)
	 */
	TransactionDetails changeTransaction(TransactionDetails transaction);

	/* (non-Javadoc)
	 * @see edu.iss.cats.service.TransactionService#removeTransaction(edu.iss.cats.model.TransactionDetails)
	 */
	void removeTransaction(TransactionDetails transaction);
	
	public ArrayList<TransactionDetails> findTransactionDetailsByPartNumber(int eid);

}