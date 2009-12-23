package org.adligo.models.core.client;

public interface I_VersionedIdentifier extends I_StorageIdentifier  {
	public Long getId();
	public Integer getVersion();
}
