package org.adligo.models.core.shared;

import org.adligo.i.adi.shared.I_Cacheable;

/**
 * This is a marker interface that represents a pluggable id
 * (ie from a database table)
 * see the models_core_relations project for implementations
 * which also implement Serilizable for hibernate.
 * Serilizable is not implemented here so that
 * this class can be compiled on JME.
 * 
 * @author scott
 *
 */
public interface I_StorageIdentifier extends  I_Cacheable {

	/**
	 * should return true if the value has been used on the storage system
	 * should return false if the value has not been used
	 * @return
	 */
	public boolean hasValue();
	/**
	 * clone a new immutable copy of this object
	 * @return
	 */
	public I_StorageIdentifier toImmutable();
}
