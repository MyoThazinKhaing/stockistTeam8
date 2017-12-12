package sg.edu.iss.team8.model;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

//@Entity
//@Table(name = "transaction")
@Component
public class TransactionForm {
	
	
	private Transaction transaction ;
	
	private TransactionDetails transactiondetails;

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public TransactionDetails getTransactiondetails() {
		return transactiondetails;
	}

	public void setTransactiondetails(TransactionDetails transactiondetails) {
		this.transactiondetails = transactiondetails;
	}
	
	

}
