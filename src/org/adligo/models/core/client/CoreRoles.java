package org.adligo.models.core.client;

public class CoreRoles {
	/**
	 * a I_User in this role can create new user entries 
	 * (possible their own user entry)
	 */
	public static final String USER_CREATOR = "UserCreator";
	
	/**
	 * a I_User in this role can edit other user entries (besides their own)
	 * this also implies the ability to add or remove UserGroups to a User 
	 * (see UserRelationsMutant inmodels_core_relations package )
	 */
	public static final String USER_EDITOR = "UserEditor";
	
	/**
	 * a I_User in this role should be able to see all other
	 * users in the system (by querying them),
	 * this does NOT allow them to see the Roles or Groups for those users
	 */
	public static final String USER_VIEWER = "UserViewer";
	
	/**
	 * a I_User in this role can view user groups (as a list of user groups, or 
	 * as a single user group with it's associated roles).   Also a user
	 * in this role should be able to see which UserGroups a User belongs to.
	 */
	public static final String USER_GROUP_VIEWER = "UserGroupViewer";
	
	/**
	 * a I_User in this role can edit the user groups (adding and removing roles)
	 */
	public static final String USER_GROUP_EDITOR = "UserGroupEditor";
	
}
