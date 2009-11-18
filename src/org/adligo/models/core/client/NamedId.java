package org.adligo.models.core.client;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.I_Serializable;


public class NamedId implements I_NamedId, I_Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ID_NULL = "You set the id to null?";
	public static final String ID_EMPTY = "You called set id with a invalid object.";
	public static final String NULL_TO_CONSTRUCTOR =  "you passed null to NamedId";
	public static final String NAMED_ID = "NamedId";
	public static final String SET_ID = "setId";
	public static final String SET_NAME = "setName";
	
	protected StorageIdentifier id;
	protected String name;
	private int hash_code;
	
	public NamedId(NamedId p) throws InvalidParameterException {
		if (p == null) {
			throw new InvalidParameterException(NULL_TO_CONSTRUCTOR, NAMED_ID);
		}
		try {
			if (p.id != null) {
				setIdP(p.id);
			}
			setNameP(p.name);
			hash_code = genHashCode();
		} catch ( InvalidParameterException e) {
			InvalidParameterException ipe = new InvalidParameterException(e.getMessage(), NAMED_ID);
			ipe.initCause(e);
			throw ipe;
		}
	}
	
	public NamedId(String p_name) throws InvalidParameterException {
		setNameP(p_name);
		hash_code = genHashCode();
	}
	
	public NamedId(String p_name, StorageIdentifier p_id) throws InvalidParameterException {
		try {
			setNameP(p_name);
			if (p_id != null) {
				setIdP(p_id);
			}
			hash_code = genHashCode();
		} catch ( InvalidParameterException e) {
			InvalidParameterException ipe = new InvalidParameterException(e.getMessage(), NAMED_ID);
			ipe.initCause(e);
			throw ipe;
		}
	}
	public NamedId() {}
	
	public StorageIdentifier getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public int hashCode() {
		return hash_code;
	}
	
	/**
	 * allow sub class to throw exception if necessary
	 * 
	 * @param p_id
	 * @throws InvalidParameterException
	 */
	protected void setIdP(StorageIdentifier p_id) throws InvalidParameterException {
		if (p_id == null) {
			throw new InvalidParameterException(ID_NULL, I_StorageMutant.SET_ID);
		}
		if (!p_id.hasValue()) {
			throw new InvalidParameterException(ID_EMPTY, I_StorageMutant.SET_ID);
		}
		id = p_id;
	}
	
	protected void setNameP(String p_name) throws InvalidParameterException {
		name = p_name;
	}
	protected int genHashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof NamedId) {
			final NamedId other = (NamedId) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		return false;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(ClassUtils.getClassShortName(this.getClass()));
		sb.append(" [name=");
		sb.append(name);
		sb.append(",id=");
		sb.append(id);
		sb.append("]");
		
		return sb.toString();
	}
}
