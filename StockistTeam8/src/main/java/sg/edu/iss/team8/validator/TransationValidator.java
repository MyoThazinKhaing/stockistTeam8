package sg.edu.iss.team8.validator;

import javax.transaction.Transaction;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class TransationValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Transaction.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Transaction transaction = (Transaction) arg0;
		
//		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, field, errorCode);
		
	}

}
