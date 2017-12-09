package sg.edu.iss.team8.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team8.model.Transaction;

public interface TransactionService {

	/* (non-Javadoc)
	 * @see edu.iss.cats.service.TransactionService#findAllTransactions()
	 */
	ArrayList<Transaction> findAllTransactions();

	/* (non-Javadoc)
	 * @see edu.iss.cats.service.TransactionService#findTransaction(java.lang.String)
	 */
	Transaction findTransaction(Integer ceid);

	/* (non-Javadoc)
	 * @see edu.iss.cats.service.TransactionService#createTransaction(edu.iss.cats.model.Transaction)
	 */
	Transaction createTransaction(Transaction transaction);

	/* (non-Javadoc)
	 * @see edu.iss.cats.service.TransactionService#changeTransaction(edu.iss.cats.model.Transaction)
	 */
	Transaction changeTransaction(Transaction transaction);

	/* (non-Javadoc)
	 * @see edu.iss.cats.service.TransactionService#removeTransaction(edu.iss.cats.model.Transaction)
	 */
	void removeTransaction(Transaction transaction);

	/* (non-Javadoc)
	 * @see edu.iss.cats.service.TransactionService#findTransactionsByEID(java.lang.String)
	 */
	ArrayList<Transaction> findTransactionsByEID(String eid);

	ArrayList<Transaction> findTransactionsByDate(String eid, String eid2);


}