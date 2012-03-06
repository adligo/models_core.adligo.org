package org.adligo.models.core.client;

public interface I_VersionedIdentifierMutant extends I_StorageIdentifier, I_VersionedIdentifier, I_LongIdentifierMutant  {
	public void setVersion(Integer p) throws InvalidParameterException ;
}
