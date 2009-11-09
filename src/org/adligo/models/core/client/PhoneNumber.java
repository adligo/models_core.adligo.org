package org.adligo.models.core.client;

public class PhoneNumber {
	protected StorageIdentifier id;
	protected String number;
	
	public PhoneNumber() {}
	
	public PhoneNumber(PhoneNumber p) {
		id = p.id;
		number = p.number;
	}
	
	
	public StorageIdentifier getId() {
		return id;
	}
	public String getNumber() {
		return number;
	}

	
	
}
