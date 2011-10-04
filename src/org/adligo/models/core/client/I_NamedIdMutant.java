package org.adligo.models.core.client;


public interface I_NamedIdMutant extends I_NamedId, I_StorageMutant {
	public void setName(String p) throws InvalidParameterException;
}
