package org.adligo.models.core.client;

import org.adligo.models.core.client.ids.I_StorageIdentifier;
import org.adligo.models.core.client.ids.StorageIdentifierValidator;
import org.adligo.models.core.client.ids.VersionValidator;

public class ChangeableMutant implements I_ChangeableMutant {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private I_StorageIdentifier id;
	private Integer version;
	private I_StorageInfo storageInfo;
	
	public ChangeableMutant() {}
	
	public ChangeableMutant(I_Changeable p) throws InvalidParameterException {
		setId(p.getId());
		setVersion(p.getVersion());
		setStorageInfo(p.getStorageInfo());
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

	@Override
	public boolean isStored() throws ValidationException {
		// TODO Auto-generated method stub
		return false;
	}
}
