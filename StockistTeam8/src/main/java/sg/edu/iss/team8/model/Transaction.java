package sg.edu.iss.team8.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "transaction")
// @SecondaryTable(name = "transactiondetails", pkJoinColumns =
// @PrimaryKeyJoinColumn(name = "transactionid"))
public class Transaction {

	@Id
	@Column(name = "transactionid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;

	@Column(name = "customerid")
	private int customerId;

	@Temporal(TemporalType.DATE)
	@Column(name = "consumedate")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date consumeDate;

	@Column(name = "username")
	private String userName;

	@OneToMany(mappedBy = "transactionDetailsMapping", cascade = CascadeType.ALL, fetch = FetchType.LAZY)//EAGER)
//	@JoinColumn(name="transactionid")
	public List<TransactionDetails> transactionEvent;// = new ArrayList<TransactionDetails>();
//	public List<TransactionDetails> getTransactionDetails(this.getTransactionId()){
//		
//	}
//	public List<TransactionDetails> transactionEvent;// = new ArrayList<TransactionDetails>();

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(int transactionId, int customerId, Date consumeDate, String userName,
			List<TransactionDetails> transactionEvent) {
		super();
		this.transactionId = transactionId;
		this.customerId = customerId;
		this.consumeDate = consumeDate;
		this.userName = userName;
		this.transactionEvent = transactionEvent;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getConsumeDate() {
		return consumeDate;
	}

	public void setConsumeDate(Date consumeDate) {
		this.consumeDate = consumeDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<TransactionDetails> getTransactionEvent() {
		return transactionEvent;
	}

	public void setTransactionEvent(List<TransactionDetails> transactionEvent) {
		this.transactionEvent = transactionEvent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerId;
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
		Transaction other = (Transaction) obj;
		if (customerId != other.customerId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", customerId=" + customerId + ", consumeDate="
				+ consumeDate + ", userName=" + userName + "]";
	}

}