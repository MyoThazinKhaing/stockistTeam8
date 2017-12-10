package sg.edu.iss.team8.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import sg.edu.iss.team8.model.Product;
import sg.edu.iss.team8.model.User;
import sg.edu.iss.team8.service.ProductService;

@Controller
@RequestMapping(value = "/product")
public class AdminProductController {

	@Autowired
	private ProductService pService;

	@RequestMapping(value = "/catalogue", method = RequestMethod.GET)
	public ModelAndView browseCatalogue(HttpSession session, Model model) {
		//UserSession us = (UserSession) session.getAttribute("USERSESSION");
		ModelAndView mav = new ModelAndView("/product-catalogue");
		mav.addObject("pList", pService.findAllProducts());
		model.addAttribute("product", new Product());
		return mav;
	}
	
	 @RequestMapping(value="/search", method = RequestMethod.POST)
	    public ModelAndView searchByDescription(
	            @RequestParam String description) {
	        return new ModelAndView("product-catalogue", "pList", pService.searchProductByDescrption(description));
	    }
	 }
