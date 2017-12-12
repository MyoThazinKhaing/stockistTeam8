package sg.edu.iss.team8.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.persistence.Column;



@Entity
@Table(name="supplier")
public class Supplier {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int supplierId;
	private String supplierName;
	private String address;
	private String country;
	@Pattern(regexp = "\\d{8}", message = "Please enter valid phone number")
	
	private String contactNumber;
	private String contactName;
	@Pattern(regexp = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", message = "Please enter valid web site")
	private String website;
	private String status;
	public Supplier() {
		super();
		
	}
	public Supplier(int supplierId, String supplierName, String address, String country, String contactNumber,
			String contactName, String website) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.address = address;
		this.country = country;
		this.contactNumber = contactNumber;
		this.contactName = contactName;
		this.website = website;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", address=" + address
				+ ", country=" + country + ", contactNumber=" + contactNumber + ", contactName=" + contactName
				+ ", website=" + website + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + supplierId;
		return result;
	}


	
	

}
