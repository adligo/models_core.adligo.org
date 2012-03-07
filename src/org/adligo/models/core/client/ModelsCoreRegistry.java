package org.adligo.models.core.client;

import org.adligo.i.adi.client.Registry;
import org.adligo.models.core.client.ids.DefaultStorageIdentifierFactory;

public class ModelsCoreRegistry {

	public static void setup() {
		//setup english constants for servers unless overridden
		new ModelsCoreEnglishConstants();
		
		Registry.addCheckedInvoker(ModelsCoreCheckedInvokerNames.STORAGE_IDENTIFIER_FACTORY, 
				new DefaultStorageIdentifierFactory());
	}
}
