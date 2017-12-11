package sg.edu.iss.team8.exception;

public class MyException extends Exception{
	
	private String message="Number only ";
	
	
	

	public String getMessage() {
		return message;
	}




	public void setMessage(String message) {
		this.message = message;
	}




	public MyException(String message) {
		// TODO Auto-generated constructor stub
		this.message = message;
	}
}
