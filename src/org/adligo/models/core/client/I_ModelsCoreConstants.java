package org.adligo.models.core.client;

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
	
	public String getEmailEmptyError();
	public String getEmailNoAtError();
	public String getEmailNoUserError();
	public String getEmailNoDomainError();
	public String getEmailToShortError();
	public String getEmailNoSpaceError();
	public String getEmailBadDomainError();
	
	public String getOrgEmptyNameError();
	public String getOrgEmptyTypeError();
	
	public String getPersonNoNameError();
	
	public String getPhoneEmptyError();
	public String getPhoneInvalidCharacterError();
	
	public String getUserNoUserNameMessage();
	public String getUserNoSpaceInNameMessage();
	public String getUserNoEmptyDomainMessage();
	public String getUserNoEmptyPasswordMessage();
	
	public String getUserGroupEmptyRoleError();
	
	public String getUserRelationsEmptyGroupError();
	public String getUserRelationsEmptyRoleError();
}
