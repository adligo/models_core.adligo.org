package org.adligo.models.core.client;

import org.adligo.i.util.client.I_Immutable;
import org.adligo.models.core.client.ids.I_StorageIdentifier;


public class User implements I_User, I_Immutable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserMutant wrapped;
	/**
	 * keep seperate for immutability
	 */
	private I_StorageIdentifier id;
	private I_DomainName domain;
	private I_EMailAddress emailAddress;
	
	public User() {
		wrapped = new UserMutant();
	}
	
	public User(String userId, String domain ) throws InvalidParameterException {
		wrapped = new UserMutant(userId, domain);
		setImmutables();
	}
	
	public User(I_User p) throws InvalidParameterException {
		wrapped = new UserMutant(p);
		setImmutables();
	}
	
	private void setImmutables() throws InvalidParameterException {
		I_StorageIdentifier otherId = wrapped.getId();
		if (otherId != null) {
			id = otherId.toImmutable();
		}
		I_DomainName dn = wrapped.getDomain();
		if (dn != null) {
			domain = new DomainName(dn);
		}
		I_EMailAddress otherEmail = wrapped.getEmail();
		if (otherEmail != null) {
			emailAddress = new EMailAddress(otherEmail);
		}
	}
	
	public boolean isMutable() {
		return false;
	}
	
	public int hashCode() {
		return UserMutant.genHashCode(this);
	}
	
	public String toString() {
		return wrapped.toString(this.getClass(), this);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		try {
			return UserMutant.equals(this, (I_User) obj);
		} catch (ClassCastException x) {
			//eat get doesn't impl instance of
		}
		return false;
	}

	public String getDn() {
		return UserMutant.getDn(this);
	}

	public I_DomainName getDomain() {
		return domain;
	}

	public I_EMailAddress getEmail() {
		return emailAddress;
	}

	public I_StorageIdentifier getId() {
		return id;
	}

	public String getName() {
		return wrapped.getName();
	}

	public String getPassword() {
		return wrapped.getPassword();
	}

	public boolean isValid() {
		return UserMutant.isValid(this);
	}

	@Override
	public String getImmutableFieldName() {
		return "wrapped";
	}
}
