package org.adligo.models.core.shared;

public interface I_VersionedMutant extends I_Versioned, I_StorageMutant {
	public void setVersion(Integer p) throws InvalidParameterException;
}
