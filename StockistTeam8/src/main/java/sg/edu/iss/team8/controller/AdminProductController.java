package sg.edu.iss.team8.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.*;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.edu.iss.team8.model.Product;
import sg.edu.iss.team8.model.Supplier;
import sg.edu.iss.team8.model.User;
import sg.edu.iss.team8.service.ProductService;
import sg.edu.iss.team8.service.SupplierService;

@Controller
@RequestMapping(value = "/product")
public class AdminProductController {

	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;

	@RequestMapping(value = "/**", method = RequestMethod.GET)
	public String firstTime(HttpServletRequest request, HttpSession session) {
		Map<RequestMappingInfo, HandlerMethod> mapping = requestMappingHandlerMapping.getHandlerMethods();
		return new TestController().testURL(request, session, mapping);
	}

	@RequestMapping(value = "/catalog")
	public ModelAndView viewProductCatalog(HttpSession session) {
		if (!new TestController().isUser(session)) {
			return new ModelAndView("403");
		}
		return new ModelAndView("products-catalog");
	}

	@Autowired
	private ProductService pService;
	
	@Autowired
	private SupplierService sService;

	@RequestMapping(value = "/catalogue", method = RequestMethod.GET)
	public ModelAndView browseCatalogue(HttpSession session, @RequestParam(required = false) Integer page) {
		if (!new TestController().isUser(session)) {
			return new ModelAndView("403");
		}
		// UserSession us = (UserSession) session.getAttribute("USERSESSION");
		ModelAndView mav = new ModelAndView("product-catalogue");
		ArrayList<Product> pList = (ArrayList<Product>) pService.findAllProducts();
		//mav.addObject("pList", pList);
		PagedListHolder<Product> pagedListHolder = new PagedListHolder<>(pList);
		pagedListHolder.setPageSize(8);
		mav.addObject("maxPages", pagedListHolder.getPageCount());
		
		//if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1;

		mav.addObject("page", page);
        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
            mav.addObject("pList", pagedListHolder.getPageList());
        }
        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
            mav.addObject("pList", pagedListHolder.getPageList());
        }
		
		return mav;
	}
	
	

	@RequestMapping(value = "/catalogue", method = RequestMethod.POST)
	public ModelAndView searchProducts(HttpSession session, @RequestParam String criteria,
			@RequestParam String description) {
		if (!new TestController().isUser(session)) {
			return new ModelAndView("403");
		}
		return new ModelAndView("product-catalogue", "pList", pService.searchProducts(criteria, description));
		// return new ModelAndView("product-catalogue", "pList",
		// pService.searchProduct("p.criteria",description));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewProductDetails(HttpSession session, @PathVariable String id) {
		if (!new TestController().isUser(session)) {
			return new ModelAndView("403");
		}
		ModelAndView mav = new ModelAndView("product-view");
		Product p = pService.findProduct(Integer.parseInt(id));
		Supplier s = sService.findSupplier(p.getSupplierId());
		
		mav.addObject("product", p);
		mav.addObject("supplier", s);
		
		
		return mav;
	}
	
	
}
