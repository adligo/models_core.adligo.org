package org.adligo.models.core.client.ids;

import org.adligo.i.adi.client.I_Cacheable;
import org.adligo.i.util.client.I_Immutable;
import org.adligo.models.core.client.I_Identifiable;
import org.adligo.models.core.client.InvalidParameterException;

public class VersionedLongIdentifier implements I_VersionedLongIdentifier, I_Immutable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VersionedLongIdentifierMutant vim;
	
	public VersionedLongIdentifier() {
		vim = new VersionedLongIdentifierMutant();
	}
	
	public VersionedLongIdentifier(I_VersionedLongIdentifier p) throws InvalidParameterException {
		vim = new VersionedLongIdentifierMutant(p);
	}

	public Long getId() {
		return vim.getId();
	}

	public Integer getVersion() {
		return vim.getVersion();
	}

	public int hashCode() {
		return vim.hashCode();
	}

	public String toString() {
		return vim.toString();
	}

	public int getMemsize() {
		return vim.getMemsize() + I_Cacheable.OBJECT;
	}

	@Override
	public String getImmutableFieldName() {
		return "vim";
	}

	@Override
	public boolean hasValue() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public I_StorageIdentifier toImmutable() {
		try {
			return new VersionedLongIdentifier(this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
