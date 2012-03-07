package org.adligo.models.core.client;

import org.adligo.i.adi.client.I_CheckedInvoker;
import org.adligo.i.adi.client.InvocationException;
import org.adligo.i.adi.client.Registry;
import org.adligo.models.core.client.ids.I_StorageIdentifier;

public class CommonModel {

	private static final I_CheckedInvoker STORAGE_IDENTIFIER_FACTORY = 
		Registry.getCheckedInvoker(ModelsCoreCheckedInvokerNames.STORAGE_IDENTIFIER_FACTORY);
	private static final I_CheckedInvoker STORAGE_IDENTIFIER_MUTANT_FACTORY = 
		Registry.getCheckedInvoker(ModelsCoreCheckedInvokerNames.STORAGE_IDENTIFIER_MUTANT_FACTORY);
	public static final String ID_NULL = "You set the id to null?";
	public static final String ID_EMPTY = "You called set id with a invalid object.";
	
	/**
	 * exception generating code so you 
	 * don't need this in every model
	 * 
	 * Note the key factory is put into the adi Registry
	 * so that you can replace it with your own if for instance you have objects
	 * with int instead of longs
	 * and that is hogging memory
	 * 
	 * @param p
	 * @return
	 * @throws InvalidParameterException
	 */
	public static I_StorageIdentifier getIdClone(I_StorageIdentifier p) throws InvalidParameterException {
		return getIdClone(p, false);
	}
	
	public static I_StorageIdentifier getIdMutantClone(I_StorageIdentifier p) throws InvalidParameterException {
		return getIdClone(p, true);
	}
	
	private static I_StorageIdentifier getIdClone(I_StorageIdentifier p, boolean mutant)
			throws InvalidParameterException {
		
		if (p == null) {
			throw new InvalidParameterException(ID_NULL, I_StorageMutant.SET_ID);
		}
		if (!p.hasValue()) {
			throw new InvalidParameterException(ID_EMPTY, I_StorageMutant.SET_ID);
		}
		try {
			if (!mutant) {
				return (I_StorageIdentifier) STORAGE_IDENTIFIER_FACTORY.invoke(p);
			} else {
				return (I_StorageIdentifier) STORAGE_IDENTIFIER_MUTANT_FACTORY.invoke(p);
			}
		} catch (InvocationException ix) {
			Throwable t = ix.getCause();
			if (t instanceof InvalidParameterException) {
				throw (InvalidParameterException) t;
			}
			InvalidParameterException ipe = new InvalidParameterException(ix.getMessage(), I_StorageMutant.SET_ID);
			ipe.initCause(ix);
			throw ipe;
		}
	}
}
