package org.adligo.models.core.client;

public class AddressMutant implements I_Address, I_StorageMutant {
	private Address wrapped;
	
	public AddressMutant() {
		wrapped = new Address();
	}

	public AddressMutant(I_Address other) throws InvalidParameterException {
		wrapped = new Address(other);
	}
	
	public void setStreet_address(String p) throws InvalidParameterException {
		wrapped.setStreetAddressP(p);
	}

	public void setCity(String p) throws InvalidParameterException {
		wrapped.setCityP(p);
	}

	public void setCountry_code(String p) throws InvalidParameterException{
		wrapped.setCountry_codeP(p);
	}

	public void setCountry_sub_code(String p) throws InvalidParameterException {
		wrapped.setCountry_sub_codeP(p);
	}

	public void setPostal_code(String p) throws InvalidParameterException {
		wrapped.setPostalCodeP(p);
	}
	
	public int hashCode() {
		return wrapped.genHashCode();
	}

	public void setId(StorageIdentifier id) throws InvalidParameterException {
		wrapped.setIdP(id);
	}

	public boolean equals(Object obj) {
		return wrapped.equals(obj);
	}

	public String getCity() {
		return wrapped.getCity();
	}

	public String getCountry_code() {
		return wrapped.getCountry_code();
	}

	public String getCountry_sub_code() {
		return wrapped.getCountry_sub_code();
	}

	public I_StorageIdentifier getId() {
		return wrapped.getId();
	}

	public String getPostal_code() {
		return wrapped.getPostal_code();
	}

	public String getStreet_address() {
		return wrapped.getStreet_address();
	}

	public boolean isValid() {
		return wrapped.isValid();
	}

	public String toString() {
		return wrapped.toString(this.getClass());
	}
}
