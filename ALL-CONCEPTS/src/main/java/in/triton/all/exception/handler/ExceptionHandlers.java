package in.triton.all.exception.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.webjars.NotFoundException;
import in.triton.all.api.response.ApiResponse;
import in.triton.all.exception.IncorrectException;
import in.triton.all.exception.ResourceAlreadyExists;
import in.triton.all.exception.ResourceNotFound;

@RestControllerAdvice
public class ExceptionHandlers{

	@ExceptionHandler(ResourceAlreadyExists.class)
	public ApiResponse error(ResourceAlreadyExists e) {
		 return  new ApiResponse(null, e.getMessage(),"Fail",406);
	}
	
	@ExceptionHandler(ResourceNotFound.class)
	public ApiResponse error(ResourceNotFound e) {
		 return  new ApiResponse(null, e.getMessage(),"Fail",404);
	}
	
	
	@ExceptionHandler(NotFoundException.class)
	public ApiResponse error(NotFoundException e) {
		 return  new ApiResponse(null, e.getMessage(),"Fail",404);
	} 
	
	@ExceptionHandler(IncorrectException.class)
	public ApiResponse error(IncorrectException e) {
		 return  new ApiResponse(null, e.getMessage(),"Fail",422);
	} 
	
	
	
}
