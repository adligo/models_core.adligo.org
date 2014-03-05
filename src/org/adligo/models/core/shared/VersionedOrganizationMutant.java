package org.adligo.models.core.shared;

public class VersionedOrganizationMutant extends OrganizationMutant implements I_ChangeableMutant {
	private Integer version;
	
	public VersionedOrganizationMutant() {
		
	}
	
	public VersionedOrganizationMutant(I_Organization p) throws InvalidParameterException {
		super(p);
		try {
			version = ((I_Changeable) p).getVersion();
		} catch (ClassCastException x) {
			version = 0;
		}
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public void isValid() throws ValidationException {
		ChangeableValidator.validate(this);
		super.isValid();
	}
}
