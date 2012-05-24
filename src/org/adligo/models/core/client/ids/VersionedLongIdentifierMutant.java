package org.adligo.models.core.client.ids;

import org.adligo.models.core.client.InvalidParameterException;

public class VersionedLongIdentifierMutant implements I_VersionedLongIdentifier, I_VersionedLongIdentifierMutant {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private I_StorageIdentifier id;
	private Integer version;
	
	public VersionedLongIdentifierMutant() {}
	public VersionedLongIdentifierMutant(I_VersionedLongIdentifier vi) throws InvalidParameterException {
		if (vi == null) {
			throw new InvalidParameterException("Does Not accept nulls", 
					"VersionedLongIdentifierMutant");
		}
		setId(vi.getId());
		setVersion(vi.getVersion());
	}
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.ids.I_VersionedLongIdentifier#getId()
	 */
	@Override
	public I_StorageIdentifier getId() {
		return id;
	}
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.ids.I_VersionedLongIdentifierMutant#setId(org.adligo.models.core.client.ids.I_StorageIdentifier)
	 */
	@Override
	public void setId(I_StorageIdentifier id) throws InvalidParameterException {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.ids.I_VersionedLongIdentifier#getVersion()
	 */
	@Override
	public Integer getVersion() {
		return version;
	}
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.ids.I_VersionedLongIdentifierMutant#setVersion(java.lang.Integer)
	 */
	@Override
	public void setVersion(Integer version) {
		this.version = version;
	}
	
}
