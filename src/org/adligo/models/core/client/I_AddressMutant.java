package org.adligo.models.core.client;

public interface I_AddressMutant extends I_Address {
	public void setStreetAddress(String p) throws InvalidParameterException ;
	public void setCity(String p) throws InvalidParameterException ;
	public void setCountryCode(String p) throws InvalidParameterException ;
	public void setCountrySubCode(String p) throws InvalidParameterException ;
	public void setPostalCode(String p) throws InvalidParameterException ;
}