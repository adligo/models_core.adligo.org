package org.adligo.models.core.client.english;

import org.adligo.models.core.client.i18n.I_PhoneNumberValidationConstants;

public class PhoneNumberValidationConstants implements I_PhoneNumberValidationConstants {

	public static final String PHONE_NUMBER_MAY_ONLY_HAVE_ARABIC_NUMERALS = "A phone number may only have Arabic numerals ie (0-9).";
	public static final String PHONE_NUMBER_CAN_NOT_BE_EMPTY = "A phone number can not be empty.";

	public String getEmptyError() {
		return PHONE_NUMBER_CAN_NOT_BE_EMPTY;
	}

	public String getInvalidCharacterError() {
		return PHONE_NUMBER_MAY_ONLY_HAVE_ARABIC_NUMERALS;
	}

}
