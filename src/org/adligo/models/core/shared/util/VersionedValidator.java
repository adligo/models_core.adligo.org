package org.adligo.models.core.shared.util;

import org.adligo.i.util.shared.ClassUtils;
import org.adligo.models.core.shared.I_Versioned;
import org.adligo.models.core.shared.I_Identifiable;
import org.adligo.models.core.shared.I_Validateable;
import org.adligo.models.core.shared.ValidationException;

public class VersionedValidator {
	public static final String REQUIRES_A_NON_NULL_VERSION = "Requires a non null version.";
	
	public static boolean validate(I_Versioned changeable) throws ValidationException {
		return validate(changeable, I_Validateable.IS_VALID);
	}
	/**
	 * 
	 * @param changeable
	 * @param methodName
	 * @return true if there is a id and a version, or no id
	 * @throws ValidationException
	 */
	public static boolean validate(I_Versioned changeable, String methodName) throws ValidationException {
		if (IdentifiableValidator.validate((I_Identifiable) changeable, methodName)) {
			Integer version = changeable.getVersion();
			Class clazz = changeable.getClass();
			if (version == null) {
				throw new ValidationException(ClassUtils.getClassShortName(clazz) + 
						REQUIRES_A_NON_NULL_VERSION, methodName);
			}
			return true;
		} 
		return false;
	}
}
