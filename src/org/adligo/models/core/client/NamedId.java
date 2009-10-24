package org.adligo.models.core.client;

import java.io.Serializable;

public class NamedId implements I_NamedId, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Integer id;
	protected String name;
	private int hash_code;
	
	public NamedId(NamedId p) {
		id = p.id;
		name = p.name;
		hash_code = genHashCode();
	}
	
	protected NamedId() {}
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public int hashCode() {
		return hash_code;
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
