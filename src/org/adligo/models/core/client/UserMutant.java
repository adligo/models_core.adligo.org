package org.adligo.models.core.client;


public class UserMutant extends User {
	
	public UserMutant() {}
	
	public UserMutant(User p) throws InvalidParameterException {
		super(p);
	}
	
	public void setName(String name) throws InvalidParameterException {
		super.setNameP(name);
	}
	public void setDomain(String domain) throws InvalidParameterException {
		super.setDomainP(domain);
	}
	public void setPassword(String password) throws InvalidParameterException {
		super.setPasswordP(password);
	}
	public void setId(StorageIdentifier id) throws InvalidParameterException {
		super.setIdP(id);
	}
}
