package org.adligo.models.core.client;

import org.adligo.i.log.client.Log;
import org.adligo.i.log.client.LogFactory;

/**
 * immutable Class to represent a domain name ie adligo.com
 * @author scott
 *
 */
public class DomainName implements I_DomainName, I_Mutable, I_Validateable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(DomainName.class);
	private DomainNameMutant wrapped;

	
	/**
	 * mostly only for RPC Serilization
	 * as this class is immutable
	 */
	public DomainName() {
		wrapped = new DomainNameMutant();
	}

	public DomainName(I_DomainName name) throws InvalidParameterException {
		String dn = "";
		if (name != null) {
			dn = name.getName();
		}
		wrapped = new DomainNameMutant(dn);
	}
	
	public DomainName(String name) throws InvalidParameterException {
		wrapped = new DomainNameMutant(name);
	}

	public boolean equals(Object obj) {
		return wrapped.equals(obj);
	}

	public int hashCode() {
		return wrapped.hashCode();
	}

	public boolean isValid() {
		return wrapped.isValid();
	}

	public boolean isMutable() {
		return wrapped.isMutable();
	}
	
	public String toString() {
		return wrapped.toString();
	}

	public static void validate(String domain) throws InvalidParameterException {
		DomainNameMutant.validate(domain);
	}
	
	public static String toDn(String domain) throws InvalidParameterException {
		return DomainNameMutant.toDn(domain);
	}
	
	public static String fromDn(String dn) throws InvalidParameterException {
		return DomainNameMutant.fromDn(dn);
	}

	public String getName() {
		return wrapped.getName();
	}
	
}
