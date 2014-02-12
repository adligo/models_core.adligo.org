package org.adligo.models.core.shared.ids;

import org.adligo.i.adi.shared.I_Cacheable;
import org.adligo.models.core.shared.InvalidParameterException;

/**
 * a class that may be used as a Hibernate component
 * to a history table (Where id, version is the primary key)
 * @author scott
 *
 */
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
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		VersionedLongIdentifierMutant other = (VersionedLongIdentifierMutant) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	
	public String toString() {
		return "VersionedLongIdentifierMutant [version=" + version + ", id="
				+ id + "]";
	}
	
	public int getMemsize() {
		int size = 0;
		if (id != null) {
			size = I_Cacheable.LONG;
		}
		if (id != null) {
			size = size + I_Cacheable.INT;
		}
		return I_Cacheable.OBJECT + size;
	}
	
	public boolean hasValue() {
		if (id == null || version == null) {
			return false;
		}
		return true;
	}
	
	public I_StorageIdentifier toImmutable() {
		try{
			return new VersionedLongIdentifier(this);
		} catch (InvalidParameterException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
