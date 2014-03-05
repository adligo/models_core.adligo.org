package org.adligo.models.core.shared;

import org.adligo.i.util.shared.AppenderFactory;
import org.adligo.i.util.shared.I_Appender;
import org.adligo.i.util.shared.I_Immutable;

public class VersionedOrganization implements I_Organization, I_Changeable, I_Immutable {
	private VersionedOrganizationMutant mutant;

	public VersionedOrganization() {
		mutant = new VersionedOrganizationMutant();
	}
	
	public VersionedOrganization(I_Organization p) throws InvalidParameterException {
		mutant = new VersionedOrganizationMutant(p);
	}
	
	public Integer getVersion() {
		return mutant.getVersion();
	}

	public I_StorageIdentifier getId() {
		return mutant.getId();
	}

	public I_StorageInfo getStorageInfo() {
		return mutant.getStorageInfo();
	}

	public String getName() {
		return mutant.getName();
	}

	public I_StorageIdentifier getType() {
		return mutant.getType();
	}

	public void isValid() throws ValidationException {
		mutant.isValid();
	}

	public int hashCode() {
		return mutant.hashCode();
	}

	public boolean equals(Object obj) {
		return mutant.equals(obj);
	}

	public String toString() {
		I_Appender apend = AppenderFactory.create();
		mutant.toString(Storable.class, apend);
		return apend.toString();
	}

	public I_CustomInfo getCustomInfo() {
		return mutant.getCustomInfo();
	}

	public boolean isStored() throws ValidationException {
		return mutant.isStored();
	}

	@Override
	public String getImmutableFieldName() {
		return "mutant";
	}
	
}