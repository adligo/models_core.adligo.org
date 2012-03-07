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
	
	public static final String SET_KEY = "setKey";
	public static final String CLAZZ_SIMPLE_NAME = "StringIdentifier";
	public static final String KEY_CANT_BE_SET_TO_EMPTY = "StringIdentifier key can't be set to empty!";
	public static final String NO_KEY_OR_A_ID = "A StringIdentifier must have a key!";
	
	/**
	 * 
	 * used to identify a model in a LDAP server (distinguished name)
	 * or on disk (filename for xml, json, exc)
	 * 
	 */
	protected String key;
	
	public StringIdentifier() {
	}
	
	
	public StringIdentifier(I_StringIdentifier other) throws InvalidParameterException {
		if (other == null) {
			throw new InvalidParameterException(NO_KEY_OR_A_ID, CLAZZ_SIMPLE_NAME);
		}
		if (other.getKey() != null) {
			if (other.getKey() != null) {
				setKeyP(other.getKey());
			} 
		} else {
			throw new InvalidParameterException(NO_KEY_OR_A_ID, CLAZZ_SIMPLE_NAME);
		}
	}
	
	public StringIdentifier(String key) throws InvalidParameterException {
		setKeyP(key);
	}
	
	public String getKey() {
		return key;
	}

	void setKeyP(String p_key) throws InvalidParameterException {
		if (StringUtils.isEmpty(p_key)) {
			throw new InvalidParameterException(KEY_CANT_BE_SET_TO_EMPTY, SET_KEY);
		}
		key = p_key;
	}

	public int hashCode() {
		if (key == null) {
			return 0;
		}
		return key.hashCode();
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		//allow extensions to equal
		I_StringIdentifier other = null;
		if (obj instanceof I_StringIdentifier) {
			other = (I_StringIdentifier) obj;
		}
		if (other == null) {
			return false;
		}
		if (key == null) {
			if (other.getKey() != null)
				return false;
		} else if (!key.equals(other.getKey()))
			return false;
		return true;
	}
	
	public boolean hasValue() {
		if (key == null) {
			return false;
		}
		return true;
	}
	
	public String toString() {
		return toString(this.getClass());
	}
	
	public String toString(Class c) {
		StringBuffer sb = new StringBuffer();
		sb.append(ClassUtils.getClassShortName(c));
		sb.append(" [key=");
		sb.append(key);
		sb.append("]");
		return sb.toString();
	}
}
