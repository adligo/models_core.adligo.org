package org.adligo.models.core.shared;



/**
 * something that implements this interface should be able 
 * to be stored to disk (database, ldap server, as a file exc)
 * 
 * @author scott
 *
 */
public interface I_Storable extends I_Identifiable {
	/**
	 * @see I_StorageInfo
	 * @return
	 */
	public I_StorageInfo getStorageInfo();
	
}
