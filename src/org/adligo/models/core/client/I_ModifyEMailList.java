package org.adligo.models.core.client;

import java.io.Serializable;

public interface I_ModifyEMailList extends Serializable {
	public String getMailListName();
	public I_EMailAddress getAddress();
	public boolean isSignup();
}
