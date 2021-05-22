package br.com.delucahigiene.webservices.services.exception;

public class ResourceNotFoundException extends RuntimeException{

	public static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id  ) {
		
		super("Resource not found. Id: " + id);
		
	}
	
}
