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

	
//	private void initEmployeeBinder(WebDataBinder binder) {
//	@InitBinder("transaction")
//	private void initTransactionBinder(WebDataBinder binder) {
//		// binder.addValidators(eValidator);
//	}
	
//	@InitBinder("customer")
//	private void initCustomerBinder(WebDataBinder binder) {
//		// binder.addValidators(eValidator);
//	}

//	@InitBinder("transaction")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newTransactionPage() {
		ModelAndView mav = new ModelAndView("transaction-new");
		mav.addObject("transaction", new Transaction());
		mav.addObject("transDetails", new TransactionDetails());
		
		// require the findAllUserName method
//		mav.addObject("eidlist", tService.findAllTransactionIDs());
		mav.addObject("custlist", cService.findAllCustomerIDs());
		// require the findAllUserName method
		
		// require the findAllUserName method OR autopopulate username
//		mav.addObject("eidlist", cService.findAllCustomerIDs());
		// require the findAllUserName method OR autopopulate username
		return mav;

		// ModelAndView mav = new ModelAndView("transaction-new", "customer", new
		// Customer());
		// mav.addObject("eidlist", tService.findAllCustomerIDs());
		// return mav;
	}

//	@InitBinder("transaction")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewTransaction(@ModelAttribute @Valid Transaction transaction, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("transaction-new");

		ModelAndView mav = new ModelAndView();
		String message = "New transaction " + transaction.getTransactionId() + " was successfully created.";

		tService.createTransaction(transaction);
		
//		for(TransactionDetails t : )
//		{
//			
//		}
			
		// require to create foreach action for transaction details
		// transactiondetails
		mav.setViewName("redirect:/mechanic/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	// @GetMapping("/choosecustomer")
//	@InitBinder("customer")
	@RequestMapping(value = "/choosecustomer", method = RequestMethod.GET)
	public ModelAndView chooseCustomerPage() {/*@ModelAttribute @Valid Customer customer*/
		// require the CustomerService interface
		ModelAndView mav = new ModelAndView("transaction-choose-customer","customer", new Customer()/*ArrayList<Customer>()*/);

		mav.addObject("custlist", cService.findAllCustomerIDs());

		//mav.addObject("custlist", tService.findAllTransactionIDs());
		// comment out above line when CustomerService interface added
		return mav;
	}

//	@InitBinder("customer")
	@RequestMapping(value = "/choosecustomer", method = RequestMethod.POST)
	public ModelAndView chooseCustomer(@ModelAttribute @Valid Customer customer, BindingResult result,
			@PathVariable String id, final RedirectAttributes redirectAttributes) /* throws EmployeeNotFound */ {

		if (result.hasErrors())
			return new ModelAndView("transaction-choose-customer");

		ModelAndView mav = new ModelAndView("redirect:/mechanic/create");
		mav.addObject("customerchosen", customer); // require the getCustomerId method from Customer class
		// String message = "Employee was successfully updated.";
		// eService.changeEmployee(employee);

		// redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	// @RequestMapping(value = "/create", method = RequestMethod.GET)
	// public ModelAndView newEmployeePage() {
	// ModelAndView mav = new ModelAndView("employee-new", "employee", new
	// Employee());
	// mav.addObject("eidlist", eService.findAllEmployeeIDs());
	// return mav;
	// }

	// @RequestMapping(value = "/createtransaction")
	// public ModelAndView createTransaction(HttpSession session) {
	//
	// UserSession us = (UserSession) session.getAttribute("USERSESSION");
	// HashMap<Transaction,TransactionDetails> submap = new
	// HashMap<Transaction,TransactionDetails>();
	//
	// //for (Employee subordinate : us.getSubordinates()) {
	// //submap.put(subordinate,
	// //cService.findCoursesByEID(subordinate.getEmployeeId()));
	// //}
	// ModelAndView mav = new ModelAndView("login");
	// if (us.getSessionId() != null && us.getSubordinates() != null) {
	// mav = new ModelAndView("/transactioncomplete");
	// mav.addObject("submap", submap);
	// return mav;
	// }
	// return mav;
	//
	// }

}
