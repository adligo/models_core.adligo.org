package org.adligo.models.core.client;



public class PhoneNumberMutant implements I_PhoneNumber {
	private PhoneNumber wrapped;
	
	public PhoneNumberMutant() {
		wrapped = new PhoneNumber();
	}
	
	public PhoneNumberMutant(I_PhoneNumber p) throws InvalidParameterException {
		wrapped = new PhoneNumber(p);
	}
	
	public void setId(StringIdentifier p) throws InvalidParameterException {
		wrapped.setIdP(p);
	}
	public void setNumber(String p) throws InvalidParameterException {
		wrapped.setNumberP(p);
	}
	
	public int hashCode() {
		return wrapped.genHashCode();
	}

	public boolean equals(Object obj) {
		return wrapped.equals(obj);
	}

	public I_StorageIdentifier getId() {
		return wrapped.getId();
	}

	public String getNumber() {
		return wrapped.getNumber();
	}

	public boolean isValid() {
		return wrapped.isValid();
	}

	public String toString() {
		return wrapped.toString(this.getClass());
	}
	
}
