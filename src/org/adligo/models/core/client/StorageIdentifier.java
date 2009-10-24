package org.adligo.models.core.client;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.StringUtils;

/**
 * this provides a unique identifier for a stored model
 * 
 * @author scott
 *
 */
public class StorageIdentifier {
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
	 */
	private Integer id;
	private int hashCode;
	
	protected StorageIdentifier() {
	}
	
	public StorageIdentifier(StorageIdentifier other) throws InvalidParameterException {
		if (other.key != null || other.id != null) {
			if (other.key != null) {
				setKeyP(other.key);
			}
			if (other.id != null) {
				setIdP(other.id);
			}
		} else {
			throw new InvalidParameterException("A StorageIdentifier must have a key or a id!", "StorageIdentifier");
		}
		genHashCode();
	}
	
	public StorageIdentifier(Integer id) throws InvalidParameterException {
		setIdP(id);
		genHashCode();
	}
	
	public StorageIdentifier(String key) throws InvalidParameterException {
		setKeyP(key);
		genHashCode();
	}
	
	public StorageIdentifier(Integer id, String key) throws InvalidParameterException {
		setKeyP(key);
		setIdP(id);
		genHashCode();
	}
	
	public String getKey() {
		return key;
	}

	public Integer getId() {
		return id;
	}
	
	protected void setKeyP(String p_key) throws InvalidParameterException {
		if (StringUtils.isEmpty(p_key)) {
			throw new InvalidParameterException("StorageIdentifier key can't be set to empty!", "setKey");
		}
		key = p_key;
	}

	protected void setIdP(Integer p_id) throws InvalidParameterException {
		if (p_id == null) {
			throw new InvalidParameterException("StorageIdentifier id can't be set to null!", "setId");
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
	
	@Override
	public int hashCode() {
		return hashCode;
	}

	@Override
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
