package org.adligo.models.core.client;

import org.adligo.i.util.client.AppenderFactory;
import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.I_Appender;
import org.adligo.models.core.client.ids.I_StorageIdentifier;
import org.adligo.models.core.client.ids.StorageIdentifierValidator;
import org.adligo.models.core.client.ids.VersionValidator;

public class ChangeableMutant implements I_ChangeableMutant {
	public static final String CHANGEABLE_MUTANTS_WITH_IDS_ALSO_REQUIRE_STORAGE_INFO = "ChangeableMutants with ids also require storage info.";
	public static final String CHANGEABLE_MUTANT_WITH_IDS_ALSO_REQUIRE_VERSIONS = "ChangeableMutant with ids also require versions.";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private I_StorageIdentifier id;
	private Integer version;
	private I_StorageInfo storageInfo;
	
	public ChangeableMutant() {}
	
	public ChangeableMutant(I_Changeable p) throws InvalidParameterException {
		I_StorageIdentifier otherId = p.getId();
		if (otherId != null) {
			setId(otherId);
			Integer otherVersion = p.getVersion();
			if (otherVersion != null) {
				setVersion(otherVersion);
			}
			I_StorageInfo si = p.getStorageInfo();
			if (si != null) {
				setStorageInfo(si);
			}
		}
		try {
			isValid(this);
		} catch (ValidationException ve) {
			throw new InvalidParameterException(ve);
		}
		
	}
	
	public I_StorageIdentifier getId() {
		return id;
	}
	
	public void setId(I_StorageIdentifier p) throws InvalidParameterException {
		StorageIdentifierValidator.validateId(p, this.getClass(), I_IdentifiableMutant.SET_ID);
		id = p;
	}
	public Integer getVersion() {
		return version;
	}
	
	public void setVersion(Integer p) throws InvalidParameterException {
		this.version = VersionValidator.validate(p);
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
		toString(ChangeableMutant.class, app);
		return app.toString();
	}
	/**
	 * client calls must append their own square brace at the end ]
	 * to allow for extension.
	 * 
	 * @param app
	 */
	public void toString(Class<?> ic, I_Appender app) {
		app.append("" + ClassUtils.getClassShortName(ic) + " [id=" + id + ", version=" + version
				+ ", storageInfo=" + storageInfo);
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
	void isValid(ChangeableMutant p) throws ValidationException {
		StorableValidator.validate(p, I_Validateable.IS_VALID);
		I_StorageIdentifier tid = p.getId();
		if (tid != null) {
			if (p.getVersion() == null) {
				throw new ValidationException(CHANGEABLE_MUTANT_WITH_IDS_ALSO_REQUIRE_VERSIONS, I_Validateable.IS_VALID);
			}
			I_StorageInfo otherInfo = p.getStorageInfo();
			if (otherInfo == null) {
				throw new ValidationException(CHANGEABLE_MUTANTS_WITH_IDS_ALSO_REQUIRE_STORAGE_INFO, I_Validateable.IS_VALID);
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
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChangeableMutant other = (ChangeableMutant) obj;
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
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
}
