package org.adligo.models.core.client;

import org.adligo.i.adi.client.I_Invoker;
import org.adligo.i.adi.client.Registry;
import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.StringUtils;
import org.adligo.models.core.client.i18n.I_UserValidationConstants;

public class User implements I_NamedId, I_Validateable, I_Mutable {
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
	
	public User() {}
	
	public User(User p) throws InvalidParameterException {
		
		//allow a null id for items that arn't yet stored
		if (p.id != null) {
			id = new StorageIdentifier(p.id);
		}
		setDomainP(new DomainName(p.domain));
		setPasswordP(p.password);
		setNameP(p.name);
		setEmailP(new EMail(p.email));
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
			throw new InvalidParameterException(getConstants().getNoUserNameMessage(), "setName");
		}
		p_name = p_name.trim();
		if (p_name.indexOf(" ") != -1) {
			throw new InvalidParameterException(getConstants().getNoSpaceInNameMessage(), "setName");
		}
		this.name = p_name;
	}

	private I_UserValidationConstants getConstants() {
		I_UserValidationConstants constants = (I_UserValidationConstants) 
						CONSTANTS_FACTORY.invoke(I_UserValidationConstants.class);
		return constants;
	}
	
	protected void setDomainP(DomainName domain) {
		this.domain = domain;
	}
	protected void setPasswordP(String password) throws InvalidParameterException {
		if (StringUtils.isEmpty(password)) {
			throw new InvalidParameterException(getConstants().getNoEmptyPasswordMessage(), "setPassword");
		}
		this.password = password;
	}
	
	protected void setIdP(StorageIdentifier p_id) throws InvalidParameterException {
		if (p_id == null) {
			throw new InvalidParameterException(getConstants().getNullUserIdMessage(), "setId");
		}
		if (!p_id.hasValue()) {
			throw new InvalidParameterException(getConstants().getUserIdWithOutValueMessage() + p_id, "setId");
		}
		id = new StorageIdentifier(p_id);
	}

	/**
	 * some basic validation,
	 * should probably also send a email for confirmation
	 * @param p_email
	 * @throws InvalidParameterException
	 */
	protected void setEmailP(EMail p_email) {
		email = p_email;
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
		sb.append(",email=");
		sb.append(this.email);
		sb.append(",domain=");
		sb.append(this.domain);
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
}
