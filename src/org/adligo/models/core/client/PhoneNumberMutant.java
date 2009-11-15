package org.adligo.models.core.client;



public class PhoneNumberMutant extends PhoneNumber {
	
	public PhoneNumberMutant() {
		super();
	}
	
	public PhoneNumberMutant(PhoneNumber other) throws InvalidParameterException {
		super(other);
	}
	
	public void setId(StorageIdentifier p) throws InvalidParameterException {
		super.setIdP(p);
	}
	public void setNumber(String p) throws InvalidParameterException {
		super.setNumberP(p);
	}
	
	public int hashCode() {
		return super.genHashCode();
	}
	
}
