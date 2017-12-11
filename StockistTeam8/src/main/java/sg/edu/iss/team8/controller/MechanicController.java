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
//import sg.edu.iss.team8.service.CustomerService;
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
	/*
	 * @Autowired private CustomerService cService;
	 */

	@RequestMapping(value = "/transactions/{pNo}", method = RequestMethod.GET)
	public ModelAndView newTransactionDetailsPage(@PathVariable int pNo) {
		// ModelAndView mav = new ModelAndView("transaction-history",
		// "transactionDetails", new TransactionDetails());

		// mav.addObject("translist",
		// tdService.findTransactionDetailsByPartNumber(pNo));
		// return mav;
		ModelAndView mav = new ModelAndView("transaction-history");
		ArrayList<TransactionDetails> transDetailList = tdService.findTransactionDetailsByPartNumber(pNo);
		// mav.addObject("transactionDetailsList", transDetailList);
		ArrayList<Integer> transIdList = new ArrayList<Integer>();
		for (TransactionDetails td : transDetailList) {
			transIdList.add(td.getTransactionId());
		}
		ArrayList<Transaction> transList = new ArrayList<Transaction>();
		for (Integer tId : transIdList) {
			transList.add(tService.findTransaction(tId));
		}
		mav.addObject("transDetailList", transDetailList);
		mav.addObject("transIdList", transIdList);
		mav.addObject("transList", transList);
		return mav;
	}

}