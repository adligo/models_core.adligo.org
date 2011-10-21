package org.adligo.models.core.client;



public class PhoneNumber implements I_PhoneNumber {
	private PhoneNumberMutant wrapped;
	
	public PhoneNumber() {
		wrapped = new PhoneNumberMutant();
	}
	
	public PhoneNumber(I_PhoneNumber p) throws InvalidParameterException {
		wrapped = new PhoneNumberMutant(p);
	}
	
	public void setNumber(String p) throws InvalidParameterException {
		wrapped.setNumber(p);
	}
	
	public int hashCode() {
		return wrapped.hashCode();
	}

	public boolean equals(Object obj) {
		return wrapped.equals(obj);
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
