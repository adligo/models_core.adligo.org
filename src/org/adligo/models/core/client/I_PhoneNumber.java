package org.adligo.models.core.client;

import java.io.Serializable;

public interface I_PhoneNumber extends I_Validateable, Serializable {
	public abstract String getNumber();
}