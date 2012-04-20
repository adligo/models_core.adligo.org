package org.adligo.models.core.client;


public class ModelsCoreEnglishConstants implements I_ModelsCoreConstants {
	public static final String EMAIL_ATTACHMENT_MAY_NOT_BE_EMPTY = "A E-mail attachment may NOT be empty.";
	public static final String EMAIL_ATTACHEMNT_MAY_NOT_BE_NULL = "A E-mail attachemnt may NOT be null.";
	public static final String EMAIL_ADDRESS_IS_NOT_VALID = "E-mail address is not valid.";
	public static final String EMAIL_REQUIRES_A_DESTINATION_ADDRESS = "A E-mail requires a destination address.";
	public static final String EMAIL_REQUIRES_A_VALID_FROM_ADDRESS = "A E-mail requires a valid from address.";
	public static final String EMAIL_REQUIRES_A_FROM_ADDRESS = "A E-mail requires a from address.";
	
	public static final String USER_RELATIONS_EMPTY_ROLE = "Can't add a empty role to UserRelations.";
	public static final String USER_RELATIONS_EMPTY_GROUP = "Can't add a empty group to UserRelations.";
	public static final String USER_GROUP_EMPTY_ROLE_TO_USER_GROUP = "Can't add a empty role to UserGroup.";
	
	public static final String ADDRESS_THE_COUNTRY_SUBDIVISION_CODE_MUST_BE_4_DIGITS_OR_LESS = "The country subdivision code must be 4 digits or less.";
	public static final String ADDRESS_THE_COUNTRY_SUBDIVISION_CODE_MAY_NOT_BE_EMPTY = "The country subdivision code may not be empty.";
	public static final String ADDRESS_THE_STREET_FIELD_MAY_NOT_BE_EMPTY = "The street field may not be empty.";
	public static final String ADDRESS_THE_POSTAL_CODE_FIELD_MAY_NOT_BE_EMPTY = "The postal code field may not be empty.";
	public static final String ADDRESS_THE_COUNTRY_FIELD_MAY_NOT_BE_EMPTY = "The country field may not be empty.";
	public static final String ADDRESS_THE_CITY_FIELD_MAY_NOT_BE_EMPTY = "The city field may not be empty.";
	public static final String ADDRESS_THE_COUNTRY_FIELD_MUST_BE_2_DIGITS = "The country field must be 2 digits.";

	public static final String DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_LAST_CHARACTER = "Domain can NOT have a dot as its last character.";
	public static final String DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_FIRST_CHARACTER = "Domain can NOT have a dot as its first character.";
	public static final String DOMAIN_CAN_NOT_HAVE_TWO_CONSECUTIVE_DOTS = "Domain can NOT have two consecutive dots ie. (foo..bar).";
	public static final String DOMAIN_TO_SHORT = "Domain to short must be at least 4 characters ie. (a.ok).";
	public static final String DOMAIN_MAY_NOT_CONTAIN_A_SPACE = "Domain may not contain a space.";
	public static final String DOMAIN_MUST_CONTAIN_A_DOT = "Domain must contain a dot ie. (name.com).";
	public static final String DOMAIN_CAN_NOT_BE_EMPTY = "Domain can not be empty.";
	
	public static final String EMAIL_ADDRESS_TWO_SHORT = "E-mail is two short to be a real E-mail address. ie. (a@l.ok)";
	public static final String EMAIL_ADDRESS_NO_USER = "E-mail must contain a user name before the @ symbol.";
	public static final String EMAIL_ADDRESS_SPACE_CHARACTER = "E-mail may NOT contain a space character.";
	public static final String EMAIL_ADDRESS_NO_DOMAIN_NAME = "E-mail must have a domain name after the @ symbol.  ie. (adligo.com)";
	public static final String EMAIL_ADDRESS_NO_AT_SYMBOL = "E-mail must contain the @ symbol.";
	public static final String EMAIL_ADDRESS_E_MAIL_CAN_NOT_BE_EMPTY = "E-mail can NOT be empty.";
	public static final String EMAIL_ADDRESS_DOMAIN_ERROR = "There is a issue with the domain portion of the E-mail, after the @ symbol.";

	public static final String ORG_EMPTY_TYPE = "The type field can not be empty.";
	public static final String ORG_EMPTY_NAME = "The name field can not be empty.";

	public static final String PERSON_A_NAME_IS_REQUIRED = "A name is required.";
	public static final String PERSON_A_FIRST_NAME_IS_REQUIRED = "A first name is required.";
	public static final String PERSON_A_MIDDLE_NAME_IS_REQUIRED = "A middle name is required.";
	public static final String PERSON_A_LAST_NAME_IS_REQUIRED = "A last name is required.";
	public static final String PERSON_A_NICK_NAME_IS_REQUIRED = "A nick name is required.";
	public static final String PERSON_GENDER_IS_NOT_VALID = "The gender must be one of (Male, Female, Other).";
	
	
	public static final String PHONE_NUMBER_MAY_ONLY_HAVE_ARABIC_NUMERALS = "A phone number may only have Arabic numerals ie (0-9).";
	public static final String PHONE_NUMBER_CAN_NOT_BE_EMPTY = "A phone number can not be empty.";
	
	public static final String USER_PASSWORD_CAN_T_BE_EMPTY = "User password can't be set to empty!";
	public static final String USER_DOMAIN_NAME_CANT_BE_EMPTY = "User domain name can't be set to empty!";
	public static final String USER_NAME_CANT_CONTAIN_A_SPACE = "User name can't contain a space character!";
	public static final String USER_NAME_CANT_BE_SET_TO_EMPTY = "User name can't be set to empty!";
	
	public String getAddressCountryCodeWrongSizeError() {
		return ADDRESS_THE_COUNTRY_FIELD_MUST_BE_2_DIGITS;
	}

	public String getAddressEmptyCityError() {
		return ADDRESS_THE_CITY_FIELD_MAY_NOT_BE_EMPTY;
	}

	public String getAddressEmptyCountryError() {
		return ADDRESS_THE_COUNTRY_FIELD_MAY_NOT_BE_EMPTY;
	}

	public String getAddressEmptyPostalError() {
		return ADDRESS_THE_POSTAL_CODE_FIELD_MAY_NOT_BE_EMPTY;
	}

	public String getAddressEmptyStreetError() {
		return ADDRESS_THE_STREET_FIELD_MAY_NOT_BE_EMPTY;
	}

	public String getAddressEmptySubCodeError() {
		return ADDRESS_THE_COUNTRY_SUBDIVISION_CODE_MAY_NOT_BE_EMPTY;
	}

	public String getAddressSubCodeTwoBigError() {
		return ADDRESS_THE_COUNTRY_SUBDIVISION_CODE_MUST_BE_4_DIGITS_OR_LESS;
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
	
	public String getEmaiAddressBadDomainError() {
		return EMAIL_ADDRESS_DOMAIN_ERROR;
	}

	public String getEmailAddressEmptyError() {
		return EMAIL_ADDRESS_E_MAIL_CAN_NOT_BE_EMPTY;
	}

	public String getEmailAddressNoAtError() {
		return EMAIL_ADDRESS_NO_AT_SYMBOL;
	}

	public String getEmailAddressNoDomainError() {
		return EMAIL_ADDRESS_NO_DOMAIN_NAME;
	}

	public String getEmailAddressNoSpaceError() {
		return EMAIL_ADDRESS_SPACE_CHARACTER;
	}

	public String getEmailAddressNoUserError() {
		return EMAIL_ADDRESS_NO_USER;
	}

	
	public String getEmailAddressToShortError() {
		return EMAIL_ADDRESS_TWO_SHORT;
	}
	
	public String getOrgEmptyNameError() {
		return ORG_EMPTY_NAME;
	}

	public String getOrgEmptyTypeError() {
		return ORG_EMPTY_TYPE;
	}
	
	public String getPersonNoNameError() {
		return PERSON_A_NAME_IS_REQUIRED;
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

	public String getEMailRequiresADestAddress() {
		return EMAIL_REQUIRES_A_DESTINATION_ADDRESS;
	}

	public String getEMailRequiresAFromAddress() {
		return EMAIL_REQUIRES_A_FROM_ADDRESS;
	}
	
	public String getEMailRequiresAValidAddress() {
		return EMAIL_ADDRESS_IS_NOT_VALID;
	}

	public String getEMailRequiresAValidFromAddress() {
		return EMAIL_REQUIRES_A_VALID_FROM_ADDRESS;
	}
	
	public String getEMailRequiresANonNullAttachemt() {
		return EMAIL_ATTACHEMNT_MAY_NOT_BE_NULL;
	}

	public String getEMailRequiresAValidAttachemt() {
		return EMAIL_ATTACHMENT_MAY_NOT_BE_EMPTY;
	}

	@Override
	public String getPersonNoFirstNameError() {
		return PERSON_A_FIRST_NAME_IS_REQUIRED;
	}

	@Override
	public String getPersonNoMiddleNameError() {
		return PERSON_A_MIDDLE_NAME_IS_REQUIRED;
	}

	@Override
	public String getPersonNoLastNameError() {
		return PERSON_A_LAST_NAME_IS_REQUIRED;
	}

	@Override
	public String getPersonNoNickNameError() {
		// TODO Auto-generated method stub
		return PERSON_A_NICK_NAME_IS_REQUIRED;
	}


	@Override
	public String getPersonMustBeAKnownGenderType() {
		// TODO Auto-generated method stub
		return PERSON_GENDER_IS_NOT_VALID;
	}

}
