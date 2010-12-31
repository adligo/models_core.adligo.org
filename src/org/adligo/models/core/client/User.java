package org.adligo.models.core.client;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.StringUtils;

public class User implements I_User, I_Mutable, I_StorageIdGenerator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String SET_EMAIL = "setEmail";
	public static final String SET_DOMAIN = "setDomain";
	public static final String USER = "User";
	public static final String SET_PASSWORD = "setPassword";
	public static final String SET_NAME = "setName";
	
	/**
	 * the unique storage identifier
	 */
	protected I_StorageIdentifier id;
	
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
	protected DomainName domain;
	protected String password;
	protected EMailAddress email;
	
	public User() {}
	
	/**
	 * constructor for creating a new user
	 * 
	 * @param p
	 * @throws InvalidParameterException
	 */
	public User(I_User p) throws InvalidParameterException {
		
		//allow a null id for items that arn't yet stored
		try {
			if (p.getId() != null) {
				setIdP(p.getId());
			}
			setDomainP(p.getDomain());
			setPasswordP(p.getPassword());
			setNameP(p.getName());
			setEmailP(p.getEmail());
		} catch (InvalidParameterException x) {
			InvalidParameterException ipe = new InvalidParameterException(x.getMessage(), 
					USER);
			ipe.initCause(x);
			throw ipe;
		}
	}
	
	/**
	 * a constructor for passing a list of users back to the client
	 * when the authenticated user should not know the users
	 * passwords or emails
	 * (chat user, or modified data user, exc)
	 * 
	 * @param p_domain
	 * @param p_name
	 * @throws InvalidParameterException
	 */
	public User(String p_domain, String p_name) throws InvalidParameterException {
		try {
			setDomainP(new DomainName(p_domain));
			setNameP(p_name);
		} catch (InvalidParameterException x) {
			InvalidParameterException ipe = new InvalidParameterException(x.getMessage(), 
					USER);
			ipe.initCause(x);
			throw ipe;
		}
	}

	/**
	 * a constructor for passing a list of users back to the client
	 * when the authenticated user (some sort of admin user) 
	 * should not know the users passwords
	 * @param p_domain
	 * @param p_name
	 * @param p_email
	 * 
	 * @throws InvalidParameterException
	 */
	public User(String p_domain, String p_name, String p_email) throws InvalidParameterException {
		try {
			setDomainP(new DomainName(p_domain));
			setNameP(p_name);
			setEmailP(new EMailAddress(p_email));
		} catch (InvalidParameterException x) {
			InvalidParameterException ipe = new InvalidParameterException(x.getMessage(), 
					USER);
			ipe.initCause(x);
			throw ipe;
		}
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_NamedId#getName()
	 */
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_User#getDomain()
	 */
	public DomainName getDomain() {
		return domain;
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_User#getPassword()
	 */
	public String getPassword() {
		return password;
	}

	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_NamedId#getId()
	 */
	public I_StorageIdentifier getId() {
		return id;
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_User#getEmail()
	 */
	public EMailAddress getEmail() {
		return email;
	}

	/**
	 * returns a LDAP dn (for i_netOrgUser entries)
	 * @return
	 */
	public String getDn() {
		StringBuffer sb = new StringBuffer();
		sb.append("uid=");
		sb.append(name);
		sb.append(",");
		if (domain != null) {
			try {
				sb.append(DomainName.toDn(domain.toString()));
			} catch (InvalidParameterException x) {
				sb.append("dc=unknown");
			}
		} else {
			sb.append("dc=unknown");
		}
		return sb.toString();
	}
	
	void setNameP(String p_name) throws InvalidParameterException {
		if (StringUtils.isEmpty(p_name)) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getUserNoUserNameMessage(), SET_NAME);
		}
		p_name = p_name.trim();
		if (p_name.indexOf(" ") != -1) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getUserNoSpaceInNameMessage(), SET_NAME);
		}
		this.name = p_name;
	}

	void setDomainP(String domain)  throws InvalidParameterException {
		try {
			this.domain = new DomainName(domain);
		} catch (InvalidParameterException e) {
			InvalidParameterException ipe = new InvalidParameterException(e.getMessage(), 
					SET_DOMAIN);
			ipe.initCause(e);
			throw ipe;
		}
	}
	
	void setDomainP(DomainName domain)  throws InvalidParameterException {
		try {
			this.domain = new DomainName(domain);
		} catch (InvalidParameterException e) {
			InvalidParameterException ipe = new InvalidParameterException(e.getMessage(), 
					SET_DOMAIN);
			ipe.initCause(e);
			throw ipe;
		}
	}
	
	void setPasswordP(String password) throws InvalidParameterException {
		if (StringUtils.isEmpty(password)) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getUserNoEmptyPasswordMessage(), SET_PASSWORD);
		}
		this.password = password;
	}
	
	void setIdP(I_StorageIdentifier p_id) throws InvalidParameterException {
		id = CommonModel.getIdClone(p_id);
	}

	/**
	 * some basic validation,
	 * should probably also send a email for confirmation
	 * @param p_email
	 * @throws InvalidParameterException
	 */
	void setEmailP(EMailAddress p_email) throws InvalidParameterException {
		try {
			email = new EMailAddress(p_email);
		} catch (InvalidParameterException e) {
			InvalidParameterException ipe = new InvalidParameterException(e.getMessage(), 
					SET_EMAIL);
			ipe.initCause(e);
			throw ipe;
		}
		
	}
	
	void setEmailP(String p_email) throws InvalidParameterException {
		try {
			email = new EMailAddress(p_email);
		} catch (InvalidParameterException e) {
			InvalidParameterException ipe = new InvalidParameterException(e.getMessage(), 
					SET_EMAIL);
			ipe.initCause(e);
			throw ipe;
		}
		
	}
	
	public String toString() {
		return toString(this.getClass());
	}
	
	public String toString(Class c) {	
		StringBuffer sb = new StringBuffer();
		sb.append(ClassUtils.getClassShortName(c));
		sb.append(" [name=");
		sb.append(this.name);
		sb.append(",id=");
		sb.append(this.id);
		sb.append(",email=");
		sb.append(this.email);
		sb.append(",domain=");
		sb.append(this.domain);
		//omit password!
		sb.append("]");
		return sb.toString();
	}
	

	public boolean isMutable() {
		return false;
	}

	public boolean isValid() {
		if (domain == null) {
			return false;
		} 
		if (email == null) {
			return false;
		}
		if (StringUtils.isEmpty(name)) {
			return false;
		}
		if (StringUtils.isEmpty(password)) {
			return false;
		}
		return true;
	}

	int genHashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domain == null) ? 0 : domain.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		return result;
	}
	
	public int hashCode() {
		return genHashCode();
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof I_User) {
			I_User other = (I_User) obj;
			if (domain == null) {
				if (other.getDomain() != null)
					return false;
			} else if (!domain.equals(other.getDomain()))
				return false;
			if (email == null) {
				if (other.getEmail() != null)
					return false;
			} else if (!email.equals(other.getEmail()))
				return false;
			if (id == null) {
				if (other.getId() != null)
					return false;
			} else if (!id.equals(other.getId()))
				return false;
			if (name == null) {
				if (other.getName() != null)
					return false;
			} else if (!name.equals(other.getName()))
				return false;
			if (password == null) {
				if (other.getPassword() != null)
					return false;
			} else if (!password.equals(other.getPassword()))
				return false;
			return true;
		}
		return false;
	}

	public StringIdentifier generate() throws InvalidParameterException{
		return new StringIdentifier(getDn());
	}
}
