package org.adligo.models.core.client;



public interface I_User extends I_NamedId, I_Validateable {
	
	/** 
	 * @return the users name for things like
	 * Welcome Back <UserName/>
	 * ie
	 * Welcome Back Scott
	 */
	public String getName();
	
	public String getPassword();

	public I_EMailAddress getEmail();
	
	public I_DomainName getDomain();
	
	/**
	 * returns the LDAP distinguished name
	 * of the user which is name + domain 
	 * uid=guest,dc=adligo,dc=com
	 * 
	 * @return
	 */
	public String getDn();
}
