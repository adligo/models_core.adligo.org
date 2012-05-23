package org.adligo.models.core.client;

public interface I_CustomizableMutant extends I_Customizable, I_StorageMutant  {
	public void setCustomInfo(I_CustomInfo p) throws InvalidParameterException;
}
