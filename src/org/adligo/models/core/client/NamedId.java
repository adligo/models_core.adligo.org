package org.adligo.models.core.client;


public class NamedId implements I_NamedId {
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
	
	protected NamedId() {}
	
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
		if (getClass() != obj.getClass())
			return false;
		final NamedId other = (NamedId) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
}
