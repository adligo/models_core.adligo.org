package org.adligo.models.core.client;

/**
 * a structured way to show why the object is not valid
 * (a object that is valid is good enough to be saved to storage)
 * 
 * @author scott
 *
 */
public class ValidationException extends ChainedFieldException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	public ValidationException(String message, String methodName) {
		super(message, methodName);
	}

	public ValidationException(String message, String methodName, ChainedFieldException cause) {
		super(message, methodName, cause);
	}
	public ValidationException(ChainedFieldException cause) {
		super(cause.getMessage(), cause.getMethodName(), cause);
	}
}
