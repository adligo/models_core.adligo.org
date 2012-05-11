package org.adligo.models.core.client;



public interface I_User extends I_NamedId {
	
	/** 
	 * @return the users name for things like
	 * Welcome Back <UserName/>
	 * ie
	 * Welcome Back Scott
	 */
	public String getName();
	
	public String getPassword();

	public EMailAddress getEmail();
	
	public DomainName getDomain();
	
	/**
	 * returns the LDAP distinguished name
	 * of the user which is name + domain 
	 * uid=guest,dc=adligo,dc=com
	 * 
	 * @return
	 */
	public String getDn();
}
