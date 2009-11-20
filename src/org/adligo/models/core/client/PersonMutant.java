package org.adligo.models.core.client;



public class PersonMutant implements I_Person  {
	private Person wrapped;

	public PersonMutant() {
		wrapped = new Person();
	}
	
	public PersonMutant(I_Person p) throws InvalidParameterException {
		wrapped = new Person(p);
	}
	
	public void setId(StorageIdentifier id) throws InvalidParameterException {
		wrapped.setIdP(id);
	}

	public void setFirst_name(String first_name) {
		wrapped.setFirst_nameP(first_name);
	}

	public void setMiddle_name(String middle_name) {
		wrapped.setMiddle_nameP(middle_name);
	}
	
	public void setLast_name(String last_name) throws InvalidParameterException {
		wrapped.setLast_nameP(last_name);
	}
	
	public void setBirthday(Long bday) {
		wrapped.setBirthdayP(bday);
	}
	
	public void setDeceased(Long p_deceased) {
		wrapped.setDeceasedP(p_deceased);
	}
	public int hashCode() {
		return wrapped.genHashCode();
	}

	public Long getBirthday() {
		return wrapped.getBirthday();
	}

	public boolean equals(Object obj) {
		return wrapped.equals(obj);
	}

	public Long getDeceased() {
		return wrapped.getDeceased();
	}

	public String getFirst_name() {
		return wrapped.getFirst_name();
	}

	public I_StorageIdentifier getId() {
		return wrapped.getId();
	}

	public String getLast_name() {
		return wrapped.getLast_name();
	}

	public String getMiddle_name() {
		return wrapped.getMiddle_name();
	}

	public String getName() {
		return wrapped.getName();
	}

	public boolean isAlive() {
		return wrapped.isAlive();
	}

	public boolean isValid() {
		return wrapped.isValid();
	}

	public String toString() {
		return wrapped.toString(this.getClass());
	}

	
}
