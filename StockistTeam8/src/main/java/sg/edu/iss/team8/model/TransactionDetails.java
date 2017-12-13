package sg.edu.iss.team8.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "transactiondetails")
@IdClass(TransactionId.class)
public class TransactionDetails {
     @Id
	@Column(name = "transactionid")
	private Integer transactionId;
	@Id
	@Column(name = "partnumber")
	private int partNumber;
	@Column(name = "quantity")
	private Integer quantity;

//	@JoinColumn(name = "transactionid"/*,referencedColumnName="transactionid"*/)
	@Transient
	@ManyToOne(/*cascade = CascadeType.ALL,*/ fetch = FetchType.LAZY)
	public Transaction transactionDetailsMapping;

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

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public int getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

//	public Transaction getTransaction() {
//		return transactionDetailsMapping;
//	}
//
//	public void setTransaction(Transaction transaction) {
//		this.transactionDetailsMapping = transaction;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + partNumber;
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
		TransactionDetails other = (TransactionDetails) obj;
		if (partNumber != other.partNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TransactionDetails [transactionId=" + transactionId + ", partNumber=" + partNumber + ", quantity="
				+ quantity + "]";
	}

}