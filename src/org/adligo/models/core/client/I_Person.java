package org.adligo.models.core.client;

public interface I_Person extends I_NamedId, I_Validateable, I_Changeable {
	public static final Character GENDER_MALE = 'M';
	public static final Character GENDER_FEMALE = 'F'; 
	public static final Character GENDER_OTHER = 'O';
	
	public String getFirst_name();
	public String getMiddle_name();
	public String getLast_name();
	public String getNickname();
	public Long getBirthday();
	/**
	 * null means there not dead yet
	 *   should also be nullable in case info is found to be incorrect
	 * @return
	 */
	public Long getDeceased();
	/**
	 * may return null if the system doesn't know 
	 * if the person is alive or not
	 * (although it generally assumes they are, unless told they are dead)
	 * 
	 * @return
	 */
	public Boolean isAlive();
	
	/**
	 * the gender of the person (use constants in this interface 
	 * GENDER_MALE, GENDER_FEMALE, GENDER_OTHER)
	 * @return
	 */
	public Character getGender();
	/**
	 * @see I_CustomInfo
	 * @return
	 */
	public I_CustomInfo getCustomInfo();
}