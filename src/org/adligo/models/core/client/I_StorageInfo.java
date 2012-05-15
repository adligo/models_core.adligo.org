package org.adligo.models.core.client;

import java.io.Serializable;

public interface I_StorageInfo extends Serializable {
	/**
	 * this should return a system usable name 
	 * which can be used to determine where the object with this info
	 * was stored when it was put back in ram (db, ldap, filesystem exc)
	 * 
	 * It should NOT return a schema name or url or anything 
	 * which could use to penetrate/hack the systems.
	 * @return
	 */
	public String getStoreName();
	public I_StorageInfo toImmutable();
}
