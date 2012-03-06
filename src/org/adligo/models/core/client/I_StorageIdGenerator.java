package org.adligo.models.core.client;

public interface I_StorageIdGenerator {
	public I_StorageIdentifier generate() throws InvalidParameterException;
}
