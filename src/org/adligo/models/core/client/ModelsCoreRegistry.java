package org.adligo.models.core.client;


public class ModelsCoreRegistry {

	public static void setup() {
		//setup english constants for servers unless overridden
		new ModelsCoreEnglishConstants();
		
	}
}
