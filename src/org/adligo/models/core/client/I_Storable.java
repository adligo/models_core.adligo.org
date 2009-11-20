package org.adligo.models.core.client;

/**
 * something that implements this interface should be able 
 * to be stored to disk (database, ldap server, as a file exc)
 * 
 * @author scott
 *
 */
public interface I_Storable {
	public I_StorageIdentifier getId();
}
