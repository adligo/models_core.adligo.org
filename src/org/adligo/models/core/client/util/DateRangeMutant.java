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
	protected Date getStartedDate() {
		if (start == null) {
			return null;
		}
		return new Date(start);
	}
	
	protected void setStartedDate(Date p) {
		if (p == null) {
			//allow null to come from the db
			return;
		}
		start = p.getTime();
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.util.I_DateRange#getEnded()
	 */
	@Override
	public Long getEnd() {
		return end;
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.util.I_DateRangeMutant#setEnded(java.lang.Long)
	 */
	@Override
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
	protected Date getEndedDate() {
		if (end == null) {
			return null;
		}
		return new Date(end);
	}
	
	protected void setEndedDate(Date p) {
		if (p == null) {
			//allow null to come from the db
			return;
		}
		start = p.getTime();
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
			throw new ValidationException(ipe);
		}
	}

	public void isValidWithoutNulls() throws ValidationException {
		try {
			if (start == null) {
				throw new ValidationException(ModelsCoreConstantsObtainer.getConstants()
							.getDateRangeRequiresStartValue(),IS_VALID_WITHOUT_NULLS);
			}
			if (end == null) {
				throw new ValidationException(ModelsCoreConstantsObtainer.getConstants()
							.getDateRangeRequiresEndValue(),IS_VALID_WITHOUT_NULLS);
			}
			
			DateRangeMutant other = new DateRangeMutant();
			other.setEnd(end);
			other.setStart(start);
		} catch (InvalidParameterException ipe) {
			throw new ValidationException(ipe);
		}
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
		if (getClass() != obj.getClass())
			return false;
		DateRangeMutant other = (DateRangeMutant) obj;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}

	@Override
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
}
