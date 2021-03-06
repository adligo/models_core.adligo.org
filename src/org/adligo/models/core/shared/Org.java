package org.adligo.models.core.shared;

import org.adligo.i.util.shared.I_Immutable;


public class Org implements I_Org, I_Validateable, I_Immutable {

	private OrgMutant mutant;
	
	public Org() {
		mutant = new OrgMutant();
	}
	
	public Org(I_Org other) throws InvalidParameterException {
		mutant = new OrgMutant(other);
	}

	public I_StorageIdentifier getType() {
		I_StorageIdentifier toRet = mutant.getType();
		if (toRet != null) {
			return toRet.toImmutable();
		}
		return null;
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
			return OrgMutant.equals(this, (I_Org) obj);
		} catch (ClassCastException x) {
			//eat gwt doesn't impl instance of
		}
		return false;
	}

	public int hashCode() {
		return OrgMutant.genHashCode(this);
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
		I_CustomInfo customInfo = mutant.getCustomInfo();
		if (customInfo != null) {
			try {
				return customInfo.toImmutable();
			} catch (ValidationException ve) {
				//do nothing
			}
		}
		return null;
	}

	public I_Org toImmutable() throws ValidationException {
		return this;
	}

	public I_OrgMutant toMutant() throws ValidationException {
		try {
			return new OrgMutant(this);
		} catch (InvalidParameterException ipe) {
			throw new ValidationException(ipe);
		}
	}

	public boolean isStored() throws ValidationException {
		return mutant.isStored();
	}

	public I_StorageIdentifier getId() {
		return mutant.getId();
	}

	public I_StorageInfo getStorageInfo() {
		return mutant.getStorageInfo();
	}
}
