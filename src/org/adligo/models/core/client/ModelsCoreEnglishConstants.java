package org.adligo.models.core.client;


public class ModelsCoreEnglishConstants implements I_ModelsCoreConstants {
	public static final String USER_RELATIONS_EMPTY_ROLE = "Can't add a empty role to UserRelations.";
	public static final String USER_RELATIONS_EMPTY_GROUP = "Can't add a empty group to UserRelations.";
	public static final String USER_GROUP_EMPTY_ROLE_TO_USER_GROUP = "Can't add a empty role to UserGroup.";
	
	public static final String THE_COUNTRY_SUBDIVISION_CODE_MUST_BE_4_DIGITS_OR_LESS = "The country subdivision code must be 4 digits or less.";
	public static final String THE_COUNTRY_SUBDIVISION_CODE_MAY_NOT_BE_EMPTY = "The country subdivision code may not be empty.";
	public static final String THE_STREET_FIELD_MAY_NOT_BE_EMPTY = "The street field may not be empty.";
	public static final String THE_POSTAL_CODE_FIELD_MAY_NOT_BE_EMPTY = "The postal code field may not be empty.";
	public static final String THE_COUNTRY_FIELD_MAY_NOT_BE_EMPTY = "The country field may not be empty.";
	public static final String THE_CITY_FIELD_MAY_NOT_BE_EMPTY = "The city field may not be empty.";
	public static final String THE_COUNTRY_FIELD_MUST_BE_2_DIGITS = "The country field must be 2 digits.";

	public static final String DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_LAST_CHARACTER = "Domain can NOT have a dot as its last character.";
	public static final String DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_FIRST_CHARACTER = "Domain can NOT have a dot as its first character.";
	public static final String DOMAIN_CAN_NOT_HAVE_TWO_CONSECUTIVE_DOTS = "Domain can NOT have two consecutive dots ie. (foo..bar).";
	public static final String DOMAIN_TO_SHORT = "Domain to short must be at least 4 characters ie. (a.ok).";
	public static final String DOMAIN_MAY_NOT_CONTAIN_A_SPACE = "Domain may not contain a space.";
	public static final String DOMAIN_MUST_CONTAIN_A_DOT = "Domain must contain a dot ie. (name.com).";
	public static final String DOMAIN_CAN_NOT_BE_EMPTY = "Domain can not be empty.";
	
	public static final String TWO_SHORT = "E-mail is two short to be a real E-mail address. ie. (a@l.ok)";
	public static final String NO_USER = "E-mail must contain a user name before the @ symbol.";
	public static final String SPACE_CHARACTER = "E-mail may NOT contain a space character.";
	public static final String NO_DOMAIN_NAME = "E-mail must have a domain name after the @ symbol.  ie. (adligo.com)";
	public static final String NO_AT_SYMBOL = "E-mail must contain the @ symbol.";
	public static final String E_MAIL_CAN_NOT_BE_EMPTY = "E-mail can NOT be empty.";
	public static final String DOMAIN_ERROR = "There is a issue with the domain portion of the E-mail, after the @ symbol.";

	public static final String ORG_EMPTY_TYPE = "The type field can not be empty.";
	public static final String ORG_EMPTY_NAME = "The name field can not be empty.";

	public static final String PERSON_A_NAME_LAST_NAME_IS_REQUIRED = "A name (last name) is required.";

	public static final String PHONE_NUMBER_MAY_ONLY_HAVE_ARABIC_NUMERALS = "A phone number may only have Arabic numerals ie (0-9).";
	public static final String PHONE_NUMBER_CAN_NOT_BE_EMPTY = "A phone number can not be empty.";
	
	public static final String USER_PASSWORD_CAN_T_BE_EMPTY = "User password can't be set to empty!";
	public static final String USER_DOMAIN_NAME_CANT_BE_EMPTY = "User domain name can't be set to empty!";
	public static final String USER_NAME_CANT_CONTAIN_A_SPACE = "User name can't contain a space character!";
	public static final String USER_NAME_CANT_BE_SET_TO_EMPTY = "User name can't be set to empty!";
	
	public String getAddressCountryCodeWrongSizeError() {
		return THE_COUNTRY_FIELD_MUST_BE_2_DIGITS;
	}

	public String getAddressEmptyCityError() {
		return THE_CITY_FIELD_MAY_NOT_BE_EMPTY;
	}

	public String getAddressEmptyCountryError() {
		return THE_COUNTRY_FIELD_MAY_NOT_BE_EMPTY;
	}

	public String getAddressEmptyPostalError() {
		return THE_POSTAL_CODE_FIELD_MAY_NOT_BE_EMPTY;
	}

	public String getAddressEmptyStreetError() {
		return THE_STREET_FIELD_MAY_NOT_BE_EMPTY;
	}

	public String getAddressEmptySubCodeError() {
		return THE_COUNTRY_SUBDIVISION_CODE_MAY_NOT_BE_EMPTY;
	}

	public String getAddressSubCodeTwoBigError() {
		return THE_COUNTRY_SUBDIVISION_CODE_MUST_BE_4_DIGITS_OR_LESS;
	}
	
	public String getDomainNameEmptyError() {
		return DOMAIN_CAN_NOT_BE_EMPTY;
	}

	
	public String getDomainNameNoDotError() {
		return DOMAIN_MUST_CONTAIN_A_DOT;
	}

	
	public String getDomainNameNoSpaceError() {
		return DOMAIN_MAY_NOT_CONTAIN_A_SPACE;
	}

	
	public String getDomainNameToShortError() {
		return DOMAIN_TO_SHORT;
	}

	
	public String getDomainNameDotCantBeConsecutive() {
		return DOMAIN_CAN_NOT_HAVE_TWO_CONSECUTIVE_DOTS;
	}

	
	public String getDomainNameDotCantBeFirst() {
		return DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_FIRST_CHARACTER;
	}

	
	public String getDomainNameDotCantBeLast() {
		return DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_LAST_CHARACTER;
	}
	
	public String getEmailBadDomainError() {
		return DOMAIN_ERROR;
	}

	public String getEmailEmptyError() {
		return E_MAIL_CAN_NOT_BE_EMPTY;
	}

	public String getEmailNoAtError() {
		return NO_AT_SYMBOL;
	}

	public String getEmailNoDomainError() {
		return NO_DOMAIN_NAME;
	}

	public String getEmailNoSpaceError() {
		return SPACE_CHARACTER;
	}

	public String getEmailNoUserError() {
		return NO_USER;
	}

	
	public String getEmailToShortError() {
		return TWO_SHORT;
	}
	
	public String getOrgEmptyNameError() {
		return ORG_EMPTY_NAME;
	}

	public String getOrgEmptyTypeError() {
		return ORG_EMPTY_TYPE;
	}
	
	public String getPersonNoNameError() {
		return PERSON_A_NAME_LAST_NAME_IS_REQUIRED;
	}

	public String getPhoneEmptyError() {
		return PHONE_NUMBER_CAN_NOT_BE_EMPTY;
	}

	public String getPhoneInvalidCharacterError() {
		return PHONE_NUMBER_MAY_ONLY_HAVE_ARABIC_NUMERALS;
	}
	
	public String getUserNoUserNameMessage() {
		return USER_NAME_CANT_BE_SET_TO_EMPTY;
	}

	public String getUserNoSpaceInNameMessage() {
		return USER_NAME_CANT_CONTAIN_A_SPACE;
	}

	public String getUserNoEmptyDomainMessage() {
		return USER_DOMAIN_NAME_CANT_BE_EMPTY;
	}

	public String getUserNoEmptyPasswordMessage() {
		return USER_PASSWORD_CAN_T_BE_EMPTY;
	}
	
	public String getUserGroupEmptyRoleError() {
		return USER_GROUP_EMPTY_ROLE_TO_USER_GROUP;
	}
	
	public String getUserRelationsEmptyGroupError() {
		return USER_RELATIONS_EMPTY_GROUP;
	}

	public String getUserRelationsEmptyRoleError() {
		return USER_RELATIONS_EMPTY_ROLE;
	}

}
