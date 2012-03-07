package org.adligo.models.core.client.ids;

import java.lang.Long;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.models.core.client.InvalidParameterException;

public class VersionedIdentifierMutant implements I_VersionedIdentifierMutant {
	public static final String TYPE = "VersionedIdentifier";
	
	public static final String YOU_PASSED_A_NULL_TO_THE_VERSIONED_IDENTIFIER_CONSTRUCTOR = "You passed a null to the VersionedIdentifier constructor.";

	public static final String SET_ID = "setId";
	public static final String SET_VERSION = "setVersion";
	public static final String CLAZZ_SIMPLE_NAME = "VersionedIdentifier";
	public static final String ID_CANT_BE_SET_TO_NULL = "VersionedIdentifier id can't be set to null!";
	public static final String VERSION_CANT_BE_SET_TO_NULL = "VersionedIdentifier key can't be set to null!";
	public static final String NO_VERSION_OR_A_ID = "A VersionedIdentifier must have a version and a id!";
	
	/**
	 * used to identify a model in a RDBMS (Database)
	 * 
	 * Long biggest common unit available on j2me, gwt and j2se
	 */
	protected Long id;
	/**
	 * for optimistic locking 
	 * (you get version 1 
	 * 	bob gets version 1
	 * 	bob updates version is now 2
	 *  you update and it fails because the version is now 2)
	 *  
	 */
	protected Integer version;
	
	public VersionedIdentifierMutant() {
	}
	
	public VersionedIdentifierMutant(I_VersionedIdentifier other) throws InvalidParameterException {
		if (other == null) {
			throw new InvalidParameterException(YOU_PASSED_A_NULL_TO_THE_VERSIONED_IDENTIFIER_CONSTRUCTOR
					, CLAZZ_SIMPLE_NAME);
		}
		if (other.getVersion() != null && other.getId() != null) {
			setVersion(other.getVersion());
			setId(other.getId());
		} else {
			throw new InvalidParameterException(NO_VERSION_OR_A_ID, CLAZZ_SIMPLE_NAME);
		}
	}
	
	public VersionedIdentifierMutant(Integer id) throws InvalidParameterException {
		setId(new Long(id.longValue()));
	}
	
	public VersionedIdentifierMutant(Long id) throws InvalidParameterException {
		setId(id);
	}
	
	public VersionedIdentifierMutant(Integer id, Integer version) throws InvalidParameterException {
		setVersion(version);
		setId(new Long(id.longValue()));
	}
	
	public VersionedIdentifierMutant(Long id, Integer version) throws InvalidParameterException {
		setVersion(version);
		setId(id);
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(int p_id) throws InvalidParameterException {
		setId((long) p_id);
	}

	public void setId(Long p_id) throws InvalidParameterException {
		if (p_id == null) {
			throw new InvalidParameterException(ID_CANT_BE_SET_TO_NULL, SET_ID);
		}
		id = p_id;
	}
	
	public Integer getVersion() {
		return version;
	}
	
	public void setVersion(Integer p_version) throws InvalidParameterException {
		if (p_version == null) {
			throw new InvalidParameterException(VERSION_CANT_BE_SET_TO_NULL, SET_VERSION);
		}
		version = p_version;
	}
	
	public boolean hasValue() {
		if (id == null || version == null) {
			return false;
		}
		return true;
	}

	
	public String getType() {
		return TYPE;
	}
	
	public String toString() {
		return toString(this.getClass());
	}
	
	String toString(Class c) {
		StringBuffer sb = new StringBuffer();
		sb.append(ClassUtils.getClassShortName(c));
		sb.append(" [id=");
		sb.append(id);
		sb.append(",version=");
		sb.append(version);
		sb.append("]");
		return sb.toString();
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		//allow extensions to equal
		I_VersionedIdentifier other = null;
		if (obj instanceof I_VersionedIdentifier) {
			other = (I_VersionedIdentifier) obj;
		}
		if (other == null) {
			return false;
		}
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		if (version == null) {
			if (other.getVersion() != null)
				return false;
		} else if (!version.equals(other.getVersion()))
			return false;
		return true;
	}
}
