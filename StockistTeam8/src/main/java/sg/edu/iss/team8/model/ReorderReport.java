package sg.edu.iss.team8.model;



import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



public class ReorderReport
{
	
	private int supplierId;

	private int partNumber;
	
	private double unitPrice;
	
	private int stock;

	private int reorderlevel;
	
	private int minimumreorderquantity;
	
	private int orderquantity;
	private double price;
	public ReorderReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReorderReport(int supplierId, int partNumber, double unitPrice, int stock, int reorderlevel,
			int minimumreorderquantity, int orderquantity, double price) {
		super();
		this.supplierId = supplierId;
		this.partNumber = partNumber;
		this.unitPrice = unitPrice;
		this.stock = stock;
		this.reorderlevel = reorderlevel;
		this.minimumreorderquantity = minimumreorderquantity;
		this.orderquantity = orderquantity;
		this.price = price;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public int getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getReorderlevel() {
		return reorderlevel;
	}
	public void setReorderlevel(int reorderlevel) {
		this.reorderlevel = reorderlevel;
	}
	public int getMinimumreorderquantity() {
		return minimumreorderquantity;
	}
	public void setMinimumreorderquantity(int minimumreorderquantity) {
		this.minimumreorderquantity = minimumreorderquantity;
	}
	public int getOrderquantity() {
		if(stock<reorderlevel)
		{
			int a = reorderlevel - stock;
			if(a>minimumreorderquantity)
			{
				orderquantity=a;
			}
			else
			{
				orderquantity=minimumreorderquantity;
			}
			
		}
		else 
		{
			orderquantity=0;
		}
		return orderquantity;
	}
	public void setOrderquantity(int orderquantity) {
		this.orderquantity = orderquantity;
	}
	public double getPrice() {
		price= unitPrice*orderquantity;
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + supplierId;
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
		ReorderReport other = (ReorderReport) obj;
		if (supplierId != other.supplierId)
			return false;
		return true;
	}
	

	
	
}
