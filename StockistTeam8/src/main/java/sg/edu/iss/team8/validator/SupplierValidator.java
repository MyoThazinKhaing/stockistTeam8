package sg.edu.iss.team8.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.edu.iss.team8.model.Supplier;



@Component
public class SupplierValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return Supplier.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "supplierName", "error.supplierName", "Supplier name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "address", "error.address", "Address is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "country", "error.country", "Country is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "contactNumber", "error.contactNumber", "Contact Number is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "contactName", "error.contactName", "Contact Name is required.");


		
	}

}
