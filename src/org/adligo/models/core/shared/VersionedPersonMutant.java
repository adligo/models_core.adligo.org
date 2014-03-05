package org.adligo.models.core.shared;

import org.adligo.models.core.shared.util.ChangeableValidator;
import org.adligo.models.core.shared.util.VersionValidator;

public class VersionedPersonMutant extends PersonMutant implements I_ChangeableMutant {
	private Integer version = 0;

	public VersionedPersonMutant() {}
	
	public VersionedPersonMutant(I_Person p) throws InvalidParameterException {
		super(p);
		try {
			version = ((I_Changeable) p).getVersion();
		} catch (ClassCastException x) {
			throw new InvalidParameterException(x.getMessage(), CONSTRUCTOR);
		}
	}
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) throws InvalidParameterException {
		VersionValidator.validate(version,this);
		this.version = version;
	}

	public void isValid() throws ValidationException {
		ChangeableValidator.validate(this);
		super.isValid();
	}
	
}
