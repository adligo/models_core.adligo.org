package org.adligo.models.core.shared;

import org.adligo.i.util.shared.I_Immutable;

/**
 * Note this is a immutable class that represents something
 * that could change (by creating a new one)
 * 
 * @author scott
 *
 */
public class Changeable implements I_Changeable, I_Immutable {

	public static final String CHANGEABLE = "Changeable";
	
	private ChangeableMutant changeable;
	
	/**
	 * default constructor
	 */
	public Changeable() {
		changeable = new ChangeableMutant();
	}
	
	public Changeable(I_Changeable p) throws InvalidParameterException {
		changeable = new ChangeableMutant(p);
		
	}

	/**
	 * @see I_Identifiable#getId()
	 * also this is immutable so it should return a immutable 
	 */
	public I_StorageIdentifier getId() {
		I_StorageIdentifier id = changeable.getId();
		if (id == null) {
			return null;
		}
		return id.toImmutable();
	}

	
	
	
	public boolean isStored() throws ValidationException {
		return changeable.isStored();
	}
	
	public String getImmutableFieldName() {
		return  "changeable";
	}

	/**
	 * @see I_Changeable#getVersion()
	 * also this is immutable so it should return a immutable 
	 */
	public Integer getVersion() {
		return changeable.getVersion();
	}
	/**
	 * @see I_Storable#getStorageInfo()
	 * also this is immutable so it should return a immutable 
	 */
	public I_StorageInfo getStorageInfo() {
		I_StorageInfo info = changeable.getStorageInfo();
		if (info == null) {
			return null;
		}
		try {
			return (I_StorageInfo) info.toImmutable();
		} catch (ValidationException e) {
			return null;
		}
	}
}
