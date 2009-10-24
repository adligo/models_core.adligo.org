package org.adligo.models.core.client;


public class OrganizationMutant extends Organization  {
	
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
