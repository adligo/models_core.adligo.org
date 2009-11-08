package org.adligo.models.core.client.english;

import org.adligo.models.core.client.i18n.I_DomainNameValidationConstants;

public class DomainValidationConstants implements I_DomainNameValidationConstants {

	public static final String DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_LAST_CHARACTER = "Domain can NOT have a dot as its last character.";
	public static final String DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_FIRST_CHARACTER = "Domain can NOT have a dot as its first character.";
	public static final String DOMAIN_CAN_NOT_HAVE_TWO_CONSECUTIVE_DOTS = "Domain can NOT have two consecutive dots ie. (foo..bar).";
	public static final String DOMAIN_TO_SHORT = "Domain to short must be at least 4 characters ie. (a.ok).";
	public static final String DOMAIN_MAY_NOT_CONTAIN_A_SPACE = "Domain may not contain a space.";
	public static final String DOMAIN_MUST_CONTAIN_A_DOT = "Domain must contain a dot ie. (name.com).";
	public static final String DOMAIN_CAN_NOT_BE_EMPTY = "Domain can not be empty.";

	
	public String getEmptyError() {
		return DOMAIN_CAN_NOT_BE_EMPTY;
	}

	
	public String getNoDotError() {
		return DOMAIN_MUST_CONTAIN_A_DOT;
	}

	
	public String getNoSpaceError() {
		return DOMAIN_MAY_NOT_CONTAIN_A_SPACE;
	}

	
	public String getToShortError() {
		return DOMAIN_TO_SHORT;
	}

	
	public String getDotCantBeConsecutive() {
		return DOMAIN_CAN_NOT_HAVE_TWO_CONSECUTIVE_DOTS;
	}

	
	public String getDotCantBeFirst() {
		return DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_FIRST_CHARACTER;
	}

	
	public String getDotCantBeLast() {
		return DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_LAST_CHARACTER;
	}

}
