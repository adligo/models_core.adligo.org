package org.adligo.models.core.client;

public interface I_VersionedIdentifier extends I_StorageIdentifier, I_LongIdentifier  {
	public Integer getVersion();
}
