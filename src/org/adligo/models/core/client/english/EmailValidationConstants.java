package org.adligo.models.core.client.english;

import org.adligo.models.core.client.i18n.I_EmailValidationConstants;

public class EmailValidationConstants implements I_EmailValidationConstants {
	public static final String TWO_SHORT = "E-mail is two short to be a real E-mail address. ie. (a@l.ok)";
	public static final String NO_USER = "E-mail must contain a user name before the @ symbol.";
	public static final String SPACE_CHARACTER = "E-mail may NOT contain a space character.";
	public static final String NO_DOMAIN_NAME = "E-mail must have a domain name after the @ symbol.  ie. (adligo.com)";
	public static final String NO_AT_SYMBOL = "E-mail must contain the @ symbol.";
	public static final String E_MAIL_CAN_NOT_BE_EMPTY = "E-mail can NOT be empty.";
	public static final String DOMAIN_ERROR = "There is a issue with the domain portion of the E-mail, after the @ symbol.";


	public String getBadDomainError() {
		return DOMAIN_ERROR;
	}

	public String getEmptyError() {
		return E_MAIL_CAN_NOT_BE_EMPTY;
	}

	public String getNoAtError() {
		return NO_AT_SYMBOL;
	}

	public String getNoDomainError() {
		return NO_DOMAIN_NAME;
	}

	public String getNoSpaceError() {
		return SPACE_CHARACTER;
	}

	public String getNoUserError() {
		return NO_USER;
	}

	
	public String getToShortError() {
		return TWO_SHORT;
	}

}
