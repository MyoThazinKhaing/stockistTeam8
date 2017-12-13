package sg.edu.iss.team8.validator;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.edu.iss.team8.model.Damage;
import sg.edu.iss.team8.service.DamageService;
import sg.edu.iss.team8.service.DamageServiceImpl;
import sg.edu.iss.team8.service.ProductService;
import sg.edu.iss.team8.service.ProductServiceImpl;

@Component
public class DamageValidator implements Validator {
	@Autowired
	private ProductService pService;

	@Override
	public boolean supports(Class<?> arg0) {
		return Damage.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Damage damage = (Damage) arg0;
		if ((damage.getSendDate() != null && damage.getReceiveDate() != null)
				&& (damage.getSendDate().compareTo(damage.getReceiveDate()) > 0)) {
			// arg1.reject("receiveDate", "Receive date should be greater than send date.");
			arg1.rejectValue("receiveDate", "error.dates", "Receive date cannot prior than send date");

		}
		
		
		if ((damage.getQuantity() > pService.findProduct(damage.getPartNumber()).getStock())) {
			arg1.rejectValue("quantity","damage.quantity", "Quantity damaged cannot exceed the stock of "
					+ pService.findProduct(damage.getPartNumber()).getStock());
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "partNumber", "error.partNumber", "Part Number is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "quantity", "error.quantity", " ");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "sendDate", "error.sendDate", "Please select the send date.");

	}

}