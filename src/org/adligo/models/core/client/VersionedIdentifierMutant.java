package org.adligo.models.core.client;

import java.lang.Long;

public class VersionedIdentifierMutant implements I_VersionedIdentifier {
	private VersionedIdentifier wrapped;
	
	public VersionedIdentifierMutant() {
		wrapped = new VersionedIdentifier();
	}
	
	public int hashCode() {
		return wrapped.genHashCode();
	}
	
	public VersionedIdentifierMutant(I_VersionedIdentifier other) throws InvalidParameterException {
		wrapped = new VersionedIdentifier(other);
	}
	
	public Integer getVersion() {
		return wrapped.getVersion();
	}
	
	public void setVersion(Integer version) throws InvalidParameterException {
		wrapped.setVersionP(version);
	}

	public void setId(Long id) throws InvalidParameterException {
		wrapped.setIdP(id);
	}

	public void setId(Integer id) throws InvalidParameterException {
		wrapped.setIdP(new Long(id.longValue())); 
	}
	
	public boolean equals(Object obj) {
		return wrapped.equals(obj);
	}

	public Long getId() {
		return wrapped.getId();
	}

	public boolean hasValue() {
		return wrapped.hasValue();
	}

	public String toString() {
		return wrapped.toString(this.getClass());
	}
}
