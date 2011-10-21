package org.adligo.models.core.client;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.StringUtils;

public class PhoneNumberMutant implements I_Validateable, I_PhoneNumberMutant
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String PHONE_NUMBER = "PhoneNumber";
	public static final String SET_NUMBER = "setNumber";
	private static final String DIGITS = "0123456789";
	
	protected String number;
	
	public PhoneNumberMutant() {}
	
	public PhoneNumberMutant(I_PhoneNumber p) throws InvalidParameterException {
		
		try {
			setNumber(p.getNumber());
		} catch (InvalidParameterException e) {
			InvalidParameterException ipe = new InvalidParameterException(e.getMessage(), PHONE_NUMBER);
			ipe.initCause(e);
			throw ipe;
		}
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_PhoneNumber#getNumber()
	 */
	public String getNumber() {
		return number;
	}

	public void setNumber(String p) throws InvalidParameterException {
		
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
	
	public boolean isValid() {
		try {
			new PhoneNumberMutant(this);
			return true;
		} catch (InvalidParameterException e) {
			//do nothing
		}
		return false;
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
		return toString(this.getClass());
	}
	
	public String toString(Class c) {
		StringBuffer sb = new StringBuffer();
		sb.append(ClassUtils.getClassShortName(c));
		sb.append(" [number=");
		sb.append(number);
		sb.append("]");
		return sb.toString();
	}
	
}
