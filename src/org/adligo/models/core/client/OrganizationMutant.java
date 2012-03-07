package org.adligo.models.core.client;

import org.adligo.models.core.client.ids.I_StorageIdentifier;



public class OrganizationMutant implements I_OrganizationMutant {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Organization wrapped;

	public OrganizationMutant() {
		wrapped = new Organization();
	}
	
	public OrganizationMutant(I_Organization other) throws InvalidParameterException {
		wrapped = new Organization(other);
	}
	
	public void setId(I_StorageIdentifier p)  throws InvalidParameterException {
		wrapped.setIdP(p);
	}
	
	public void setName(String p) throws InvalidParameterException {
		wrapped.setNameP(p);
	}
	
	public void setType(I_NamedId p) throws InvalidParameterException {
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
