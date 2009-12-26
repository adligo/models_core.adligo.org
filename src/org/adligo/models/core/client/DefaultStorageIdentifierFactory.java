package org.adligo.models.core.client;

import org.adligo.i.adi.client.I_CheckedInvoker;
import org.adligo.i.adi.client.InvocationException;

public class DefaultStorageIdentifierFactory implements I_CheckedInvoker {

	public Object invoke(Object other) throws InvocationException {
		try {
			if (other instanceof I_StringIdentifier) {
				return new StringIdentifier((I_StringIdentifier) other);
			} else if (other instanceof I_VersionedIdentifier) {
				return new VersionedIdentifier((I_VersionedIdentifier) other);
			}
		} catch (InvalidParameterException ipx) {
			InvocationException ie = new InvocationException("See invalid parameter exception init cause.");
			ipx.initCause(ipx);
			throw ie;
		}
		return null;
	}
 
}
