package org.adligo.models.core.client;

public interface I_Person extends I_NamedId, I_Validateable, I_Changeable {
	public static final Character GENDER_MALE = new Character('M');
	public static final Character GENDER_FEMALE = new Character('F');
	public static final Character GENDER_OTHER = new Character('O');
	
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
	public boolean isAlive();
	
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

	/**
	 * may return null if the height of the person is unknown,
	 * the last height of the person in meters
	 * note double is used instead of BigDecimal for JME
	 */
	public Double getHeight();
	/**
	 * may return null if the weight of the person is unknown,
	 * the last weight of the person in kilograms
	 * note double is used instead of BigDecimal for JME
	 */
	public Double getWeight();
}