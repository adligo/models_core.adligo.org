package org.adligo.models.core.shared;

import java.io.Serializable;

public interface I_ModifyEMailList {
	public String getMailListName();
	public EMailAddress getAddress();
	public boolean isSignup();
}
