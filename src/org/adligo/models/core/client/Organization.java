package org.adligo.models.core.client;

import org.adligo.i.adi.client.I_Invoker;
import org.adligo.i.adi.client.Registry;
import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.I_Serializable;
import org.adligo.i.util.client.StringUtils;
import org.adligo.models.core.client.i18n.I_OrganizationValidationConstants;


public class Organization implements I_NamedId, I_Serializable, I_Validateable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String SET_NAME = "setName";
	public static final String SET_TYPE = "setType";
	public static final String ORGANIZAITION = "Organization";
	
	private static final I_Invoker CONSTANTS_FACTORY = 
		Registry.getInvoker(ModelInvokerNames.CONSTANTS_FACTORY);
	
	protected StorageIdentifier id;
	protected String name;
	/**
	 * the type pertains to something like a School, Band, Company
	 * to be defined depending on your problem domain 
	 */
	protected NamedId type;
	private int hash_code;
	
	public Organization(Organization p) throws InvalidParameterException {
		try {
			if (p.getId() != null) {
				setIdP(p.getId());
			}
			setNameP(p.name);
			setTypeP(p.type);
		} catch (InvalidParameterException x) {
			InvalidParameterException ipe = new InvalidParameterException(x.getMessage(), ORGANIZAITION);
			ipe.initCause(x);
			throw ipe;
		}
		hash_code = genHashCode();
	}
	
	protected void setIdP(StorageIdentifier p) throws InvalidParameterException {
		try {
			id = new StorageIdentifier(p);
		} catch (InvalidParameterException e) {
			InvalidParameterException ipe = new InvalidParameterException(e.getMessage(), 
					I_StorageMutant.SET_ID);
			ipe.initCause(e);
			throw ipe;
		}
	}
	/**
	 * for gwt serialization
	 */
	public Organization() {}
	
	public StorageIdentifier getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	private I_OrganizationValidationConstants getConstants() {
		I_OrganizationValidationConstants constants = (I_OrganizationValidationConstants) 
						CONSTANTS_FACTORY.invoke(I_OrganizationValidationConstants.class);
		return constants;
	}
	
	protected void setNameP(String p) throws InvalidParameterException {
		I_OrganizationValidationConstants csts = getConstants();
		if (StringUtils.isEmpty(p)) {
			throw new InvalidParameterException(csts.getEmptyNameError(),SET_NAME);
		}
		name = p;
	}

	public NamedId getType() {
		return type;
	}

	protected void setTypeP(NamedId p) throws InvalidParameterException {
		I_OrganizationValidationConstants csts = getConstants();
		if (p == null) {
			throw new InvalidParameterException(csts.getEmptyTypeError(),SET_TYPE);
		}
		if (StringUtils.isEmpty(p.getName())) {
			throw new InvalidParameterException(csts.getEmptyTypeError(),SET_TYPE);
		}
		type = p;
	}
	
	public int hashCode() {
		return hash_code;
	}
	
	protected int genHashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof Organization) {
			final Organization other = (Organization) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (type == null) {
				if (other.type != null)
					return false;
			} else if (!type.equals(other.type))
				return false;
			return true;
		}
		return false;
	}

	public boolean isValid() {
		try {
			new Organization(this);
			return true;
		} catch (InvalidParameterException e) {
			//do nothing
		}
		return false;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(ClassUtils.getClassShortName(this.getClass()));
		sb.append(" [name=");
		sb.append(name);
		sb.append(",type=");
		sb.append(type);
		sb.append(",id=");
		sb.append(id);
		sb.append("]");
		return sb.toString();
	}
	
}
