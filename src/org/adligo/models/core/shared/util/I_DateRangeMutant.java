package org.adligo.models.core.shared.util;

import org.adligo.models.core.shared.InvalidParameterException;

public interface I_DateRangeMutant extends I_DateRange {

	public abstract void setStart(Long p) throws InvalidParameterException;

	public abstract void setEnd(Long p) throws InvalidParameterException;

}