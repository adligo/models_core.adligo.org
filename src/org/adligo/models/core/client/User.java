package org.adligo.models.core.client;

import org.adligo.i.util.client.StringUtils;

public class User implements I_NamedId {
	/**
	 * the unique storage identifier
	 */
	private StorageIdentifier id;
	
	/**
	 * usually a email address
	 * used as reciever in MessageDestination to identify the session of the user
	 * 
	 * the simple userName (id)
	 * if this is stored in a Ldap server this is only the domain specific portion of the dn 
	 * for instance if the dn is uid=scott,dc=adligo,dc=com
	 * it is just the value 'scott'
	 */
	private String name;
	
	/**
	 * used to keep users in different organizations apart
	 * 
	 * for instance the 9ci users may not be able to send
	 * messages to the CME users, null is the root (adligo) domain 
	 * depending on rules
	 * 
	 * the domain in a user readable form so if the LDAP dn is 
	 * dc=com;dc=adligo;uid=scott
	 * this is 
	 * 
	 * adligo.com
	 */
	private String domain;
	private String password;
	
	protected User() {}
	
	public User(User p) throws InvalidParameterException {
		
		//allow a null id for items that arn't yet stored
		if (p.id != null) {
			id = new StorageIdentifier(p.id);
		}
		setDomainP(p.domain);
		setPasswordP(p.password);
		setNameP(p.name);
	}
	
	public String getName() {
		return name;
	}
	
	public String getDomain() {
		return domain;
	}
	
	public String getPassword() {
		return password;
	}

	public StorageIdentifier getId() {
		return id;
	}

	/**
	 * returns a LDAP dn (for i_netOrgUser entries)
	 * @return
	 */
	public String getDn() {
		if (domain == null) {
			return null;
		}
		
		if (name == null) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		sb.append("uid=");
		sb.append(name);
		sb.append(",");
		sb.append(toDn(domain));
		return sb.toString();
	}
	
	public static String toDn(String domain) {
		if (domain == null) {
			return null;
		}
		
		//j2me doesn't have string builder
		StringBuffer sb = new StringBuffer();
		
		boolean first = true;
		int index = domain.indexOf('.');
		while (index != -1) {
			if (index == domain.length()) {
				index = -1;
			} else {
				if (!first) {
					sb.append(",");
				}
				String dc = domain.substring(0, index);
				sb.append("dc=");
				sb.append(dc);
				domain = domain.substring(index + 1, domain.length());
				index = domain.indexOf('.');
				first = false;
			}
		}
		if (!first) {
			sb.append(",");
			sb.append("dc=");
			sb.append(domain);
		} else {
			sb.append("dc=");
			sb.append(domain);
		}
		return sb.toString();
	}
	
	protected void setNameP(String name) throws InvalidParameterException {
		if (StringUtils.isEmpty(name)) {
			throw new InvalidParameterException("User name can't be set to empty!", "setName");
		}
		this.name = name;
	}
	
	protected void setDomainP(String domain) throws InvalidParameterException {
		if (StringUtils.isEmpty(domain)) {
			throw new InvalidParameterException("User domain can't be set to empty!", "setDomain");
		}
		this.domain = domain;
	}
	protected void setPasswordP(String password) throws InvalidParameterException {
		if (StringUtils.isEmpty(password)) {
			throw new InvalidParameterException("User password can't be set to empty!", "setPassword");
		}
		this.password = password;
	}
	
	protected void setIdP(StorageIdentifier p_id) throws InvalidParameterException {
		if (p_id == null) {
			throw new InvalidParameterException("User id can't be set to null!", "setId");
		}
		if (!p_id.hasValue()) {
			throw new InvalidParameterException("User id can't be set to a StorageIdentifier with out a value " + p_id, "setId");
		}
		id = new StorageIdentifier(p_id);
	}
	
}
