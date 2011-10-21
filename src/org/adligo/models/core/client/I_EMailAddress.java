package org.adligo.models.core.client;

import java.io.Serializable;

public interface I_EMailAddress extends Serializable {
	public String getEMail();
	public I_DomainName getDomainName();
	public String getUserName();
}
