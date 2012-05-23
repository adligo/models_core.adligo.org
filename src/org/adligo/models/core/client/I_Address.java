package org.adligo.models.core.client;

public interface I_Address extends I_Identifiable, I_Validateable, I_Mutable {
	public String getStreetAddress();
	public String getCity();
	public String getCountryCode();
	public String getCountrySubCode();
	public String getPostalCode();
}