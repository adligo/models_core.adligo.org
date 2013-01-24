package org.adligo.models.core.client.ids;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.adligo.models.params.client.I_TemplateParams;
import org.adligo.models.params.client.Param;
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
	

	public static void addIdParameter(Params parent, String paramName, I_StorageIdentifier p) {
		try {
			addIdParameter(parent, paramName, (I_LongIdentifier) p);
			return;
		} catch (ClassCastException cce) {
			//do nothing
		}
		try {
			addIdParameter(parent, paramName, (I_StringIdentifier) p);
			return;
		} catch (ClassCastException cce) {
			//do nothing
		}
		try {
			addIdParameter(parent, paramName, (I_VersionedLongIdentifier) p);
			return;
		} catch (ClassCastException cce) {
			//do nothing
		}
	}
	
	public static void addIdParameter(Params parent, String paramName, I_StorageIdentifier p, I_TemplateParams child) {
		try {
			addIdParameter(parent, paramName, (I_LongIdentifier) p, child);
			return;
		} catch (ClassCastException cce) {
			//do nothing
		}
		try {
			addIdParameter(parent, paramName, (I_StringIdentifier) p, child);
			return;
		} catch (ClassCastException cce) {
			//do nothing
		}
		try {
			addIdParameter(parent, paramName, (I_VersionedLongIdentifier) p, child);
			return;
		} catch (ClassCastException cce) {
			//do nothing
		}
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
	
	public static void addIdParameter(Params parent, String paramName, I_LongIdentifier p, I_TemplateParams childParams) {
		Long id = p.getId();
		Params params = new Params();
		Param param = params.addParam(paramName);
		param.setOperators(SqlOperators.EQUALS);
		param.setValue(id);
		params.addParam(childParams);
		parent.addParam(params);
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
	
	public static void addIdParameter(Params parent, String paramName, I_StringIdentifier p, I_TemplateParams child) {
		String id = p.getKey();
		Params params = new Params();
		Param param = params.addParam(paramName);
		param.setOperators(SqlOperators.EQUALS);
		param.setValue(id);
		params.addParam(child);
		parent.addParam(params);
	}
	
	public static void addIdParameter(Params parent, String idParamName, String valueParamName,  I_VersionedLongIdentifier p) {
		Long id = p.getId();
		parent.addParam(idParamName, SqlOperators.EQUALS, id);
		Integer version = p.getVersion();
		parent.addParam(valueParamName, SqlOperators.EQUALS, version);
	}
	
	public static void addIdParameter(Params parent, String idParamName, String valueParamName,  I_VersionedLongIdentifier p, I_TemplateParams child) {
		Long id = p.getId();
		Params params = new Params();
		Param param = params.addParam(idParamName);
		param.setOperators(SqlOperators.EQUALS);
		param.setValue(id);
		params.addParam(child);
		
		parent.addParam(params);
		
		Integer version = p.getVersion();
		params = new Params();
		param = params.addParam(valueParamName);
		param.setOperators(SqlOperators.EQUALS);
		param.setValue(version);
		params.addParam(child);
		
		parent.addParam(params);
	}
	
	public static Object getIdParameter(I_LongIdentifier p) {
		return p.getId();
	}
	
	/**
	 * 
	 * @param parent the parent parameters (whereParams usually)
	 * @param paramName 
	 * @param p
	 */
	public static Object getIdParameter(I_StringIdentifier p) {
		return p.getKey();
	}
	
	public static Object getIdParameter(I_StorageIdentifier p) {
		try {
			return getIdParameter((I_LongIdentifier) p);
		} catch (ClassCastException cce) {
			//do nothing
		}
		try {
			return getIdParameter((I_StringIdentifier) p);
		} catch (ClassCastException cce) {
			//do nothing
		}
		throw new IllegalArgumentException("Unable to obtain a single object id for " + p);
	}
	
	public static void addIdParametersInClauses(Params parent, String paramName, Collection<I_StorageIdentifier> p) {
		Param childParam = parent.addParam(paramName,SqlOperators.IN);
	    for (I_StorageIdentifier id: p) {
			Object obj = getIdParameter(id);
			try {
				childParam.addValue((Long) obj);
			} catch (ClassCastException x) {
				try {
					childParam.addValue((String) obj);
				} catch (ClassCastException g) {
					throw new RuntimeException(g);
				}
			}
		}
	}
}
