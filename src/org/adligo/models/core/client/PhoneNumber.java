package org.adligo.models.core.client;

import org.adligo.i.adi.client.I_Invoker;
import org.adligo.i.adi.client.Registry;
import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.StringUtils;
import org.adligo.models.core.client.i18n.I_PhoneNumberValidationConstants;

import com.google.gwt.user.client.rpc.IsSerializable;

public class PhoneNumber implements IsSerializable, I_Validateable
{
	public static final String PHONE_NUMBER = "PhoneNumber";
	public static final String SET_NUMBER = "setNumber";
	private static final I_Invoker CONSTANTS_FACTORY = 
		Registry.getInvoker(ModelInvokerNames.CONSTANTS_FACTORY);
	private static final String DIGITS = "0123456789";
	
	protected StorageIdentifier id;
	protected String number;
	private int hashCode;
	
	public PhoneNumber() {}
	
	public PhoneNumber(PhoneNumber p) throws InvalidParameterException {
		
		try {
			if (p.getId() != null) {
				setIdP(p.getId());
			}
			setNumberP(p.number);
			hashCode = genHashCode();
		} catch (InvalidParameterException e) {
			InvalidParameterException ipe = new InvalidParameterException(e.getMessage(), PHONE_NUMBER);
			ipe.initCause(e);
			throw ipe;
		}
	}
	
	
	public StorageIdentifier getId() {
		return id;
	}
	
	protected void setIdP(StorageIdentifier p) throws InvalidParameterException {
		try {
			id = new StorageIdentifier(p);
		} catch (InvalidParameterException e) {
			InvalidParameterException ipe = new InvalidParameterException(e.getMessage(), 
					I_StorageMutant.SET_ID);
			ipe.initCause(e);
			throw ipe;
		}
	}
	
	public String getNumber() {
		return number;
	}

	protected void setNumberP(String p) throws InvalidParameterException {
		I_PhoneNumberValidationConstants csts = (I_PhoneNumberValidationConstants) 
				CONSTANTS_FACTORY.invoke(I_PhoneNumberValidationConstants.class);
		
		if (StringUtils.isEmpty(p)) {
			throw new InvalidParameterException(csts.getEmptyError(),SET_NUMBER);
		}
		char [] chars = p.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			int index = DIGITS.indexOf(c);
			if (index == -1) {
				throw new InvalidParameterException(csts.getInvalidCharacterError(),SET_NUMBER);
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

	protected int genHashCode() {
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
		if (obj instanceof PhoneNumber) {
			PhoneNumber other = (PhoneNumber) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (number == null) {
				if (other.number != null)
					return false;
			} else if (!number.equals(other.number))
				return false;
			return true;
		}
		return false;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(ClassUtils.getClassShortName(this.getClass()));
		appendFields(sb);
		return sb.toString();
	}
	
	protected void appendFields(StringBuffer sb) {
		sb.append(" [number=");
		sb.append(number);
		sb.append(",id=");
		sb.append(id);
		sb.append("]");
	}
}
