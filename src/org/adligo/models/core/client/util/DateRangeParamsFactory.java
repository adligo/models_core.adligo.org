package org.adligo.models.core.client.util;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.adligo.i.util.client.DateTime;
import org.adligo.models.params.client.Params;
import org.adligo.models.params.client.SqlOperators;

public class DateRangeParamsFactory {

	/**
	 * creates time specific date range params
	 * @param params
	 * @param dr
	 * @param fieldName
	 */
	public static void addDateTimeRangeParams(Params params, I_DateRange dr, String fieldName) {
		Params rangesParams = new Params();
		params.addParam(fieldName + "_ranges", rangesParams);
		addDateTimeRange(dr, fieldName, rangesParams);
	}

	/**
	 * Note no generics or annotations for jme compaitibility
	 * 
	 * @param params
	 * @param drs
	 * @param fieldName
	 */
	public static void addDateTimeRangeParams(Params params, Collection drs, String fieldName) {
		if (drs.size() > 0) {
			Params rangesParams = new Params();
			params.addParam(fieldName + "_ranges", rangesParams);
			Iterator it = drs.iterator();
			while (it.hasNext()) {
				I_DateRange dr = (I_DateRange) it.next();
				addDateTimeRange(dr, fieldName, rangesParams);
			}
		}
	}
	
	protected static void addDateTimeRange(I_DateRange dr, String fieldName,
			Params rangesParams) {
		Params rangeParams = new Params();
		rangesParams.addParam(fieldName + "_range", rangeParams);
		rangeParams.addParam(fieldName, SqlOperators.GREATER_THAN_EQUALS, new Date(dr.getStart()));
		rangeParams.addParam(fieldName, SqlOperators.LESS_THAN_EQUALS, new Date(dr.getEnd()));
	}
	
	/**
	 * creates date range params which include any extra time from the start of the start day 
	 * to the end of the end day by extending the start to one millisecond before the start day
	 * and using the GREATER_THAN operator, and extending the end day to the next day and using the 
	 * LESS_THAN operator.
	 * @param params
	 * @param dr
	 * @param fieldName
	 */
	public static void addDateRangeParams(Params params, I_DateRange dr, String fieldName) {
		Params rangesParams = new Params();
		params.addParam(fieldName + "_ranges", rangesParams);
		addDateRange(dr, fieldName, rangesParams);
	}

	/**
	 * note no Generics or annotations for jme
	 * 
	 * @param params
	 * @param drs
	 * @param fieldName
	 */
	public static void addDateRangeParams(Params params, Collection drs, String fieldName) {
		if (drs.size() > 0) {
			Params rangesParams = new Params();
			params.addParam(fieldName + "_ranges", rangesParams);
			Iterator it = drs.iterator();
			while (it.hasNext()) {
				I_DateRange dr = (I_DateRange) it.next();
				addDateRange(dr, fieldName, rangesParams);
			}
		}
	}
	
	protected static void addDateRange(I_DateRange dr, String fieldName,
			Params rangesParams) {
		Params rangeParams = new Params();
		rangesParams.addParam(fieldName + "_range", rangeParams);
		DateTime startDt = new DateTime(dr.getStart());
		DateTime startP = new DateTime(startDt.getDayStart());
		startP = new DateTime(startP.getTime() - 1L);
		
		//System.out.println(new DateTime(start));
		DateTime endDt = new DateTime(dr.getEnd());
		DateTime endP = new DateTime(endDt.getDayEnd());
		endP = new DateTime(endP.getTime() + 1L);
		
		Date startDate = new Date(startP.getTime());
		Date endDate = new Date(endP.getTime());
		rangeParams.addParam(fieldName, SqlOperators.GREATER_THAN, startDate);
		rangeParams.addParam(fieldName, SqlOperators.LESS_THAN, endDate);
	}
}
