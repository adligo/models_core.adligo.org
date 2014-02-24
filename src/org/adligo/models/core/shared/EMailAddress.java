package org.adligo.models.core.shared;

import org.adligo.i.util.shared.I_Immutable;
import org.adligo.i.util.shared.StringUtils;

public class EMailAddress implements I_Immutable {
	
	public static final String EMAIL = "email";
	private DomainName domainName;
	private String userName;
	private String email;
	
	/**
	 * mostly only for RPC Serilization
	 * as this class is immutable
	 */
	public EMailAddress() {
	}
	

	public EMailAddress(String email) throws InvalidParameterException {
		this.email = email;
		setName(email);
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
		return email;
	}

	public int hashCode() {
		if (email == null) {
			return 0;
		}
		return email.hashCode();
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof EMailAddress) {
			EMailAddress other = (EMailAddress) obj;
			if (email.equals(other.getEMail())) {
				return true;
			}
		}
		return false;
	}

	public boolean isMutable() {
		return false;
	}

	public boolean isValid() {
		if (StringUtils.isEmpty(email)) {
			return false;
		}
		return true;
	}

	private void setName(String email) throws InvalidParameterException {

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
						.getEmaiAddressBadDomainError(), EMAIL, ex);
			throw toThrow;
		}
		if (userName.length() == 0) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getEmailAddressNoUserError(), EMAIL);
		}
		this.email = email;
	}

	public String getEMail() {
		return email;
	}
	
	public String getImmutableFieldName() {
		return "email";
	}
	
}
