package org.adligo.models.core.client;

import org.adligo.i.util.client.I_Serializable;
import org.adligo.i.util.client.StringUtils;

public class EMailAddress implements I_Mutable, I_Validateable, I_Serializable, I_NamedId {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String EMAIL = "email";
	protected DomainName domainName;
	protected String userName;
	protected NamedId namedId;
	
	/**
	 * mostly only for RPC Serilization
	 * as this class is immutable
	 */
	public EMailAddress() {}
	
	public EMailAddress(EMailAddress other) throws InvalidParameterException {

		if (other == null) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getEmailAddressEmptyError(), EMAIL);
		}
		if (other.namedId == null) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getEmailAddressEmptyError(), EMAIL);
		}
		namedId = new NamedId(other.namedId);
		if (StringUtils.isEmpty(namedId.getName())) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getEmailAddressEmptyError(), EMAIL);
		}
		domainName = other.domainName;
		userName = other.userName;
	}

	public EMailAddress(String email) throws InvalidParameterException {

		if (StringUtils.isEmpty(email)) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getEmailAddressEmptyError(), EMAIL);
		}	
		email = email.trim();
		if (email.length() < 6) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getEmailAddressToShortError(), EMAIL);
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
				throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
						.getEmailAddressNoSpaceError(), EMAIL);
			} else if (!foundAt) {
				userB.append(c);
			} else {
				domainB.append(c);
			}
		}
		if (!foundAt) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getEmailAddressNoAtError(), EMAIL);
		}
		
		userName = userB.toString();
		try {
			domainName = new DomainName(domainB.toString());
		} catch (InvalidParameterException ex) {
			InvalidParameterException toThrow = new InvalidParameterException(
					ModelsCoreConstantsObtainer.getConstants()
						.getEmaiAddressBadDomainError(), EMAIL);
			toThrow.initCause(ex);
			throw toThrow;
		}
		if (userName.length() == 0) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getEmailAddressNoUserError(), EMAIL);
		}
		namedId = new NamedId(email);
	}
	
	public static void validate(String email) throws InvalidParameterException {
		new EMailAddress(email);
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
		if (obj instanceof EMailAddress) {
			EMailAddress other = (EMailAddress) obj;
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

	public I_StorageIdentifier getId() {
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
