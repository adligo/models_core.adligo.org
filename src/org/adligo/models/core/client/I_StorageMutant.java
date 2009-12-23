package org.adligo.models.core.client;

public interface I_StorageMutant {
	public static final String SET_ID = "setId";
	
	public void setId(I_StorageIdentifier id) throws InvalidParameterException;
}
