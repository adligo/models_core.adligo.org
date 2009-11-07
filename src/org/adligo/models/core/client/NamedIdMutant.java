package org.adligo.models.core.client;

import com.google.gwt.user.client.rpc.IsSerializable;

public class NamedIdMutant extends NamedId implements IsSerializable {

	public void setId(StorageIdentifier p) throws InvalidParameterException {
		setIdP(p);
	}
	
	public void setName(String p) throws InvalidParameterException {
		setNameP(p);
	}
	
	public int hashCode() {
		return super.genHashCode();
	}
}
