package org.adligo.models.core.client;

public class LongIdentifier implements I_LongIdentifier {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LongIdentifierMutant mutant;
	
	public LongIdentifier() {}
	
	public LongIdentifier(I_LongIdentifier p) throws InvalidParameterException {
		mutant = new LongIdentifierMutant(p);
	}
	
	@Override
	public Long getId() {
		return mutant.getId();
	}

	public int hashCode() {
		return mutant.hashCode();
	}

	public boolean equals(Object obj) {
		return mutant.equals(obj);
	}

	public String toString() {
		return mutant.toString();
	}

	@Override
	public boolean hasValue() {
		if (mutant == null) {
			return false;
		}
		return true;
	}

}
