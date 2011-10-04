package org.adligo.models.core.client;

import org.adligo.i.util.client.StringUtils;

public class EMailAddressMutant implements I_Mutable, I_Validateable, I_NamedId {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String EMAIL = "email";
	private DomainName domainName;
	private String userName;
	private NamedIdMutant namedId;
	
	/**
	 * mostly only for RPC Serilization
	 * as this class is immutable
	 */
	public EMailAddressMutant() {
		namedId = new NamedIdMutant();
	}
	
	public EMailAddressMutant(I_NamedId other) throws InvalidParameterException {

		if (other == null) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getEmailAddressEmptyError(), EMAIL);
		}
		namedId = new NamedIdMutant(other);
		setName(other.getName());
	}

	public EMailAddressMutant(String email) throws InvalidParameterException {
		namedId = new NamedIdMutant();
		setName(email);
	}
	
	public static void validate(String email) throws InvalidParameterException {
		new EMailAddressMutant(email);
	}

	public DomainName getDomainName() {
		return domainName;
	}

	public String getUserName() {
		return userName;
	}
	
	public String toString() {
		if (namedId.getName() == null) {
			return "'empty email'";
		}
		return namedId.getName();
	}

	public int hashCode() {
		return namedId.hashCode();
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof I_NamedId) {
			I_NamedId other = (I_NamedId) obj;
			if (namedId.equals(other)) {
				return true;
			}
		}
		return false;
	}

	public boolean isMutable() {
		return true;
	}

	public boolean isValid() {
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

	public void setId(I_StorageIdentifier id) throws InvalidParameterException {
		namedId.setId(id);
	}
	
	public String getName() {
		if (namedId != null) {
			return namedId.getName();
		}
		return null;
	}
	
	public void setName(String email) throws InvalidParameterException {

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
		namedId.setName(email);
	}
	
}
