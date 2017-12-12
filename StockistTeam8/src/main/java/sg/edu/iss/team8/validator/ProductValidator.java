package sg.edu.iss.team8.validator;




import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.edu.iss.team8.model.Product;

@Component
public class ProductValidator implements Validator{
	
	
	@Override
	public boolean supports(Class<?> arg0) {
		
		return Product.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		
		Product product = (Product)arg0;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "partNumber","error.product.partNumber.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "unitPrice", "error.product.unitPrice.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description","error.product.description.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "colour", "error.product.colour.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dimension", "error.product.dimension.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "manufacturer", "error.product.manufacturer.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "supplierId", "error.product.supplierId.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reorderLevel", "error.product.reorderLevel.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "minimumReorderQuantity", "error.product.minimumReorderQuantity.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shelfLocation", "error.product.shelflocation.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stock", "error.product.stock.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "status", "error.product.status.empty");



		

		
	}

}
