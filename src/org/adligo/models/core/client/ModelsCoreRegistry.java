package org.adligo.models.core.client;

import org.adligo.i.adi.client.Registry;

public class ModelsCoreRegistry {

	public synchronized static void init() {
		Registry.addOrReplaceInvoker(ModelInvokerNames.CONSTANTS_FACTORY, ConstantsFactory.INSTANCE);
	}
}
