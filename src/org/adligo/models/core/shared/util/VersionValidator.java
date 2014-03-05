package org.adligo.models.core.shared.util;

import org.adligo.i.util.shared.ClassUtils;
import org.adligo.models.core.shared.InvalidParameterException;

public class VersionValidator {
	public static final String SET_VERSION = "setVersion";
	public static final String NULL_VERSION_NOT_ALLOWED = " Null Version numbers are not allowed.";
	
	public static Integer validate(Integer version, Object callingObj) throws InvalidParameterException {
		if (version == null) {
			throw new InvalidParameterException(
					ClassUtils.getClassShortName(callingObj.getClass()) + 
					NULL_VERSION_NOT_ALLOWED, SET_VERSION);
		}
		return version;
	}
}
