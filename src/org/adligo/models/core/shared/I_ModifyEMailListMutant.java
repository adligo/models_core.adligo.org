package org.adligo.models.core.shared;

public interface I_ModifyEMailListMutant extends I_ModifyEMailList {

	public void setMailListName(String mailListName);

	public void setAddress(EMailAddress address);

	public void setSignup(boolean signup);
}