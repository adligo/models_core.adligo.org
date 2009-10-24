package org.adligo.models.core.client;

public class NamedIdMutant extends NamedId {

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
