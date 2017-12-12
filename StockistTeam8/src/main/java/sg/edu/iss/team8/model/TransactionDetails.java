package sg.edu.iss.team8.model;

import javax.persistence.*;

@Entity
public class TransactionDetails {
	@Id
	@Column(name = "transactionid")
	private int transactionId;
	
	@Id
	@Column(name = "partnumber")
	private int partNumber;
	
	@Column (name = "quantity")
	private int quantity;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + partNumber;
		result = prime * result + quantity;
		result = prime * result + transactionId;
		return result;
	}

	public TransactionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionDetails(int transactionId, int partNumber, int quantity) {
		super();
		this.transactionId = transactionId;
		this.partNumber = partNumber;
		this.quantity = quantity;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "TransactionDetails [transactionId=" + transactionId + ", partNumber=" + partNumber + ", quantity="
				+ quantity + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionDetails other = (TransactionDetails) obj;
		if (partNumber != other.partNumber)
			return false;
		if (quantity != other.quantity)
			return false;
		if (transactionId != other.transactionId)
			return false;
		return true;
	}
	
	
	

}
