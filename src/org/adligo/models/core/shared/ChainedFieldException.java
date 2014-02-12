package org.adligo.models.core.shared;

/**
 * This is a Exception that can be traced back to a method_name and by proxy it's 
 * field (ie name or last_name).
 * 
 * @author scott
 *
 */
public class ChainedFieldException extends Exception {
	public static final String PLEASE_USE_ONE_OF_THE_CONSTRUCTORS_FOR_THIS_CLASS = "Please use one of the constructors for this class.";
	public static final String CHAINED_FILED_EXCEPTION_REQUIRES_A_ROOT = "ChainedFiledException requires a root";
	public static final String CHAINED_FIELD_EXCEPTION_REQUIRES_A_NON_EMPTY_METHOD_NAME = "ChainedFieldException requires a non empty methodName.";
	public static final String CHAINED_FILED_EXCEPTION_REQUIRES_A_METHOD_NAME = "ChainedFiledException requires a methodName";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String methodName;
	private ChainedFieldException cause;
	private boolean isRoot = true;
	/**
	 * create a new root Exception
	 * @param message
	 * @param pMethodName
	 */
	public ChainedFieldException(String message, String pMethodName) {
		super(message);
		methodName = pMethodName;
	}
	
	public ChainedFieldException(String message, String pMethodName, ChainedFieldException pCause) {
		super(message);
		methodName = pMethodName;
		if (methodName == null) {
			throw new NullPointerException(CHAINED_FILED_EXCEPTION_REQUIRES_A_METHOD_NAME);
		}
		if (methodName.trim().length() == 0) {
			throw new IllegalArgumentException(CHAINED_FIELD_EXCEPTION_REQUIRES_A_NON_EMPTY_METHOD_NAME);
		}
		cause = pCause;
		ChainedFieldException root = cause.getRoot();
		if (root == null) {
			throw new NullPointerException(CHAINED_FILED_EXCEPTION_REQUIRES_A_ROOT);
		}
		isRoot = false;
	}

	public String getMethodName() {
		return methodName;
	}

	public ChainedFieldException getCause() {
		return cause;
	}
	
	public boolean isRoot() {
		return isRoot;
	}
	
	public ChainedFieldException getRoot() {
		if (isRoot) {
			return this;
		}
		if (cause != null) {
			return cause.getRoot();
		}
		return null;
	}
	
	public Throwable initCause(Throwable t) {
		throw new IllegalStateException(PLEASE_USE_ONE_OF_THE_CONSTRUCTORS_FOR_THIS_CLASS);
	}
}
