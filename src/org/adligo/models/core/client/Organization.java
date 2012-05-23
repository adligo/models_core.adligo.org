package org.adligo.models.core.client;

import org.adligo.i.util.client.I_Immutable;
import org.adligo.models.core.client.ids.I_StorageIdentifier;


public class Organization implements I_Organization, I_Validateable, I_Immutable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrganizationMutant mutant;
	/**
	 * keep id seperate from mutant for immutability
	 */
	private I_StorageIdentifier id;
	/**
	 * keep type seperate from mutant for immutability
	 */
	private I_NamedId type;
	private I_CustomInfo customInfo;
	private I_StorageInfo storageInfo;
	
	public Organization() {
		mutant = new OrganizationMutant();
	}
	
	public Organization(I_Organization other) throws InvalidParameterException {
		mutant = new OrganizationMutant(other);
		I_StorageIdentifier otherId = other.getId();
		if (otherId != null) {
			id = otherId;
		}
		I_NamedId other_type = other.getType();
		if (other_type != null) {
			type = new NamedId(other_type);
		}
		I_StorageInfo p_storageInfo = other.getStorageInfo();
		if (p_storageInfo != null) {
			try {
				storageInfo = (I_StorageInfo) p_storageInfo.toImmutable();
			} catch (ValidationException ve) {
				throw new InvalidParameterException(ve);
			}
		}
		I_CustomInfo p_customInfo = other.getCustomInfo();
		if (p_customInfo != null) {
			try {
				customInfo = p_customInfo.toImmutable();
			} catch (ValidationException ve) {
				throw new InvalidParameterException(ve);
			}
		}
	}

	public I_NamedId getType() {
		return type;
	}

	public String getName() {
		return mutant.getName();
	}

	public I_StorageIdentifier getId() {
		return id;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		try {
			return OrganizationMutant.equals(this, (I_Organization) obj);
		} catch (ClassCastException x) {
			//eat gwt doesn't impl instance of
		}
		return false;
	}

	public int hashCode() {
		return OrganizationMutant.genHashCode(this);
	}

	public boolean isValid() {
		return mutant.isValid();
	}
	
	public String toString() {
		return mutant.toString(this.getClass(), this);
	}

	public String getImmutableFieldName() {
		return "mutant";
	}

	public I_CustomInfo getCustomInfo() {
		return customInfo;
	}

	public I_StorageInfo getStorageInfo() {
		return storageInfo;
	}

	public Integer getVersion() {
		return mutant.getVersion();
	}

	public I_Organization toImmutable() throws ValidationException {
		return this;
	}

	public I_OrganizationMutant toMutant() throws ValidationException {
		try {
			return new OrganizationMutant(this);
		} catch (InvalidParameterException ipe) {
			throw new ValidationException(ipe);
		}
	}
}
