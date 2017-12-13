package sg.edu.iss.team8.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;

import sg.edu.iss.team8.model.Product;
import sg.edu.iss.team8.model.Supplier;

public class ReorderReportService {

	@Autowired
	ProductService productService;
	@Autowired
	SupplierService supplierService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sg.edu.iss.team8.service.ReorderReportService#getReorderReport(sg.edu.iss.
	 * team8.model.Supplier, java.util.List)
	 */
	public Pair<ArrayList<String[]>, String> getReportMatchSupplierWithProducts(Supplier s, List<Product> plist) {
		ArrayList<String[]> reorderReport = new ArrayList<String[]>();
		double totalPrice = 0;
		for (Product p : plist) {
			if (p.getSupplierId() == s.getSupplierId()) {
				int partNo = p.getPartNumber();
				double unitPrice = p.getUnitPrice();
				int quantity = p.getStock();
				int reorderLevel = p.getReorderLevel();
				int minReorderQty = p.getMinimumReorderQuantity();
				int orderQty = 0;
				double price = 0;
				if (quantity < reorderLevel) {
					int deficit = reorderLevel - quantity;
					if (deficit < minReorderQty) {
						orderQty = minReorderQty;
					} else {
						orderQty = deficit;
					}
					price = orderQty * unitPrice;
				}
				String[] row = new String[] { Integer.toString(partNo), String.format("%,.2f", unitPrice),
						Integer.toString(quantity), Integer.toString(reorderLevel), Integer.toString(minReorderQty),
						Integer.toString(orderQty), String.format("%,.2f", price) };
				reorderReport.add(row);
				totalPrice += price;
			}
		}
		return Pair.of(reorderReport, String.format("%,.2f", totalPrice));

	}

	public Pair<ArrayList<String[]>, String> getReportFromProductList(ArrayList<Product> plist) {
		ArrayList<String[]> reorderReport = new ArrayList<String[]>();
		double totalPrice = 0;
		for (Product p : plist) {
			int partNo = p.getPartNumber();
			double unitPrice = p.getUnitPrice();
			int quantity = p.getStock();
			int reorderLevel = p.getReorderLevel();
			int minReorderQty = p.getMinimumReorderQuantity();
			int orderQty = 0;
			double price = 0;
			if (quantity < reorderLevel) {
				int deficit = reorderLevel - quantity;
				if (deficit < minReorderQty) {
					orderQty = minReorderQty;
				} else {
					orderQty = deficit;
				}
				price = orderQty * unitPrice;
			}
			String[] row = new String[] { Integer.toString(partNo), String.format("%,.2f", unitPrice),
					Integer.toString(quantity), Integer.toString(reorderLevel), Integer.toString(minReorderQty),
					Integer.toString(orderQty), String.format("%,.2f", price) };
			reorderReport.add(row);
			totalPrice += price;

		}
		return Pair.of(reorderReport, String.format("%,.2f", totalPrice));
	}

}
