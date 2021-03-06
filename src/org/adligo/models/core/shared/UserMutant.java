package org.adligo.models.core.shared;

import org.adligo.i.util.shared.ClassUtils;
import org.adligo.i.util.shared.StringUtils;
import org.adligo.models.core.shared.util.StorageIdentifierValidator;

public class UserMutant implements I_UserMutant, I_Mutable {
	public static final String SET_ID = "setId";
	public static final String SET_EMAIL = "setEmail";
	public static final String SET_DOMAIN = "setDomain";
	public static final String USER = "User";
	public static final String SET_PASSWORD = "setPassword";
	public static final String SET_NAME = "setName";
	
	/**
	 * the unique storage identifier
	 */
	private I_StorageIdentifier id;
	/**
	 * detailed information about where this was stored 
	 */
	private I_StorageInfo storageInfo;
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
	private DomainName domain;
	private String password;
	private EMailAddress email;
	
	public UserMutant() {}
	
	/**
	 * constructor for creating a new user
	 * 
	 * @param p
	 * @throws InvalidParameterException
	 */
	public UserMutant(I_User p) throws InvalidParameterException {
		
		//allow a null id for items that arn't yet stored
		try {
			if (p.getId() != null) {
				setId(p.getId());
			}
			setDomain(p.getDomain());
			setPassword(p.getPassword());
			setName(p.getName());
			setEmail(p.getEmail());
			I_StorageInfo storageInfo = p.getStorageInfo();
			if (storageInfo != null) {
				setStorageInfo(storageInfo);
			}
		} catch (InvalidParameterException x) {
			throw new InvalidParameterException(x.getMessage(), USER, x);
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
	public UserMutant(String p_domain, String p_name) throws InvalidParameterException {
		try {
			setDomain(new DomainName(p_domain));
			setName(p_name);
		} catch (InvalidParameterException x) {
			InvalidParameterException ipe = new InvalidParameterException(x.getMessage(), 
					USER,x);
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
	public UserMutant(String p_domain, String p_name, String p_email) throws InvalidParameterException {
		try {
			setDomain(new DomainName(p_domain));
			setName(p_name);
			setEmail(new EMailAddress(p_email));
		} catch (InvalidParameterException x) {
			throw new InvalidParameterException(x.getMessage(), USER, x);
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
		return getDn(this);
	}
	
	public static String getDn(I_User user) {
		String name = user.getName();
		DomainName domain = user.getDomain();
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
	
	public void setName(String p_name) throws InvalidParameterException {
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

	public void setDomain(String domain)  throws InvalidParameterException {
		try {
			this.domain = new DomainName(domain);
		} catch (InvalidParameterException e) {
			throw new InvalidParameterException(e.getMessage(), 
					SET_DOMAIN, e);
		}
	}
	
	public void setDomain(DomainName domain)  throws InvalidParameterException {
		if (domain == null) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getUserNoEmptyDomainMessage(), SET_DOMAIN);
		} 
		if (StringUtils.isEmpty(domain.getName())) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getUserNoEmptyDomainMessage(), SET_DOMAIN);
		}
		this.domain = domain;
	}
	
	public void setPassword(String password) throws InvalidParameterException {
		if (StringUtils.isEmpty(password)) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getUserNoEmptyPasswordMessage(), SET_PASSWORD);
		}
		this.password = password;
	}
	
	public void setId(I_StorageIdentifier p_id) throws InvalidParameterException {
		StorageIdentifierValidator.validateId(p_id, this.getClass(), SET_ID);
		id = p_id;
	}

	/**
	 * some basic validation,
	 * should probably also send a email for confirmation
	 * @param p_email
	 * @throws InvalidParameterException
	 */
	public void setEmail(EMailAddress p_email) throws InvalidParameterException {
		if (p_email == null) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getEmailAddressEmptyError(), SET_EMAIL);
		}
		if (StringUtils.isEmpty(p_email.getEMail())) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getEmailAddressEmptyError(), SET_EMAIL);
		}
		email = p_email;
	}
	
	public void setEmail(String p_email) throws InvalidParameterException {
		try {
			email = new EMailAddress(p_email);
		} catch (InvalidParameterException e) {
			throw new InvalidParameterException(e.getMessage(), 
					SET_EMAIL);
		}
		
	}
	
	public String toString() {
		return toString(this.getClass(), this);
	}
	
	public String toString(Class c, I_User p) {	
		StringBuffer sb = new StringBuffer();
		sb.append(ClassUtils.getClassShortName(c));
		sb.append(" [name=");
		sb.append(p.getName());
		sb.append(",id=");
		sb.append(p.getId());
		sb.append(",email=");
		sb.append(p.getEmail());
		sb.append(",domain=");
		sb.append(p.getDomain());
		//omit password!
		sb.append(",storageInfo=");
		sb.append(storageInfo);
		sb.append("]");
		return sb.toString();
	}
	

	public boolean isMutable() {
		return false;
	}

	public void isValid() throws ValidationException {
		StorableValidator.validate(this, I_Validateable.IS_VALID);
		try {
			UserMutant other = new UserMutant();
			other.setName(getName());
			other.setEmail(getEmail());
			other.setDomain(getDomain());
		} catch (InvalidParameterException e) {
			throw new ValidationException(e.getMessage(), I_Validateable.IS_VALID, e);
		}
	}

	static int genHashCode(I_User user) {
		final int prime = 31;
		int result = 1;
		DomainName domain = user.getDomain();
		EMailAddress email = user.getEmail();
		I_StorageIdentifier id = user.getId();
		String name = user.getName();
		String password = user.getPassword();
		
		result = prime * result + ((domain == null) ? 0 : domain.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		return result;
	}
	
	public int hashCode() {
		return genHashCode(this);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		try {
			return equals(this, (I_User) obj);
		} catch (ClassCastException x) {
			//eat get doesn't impl instance of
		}
		return false;
	}

	public static boolean equals(I_User user, I_User other) {
		DomainName domain = user.getDomain();
		EMailAddress email = user.getEmail();
		I_StorageIdentifier id = user.getId();
		String name = user.getName();
		String password = user.getPassword();
		
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

	public I_StorageInfo getStorageInfo() {
		return storageInfo;
	}

	public void setStorageInfo(I_StorageInfo storageInfo) throws InvalidParameterException {
		try {
			this.storageInfo = (I_StorageInfo) storageInfo.toMutant();
		} catch (ValidationException ve) {
			throw new InvalidParameterException(ve);
		}
	}

	public I_User toImmutable() throws ValidationException {
		try {
			return new User(this);
		} catch (InvalidParameterException ipe) {
			throw new ValidationException(ipe);
		}
	}

	public I_UserMutant toMutant() throws ValidationException {
		return this;
	}
	
	public boolean isStored() throws ValidationException {
		return StorableValidator.validate(this, I_Storable.IS_STORED);
	}
}
