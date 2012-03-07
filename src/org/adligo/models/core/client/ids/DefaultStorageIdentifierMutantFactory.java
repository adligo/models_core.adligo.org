package org.adligo.models.core.client.ids;

import org.adligo.i.adi.client.I_CheckedInvoker;
import org.adligo.i.adi.client.InvocationException;
import org.adligo.i.util.client.I_Map;
import org.adligo.i.util.client.MapFactory;
import org.adligo.models.core.client.InvalidParameterException;

public class DefaultStorageIdentifierMutantFactory implements I_CheckedInvoker {
	private static final I_Map TYPES_TO_GENERATORS = getTypesToGenerators();
	
	private static I_Map getTypesToGenerators() {
		I_Map toRet = MapFactory.create();
		toRet.put(StringIdentifierMutant.TYPE, new StringIdentifierMutantFactory());
		toRet.put(VersionedIdentifierMutant.TYPE, new VersionedIdentifierMutantFactory());
		toRet.put(LongIdentifierMutant.TYPE, new LongIdentifierMutantFactory());
		return toRet;
	}
	
	public Object invoke(Object other) throws InvocationException {
		try {
			I_StorageIdentifier id = (I_StorageIdentifier) other;
			String type = id.getType();
			I_StorageIdGenerator gen = (I_StorageIdGenerator) TYPES_TO_GENERATORS.get(type);
			if (gen == null) {
				InvocationException ie = new InvocationException("Class not accunted for " + other.getClass() + " .");
				throw ie;
			}
			return gen.generate(id);
		} catch (ClassCastException x) {
			InvocationException ie = new InvocationException("See invalid parameter exception init cause.");
			x.initCause(x);
			throw ie;
		} catch (InvalidParameterException x) {
			InvocationException ie = new InvocationException("See invalid parameter exception init cause.");
			x.initCause(x);
			throw ie;
		} 
	}
 
}
