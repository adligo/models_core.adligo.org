package org.adligo.models.core.client;


public class NamedIdMutant implements I_NamedId {
	private NamedId wrapped;
	
	public NamedIdMutant() {
		wrapped = new NamedId();
	}
	public NamedIdMutant(I_NamedId other) throws InvalidParameterException {
		wrapped = new NamedId(other);
	}
	
	public void setId(I_StorageIdentifier p) throws InvalidParameterException {
		wrapped.setIdP(p);
	}
	
	public void setName(String p) throws InvalidParameterException {
		wrapped.setNameP(p);
	}
	
	public int hashCode() {
		return wrapped.genHashCode();
	}
	public boolean equals(Object obj) {
		return wrapped.equals(obj);
	}
	
	public String toString() {
		return wrapped.toString(this.getClass());
	}
	public I_StorageIdentifier getId() {
		return wrapped.getId();
	}
	public String getName() {
		return wrapped.getName();
	}
}
