package org.adligo.models.core.client;

public interface I_Person extends I_NamedId, I_Validateable {
	public abstract String getFirst_name();
	public abstract String getMiddle_name();
	public abstract String getLast_name();
	public abstract Long getBirthday();
	/**
	 * null means there not dead yet
	 *   should also be nullable in case info is found to be incorrect
	 * @return
	 */
	public abstract Long getDeceased();
	public boolean isAlive();

}