package org.adligo.models.core.shared;

import org.adligo.i.util.shared.AppenderFactory;
import org.adligo.i.util.shared.I_Appender;
import org.adligo.i.util.shared.I_Immutable;

public class Storable implements I_Storable, I_Immutable {
	private StorableMutant sm;

	public Storable() {
		sm = new StorableMutant();
	}
	
	public Storable(I_Storable p) throws InvalidParameterException {
		sm = new StorableMutant(p);
	}
	
	public I_StorageIdentifier getId() {
		return sm.getId();
	}

	public void setId(I_StorageIdentifier p) throws InvalidParameterException {
		sm.setId(p);
	}

	public I_StorageInfo getStorageInfo() {
		return sm.getStorageInfo();
	}

	public void setStorageInfo(I_StorageInfo p)
			throws InvalidParameterException {
		sm.setStorageInfo(p);
	}

	public String toString() {
		I_Appender apend = AppenderFactory.create();
		sm.toString(Storable.class, apend);
		return apend.toString();
	}

	public void isValid() throws ValidationException {
		sm.isValid();
	}

	public boolean isStored() throws ValidationException {
		return sm.isStored();
	}

	public int hashCode() {
		return sm.hashCode();
	}

	public boolean equals(Object obj) {
		return sm.equals(obj);
	}

	@Override
	public String getImmutableFieldName() {
		return "sm";
	}
	
}
