package org.adligo.models.core.client;

public interface I_OrganizationMutant extends I_Organization, I_ChangeableMutant, 
I_NamedIdMutant, I_CustomizableMutant {
	public void setType(I_NamedId p) throws InvalidParameterException;
}
