package org.adligo.models.core.client.ids;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.StringUtils;
import org.adligo.models.core.client.InvalidParameterException;


public class StringIdentifierMutant implements I_StringIdentifierMutant {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String SET_KEY = "setKey";
	public static final String TYPE = "StringIdentifier";
	public static final String KEY_CANT_BE_SET_TO_EMPTY = "StringIdentifier key can't be set to empty!";
	public static final String NO_KEY_OR_A_ID = "A StringIdentifier must have a key!";
	public static final String CONSTRUCTOR = "Constructor";
	/**
	 * 
	 * used to identify a model in a LDAP server (distinguished name)
	 * or on disk (filename for xml, json, exc)
	 * 
	 */
	protected String key;
	
	public StringIdentifierMutant() {
	}

	public StringIdentifierMutant(String p) throws InvalidParameterException {
		try {
			setKey(p);
		} catch (InvalidParameterException ipe) {
			throw new InvalidParameterException(ipe.getMessage(), CONSTRUCTOR);
		}
	}
	
	public StringIdentifierMutant(I_StringIdentifier p) throws InvalidParameterException {
		if (p == null) {
			throw new InvalidParameterException(NO_KEY_OR_A_ID, CONSTRUCTOR);
		}
		try {
			setKey(p.getKey());
		} catch (InvalidParameterException ipe) {
			throw new InvalidParameterException(ipe.getMessage(), CONSTRUCTOR);
		}
	}	
	
	public int hashCode() {
		if (key == null) {
			return 0;
		}
		return key.hashCode();
	}
	
	public void setKey(String p_key) throws InvalidParameterException {
		if (StringUtils.isEmpty(p_key)) {
			throw new InvalidParameterException(KEY_CANT_BE_SET_TO_EMPTY, SET_KEY);
		}
		key = p_key;
	}

	public boolean equals(Object obj) {
		if (obj != null) {
			try {
				I_StringIdentifier id = (I_StringIdentifier) obj;
				String otherKey = id.getKey();
				if (key == null) {
					if (otherKey == null) {
						return true;
					} else {
						return false;
					}
				}
				if (key.equals(otherKey)) {
					return true;
				}
			} catch (ClassCastException x) {
				//eat gwt doesn't have instance of operator
			}
		}
		return false;		
	}

	public String getKey() {
		return key;
	}

	public boolean hasValue() {
		if (key == null) {
			return false;
		}
		return true;
	}

	public String getType() {
		return TYPE;
	}
	
	public String toString() {
		return toString(this.getClass());
	}
	
	
	String toString(Class c) {
		StringBuffer sb = new StringBuffer();
		sb.append(ClassUtils.getClassShortName(c));
		sb.append(" [key=");
		sb.append(key);
		sb.append("]");
		return sb.toString();
	}
	
	public I_StorageIdentifier toImmutable() {
		try {
			return new StringIdentifier(this);
		} catch (InvalidParameterException x) {
			throw new IllegalStateException(x);
		}
	}
	
	public I_StorageIdentifier toMutant() {
		try {
			return new StringIdentifierMutant(this);
		} catch (InvalidParameterException x) {
			throw new IllegalStateException(x);
		}
	}
}
