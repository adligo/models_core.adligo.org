package org.adligo.models.core.client;



public class OrganizationMutant extends Organization {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrganizationMutant() {
		
	}
	
	public OrganizationMutant(Organization o) throws InvalidParameterException {
		super(o);
	}
	
	public void setId(StorageIdentifier p)  throws InvalidParameterException {
		setIdP(p);
	}
	
	public void setName(String p) throws InvalidParameterException {
		setNameP(p);
	}
	
	public void setType(NamedId p) throws InvalidParameterException {
		setTypeP(p);
	}
	
}
