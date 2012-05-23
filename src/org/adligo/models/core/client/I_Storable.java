package org.adligo.models.core.client;

import java.io.Serializable;


/**
 * something that implements this interface should be able 
 * to be stored to disk (database, ldap server, as a file exc)
 * 
 * @author scott
 *
 */
public interface I_Storable extends Serializable, I_Identifiable {
	/**
	 * @see I_StorageInfo
	 * @return
	 */
	public I_StorageInfo getStorageInfo();
	
}
