package org.adligo.models.core.client;

public interface I_PersonMutant extends I_Person, I_ChangeableMutant {
	public void setFirst_name(String p) throws InvalidParameterException;
	public void setMiddle_name(String p) throws InvalidParameterException;
	public void setLast_name(String p) throws InvalidParameterException;
	public void setNickname(String p) throws InvalidParameterException;
	public void setBirthday(Long p) throws InvalidParameterException;
	public void setDeceased(Long p) throws InvalidParameterException;
	public void setGender(Character c) throws InvalidParameterException;
	public void setCustomInfo(I_CustomInfo p) throws InvalidParameterException;
}
