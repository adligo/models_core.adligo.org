package org.adligo.models.core.client.util;

import org.adligo.models.core.client.InvalidParameterException;

public interface I_DateRangeMutant {

	public abstract void setStarted(Long p) throws InvalidParameterException;

	public abstract void setEnded(Long p) throws InvalidParameterException;

}