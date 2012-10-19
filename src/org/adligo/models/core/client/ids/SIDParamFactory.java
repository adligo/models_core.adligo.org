package org.adligo.models.core.client.ids;

import org.adligo.models.params.client.I_TemplateParams;
import org.adligo.models.params.client.Params;
import org.adligo.models.params.client.ParamsFactory;
import org.adligo.models.params.client.SqlOperators;

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
		params.addParam(ParamsFactory.WHERE, whereParams);
		
		Long id = p.getId();
		whereParams.addParam(ParamsFactory.ID, SqlOperators.EQUALS, id);
		Integer version = p.getVersion();
		whereParams.addParam(VERSION, SqlOperators.EQUALS, version);
		
		return params;
	}
	

	/**
	 * 
	 * @param parent the parent parameters (whereParams usually)
	 * @param paramName 
	 * @param p
	 */
	public static void addIdParameter(Params parent, String paramName, I_LongIdentifier p) {
		Long id = p.getId();
		parent.addParam(paramName, SqlOperators.EQUALS, id);
	}
	
	/**
	 * 
	 * @param parent the parent parameters (whereParams usually)
	 * @param paramName 
	 * @param p
	 */
	public static void addIdParameter(Params parent, String paramName, I_StringIdentifier p) {
		String id = p.getKey();
		parent.addParam(paramName, SqlOperators.EQUALS, id);
	}
	
	public static void addIdParameter(Params parent, String idParamName, String valueParamName,  I_VersionedLongIdentifier p) {
		Long id = p.getId();
		parent.addParam(idParamName, SqlOperators.EQUALS, id);
		Integer version = p.getVersion();
		parent.addParam(valueParamName, SqlOperators.EQUALS, version);
	}
}
