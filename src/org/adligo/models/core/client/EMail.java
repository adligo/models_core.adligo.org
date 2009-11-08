package org.adligo.models.core.client;

import org.adligo.i.adi.client.I_Invoker;
import org.adligo.i.adi.client.Registry;
import org.adligo.i.util.client.StringUtils;
import org.adligo.models.core.client.i18n.I_EmailValidationConstants;

public class EMail {
	public static final String EMAIL = "email";
	private static final I_Invoker CONSTANTS_FACTORY = 
		Registry.getInvoker(ModelInvokerNames.CONSTANTS_FACTORY);
	private DomainName domainName;
	private String userName;
	private String asString;
	
	
	public EMail(EMail other) {
		domainName = other.domainName;
		userName = other.userName;
		asString = other.asString;
	}

	public EMail(String email) throws InvalidParameterException {
		I_EmailValidationConstants constants = (I_EmailValidationConstants) 
		CONSTANTS_FACTORY.invoke(I_EmailValidationConstants.class);

		if (StringUtils.isEmpty(email)) {
			throw new InvalidParameterException(constants.getEmptyError(), EMAIL);
		}	
		email = email.trim();
		if (email.length() < 6) {
			if (StringUtils.isEmpty(email)) {
				throw new InvalidParameterException(constants.getToShortError(), EMAIL);
			}
		}
		StringBuffer userB = new StringBuffer();
		StringBuffer domainB = new StringBuffer();
		boolean foundAt = false;
		char [] chars = email.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (c == '@') {
				foundAt = true;
			} else if (c == ' ') {
				throw new InvalidParameterException(constants.getNoSpaceError(), EMAIL);
			} else if (!foundAt) {
				userB.append(c);
			} else {
				domainB.append(c);
			}
		}
		userName = userB.toString();
		try {
			domainName = new DomainName(domainB.toString());
		} catch (InvalidParameterException ex) {
			InvalidParameterException toThrow = new InvalidParameterException(
					constants.getBadDomainError(), EMAIL);
			toThrow.initCause(ex);
			throw toThrow;
		}
		if (userName.length() == 0) {
			if (StringUtils.isEmpty(email)) {
				throw new InvalidParameterException(constants.getNoUserError(), EMAIL);
			}
		}
		
	}
	
	public static void validate(String email) throws InvalidParameterException {
		new EMail(email);
	}

	public DomainName getDomainName() {
		return domainName;
	}

	public String getUserName() {
		return userName;
	}
	
	public String toString() {
		return asString;
	}

	public int hashCode() {
		return asString.hashCode();
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EMail other = (EMail) obj;
		if (asString == null) {
			if (other.asString != null)
				return false;
		} else if (!asString.equals(other.asString))
			return false;
		return true;
	}
	
}
