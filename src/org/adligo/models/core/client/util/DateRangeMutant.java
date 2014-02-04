package org.adligo.models.core.client.util;

import java.util.Date;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.DateTime;
import org.adligo.i.util.client.TextFormatter;
import org.adligo.i.util.client.I_TextFormatter;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ModelsCoreConstantsObtainer;
import org.adligo.models.core.client.ValidationException;

public class DateRangeMutant implements I_DateRange, I_DateRangeMutant {
	public static final String IS_VALID_WITHOUT_NULLS = "isValidWithoutNulls";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String SET_ENDED = "setEnded";
	private Long start;
	private Long end;
	
	public DateRangeMutant() {}
	
	public DateRangeMutant(I_DateRange p) throws InvalidParameterException {
		setStart(p.getStart());
		setEnd(p.getEnd());
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.util.I_DateRange#getStarted()
	 */
	public Long getStart() {
		return start;
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.util.I_DateRangeMutant#setStarted(java.lang.Long)
	 */
	public void setStart(Long p) throws InvalidParameterException {
		if (end != null) {
			if (p != null) {
				if (p > end) {
					throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
							.getStartOfDateRangeMustBeBeforeEnd(), SET_ENDED);
				}
			}
		}
		start = p;
	}
	/**
	 * protected only for hibernate
	 * @return
	 */
	protected Date getStartDate() {
		if (start == null) {
			return null;
		}
		return new Date(start);
	}
	
	protected void setStartDate(Date p) {
		if (p == null) {
			//allow null to come from the db
			return;
		}
		start = p.getTime();
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.util.I_DateRange#getEnded()
	 */
	public Long getEnd() {
		return end;
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.util.I_DateRangeMutant#setEnded(java.lang.Long)
	 */
	public void setEnd(Long p) throws InvalidParameterException {
		if (start != null) {
			if (p != null) {
				if (p < start) {
					throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
							.getEndOfDateRangeMustBeAfterStart(), SET_ENDED);
				}
			}
		}
		end = p;
	}
	/**
	 * protected only for hibernate
	 * @return
	 */
	protected Date getEndDate() {
		if (end == null) {
			return null;
		}
		return new Date(end);
	}
	
	protected void setEndDate(Date p) {
		if (p == null) {
			//allow null to come from the db
			return;
		}
		end = p.getTime();
	}

	/**
	 * note this only checks if the start is before the end
	 * either value may be null,
	 * use the method isValidWithoutNulls if values are required
	 */
	public void isValid() throws ValidationException {
		try {
			DateRangeMutant other = new DateRangeMutant();
			other.setEnd(end);
			other.setStart(start);
		} catch (InvalidParameterException ipe) {
			//this code is unreachable but necessary for the conversion of possible exceptions
			throw new ValidationException(ipe);
		}
	}

	public void isValidWithoutNulls() throws ValidationException {
		if (start == null) {
			throw new ValidationException(ModelsCoreConstantsObtainer.getConstants()
						.getDateRangeRequiresStartValue(),IS_VALID_WITHOUT_NULLS);
		}
		if (end == null) {
			throw new ValidationException(ModelsCoreConstantsObtainer.getConstants()
						.getDateRangeRequiresEndValue(),IS_VALID_WITHOUT_NULLS);
		}
		isValid();
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		try {
			I_DateRange other = (I_DateRange) obj;
			if (end == null) {
				if (other.getEnd() != null)
					return false;
			} else if (!end.equals(other.getEnd()))
				return false;
			if (start == null) {
				if (other.getStart() != null)
					return false;
			} else if (!start.equals(other.getStart()))
				return false;
			return true;
		} catch (ClassCastException e) {
			return false;
		}
	}

	/**
	 * @return returns true if the this 
	 * starts before and ends after the dr argument object
	 * 
	 */
	public boolean overlaps(I_DateRange dr) {
		long drEnd = Long.MAX_VALUE;
		long drStart = Long.MIN_VALUE;
		if (dr.getEnd() != null) {
			drEnd = dr.getEnd();
		}
		if (dr.getStart() != null) {
			drStart = dr.getStart();
		}
		if (drEnd >= start && drEnd <= end) {
			return true;
		}
		if (drStart >= start && drStart <= end) {
			return true;
		}
		return false;
	}
	
	/**
	 * returns 
	 * @param dr
	 * @return true if the date range passed in starts after this and ends before this.
	 */
	public boolean contains(I_DateRange dr) {
		long drEnd = Long.MAX_VALUE;
		long drStart = Long.MIN_VALUE;
		if (dr.getEnd() != null) {
			drEnd = dr.getEnd();
		}
		if (dr.getStart() != null) {
			drStart = dr.getStart();
		}
		if (start <= drStart && end >= drEnd) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return toString(DateRangeMutant.class);
	}
	
	public String toString(Class c) {
		I_TextFormatter formatter = TextFormatter.getInstance();
		String startedString = formatter.formatDate(DateTime.DEFAULT_DATE_TIME_FORMAT, start);
		String endedString = formatter.formatDate(DateTime.DEFAULT_DATE_TIME_FORMAT, end);
		
		return "" + ClassUtils.getClassShortName(c) + 
				" [" + startedString + "-" + endedString + "]";
	}

	public Long getDuration() {
		if (start == null || end == null) {
			return null;
		}
		return end - start;
	}

	public boolean contains(Long time) {
		if (time >= start && time <= end) {
			return true;
		}
		return false;
	}
}
