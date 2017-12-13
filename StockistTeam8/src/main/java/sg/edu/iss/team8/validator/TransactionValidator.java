package sg.edu.iss.team8.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.edu.iss.team8.model.Transaction;



@Component
public class TransactionValidator implements Validator{
	@Override
	public boolean supports(Class<?> arg0) {
		return Transaction.class.isAssignableFrom(arg0);

	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		Transaction t=new Transaction();
	/*	Course course = (Course) arg0;	
		if ((course.getFromDate()!=null && course.getToDate()!=null)&&(course.getFromDate().compareTo(course.getToDate()) > 0)) {
			arg1.reject("toDate", "End date should be greater than start date.");
			arg1.rejectValue("toDate", "error.dates", "to date must be > from date");
	
		}*/
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "consumeDate", "error.consumeDate", "");
		//ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "toDate", "error.toDate", "To Date is required.");
	}
}
