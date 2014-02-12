package org.adligo.models.core.shared;

public interface I_ChangeableMutant extends I_Changeable, I_StorageMutant {
	public void setVersion(Integer p) throws InvalidParameterException;
}
