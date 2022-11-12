package in.tirtonlabs.exeption.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> error(NullPointerException e) {
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);

	}

}
