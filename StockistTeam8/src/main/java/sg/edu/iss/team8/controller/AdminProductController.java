package sg.edu.iss.team8.controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
import sg.edu.iss.team8.validator.ProductValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.*;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Controller
@RequestMapping(value = "/product")
public class AdminProductController {

	@Autowired
	ProductService productService;
	@Autowired
	ProductValidator productValidator;
	@Autowired
	SupplierService supplierService;

	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;
	
	@RequestMapping(value = {"/*","/**"}, method = RequestMethod.GET)
	public String general(HttpServletRequest request, HttpSession session) {
		return "redirect:/notfound";
	}

	@RequestMapping(value = "/catalogue", method = RequestMethod.GET)
	public ModelAndView browseCatalogue(HttpSession session, @RequestParam(required = false) Integer page) {

		ModelAndView mav = new ModelAndView("product-catalogue");
		ArrayList<Product> pList = (ArrayList<Product>) productService.findAllProducts();

		PagedListHolder<Product> pagedListHolder = new PagedListHolder<>(pList);
		pagedListHolder.setPageSize(5);
		mav.addObject("maxPages", pagedListHolder.getPageCount());

		mav.addObject("page", page);
		if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(0);
			mav.addObject("pList", pagedListHolder.getPageList());
		} else if (page <= pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(page - 1);
			mav.addObject("pList", pagedListHolder.getPageList());
		}

		return mav;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView searchByDescription(HttpSession session, @RequestParam String criteria,
			@RequestParam String description) {
		if (!new TestController().isUser(session)) {
			return new ModelAndView("403");
		}
		return new ModelAndView("product-catalogue", "pList", productService.searchProducts(criteria, description));
		// return new ModelAndView("product-catalogue", "pList",
		// pService.searchProduct("p.criteria",description));
	}

	@InitBinder("product")
	private void initEmployeeBinder(WebDataBinder binder) {
		binder.addValidators(productValidator);
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newProductPage() {
		ModelAndView mav = new ModelAndView("product-new", "product", new Product());
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		List<Supplier> slist = supplierService.findAllSupplierByStatus();
		for (Supplier s : slist) {
			map.put(s.getSupplierId(), s.getSupplierName());
		}
		/*
		 * mav.addObject("sidlist", supplierService.findAllSupplierIDs());
		 * mav.addObject("sidNamelist", supplierService.findAllSupplierNames());
		 */
		mav.addObject("supplierList", map);
		System.out.println("in create method");
		return mav;

	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewProduct(@ModelAttribute @Valid Product product, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView("product-new");

			HashMap<Integer, String> map = new HashMap<Integer, String>();
			List<Supplier> slist = supplierService.findAllSupplierByStatus();
			for (Supplier s : slist) {
				map.put(s.getSupplierId(), s.getSupplierName());
			}
			mav.addObject("supplierList", map);

			return mav;
		}
		ModelAndView mav = new ModelAndView();
		String message = "New Product " + product.getPartNumber() + " is successfully created";

		productService.createProduct(product);
		mav.setViewName("redirect:/product/list");
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView productListPage() {
		ModelAndView mav = new ModelAndView("product-list");
		List<Product> plist = productService.findAllProducts();
		mav.addObject("plist", plist);
		return mav;

	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editProductPage(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("product-edit");
		Product product = productService.findProductByNo(id);
		mav.addObject("product", product);
		// mav.addObject("plist", productService.findAllSupplierIDs());
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		List<Supplier> slist = supplierService.findAllSupplier();
		for (Supplier s : slist) {
			map.put(s.getSupplierId(), s.getSupplierName());
		}
		mav.addObject("supplierList", map);
		return mav;

	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editProdcut(@ModelAttribute @Valid Product product, BindingResult result, @PathVariable int id,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {

			ModelAndView mav = new ModelAndView("product-edit");

			// Product p1 = productService.findProductByNo(id);
			// mav.addObject("product",p1);

			HashMap<Integer, String> map = new HashMap<Integer, String>();
			List<Supplier> slist = supplierService.findAllSupplier();
			for (Supplier s : slist) {
				map.put(s.getSupplierId(), s.getSupplierName());
			}
			mav.addObject("supplierList", map);

			return mav;
		}

		ModelAndView mav = new ModelAndView("redirect:/product/list");
		String message = "Product was successfully updated.";
		productService.changeProduct(product);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;

	}

}