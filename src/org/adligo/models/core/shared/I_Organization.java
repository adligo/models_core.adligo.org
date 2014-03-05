package org.adligo.models.core.shared;


public interface I_Organization extends I_NamedId, I_Customizable, I_Changeable {
	public I_StorageIdentifier getType();
}