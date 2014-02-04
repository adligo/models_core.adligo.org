package org.adligo.models.core.client;

import org.adligo.i.util.client.I_Immutable;

public class SimpleStorageInfo implements I_StorageInfo, I_Immutable {

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

	public String getImmutableFieldName() {
		return "storeName";
	}

	public void isValid() throws ValidationException {
		if (storeName == null) {
			throw new ValidationException("SimpleStorageInfo requires a store name.",
					I_Validateable.IS_VALID);
		}
	}
	
	public String toString() {
		return "SimpleStorageInfo[" + storeName + "]";
	}
	
}
