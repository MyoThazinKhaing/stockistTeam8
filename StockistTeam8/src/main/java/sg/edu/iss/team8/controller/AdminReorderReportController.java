package sg.edu.iss.team8.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.edu.iss.team8.model.Product;
import sg.edu.iss.team8.model.Supplier;
import sg.edu.iss.team8.service.ProductService;
import sg.edu.iss.team8.service.SupplierService;


@RequestMapping(value="/admin/reorderreport")
@Controller
public class AdminReorderReportController 
{
	
	@Autowired
	ProductService productService;
	@Autowired
	SupplierService supplierService;

	

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView productListPage() {
		ModelAndView mav = new ModelAndView("ReorderReport","supplier",new Supplier());
		List<Product> plist = productService.findAllProduct();
		List<Supplier> slist=supplierService.findAllSuppliers();
		HashMap<Integer,String> map=new HashMap<Integer,String>();
		for(Supplier s:slist) {
			map.put(s.getSupplierId(),s.getSupplierName());
		}
		mav.addObject("plist", plist);
		mav.addObject("slist", map);
		return mav;

	}
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView editProdcut(@ModelAttribute @Valid Supplier supplier, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		/*if (result.hasErrors()) {
			return new ModelAndView("product-edit");
		}*/

		ModelAndView mav = new ModelAndView("ReorderReport");
		
		ArrayList<Product> plist=productService.findAllProductBySupplierId(supplier.getSupplierId());
		List<Supplier> slist=supplierService.findAllSuppliers();
		HashMap<Integer,String> map=new HashMap<Integer,String>();
		for(Supplier s:slist) {
			map.put(s.getSupplierId(),s.getSupplierName());
		}
		mav.addObject("plist",plist);
		mav.addObject("slist", map);
		return mav;

	}

}
