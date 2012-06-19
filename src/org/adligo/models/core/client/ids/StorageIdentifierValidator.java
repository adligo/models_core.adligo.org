package org.adligo.models.core.client.ids;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.models.core.client.InvalidParameterException;

/**
 * Note end users should never see these errors so 
 * they are NOT i18n
 * 
 * 
 * @author scott
 *
 */
public class StorageIdentifierValidator {

	public static final String REQUIRES_A_ID_WITH_A_VALUE_IN = " requires a id with a value in ";
	public static final String REQUIRES_A_NON_NULL_ID_IN = " requires a non null id in ";

	public static void validateId(I_StorageIdentifier id, Class callingClass, String methodName) throws InvalidParameterException {
		if (id == null) {
			throw new InvalidParameterException(ClassUtils.getClassShortName(callingClass) + 
					REQUIRES_A_NON_NULL_ID_IN + methodName, methodName);
		}
		if (!id.hasValue()) {
			throw new InvalidParameterException(ClassUtils.getClassShortName(callingClass) + 
					REQUIRES_A_ID_WITH_A_VALUE_IN + methodName, methodName);
		}
	}
	
	public static void validateIdAllowingNull(I_StorageIdentifier id, Class callingClass, String methodName) throws InvalidParameterException {
		if (id == null) {
			return;
		} else {
			if (!id.hasValue()) {
				throw new InvalidParameterException(ClassUtils.getClassShortName(callingClass) + 
						REQUIRES_A_ID_WITH_A_VALUE_IN + methodName, methodName);
			}
		}
	}
}
