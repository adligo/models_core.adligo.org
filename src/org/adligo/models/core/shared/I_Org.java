package org.adligo.models.core.shared;


public interface I_Org extends I_NamedId, I_Customizable, I_Storable {
	public I_StorageIdentifier getType();
}