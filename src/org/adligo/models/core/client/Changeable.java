package org.adligo.models.core.client;

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
public abstract class Changeable implements I_Changeable {
	public static final String STORAGE_INFO_IS_REQUIRED_FOR_CHANGEABLES_THAT_ARE_STORED = "StorageInfo is required for Changeables that are stored.";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String CHANGEABLE = "Changeable";
	
	private I_StorageIdentifier id;
	private Integer version;
	private I_StorageInfo storageInfo;
	
	public Changeable() {}
	
	public Changeable(I_Changeable p) throws InvalidParameterException {
		I_StorageIdentifier otherId = p.getId();
		StorageIdentifierValidator.validateIdAllowingNull(otherId, Changeable.class, CHANGEABLE);
		id = otherId;
		if (id != null) {
			//its stored so get the other storage info
			version = p.getVersion();
			VersionValidator.validate(version);
			
			try {
				I_StorageInfo otherInfo = p.getStorageInfo();
				if (otherInfo == null) {
					throw new InvalidParameterException(STORAGE_INFO_IS_REQUIRED_FOR_CHANGEABLES_THAT_ARE_STORED, 
							CHANGEABLE);
				}
				storageInfo = (I_StorageInfo) otherInfo.toImmutable();
				storageInfo.isValid();
			} catch (ValidationException ve) {
				throw new InvalidParameterException(ve);
			}
		}
	}

	public I_StorageIdentifier getId() {
		return id;
	}

	public Integer getVersion() {
		return version;
	}

	public I_StorageInfo getStorageInfo() {
		return storageInfo;
	}
	
	public boolean isStored() throws ValidationException {
		if (id == null) {
			return false;
		}
		return true;
	}
}
