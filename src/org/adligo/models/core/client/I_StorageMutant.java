package org.adligo.models.core.client;

import org.adligo.models.core.client.ids.I_StorageIdentifier;

public interface I_StorageMutant {
	public static final String SET_ID = "setId";
	
	public void setId(I_StorageIdentifier id) throws InvalidParameterException;
}
