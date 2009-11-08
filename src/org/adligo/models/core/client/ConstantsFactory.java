package org.adligo.models.core.client;

import org.adligo.i.adi.client.I_Invoker;
import org.adligo.i.util.client.I_Map;
import org.adligo.i.util.client.MapFactory;

public class ConstantsFactory implements I_Invoker {
	public static final ConstantsFactory INSTANCE = new ConstantsFactory();
	
	private I_Map map = MapFactory.create();
	
	public Object invoke(Object valueObject) {
		Object val = map.get(valueObject);
		if (val instanceof I_Invoker) {
			return ((I_Invoker) val).invoke(null);
		}
		return val;
	}

	/**
	 * J2me doesn't have annotations or Generics
	 * @param clazz
	 * @param impl
	 */
	public synchronized void put(Class clazz, Object impl) {
		map.put(clazz, impl);
	}
}
