package org.adligo.models.core.client.ids;

import org.adligo.models.core.client.InvalidParameterException;

public interface I_StorageIdGenerator {
	public I_StorageIdentifier generate(I_StorageIdentifier other) throws InvalidParameterException, ClassCastException;
}
