package org.adligo.models.core.shared;

import org.adligo.i.util.shared.ClassUtils;
import org.adligo.i.util.shared.StringUtils;



public class OrgMutant extends StorableMutant implements I_OrgMutant {

	public static final String SET_NAME = "setName";
	public static final String SET_TYPE = "setType";
	public static final String ORGANIZAITION = "Organization";
	
	private String name;
	/**
	 * the type pertains to something like a School, Band, Company
	 * to be defined depending on your problem domain 
	 */
	private I_StorageIdentifier type;
	/**
	 * custom info specific to your system
	 */
	private I_CustomInfo customInfo;
	
	/**
	 * for gwt serialization
	 */
	public OrgMutant() {}
	
	public OrgMutant(I_Org p) throws InvalidParameterException {
		super(p);
		try {
			if (p.getId() != null) {
				setId(p.getId());
			}
			I_StorageInfo storageInfo = p.getStorageInfo();
			if (storageInfo != null) {
				setStorageInfo(storageInfo);
			}
			setName(p.getName());
			setType(p.getType());
			
			I_CustomInfo customInfo = p.getCustomInfo();
			if (customInfo != null) {
				setCustomInfo(customInfo);
			}
			
		} catch (InvalidParameterException x) {
			InvalidParameterException ipe = new InvalidParameterException(
					x.getMessage(), ORGANIZAITION, x);
			throw ipe;
		}
	}

	public String getName() {
		return name;
	}
	
	public void setName(String p) throws InvalidParameterException {
		if (StringUtils.isEmpty(p)) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getOrgEmptyNameError(),SET_NAME);
		}
		name = p;
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_Org#getType()
	 */
	public I_StorageIdentifier getType() {
		return type;
	}

	public void setType(I_StorageIdentifier p) throws InvalidParameterException {
		if (p == null) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getOrgEmptyTypeError(),SET_TYPE);
		}
		if (!p.hasValue()) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getOrgEmptyTypeError(),SET_TYPE);
		}
		type = p;
	}
	
	public void isValid() throws ValidationException {
		StorableValidator.validate(this, I_Validateable.IS_VALID);
		try {
			OrgMutant other = new OrgMutant();
			other.setName(getName());
			other.setType(getType());
			if (customInfo != null) {
				if (customInfo.isValidatable()) {
					((I_Validateable) customInfo).isValid();
				}
			}
		} catch (InvalidParameterException e) {
			throw new ValidationException(e.getMessage(), I_Validateable.IS_VALID, e);
		}
	}
	
	
	public int hashCode() {
		return genHashCode(this);
	}

	public static int genHashCode(I_Org me) {
		final int prime = 31;
		int result = 1;
		String name = me.getName();
		I_StorageIdentifier type = me.getType();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		try {
			return equals(this, (I_Org) obj);
		} catch (ClassCastException x) {
			//eat gwt doesn't impl instance of
		}
		return false;
	}
	
	public static boolean equals(I_Org me, I_Org other) {
		if (me.getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!me.getName().equals(other.getName()))
			return false;
		if (me.getType() == null) {
			if (other.getType() != null)
				return false;
		} else if (!me.getType().equals(other.getType()))
			return false;
		return true;
	}
	
	public String toString() {
		return toString(this.getClass(),this);
	}
	
	public String toString(Class c, I_Org p) {
		StringBuffer sb = new StringBuffer();
		sb.append(ClassUtils.getClassShortName(c));
		sb.append(" [name=");
		sb.append(p.getName());
		sb.append(",type=");
		sb.append(p.getType());
		sb.append(",id=");
		sb.append(p.getId());
		sb.append(",customInfo=");
		sb.append(p.getCustomInfo());
		sb.append(",storageInfo=");
		sb.append(p.getStorageInfo());
		sb.append("]");
		return sb.toString();
	}

	public I_CustomInfo getCustomInfo() {
		return customInfo;
	}

	public void setCustomInfo(I_CustomInfo customInfo) throws InvalidParameterException {
		try {
			this.customInfo = customInfo.toMutant();
		} catch (ValidationException ve) {
			throw new InvalidParameterException(ve);
		}
	}

	public I_Org toImmutable() throws ValidationException {
		try {
			return new Org(this);
		} catch (InvalidParameterException ipe) {
			throw new ValidationException(ipe);
		}
	}

	public I_OrgMutant toMutant() throws ValidationException {
		return this;
	}
	
	public boolean isStored() throws ValidationException {
		return StorableValidator.validate(this, I_Storable.IS_STORED);
	}
}
