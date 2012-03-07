package org.adligo.models.core.client.ids;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.StringUtils;
import org.adligo.models.core.client.InvalidParameterException;

/**
 * this provides a unique identifier for a stored model
 * Storage Identifier 
 * 
 * Note the errors are not internationalized because
 * they are primarily for programmers who write code in English.
 * 
 * @author scott
 *
 */
public class VersionedIdentifier implements I_VersionedIdentifier {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VersionedIdentifierMutant mutant;
	
	public VersionedIdentifier() {
		mutant = new VersionedIdentifierMutant();
	}
	
	public VersionedIdentifier(I_VersionedIdentifier other) throws InvalidParameterException {
		mutant = new VersionedIdentifierMutant(other);
	}
	
	public VersionedIdentifier(Integer id) throws InvalidParameterException {
		mutant = new VersionedIdentifierMutant(id);
	}
	
	public VersionedIdentifier(Long id) throws InvalidParameterException {
		mutant = new VersionedIdentifierMutant(id);
	}
	
	public VersionedIdentifier(Integer id, Integer version) throws InvalidParameterException {
		mutant = new VersionedIdentifierMutant(id, version);
	}
	
	public VersionedIdentifier(Long id, Integer version) throws InvalidParameterException {
		mutant = new VersionedIdentifierMutant(id, version);
	}
	
	public int hashCode() {
		return mutant.hashCode();
	}
	
	public Integer getVersion() {
		return mutant.getVersion();
	}
	
	
	public boolean equals(Object obj) {
		return mutant.equals(obj);
	}

	public Long getId() {
		return mutant.getId();
	}

	public boolean hasValue() {
		return mutant.hasValue();
	}

	
	public String getType() {
		return VersionedIdentifierMutant.TYPE;
	}
	
	public String toString() {
		return mutant.toString(this.getClass());
	}
	
	
}
