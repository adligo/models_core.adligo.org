package org.adligo.models.core.client;

import org.adligo.i.adi.client.I_Invoker;
import org.adligo.i.adi.client.InvokerNames;
import org.adligo.i.adi.client.Registry;
import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.I_Serializable;
import org.adligo.i.util.client.StringUtils;


/**
 * 
 * requires a last name 
 * @author scott
 *
 */
public class Person implements I_NamedId, I_Serializable, I_Validateable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String SET_LAST_NAME = "setLast_name";
	public static final String PERSON = "Person";
	
	protected StorageIdentifier id;
	protected String first_name;
	protected String middle_name;
	protected String last_name;
	private int hash_code;
	
	public Person(Person p) throws InvalidParameterException {
		try {
			if (p.getId() != null) {
				setIdP(p.getId());
			}
			first_name = p.first_name;
			middle_name = p.middle_name;
			setLast_nameP(p.last_name);
			hash_code = genHashCode();
		} catch (InvalidParameterException ex) {
			InvalidParameterException ipe = new InvalidParameterException(ex.getMessage(), PERSON);
			ipe.initCause(ex);
			throw ipe;
		}
	}
	
	public Person() {}
	
	public StorageIdentifier getId() {
		return id;
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
	public String getName() {
		StringBuffer sb = new StringBuffer();
		
		
		if (!StringUtils.isEmpty(first_name)) {
			sb.append(first_name);
		}
		if (!StringUtils.isEmpty(middle_name)) {
			if (!StringUtils.isEmpty(first_name)) {
				sb.append(" ");
			}
			sb.append(middle_name);
		}
		if (!StringUtils.isEmpty(last_name)) {
			if (!StringUtils.isEmpty(first_name) || !StringUtils.isEmpty(middle_name)) {
				sb.append(" ");
			}
			sb.append(last_name);
		}
		return sb.toString();
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	protected void setLast_nameP(String p) throws InvalidParameterException {
		if (StringUtils.isEmpty(p)) {
			throw new InvalidParameterException(ModelsCoreValidationConstantsObtainer.getConstants()
					.getPersonNoNameError(), SET_LAST_NAME);
		}
		last_name = p;
	}
	
	public int hashCode() {
		return hash_code;
	}
	
	protected int genHashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result
				+ ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((middle_name == null) ? 0 : middle_name.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof Person) {
			final Person other = (Person) obj;
			if (first_name == null) {
				if (other.first_name != null)
					return false;
			} else if (!first_name.equals(other.first_name))
				return false;
			if (last_name == null) {
				if (other.last_name != null)
					return false;
			} else if (!last_name.equals(other.last_name))
				return false;
			if (middle_name == null) {
				if (other.middle_name != null)
					return false;
			} else if (!middle_name.equals(other.middle_name))
				return false;
			return true;
		}
		return false;
	}

	public boolean isValid() {
		try {
			new Person(this);
			return true;
		} catch (InvalidParameterException e) {
			//do nothing
		}
		return false;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(ClassUtils.getClassShortName(this.getClass()));
		sb.append(" [first_name=");
		sb.append(first_name);
		sb.append(",middle_name=");
		sb.append(middle_name);
		sb.append(",last_name=");
		sb.append(last_name);
		sb.append(",id=");
		sb.append(id);
		sb.append("]");
		return sb.toString();
	}
}
