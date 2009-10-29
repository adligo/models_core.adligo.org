package org.adligo.models.core.client;

import com.google.gwt.user.client.rpc.IsSerializable;

public class NamedIdMutant extends NamedId implements IsSerializable {

	public void setId(StorageIdentifier p) {
		id = p;
	}
	public void setName(String p) {
		name = p;
	}
	
	public int hashCode() {
		return super.genHashCode();
	}
}
