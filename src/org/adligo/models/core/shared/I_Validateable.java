package org.adligo.models.core.shared;

public interface I_Validateable {
	public static final String IS_VALID = "isValid";
	
	/**
	 * 
	 * Also note that a entity can either be saved or unsaved.
	 * See StorableValidator.
	 * 
	 * Referent ids should be validated (ie org type)
	 * @return
	 * @throws ValidationException
	 */
	public void isValid() throws ValidationException;
}
