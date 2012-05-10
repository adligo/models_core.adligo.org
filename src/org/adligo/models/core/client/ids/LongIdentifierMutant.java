package org.adligo.models.core.client.ids;

import java.lang.Long;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.models.core.client.InvalidParameterException;

public class LongIdentifierMutant implements I_LongIdentifierMutant {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String SET_ID = "setId";
	public static final String TYPE = "LongIdentifier";
	public static final String ID_CANT_BE_SET_TO_NULL = "LongIdentifier id can't be set to null!";
	public static final String CONSTRUCTOR = "Constructor";
	
	private Long id;
	
	public LongIdentifierMutant() {}
	
	public LongIdentifierMutant(I_LongIdentifier p) throws InvalidParameterException {
		if (p == null) {
			throw new InvalidParameterException(TYPE, CONSTRUCTOR);
		}
		setId(p.getId());
		
	}

	public LongIdentifierMutant(Long p) throws InvalidParameterException {
		if (p == null) {
			throw new InvalidParameterException(TYPE, CONSTRUCTOR);
		}
		setId(p);
	}
	
	public void setId(Long p) throws InvalidParameterException {
		if (p == null) {
			throw new InvalidParameterException(TYPE, ID_CANT_BE_SET_TO_NULL);
		}
		id = p;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		try {
			I_LongIdentifier other = (I_LongIdentifier) obj;
			if (other.getId().equals(id)) {
				return true;
			}
		} catch (ClassCastException x) {
			//eat
		}
		return false;
	}

	public String toString() {
		return toString(this.getClass());
	}

	String toString(Class c) {
		StringBuffer sb = new StringBuffer();
		sb.append(ClassUtils.getClassShortName(c));
		sb.append(" [id=");
		sb.append(id);
		sb.append("]");
		return sb.toString();
	}
	
	public Long getId() {
		return id;
	}

	public boolean hasValue() {
		if (id == null) {
			return false;
		}
		return true;
	}

	public String getType() {
		return LongIdentifierMutant.TYPE;
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
