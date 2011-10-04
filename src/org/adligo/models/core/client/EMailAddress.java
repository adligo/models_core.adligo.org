package org.adligo.models.core.client;

import org.adligo.i.util.client.StringUtils;

public class EMailAddress implements I_Mutable, I_Validateable, I_NamedId {
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
	
	public EMailAddress(I_NamedId other) throws InvalidParameterException {
		mutant = new EMailAddressMutant(other);
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

	public I_StorageIdentifier getId() {
		return mutant.getId();
	}

	public String getName() {
		return mutant.getName();
	}

	public String toString() {
		return mutant.toString();
	}
}
