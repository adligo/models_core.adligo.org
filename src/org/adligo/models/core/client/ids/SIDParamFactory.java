package org.adligo.models.core.client.ids;

import org.adligo.models.params.client.I_TemplateParams;
import org.adligo.models.params.client.Params;
import org.adligo.models.params.client.ParamsFactory;

public class SIDParamFactory {

	public static final String VERSION = "version";

	public static I_TemplateParams byId(I_StorageIdentifier p) {
		try {
			return byId((I_LongIdentifier) p);
		} catch (ClassCastException cce) {
			//do nothing
		}
		try {
			return byId((I_VersionedLongIdentifier) p);
		} catch (ClassCastException cce) {
			//do nothing
		}
		try {
			return byId((I_StringIdentifier) p);
		} catch (ClassCastException cce) {
			//do nothing
		}
		return null;
	}
	
	private static I_TemplateParams byId(I_LongIdentifier p) {
		Long id = p.getId();
		return ParamsFactory.byId(id);
	}
	
	private static I_TemplateParams byId(I_StringIdentifier p) {
		String id = p.getKey();
		return ParamsFactory.byId(id);
	}
	
	private static I_TemplateParams byId(I_VersionedLongIdentifier p) {
		Params params = new Params();
		params.addParam(ParamsFactory.DEFAULT);
		Params whereParams = new Params();
		params.addParam(whereParams);
		
		Long id = p.getId();
		whereParams.addParam(ParamsFactory.ID, id);
		Integer version = p.getVersion();
		whereParams.addParam(VERSION, version);
		
		return params;
	}
}
