package org.adligo.models.core.client;


public class StorageIdentifierMutant extends StorageIdentifier {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	public void setId(Long id) throws InvalidParameterException {
		super.setIdP(id);
	}
}
