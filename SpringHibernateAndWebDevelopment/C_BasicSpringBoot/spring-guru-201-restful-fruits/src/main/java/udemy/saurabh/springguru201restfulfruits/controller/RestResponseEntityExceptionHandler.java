package udemy.saurabh.springguru201restfulfruits.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import udemy.saurabh.springguru201restfulfruits.model.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
//	if @ControllerAdvice
//	@ExceptionHandler({ResourceNotFoundException.class})
//	public ResponseEntity<Object> handleNotFoundException(ResourceNotFoundException exception, WebRequest request) {
//
//		return new ResponseEntity<>(exception.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
//
//	}

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleNotFoundException(ResourceNotFoundException ex) {
		return ex.getMessage();
	}
}