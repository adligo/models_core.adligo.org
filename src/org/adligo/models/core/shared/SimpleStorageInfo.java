package org.adligo.models.core.shared;

import org.adligo.i.util.shared.I_Immutable;

public class SimpleStorageInfo implements I_StorageInfo, I_Immutable {

	private String storeName;
	
	public SimpleStorageInfo() {
		storeName = "DEFAULT";
	}
	
	public SimpleStorageInfo(String name) {
		storeName = name;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((storeName == null) ? 0 : storeName.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleStorageInfo other = (SimpleStorageInfo) obj;
		if (storeName == null) {
			if (other.storeName != null)
				return false;
		} else if (!storeName.equals(other.storeName))
			return false;
		return true;
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
