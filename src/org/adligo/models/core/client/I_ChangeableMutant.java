package org.adligo.models.core.client;

public interface I_ChangeableMutant extends I_Changeable, I_StorageMutant {
	public void setVersion(Integer p) throws InvalidParameterException;
}
