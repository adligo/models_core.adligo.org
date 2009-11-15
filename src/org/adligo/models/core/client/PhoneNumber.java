package org.adligo.models.core.client;

import org.adligo.i.util.client.StringUtils;

import com.google.gwt.user.client.rpc.IsSerializable;

public class PhoneNumber implements IsSerializable 
{
	private static final String DIGITS = "0123456789";
	
	protected StorageIdentifier id;
	protected String number;
	
	public PhoneNumber() {}
	
	public PhoneNumber(PhoneNumber p) throws InvalidParameterException {
		id = p.id;
		setNumberP(p.number);
	}
	
	
	public StorageIdentifier getId() {
		return id;
	}
	public String getNumber() {
		return number;
	}

	protected void setNumberP(String p) throws InvalidParameterException {
		if (StringUtils.isEmpty(p)) {
			throw new InvalidParameterException("Can't accept a empty phone p","setNumber");
		}
		char [] chars = p.toCharArray();
		
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			int index = DIGITS.indexOf(c);
			if (index == -1) {
				throw new InvalidParameterException("A phone number may only have arabic numerals and it had " +
						c,"setNumber");
			}
		}
		number = p;
	}
	
	
}
