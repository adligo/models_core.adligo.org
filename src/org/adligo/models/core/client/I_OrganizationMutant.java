package org.adligo.models.core.client;

public interface I_OrganizationMutant extends I_Organization, I_NamedIdMutant, I_StorageMutant {
	public void setType(I_NamedId p) throws InvalidParameterException;
}
