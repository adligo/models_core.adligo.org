package org.adligo.models.core.client;

import java.io.Serializable;

import org.adligo.models.core.client.ids.I_StorageIdentifier;

/**
 * something that implements this interface should be able 
 * to be stored to disk (database, ldap server, as a file exc)
 * 
 * @author scott
 *
 */
public interface I_Storable extends Serializable {
	public I_StorageIdentifier getId();
}
