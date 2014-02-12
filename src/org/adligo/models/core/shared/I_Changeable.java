package org.adligo.models.core.shared;

/**
 * marks objects of classes that implement this interface as changeable in the system
 * using optimistic locking to synchronize changes.
 * 
 * @author scott
 *
 */
public interface I_Changeable extends I_Storable {
	public Integer getVersion();
}
