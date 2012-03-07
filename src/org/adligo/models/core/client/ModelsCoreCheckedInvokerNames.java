package org.adligo.models.core.client;

public class ModelsCoreCheckedInvokerNames {
	private static final String BASE = ModelsCoreCheckedInvokerNames.class.getName() + ".";
	
	/**
	 * takes a I_StorageIdentifier and returns a Immutable impl of the same type
	 */
	public static final String STORAGE_IDENTIFIER_FACTORY = BASE + "StorageIdentifierFactory";
	/**
	 * takes a I_StorageIdentifier and returns a mutable impl of the same type
	 */
	public static final String STORAGE_IDENTIFIER_MUTANT_FACTORY = BASE + "StorageIdentifierMutantFactory";
}
