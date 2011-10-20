package org.adligo.models.core.client;

import org.adligo.i.adi.client.Registry;

public class ModelsCoreRegistry {

	public static void setup() {
		Registry.addCheckedInvoker(ModelsCoreCheckedInvokerNames.STORAGE_IDENTIFIER_FACTORY, 
				new DefaultStorageIdentifierFactory());
	}
}
