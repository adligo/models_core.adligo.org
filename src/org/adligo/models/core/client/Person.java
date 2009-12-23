package org.adligo.models.core.client;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.CommonTime;
import org.adligo.i.util.client.I_Serializable;
import org.adligo.i.util.client.StringUtils;


/**
 * 
 * requires a last name 
 * @author scott
 *
 */
public class Person implements I_Validateable, I_SerializablePerson {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String SET_LAST_NAME = "setLast_name";
	public static final String PERSON = "Person";
	
	protected I_SerializableStorageIdentifier id;
	protected String first_name;
	protected String middle_name;
	protected String last_name;
	protected Long birthday;
	/**
	 * null means there alive
	 */
	protected Long deceased;
	protected transient Integer hash_code;
	
	public Person(I_Person p) throws InvalidParameterException {
		try {
			if (p.getId() != null) {
				setIdP(p.getId());
			}
			first_name = p.getFirst_name();
			middle_name = p.getMiddle_name();
			setLast_nameP(p.getLast_name());
			birthday = p.getBirthday();
			deceased = p.getDeceased();
		} catch (InvalidParameterException ex) {
			InvalidParameterException ipe = new InvalidParameterException(ex.getMessage(), PERSON);
			ipe.initCause(ex);
			throw ipe;
		}
	}
	
	public Person() {}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_Person#getId()
	 */
	public I_StorageIdentifier getId() {
		return id;
	}
	
	protected void setIdP(I_StorageIdentifier p) throws InvalidParameterException {
		id = CommonModel.getIdClone(p);
	}
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_Person#getName()
	 */
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

	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_Person#getFirst_name()
	 */
	public String getFirst_name() {
		return first_name;
	}

	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_Person#getMiddle_name()
	 */
	public String getMiddle_name() {
		return middle_name;
	}

	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_Person#getLast_name()
	 */
	public String getLast_name() {
		return last_name;
	}

	void setLast_nameP(String p) throws InvalidParameterException {
		if (StringUtils.isEmpty(p)) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getPersonNoNameError(), SET_LAST_NAME);
		}
		last_name = p;
	}
	
	public int hashCode() {
		if (hash_code == null) {
			hash_code = new Integer(genHashCode());
		}
		return hash_code.intValue();
	}
	
	int genHashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result
				+ ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((middle_name == null) ? 0 : middle_name.hashCode());
		result = prime * result
				+ ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result
				+ ((deceased == null) ? 0 : deceased.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof I_Person) {
			final I_Person other = (I_Person) obj;
			if (first_name == null) {
				if (other.getFirst_name() != null)
					return false;
			} else if (!first_name.equals(other.getFirst_name()))
				return false;
			if (last_name == null) {
				if (other.getLast_name() != null)
					return false;
			} else if (!last_name.equals(other.getLast_name()))
				return false;
			if (middle_name == null) {
				if (other.getMiddle_name() != null)
					return false;
			} else if (!middle_name.equals(other.getMiddle_name()))
				return false;
			if (birthday == null) {
				if (other.getBirthday() != null)
					return false;
			} else if (!birthday.equals(other.getBirthday()))
				return false;
			if (deceased == null) {
				if (other.getDeceased() != null)
					return false;
			} else if (!deceased.equals(other.getDeceased()))
				return false;
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_Person#isValid()
	 */
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
		return toString(this.getClass());
	}
	public String toString(Class c) {
		StringBuffer sb = new StringBuffer();
		sb.append(ClassUtils.getClassShortName(c));
		sb.append(" [first_name=");
		sb.append(first_name);
		sb.append(",middle_name=");
		sb.append(middle_name);
		sb.append(",last_name=");
		sb.append(last_name);
		sb.append(",id=");
		sb.append(id);
		
		sb.append(",birthday=");
		if (birthday != null) {
			sb.append(CommonTime.formatDateTime(birthday.longValue()));
		} else {
			sb.append("null");
		}
		sb.append(",deceased=");
		if (deceased != null) {
			sb.append(CommonTime.formatDateTime(deceased.longValue()));
		} else {
			sb.append("null");
		}
		sb.append("]");
		return sb.toString();
	}

	public Long getBirthday() {
		return birthday;
	}

	void setBirthdayP(Long p_birthday) {
		birthday = p_birthday;
	}

	public Long getDeceased() {
		return deceased;
	}

	void setDeceasedP(Long p_deceased) {
		deceased = p_deceased;
	}

	void setFirst_nameP(String p_firstName) {
		first_name = p_firstName;
	}

	void setMiddle_nameP(String p_middleName) {
		middle_name = p_middleName;
	}

	public boolean isAlive() {
		if (deceased == null) {
			return true;
		}
		return false;
	}
}
