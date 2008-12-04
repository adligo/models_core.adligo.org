package org.adligo.models.core;

public class PhoneNumber {
	protected Integer id;
	protected String number;
	protected boolean recieves_faxes;
	private int hash_code;
	
	protected PhoneNumber() {}
	
	public PhoneNumber(PhoneNumber p) {
		id = p.id;
		number = p.number;
		recieves_faxes = p.recieves_faxes;
		
	}
	
	
	public Integer getId() {
		return id;
	}
	public String getNumber() {
		return number;
	}
	public boolean isRecieves_faxes() {
		return recieves_faxes;
	}

	
	
}
