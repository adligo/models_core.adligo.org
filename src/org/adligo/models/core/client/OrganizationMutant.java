package org.adligo.models.core.client;

import java.io.Serializable;

public class OrganizationMutant extends Organization implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void setId(Integer p) {
		id = p;
	}
	public void setName(String p) {
		name = p;
	}
	public void setType(NamedId p) {
		type = p;
	}
}
