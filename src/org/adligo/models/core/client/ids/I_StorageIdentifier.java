package org.adligo.models.core.client.ids;

import java.io.Serializable;

import org.adligo.i.util.client.I_Immutable;

/**
 * marker interfaces actual impls should also 
 * be a I_StringIdentifier (for LDAP dns or Filesystem uris)
 * ,I_VersionedIdentifier (optimistic locking with values big enough for most databases)
 * 
 * @author scott
 *
 */
public interface I_StorageIdentifier extends Serializable, I_Immutable {

	/**
	 * should return true if the value has been used on the storage system
	 * should return false if the value has not been used
	 * @return
	 */
	public boolean hasValue();
}
