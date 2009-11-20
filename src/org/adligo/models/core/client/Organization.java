package org.adligo.models.core.client;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.I_Serializable;
import org.adligo.i.util.client.StringUtils;


public class Organization implements I_Org, I_Serializable, I_Validateable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String SET_NAME = "setName";
	public static final String SET_TYPE = "setType";
	public static final String ORGANIZAITION = "Organization";
	
	private StorageIdentifier id;
	private String name;
	/**
	 * the type pertains to something like a School, Band, Company
	 * to be defined depending on your problem domain 
	 */
	private NamedId type;
	private int hash_code;
	
	public Organization(I_Org p) throws InvalidParameterException {
		try {
			if (p.getId() != null) {
				setIdP(p.getId());
			}
			setNameP(p.getName());
			setTypeP(p.getType());
		} catch (InvalidParameterException x) {
			InvalidParameterException ipe = new InvalidParameterException(x.getMessage(), ORGANIZAITION);
			ipe.initCause(x);
			throw ipe;
		}
		hash_code = genHashCode();
	}
	
	protected void setIdP(I_StorageIdentifier p) throws InvalidParameterException {
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
	
	public I_StorageIdentifier getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	protected void setNameP(String p) throws InvalidParameterException {
		if (StringUtils.isEmpty(p)) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getOrgEmptyNameError(),SET_NAME);
		}
		name = p;
	}

	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_Org#getType()
	 */
	public I_NamedId getType() {
		return type;
	}

	protected void setTypeP(I_NamedId p) throws InvalidParameterException {
		if (p == null) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getOrgEmptyTypeError(),SET_TYPE);
		}
		if (StringUtils.isEmpty(p.getName())) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getOrgEmptyTypeError(),SET_TYPE);
		}
		try {
			type = new NamedId(p);
		} catch (InvalidParameterException x) {
			InvalidParameterException ipe = new InvalidParameterException(x.getMessage(), SET_TYPE);
			ipe.initCause(x);
			throw ipe;
		}
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
		if (obj instanceof I_Org) {
			final I_Org other = (I_Org) obj;
			if (name == null) {
				if (other.getName() != null)
					return false;
			} else if (!name.equals(other.getName()))
				return false;
			if (type == null) {
				if (other.getType() != null)
					return false;
			} else if (!type.equals(other.getType()))
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
		return toString(this.getClass());
	}
	
	public String toString(Class c) {
		StringBuffer sb = new StringBuffer();
		sb.append(ClassUtils.getClassShortName(c));
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
