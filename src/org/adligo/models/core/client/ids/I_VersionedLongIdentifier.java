package org.adligo.models.core.client.ids;

/**
 * note this is not serilizeable as 
 * it would get normalized to the version integer and I_StorageIdentifier
 * at runtime in the class (see Person, Org)
 * @author scott
 *
 */
public interface I_VersionedLongIdentifier {

	public abstract Long getId();

	public abstract Integer getVersion();

}