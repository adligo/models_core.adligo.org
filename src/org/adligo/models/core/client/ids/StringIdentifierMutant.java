package org.adligo.models.core.client.ids;

import org.adligo.models.core.client.InvalidParameterException;


public class StringIdentifierMutant implements I_StringIdentifierMutant {
	private StringIdentifier wrapped;
	
	public StringIdentifierMutant() {
		wrapped = new StringIdentifier();
	}
	
	public int hashCode() {
		return wrapped.hashCode();
	}
	
	public void setKey(String key) throws InvalidParameterException {
		wrapped.setKeyP(key);
	}

	public boolean equals(Object obj) {
		return wrapped.equals(obj);
	}

	public String getKey() {
		return wrapped.getKey();
	}

	public boolean hasValue() {
		return wrapped.hasValue();
	}

	@Override
	public String getType() {
		return StringIdentifier.TYPE;
	}
	
	public String toString() {
		return wrapped.toString(this.getClass());
	}
}
