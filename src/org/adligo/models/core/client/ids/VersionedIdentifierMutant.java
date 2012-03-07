package org.adligo.models.core.client.ids;

import java.lang.Long;

import org.adligo.models.core.client.InvalidParameterException;

public class VersionedIdentifierMutant implements I_VersionedIdentifierMutant {
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
		wrapped.setVersion(version);
	}

	public void setId(Long id) throws InvalidParameterException {
		wrapped.setId(id);
	}

	public void setId(Integer id) throws InvalidParameterException {
		wrapped.setId(new Long(id.longValue())); 
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
