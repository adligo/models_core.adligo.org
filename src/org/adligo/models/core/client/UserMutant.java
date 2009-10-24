package org.adligo.models.core.client;

import org.adligo.i.util.client.StringUtils;

public class UserMutant extends User {
	public UserMutant() {}
	
	public UserMutant(User p) {
		super(p);
	}
	
	public void setName(String name) throws InvalidParameterException {
		if (StringUtils.isEmpty(name)) {
			throw new InvalidParameterException("UserMutant name can't be set to empty!", "setName");
		}
		super.name = name;
	}
	public void setDomain(String domain) throws InvalidParameterException {
		if (StringUtils.isEmpty(domain)) {
			throw new InvalidParameterException("UserMutant domain can't be set to empty!", "setDomain");
		}
		super.domain = domain;
	}
	public void setPassword(String password) throws InvalidParameterException {
		if (StringUtils.isEmpty(password)) {
			throw new InvalidParameterException("UserMutant password can't be set to empty!", "setPassword");
		}
		super.password = password;
	}
	public void setId(Integer id) throws InvalidParameterException {
		if (id == null) {
			throw new InvalidParameterException("UserMutant id can't be set to null!", "setId");
		}
		this.id = id;
	}
}
