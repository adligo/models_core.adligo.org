package org.adligo.models.core.client;

public class StorageIdentifierMutant extends StorageIdentifier {

	public StorageIdentifierMutant() {}
	
	public int hashCode() {
		return super.genHashCode();
	}
	
	public StorageIdentifierMutant(StorageIdentifier other) throws InvalidParameterException {
		super(other);
	}
	
	public void setKey(String key) throws InvalidParameterException {
		super.setKeyP(key);
	}

	public void setId(Integer id) throws InvalidParameterException {
		super.setIdP(id);
	}
}
