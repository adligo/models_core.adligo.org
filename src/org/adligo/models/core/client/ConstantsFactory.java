package org.adligo.models.core.client;

import org.adligo.i.adi.client.I_Invoker;
import org.adligo.i.util.client.I_Map;
import org.adligo.i.util.client.MapFactory;

public class ConstantsFactory implements I_Invoker {
	public static final ConstantsFactory INSTANCE = new ConstantsFactory();
	
	private I_Map map = MapFactory.create();
	private ConstantsFactory() {
		put(I_UserValidationConstants.class, new UserValidationEnglishConstants());
	};
	
	public Object invoke(Object valueObject) {
		return map.get(valueObject);
	}

	public synchronized void put(Class clazz, Object impl) {
		map.put(clazz, impl);
	}
}
