package org.adligo.models.core.client;

public interface I_PersonMutant extends I_Person, I_StorageMutant {
	public void setFirst_name(String p);
	public void setMiddle_name(String p);
	public void setLast_name(String p);
	public void setNickname(String p);
	public void setBirthday(Long p);
	public void setDeceased(Long p);
	public void setGender(Character c);
	public void setHeight(Double p);
}
