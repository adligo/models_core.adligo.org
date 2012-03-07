package org.adligo.models.core.client.ids;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.StringUtils;
import org.adligo.models.core.client.InvalidParameterException;

/**
 * this provides a unique identifier for a stored model
 * Storage Identifier 
 * for a LDAP server (key is dn in this case)
 * or a FileSystem (key is the java.io.File pathname constructor)
 * 
 * Note the errors are not internationalized because
 * they are primarily for programmers who write code in English.
 * 
 * @author scott
 *
 */
public class StringIdentifier implements I_StringIdentifier {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StringIdentifierMutant mutant;
	
	public StringIdentifier() {
		mutant = new StringIdentifierMutant();
	}
	
	public StringIdentifier(String p) throws InvalidParameterException {
		mutant = new StringIdentifierMutant(p);
	}
	
	public StringIdentifier(I_StringIdentifier other) throws InvalidParameterException {
		mutant = new StringIdentifierMutant(other);
	}
	
	
	public String getKey() {
		return mutant.getKey();
	}

	public int hashCode() {
		return mutant.hashCode();
	}

	public boolean equals(Object obj) {
		return mutant.equals(obj);
	}
	
	public boolean hasValue() {
		return mutant.hasValue();
	}
	@Override
	public String getType() {
		return StringIdentifierMutant.TYPE;
	}
	
	public String toString() {
		return mutant.toString(this.getClass());
	}
}
