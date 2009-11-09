package org.adligo.models.core.client;


public class Address {
	protected StorageIdentifier id;
	protected String street_address;
	protected String city;
	/** this is the 2 letter ISO country code */
	protected String country_code;
	/**
	 * this is the iso country sub code ie.. IL is Illinois
	 */
	protected String country_sub_code;
	protected String zip;
	
	private int hash_code;
	
	public Address(Address p) {
		id = p.id;
		street_address = p.street_address;
		city = p.city;
		country_code = p.country_code;
		country_sub_code = p.country_sub_code;
		zip = p.zip;
		hash_code = genHashCode();
	}
	
	public Address() {}
	
	public StorageIdentifier getId() {
		return id;
	}
	
	public String getStreet_address() {
		return street_address;
	}

	public String getCity() {
		return city;
	}

	public String getCountry_code() {
		return country_code;
	}

	public String getCountry_sub_code() {
		return country_sub_code;
	}

	public String getZip() {
		return zip;
	}

	public int hashCode() {
		return hash_code;
	}
	
	protected int genHashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result
				+ ((country_code == null) ? 0 : country_code.hashCode());
		result = prime
				* result
				+ ((country_sub_code == null) ? 0 : country_sub_code.hashCode());
		result = prime * result
				+ ((street_address == null) ? 0 : street_address.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country_code == null) {
			if (other.country_code != null)
				return false;
		} else if (!country_code.equals(other.country_code))
			return false;
		if (country_sub_code == null) {
			if (other.country_sub_code != null)
				return false;
		} else if (!country_sub_code.equals(other.country_sub_code))
			return false;
		if (street_address == null) {
			if (other.street_address != null)
				return false;
		} else if (!street_address.equals(other.street_address))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}

	
}
