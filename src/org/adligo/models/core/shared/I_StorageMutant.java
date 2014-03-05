package org.adligo.models.core.shared;


public interface I_StorageMutant extends I_Storable, I_IdentifiableMutant {

	public static final String SET_STORAGE_INFO = "setStorageInfo";
	/**
	 * @see I_StorageInfo
	 */
	public void setStorageInfo(I_StorageInfo p) throws InvalidParameterException;
}
