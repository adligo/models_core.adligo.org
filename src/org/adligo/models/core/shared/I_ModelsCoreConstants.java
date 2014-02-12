package org.adligo.models.core.shared;

/**
 * this is for i118 in GWT or other java apps (which would look up the users language from the local RAM memory cache)
 *
 * @author scott
 *
 */
public interface I_ModelsCoreConstants {
	public String getAddressEmptyCityError();
	public String getAddressEmptyStreetError();
	public String getAddressEmptyPostalError();
	public String getAddressEmptyCountryError();
	public String getAddressCountryCodeWrongSizeError();
	public String getAddressEmptySubCodeError();
	public String getAddressSubCodeTwoBigError();
	
	public String getDomainNameEmptyError();
	public String getDomainNameNoDotError();
	public String getDomainNameToShortError();
	public String getDomainNameNoSpaceError();
	public String getDomainNameDotCantBeFirst();
	public String getDomainNameDotCantBeLast();
	public String getDomainNameDotCantBeConsecutive();
	
	public String getEmailAddressEmptyError();
	public String getEmailAddressNoAtError();
	public String getEmailAddressNoUserError();
	public String getEmailAddressNoDomainError();
	public String getEmailAddressToShortError();
	public String getEmailAddressNoSpaceError();
	public String getEmaiAddressBadDomainError();
	
	public String getEMailRequiresAFromAddress();
	public String getEMailRequiresAValidAddress();
	public String getEMailRequiresAValidFromAddress();
	public String getEMailRequiresADestAddress();
	public String getEMailRequiresANonNullAttachemt();
	public String getEMailRequiresAValidAttachemt();
			
	public String getOrgEmptyNameError();
	public String getOrgEmptyTypeError();
	
	public String getPersonNoNameError();
	public String getPersonNoFirstNameError();
	public String getPersonNoMiddleNameError();
	public String getPersonNoLastNameError();
	public String getPersonNoNickNameError();
	public String getPersonMustBeAKnownGenderType();
	
	public String getPhoneEmptyError();
	public String getPhoneInvalidCharacterError();
	
	public String getUserNoUserNameMessage();
	public String getUserNoSpaceInNameMessage();
	public String getUserNoEmptyDomainMessage();
	public String getUserNoEmptyPasswordMessage();
	
	public String getUserGroupEmptyRoleError();
	
	public String getUserRelationsEmptyGroupError();
	public String getUserRelationsEmptyRoleError();
	
	public String getEndOfDateRangeMustBeAfterStart();
	public String getStartOfDateRangeMustBeBeforeEnd();
	public String getDateRangeRequiresStartValue();
	public String getDateRangeRequiresEndValue();
}
