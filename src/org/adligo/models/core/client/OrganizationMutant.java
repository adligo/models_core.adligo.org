package org.adligo.models.core.client;

import com.google.gwt.user.client.rpc.IsSerializable;


public class OrganizationMutant extends Organization implements IsSerializable {
	
	
	public OrganizationMutant() {
		
	}
	
	public OrganizationMutant(Organization o) {
		super(o);
	}
	
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
