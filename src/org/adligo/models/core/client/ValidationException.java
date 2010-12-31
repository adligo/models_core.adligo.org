package org.adligo.models.core.client;

/**
 * a structured way to show why the object is not valid
 * (a object that is valid is good enough to be saved to storage)
 * 
 * @author scott
 *
 */
public class ValidationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ValidationException() {}
	
	public ValidationException(String message) {
		super(message);
	}

}
