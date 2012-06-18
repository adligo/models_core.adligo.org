package org.adligo.models.core.client;

import java.io.Serializable;

import org.adligo.models.core.client.ids.I_StorageIdentifier;

public interface I_Identifiable extends Serializable {
	public static final String IS_STORED = "IS_STORED";
	
	public abstract I_StorageIdentifier getId();

	public boolean isStored() throws ValidationException;
}