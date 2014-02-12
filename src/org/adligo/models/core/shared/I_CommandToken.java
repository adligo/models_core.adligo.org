package org.adligo.models.core.shared;

import java.io.Serializable;

public interface I_CommandToken {

	public abstract Serializable getData();

	public abstract String getCommand();

}