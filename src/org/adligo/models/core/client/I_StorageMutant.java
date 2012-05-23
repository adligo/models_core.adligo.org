package org.adligo.models.core.client;


public interface I_StorageMutant extends I_IdentifiableMutant {

	/**
	 * @see I_StorageInfo
	 */
	public void setStorageInfo(I_StorageInfo p) throws InvalidParameterException;
}
