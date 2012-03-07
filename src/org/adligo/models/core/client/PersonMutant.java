package org.adligo.models.core.client;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.CommonTime;
import org.adligo.models.core.client.ids.I_StorageIdentifier;

public class PersonMutant implements I_PersonMutant  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * a null storage identifier means it hasn't been stored yet
	 */
	private I_StorageIdentifier id;
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
	private String nick_name;
	/**
	 * null is allowed one of the constants in I_Person may be extended
	 */
	private Character gender;
	/**
	 * the last height of the person in meters
	 */
	private Double height;
	/**
	 * note this is a full blown object so
	 * that a user can set this to true or false
	 * if they know a person died but not when 
	 * or something
	 */
	private Boolean alive = null;
	
	public PersonMutant() {}
	
	public PersonMutant(I_Person p) throws InvalidParameterException {
		try {
			p.isValid();
			copy(this, p);
		} catch (ValidationException x) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getPersonNoNameError(), Person.PERSON);
		}
	}
	

	public static void copy(PersonMutant dest, I_Person source) throws InvalidParameterException {
		if (source.getId() != null) {
			dest.setId(source.getId());
		}
		dest.setFirst_name(source.getFirst_name());
		dest.setMiddle_name(source.getMiddle_name());
		dest.setLast_name(source.getLast_name());
		dest.setNickname(source.getNickname());
		dest.setBirthday(source.getBirthday());
		dest.setDeceased(source.getDeceased());
		dest.setGender(source.getGender());
		dest.setHeight(source.getHeight());
	}
	
	public I_StorageIdentifier getId() {
		return id;
	}

	public void setId(I_StorageIdentifier id)  throws InvalidParameterException {
		this.id = CommonModel.getIdClone(id);
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		if (first_name != null) {
			this.first_name = first_name.trim();
			if (this.first_name.length() == 0) {
				this.first_name = null;
			}
		} 
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		if (middle_name != null) {
			this.middle_name = middle_name.trim();
			if (this.middle_name.length() == 0) {
				this.middle_name = null;
			}
		} 
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		if (last_name != null) {
			this.last_name = last_name.trim();
			if (this.last_name.length() == 0) {
				this.last_name = null;
			}
		} 
	}

	public Long getBirthday() {
		return birthday;
	}

	public void setBirthday(Long birthday) {
		this.birthday = birthday;
	}

	public Long getDeceased() {
		return deceased;
	}

	public void setDeceased(Long deceased) {
		this.deceased = deceased;
	}

	public void setNickname(String nickname) {
		if (nickname != null) {
			nick_name = nickname.trim();
			if (this.nick_name.length() == 0) {
				this.nick_name = null;
			}
		} 
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
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
				sb.append(" ");
			}
			sb.append(middle_name);
			hadRealName = true;
		}
		if (last_name != null) {
			if (first_name != null || middle_name != null) {
				sb.append(" ");
			}
			sb.append(last_name);
			hadRealName = true;
		}		
		if (!hadRealName && nick_name != null) {
			sb.append(nick_name);
		}
		return sb.toString();
	}

	public boolean isValid()  throws ValidationException { 
		// a PersonMutant needs a name of some sort at least
		if (first_name == null && 
			middle_name == null &&
			last_name == null &&
			nick_name == null ) {
			
			ValidationException validationException = new ValidationException(
					ModelsCoreConstantsObtainer.getConstants()
					.getPersonNoNameError());
			throw validationException;
		}
		return true;
	}

	public String getNickname() {
		return nick_name;
	}

	public Boolean isAlive() {
		if (deceased != null) {
			return true;
		}
		return alive;
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
		sb.append(nick_name);
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
		sb.append(",gender=");
		if (gender != null) {
			sb.append(gender);
		} else {
			sb.append("null");
		}
		sb.append(",height=");
		if (height != null) {
			sb.append(height);
		} else {
			sb.append("null");
		}
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
				+ ((nick_name == null) ? 0 : nick_name.hashCode());
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
			if (height == null) {
				if (other.getHeight() != null)
					return false;
			} else if (!height.equals(other.getHeight()))
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
			if (nick_name == null) {
				if (other.getNickname() != null)
					return false;
			} else if (!nick_name.equals(other.getNickname()))
				return false;
		} catch (ClassCastException x) {
			return false;
		}
		return true;
	}
}
