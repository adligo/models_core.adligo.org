package org.adligo.models.core.client;

public interface I_UserMutant extends I_User {
	public void setName(String p)  throws InvalidParameterException;
	
	public void setPassword(String p)  throws InvalidParameterException;

	public void setEmail(EMailAddress p)  throws InvalidParameterException;
	
	public void setDomain(DomainName d)  throws InvalidParameterException;
	
}
