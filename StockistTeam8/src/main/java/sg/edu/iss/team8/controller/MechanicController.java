package sg.edu.iss.team8.controller;

import java.sql.Date;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.edu.iss.team8.model.Customer;
import sg.edu.iss.team8.model.Product;
import sg.edu.iss.team8.model.Transaction;
import sg.edu.iss.team8.model.TransactionDetails;
import sg.edu.iss.team8.model.User;
import sg.edu.iss.team8.repository.CustomerRepository;
import sg.edu.iss.team8.repository.TransactionRepository;
import sg.edu.iss.team8.service.CustomerService;
import sg.edu.iss.team8.service.CustomerServiceImpl;
import sg.edu.iss.team8.service.ProductService;
//import sg.edu.iss.team8.service.CustomerService;
import sg.edu.iss.team8.service.TransactionDetailsService;
import sg.edu.iss.team8.service.TransactionService;
import sg.edu.iss.team8.validator.TransactionValidator;

@RequestMapping(value = "/transaction")
@Controller
public class MechanicController {
	static int transId;
	String partNumber=null;

	@Autowired
	 ProductService pService;

	@Autowired
	private TransactionService tService;
	@Autowired
	private TransactionDetailsService tdService;

	@Autowired
	private CustomerService cService;
	
	 @Autowired
	 TransactionValidator transactionValidator;

	@InitBinder("transaction")
	private void initCourseBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		binder.addValidators(transactionValidator);

	}

	static Transaction t = null;
	static {
		t = new Transaction();
		transId=0;
	}

	@RequestMapping(value = { "/*", "/**" }, method = RequestMethod.GET)
	public String general(HttpServletRequest request, HttpSession session) {
		return "redirect:/notfound";
	}

	@RequestMapping(value = "/list/{pNo}", method = RequestMethod.GET)
	public ModelAndView showProductTransaction(@PathVariable int pNo) {
		ModelAndView mav = new ModelAndView("transaction-history");
		ArrayList<TransactionDetails> transDetailList = tdService.findTransactionDetailsByPartNumber(pNo);

		ArrayList<Customer> custList = cService.findAllCustomers();
		ArrayList<Transaction> transList = tService.findAllTransactions();

		mav.addObject("transDetailList", transDetailList);
		mav.addObject("transList", transList);
		mav.addObject("custList", custList);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView showAllTransaction(@RequestParam(required = false) Integer page) {
		ModelAndView mav = new ModelAndView("transaction-all");
		ArrayList<TransactionDetails> transDetailList = tdService.findAllTransactions();
		ArrayList<Customer> custList = cService.findAllCustomers();
		ArrayList<Transaction> transList = tService.findAllTransactions();
		
		PagedListHolder<TransactionDetails> pagedListHolder = new PagedListHolder<>(transDetailList);
		pagedListHolder.setPageSize(8);
		mav.addObject("maxPages", pagedListHolder.getPageCount());

		mav.addObject("page", page);
		if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(0);
			mav.addObject("transDetailList", pagedListHolder.getPageList());
		} else if (page <= pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(page - 1);
			mav.addObject("transDetailList", pagedListHolder.getPageList());
		}
		
		mav.addObject("transList", transList);
		mav.addObject("custList", custList);
		return mav;
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
			final RedirectAttributes redirectAttributes, HttpServletRequest request ,HttpSession session) {
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
			 System.out.println("Bind Error");
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
		
		if(t.getCustomerId()==transaction.getCustomerId()&&t.getConsumeDate().compareTo(transaction.getConsumeDate())==0) {
			partNumber = request.getParameter("product");
			String quantity = request.getParameter("quantity");
			Product p=pService.findProduct(Integer.parseInt(partNumber));
			if(Integer.parseInt(quantity)>p.getStock()) {
				
			}
			
			
			//and set to transationdetails object:
			TransactionDetails tdetails = new TransactionDetails();
			tdetails.setTransactionId(t.getTransactionId());
			tdetails.setPartNumber(Integer.parseInt(partNumber));
	
			try {
			tdetails.setQuantity(Integer.parseInt(quantity));
			}catch(NumberFormatException e) {
				
			}
			//t.setTransactionId(t.getTransactionId()+1);
			tdService.createTransaction(tdetails);
			System.out.println("if block-----");
			
			
			
		}
		else {
		
		Transaction lastRow=	tService.findLastRow();
		transaction.setTransactionId(lastRow.getTransactionId()+1);
		/*String condate=request.getParameter("consumedate");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			transaction.setConsumeDate(dateFormat.parse(condate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		*/
		UserSession us = (UserSession) request.getSession().getAttribute("USERSESSION");
		User u = us.getUser();
		transaction.setUserName(u.getUsername());
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
		 transDet=tdService.findAllTransactions();
		mav.addObject("transDetail",transDet);
		//transationdetails attirbute received from httprequest  
		
		//pService.UpdateStock(Integer.parseInt(partNumber), p.getStock()-Integer.parseInt(quantity));
		String message = "New transaction " + transaction.getTransactionId() + " was successfully created.";

		//mav.setViewName("redirect:/mechanic/list");
    System.out.println("Out side if-else block...------");
		redirectAttributes.addFlashAttribute("message", "");
		//mav.clear();
		return mav;
		
	}

}