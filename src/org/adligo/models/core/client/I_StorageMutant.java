package org.adligo.models.core.client;

public interface I_StorageMutant {
	public static final String SET_ID = "setId";
	
	public void setId(StorageIdentifier id) throws InvalidParameterException;
}
