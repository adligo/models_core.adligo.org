package org.adligo.models.core.shared;

import org.adligo.i.util.shared.ClassUtils;
import org.adligo.models.core.shared.ids.I_StorageIdentifier;
import org.adligo.models.core.shared.ids.StorageIdentifierValidator;

public class StorableValidator {

	public static final String REQUIRES_A_NON_NULL_STORAGE_INFO = " requires a non null storage info.";
	public static final String REQUIRES_A_NON_NULL_VERSION = " requires a non null version.";

	
	/**
	 * 
	 * @param storable
	 * @param methodName
	 * @return return true if there is a id, version and info, or if there is no id
	 * 
	 * @throws ValidationException
	 */
	public static boolean validate(I_Storable storable, String methodName) throws ValidationException {

		if (IdentifiableValidator.validate(storable,  methodName)) {
			try {
				if (!ChangeableValidator.validate((I_Changeable) storable, methodName)) {
					return false;
				}
			} catch (ClassCastException x) {
				//do nothing all storables are not changeable
				// GWT didn't impl instanceOf correctly at this time
			}
			I_StorageInfo info = storable.getStorageInfo();
			if (info == null) {
				Class clazz = storable.getClass();
				throw new ValidationException(ClassUtils.getClassShortName(clazz) + 
							REQUIRES_A_NON_NULL_STORAGE_INFO, methodName);
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
