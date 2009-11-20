package org.adligo.models.core.client;

public interface I_Address extends I_Storable, I_Validateable {
	public abstract String getStreet_address();
	public abstract String getCity();
	public abstract String getCountry_code();
	public abstract String getCountry_sub_code();
	public abstract String getPostal_code();
}