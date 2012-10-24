package org.adligo.models.core.client.util;

import java.sql.Date;

import org.adligo.models.params.client.Params;
import org.adligo.models.params.client.SqlOperators;

public class DateRangeParamsFactory {

	
	public static void addDateRangeParams(Params params, I_DateRange dr, String fieldName) {
		Params rangesParams = new Params();
		
		params.addParam(fieldName + "_ranges", rangesParams);
		
		Params rangeParams = new Params();
		rangesParams.addParam(fieldName + "_range", rangeParams);
		rangeParams.addParam(fieldName, SqlOperators.GREATER_THAN_EQUALS, new Date(dr.getStart()));
		rangeParams.addParam(fieldName, SqlOperators.LESS_THAN_EQUALS, new Date(dr.getEnd()));
	}
}
