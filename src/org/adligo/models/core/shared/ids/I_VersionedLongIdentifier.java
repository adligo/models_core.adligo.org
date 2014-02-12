package org.adligo.models.core.shared.ids;

import org.adligo.i.adi.shared.I_Cacheable;

/**
 * note 
 * it would get normalized to the version integer and I_StorageIdentifier
 * at runtime in the class (see Person, Org)
 * @author scott
 *
 */
public interface I_VersionedLongIdentifier extends I_StorageIdentifier, I_Cacheable {

	public abstract Long getId();

	public abstract Integer getVersion();

}