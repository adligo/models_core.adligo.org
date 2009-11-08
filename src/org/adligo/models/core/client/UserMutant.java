package org.adligo.models.core.client;

import com.google.gwt.user.client.rpc.IsSerializable;


public class UserMutant extends User implements IsSerializable {
	
	public UserMutant() {}
	
	public UserMutant(User p) throws InvalidParameterException {
		super(p);
	}
	
	public void setName(String name) throws InvalidParameterException {
		super.setNameP(name);
	}
	public void setDomain(DomainName domain) {
		super.setDomainP(domain);
	}
	public void setDomain(String domain) throws InvalidParameterException {
		super.setDomainP(new DomainName(domain));
	}
	
	public void setPassword(String password) throws InvalidParameterException {
		super.setPasswordP(password);
	}
	public void setId(StorageIdentifier id) throws InvalidParameterException {
		super.setIdP(id);
	}
	public void setEmail(String email) throws InvalidParameterException {
		super.setEmailP(email);
	}
}
