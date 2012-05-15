package org.adligo.models.core.client;

import org.adligo.i.util.client.I_Immutable;
import org.adligo.models.core.client.ids.I_StorageIdentifier;



/**
 * 
 * requires a last name 
 * @author scott
 *
 */
public class Person implements I_Validateable, I_Person, I_Immutable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PersonMutant mutant = new PersonMutant();
	/**
	 * keep a immutable id or null copy
	 */
	private I_StorageIdentifier id;
	private I_CustomInfo customInfo;
	private I_StorageInfo storageInfo;
	/**
	 * do nothing for GWT Serialization
	 */
	public Person() {}
	
	public Person(I_Person p) throws InvalidParameterException {
		mutant = new PersonMutant(p);
		I_StorageIdentifier otherId = mutant.getId();
		if (otherId != null) {
			id = otherId.toImmutable();
		}
		I_CustomInfo otherInfo = mutant.getCustomInfo();
		if (otherInfo != null) {
			customInfo = otherInfo.createImmutableClone();
		}
		I_StorageInfo info = mutant.getStorageInfo();
		if (info != null) {
			storageInfo = info.toImmutable();
		}
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_Person#isValid()
	 */
	public boolean isValid() throws ValidationException {
		return mutant.isValid();
	}
	
	public String toString() {
		return mutant.toString(this.getClass());
	}

	public I_StorageIdentifier getId() {
		return id;
	}


	public String getFirst_name() {
		return mutant.getFirst_name();
	}


	public String getMiddle_name() {
		return mutant.getMiddle_name();
	}


	public String getLast_name() {
		return mutant.getLast_name();
	}


	public Long getBirthday() {
		return mutant.getBirthday();
	}


	public Long getDeceased() {
		return mutant.getDeceased();
	}

	public Double getHeight() {
		return mutant.getHeight();
	}

	public Double getWeight() {
		return mutant.getWeight();
	}
	
	public Character getGender() {
		return mutant.getGender();
	}


	public String getName() {
		return mutant.getName();
	}


	public String getNickname() {
		return mutant.getNickname();
	}


	public Boolean isAlive() {
		return mutant.isAlive();
	}

	public int hashCode() {
		return mutant.hashCode();
	}
	
	public boolean equals(Object obj) {
		return mutant.equals(obj);
	}

	public Integer getVersion() {
		return mutant.getVersion();
	}

	public I_CustomInfo getCustomInfo() {
		return customInfo;
	}

	@Override
	public String getImmutableFieldName() {
		return "mutant";
	}

	@Override
	public I_StorageInfo getStorageInfo() {
		return storageInfo;
	}
	


}
