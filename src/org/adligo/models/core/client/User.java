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
	/**
	 * detailed information about where this was stored 
	 */
	private I_StorageInfo storageInfo;
	private DomainName domain;
	private EMailAddress emailAddress;
	
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
			id = otherId;
		}
		domain = wrapped.getDomain();
		emailAddress = wrapped.getEmail();
		I_StorageInfo p_storageInfo = wrapped.getStorageInfo();
		if (p_storageInfo != null) {
			try {
				storageInfo = (I_StorageInfo) p_storageInfo.toImmutable();
			} catch (ValidationException ve) {
				throw new InvalidParameterException(ve);
			}
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

	public DomainName getDomain() {
		return domain;
	}

	public EMailAddress getEmail() {
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

	public void isValid() throws ValidationException {
		wrapped.isValid();
	}

	@Override
	public String getImmutableFieldName() {
		return "wrapped";
	}
	
	public I_StorageInfo getStorageInfo() {
		return storageInfo;
	}

	public I_User toImmutable() throws ValidationException {
		return this;
	}

	public I_UserMutant toMutant() throws ValidationException {
		try {
			return new UserMutant(this);
		} catch (InvalidParameterException ipe) {
			throw new ValidationException(ipe);
		}
	}

	public boolean isStored() throws ValidationException {
		return wrapped.isStored();
	}

}
