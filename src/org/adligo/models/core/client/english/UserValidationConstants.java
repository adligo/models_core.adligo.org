package org.adligo.models.core.client.english;

import org.adligo.models.core.client.i18n.I_UserValidationConstants;

/**
 * for j2se and j2me, and GWT 
 * 
 * contrary to 
 * http://google-web-toolkit.googlecode.com/svn/javadoc/1.5/com/google/gwt/i18n/client/Constants.html
 * I have a default impl
 * 
 * If you wanted to use the GWT method in the above url
 * have your GWT init code do something like;
 * 
 * ConstantsFactory.put(I_UserValidationConstants.class, GWT.create(X));
 * where X extends I_UserValidationConstants and Constants the GWT class
 * 
 * or better yet do it in a lazy (just in time) way
 * 
 * @author scott
 *
 * 
 */
public class UserValidationConstants implements I_UserValidationConstants {

	public static final String USER_PASSWORD_CAN_T_BE_EMPTY = "User password can't be set to empty!";
	public static final String USER_DOMAIN_NAME_CANT_BE_EMPTY = "User domain name can't be set to empty!";
	public static final String USER_NAME_CANT_CONTAIN_A_SPACE = "User name can't contain a space character!";
	public static final String USER_NAME_CANT_BE_SET_TO_EMPTY = "User name can't be set to empty!";

	public String getNoUserNameMessage() {
		return USER_NAME_CANT_BE_SET_TO_EMPTY;
	}

	public String getNoSpaceInNameMessage() {
		return USER_NAME_CANT_CONTAIN_A_SPACE;
	}

	public String getNoEmptyDomainMessage() {
		return USER_DOMAIN_NAME_CANT_BE_EMPTY;
	}

	public String getNoEmptyPasswordMessage() {
		return USER_PASSWORD_CAN_T_BE_EMPTY;
	}

	public String getNullUserIdMessage() {
		return "User id can't be set to null!";
	}

	public String getUserIdWithOutValueMessage() {
		return "User id can't be set to a StorageIdentifier with out a value ";
	}

	public String getNoEmptyUserEmailMessage() {
		return "User email can't be empty!";
	}

	public String getNoUserEmailWithoutAtMessage() {
		return "User email must contain the @ symbol.";
	}

	public String getNoUserEmailWithSpaceMessage() {
		return "User email can't contain a space character!";
	}

	public String getNoUserEmailWithTabMessage() {
		return "User email can't contain a tab character!";
	}

	public String getUserEmailTwoShortMessage() {
		return "User email is two short to be a email.";
	}

	public String getUserMustContainDot() {
		return "User email must contain a dot.";
	}
}
