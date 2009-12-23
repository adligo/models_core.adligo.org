package org.adligo.models.core.client;



public class OrganizationMutant implements I_Org {
	private Organization wrapped;

	public OrganizationMutant() {
		wrapped = new Organization();
	}
	
	public OrganizationMutant(I_Org other) throws InvalidParameterException {
		wrapped = new Organization(other);
	}
	
	public void setId(StringIdentifier p)  throws InvalidParameterException {
		wrapped.setIdP(p);
	}
	
	public void setName(String p) throws InvalidParameterException {
		wrapped.setNameP(p);
	}
	
	public void setType(NamedId p) throws InvalidParameterException {
		wrapped.setTypeP(p);
	}

	public I_NamedId getType() {
		return wrapped.getType();
	}

	public String getName() {
		return wrapped.getName();
	}

	public I_StorageIdentifier getId() {
		return wrapped.getId();
	}

	public boolean equals(Object obj) {
		return wrapped.equals(obj);
	}

	public int hashCode() {
		return wrapped.genHashCode();
	}

	public String toString() {
		return wrapped.toString(this.getClass());
	}

	public boolean isValid() {
		return wrapped.isValid();
	}
	
}
