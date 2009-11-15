package org.adligo.models.core.client.english;

import org.adligo.models.core.client.i18n.I_PersonValidationConstants;

public class PersonValidationConstants implements I_PersonValidationConstants {

	public static final String A_NAME_LAST_NAME_IS_REQUIRED = "A name (last name) is required.";

	public String getNoNameError() {
		return A_NAME_LAST_NAME_IS_REQUIRED;
	}

}
