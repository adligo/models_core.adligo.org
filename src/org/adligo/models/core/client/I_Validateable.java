package org.adligo.models.core.client;

public interface I_Validateable {
	/**
	 * never return false here, always throw a ValidationException
	 * to show why it's not valid
	 * @return
	 * @throws ValidationException
	 */
	public boolean isValid() throws ValidationException;
}
