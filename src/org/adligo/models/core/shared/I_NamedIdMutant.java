package org.adligo.models.core.shared;


public interface I_NamedIdMutant extends I_NamedId, I_IdentifiableMutant {
	public void setName(String p) throws InvalidParameterException;
}
