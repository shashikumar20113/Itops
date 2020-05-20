/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.lti.itops.ipac.custcatmgmt.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the ttdpsp cust decision task table service. This utility wraps {@link com.lti.itops.ipac.custcatmgmt.service.persistence.impl.TTDPSPCustDecisionTaskTablePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sunprabh
 * @see TTDPSPCustDecisionTaskTablePersistence
 * @see com.lti.itops.ipac.custcatmgmt.service.persistence.impl.TTDPSPCustDecisionTaskTablePersistenceImpl
 * @generated
 */
@ProviderType
public class TTDPSPCustDecisionTaskTableUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable) {
		getPersistence().clearCache(ttdpspCustDecisionTaskTable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TTDPSPCustDecisionTaskTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TTDPSPCustDecisionTaskTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TTDPSPCustDecisionTaskTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TTDPSPCustDecisionTaskTable update(
		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable) {
		return getPersistence().update(ttdpspCustDecisionTaskTable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TTDPSPCustDecisionTaskTable update(
		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable,
		ServiceContext serviceContext) {
		return getPersistence()
				   .update(ttdpspCustDecisionTaskTable, serviceContext);
	}

	/**
	* Returns all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @return the matching ttdpsp cust decision task tables
	*/
	public static List<TTDPSPCustDecisionTaskTable> findByParentTTDPSPTaskCustomerId(
		long parentTTDPSPTaskCustomerId) {
		return getPersistence()
				   .findByParentTTDPSPTaskCustomerId(parentTTDPSPTaskCustomerId);
	}

	/**
	* Returns a range of all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param start the lower bound of the range of ttdpsp cust decision task tables
	* @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	* @return the range of matching ttdpsp cust decision task tables
	*/
	public static List<TTDPSPCustDecisionTaskTable> findByParentTTDPSPTaskCustomerId(
		long parentTTDPSPTaskCustomerId, int start, int end) {
		return getPersistence()
				   .findByParentTTDPSPTaskCustomerId(parentTTDPSPTaskCustomerId,
			start, end);
	}

	/**
	* Returns an ordered range of all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param start the lower bound of the range of ttdpsp cust decision task tables
	* @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ttdpsp cust decision task tables
	*/
	public static List<TTDPSPCustDecisionTaskTable> findByParentTTDPSPTaskCustomerId(
		long parentTTDPSPTaskCustomerId, int start, int end,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator) {
		return getPersistence()
				   .findByParentTTDPSPTaskCustomerId(parentTTDPSPTaskCustomerId,
			start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param start the lower bound of the range of ttdpsp cust decision task tables
	* @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching ttdpsp cust decision task tables
	*/
	public static List<TTDPSPCustDecisionTaskTable> findByParentTTDPSPTaskCustomerId(
		long parentTTDPSPTaskCustomerId, int start, int end,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByParentTTDPSPTaskCustomerId(parentTTDPSPTaskCustomerId,
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ttdpsp cust decision task table
	* @throws NoSuchTTDPSPCustDecisionTaskTableException if a matching ttdpsp cust decision task table could not be found
	*/
	public static TTDPSPCustDecisionTaskTable findByParentTTDPSPTaskCustomerId_First(
		long parentTTDPSPTaskCustomerId,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPCustDecisionTaskTableException {
		return getPersistence()
				   .findByParentTTDPSPTaskCustomerId_First(parentTTDPSPTaskCustomerId,
			orderByComparator);
	}

	/**
	* Returns the first ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ttdpsp cust decision task table, or <code>null</code> if a matching ttdpsp cust decision task table could not be found
	*/
	public static TTDPSPCustDecisionTaskTable fetchByParentTTDPSPTaskCustomerId_First(
		long parentTTDPSPTaskCustomerId,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator) {
		return getPersistence()
				   .fetchByParentTTDPSPTaskCustomerId_First(parentTTDPSPTaskCustomerId,
			orderByComparator);
	}

	/**
	* Returns the last ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ttdpsp cust decision task table
	* @throws NoSuchTTDPSPCustDecisionTaskTableException if a matching ttdpsp cust decision task table could not be found
	*/
	public static TTDPSPCustDecisionTaskTable findByParentTTDPSPTaskCustomerId_Last(
		long parentTTDPSPTaskCustomerId,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPCustDecisionTaskTableException {
		return getPersistence()
				   .findByParentTTDPSPTaskCustomerId_Last(parentTTDPSPTaskCustomerId,
			orderByComparator);
	}

	/**
	* Returns the last ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ttdpsp cust decision task table, or <code>null</code> if a matching ttdpsp cust decision task table could not be found
	*/
	public static TTDPSPCustDecisionTaskTable fetchByParentTTDPSPTaskCustomerId_Last(
		long parentTTDPSPTaskCustomerId,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator) {
		return getPersistence()
				   .fetchByParentTTDPSPTaskCustomerId_Last(parentTTDPSPTaskCustomerId,
			orderByComparator);
	}

	/**
	* Returns the ttdpsp cust decision task tables before and after the current ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63;.
	*
	* @param TTDPSPCustDecisionTaskTableId the primary key of the current ttdpsp cust decision task table
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ttdpsp cust decision task table
	* @throws NoSuchTTDPSPCustDecisionTaskTableException if a ttdpsp cust decision task table with the primary key could not be found
	*/
	public static TTDPSPCustDecisionTaskTable[] findByParentTTDPSPTaskCustomerId_PrevAndNext(
		long TTDPSPCustDecisionTaskTableId, long parentTTDPSPTaskCustomerId,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPCustDecisionTaskTableException {
		return getPersistence()
				   .findByParentTTDPSPTaskCustomerId_PrevAndNext(TTDPSPCustDecisionTaskTableId,
			parentTTDPSPTaskCustomerId, orderByComparator);
	}

	/**
	* Removes all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63; from the database.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	*/
	public static void removeByParentTTDPSPTaskCustomerId(
		long parentTTDPSPTaskCustomerId) {
		getPersistence()
			.removeByParentTTDPSPTaskCustomerId(parentTTDPSPTaskCustomerId);
	}

	/**
	* Returns the number of ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @return the number of matching ttdpsp cust decision task tables
	*/
	public static int countByParentTTDPSPTaskCustomerId(
		long parentTTDPSPTaskCustomerId) {
		return getPersistence()
				   .countByParentTTDPSPTaskCustomerId(parentTTDPSPTaskCustomerId);
	}

	/**
	* Returns the ttdpsp cust decision task table where parentTTDPSPTaskCustomerId = &#63; and subTTDPSPTaskCustomerId = &#63; and condition = &#63; or throws a {@link NoSuchTTDPSPCustDecisionTaskTableException} if it could not be found.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param subTTDPSPTaskCustomerId the sub ttdpsp task customer ID
	* @param condition the condition
	* @return the matching ttdpsp cust decision task table
	* @throws NoSuchTTDPSPCustDecisionTaskTableException if a matching ttdpsp cust decision task table could not be found
	*/
	public static TTDPSPCustDecisionTaskTable findByTTDPSPCustDecisionTaskTable(
		long parentTTDPSPTaskCustomerId, long subTTDPSPTaskCustomerId,
		boolean condition)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPCustDecisionTaskTableException {
		return getPersistence()
				   .findByTTDPSPCustDecisionTaskTable(parentTTDPSPTaskCustomerId,
			subTTDPSPTaskCustomerId, condition);
	}

	/**
	* Returns the ttdpsp cust decision task table where parentTTDPSPTaskCustomerId = &#63; and subTTDPSPTaskCustomerId = &#63; and condition = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param subTTDPSPTaskCustomerId the sub ttdpsp task customer ID
	* @param condition the condition
	* @return the matching ttdpsp cust decision task table, or <code>null</code> if a matching ttdpsp cust decision task table could not be found
	*/
	public static TTDPSPCustDecisionTaskTable fetchByTTDPSPCustDecisionTaskTable(
		long parentTTDPSPTaskCustomerId, long subTTDPSPTaskCustomerId,
		boolean condition) {
		return getPersistence()
				   .fetchByTTDPSPCustDecisionTaskTable(parentTTDPSPTaskCustomerId,
			subTTDPSPTaskCustomerId, condition);
	}

	/**
	* Returns the ttdpsp cust decision task table where parentTTDPSPTaskCustomerId = &#63; and subTTDPSPTaskCustomerId = &#63; and condition = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param subTTDPSPTaskCustomerId the sub ttdpsp task customer ID
	* @param condition the condition
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching ttdpsp cust decision task table, or <code>null</code> if a matching ttdpsp cust decision task table could not be found
	*/
	public static TTDPSPCustDecisionTaskTable fetchByTTDPSPCustDecisionTaskTable(
		long parentTTDPSPTaskCustomerId, long subTTDPSPTaskCustomerId,
		boolean condition, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByTTDPSPCustDecisionTaskTable(parentTTDPSPTaskCustomerId,
			subTTDPSPTaskCustomerId, condition, retrieveFromCache);
	}

	/**
	* Removes the ttdpsp cust decision task table where parentTTDPSPTaskCustomerId = &#63; and subTTDPSPTaskCustomerId = &#63; and condition = &#63; from the database.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param subTTDPSPTaskCustomerId the sub ttdpsp task customer ID
	* @param condition the condition
	* @return the ttdpsp cust decision task table that was removed
	*/
	public static TTDPSPCustDecisionTaskTable removeByTTDPSPCustDecisionTaskTable(
		long parentTTDPSPTaskCustomerId, long subTTDPSPTaskCustomerId,
		boolean condition)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPCustDecisionTaskTableException {
		return getPersistence()
				   .removeByTTDPSPCustDecisionTaskTable(parentTTDPSPTaskCustomerId,
			subTTDPSPTaskCustomerId, condition);
	}

	/**
	* Returns the number of ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63; and subTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param subTTDPSPTaskCustomerId the sub ttdpsp task customer ID
	* @param condition the condition
	* @return the number of matching ttdpsp cust decision task tables
	*/
	public static int countByTTDPSPCustDecisionTaskTable(
		long parentTTDPSPTaskCustomerId, long subTTDPSPTaskCustomerId,
		boolean condition) {
		return getPersistence()
				   .countByTTDPSPCustDecisionTaskTable(parentTTDPSPTaskCustomerId,
			subTTDPSPTaskCustomerId, condition);
	}

	/**
	* Returns all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param condition the condition
	* @return the matching ttdpsp cust decision task tables
	*/
	public static List<TTDPSPCustDecisionTaskTable> findByParentTTDPSPTaskCustomerIdAndCondition(
		long parentTTDPSPTaskCustomerId, boolean condition) {
		return getPersistence()
				   .findByParentTTDPSPTaskCustomerIdAndCondition(parentTTDPSPTaskCustomerId,
			condition);
	}

	/**
	* Returns a range of all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param condition the condition
	* @param start the lower bound of the range of ttdpsp cust decision task tables
	* @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	* @return the range of matching ttdpsp cust decision task tables
	*/
	public static List<TTDPSPCustDecisionTaskTable> findByParentTTDPSPTaskCustomerIdAndCondition(
		long parentTTDPSPTaskCustomerId, boolean condition, int start, int end) {
		return getPersistence()
				   .findByParentTTDPSPTaskCustomerIdAndCondition(parentTTDPSPTaskCustomerId,
			condition, start, end);
	}

	/**
	* Returns an ordered range of all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param condition the condition
	* @param start the lower bound of the range of ttdpsp cust decision task tables
	* @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ttdpsp cust decision task tables
	*/
	public static List<TTDPSPCustDecisionTaskTable> findByParentTTDPSPTaskCustomerIdAndCondition(
		long parentTTDPSPTaskCustomerId, boolean condition, int start, int end,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator) {
		return getPersistence()
				   .findByParentTTDPSPTaskCustomerIdAndCondition(parentTTDPSPTaskCustomerId,
			condition, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param condition the condition
	* @param start the lower bound of the range of ttdpsp cust decision task tables
	* @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching ttdpsp cust decision task tables
	*/
	public static List<TTDPSPCustDecisionTaskTable> findByParentTTDPSPTaskCustomerIdAndCondition(
		long parentTTDPSPTaskCustomerId, boolean condition, int start, int end,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByParentTTDPSPTaskCustomerIdAndCondition(parentTTDPSPTaskCustomerId,
			condition, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param condition the condition
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ttdpsp cust decision task table
	* @throws NoSuchTTDPSPCustDecisionTaskTableException if a matching ttdpsp cust decision task table could not be found
	*/
	public static TTDPSPCustDecisionTaskTable findByParentTTDPSPTaskCustomerIdAndCondition_First(
		long parentTTDPSPTaskCustomerId, boolean condition,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPCustDecisionTaskTableException {
		return getPersistence()
				   .findByParentTTDPSPTaskCustomerIdAndCondition_First(parentTTDPSPTaskCustomerId,
			condition, orderByComparator);
	}

	/**
	* Returns the first ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param condition the condition
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ttdpsp cust decision task table, or <code>null</code> if a matching ttdpsp cust decision task table could not be found
	*/
	public static TTDPSPCustDecisionTaskTable fetchByParentTTDPSPTaskCustomerIdAndCondition_First(
		long parentTTDPSPTaskCustomerId, boolean condition,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator) {
		return getPersistence()
				   .fetchByParentTTDPSPTaskCustomerIdAndCondition_First(parentTTDPSPTaskCustomerId,
			condition, orderByComparator);
	}

	/**
	* Returns the last ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param condition the condition
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ttdpsp cust decision task table
	* @throws NoSuchTTDPSPCustDecisionTaskTableException if a matching ttdpsp cust decision task table could not be found
	*/
	public static TTDPSPCustDecisionTaskTable findByParentTTDPSPTaskCustomerIdAndCondition_Last(
		long parentTTDPSPTaskCustomerId, boolean condition,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPCustDecisionTaskTableException {
		return getPersistence()
				   .findByParentTTDPSPTaskCustomerIdAndCondition_Last(parentTTDPSPTaskCustomerId,
			condition, orderByComparator);
	}

	/**
	* Returns the last ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param condition the condition
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ttdpsp cust decision task table, or <code>null</code> if a matching ttdpsp cust decision task table could not be found
	*/
	public static TTDPSPCustDecisionTaskTable fetchByParentTTDPSPTaskCustomerIdAndCondition_Last(
		long parentTTDPSPTaskCustomerId, boolean condition,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator) {
		return getPersistence()
				   .fetchByParentTTDPSPTaskCustomerIdAndCondition_Last(parentTTDPSPTaskCustomerId,
			condition, orderByComparator);
	}

	/**
	* Returns the ttdpsp cust decision task tables before and after the current ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	*
	* @param TTDPSPCustDecisionTaskTableId the primary key of the current ttdpsp cust decision task table
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param condition the condition
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ttdpsp cust decision task table
	* @throws NoSuchTTDPSPCustDecisionTaskTableException if a ttdpsp cust decision task table with the primary key could not be found
	*/
	public static TTDPSPCustDecisionTaskTable[] findByParentTTDPSPTaskCustomerIdAndCondition_PrevAndNext(
		long TTDPSPCustDecisionTaskTableId, long parentTTDPSPTaskCustomerId,
		boolean condition,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPCustDecisionTaskTableException {
		return getPersistence()
				   .findByParentTTDPSPTaskCustomerIdAndCondition_PrevAndNext(TTDPSPCustDecisionTaskTableId,
			parentTTDPSPTaskCustomerId, condition, orderByComparator);
	}

	/**
	* Removes all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63; and condition = &#63; from the database.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param condition the condition
	*/
	public static void removeByParentTTDPSPTaskCustomerIdAndCondition(
		long parentTTDPSPTaskCustomerId, boolean condition) {
		getPersistence()
			.removeByParentTTDPSPTaskCustomerIdAndCondition(parentTTDPSPTaskCustomerId,
			condition);
	}

	/**
	* Returns the number of ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param condition the condition
	* @return the number of matching ttdpsp cust decision task tables
	*/
	public static int countByParentTTDPSPTaskCustomerIdAndCondition(
		long parentTTDPSPTaskCustomerId, boolean condition) {
		return getPersistence()
				   .countByParentTTDPSPTaskCustomerIdAndCondition(parentTTDPSPTaskCustomerId,
			condition);
	}

	/**
	* Caches the ttdpsp cust decision task table in the entity cache if it is enabled.
	*
	* @param ttdpspCustDecisionTaskTable the ttdpsp cust decision task table
	*/
	public static void cacheResult(
		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable) {
		getPersistence().cacheResult(ttdpspCustDecisionTaskTable);
	}

	/**
	* Caches the ttdpsp cust decision task tables in the entity cache if it is enabled.
	*
	* @param ttdpspCustDecisionTaskTables the ttdpsp cust decision task tables
	*/
	public static void cacheResult(
		List<TTDPSPCustDecisionTaskTable> ttdpspCustDecisionTaskTables) {
		getPersistence().cacheResult(ttdpspCustDecisionTaskTables);
	}

	/**
	* Creates a new ttdpsp cust decision task table with the primary key. Does not add the ttdpsp cust decision task table to the database.
	*
	* @param TTDPSPCustDecisionTaskTableId the primary key for the new ttdpsp cust decision task table
	* @return the new ttdpsp cust decision task table
	*/
	public static TTDPSPCustDecisionTaskTable create(
		long TTDPSPCustDecisionTaskTableId) {
		return getPersistence().create(TTDPSPCustDecisionTaskTableId);
	}

	/**
	* Removes the ttdpsp cust decision task table with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param TTDPSPCustDecisionTaskTableId the primary key of the ttdpsp cust decision task table
	* @return the ttdpsp cust decision task table that was removed
	* @throws NoSuchTTDPSPCustDecisionTaskTableException if a ttdpsp cust decision task table with the primary key could not be found
	*/
	public static TTDPSPCustDecisionTaskTable remove(
		long TTDPSPCustDecisionTaskTableId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPCustDecisionTaskTableException {
		return getPersistence().remove(TTDPSPCustDecisionTaskTableId);
	}

	public static TTDPSPCustDecisionTaskTable updateImpl(
		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable) {
		return getPersistence().updateImpl(ttdpspCustDecisionTaskTable);
	}

	/**
	* Returns the ttdpsp cust decision task table with the primary key or throws a {@link NoSuchTTDPSPCustDecisionTaskTableException} if it could not be found.
	*
	* @param TTDPSPCustDecisionTaskTableId the primary key of the ttdpsp cust decision task table
	* @return the ttdpsp cust decision task table
	* @throws NoSuchTTDPSPCustDecisionTaskTableException if a ttdpsp cust decision task table with the primary key could not be found
	*/
	public static TTDPSPCustDecisionTaskTable findByPrimaryKey(
		long TTDPSPCustDecisionTaskTableId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPCustDecisionTaskTableException {
		return getPersistence().findByPrimaryKey(TTDPSPCustDecisionTaskTableId);
	}

	/**
	* Returns the ttdpsp cust decision task table with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param TTDPSPCustDecisionTaskTableId the primary key of the ttdpsp cust decision task table
	* @return the ttdpsp cust decision task table, or <code>null</code> if a ttdpsp cust decision task table with the primary key could not be found
	*/
	public static TTDPSPCustDecisionTaskTable fetchByPrimaryKey(
		long TTDPSPCustDecisionTaskTableId) {
		return getPersistence().fetchByPrimaryKey(TTDPSPCustDecisionTaskTableId);
	}

	public static java.util.Map<java.io.Serializable, TTDPSPCustDecisionTaskTable> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the ttdpsp cust decision task tables.
	*
	* @return the ttdpsp cust decision task tables
	*/
	public static List<TTDPSPCustDecisionTaskTable> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ttdpsp cust decision task tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ttdpsp cust decision task tables
	* @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	* @return the range of ttdpsp cust decision task tables
	*/
	public static List<TTDPSPCustDecisionTaskTable> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ttdpsp cust decision task tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ttdpsp cust decision task tables
	* @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ttdpsp cust decision task tables
	*/
	public static List<TTDPSPCustDecisionTaskTable> findAll(int start, int end,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the ttdpsp cust decision task tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ttdpsp cust decision task tables
	* @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of ttdpsp cust decision task tables
	*/
	public static List<TTDPSPCustDecisionTaskTable> findAll(int start, int end,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the ttdpsp cust decision task tables from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ttdpsp cust decision task tables.
	*
	* @return the number of ttdpsp cust decision task tables
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static TTDPSPCustDecisionTaskTablePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TTDPSPCustDecisionTaskTablePersistence, TTDPSPCustDecisionTaskTablePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TTDPSPCustDecisionTaskTablePersistence.class);

		ServiceTracker<TTDPSPCustDecisionTaskTablePersistence, TTDPSPCustDecisionTaskTablePersistence> serviceTracker =
			new ServiceTracker<TTDPSPCustDecisionTaskTablePersistence, TTDPSPCustDecisionTaskTablePersistence>(bundle.getBundleContext(),
				TTDPSPCustDecisionTaskTablePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}