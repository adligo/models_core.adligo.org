package org.adligo.models.core.shared;


public interface I_OrganizationMutant extends I_Organization, I_ChangeableMutant, 
I_NamedIdMutant, I_CustomizableMutant {
	public void setType(I_StorageIdentifier p) throws InvalidParameterException;
}