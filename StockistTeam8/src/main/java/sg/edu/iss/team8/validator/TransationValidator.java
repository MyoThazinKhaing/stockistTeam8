package sg.edu.iss.team8.validator;

import javax.transaction.Transaction;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.edu.iss.team8.model.TransAndTransDetails;

@Component
public class TransationValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return TransAndTransDetails.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Transaction transaction = (Transaction) arg0;
		
	ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "transactionDetails.quantity", "error.courseName", "Quantity is required.");
		
	}

}
