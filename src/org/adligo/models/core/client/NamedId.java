package org.adligo.models.core.client;

import org.adligo.i.util.client.ClassUtils;

import com.google.gwt.user.client.rpc.IsSerializable;


public class NamedId implements I_NamedId, IsSerializable {
	public static final String SET_ID = "setId";
	public static final String SET_NAME = "setName";
	
	protected StorageIdentifier id;
	protected String name;
	private int hash_code;
	
	public NamedId(NamedId p) {
		id = p.id;
		name = p.name;
		hash_code = genHashCode();
	}
	
	public NamedId(NamedIdMutant p) throws InvalidParameterException {
		setIdP(p.id);
		setNameP(p.name);
		hash_code = genHashCode();
	}
	
	public NamedId(String p_name) throws InvalidParameterException {
		setNameP(p_name);
		hash_code = genHashCode();
	}
	
	public NamedId(String p_name, StorageIdentifier p_id) throws InvalidParameterException {
		setNameP(p_name);
		setIdP(p_id);
		hash_code = genHashCode();
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
