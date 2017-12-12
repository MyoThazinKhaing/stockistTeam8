package sg.edu.iss.team8.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.edu.iss.team8.model.Supplier;
import sg.edu.iss.team8.service.SupplierService;
import sg.edu.iss.team8.validator.SupplierValidator;

@RequestMapping(value="/supplier")
@Controller
public class AdminSupplierController {

	@Autowired
	private SupplierService sService;
	
	@Autowired
	private SupplierValidator sValidator;
	
	@InitBinder("supplier")
	private void initSupplierBinder(WebDataBinder binder) {
		/*SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));*/
		binder.addValidators(sValidator);

	}
	
	@RequestMapping(value = {"/*","/**"}, method = RequestMethod.GET)
	public String general(HttpServletRequest request, HttpSession session) {
		return "redirect:/notfound";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView supplierListPage(@RequestParam(required = false) Integer page) {
		Supplier s=new Supplier();
		ModelAndView mav = new ModelAndView("supplier-list", "supplier", s);
		
		List<Supplier> supplierList = sService.findAllSuppliers();
		//mav.addObject("supplierList", supplierList);
		
		PagedListHolder<Supplier> pagedListHolder = new PagedListHolder<>(supplierList);
		pagedListHolder.setPageSize(4);
		mav.addObject("maxPages", pagedListHolder.getPageCount());
		mav.addObject("page", page);
		if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(0);
			mav.addObject("supplierList", pagedListHolder.getPageList());
		} else if (page <= pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(page - 1);
			mav.addObject("supplierList", pagedListHolder.getPageList());
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newStudentPage() {
		Supplier s=new Supplier();
		ModelAndView mav = new ModelAndView("supplier-new", "supplier", s);
		//mav.addObject("supplier", sService.createSupplier(s));
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewSupplier(@ModelAttribute @Valid Supplier supplier, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("supplier-new");

		ModelAndView mav = new ModelAndView();
		String message = "New supplier " + supplier.getSupplierId() + " was successfully created.";

		sService.createSupplier(supplier);
		mav.setViewName("redirect:/supplier/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/edit/{supplierId}", method = RequestMethod.GET)
	public ModelAndView editSupplierPage(@PathVariable String supplierId) {
		ModelAndView mav = new ModelAndView("supplier-edit");
		Supplier supplier = sService.findSupplier(Integer.parseInt(supplierId));
		mav.addObject("supplier", supplier);
		mav.addObject("supplierlist", sService.findAllSuppliers());
		return mav;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editSupplier(@ModelAttribute @Valid Supplier supplier, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("supplier-edit");

		ModelAndView mav = new ModelAndView();
		String message = "Supplier " + supplier.getSupplierId() + " was successfully updated.";

		sService.changeSupplier(supplier);
		mav.setViewName("redirect:/supplier/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/searchByName/{supplierName}", method = RequestMethod.POST)
	public ModelAndView editSupplier(@ModelAttribute @Valid Supplier supplier, BindingResult result,
			@PathVariable String supplierName, final RedirectAttributes redirectAttributes)  {

		/*if (result.hasErrors())
			return new ModelAndView("supplier-edit");*/

		ModelAndView mav = new ModelAndView("supplier-list");
		List<Supplier> supplierList = sService.searchSupplierByName(supplier.getSupplierName());
		mav.addObject("supplierList", supplierList);
		return mav;
	}
	
	
}