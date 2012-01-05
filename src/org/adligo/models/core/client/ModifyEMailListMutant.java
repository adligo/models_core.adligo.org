package org.adligo.models.core.client;

/**
 * this class represents a request to modify a email list
 * (signup or removal)
 * @author scott
 *
 */
public class ModifyEMailListMutant implements I_ModifyEMailListMutant {
	/**
	 * true for signup request
	 * false for removal request
	 */
	private boolean signup;
	private String mailListName;
	private I_EMailAddress address;
	
	public String getMailListName() {
		return mailListName;
	}
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_EMailListSignupRequestMutant#setMailListName(java.lang.String)
	 */
	@Override
	public void setMailListName(String mailListName) {
		this.mailListName = mailListName;
	}
	public I_EMailAddress getAddress() {
		return address;
	}
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_EMailListSignupRequestMutant#setAddress(org.adligo.models.core.client.I_EMailAddress)
	 */
	@Override
	public void setAddress(I_EMailAddress address) {
		this.address = address;
	}
	public boolean isSignup() {
		return signup;
	}
	public void setSignup(boolean signup) {
		this.signup = signup;
	}
	
}
