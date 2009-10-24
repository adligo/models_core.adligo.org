package org.adligo.models.core.client;

public class PhoneNumber {
	protected Integer id;
	protected String number;
	private int hash_code;
	
	protected PhoneNumber() {}
	
	public PhoneNumber(PhoneNumber p) {
		id = p.id;
		number = p.number;
	}
	
	
	public Integer getId() {
		return id;
	}
	public String getNumber() {
		return number;
	}

	
	
}
