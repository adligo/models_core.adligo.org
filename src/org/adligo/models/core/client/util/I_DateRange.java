package org.adligo.models.core.client.util;

import java.io.Serializable;

import org.adligo.models.core.client.I_Validateable;

public interface I_DateRange extends Serializable, I_Validateable {

	public abstract Long getStart();

	public abstract Long getEnd();

}