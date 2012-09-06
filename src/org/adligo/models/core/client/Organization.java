package org.adligo.models.core.client;

import org.adligo.i.util.client.I_Immutable;
import org.adligo.models.core.client.ids.I_StorageIdentifier;


public class Organization extends Changeable implements I_Organization, I_Validateable, I_Immutable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrganizationMutant mutant;
	/**
	 * keep type seperate from mutant for immutability
	 */
	private I_CustomInfo customInfo;
	
	public Organization() {
		mutant = new OrganizationMutant();
	}
	
	public Organization(I_Organization other) throws InvalidParameterException {
		super(other);
		mutant = new OrganizationMutant(other);
		
		I_CustomInfo p_customInfo = other.getCustomInfo();
		if (p_customInfo != null) {
			try {
				customInfo = p_customInfo.toImmutable();
			} catch (ValidationException ve) {
				throw new InvalidParameterException(ve);
			}
		}
	}

	public I_StorageIdentifier getType() {
		return mutant.getType();
	}

	public String getName() {
		return mutant.getName();
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

	public void isValid() throws ValidationException {
		mutant.isValid();
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

	public boolean isStored() throws ValidationException {
		return mutant.isStored();
	}
}
