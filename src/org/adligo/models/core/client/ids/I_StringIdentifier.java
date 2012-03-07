package org.adligo.models.core.client.ids;


public interface I_StringIdentifier extends I_StorageIdentifier {
	/**
	 * return the value used int the storage system
	 * for uniqueness in the following (
	 * 		LDAP this is a dn, 
	 * 		Filesystem this is a java.io.File pathname from the constructor
	 * )
	 * @return
	 */
	public String getKey();
}
