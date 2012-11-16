package org.adligo.models.core.client.util;

import org.adligo.models.core.client.InvalidParameterException;

public interface I_DateRangeMutant extends I_DateRange {

	public abstract void setStart(Long p) throws InvalidParameterException;

	public abstract void setEnd(Long p) throws InvalidParameterException;

}