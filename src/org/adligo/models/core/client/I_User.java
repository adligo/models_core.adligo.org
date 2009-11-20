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

	public EMail getEmail();
	
	public DomainName getDomain();
}
