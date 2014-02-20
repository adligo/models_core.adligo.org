package org.adligo.models.core.shared.util;

import org.adligo.models.core.shared.I_Identifiable;
import org.adligo.models.core.shared.I_StorageIdentifier;
import org.adligo.models.core.shared.InvalidParameterException;
import org.adligo.models.core.shared.ValidationException;


public class IdentifiableValidator {
	/**
	 * @param storable
	 * @param clazz
	 * @param methodName
	 * @return true if the storable is stored (has a id)
	 * @throws ValidationException
	 */
	public static boolean validate(I_Identifiable identifiable, String methodName) throws ValidationException {
		I_StorageIdentifier id = identifiable.getId();
		if (id == null) {
			return false;
		} else {
			try {
				//no generics as this can jme
				Class clazz = identifiable.getClass();
				StorageIdentifierValidator.validateId(id, clazz, methodName);
			} catch (InvalidParameterException ipe) {
				throw new ValidationException(ipe);
			}
		}
		return true;
	}
}
