package sg.edu.iss.team8.model;

import sg.edu.iss.team8.model.Product;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;




import java.util.Date;

@Entity
@Table(name="damage")
public class Damage  {
	@Id
	@Column(name="damageid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int damageId;
	@Basic
	@Column(name="partnumber")
	@NotNull
	private int partNumber;
	@NotNull
	@Min(1)
	private int quantity;
	
	@Past
	@Temporal(TemporalType.DATE)
	@Column(name="senddate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date sendDate;
	
	@Past
	@Temporal(TemporalType.DATE)
	@Column(name="receivedate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date receiveDate;
	private String status;
	
	@ManyToOne
	@JoinColumn(name ="partnumber",insertable=false,updatable=false)
	private Product product;
	
	
	
	public Damage() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Damage(int damageId, int partNumber, int quantity, Date sendDate, Date receiveDate, String status,
			Product product) {
		super();
		this.damageId = damageId;
		this.partNumber = partNumber;
		this.quantity = quantity;
		this.sendDate = sendDate;
		this.receiveDate = receiveDate;
		this.status = status;
		this.product = product;
	}



	public int getDamageId() {
		return damageId;
	}



	public void setDamageId(int damageId) {
		this.damageId = damageId;
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



	public Date getSendDate() {
		return sendDate;
	}



	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}



	public Date getReceiveDate() {
		return receiveDate;
	}



	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



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
		Damage other = (Damage) obj;
		if (partNumber != other.partNumber)
			return false;
		return true;
	}
	
	

}
