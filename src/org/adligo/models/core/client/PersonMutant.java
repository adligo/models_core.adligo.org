package org.adligo.models.core.client;

import java.io.Serializable;

public class PersonMutant extends Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public void setId(Integer id) {
		this.id = id;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public int hashCode() {
		return super.genHashCode();
	}
}
