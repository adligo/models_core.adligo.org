package org.adligo.models.core.client.ids;

import java.io.Serializable;

import org.adligo.models.core.client.InvalidParameterException;

/**
 * marker interfaces actual impls should also 
 * be a I_StringIdentifier (for LDAP dns or Filesystem uris)
 * ,I_VersionedIdentifier (optimistic locking with values big enough for most databases)
 * 
 * @author scott
 *
 */
public interface I_StorageIdentifier extends Serializable {

	/**
	 * should return true if the value has been used on the storage system
	 * should return false if the value has not been used
	 * @return
	 */
	public boolean hasValue();
	/**
	 * this returns the type ie (LongIdentifier, StringIdentifier)
	 * for the type pair to optimize the DefaultStorageIdentiferFactory and DefaultStorageIdentifierMutantFactory
	 * through use of a map lookup
	 * 
	 * @return
	 */
	public String getType();
	
	/**
	 * create a immutable copy of this object
	 * @return
	 */
	public I_StorageIdentifier toImmutable() throws InvalidParameterException;
	/**
	 * create a mutable copy of this class
	 * @return
	 */
	public I_StorageIdentifier toMutant() throws InvalidParameterException;
}
