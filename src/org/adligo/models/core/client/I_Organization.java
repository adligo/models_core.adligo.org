package org.adligo.models.core.client;

public interface I_Organization extends I_NamedId, I_Customizable, I_Changeable {
	public abstract I_NamedId getType();
	public I_Organization toImmutable() throws ValidationException;
	public I_OrganizationMutant toMutant() throws ValidationException;
}