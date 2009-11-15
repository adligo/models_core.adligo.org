package org.adligo.models.core.client;

public class AddressMutant extends Address {

	public void setStreet_address(String p) throws InvalidParameterException {
		super.setStreetAddressP(p);
	}

	public void setCity(String p) throws InvalidParameterException {
		super.setCityP(p);
	}

	public void setCountry_code(String p) throws InvalidParameterException{
		super.setCountry_codeP(p);
	}

	public void setCountry_sub_code(String p) throws InvalidParameterException {
		super.setCountry_sub_codeP(p);
	}

	public void setPostal_code(String p) throws InvalidParameterException {
		super.setPostalCodeP(p);
	}
	
	public int hashCode() {
		return super.genHashCode();
	}
}
