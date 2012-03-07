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
	protected String street_address;
	protected String city;
	/** this is the 2 letter ISO country code */
	protected String country_code;
	/**
	 * this is the iso country sub code ie.. IL is Illinois
	 */
	protected String country_sub_code;
	/**
	 * zip code for us 
	 * each country seems to have there own
	 * http://en.wikipedia.org/wiki/Postal_code
	 */
	protected String postal_code;
	
	protected transient Integer hash_code;
	
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
			InvalidParameterException ipe = new InvalidParameterException(x.getMessage(), ADDRESS);
			ipe.initCause(x);
			throw ipe;
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
		return street_address;
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
		return country_code;
	}

	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_Address#getCountrySubCode()
	 */
	public String getCountrySubCode() {
		return country_sub_code;
	}

	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_Address#getPostalCode()
	 */
	public String getPostalCode() {
		return postal_code;
	}

	public int hashCode() {
		if (hash_code == null) {
			hash_code = new Integer(genHashCode());
		}
		return hash_code.intValue();
	}
	
	public void setId(I_StorageIdentifier p_id) throws InvalidParameterException{
		id = CommonModel.getIdMutantClone(p_id);
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
		street_address = p;
	}
	
	public void setPostalCode(String p) throws InvalidParameterException{
		if (StringUtils.isEmpty(p)) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getAddressEmptyPostalError(),SET_POSTAL_CODE);
		}
		postal_code = p;
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
		country_code = p;
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
		country_sub_code = p;
	}
	
	int genHashCode() {
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
		result = prime * result + ((postal_code == null) ? 0 : postal_code.hashCode());
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
		if (country_code == null) {
			if (other.getCountryCode() != null)
				return false;
		} else if (!country_code.equals(other.getCountryCode()))
			return false;
		if (country_sub_code == null) {
			if (other.getCountrySubCode() != null)
				return false;
		} else if (!country_sub_code.equals(other.getCountrySubCode()))
			return false;
		if (street_address == null) {
			if (other.getStreetAddress() != null)
				return false;
		} else if (!street_address.equals(other.getStreetAddress()))
			return false;
		if (postal_code == null) {
			if (other.getPostalCode() != null)
				return false;
		} else if (!postal_code.equals(other.getPostalCode()))
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
		sb.append(street_address);
		sb.append(",city=");
		sb.append(city);
		sb.append(",country_code=");
		sb.append(country_code);
		sb.append(",country_sub_code=");
		sb.append(country_sub_code);
		sb.append(",postal_code=");
		sb.append(postal_code);
		sb.append("]");
		return sb.toString();
	}
	
	public boolean isMutable() {
		return true;
	}
}
