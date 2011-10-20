package org.adligo.models.core.client;


public class User implements I_User {
	private UserMutant wrapped;

	public User() {
		wrapped = new UserMutant();
	}
	
	public User(String userId, String domain ) throws InvalidParameterException {
		wrapped = new UserMutant(userId, domain);
	}
	
	public User(I_User p) throws InvalidParameterException {
		wrapped = new UserMutant(p);
	}
	
	public boolean isMutable() {
		return false;
	}
	
	public int hashCode() {
		return wrapped.genHashCode();
	}
	
	public String toString() {
		return wrapped.toString(this.getClass());
	}

	public boolean equals(Object obj) {
		return wrapped.equals(obj);
	}

	public StringIdentifier generate() throws InvalidParameterException {
		return wrapped.generate();
	}

	public String getDn() {
		return wrapped.getDn();
	}

	public DomainName getDomain() {
		return wrapped.getDomain();
	}

	public EMailAddress getEmail() {
		return wrapped.getEmail();
	}

	public I_StorageIdentifier getId() {
		return wrapped.getId();
	}

	public String getName() {
		return wrapped.getName();
	}

	public String getPassword() {
		return wrapped.getPassword();
	}

	public boolean isValid() {
		return wrapped.isValid();
	}
}
