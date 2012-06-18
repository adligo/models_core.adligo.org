package org.adligo.models.core.client.ids;

import org.adligo.models.core.client.InvalidParameterException;

public class VersionValidator {
	public static final String SET_VERSION = "setVersion";
	public static final String NULL_VERSION_NOT_ALLOWED = "Null Version numbers are not allowed.";
	
	public static Integer validate(Integer version) throws InvalidParameterException {
		if (version == null) {
			throw new InvalidParameterException(NULL_VERSION_NOT_ALLOWED, SET_VERSION);
		}
		return version;
	}
}
