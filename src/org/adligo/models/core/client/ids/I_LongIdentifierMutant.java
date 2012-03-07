package org.adligo.models.core.client.ids;

import org.adligo.models.core.client.InvalidParameterException;

public interface I_LongIdentifierMutant extends I_LongIdentifier {
	public void setId(Long p) throws InvalidParameterException ;
}
