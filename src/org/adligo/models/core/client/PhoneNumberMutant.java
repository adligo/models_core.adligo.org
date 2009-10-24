package org.adligo.models.core.client;

import org.adligo.i.util.client.StringUtils;

public class PhoneNumberMutant extends PhoneNumber {
	private static final String DIGITS = "0123456789";
	
	public void setId(Integer p) {
		id = p;
	}
	public void setNumber(String p) throws InvalidParameterException {
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
