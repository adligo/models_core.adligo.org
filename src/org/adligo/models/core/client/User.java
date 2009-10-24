package org.adligo.models.core.client;

public class User implements I_NamedId {
	/**
	 * if stored in a rdbms the table id
	 */
	protected Integer id;
	/**
	 * usually a email address
	 * used as reciever in MessageDestination to identify the session of the user
	 * 
	 * the simple userName (id)
	 * if this is stored in a Ldap server this is only the domain specific portion of the dn 
	 * for instance if the dn is uid=scott,dc=adligo,dc=com
	 * it is just the value 'scott'
	 */
	protected String name;
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
	protected String domain;
	protected String password;
	
	protected User() {}
	
	public User(User p) {
		name = p.name;
		domain = p.domain;
		password = p.password;
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

	public Integer getId() {
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
}
