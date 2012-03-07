package org.adligo.models.core.client;

import org.adligo.models.core.client.ids.I_StorageIdentifier;


public class Organization implements I_Organization, I_Validateable {
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
	
	public Organization() {
		mutant = new OrganizationMutant();
	}
	
	public Organization(I_Organization other) throws InvalidParameterException {
		mutant = new OrganizationMutant(other);
		I_StorageIdentifier otherId = other.getId();
		if (otherId != null) {
			id = CommonModel.getIdClone(otherId);
		}
		I_NamedId other_type = other.getType();
		if (other_type != null) {
			type = new NamedId(other_type);
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
}
