package org.adligo.models.core.client;

import org.adligo.i.util.client.ClassUtils;

public class ChangeableValidator {

	public static final String REQUIRES_A_NON_NULL_VERSION = "Requires a non null version.";
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
			if (version == null) {
				Class clazz = changeable.getClass();
				throw new ValidationException(ClassUtils.getClassShortName(clazz) + 
							REQUIRES_A_NON_NULL_VERSION, methodName);
			}
			return true;
		} else {
			return false;
		}
	}
}
