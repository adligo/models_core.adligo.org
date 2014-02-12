package org.adligo.models.core.shared;

public interface I_CustomizableMutant extends I_Customizable, I_StorageMutant  {
	public void setCustomInfo(I_CustomInfo p) throws InvalidParameterException;
}
