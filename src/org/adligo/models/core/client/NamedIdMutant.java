package org.adligo.models.core.client;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.models.core.client.ids.I_StorageIdentifier;
import org.adligo.models.core.client.ids.StorageIdentifierValidator;

/**
 * this class is intended to be used for selection lists, 
 * and NOT to be used for updating the data storage.
 * 
 * @author scott
 *
 */
public class NamedIdMutant implements I_NamedIdMutant, I_Validateable {
	public static final String NULL_TO_CONSTRUCTOR =  "a null was passed to the NamedIdMutant constructor ";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String SET_NAME = "setName";
	
	private I_StorageIdentifier id;
	private String name;
	
	public NamedIdMutant() {
	}
	
	public NamedIdMutant(I_NamedId other) throws InvalidParameterException {
		I_StorageIdentifier id = other.getId();
		if (id != null) {
			//allow a null id in the constructor, for objects that haven't been saved yet
			// and use this as the standard
			setId(other.getId());
		}
		setName(other.getName());
	}
	
	
	public I_StorageIdentifier getId() {
		return id;
	}

	/**
	 * allow sub class to throw exception if necessary
	 * 
	 * @param p_id
	 * @throws InvalidParameterException
	 */
	public void setId(I_StorageIdentifier p_id) throws InvalidParameterException {
		StorageIdentifierValidator.validateId(p_id, this.getClass(), SET_ID);
		id = p_id;
	}

	public String getName() {
		return name;
	}
	
	/**
	 * note no checks are done here because
	 * the client classes (DomainName, Email exc)
	 * will want to provide specific messages for nulls and empties
	 * 
	 * @param p_name
	 * @throws InvalidParameterException
	 */
	public void setName(String p_name) {
		name = p_name;
	}


	public String toString() {
		return toString(this.getClass(), id);
	}

	protected String toString(Class c, I_StorageIdentifier p_id) {
		StringBuffer sb = new StringBuffer();
		sb.append(ClassUtils.getClassShortName(c));
		sb.append(" [name=");
		sb.append(name);
		sb.append(",id=");
		sb.append(p_id);
		sb.append("]");
		return sb.toString();
	}

	public boolean isValid() throws ValidationException {
		// TODO Auto-generated method stub
		return false;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		I_NamedId other = (I_NamedId) obj;
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
		return true;
	}
}
