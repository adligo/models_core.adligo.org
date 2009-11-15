package org.adligo.models.core.client.english;

import org.adligo.models.core.client.i18n.I_AddressValidationConstants;

public class AddressValidationConstants implements I_AddressValidationConstants {

	public static final String THE_COUNTRY_SUBDIVISION_CODE_MUST_BE_4_DIGITS_OR_LESS = "The country subdivision code must be 4 digits or less.";
	public static final String THE_COUNTRY_SUBDIVISION_CODE_MAY_NOT_BE_EMPTY = "The country subdivision code may not be empty.";
	public static final String THE_STREET_FIELD_MAY_NOT_BE_EMPTY = "The street field may not be empty.";
	public static final String THE_POSTAL_CODE_FIELD_MAY_NOT_BE_EMPTY = "The postal code field may not be empty.";
	public static final String THE_COUNTRY_FIELD_MAY_NOT_BE_EMPTY = "The country field may not be empty.";
	public static final String THE_CITY_FIELD_MAY_NOT_BE_EMPTY = "The city field may not be empty.";
	public static final String THE_COUNTRY_FIELD_MUST_BE_2_DIGITS = "The country field must be 2 digits.";

	public String getCountryCodeWrongSizeError() {
		return THE_COUNTRY_FIELD_MUST_BE_2_DIGITS;
	}

	public String getEmptyCityError() {
		return THE_CITY_FIELD_MAY_NOT_BE_EMPTY;
	}

	public String getEmptyCountryError() {
		return THE_COUNTRY_FIELD_MAY_NOT_BE_EMPTY;
	}

	public String getEmptyPostalError() {
		return THE_POSTAL_CODE_FIELD_MAY_NOT_BE_EMPTY;
	}

	public String getEmptyStreetError() {
		return THE_STREET_FIELD_MAY_NOT_BE_EMPTY;
	}

	public String getEmptySubCodeError() {
		return THE_COUNTRY_SUBDIVISION_CODE_MAY_NOT_BE_EMPTY;
	}

	public String getSubCodeTwoBigError() {
		return THE_COUNTRY_SUBDIVISION_CODE_MUST_BE_4_DIGITS_OR_LESS;
	}
}
