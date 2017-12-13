package sg.edu.iss.team8.validator;


public class MappingValidator {
	public static final String[] ADMIN_ONLY = new String[] 
					{"user",
					"edit",
					"create",
					"delete",
					"supplier",
					"reorder",
					"damage"};
	
	public static final String[] ALL_USER = new String[] 
			{"transaction"};
	
	public static final String[] LIST_PAGE = new String[]
			{"catalogue", "list"};
	
	public static final String[] PUBLIC = new String[] {"/login"};
	
	
}
