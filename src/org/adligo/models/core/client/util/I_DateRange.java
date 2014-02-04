package org.adligo.models.core.client.util;

import org.adligo.models.core.client.I_Validateable;

public interface I_DateRange extends I_Validateable {

	public abstract Long getStart();

	public abstract Long getEnd();

	public boolean overlaps(I_DateRange dr);
	
	public boolean contains(I_DateRange dr);
	
	public boolean contains(Long time);
	
	/**
	 * @return null if start or end is null
	 *  otherwise end - start 
	 */
	public Long getDuration();
}