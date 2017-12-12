package sg.edu.iss.team8.model;

import java.io.Serializable;

public class TransactionId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int transactionId;
	
	private int partNumber;

	public TransactionId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public TransactionId(int transactionId, int partNumber) {
		super();
		this.transactionId = transactionId;
		this.partNumber = partNumber;
	}



	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
