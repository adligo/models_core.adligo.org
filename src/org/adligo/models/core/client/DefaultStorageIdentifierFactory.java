package org.adligo.models.core.client;

import org.adligo.i.adi.client.I_CheckedInvoker;
import org.adligo.i.adi.client.InvocationException;
import org.adligo.i.util.client.ClassUtils;

public class DefaultStorageIdentifierFactory implements I_CheckedInvoker {

	public Object invoke(Object other) throws InvocationException {
		try {
			//instnce of doesn't work on GWT
			if (ClassUtils.typeOf(other, StringIdentifier.class) ||
					ClassUtils.typeOf(other, StringIdentifierMutant.class)	) {
				return new StringIdentifier((I_StringIdentifier) other);
			} else if (ClassUtils.typeOf(other, VersionedIdentifier.class) ||
					ClassUtils.typeOf(other, VersionedIdentifierMutant.class)) {
				return new VersionedIdentifier((I_VersionedIdentifier) other);
			}
			InvocationException ie = new InvocationException("Class not accunted for " + other.getClass() + " .");
			throw ie;
		} catch (InvalidParameterException ipx) {
			InvocationException ie = new InvocationException("See invalid parameter exception init cause.");
			ipx.initCause(ipx);
			throw ie;
		}
	}
 
}
