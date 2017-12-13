package sg.edu.iss.team8.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.edu.iss.team8.model.Product;
import sg.edu.iss.team8.model.Supplier;
import sg.edu.iss.team8.service.ProductService;
import sg.edu.iss.team8.service.ReorderReportService;
import sg.edu.iss.team8.service.SupplierService;

@RequestMapping(value = "/reorder")
@Controller
public class AdminReorderReportController {

	@Autowired
	ProductService productService;
	@Autowired
	SupplierService supplierService;

	
	ReorderReportService reportService = new ReorderReportService();

	@RequestMapping(value = { "/*", "/**" }, method = RequestMethod.GET)
	public String general(HttpServletRequest request, HttpSession session) {
		return "redirect:/notfound";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView productListPage() {
		ModelAndView mav = new ModelAndView("reorder-report");
		// List<Product> plist = productService.findAllProduct();
		List<Supplier> slist = supplierService.findAllSupplier();
		
		Supplier supplier = slist.get(0);
		
		// get list of matching products with first supplier id in list
		ArrayList<Product> plist = productService.findAllProductBySupplierId(supplier.getSupplierId());

		// get values to map report on jsp
		Pair<ArrayList<String[]>, String> reorderReport = reportService.getReportFromProductList(plist);

		mav.addObject("reportTable", reorderReport.getFirst());
		mav.addObject("totalPrice", reorderReport.getSecond());	
		mav.addObject("supplier", supplier);
		mav.addObject("supplierName", slist.get(0).getSupplierName());
		mav.addObject("slist", slist);
		return mav;

	}
/*
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView editProdcut(@ModelAttribute @Valid Supplier supplier, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		
		 * if (result.hasErrors()) { return new ModelAndView("product-edit"); }
		 

		ModelAndView mav = new ModelAndView("reorder-report");

		ArrayList<Product> plist = productService.findAllProductBySupplierId(supplier.getSupplierId());
		List<Supplier> slist = supplierService.findAllSuppliers();
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for (Supplier s : slist) {
			map.put(s.getSupplierId(), s.getSupplierName());
		}
		mav.addObject("plist", plist);
		mav.addObject("slist", map);
		return mav;

	}*/

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchSupplier(@RequestParam String supplierName) {
		ModelAndView mav = new ModelAndView("reorder-report");
		
		Supplier supplier = supplierService.searchSupplierByName(supplierName).get(0);
		
		ArrayList<Product> plist = productService.findAllProductBySupplierId(supplier.getSupplierId());
		List<Supplier> slist = supplierService.findAllSuppliers();

		// get values to map report on jsp
		Pair<ArrayList<String[]>, String> reorderReport = reportService.getReportFromProductList(plist);

		mav.addObject("reportTable", reorderReport.getFirst());
		mav.addObject("totalPrice", reorderReport.getSecond());
		mav.addObject("supplier", supplier);
		mav.addObject("supplierName", supplier.getSupplierName());
		mav.addObject("slist", slist);
		return mav;

	}

}
