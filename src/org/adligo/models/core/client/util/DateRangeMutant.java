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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String SET_ENDED = "setEnded";
	private Long started;
	private Long ended;
	
	public DateRangeMutant() {}
	
	public DateRangeMutant(I_DateRange p) throws InvalidParameterException {
		setStarted(p.getStarted());
		setEnded(p.getEnded());
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.util.I_DateRange#getStarted()
	 */
	public Long getStarted() {
		return started;
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.util.I_DateRangeMutant#setStarted(java.lang.Long)
	 */
	public void setStarted(Long p) throws InvalidParameterException {
		if (ended != null) {
			if (p != null) {
				if (p > ended) {
					throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
							.getStartOfDateRangeMustBeBeforeEnd(), SET_ENDED);
				}
			}
		}
		started = p;
	}
	/**
	 * protected only for hibernate
	 * @return
	 */
	protected Date getStartedDate() {
		if (started == null) {
			return null;
		}
		return new Date(started);
	}
	
	protected void setStartedDate(Date p) {
		if (p == null) {
			//allow null to come from the db
			return;
		}
		started = p.getTime();
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.util.I_DateRange#getEnded()
	 */
	@Override
	public Long getEnded() {
		return ended;
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.util.I_DateRangeMutant#setEnded(java.lang.Long)
	 */
	@Override
	public void setEnded(Long p) throws InvalidParameterException {
		if (started != null) {
			if (p != null) {
				if (p < started) {
					throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
							.getEndOfDateRangeMustBeAfterStart(), SET_ENDED);
				}
			}
		}
		ended = p;
	}
	/**
	 * protected only for hibernate
	 * @return
	 */
	protected Date getEndedDate() {
		if (ended == null) {
			return null;
		}
		return new Date(ended);
	}
	
	protected void setEndedDate(Date p) {
		if (p == null) {
			//allow null to come from the db
			return;
		}
		started = p.getTime();
	}

	public void isValid() throws ValidationException {
		try {
			DateRangeMutant other = new DateRangeMutant();
			other.setEnded(ended);
			other.setStarted(started);
		} catch (InvalidParameterException ipe) {
			throw new ValidationException(ipe);
		}
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ended == null) ? 0 : ended.hashCode());
		result = prime * result + ((started == null) ? 0 : started.hashCode());
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
		if (ended == null) {
			if (other.ended != null)
				return false;
		} else if (!ended.equals(other.ended))
			return false;
		if (started == null) {
			if (other.started != null)
				return false;
		} else if (!started.equals(other.started))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return toString(DateRangeMutant.class);
	}
	
	public String toString(Class c) {
		I_TextFormatter formatter = TextFormatter.getInstance();
		String startedString = formatter.formatDate(DateTime.DEFAULT_DATE_TIME_FORMAT, started);
		String endedString = formatter.formatDate(DateTime.DEFAULT_DATE_TIME_FORMAT, ended);
		
		return "" + ClassUtils.getClassShortName(c) + 
				" [" + startedString + "-" + endedString + "]";
	}
}
