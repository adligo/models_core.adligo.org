package org.adligo.models.core.shared;

import org.adligo.models.core.shared.ids.I_StorageIdentifier;

public interface I_Organization extends I_NamedId, I_Customizable, I_Changeable {
	public I_StorageIdentifier getType();
	public I_Organization toImmutable() throws ValidationException;
	public I_OrganizationMutant toMutant() throws ValidationException;
}