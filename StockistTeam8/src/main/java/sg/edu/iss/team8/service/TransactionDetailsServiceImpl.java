package sg.edu.iss.team8.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import sg.edu.iss.team8.model.TransactionDetails;
import sg.edu.iss.team8.repository.TransactionDetailsRepository;




@Service
public class TransactionDetailsServiceImpl implements TransactionDetailsService {
	@Resource
	private TransactionDetailsRepository transactionDetailsRepository;
	
	/* (non-Javadoc)
	 * @see sg.edu.iss.team8.service.TransactionDetailsService#findAllTransactions()
	 */
	@Override
	@Transactional
	public ArrayList<TransactionDetails> findAllTransactions() {
		ArrayList<TransactionDetails> l = (ArrayList<TransactionDetails>) transactionDetailsRepository.findAll();
		return l;
	}

	/* (non-Javadoc)
	 * @see sg.edu.iss.team8.service.TransactionDetailsService#findTransaction(java.lang.Integer)
	 */
	@Override
	@Transactional
	public TransactionDetails findTransaction(Integer ceid) {
		return transactionDetailsRepository.findOne(ceid);

	}

	/* (non-Javadoc)
	 * @see sg.edu.iss.team8.service.TransactionDetailsService#createTransaction(sg.edu.iss.team8.model.TransactionDetails)
	 */
	@Override
	@Transactional
	public TransactionDetails createTransaction(TransactionDetails transaction) {
		return transactionDetailsRepository.saveAndFlush(transaction);
		//return transactionDetailsRepository.saveAndFlush(transactionDetails);
	}

	

	/* (non-Javadoc)
	 * @see sg.edu.iss.team8.service.TransactionDetailsService#changeTransaction(sg.edu.iss.team8.model.TransactionDetails)
	 */
	@Override
	@Transactional
	public TransactionDetails changeTransaction(TransactionDetails transaction) {
		return transactionDetailsRepository.saveAndFlush(transaction);
	}

	/* (non-Javadoc)
	 * @see sg.edu.iss.team8.service.TransactionDetailsService#removeTransaction(sg.edu.iss.team8.model.TransactionDetails)
	 */
	@Override
	@Transactional
	public void removeTransaction(TransactionDetails transaction) {
		transactionDetailsRepository.delete(transaction);
	}
	
	public ArrayList<TransactionDetails> findTransactionDetailsByPartNumber(String eid)
	{
		return transactionDetailsRepository.findTransactionDetailsByPartNumber(eid);
	}

}
