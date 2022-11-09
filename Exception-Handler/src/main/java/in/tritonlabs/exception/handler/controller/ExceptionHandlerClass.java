package in.tritonlabs.exception.handler.controller;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerClass {

	@ExceptionHandler(IllegalAccessError.class)
	
	public String handler(IllegalAccessError e) {
		
		return "This is 2";
		
	}

}
