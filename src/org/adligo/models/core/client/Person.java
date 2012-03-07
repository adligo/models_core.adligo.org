package org.adligo.models.core.client;

import org.adligo.models.core.client.ids.I_StorageIdentifier;



/**
 * 
 * requires a last name 
 * @author scott
 *
 */
public class Person implements I_Validateable, I_Person {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String PERSON = "Person";
	protected PersonMutant mutant = new PersonMutant();

	/**
	 * do nothing for GWT Serialization
	 */
	public Person() {}
	
	public Person(I_Person p) throws InvalidParameterException {
		mutant = new PersonMutant(p);
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
		return mutant.getId();
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
	


}
