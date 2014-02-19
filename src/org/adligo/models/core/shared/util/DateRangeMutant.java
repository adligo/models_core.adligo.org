package org.adligo.models.core.shared.util;

import java.util.Date;

import org.adligo.i.util.shared.ClassUtils;
import org.adligo.i.util.shared.DateTime;
import org.adligo.i.util.shared.I_TextFormatter;
import org.adligo.i.util.shared.TextFormatter;
import org.adligo.models.core.shared.InvalidParameterException;
import org.adligo.models.core.shared.ModelsCoreConstantsObtainer;
import org.adligo.models.core.shared.ValidationException;

public class DateRangeMutant implements I_DateRange, I_DateRangeMutant {
	public static final String IS_VALID_WITHOUT_NULLS = "isValidWithoutNulls";
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
				long el = end.longValue();
				long pl = p.longValue();
				
				if (pl > el) {
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
		return new Date(start.longValue());
	}
	
	protected void setStartDate(Date p) {
		if (p == null) {
			//allow null to come from the db
			return;
		}
		start = new Long(p.getTime());
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
				long pl = p.longValue();
				long sl = start.longValue();
				
				if (pl < sl) {
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
		return new Date(end.longValue());
	}
	
	protected void setEndDate(Date p) {
		if (p == null) {
			//allow null to come from the db
			return;
		}
		long time = p.getTime();
		end = new Long(time);
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
		Long dre = dr.getEnd();
		if (dre != null) {
			drEnd = dre.longValue();
		}
		Long drs = dr.getStart();
		if (drs!= null) {
			drStart = drs.longValue();
		}
		long el = end.longValue();
		long sl = start.longValue();
		if (drEnd >= sl && drEnd <= el) {
			return true;
		}
		
		if (drStart >= sl && drStart <= el) {
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
		Long dre = dr.getEnd();
		if (dre != null) {
			drEnd = dre.longValue();
		}
		Long drs = dr.getStart();
		if (drs != null) {
			drStart = drs.longValue();
		}
		if (start == null) {
			return false;
		}
		if (end == null) {
			return false;
		}
		long sl = start.longValue();
		long el = end.longValue();
		if (sl <= drStart && el >= drEnd) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return toString(DateRangeMutant.class);
	}
	
	public String toString(Class c) {
		I_TextFormatter formatter = TextFormatter.getInstance();
		String startedString = null;
		if (start != null) {
			startedString = formatter.formatDate(DateTime.DEFAULT_DATE_TIME_FORMAT, start.longValue());
		}
		String endedString = null;
		if (end != null) {
			endedString = formatter.formatDate(DateTime.DEFAULT_DATE_TIME_FORMAT, end.longValue());
		}
		
		return "" + ClassUtils.getClassShortName(c) + 
				" [" + startedString + "-" + endedString + "]";
	}

	public Long getDuration() {
		if (start == null || end == null) {
			return null;
		}
		long el = end.longValue();
		long sl = start.longValue();
		
		return new Long(el - sl);
	}

	public boolean contains(Long time) {
		long tl = time.longValue();
		long el = end.longValue();
		long sl = start.longValue();
		
		if (tl >= sl && tl <= el) {
			return true;
		}
		return false;
	}
}
