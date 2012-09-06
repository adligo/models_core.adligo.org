package org.adligo.models.core.client;

import org.adligo.i.util.client.I_Immutable;
import org.adligo.models.core.client.ids.I_StorageIdentifier;
import org.adligo.models.core.client.ids.StorageIdentifierValidator;
import org.adligo.models.core.client.ids.VersionValidator;

/**
 * Note this is a immutable class that represents something
 * that could change (by creating a new one)
 * 
 * @author scott
 *
 */
public abstract class Changeable implements I_Changeable, I_Immutable {
	public static final String STORAGE_INFO_IS_REQUIRED_FOR_CHANGEABLES_THAT_ARE_STORED = "StorageInfo is required for Changeables that are stored.";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String CHANGEABLE = "Changeable";
	
	private ChangeableMutant mutant;
	
	/**
	 * default constructor
	 */
	public Changeable() {
		mutant = new ChangeableMutant();
	}
	
	public Changeable(I_Changeable p) throws InvalidParameterException {
		mutant = new ChangeableMutant(p);
		
	}

	public I_StorageIdentifier getId() {
		I_StorageIdentifier id = mutant.getId();
		if (id == null) {
			return null;
		}
		return id.toImmutable();
	}

	
	
	
	public boolean isStored() throws ValidationException {
		return mutant.isStored();
	}
	
	public String getImmutableFieldName() {
		return I_Immutable.MUTANT;
	}

	public Integer getVersion() {
		return mutant.getVersion();
	}

	public I_StorageInfo getStorageInfo() {
		I_StorageInfo info = mutant.getStorageInfo();
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
