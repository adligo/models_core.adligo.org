package org.adligo.models.core.client;

import org.adligo.models.core.client.ids.I_StorageIdentifier;
import org.adligo.models.core.client.ids.StorageIdentifierValidator;

public class StorableValidator {

	public static final String REQUIRES_A_NON_NULL_STORAGE_INFO = " requires a non null storage info.";
	public static final String REQUIRES_A_NON_NULL_VERSION = " requires a non null version.";

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
				Class clazz = identifiable.getClass();
				StorageIdentifierValidator.validateId(id, clazz, methodName);
			} catch (InvalidParameterException ipe) {
				throw new ValidationException(ipe);
			}
		}
		return true;
	}
	
	public static boolean validate(I_Changeable changeable, String methodName) throws ValidationException {
		if (validate((I_Identifiable) changeable, methodName)) {
			Integer version = changeable.getVersion();
			if (version == null) {
				Class clazz = changeable.getClass();
				throw new ValidationException(clazz.getSimpleName() + REQUIRES_A_NON_NULL_VERSION, methodName);
			}
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean validate(I_Storable storable, String methodName) throws ValidationException {
		if (validate((I_Identifiable) storable,  methodName)) {
			try {
				validate((I_Changeable) storable, methodName);
			} catch (ClassCastException x) {
				//do nothing all storables are not changeable
				// GWT didn't impl instanceOf correctly at this time
			}
			I_StorageInfo info = storable.getStorageInfo();
			if (info == null) {
				Class clazz = storable.getClass();
				throw new ValidationException(clazz.getSimpleName() + REQUIRES_A_NON_NULL_STORAGE_INFO, methodName);
			}
			if (info.isValidatable()) {
				((I_Validateable) info).isValid();
			}
			return true;
		} else {
			return false;
		}
	}
}
