package org.adligo.models.core.client.ids;

import org.adligo.i.util.client.I_Immutable;
import org.adligo.models.core.client.InvalidParameterException;

public class LongIdentifier implements I_LongIdentifier, I_Immutable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LongIdentifierMutant mutant;
	
	public LongIdentifier() {}
	
	public LongIdentifier(I_LongIdentifier p) throws InvalidParameterException {
		mutant = new LongIdentifierMutant(p);
	}
	
	public LongIdentifier(Long p) throws InvalidParameterException {
		mutant = new LongIdentifierMutant(p);
	}
	
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
		return mutant.toString(this.getClass());
	}

	public boolean hasValue() {
		if (mutant == null) {
			return false;
		}
		return true;
	}

	public String getType() {
		return LongIdentifierMutant.TYPE;
	}

	@Override
	public String getImmutableFieldName() {
		return "mutant";
	}

	public I_StorageIdentifier toImmutable() {
		try {
			return new LongIdentifier(this);
		} catch (InvalidParameterException x) {
			throw new IllegalStateException(x);
		}
	}

	public I_StorageIdentifier toMutant() {
		try {
			return new LongIdentifierMutant(this);
		} catch (InvalidParameterException x) {
			throw new IllegalStateException(x);
		}
	}
}
