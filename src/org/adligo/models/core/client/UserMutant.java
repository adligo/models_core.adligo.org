package org.adligo.models.core.client;

import org.adligo.i.util.client.ClassUtils;

public class UserMutant extends User {
	public static final String SET_EMAIL = "setEmail";
	public static final String SET_DOMAIN = "setDomain";
	
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
		try {
			super.setDomainP(new DomainName(domain));
		} catch (InvalidParameterException x) {
			throw new InvalidParameterException(x.getMessage(), SET_DOMAIN);
		}
	}
	
	public void setPassword(String password) throws InvalidParameterException {
		super.setPasswordP(password);
	}
	public void setId(StorageIdentifier id) throws InvalidParameterException {
		super.setIdP(id);
	}
	public void setEmail(String email) throws InvalidParameterException {
		try {
			super.setEmailP(new EMail(email));
		} catch (InvalidParameterException x) {
			throw new InvalidParameterException(x.getMessage(), SET_EMAIL);
		}
	}
	public void setEmail(EMail email) throws InvalidParameterException {
		super.setEmailP(email);
	}
	
	public boolean isMutable() {
		return true;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(ClassUtils.getClassShortName(UserMutant.class));
		appendFields(sb);
		return sb.toString();
	}
}
