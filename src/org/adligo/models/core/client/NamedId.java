package org.adligo.models.core.client;

import org.adligo.i.util.client.I_Immutable;
import org.adligo.models.core.client.ids.I_StorageIdentifier;

public class NamedId implements I_NamedId, I_Immutable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
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
			id = otherId.toImmutable();
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
			id = p_id.toImmutable();
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

	public boolean isValid() throws ValidationException {
		return mutant.isValid();
	}

	public int hashCode() {
		return mutant.hashCode();
	}

	public boolean equals(Object obj) {
		return mutant.equals(obj);
	}

	@Override
	public String getImmutableFieldName() {
		return "mutant";
	}

}
