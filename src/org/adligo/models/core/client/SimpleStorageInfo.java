package org.adligo.models.core.client;

public class SimpleStorageInfo implements I_StorageInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String storeName;
	
	public SimpleStorageInfo() {
		storeName = "DEFAULT";
	}
	
	public SimpleStorageInfo(String name) {
		storeName = name;
	}
	
	public Class getDetailClass() {
		return this.getClass();
	}

	public I_CustomInfo toImmutable() throws ValidationException {
		return this;
	}

	public I_CustomInfo toMutant() throws ValidationException {
		return this;
	}

	public boolean isValidatable() {
		return false;
	}

	public String getStoreName() {
		return storeName;
	}
	
}
