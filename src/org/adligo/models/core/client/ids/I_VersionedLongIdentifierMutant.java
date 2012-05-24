package org.adligo.models.core.client.ids;

import org.adligo.models.core.client.InvalidParameterException;

public interface I_VersionedLongIdentifierMutant {

	public abstract void setId(I_StorageIdentifier id)
			throws InvalidParameterException;

	public abstract void setVersion(Integer version);

}