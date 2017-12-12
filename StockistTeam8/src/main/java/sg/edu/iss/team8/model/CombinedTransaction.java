package sg.edu.iss.team8.model;

public class CombinedTransaction {
	private Transaction transaction;
	private TransactionDetails transactionDetails;
	
	public CombinedTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CombinedTransaction(Transaction transaction, TransactionDetails transactionDetails) {
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
	@Override
	public String toString() {
		return "CombinedTransaction [transaction=" + transaction + ", transactionDetails=" + transactionDetails + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((transaction == null) ? 0 : transaction.hashCode());
		result = prime * result + ((transactionDetails == null) ? 0 : transactionDetails.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CombinedTransaction other = (CombinedTransaction) obj;
		if (transaction == null) {
			if (other.transaction != null)
				return false;
		} else if (!transaction.equals(other.transaction))
			return false;
		if (transactionDetails == null) {
			if (other.transactionDetails != null)
				return false;
		} else if (!transactionDetails.equals(other.transactionDetails))
			return false;
		return true;
	}
	

}
