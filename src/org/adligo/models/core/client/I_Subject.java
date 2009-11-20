package org.adligo.models.core.client;

/**
 * modeled after the java Jaas Subject (think spy movies)
 * should be implemented by the User(Mutant)Relations
 * objects
 * 
 * @author scott
 *
 */
public interface I_Subject {

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
	
	public String getName();
}
