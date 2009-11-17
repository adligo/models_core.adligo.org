package org.adligo.models.core.client;

import org.adligo.i.adi.client.I_Invoker;
import org.adligo.i.adi.client.Registry;
import org.adligo.i.util.client.I_Serializable;
import org.adligo.i.util.client.StringUtils;
import org.adligo.models.core.client.i18n.I_EmailValidationConstants;

public class EMail implements I_Mutable, I_Validateable, I_Serializable, I_NamedId {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String EMAIL = "email";
	private static final I_Invoker CONSTANTS_FACTORY = 
		Registry.getInvoker(ModelInvokerNames.CONSTANTS_FACTORY);
	private DomainName domainName;
	private String userName;
	private NamedId namedId;
	
	/**
	 * mostly only for RPC Serilization
	 * as this class is immutable
	 */
	public EMail() {}
	
	public EMail(EMail other) throws InvalidParameterException {
		I_EmailValidationConstants constants = (I_EmailValidationConstants) 
				CONSTANTS_FACTORY.invoke(I_EmailValidationConstants.class);

		if (other == null) {
			throw new InvalidParameterException(constants.getEmptyError(), EMAIL);
		}
		if (other.namedId == null) {
			throw new InvalidParameterException(constants.getEmptyError(), EMAIL);
		}
		namedId = new NamedId(other.namedId);
		if (StringUtils.isEmpty(namedId.getName())) {
			throw new InvalidParameterException(constants.getEmptyError(), EMAIL);
		}
		domainName = other.domainName;
		userName = other.userName;
	}

	public EMail(String email) throws InvalidParameterException {
		I_EmailValidationConstants constants = (I_EmailValidationConstants) 
				CONSTANTS_FACTORY.invoke(I_EmailValidationConstants.class);

		if (StringUtils.isEmpty(email)) {
			throw new InvalidParameterException(constants.getEmptyError(), EMAIL);
		}	
		email = email.trim();
		if (email.length() < 6) {
			throw new InvalidParameterException(constants.getToShortError(), EMAIL);
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
		if (!foundAt) {
			throw new InvalidParameterException(constants.getNoAtError(), EMAIL);
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
			throw new InvalidParameterException(constants.getNoUserError(), EMAIL);
		}
		namedId = new NamedId(email);
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
		if (namedId == null) {
			return "'empty email'";
		}
		if (namedId.getName() == null) {
			return "'empty email'";
		}
		return namedId.getName();
	}

	public int hashCode() {
		if (namedId == null) {
			return 0;
		}
		return namedId.hashCode();
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof EMail) {
			EMail other = (EMail) obj;
			if (namedId == null) {
				if (other.namedId != null)
					return false;
			} else if (!namedId.equals(other.namedId))
				return false;
			return true;
		}
		return false;
	}

	public boolean isMutable() {
		return false;
	}

	public boolean isValid() {
		if (namedId == null) {
			return false;
		}
		if (StringUtils.isEmpty(namedId.getName())) {
			return false;
		}
		return true;
	}

	public StorageIdentifier getId() {
		if (namedId != null) {
			return namedId.getId();
		}
		return null;
	}

	public String getName() {
		if (namedId != null) {
			return namedId.getName();
		}
		return null;
	}
	
}
