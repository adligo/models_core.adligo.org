package org.adligo.models.core.shared;

import org.adligo.i.util.shared.AppenderFactory;
import org.adligo.i.util.shared.ClassUtils;
import org.adligo.i.util.shared.I_Appender;
import org.adligo.models.core.shared.util.StorageIdentifierValidator;
import org.adligo.models.core.shared.util.VersionValidator;

/**
 * 
 * @author scott
 *
 */
public class StorableMutant implements I_StorageMutant {
	public static final String STORAGE_MUTANTS_WITH_IDS_ALSO_REQUIRE_STORAGE_INFO = "StorageMutants with ids also require storage info.";
	
	private I_StorageIdentifier id;
	private I_StorageInfo storageInfo;
	
	public StorableMutant() {}
	
	public StorableMutant(I_Storable p) throws InvalidParameterException {
		if (p == null) {
			throw new InvalidParameterException("","Constructor");
		}
		I_StorageIdentifier otherId = p.getId();
		if (otherId != null) {
			setId(otherId);
			I_StorageInfo si = p.getStorageInfo();
			if (si != null) {
				setStorageInfo(si);
			}
		}
	}
	
	public I_StorageIdentifier getId() {
		return id;
	}
	
	public void setId(I_StorageIdentifier p) throws InvalidParameterException {
		StorageIdentifierValidator.validateId(p, this.getClass(), SET_ID);
		id = p;
	}
	
	/* (non-Javadoc)
	 * @see com.adligo.models.accounting.client.assets.I_Purchase#getStorageInfo()
	 */
	
	public I_StorageInfo getStorageInfo() {
		return storageInfo;
	}
	/* (non-Javadoc)
	 * @see com.adligo.models.accounting.client.assets.I_PurchaseMutant#setStorageInfo(org.adligo.models.core.client.I_StorageInfo)
	 */
	
	public void setStorageInfo(I_StorageInfo p) throws InvalidParameterException {
		if (p == null) {
			throw new InvalidParameterException("ChangeableMutant does NOT allow null storage info.",
					SET_STORAGE_INFO);
		}
		storageInfo = p;
	}

	
	public String toString() {
		I_Appender app = AppenderFactory.create();
		toString(StorableMutant.class, app);
		return app.toString();
	}
	/**
	 * client calls must append their own square brace at the end ]
	 * to allow for extension.
	 * Note no generics or annotations for jme compatibility
	 * @param app
	 */
	public void toString(Class ic, I_Appender app) {
		app.append("" + ClassUtils.getClassShortName(ic) + " [id=" + id + 
				", storageInfo=" + storageInfo);
	}
	
	public void isValid() throws ValidationException {
		isValid(this);
	}
	/**
	 * package private isValid method to allow
	 * cleaner call hierarchy
	 * @param p
	 * @throws ValidationException
	 */
	void isValid(StorableMutant p) throws ValidationException {
		StorableValidator.validate(p, I_Validateable.IS_VALID);
		I_StorageIdentifier tid = p.getId();
		if (tid != null) {
			I_StorageInfo otherInfo = p.getStorageInfo();
			if (otherInfo == null) {
				throw new ValidationException(STORAGE_MUTANTS_WITH_IDS_ALSO_REQUIRE_STORAGE_INFO, I_Validateable.IS_VALID);
			} else {
				otherInfo.isValid();
			}
		}
	}
	
	public boolean isStored() throws ValidationException {
		return StorableValidator.validate(this, I_Storable.IS_STORED);
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((storageInfo == null) ? 0 : storageInfo.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StorableMutant other = (StorableMutant) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (storageInfo == null) {
			if (other.storageInfo != null)
				return false;
		} else if (!storageInfo.equals(other.storageInfo))
			return false;
		return true;
	}
}
