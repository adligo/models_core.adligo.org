package org.adligo.models.core.client.util;

import org.adligo.i.util.client.I_Immutable;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ValidationException;

public class DateRange implements I_DateRange, I_Immutable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DateRangeMutant mutant;

	public DateRange() {
		mutant = new DateRangeMutant();
	}
	
	public DateRange(I_DateRange p) throws InvalidParameterException {
		mutant = new DateRangeMutant(p);
	}
	
	public boolean equals(Object obj) {
		return mutant.equals(obj);
	}

	
	
	public Long getStart() {
		return mutant.getStart();
	}

	public Long getEnd() {
		return mutant.getEnd();
	}

	public int hashCode() {
		return mutant.hashCode();
	}

	public void isValid() throws ValidationException {
		mutant.isValid();
	}

	public String toString() {
		return mutant.toString(DateRange.class);
	}

	public String getImmutableFieldName() {
		return I_Immutable.MUTANT;
	}
}
