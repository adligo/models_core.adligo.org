package org.adligo.models.core.shared;

import org.adligo.models.core.shared.util.VersionedValidator;
import org.adligo.models.core.shared.util.VersionValidator;

public class OrgVersionedMutant extends OrgMutant implements I_OrgVersionedMutant {
	private Integer version;
	
	public OrgVersionedMutant() {
		
	}
	
	public OrgVersionedMutant(I_Org p) throws InvalidParameterException {
		super(p);
		version = 0;
	}

	public OrgVersionedMutant(I_OrgVersioned p) throws InvalidParameterException {
		super(p);
		version = p.getVersion();
	}
	
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) throws InvalidParameterException {
		VersionValidator.validate(version, this);
		this.version = version;
	}

	public void isValid() throws ValidationException {
		VersionedValidator.validate(this);
		super.isValid();
	}
	
	public boolean isStored() throws ValidationException {
		if (super.isStored()) {
			if (version != null) {
				return true;
			}
		}
		return false;
	}
}
