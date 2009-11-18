package org.adligo.models.core.client;

import org.adligo.i.util.client.I_Serializable;


/**
 * modeled after the java Jaas Subject
 * should be implemented by the User(Mutant)Relations
 * objects
 * 
 * @author scott
 *
 */
public interface I_User extends I_Serializable {
	
	/** 
	 * @return the users name for things like
	 * Welcome Back <UserName/>
	 * ie
	 * Welcome Back Scott
	 */
	public String getUserName();
	/**
	 * this should correspond to a LDAP role (organizational_role)
	 * or something similar,
	 * 
	 * Remeber Javascript is NOT secure, so this should only be 
	 * used to show or hide (disable) GUI items (buttons exc)
	 * if the user shouldn't see some section of the GUI
	 * (Admin tab, exc), when sent out to a GWT client
	 * 
	 * @param role
	 * @return if the user is in the role
	 */
	public boolean isUserInRole(String role);
}
