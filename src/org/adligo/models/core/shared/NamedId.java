package org.adligo.models.core.shared;

import org.adligo.i.util.shared.I_Immutable;

public class NamedId implements I_NamedId, I_Immutable {

	
	private NamedIdMutant mutant;
	/**
	 * keep a variable for the
	 * id to keep it immutable
	 */
	private I_StorageIdentifier id;
	
	public NamedId(I_NamedId p) throws InvalidParameterException {
		mutant = new NamedIdMutant(p);
		I_StorageIdentifier otherId = p.getId();
		if (otherId != null) {
			id = otherId;
		}
	}
	
	public NamedId(String p_name) throws InvalidParameterException {
		mutant = new NamedIdMutant();
		mutant.setName(p_name);
	}
	
	public NamedId(String p_name, I_StorageIdentifier p_id) throws InvalidParameterException {
		mutant = new NamedIdMutant();
		mutant.setName(p_name);
		if (p_id != null) {
			id = p_id;
		}
	}
	
	public NamedId() {
		mutant = new NamedIdMutant();
	}

	public I_StorageIdentifier getId() {
		return id;
	}

	public String getName() {
		return mutant.getName();
	}

	public String toString() {
		return mutant.toString(this.getClass(), id);
	}

	public void isValid() throws ValidationException {
		mutant.isValid();
	}

	public int hashCode() {
		return mutant.hashCode();
	}

	public boolean equals(Object obj) {
		return mutant.equals(obj);
	}

	public String getImmutableFieldName() {
		return "mutant";
	}

	public boolean isStored() throws ValidationException {
		return mutant.isStored();
	}

}
