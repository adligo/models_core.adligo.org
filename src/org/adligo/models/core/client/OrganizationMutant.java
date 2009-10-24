package org.adligo.models.core.client;


public class OrganizationMutant extends Organization  {
	
	public void setId(StorageIdentifier p) {
		id = p;
	}
	public void setName(String p) {
		name = p;
	}
	public void setType(NamedId p) {
		type = p;
	}
}
