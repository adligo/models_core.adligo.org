package org.adligo.models.core.client;

import org.adligo.models.core.client.ids.I_StorageIdentifier;

public class Address implements I_Address {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AddressMutant wrapped;
	
	public Address() {
		wrapped = new AddressMutant();
	}

	public Address(I_Address other) throws InvalidParameterException {
		wrapped = new AddressMutant(other);
	}
	
	public int hashCode() {
		return wrapped.genHashCode();
	}

	public boolean equals(Object obj) {
		return wrapped.equals(obj);
	}

	public String getCity() {
		return wrapped.getCity();
	}

	public String getCountryCode() {
		return wrapped.getCountryCode();
	}

	public String getCountrySubCode() {
		return wrapped.getCountrySubCode();
	}

	public I_StorageIdentifier getId() {
		return wrapped.getId();
	}

	public String getPostalCode() {
		return wrapped.getPostalCode();
	}

	public String getStreetAddress() {
		return wrapped.getStreetAddress();
	}

	public boolean isValid() {
		return wrapped.isValid();
	}

	public String toString() {
		return wrapped.toString(this.getClass());
	}

	@Override
	public boolean isMutable() {
		return false;
	}
}
