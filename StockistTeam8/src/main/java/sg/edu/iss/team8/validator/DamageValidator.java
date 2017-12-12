package sg.edu.iss.team8.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import sg.edu.iss.team8.model.Damage;

@Component
public class DamageValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Damage.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Damage damage=(Damage) arg0;	
		if ((damage.getSendDate()!=null && damage.getReceiveDate()!=null)&&(damage.getSendDate().compareTo(damage.getReceiveDate()) > 0)) {
			arg1.reject("receiveDate", "Receive date should be greater than send date.");
			arg1.rejectValue("receiveDate", "error.dates", "receive date cannot prior than send date");
	
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1,"partNumber", "error.partNumber", "Part Number is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "quantity","error.quantity", " ");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "sendDate", "error.sendDate", "Please select the send date.");
		
	}

}