package sg.edu.iss.team8.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.edu.iss.team8.model.User;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User u = (User) target;
		ValidationUtils.rejectIfEmpty(errors, "username", "error.user.username.empty");
//		ValidationUtils.rejectIfEmpty(errors, "employeeId", "error.user.employeeid.empty");
		ValidationUtils.rejectIfEmpty(errors, "role", "error.user.role.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "error.user.password.empty");
		ValidationUtils.rejectIfEmpty(errors, "status", "error.user.status.empty");

		System.out.println(u.toString());
	}


}