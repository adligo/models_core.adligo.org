package org.adligo.models.core.client;

/**
 * this class represents a request to modify a email list
 * (signup or removal)
 * @author scott
 *
 */
public class ModifyEMailListMutant implements I_ModifyEMailListMutant {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * true for signup request
	 * false for removal request
	 */
	private boolean signup;
	private String mailListName;
	private EMailAddress address;
	
	public String getMailListName() {
		return mailListName;
	}
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_EMailListSignupRequestMutant#setMailListName(java.lang.String)
	 */
	public void setMailListName(String mailListName) {
		this.mailListName = mailListName;
	}
	public EMailAddress getAddress() {
		return address;
	}
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.I_EMailListSignupRequestMutant#setAddress(org.adligo.models.core.client.I_EMailAddress)
	 */
	public void setAddress(EMailAddress address) {
		this.address = address;
	}
	public boolean isSignup() {
		return signup;
	}
	public void setSignup(boolean signup) {
		this.signup = signup;
	}
	
}
