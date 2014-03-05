package org.adligo.models.core.shared;

import org.adligo.i.util.shared.ClassUtils;
import org.adligo.models.core.shared.util.IdentifiableValidator;

public class ChangeableValidator {

	public static final String REQUIRES_A_NON_NULL_VERSION = "Requires a non null version.";
	public static final String SET_VERSION = "setVersion";
	
	public static boolean validate(I_Changeable changeable) throws ValidationException {
		return validate(changeable, I_Validateable.IS_VALID);
	}
	/**
	 * 
	 * @param changeable
	 * @param methodName
	 * @return true if there is a id and a version, or no id
	 * @throws ValidationException
	 */
	public static boolean validate(I_Changeable changeable, String methodName) throws ValidationException {
		if (IdentifiableValidator.validate((I_Identifiable) changeable, methodName)) {
			Integer version = changeable.getVersion();
			Class clazz = changeable.getClass();
			try {
				validate(version, clazz, methodName);
			} catch (InvalidParameterException ipe) {
				throw new ValidationException(ipe);
			}
			return true;
		} 
		return false;
	}
	
	public static boolean validate(Integer version, Class clazz) throws InvalidParameterException {
		return validate(version, clazz, SET_VERSION);
	}
	
	public static boolean validate(Integer version, Class clazz, String methodName) throws InvalidParameterException {
		if (version == null) {
				throw new InvalidParameterException(ClassUtils.getClassShortName(clazz) + 
							REQUIRES_A_NON_NULL_VERSION, methodName);
		}
		return true;
	}
}
