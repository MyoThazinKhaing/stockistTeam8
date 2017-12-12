package sg.edu.iss.team8.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.edu.iss.team8.model.Customer;
import sg.edu.iss.team8.model.Product;
import sg.edu.iss.team8.model.Transaction;
import sg.edu.iss.team8.model.TransactionDetails;
import sg.edu.iss.team8.service.CustomerService;
import sg.edu.iss.team8.service.ProductService;
import sg.edu.iss.team8.service.TransactionDetailsService;
import sg.edu.iss.team8.service.TransactionService;
import sg.edu.iss.team8.validator.TransationValidator;

@RequestMapping(value = "/mechanic")
@Controller
public class MechanicController {

	@Autowired
	 ProductService pService;
	@Autowired
	 TransactionService tService;
	@Autowired
	 TransactionDetailsService tdService;
	 @Autowired
	  CustomerService cService;
	 @Autowired
	  UserSession uService;
	 @Autowired
	 TransationValidator transactionValidator;
	

/*@InitBinder("transaction")
private void initTransactionBinder(WebDataBinder binder) {
 binder.addValidators(transactionValidator);
}*/
	
//	@InitBinder("customer")
//	private void initCustomerBinder(WebDataBinder binder) {
//		// binder.addValidators(eValidator);
//	}
	 static Transaction t=null;
	 static 
	 {
		 t=new Transaction();
	 }
	 @RequestMapping(value = "/create", method = RequestMethod.GET)
		public ModelAndView newTransactionPage() {
			ModelAndView mav = new ModelAndView("transaction-new");
			//mav.addObject("transactionform", new TransactionForm());
			//mav.addObject("transactionform");
			
			mav.addObject("transaction", new Transaction());
			HashMap<Integer,String> map=new HashMap<Integer,String>();
			List<Customer> clist=cService.findAllCustomers();
			for(Customer c:clist) {
				map.put(c.getCustomerId(), c.getCustomerName());
			}
			mav.addObject("custlist",map);
		
			List<Product> plist=pService.findAllProducts();
			mav.addObject("plist",plist);
			System.out.println("Create get");
			List<TransactionDetails> transDet=tdService.findAllTransactions();
			mav.addObject("transDetail",transDet);
			return mav;

	 }

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewTransaction(@ModelAttribute("transaction") @Valid Transaction transaction, BindingResult result,
			final RedirectAttributes redirectAttributes, HttpServletRequest request ) {
		ModelAndView mav = new ModelAndView("transaction-new");
		HashMap<Integer,String> map=new HashMap<Integer,String>();
		List<Customer> clist=cService.findAllCustomers();
		for(Customer c:clist) {
			map.put(c.getCustomerId(), c.getCustomerName());
		}
		mav.addObject("custlist",map);
	
		List<Product> plist=pService.findAllProducts();
		mav.addObject("plist",plist);
		List<TransactionDetails> transDet=tdService.findAllTransactions();
		mav.addObject("transDetail",transDet);
		System.out.println("start of post method");
		
		
		if (result.hasErrors()) {
			 mav.setViewName("transaction-new");
			 return mav;
		}
		
		//mav.addObject("custlist", cService.findAllCustomerIDs());
		
		//mav.addObject("transactionform");
		//mav.addObject("transaction");
		
		//String message = "New transaction " + transactionForm.getTransaction().getTransactionId() + " was successfully created.";
/*
		TransactionDetails a = new TransactionDetails(transactionForm.getTransaction().getTransactionId(), 
				transactionForm.getTransactiondetails().getPartNumber(),
				transactionForm.getTransactiondetails().getQuantity()); */
		
		
		//tService.createTransaction(transactionForm.getTransaction());
		//tdService.createTransaction(a);
		
		
		//&&t.getConsumeDate().compareTo(transaction.getConsumeDate())==0
		
		if(t.getCustomerId()==transaction.getCustomerId()) {
			String partNumber = request.getParameter("product");
			String quantity = request.getParameter("quantity");
			//and set to transationdetails object:
			TransactionDetails tdetails = new TransactionDetails();
			tdetails.setTransactionId(t.getTransactionId());
			tdetails.setPartNumber(Integer.parseInt(partNumber));
			tdetails.setQuantity(Integer.parseInt(quantity));
			t.setTransactionId(t.getTransactionId()+1);
			tdService.createTransaction(tdetails);
			System.out.println("if block-----");
			
		}
		else {
		Transaction lastRow=	tService.findLastRow();
		transaction.setTransactionId(lastRow.getTransactionId()+1);
			 t=	tService.createTransaction(transaction);
			 System.out.println("else block-----");
			 String partNumber = request.getParameter("product");
				String quantity = request.getParameter("quantity");
				//and set to transationdetails object:
				TransactionDetails tdetails = new TransactionDetails();
				tdetails.setTransactionId(t.getTransactionId());
				tdetails.setPartNumber(Integer.parseInt(partNumber));
				tdetails.setQuantity(Integer.parseInt(quantity));
				
				tdService.createTransaction(tdetails);
				
		}
		
		//transationdetails attirbute received from httprequest  
		
		
		String message = "New transaction " + transaction.getTransactionId() + " was successfully created.";

		//mav.setViewName("redirect:/mechanic/list");
     System.out.println("Out side if-else block...------");
		//redirectAttributes.addFlashAttribute("message", message);
		//mav.clear();
		return mav;
		
	}


//	@RequestMapping(value = "/choosecustomer", method = RequestMethod.GET)
//	public ModelAndView chooseCustomerPage() {
//		ModelAndView mav = new ModelAndView("transaction-choose-customer","customer", new Customer());
//
//		mav.addObject("custlist", cService.findAllCustomerIDs());
//
//		return mav;
//	}
//
//	@RequestMapping(value = "/choosecustomer", method = RequestMethod.POST)
//	public ModelAndView chooseCustomer(@ModelAttribute @Valid Customer customer, BindingResult result,
//			@PathVariable String id, final RedirectAttributes redirectAttributes){
//
//		if (result.hasErrors())
//			return new ModelAndView("transaction-choose-customer");
//
//		ModelAndView mav = new ModelAndView("redirect:/mechanic/create");
//		mav.addObject("customerchosen", customer); 
//		return mav;
//	}

}
