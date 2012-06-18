package org.adligo.models.core.client;

import java.util.Date;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.DateTime;
import org.adligo.models.core.client.ids.I_StorageIdentifier;
import org.adligo.models.core.client.ids.StorageIdentifierValidator;

public class PersonMutant implements I_PersonMutant  {

	public static final String STORAGE_INFO_CAN_NOT_BE_SET_TO_NULL = "StorageInfo can NOT be set to null";
	public static final String SET_STORAGE_INFO = "setStorageInfo";
	public static final String CUSTOM_INFO_MUST_NOT_BE_NULL = "CustomInfo must not be null";
	public static final String SET_GENDER = "setGender";
	public static final String SET_NICKNAME = "setNickname";
	public static final String SET_LAST_NAME = "setLastName";
	public static final String SET_MIDDLE_NAME = "setMiddleName";
	public static final String PERSON = "Person";
	public static final String SET_FIRST_NAME = "setFirstName";
	/**
	 * although there is no actual name field to set,
	 * this is for general no name errors
	 */
	public static final String SET_NAME = "setName";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * a null storage identifier means it hasn't been stored yet
	 */
	private I_StorageIdentifier id;
	/**
	 * the version number for optimistic locking
	 */
	private Integer version;
	/**
	 * null is allowed
	 */
	private String first_name;
	/**
	 * null is allowed
	 */
	private String middle_name;
	/**
	 * null is allowed
	 */
	private String last_name;
	/**
	 * null is allowed, the day/time this person was born
	 */
	private Long birthday;
	/**
	 * null is allowed, they day/time this person died
	 */
	private Long deceased;
	/**
	 * null is allowed
	 */
	private String nickname;
	/**
	 * null is allowed one of the constants in I_Person may be extended
	 */
	private Character gender;
	/**
	 * @see I_Person#getHeight()
	 */
	private Double height;
	/**
	 * @see I_Person#getWeight()
	 */
	private Double weight;
	/**
	 * @see I_Person#isAlive()
	 */
	private Boolean alive = null;
	/**
	 * custom info specific to your system
	 */
	private I_CustomInfo customInfo;
	/**
	 * detailed information about where this was stored 
	 */
	private I_StorageInfo storageInfo;
	
	public PersonMutant() {}
	
	public PersonMutant(I_Person p) throws InvalidParameterException {
		try {
			p.isValid();
			copy(this, p);
		} catch (ValidationException x) {
			throw new InvalidParameterException(getConstants().getPersonNoNameError(), PERSON, x);
		}
	}
	
	private I_ModelsCoreConstants getConstants() {
		return ModelsCoreConstantsObtainer.getConstants();
	}

	public static void copy(PersonMutant dest, I_Person source) throws InvalidParameterException {
		I_StorageIdentifier idCopy = source.getId();
		if (idCopy != null) {
			dest.setId(idCopy);
		}
		Integer version = source.getVersion();
		if (version != null) {
			dest.setVersion(version);
		}
		
		String firstNameCopy = source.getFirst_name();
		if (firstNameCopy != null) {
			dest.setFirst_name(firstNameCopy);
		} 
		
		String middleNameCopy = source.getMiddle_name();
		if (middleNameCopy != null) {
			dest.setMiddle_name(middleNameCopy);
		} 
		
		String lastNameCopy = source.getLast_name();
		if (lastNameCopy != null) {
			dest.setLast_name(lastNameCopy);
		} 
		
		String nickNameCopy = source.getNickname();
		if (nickNameCopy != null) {
			dest.setNickname(nickNameCopy);
		} 
		
		dest.setBirthday(source.getBirthday());
		dest.setDeceased(source.getDeceased());
		dest.setGender(source.getGender());
		I_StorageInfo storageInfo = source.getStorageInfo();
		if (storageInfo != null) {
			dest.setStorageInfo(storageInfo);
		}
		I_CustomInfo customInfo = source.getStorageInfo();
		if (customInfo != null) {
			dest.setCustomInfo(customInfo);
		}
		
		Double height = source.getHeight();
		if (height != null) {
			dest.setHeight(height);
		}
		Double weight = source.getWeight();
		if (weight != null) {
			dest.setWeight(weight);
		}
	}
	
	public I_StorageIdentifier getId() {
		return id;
	}

	public void setId(I_StorageIdentifier p_id)  throws InvalidParameterException {
		StorageIdentifierValidator.validateId(p_id, this.getClass(), SET_ID);
		id = p_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String p) throws InvalidParameterException {
		if (p == null) {
			throw new InvalidParameterException(getConstants().getPersonNoFirstNameError(), SET_FIRST_NAME);
		} else {
			//allow empty strings
			first_name = p.trim();
		} 
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String p) throws InvalidParameterException {
		if (p == null) {
			throw new InvalidParameterException(getConstants().getPersonNoMiddleNameError(), SET_MIDDLE_NAME);
		} else {
			//allow empty strings
			middle_name = p.trim();
		} 
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String p) throws InvalidParameterException {
		if (p == null) {
			throw new InvalidParameterException(getConstants().getPersonNoLastNameError(), SET_LAST_NAME);
		} else {
			//allow empty strings
			last_name = p.trim();
		} 
	}

	public Long getBirthday() {
		return birthday;
	}

	public void setBirthday(Long p) throws InvalidParameterException {
		birthday = p;
		//TODO if birthday and deceased are not null, make sure there with in 150 years of each other
	}

	public Long getDeceased() {
		return deceased;
	}

	public void setDeceased(Long deceased)  throws InvalidParameterException {
		this.deceased = deceased;
		//TODO if birthday and deceased are not null, make sure there with in 150 years of each other
	}

	public void setNickname(String p) throws InvalidParameterException {
		if (p == null) {
			throw new InvalidParameterException(getConstants().getPersonNoNickNameError(), SET_NICKNAME);
		} else {
			//allow empty strings
			nickname = p.trim();
		} 
	}

	public Double getHeight() {
		return height;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character p) throws InvalidParameterException {
		if (p == null) {} //do nothing, don't know the gender
		else if (I_Person.GENDER_FEMALE == p) {}   //do nothing, its a girl
		else if (I_Person.GENDER_MALE == p) {}  //do nothing, its a boy
		else if (I_Person.GENDER_OTHER == p) {} //do nothing, its a something else
		else {
			throw new InvalidParameterException(getConstants().getPersonMustBeAKnownGenderType(), SET_GENDER);
		}
		gender = p;
	}

	public String getName() {
		//jme doesn't have StringBuilder
		StringBuffer sb = new StringBuffer();
		
		boolean hadRealName = false;
		if (first_name != null) {
			sb.append(first_name);
			hadRealName = true;
		} 
		if (middle_name != null) {
			if (first_name != null) {
				if (first_name.length() > 0) {
					sb.append(" ");
				}
			}
			sb.append(middle_name);
			hadRealName = true;
		}
		if (last_name != null) {
			if (first_name != null || middle_name != null) {
				if (first_name != null) {
					if (first_name.length() > 0) {
						sb.append(" ");
					}
				} else if (middle_name != null) {
					if (middle_name.length() > 0) {
						sb.append(" ");
					}
				}
			}
			sb.append(last_name);
			hadRealName = true;
		}		
		if (!hadRealName && nickname != null) {
			sb.append(nickname);
		}
		return sb.toString();
	}

	public void isValid() throws ValidationException {
		StorableValidator.validate(this, I_Validateable.IS_VALID);
		try {
			PersonMutant other = new PersonMutant();
			other.setFirst_name(getFirst_name());
			other.setMiddle_name(getMiddle_name());
			other.setLast_name(getLast_name());
			other.setBirthday(getBirthday());
			other.setDeceased(getDeceased());
			other.setNickname(getNickname());
			other.setGender(getGender());
			other.setHeight(getHeight());
			other.setWeight(getWeight());
			if (customInfo.isValidatable()) {
				((I_Validateable) customInfo).isValid();
			}
		} catch (InvalidParameterException e) {
			throw new ValidationException(e.getMessage(), I_Validateable.IS_VALID, e);
		}
	}

	public String getNickname() {
		return nickname;
	}

	public Boolean isAlive() {
		if (deceased != null) {
			return false;
		}
		if (alive == null) {
			//assume there alive
			return true;
		}
		return alive;
	}
	
	public void setAlive(Boolean p) throws InvalidParameterException  {
		alive = p;
	}
	
	public void setHeight(Double p) throws InvalidParameterException  {
		height = p;
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
		sb.append(",nick_name=");
		sb.append(nickname);
		sb.append(",id=");
		sb.append(id);
		sb.append(",version=");
		sb.append(version);
		
		sb.append(",birthday=");
		if (birthday != null) {
			sb.append(new DateTime(birthday));
		} else {
			sb.append("null");
		}
		sb.append(",deceased=");
		if (deceased != null) {
			sb.append(new DateTime(deceased));
		} else {
			sb.append("null");
		}
		sb.append(",gender=");
		sb.append(gender);
		
		sb.append(",height=");
		sb.append(height);
		
		sb.append(",weight=");
		sb.append(weight);
		
		sb.append(",customInfo=");
		sb.append(customInfo);
		sb.append(",storageInfo=");
		sb.append(storageInfo);
		sb.append("]");
		return sb.toString();
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result
				+ ((deceased == null) ? 0 : deceased.hashCode());
		result = prime * result
				+ ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result
				+ ((middle_name == null) ? 0 : middle_name.hashCode());
		result = prime * result
				+ ((nickname == null) ? 0 : nickname.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		try {
			I_Person other = (I_Person) obj;
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
			if (first_name == null) {
				if (other.getFirst_name() != null)
					return false;
			} else if (!first_name.equals(other.getFirst_name()))
				return false;
			if (gender == null) {
				if (other.getGender() != null)
					return false;
			} else if (!gender.equals(other.getGender()))
				return false;
			if (id == null) {
				if (other.getId() != null)
					return false;
			} else if (!id.equals(other.getId()))
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
			if (nickname == null) {
				if (other.getNickname() != null)
					return false;
			} else if (!nickname.equals(other.getNickname()))
				return false;
		} catch (ClassCastException x) {
			return false;
		}
		return true;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public I_CustomInfo getCustomInfo() {
		return customInfo;
	}

	public void setCustomInfo(I_CustomInfo p) throws InvalidParameterException {
		if (p == null) {
			throw new NullPointerException(CUSTOM_INFO_MUST_NOT_BE_NULL);
		}
		if (p.isValidatable()) {
			I_Validateable v = (I_Validateable) p;
			try {
				v.isValid();
			} catch (ValidationException x) {
				//chain to the field in the custom info
				String methodName = x.getMethodName();
				String message = x.getMessage();
				throw new InvalidParameterException(message, methodName);
			}
		}
		customInfo = p;
	}

	public I_StorageInfo getStorageInfo() {
		return storageInfo;
	}

	public void setStorageInfo(I_StorageInfo p) throws InvalidParameterException {
		if (p == null) {
			throw new InvalidParameterException(STORAGE_INFO_CAN_NOT_BE_SET_TO_NULL, SET_STORAGE_INFO);
		}
		this.storageInfo = p;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double p) throws InvalidParameterException  {
		this.weight = p;
	}
	
	/**
	 * for db io only
	 * @return
	 */
	Date getBirthdayTime() {
		if (birthday == null) {
			return null;
		}
		return new Date(birthday);
	}
	/**
	 * for db io only
	 * @return
	 */
	void setBirthdayTime(Date p) {
		if (p == null) {
			birthday = null;
		} else {
			this.birthday = p.getTime();
		}
	}
	
	/**
	 * for db io only
	 * @return
	 */
	Date getDeceasedTime() {
		if (deceased == null) {
			return null;
		}
		return new Date(deceased);
	}
	/**
	 * for db io only
	 * @return
	 */
	void setDeceasedTime(Date p) {
		if (p == null) {
			deceased = null;
		} else {
			this.deceased = p.getTime();
		}
	}
	
	public boolean isStored() throws ValidationException {
		return StorableValidator.validate(this, I_Storable.IS_STORED);
	}
}
