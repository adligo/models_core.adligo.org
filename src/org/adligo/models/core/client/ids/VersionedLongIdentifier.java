package org.adligo.models.core.client.ids;

import org.adligo.i.adi.client.I_Cacheable;
import org.adligo.models.core.client.InvalidParameterException;

public class VersionedLongIdentifier {
	private VersionedLongIdentifierMutant mutant;
	
	public VersionedLongIdentifier() {
		mutant = new VersionedLongIdentifierMutant();
	}
	
	public VersionedLongIdentifier(I_VersionedLongIdentifier p) throws InvalidParameterException {
		mutant = new VersionedLongIdentifierMutant(p);
	}

	public Long getId() {
		return mutant.getId();
	}

	public Integer getVersion() {
		return mutant.getVersion();
	}

	public int hashCode() {
		return mutant.hashCode();
	}

	public String toString() {
		return mutant.toString();
	}

	public int getMemsize() {
		return mutant.getMemsize() + I_Cacheable.OBJECT;
	}
}
