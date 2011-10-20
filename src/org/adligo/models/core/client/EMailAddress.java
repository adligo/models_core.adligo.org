package org.adligo.models.core.client;


public class EMailAddress implements I_EMailAddress {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EMailAddressMutant mutant;
	
	/**
	 * mostly only for RPC Serilization
	 * as this class is immutable
	 */
	public EMailAddress() {
		mutant = new EMailAddressMutant();
	}
	
	public EMailAddress(I_EMailAddress address) throws InvalidParameterException {
		if (address == null) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getEmailAddressEmptyError(), EMailAddressMutant.EMAIL);
		}
		String email = address.getEMail();
		mutant = new EMailAddressMutant(email);
	}

	public EMailAddress(String email) throws InvalidParameterException {
		mutant = new EMailAddressMutant(email);
	}
	
	public static void validate(String email) throws InvalidParameterException {
		new EMailAddress(email);
	}

	public DomainName getDomainName() {
		return mutant.getDomainName();
	}

	public String getUserName() {
		return mutant.getUserName();
	}

	public int hashCode() {
		return mutant.hashCode();
	}

	public boolean equals(Object obj) {
		return mutant.equals(obj);
	}

	public boolean isMutable() {
		return false;
	}

	public boolean isValid() {
		return mutant.isValid();
	}

	public String toString() {
		return mutant.toString();
	}

	@Override
	public String getEMail() {
		return mutant.getEMail();
	}
}
