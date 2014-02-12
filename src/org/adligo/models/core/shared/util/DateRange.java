package org.adligo.models.core.shared.util;

import org.adligo.i.util.shared.I_Immutable;
import org.adligo.models.core.shared.InvalidParameterException;
import org.adligo.models.core.shared.ValidationException;

public class DateRange implements I_DateRange, I_Immutable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DateRangeMutant dateRangeMutant;

	public DateRange() {
		dateRangeMutant = new DateRangeMutant();
	}
	
	public DateRange(I_DateRange p) throws InvalidParameterException {
		dateRangeMutant = new DateRangeMutant(p);
	}
	
	public boolean equals(Object obj) {
		return dateRangeMutant.equals(obj);
	}

	public Long getStart() {
		return dateRangeMutant.getStart();
	}

	public Long getEnd() {
		return dateRangeMutant.getEnd();
	}

	public int hashCode() {
		return dateRangeMutant.hashCode();
	}

	public void isValid() throws ValidationException {
		dateRangeMutant.isValid();
	}

	public String toString() {
		return dateRangeMutant.toString(DateRange.class);
	}

	public String getImmutableFieldName() {
		return "dateRangeMutant";
	}

	public boolean overlaps(I_DateRange dr) {
		return dateRangeMutant.overlaps(dr);
	}

	public boolean contains(I_DateRange dr) {
		return dateRangeMutant.contains(dr);
	}
	
	public Long getDuration() {
		return dateRangeMutant.getDuration();
	}

	public boolean contains(Long time) {
		return dateRangeMutant.contains(time);
	}
}
