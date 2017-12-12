package sg.edu.iss.team8.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@Column(name = "partnumber")
	private int partNumber; 

	@Column(name = "unitprice")
	private double unitPrice;

	@Column(name = "description")
	private String description;

	@Column(name = "colour")
	private String colour;

	@Column(name = "dimension")
	private String dimension;

	@Column(name = "manufacturer")
	private String manufacturer;

	@Column(name = "supplierid")
	private Integer supplierId;

	@Column(name = "reorderlevel")
	private int reorderLevel;

	@Column(name = "minimumreorderquantity")
	private int minimumReorderQuantity;

	@Column(name = "shelflocation")
	private String shelfLocation;

	

	@Column(name = "stock")
	private Integer stock;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
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


	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getColour() {
		return colour;
	}



	public void setColour(String colour) {
		this.colour = colour;
	}



	public String getDimension() {
		return dimension;
	}



	public void setDimension(String dimension) {
		this.dimension = dimension;
	}



	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	public Integer getSupplierId() {
		return supplierId;
	}


	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}


	public int getReorderLevel() {
		return reorderLevel;
	}


	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}


	public int getMinimumReorderQuantity() {
		return minimumReorderQuantity;
	}


	public void setMinimumReorderQuantity(int minimumReorderQuantity) {
		this.minimumReorderQuantity = minimumReorderQuantity;
	}


	public String getShelfLocation() {
		return shelfLocation;
	}



	public void setShelfLocation(String shelfLocation) {
		this.shelfLocation = shelfLocation;
	}
	



	public Integer getStock() {
		return stock;
	}



	public void setStock(Integer stock) {
		this.stock = stock;
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
		Product other = (Product) obj;
		if (partNumber != other.partNumber)
			return false;
		return true;
	}

}
