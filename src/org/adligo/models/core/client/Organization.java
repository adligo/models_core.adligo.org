package org.adligo.models.core.client;


public class Organization implements I_NamedId {
	
	protected Integer id;
	protected String name;
	/**
	 * the type pertains to something like a School, Band, Company
	 * to be defined depending on your problem domain 
	 */
	protected NamedId type;
	private int hash_code;
	
	public Organization(Organization p) {
		id = p.id;
		name = p.name;
		type = p.type;
		hash_code = genHashCode();
	}
	
	protected Organization() {}
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public NamedId getType() {
		return type;
	}

	public int hashCode() {
		return hash_code;
	}
	
	protected int genHashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Organization other = (Organization) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}


	
}
