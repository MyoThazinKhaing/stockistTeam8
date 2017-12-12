package sg.edu.iss.team8.model;

public class TransAndTransDetails {
private Transaction transaction;
private TransactionDetails transactionDetails;
public TransAndTransDetails() {
	super();
	// TODO Auto-generated constructor stub
}
public TransAndTransDetails(Transaction transaction, TransactionDetails transactionDetails) {
	super();
	this.transaction = transaction;
	this.transactionDetails = transactionDetails;
}
public Transaction getTransaction() {
	return transaction;
}
public void setTransaction(Transaction transaction) {
	this.transaction = transaction;
}
public TransactionDetails getTransactionDetails() {
	return transactionDetails;
}
public void setTransactionDetails(TransactionDetails transactionDetails) {
	this.transactionDetails = transactionDetails;
}

}
