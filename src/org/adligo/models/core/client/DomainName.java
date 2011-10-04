package org.adligo.models.core.client;

import org.adligo.i.log.client.Log;
import org.adligo.i.log.client.LogFactory;

/**
 * immutable Class to represent a domain name ie adligo.com
 * @author scott
 *
 */
public class DomainName implements I_NamedId, I_Mutable, I_Validateable {
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
	
	public DomainName(I_NamedId other) throws InvalidParameterException {
		wrapped = new DomainNameMutant(other);
	}
	
	public DomainName(String name) throws InvalidParameterException {
		wrapped = new DomainNameMutant(name);
	}

	public DomainName(String name, I_StorageIdentifier id) throws InvalidParameterException {
		wrapped = new DomainNameMutant(name, id);
	}

	public boolean equals(Object obj) {
		return wrapped.equals(obj);
	}

	public I_StorageIdentifier getId() {
		return wrapped.getId();
	}

	public String getName() {
		return wrapped.getName();
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
		return wrapped.getName();
	}

	
}
