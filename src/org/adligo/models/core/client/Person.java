package org.adligo.models.core.client;

import java.io.Serializable;

public class Person implements I_NamedId, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Integer id;
	protected String first_name;
	protected String middle_name;
	protected String last_name;
	private int hash_code;
	
	public Person(Person p) {
		id = p.id;
		first_name = p.first_name;
		middle_name = p.middle_name;
		last_name = p.last_name;
		hash_code = genHashCode();
	}
	
	protected Person() {}
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return first_name + " " + middle_name + " " + last_name;
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
		result = prime * result
				+ ((middle_name == null) ? 0 : middle_name.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
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

	
}
