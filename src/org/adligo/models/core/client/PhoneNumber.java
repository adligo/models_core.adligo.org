package org.adligo.models.core.client;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.I_Serializable;
import org.adligo.i.util.client.StringUtils;

public class PhoneNumber implements I_Serializable, I_Validateable, I_PhoneNumber
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String PHONE_NUMBER = "PhoneNumber";
	public static final String SET_NUMBER = "setNumber";
	private static final String DIGITS = "0123456789";
	
	private StorageIdentifier id;
	private String number;
	private int hashCode;
	
	public PhoneNumber() {}
	
	public PhoneNumber(I_PhoneNumber p) throws InvalidParameterException {
		
		try {
			if (p.getId() != null) {
				setIdP(p.getId());
			}
			setNumberP(p.getNumber());
			hashCode = genHashCode();
		} catch (InvalidParameterException e) {
			InvalidParameterException ipe = new InvalidParameterException(e.getMessage(), PHONE_NUMBER);
			ipe.initCause(e);
			throw ipe;
		}
	}
	
	
	public I_StorageIdentifier getId() {
		return id;
	}
	
	void setIdP(I_StorageIdentifier p) throws InvalidParameterException {
		try {
			id = new StorageIdentifier(p);
		} catch (InvalidParameterException e) {
			InvalidParameterException ipe = new InvalidParameterException(e.getMessage(), 
					I_StorageMutant.SET_ID);
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

	void setNumberP(String p) throws InvalidParameterException {
		
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
			new PhoneNumber(this);
			return true;
		} catch (InvalidParameterException e) {
			//do nothing
		}
		return false;
	}

	int genHashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	public int hashCode() {
		return hashCode;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof I_PhoneNumber) {
			I_PhoneNumber other = (I_PhoneNumber) obj;
			if (id == null) {
				if (other.getId() != null)
					return false;
			} else if (!id.equals(other.getId()))
				return false;
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
		sb.append(",id=");
		sb.append(id);
		sb.append("]");
		return sb.toString();
	}
	
}
