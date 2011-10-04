package org.adligo.models.core.client;

public interface I_VersionedIdentifierMutant extends I_StorageIdentifier, I_VersionedIdentifier  {
	public void setId(Long p) throws InvalidParameterException ;
	public void setVersion(Integer p) throws InvalidParameterException ;
}
