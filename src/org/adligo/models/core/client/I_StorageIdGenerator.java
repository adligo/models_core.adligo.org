package org.adligo.models.core.client;

public interface I_StorageIdGenerator {
	public StorageIdentifier generate() throws InvalidParameterException;
}
