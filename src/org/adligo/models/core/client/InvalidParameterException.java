package org.adligo.models.core.client;

public class InvalidParameterException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String methodName;
	
	public InvalidParameterException(String p, String methodName) {
		super(p);
		this.methodName = methodName;
	}

	public String getMethodName() {
		return methodName;
	}
}
