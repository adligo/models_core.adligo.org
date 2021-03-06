package org.adligo.models.core.shared;

public class InvalidParameterException extends ChainedFieldException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public InvalidParameterException(String message, String methodName) {
		super(message, methodName);
	}

	public InvalidParameterException(String message, String methodName, ChainedFieldException cause) {
		super(message, methodName, cause);
	}
	
	public InvalidParameterException(ChainedFieldException cause) {
		super(cause.getMessage(), cause.getMethodName(), cause);
	}
}
