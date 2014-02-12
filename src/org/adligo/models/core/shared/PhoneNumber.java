package org.adligo.models.core.shared;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.I_Immutable;
import org.adligo.i.util.client.StringUtils;

public class PhoneNumber implements I_Validateable, I_PhoneNumber, I_Immutable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String PHONE_NUMBER = "PhoneNumber";
	public static final String SET_NUMBER = "setNumber";
	private static final String DIGITS = "0123456789";
	
	protected String number;
	
	public PhoneNumber() {}
	
	public PhoneNumber(String number) throws InvalidParameterException {
		try {
			setNumber(number);
		} catch (InvalidParameterException e) {
			throw new InvalidParameterException(e.getMessage(), PHONE_NUMBER, e);
		}
	}
	
	public PhoneNumber(I_PhoneNumber p) throws InvalidParameterException {
		try {
			setNumber(p.getNumber());
		} catch (InvalidParameterException e) {
			throw new InvalidParameterException(e.getMessage(), PHONE_NUMBER, e);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_PhoneNumber#getNumber()
	 */
	public String getNumber() {
		return number;
	}

	private void setNumber(String p) throws InvalidParameterException {
		
		if (StringUtils.isEmpty(p)) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getPhoneEmptyError(),SET_NUMBER);
		}
		char [] chars = p.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			int index = DIGITS.indexOf(c);
			if (index == -1) {
				throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
						.getPhoneInvalidCharacterError(),SET_NUMBER);
			}
		}
		number = p;
	}
	
	public void isValid() throws ValidationException {
		try {
			new PhoneNumber(this);
		} catch (InvalidParameterException e) {
			throw new ValidationException(e.getMessage(), I_Validateable.IS_VALID, e);
		}
	}

	public int hashCode() {
		if (number == null) {
			return 0;
		}
		return number.hashCode();
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof I_PhoneNumber) {
			I_PhoneNumber other = (I_PhoneNumber) obj;
			if (number == null) {
				if (other.getNumber() != null)
					return false;
			} else if (!number.equals(other.getNumber()))
				return false;
			return true;
		}
		return false;
	}
	
	public String toString() {
		return number;
	}

	public String getImmutableFieldName() {
		return "number";
	}
	
	
}
