package sg.edu.iss.team8.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import sg.edu.iss.team8.service.CustomerServiceImpl;
//import sg.edu.iss.team8.service.CustomerService;
import sg.edu.iss.team8.service.TransactionDetailsService;
import sg.edu.iss.team8.service.TransactionService;

@RequestMapping(value = "/transaction")
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
	
	@RequestMapping(value = {"/*","/**"}, method = RequestMethod.GET)
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
	public ModelAndView showAllTransaction() {
		ModelAndView mav = new ModelAndView("transaction-all");
		ArrayList<TransactionDetails> transDetailList = tdService.findAllTransactions();
		ArrayList<Customer> custList = cService.findAllCustomers();
		ArrayList<Transaction> transList = tService.findAllTransactions();
		mav.addObject("transDetailList", transDetailList);
		mav.addObject("transList", transList);
		mav.addObject("custList", custList);
		return mav;
	}

}