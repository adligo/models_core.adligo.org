package org.adligo.models.core.client;

import org.adligo.i.adi.client.I_Invoker;
import org.adligo.i.util.client.I_Map;
import org.adligo.i.util.client.MapFactory;
import org.adligo.models.core.client.english.DomainValidationConstants;
import org.adligo.models.core.client.english.UserValidationConstants;

public class ConstantsFactory implements I_Invoker {
	public static final ConstantsFactory INSTANCE = new ConstantsFactory();
	
	private I_Map map = MapFactory.create();
	
	public Object invoke(Object valueObject) {
		return map.get(valueObject);
	}

	public synchronized void put(Class clazz, Object impl) {
		map.put(clazz, impl);
	}
}
