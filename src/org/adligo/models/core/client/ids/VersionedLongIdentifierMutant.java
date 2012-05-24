package org.adligo.models.core.client.ids;

import org.adligo.models.core.client.InvalidParameterException;

public class VersionedLongIdentifierMutant implements I_VersionedLongIdentifier {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer version;
	private Long id;
	
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
	public Long getId() {
		return id;
	}
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.ids.I_VersionedLongIdentifierMutant#setId(org.adligo.models.core.client.ids.I_StorageIdentifier)
	 */
	public void setId(Long id) throws InvalidParameterException {
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.ids.I_VersionedLongIdentifier#getVersion()
	 */
	public Integer getVersion() {
		return version;
	}
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.ids.I_VersionedLongIdentifierMutant#setVersion(java.lang.Integer)
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	
}
