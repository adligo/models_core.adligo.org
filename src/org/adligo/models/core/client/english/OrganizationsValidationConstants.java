package org.adligo.models.core.client.english;

import org.adligo.models.core.client.i18n.I_OrganizationValidationConstants;

public class OrganizationsValidationConstants implements I_OrganizationValidationConstants {

	public static final String THE_TYPE_FIELD_CAN_NOT_BE_EMPTY = "The type field can not be empty.";
	public static final String THE_NAME_FIELD_CAN_NOT_BE_EMPTY = "The name field can not be empty.";

	public String getEmptyNameError() {
		return THE_NAME_FIELD_CAN_NOT_BE_EMPTY;
	}

	public String getEmptyTypeError() {
		return THE_TYPE_FIELD_CAN_NOT_BE_EMPTY;
	}

}
