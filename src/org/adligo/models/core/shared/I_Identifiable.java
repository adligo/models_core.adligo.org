package org.adligo.models.core.shared;


public interface I_Identifiable {
	public static final String IS_STORED = "IS_STORED";
	public static final String CONSTRUCTOR = "Constructor";
	
	public abstract I_StorageIdentifier getId();

	public boolean isStored() throws ValidationException;
}