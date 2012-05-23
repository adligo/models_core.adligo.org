package org.adligo.models.core.client;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.StringUtils;
import org.adligo.models.core.client.ids.I_StorageIdentifier;


public class AddressMutant implements I_AddressMutant {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ADDRESS = "Address";
	public static final String SET_POSTAL_CODE = "setPostal_code";
	public static final String SET_STREET_ADDRESS = "setStreet_address";
	public static final String SET_CITY = "setCity";
	public static final String SET_COUNTRY_SUB_CODE = "setCountry_sub_code";
	public static final String SET_COUNTRY_CODE = "setCountry_code";
	
	protected I_StorageIdentifier id;
	protected String streetAddress;
	protected String city;
	/** this is the 2 letter ISO country code */
	protected String countryCode;
	/**
	 * this is the iso country sub code ie.. IL is Illinois
	 */
	protected String countrySubCode;
	/**
	 * zip code for us 
	 * each country seems to have there own
	 * http://en.wikipedia.org/wiki/Postal_code
	 */
	protected String postalCode;
	
	public AddressMutant(I_Address p) throws InvalidParameterException {
		try {
			if (p.getId() != null) {
				setId(p.getId());
			}
			setStreetAddress(p.getStreetAddress());
			setCity(p.getCity());
			setCountryCode(p.getCountryCode());
			setCountrySubCode(p.getCountrySubCode());
			setPostalCode(p.getPostalCode());
		} catch (InvalidParameterException x) {
			throw new InvalidParameterException(x.getMessage(), ADDRESS, x);
		}
	}
	
	/**
	 * for gwt serialization
	 */
	public AddressMutant() {}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_Address#getId()
	 */
	public I_StorageIdentifier getId() {
		return id;
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_Address#getStreetAddress()
	 */
	public String getStreetAddress() {
		return streetAddress;
	}

	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_Address#getCity()
	 */
	public String getCity() {
		return city;
	}

	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_Address#getCountryCode()
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_Address#getCountrySubCode()
	 */
	public String getCountrySubCode() {
		return countrySubCode;
	}

	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_Address#getPostalCode()
	 */
	public String getPostalCode() {
		return postalCode;
	}

	public int hashCode() {
		return genHashCode();
	}
	
	public void setId(I_StorageIdentifier p_id) throws InvalidParameterException{
		if (p_id == null) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getStorageIdRequired(),SET_ID);
		}
		id = p_id;
	}
	
	public void setCity(String p) throws InvalidParameterException{
		if (StringUtils.isEmpty(p)) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getAddressEmptyCityError(),SET_CITY);
		}
		city = p;
	}
	
	public void setStreetAddress(String p) throws InvalidParameterException{
		if (StringUtils.isEmpty(p)) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getAddressEmptyStreetError(),SET_STREET_ADDRESS);
		}
		streetAddress = p;
	}
	
	public void setPostalCode(String p) throws InvalidParameterException{
		if (StringUtils.isEmpty(p)) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getAddressEmptyPostalError(),SET_POSTAL_CODE);
		}
		postalCode = p;
	}
	
	public void setCountryCode(String p) throws InvalidParameterException{
		if (StringUtils.isEmpty(p)) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getAddressEmptyCountryError(),SET_COUNTRY_CODE);
		}
		if (p.length() != 2) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getAddressCountryCodeWrongSizeError(),SET_COUNTRY_CODE);
		}
		countryCode = p;
	}

	public void setCountrySubCode(String p) throws InvalidParameterException {
		if (StringUtils.isEmpty(p)) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getAddressEmptySubCodeError(),
					SET_COUNTRY_SUB_CODE);
		}
		if (p.length() > 4) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getAddressSubCodeTwoBigError(),
					SET_COUNTRY_SUB_CODE);
		}
		countrySubCode = p;
	}
	
	int genHashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result
				+ ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime
				* result
				+ ((countrySubCode == null) ? 0 : countrySubCode.hashCode());
		result = prime * result
				+ ((streetAddress == null) ? 0 : streetAddress.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if ( !(obj instanceof I_Address))
			return false;
		final I_Address other = (I_Address) obj;
		if (city == null) {
			if (other.getCity() != null)
				return false;
		} else if (!city.equals(other.getCity()))
			return false;
		if (countryCode == null) {
			if (other.getCountryCode() != null)
				return false;
		} else if (!countryCode.equals(other.getCountryCode()))
			return false;
		if (countrySubCode == null) {
			if (other.getCountrySubCode() != null)
				return false;
		} else if (!countrySubCode.equals(other.getCountrySubCode()))
			return false;
		if (streetAddress == null) {
			if (other.getStreetAddress() != null)
				return false;
		} else if (!streetAddress.equals(other.getStreetAddress()))
			return false;
		if (postalCode == null) {
			if (other.getPostalCode() != null)
				return false;
		} else if (!postalCode.equals(other.getPostalCode()))
			return false;
		return true;
	}

	public boolean isValid() {
		try {
			new AddressMutant(this);
			return true;
		} catch (InvalidParameterException e) {
			//do nothing
		}
		return false;
	}

	public String toString() {
		return toString(this.getClass());
	} 
	
	public String toString(Class c) {
		StringBuffer sb = new StringBuffer();
		sb.append(ClassUtils.getClassShortName(c));
		sb.append(" [id=");
		sb.append(id);
		sb.append(",street_address=");
		sb.append(streetAddress);
		sb.append(",city=");
		sb.append(city);
		sb.append(",country_code=");
		sb.append(countryCode);
		sb.append(",country_sub_code=");
		sb.append(countrySubCode);
		sb.append(",postal_code=");
		sb.append(postalCode);
		sb.append("]");
		return sb.toString();
	}
	
	public boolean isMutable() {
		return true;
	}
}
