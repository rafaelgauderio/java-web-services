package br.com.delucahigiene.webservices.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.delucahigiene.webservices.services.exception.DatabaseException;
import br.com.delucahigiene.webservices.services.exception.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException error, HttpServletRequest httpRequest) {
		String Defaulterror = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError standardError = new StandardError(Instant.now(), status.value(), Defaulterror, error.getMessage(), httpRequest.getRequestURI()); 
		return ResponseEntity.status(status).body(standardError);
	}
	
	
		
		@ExceptionHandler(DatabaseException.class)
		public ResponseEntity<StandardError> database(DatabaseException error, HttpServletRequest httpRequest) {
			String Defaulterror = "Resource not found";
			HttpStatus status = HttpStatus.BAD_REQUEST;
			StandardError standardError = new StandardError(Instant.now(), status.value(), Defaulterror, error.getMessage(), httpRequest.getRequestURI()); 
			return ResponseEntity.status(status).body(standardError);
		}	

}
