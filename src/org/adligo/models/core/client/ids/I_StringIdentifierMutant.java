package org.adligo.models.core.client.ids;

import org.adligo.models.core.client.InvalidParameterException;

public interface I_StringIdentifierMutant extends I_StringIdentifier, I_StorageIdentifier {
	public void setKey(String p) throws InvalidParameterException ;
}
