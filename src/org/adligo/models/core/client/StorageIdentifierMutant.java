package org.adligo.models.core.client;


public class StorageIdentifierMutant implements I_StorageIdentifier {
	private StorageIdentifier wrapped;
	
	public StorageIdentifierMutant() {
		wrapped = new StorageIdentifier();
	}
	
	public int hashCode() {
		return wrapped.genHashCode();
	}
	
	public StorageIdentifierMutant(I_StorageIdentifier other) throws InvalidParameterException {
		wrapped = new StorageIdentifier(other);
	}
	
	public void setKey(String key) throws InvalidParameterException {
		wrapped.setKeyP(key);
	}

	public void setId(Long id) throws InvalidParameterException {
		wrapped.setIdP(id);
	}

	public boolean equals(Object obj) {
		return wrapped.equals(obj);
	}

	public Long getId() {
		return wrapped.getId();
	}

	public String getKey() {
		return wrapped.getKey();
	}

	public boolean hasValue() {
		return wrapped.hasValue();
	}

	public String toString() {
		return wrapped.toString(this.getClass());
	}

	protected StorageIdentifier getWrapped() {
		return wrapped;
	}
	
}
