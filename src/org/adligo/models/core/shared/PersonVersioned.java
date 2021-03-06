package org.adligo.models.core.shared;

import org.adligo.i.util.shared.I_Immutable;

public class PersonVersioned implements I_PersonVersioned, I_Immutable {
	private PersonVersionedMutant vpm;
	
	public PersonVersioned() {
		vpm = new PersonVersionedMutant();
	}
	
	public PersonVersioned(I_Person p) throws InvalidParameterException {
		vpm = new PersonVersionedMutant(p);
	}

	public PersonVersioned(I_PersonVersioned p) throws InvalidParameterException {
		vpm = new PersonVersionedMutant(p);
	}
	
	public Integer getVersion() {
		return vpm.getVersion();
	}

	public I_StorageIdentifier getId() {
		return vpm.getId();
	}

	public I_StorageInfo getStorageInfo() {
		return vpm.getStorageInfo();
	}

	public boolean isStored() throws ValidationException {
		return vpm.isStored();
	}

	public String getFirst_name() {
		return vpm.getFirst_name();
	}

	public String getMiddle_name() {
		return vpm.getMiddle_name();
	}

	public String getLast_name() {
		return vpm.getLast_name();
	}

	public Long getBirthday() {
		return vpm.getBirthday();
	}

	public Long getDeceased() {
		return vpm.getDeceased();
	}

	public Double getHeight() {
		return vpm.getHeight();
	}

	public Character getGender() {
		return vpm.getGender();
	}

	public String getName() {
		return vpm.getName();
	}

	public void isValid() throws ValidationException {
		vpm.isValid();
	}

	public String getNickname() {
		return vpm.getNickname();
	}

	public boolean isAlive() {
		return vpm.isAlive();
	}

	public int hashCode() {
		return vpm.hashCode();
	}

	public boolean equals(Object obj) {
		return vpm.equals(obj);
	}

	public I_CustomInfo getCustomInfo() {
		return vpm.getCustomInfo();
	}

	public Double getWeight() {
		return vpm.getWeight();
	}

	public String getImmutableFieldName() {
		return "vpm";
	}
}
