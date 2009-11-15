package org.adligo.models.core.client;

import org.adligo.i.adi.client.I_Invoker;
import org.adligo.i.adi.client.Registry;
import org.adligo.i.util.client.StringUtils;
import org.adligo.models.core.client.i18n.I_AddressValidationConstants;

import com.google.gwt.user.client.rpc.IsSerializable;


public class Address implements IsSerializable, I_Validateable, I_Storable {
	public static final String ADDRESS = "Address";
	public static final String SET_POSTAL_CODE = "setPostal_code";
	public static final String SET_STREET_ADDRESS = "setStreet_address";
	public static final String SET_CITY = "setCity";
	public static final String SET_COUNTRY_SUB_CODE = "setCountry_sub_code";
	public static final String SET_COUNTRY_CODE = "setCountry_code";

	private static final I_Invoker CONSTANTS_FACTORY = 
		Registry.getInvoker(ModelInvokerNames.CONSTANTS_FACTORY);
	
	protected StorageIdentifier id;
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
	
	private int hash_code;
	
	public Address(Address p) throws InvalidParameterException {
		try {
			if (p.id != null) {
				setIdP(p.id);
			}
			setStreetAddressP(p.street_address);
			setCityP(p.city);
			setCountry_codeP(p.country_code);
			setCountry_sub_codeP(p.country_sub_code);
			setPostalCodeP(p.postal_code);
			hash_code = genHashCode();
		} catch (InvalidParameterException x) {
			throw new InvalidParameterException(x.getMessage(), ADDRESS);
		}
	}
	
	/**
	 * for gwt serialization
	 */
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

	public String getPostal_code() {
		return postal_code;
	}

	public int hashCode() {
		return hash_code;
	}
	
	private I_AddressValidationConstants getConstants() {
		I_AddressValidationConstants constants = (I_AddressValidationConstants) 
						CONSTANTS_FACTORY.invoke(I_AddressValidationConstants.class);
		return constants;
	}
	
	protected void setIdP(StorageIdentifier p_id) throws InvalidParameterException{
		id = new StorageIdentifier(p_id);
	}
	
	protected void setCityP(String p) throws InvalidParameterException{
		I_AddressValidationConstants csts = getConstants();
		if (StringUtils.isEmpty(p)) {
			throw new InvalidParameterException(csts.getEmptyCityError(),SET_CITY);
		}
		city = p;
	}
	
	protected void setStreetAddressP(String p) throws InvalidParameterException{
		I_AddressValidationConstants csts = getConstants();
		if (StringUtils.isEmpty(p)) {
			throw new InvalidParameterException(csts.getEmptyStreetError(),SET_STREET_ADDRESS);
		}
		street_address = p;
	}
	
	protected void setPostalCodeP(String p) throws InvalidParameterException{
		I_AddressValidationConstants csts = getConstants();
		if (StringUtils.isEmpty(p)) {
			throw new InvalidParameterException(csts.getEmptyPostalError(),SET_POSTAL_CODE);
		}
		postal_code = p;
	}
	
	protected void setCountry_codeP(String p) throws InvalidParameterException{
		I_AddressValidationConstants csts = getConstants();
		if (StringUtils.isEmpty(p)) {
			throw new InvalidParameterException(csts.getEmptyCountryError(),SET_COUNTRY_CODE);
		}
		if (p.length() != 2) {
			throw new InvalidParameterException(csts.getCountryCodeWrongSizeError(),SET_COUNTRY_CODE);
		}
		country_code = p;
	}

	protected void setCountry_sub_codeP(String p) throws InvalidParameterException {
		I_AddressValidationConstants csts = getConstants();
		if (StringUtils.isEmpty(p)) {
			throw new InvalidParameterException(csts.getEmptySubCodeError(),
					SET_COUNTRY_SUB_CODE);
		}
		if (p.length() > 4) {
			throw new InvalidParameterException(csts.getSubCodeTwoBigError(),
					SET_COUNTRY_SUB_CODE);
		}
		country_sub_code = p;
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
		result = prime * result + ((postal_code == null) ? 0 : postal_code.hashCode());
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
		if (postal_code == null) {
			if (other.postal_code != null)
				return false;
		} else if (!postal_code.equals(other.postal_code))
			return false;
		return true;
	}

	public boolean isValid() {
		try {
			new Address(this);
			return true;
		} catch (InvalidParameterException e) {
			//do nothing
		}
		return false;
	}

	
}
