package sg.edu.iss.team8.controller;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import sg.edu.iss.team8.model.Product;
import sg.edu.iss.team8.service.ProductService;

@RequestMapping("/admin/product")
@Controller
public class AdminProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newProductPage()
	{
		ModelAndView mav = new ModelAndView("product-new", "product", new Product());
		mav.addObject("pidlist", productService.findAllProductIDs());
		return mav;
		
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewProduct(@ModelAttribute Product product,BindingResult result, 
			final RedirectAttributes redirectAttributes){
		if(result.hasErrors())
		{
			return new ModelAndView("product-new");
		}
		ModelAndView mav = new ModelAndView();
		String message = "New Product "+product.getPartNumber()+" is successfully created";
		
		productService.createProduct(product);
		mav.setViewName("redirect:admin/product/list");
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value="/list", method= RequestMethod.GET)
	public ModelAndView productListPage() 
	{
		ModelAndView mav = new ModelAndView("product-list");
	  List<Product> plist =	productService.findAllProducts();
	   mav.addObject("plist",plist);
		return mav;
		
	}
	
	
	

}
