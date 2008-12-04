package org.adligo.models.core.client;

public class PhoneNumberMutant extends PhoneNumber {

	public void setId(Integer p) {
		id = p;
	}
	public void setNumber(String p) throws InvalidParameterException {
		if (p == null) {
			throw new InvalidParameterException("Can't accept a null phone p");
		}
		if (p.length() != 10) {
			throw new InvalidParameterException("A phone p must have 10 digits");
		}
		if (p.indexOf("-") != -1) {
			throw new InvalidParameterException("A phone p may not contain the - character");
		}
		if (p.indexOf("(") != -1) {
			throw new InvalidParameterException("A phone p may not contain the ( character");
		}
		if (p.indexOf(")") != -1) {
			throw new InvalidParameterException("A phone p may not contain the ) character");
		}
		number = p;
	}
	public void setRecieves_faxes(boolean recieves_faxes) {
		this.recieves_faxes = recieves_faxes;
	}
}
