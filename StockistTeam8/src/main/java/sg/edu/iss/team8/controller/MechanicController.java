package sg.edu.iss.team8.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.edu.iss.team8.model.Customer;
import sg.edu.iss.team8.model.Transaction;
import sg.edu.iss.team8.model.TransactionDetails;
import sg.edu.iss.team8.repository.CustomerRepository;
import sg.edu.iss.team8.repository.TransactionRepository;
import sg.edu.iss.team8.service.CustomerService;
import sg.edu.iss.team8.service.TransactionDetailsService;
import sg.edu.iss.team8.service.TransactionService;

@RequestMapping(value = "/mechanic")
@Controller
public class MechanicController {
	

	 @Resource
	 TransactionRepository trepo;
	 @Resource
	 CustomerRepository crepo;

	@Autowired
	private TransactionService tService;
	@Autowired
	private TransactionDetailsService tdService;
	 @Autowired
	 private CustomerService cService;
	 @Autowired
	 private UserSession uService;

	
//	private void initEmployeeBinder(WebDataBinder binder) {
//	@InitBinder("transaction")
//	private void initTransactionBinder(WebDataBinder binder) {
//		// binder.addValidators(eValidator);
//	}
	
//	@InitBinder("customer")
//	private void initCustomerBinder(WebDataBinder binder) {
//		// binder.addValidators(eValidator);
//	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newTransactionPage() {
		ModelAndView mav = new ModelAndView("transaction-new");
		mav.addObject("transaction", new Transaction());
		mav.addObject("transDetails", new TransactionDetails());
		
		mav.addObject("custlist", cService.findAllCustomerIDs());
//		mav.addObject("eidlist", uService.getUser().getUsername());
		return mav;

	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewTransaction(@ModelAttribute @Valid Transaction transaction,@ModelAttribute @Valid TransactionDetails transactionDetails, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("transaction-new");

		ModelAndView mav = new ModelAndView();
		String message = "New transaction " + transaction.getTransactionId() + " was successfully created.";

		tService.createTransaction(transaction);
		transactionDetails.setTransactionId(transaction.getTransactionId());
		tdService.createTransaction(transactionDetails);
		
//		for(TransactionDetails t : )
//		{
//			
//		}
			
		mav.setViewName("redirect:/mechanic/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/choosecustomer", method = RequestMethod.GET)
	public ModelAndView chooseCustomerPage() {
		ModelAndView mav = new ModelAndView("transaction-choose-customer","customer", new Customer());

		mav.addObject("custlist", cService.findAllCustomerIDs());

		return mav;
	}

	@RequestMapping(value = "/choosecustomer", method = RequestMethod.POST)
	public ModelAndView chooseCustomer(@ModelAttribute @Valid Customer customer, BindingResult result,
			@PathVariable String id, final RedirectAttributes redirectAttributes){

		if (result.hasErrors())
			return new ModelAndView("transaction-choose-customer");

		ModelAndView mav = new ModelAndView("redirect:/mechanic/create");
		mav.addObject("customerchosen", customer); 
		return mav;
	}

}
