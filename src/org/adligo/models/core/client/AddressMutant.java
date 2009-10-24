package org.adligo.models.core.client;

import java.io.Serializable;

public class AddressMutant extends Address implements Serializable  {
	private static final long serialVersionUID = 1L;

	public void setStreet_address(String p) {
		street_address = p;
	}

	public void setCity(String p) {
		city = p;
	}

	public void setCountry_code(String p) throws InvalidParameterException{
		if (p == null) {
			throw new InvalidParameterException("A country code may not be null!","setCountry_code");
		}
		if (p.length() != 2) {
			throw new InvalidParameterException("A country code must be 2 digits!","setCountry_code");
		}
		country_code = p;
	}

	public void setCountry_sub_code(String p) throws InvalidParameterException {
		if (p == null) {
			throw new InvalidParameterException("A country subdivision code may not be null (use empty string or don't call)!",
					"setCountry_sub_code");
		}
		if (p.length() > 4) {
			throw new InvalidParameterException("A country subdivision code must be 4 digits or less!",
					"setCountry_sub_code");
		}
		country_sub_code = p;
	}

	public void setZip(String p) {
		zip = p;
	}
	
	public int hashCode() {
		return super.genHashCode();
	}
}
