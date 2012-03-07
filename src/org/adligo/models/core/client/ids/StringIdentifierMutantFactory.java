package org.adligo.models.core.client.ids;

import org.adligo.models.core.client.InvalidParameterException;

public class StringIdentifierMutantFactory implements I_StorageIdGenerator {
	public I_StorageIdentifier generate(I_StorageIdentifier other)
		throws InvalidParameterException, ClassCastException {
		
		return new StringIdentifierMutant((I_StringIdentifier) other);
	}
}