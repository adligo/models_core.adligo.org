package org.adligo.models.core.client;

import java.io.Serializable;

public class NamedIdMutant extends NamedId implements Serializable {

	private static final long serialVersionUID = 1L;

	public void setId(Integer p) {
		id = p;
	}
	public void setName(String p) {
		name = p;
	}
	
	public int hashCode() {
		return super.genHashCode();
	}
}
