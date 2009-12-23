package org.adligo.models.core.client;


public class UserMutant implements I_User {
	private User wrapped;

	public UserMutant() {
		wrapped = new User();
	}
	
	public UserMutant(I_User p) throws InvalidParameterException {
		wrapped = new User(p);
	}
	
	public void setName(String name) throws InvalidParameterException {
		wrapped.setNameP(name);
	}
	public void setDomain(DomainName domain)  throws InvalidParameterException {
		wrapped.setDomainP(domain);
	}
	
	public void setDomain(String domain) throws InvalidParameterException {
		wrapped.setDomainP(domain);
	}
	
	public void setPassword(String password) throws InvalidParameterException {
		wrapped.setPasswordP(password);
	}
	
	public void setId(I_StorageIdentifier id) throws InvalidParameterException {
		wrapped.setIdP(id);
	}
	
	public void setEmail(String email) throws InvalidParameterException {
		wrapped.setEmailP(email);
	}
	
	public void setEmail(EMailAddress email) throws InvalidParameterException {
		wrapped.setEmailP(email);
	}
	
	public boolean isMutable() {
		return true;
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

	public String getDn() throws InvalidParameterException {
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
