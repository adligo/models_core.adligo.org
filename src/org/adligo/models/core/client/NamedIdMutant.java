package org.adligo.models.core.client;


public class NamedIdMutant extends NamedId {

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
