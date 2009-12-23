package org.adligo.models.core.client;


public class StringIdentifierMutant implements I_StringIdentifier {
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

	public String toString() {
		return wrapped.toString(this.getClass());
	}
}