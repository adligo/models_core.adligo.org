package org.adligo.models.core.client;



public class PersonMutant extends Person {
	

	public PersonMutant() {
		
	}
	
	public PersonMutant(Person p) {
		super(p);
	}
	
	public void setId(StorageIdentifier id) {
		this.id = id;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public int hashCode() {
		return super.genHashCode();
	}
}
