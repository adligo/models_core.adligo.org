package org.adligo.models.core.client;

import org.adligo.i.adi.client.I_Invoker;
import org.adligo.i.adi.client.Registry;
import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.StringUtils;
import org.adligo.models.core.client.i18n.I_UserValidationConstants;

public class User implements I_NamedId, I_Validateable, I_Mutable {
	public static final String USER_ID_NULL = "User id can't be set to null!";
	public static final String USER_ID_EMPTY = "User id can't be set to a StorageIdentifier with out a value ";
	
	public static final String SET_EMAIL = "setEmail";
	public static final String SET_DOMAIN = "setDomain";
	public static final String USER = "User";
	public static final String SET_PASSWORD = "setPassword";
	public static final String SET_NAME = "setName";

	private static final I_Invoker CONSTANTS_FACTORY = 
		Registry.getInvoker(ModelInvokerNames.CONSTANTS_FACTORY);
	
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
	protected DomainName domain;
	private String password;
	private EMail email;
	private int hashCode;
	
	public User() {}
	
	public User(User p) throws InvalidParameterException {
		
		//allow a null id for items that arn't yet stored
		try {
			if (p.id != null) {
				id = new StorageIdentifier(p.id);
			}
			setDomainP(p.domain);
			setPasswordP(p.password);
			setNameP(p.name);
			setEmailP(p.email);
			hashCode = genHashCode();
			
		} catch (InvalidParameterException x) {
			InvalidParameterException ipe = new InvalidParameterException(x.getMessage(), 
					USER);
			ipe.initCause(x);
			throw ipe;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public DomainName getDomain() {
		return domain;
	}
	
	public String getPassword() {
		return password;
	}

	public StorageIdentifier getId() {
		return id;
	}
	
	public EMail getEmail() {
		return email;
	}

	/**
	 * returns a LDAP dn (for i_netOrgUser entries)
	 * @return
	 */
	public String getDn() throws InvalidParameterException {
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
		sb.append(DomainName.toDn(domain.toString()));
		return sb.toString();
	}
	
	protected void setNameP(String p_name) throws InvalidParameterException {
		if (StringUtils.isEmpty(p_name)) {
			throw new InvalidParameterException(getConstants().getNoUserNameMessage(), SET_NAME);
		}
		p_name = p_name.trim();
		if (p_name.indexOf(" ") != -1) {
			throw new InvalidParameterException(getConstants().getNoSpaceInNameMessage(), SET_NAME);
		}
		this.name = p_name;
	}

	private I_UserValidationConstants getConstants() {
		I_UserValidationConstants constants = (I_UserValidationConstants) 
						CONSTANTS_FACTORY.invoke(I_UserValidationConstants.class);
		return constants;
	}
	
	protected void setDomainP(DomainName domain)  throws InvalidParameterException {
		try {
			this.domain = new DomainName(domain);
		} catch (InvalidParameterException e) {
			InvalidParameterException ipe = new InvalidParameterException(e.getMessage(), 
					SET_DOMAIN);
			ipe.initCause(e);
			throw ipe;
		}
	}
	protected void setPasswordP(String password) throws InvalidParameterException {
		if (StringUtils.isEmpty(password)) {
			throw new InvalidParameterException(getConstants().getNoEmptyPasswordMessage(), SET_PASSWORD);
		}
		this.password = password;
	}
	
	protected void setIdP(StorageIdentifier p_id) throws InvalidParameterException {
		if (p_id == null) {
			throw new InvalidParameterException(USER_ID_NULL, I_StorageMutant.SET_ID);
		}
		if (!p_id.hasValue()) {
			throw new InvalidParameterException(USER_ID_EMPTY, I_StorageMutant.SET_ID);
		}
		id = new StorageIdentifier(p_id);
	}

	/**
	 * some basic validation,
	 * should probably also send a email for confirmation
	 * @param p_email
	 * @throws InvalidParameterException
	 */
	protected void setEmailP(EMail p_email) throws InvalidParameterException {
		try {
			email = new EMail(p_email);
		} catch (InvalidParameterException e) {
			InvalidParameterException ipe = new InvalidParameterException(e.getMessage(), 
					SET_EMAIL);
			ipe.initCause(e);
			throw ipe;
		}
		
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(ClassUtils.getClassShortName(User.class));
		appendFields(sb);
		return sb.toString();
	}
	
	protected void appendFields(StringBuffer sb) {
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

	protected int genHashCode() {
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
		return hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof User) {
			User other = (User) obj;
			if (domain == null) {
				if (other.domain != null)
					return false;
			} else if (!domain.equals(other.domain))
				return false;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			return true;
		}
		return false;
	}
}
