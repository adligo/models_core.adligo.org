package org.adligo.models.core.shared;


public interface I_IdentifiableMutant extends I_Identifiable {
	public static final String SET_ID = "setId";
	
	public void setId(I_StorageIdentifier id) throws InvalidParameterException;
}
