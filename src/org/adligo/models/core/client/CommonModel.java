package org.adligo.models.core.client;

import org.adligo.i.adi.client.I_CheckedInvoker;
import org.adligo.i.adi.client.InvocationException;
import org.adligo.i.adi.client.Registry;

public class CommonModel {

	private static final I_CheckedInvoker STORAGE_IDENTIFIER_FACTORY = 
		Registry.getCheckedInvoker(ModelsCoreCheckedInvokerNames.STORAGE_IDENTIFIER_FACTORY);
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
	public static I_StorageIdentifier getIdClone(I_StorageIdentifier p)
			throws InvalidParameterException {
		
		if (p == null) {
			throw new InvalidParameterException(ID_NULL, I_StorageMutant.SET_ID);
		}
		if (!p.hasValue()) {
			throw new InvalidParameterException(ID_EMPTY, I_StorageMutant.SET_ID);
		}
		try {
			return (I_StorageIdentifier) STORAGE_IDENTIFIER_FACTORY.invoke(p);
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
