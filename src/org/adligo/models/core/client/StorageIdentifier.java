package org.adligo.models.core.client;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.StringUtils;

/**
 * this provides a unique identifier for a stored model
 * Storage Identifier 
 * @author scott
 *
 */
public class StorageIdentifier {
	public static final String SET_ID = "setId";
	public static final String SET_KEY = "setKey";
	public static final String CLAZZ_SIMPLE_NAME = "StorageIdentifier";
	public static final String ID_CANT_BE_SET_TO_NULL = "StorageIdentifier id can't be set to null!";
	public static final String KEY_CANT_BE_SET_TO_EMPTY = "StorageIdentifier key can't be set to empty!";
	public static final String NO_KEY_OR_A_ID = "A StorageIdentifier must have a key or a id!";
	
	/**
	 * 
	 * used to identify a model in a LDAP server (distinguished name)
	 * or on disk (filename for xml, json, exc)
	 * 
	 */
	private String key;
	/**
	 * used to identify a model in a RDBMS (Database)
	 * 
	 * Long biggest common unit available on j2me, gwt and j2se
	 */
	private Long id;
	private int hashCode;
	
	protected StorageIdentifier() {
	}
	
	public StorageIdentifier(StorageIdentifier other) {
		id = other.id;
		key = other.key;
		genHashCode();
	}
	
	public StorageIdentifier(StorageIdentifierMutant other) throws InvalidParameterException {
		if (other.getKey() != null || other.getId() != null) {
			if (other.getKey() != null) {
				setKeyP(other.getKey());
			} 
			if (other.getId() != null){
				setIdP(other.getId());
			}
		} else {
			throw new InvalidParameterException(NO_KEY_OR_A_ID, CLAZZ_SIMPLE_NAME);
		}
		genHashCode();
	}
	
	public StorageIdentifier(Long id) throws InvalidParameterException {
		setIdP(id);
		genHashCode();
	}
	
	public StorageIdentifier(String key) throws InvalidParameterException {
		setKeyP(key);
		genHashCode();
	}
	
	public StorageIdentifier(Long id, String key) throws InvalidParameterException {
		setKeyP(key);
		setIdP(id);
		genHashCode();
	}
	
	public String getKey() {
		return key;
	}

	public Long getId() {
		return id;
	}
	
	protected void setKeyP(String p_key) throws InvalidParameterException {
		if (StringUtils.isEmpty(p_key)) {
			throw new InvalidParameterException(KEY_CANT_BE_SET_TO_EMPTY, SET_KEY);
		}
		key = p_key;
	}

	protected void setIdP(Long p_id) throws InvalidParameterException {
		if (p_id == null) {
			throw new InvalidParameterException(ID_CANT_BE_SET_TO_NULL, SET_ID);
		}
		id = p_id;
	}

	
	public int genHashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		hashCode = result;
		return result;
	}
	
	public int hashCode() {
		return hashCode;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		//allow extensions to equal
		StorageIdentifier other = (StorageIdentifier) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
	public boolean hasValue() {
		if (id == null && key == null) {
			return false;
		}
		return true;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(ClassUtils.getClassShortName(this.getClass()));
		sb.append(" [id=");
		sb.append(id);
		sb.append(",key=");
		sb.append(key);
		sb.append("]");
		return sb.toString();
	}
}
