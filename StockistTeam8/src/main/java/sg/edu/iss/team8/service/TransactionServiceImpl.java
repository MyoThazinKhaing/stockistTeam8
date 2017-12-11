package sg.edu.iss.team8.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team8.model.Transaction;
import sg.edu.iss.team8.repository.TransactionRepository;



@Service
public class TransactionServiceImpl implements TransactionService {
	@Resource
	private TransactionRepository transactionRepository;
	


	/* (non-Javadoc)
	 * @see edu.iss.cats.service.TransactionService#findAllTransactions()
	 */
	@Override
	@Transactional
	public ArrayList<Transaction> findAllTransactions() {
		ArrayList<Transaction> l = (ArrayList<Transaction>) transactionRepository.findAll();
		return l;
	}


	/* (non-Javadoc)
	 * @see edu.iss.cats.service.TransactionService#findTransaction(java.lang.String)
	 */
	@Override
	@Transactional
	public Transaction findTransaction(Integer ceid) {
		return transactionRepository.findOne(ceid);

	}

	
	/* (non-Javadoc)
	 * @see edu.iss.cats.service.TransactionService#createTransaction(edu.iss.cats.model.Transaction)
	 */
	@Override
	@Transactional
	public Transaction createTransaction(Transaction transaction) {
		return transactionRepository.saveAndFlush(transaction);
		//return transactionDetailsRepository.saveAndFlush(transactionDetails);
	}

	
	/* (non-Javadoc)
	 * @see edu.iss.cats.service.TransactionService#changeTransaction(edu.iss.cats.model.Transaction)
	 */
	@Override
	@Transactional
	public Transaction changeTransaction(Transaction transaction) {
		return transactionRepository.saveAndFlush(transaction);
	}

	/* (non-Javadoc)
	 * @see edu.iss.cats.service.TransactionService#removeTransaction(edu.iss.cats.model.Transaction)
	 */
	@Override
	@Transactional
	public void removeTransaction(Transaction transaction) {
		transactionRepository.delete(transaction);
	}

	/* (non-Javadoc)
	 * @see edu.iss.cats.service.TransactionService#findTransactionsByEID(java.lang.String)
	 */
	@Override
	@Transactional
	public ArrayList<Transaction> findTransactionsByEID(String eid) {
		return transactionRepository.findTransactionsByEID(eid);
	}
	
	@Override
	@Transactional
	public ArrayList<Transaction> findTransactionsByDate(String eid, String eid2){
		return transactionRepository.findTransactionsByDate(eid, eid2);
	}

	@Override
	@Transactional
	public ArrayList<String> findAllTransactionIDs(){
		return transactionRepository.findAllTransactionIDs();
	}
}