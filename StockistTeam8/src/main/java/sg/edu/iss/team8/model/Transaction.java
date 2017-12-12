package sg.edu.iss.team8.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
	@Column(name = "transactionid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionid;

	@Basic
	@Column(name = "customerid")
	private int customerId;

	@Basic
	@Column(name = "username")
	private String userName;

	@Temporal(TemporalType.DATE)
	@Column(name = "consumedate")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date consumeDate;

	@OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<TransactionDetails> transactionDetails = new ArrayList<TransactionDetails>();

	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", customerId=" + customerId + ", userName=" + userName
				+ ", consumeDate=" + consumeDate + ", transactionDetails=" + transactionDetails + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consumeDate == null) ? 0 : consumeDate.hashCode());
		result = prime * result + customerId;
		result = prime * result + ((transactionDetails == null) ? 0 : transactionDetails.hashCode());
		result = prime * result + transactionid;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	public Transaction(int transactionid, int customerId, String userName, Date consumeDate,
			List<TransactionDetails> transactionDetails) {
		super();
		this.transactionid = transactionid;
		this.customerId = customerId;
		this.userName = userName;
		this.consumeDate = consumeDate;
		this.transactionDetails = transactionDetails;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getConsumeDate() {
		return consumeDate;
	}

	public void setConsumeDate(Date consumeDate) {
		this.consumeDate = consumeDate;
	}

	public List<TransactionDetails> getTransactionDetails() {
		return transactionDetails;
	}

	public void setTransactionDetails(List<TransactionDetails> transactionDetails) {
		this.transactionDetails = transactionDetails;
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
		if (consumeDate == null) {
			if (other.consumeDate != null)
				return false;
		} else if (!consumeDate.equals(other.consumeDate))
			return false;
		if (customerId != other.customerId)
			return false;
		if (transactionDetails == null) {
			if (other.transactionDetails != null)
				return false;
		} else if (!transactionDetails.equals(other.transactionDetails))
			return false;
		if (transactionid != other.transactionid)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

}
