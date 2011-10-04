package org.adligo.models.core.client;

public class NamedId implements I_NamedId {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private NamedIdMutant mutant;
	
	public NamedId(I_NamedId p) throws InvalidParameterException {
		mutant = new NamedIdMutant(p);
	}
	
	public NamedId(String p_name) throws InvalidParameterException {
		mutant = new NamedIdMutant();
		mutant.setName(p_name);
	}
	
	public NamedId(String p_name, I_StorageIdentifier p_id) throws InvalidParameterException {
		mutant = new NamedIdMutant();
		mutant.setName(p_name);
		mutant.setId(p_id);
	}
	
	public NamedId() {
		mutant = new NamedIdMutant();
	}

	public I_StorageIdentifier getId() {
		return mutant.getId();
	}

	public String getName() {
		return mutant.getName();
	}

	public String toString() {
		return mutant.toString(this.getClass());
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

}
