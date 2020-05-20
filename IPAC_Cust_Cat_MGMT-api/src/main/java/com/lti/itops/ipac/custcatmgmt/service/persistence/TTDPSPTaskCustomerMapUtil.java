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

import com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the ttdpsp task customer map service. This utility wraps {@link com.lti.itops.ipac.custcatmgmt.service.persistence.impl.TTDPSPTaskCustomerMapPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sunprabh
 * @see TTDPSPTaskCustomerMapPersistence
 * @see com.lti.itops.ipac.custcatmgmt.service.persistence.impl.TTDPSPTaskCustomerMapPersistenceImpl
 * @generated
 */
@ProviderType
public class TTDPSPTaskCustomerMapUtil {
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
	public static void clearCache(TTDPSPTaskCustomerMap ttdpspTaskCustomerMap) {
		getPersistence().clearCache(ttdpspTaskCustomerMap);
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
	public static List<TTDPSPTaskCustomerMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TTDPSPTaskCustomerMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TTDPSPTaskCustomerMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TTDPSPTaskCustomerMap update(
		TTDPSPTaskCustomerMap ttdpspTaskCustomerMap) {
		return getPersistence().update(ttdpspTaskCustomerMap);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TTDPSPTaskCustomerMap update(
		TTDPSPTaskCustomerMap ttdpspTaskCustomerMap,
		ServiceContext serviceContext) {
		return getPersistence().update(ttdpspTaskCustomerMap, serviceContext);
	}

	/**
	* Returns all the ttdpsp task customer maps where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching ttdpsp task customer maps
	*/
	public static List<TTDPSPTaskCustomerMap> findByorganizationId(
		long organizationId) {
		return getPersistence().findByorganizationId(organizationId);
	}

	/**
	* Returns a range of all the ttdpsp task customer maps where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of ttdpsp task customer maps
	* @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	* @return the range of matching ttdpsp task customer maps
	*/
	public static List<TTDPSPTaskCustomerMap> findByorganizationId(
		long organizationId, int start, int end) {
		return getPersistence().findByorganizationId(organizationId, start, end);
	}

	/**
	* Returns an ordered range of all the ttdpsp task customer maps where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of ttdpsp task customer maps
	* @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ttdpsp task customer maps
	*/
	public static List<TTDPSPTaskCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator) {
		return getPersistence()
				   .findByorganizationId(organizationId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the ttdpsp task customer maps where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of ttdpsp task customer maps
	* @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching ttdpsp task customer maps
	*/
	public static List<TTDPSPTaskCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByorganizationId(organizationId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first ttdpsp task customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ttdpsp task customer map
	* @throws NoSuchTTDPSPTaskCustomerMapException if a matching ttdpsp task customer map could not be found
	*/
	public static TTDPSPTaskCustomerMap findByorganizationId_First(
		long organizationId,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPTaskCustomerMapException {
		return getPersistence()
				   .findByorganizationId_First(organizationId, orderByComparator);
	}

	/**
	* Returns the first ttdpsp task customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	*/
	public static TTDPSPTaskCustomerMap fetchByorganizationId_First(
		long organizationId,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator) {
		return getPersistence()
				   .fetchByorganizationId_First(organizationId,
			orderByComparator);
	}

	/**
	* Returns the last ttdpsp task customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ttdpsp task customer map
	* @throws NoSuchTTDPSPTaskCustomerMapException if a matching ttdpsp task customer map could not be found
	*/
	public static TTDPSPTaskCustomerMap findByorganizationId_Last(
		long organizationId,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPTaskCustomerMapException {
		return getPersistence()
				   .findByorganizationId_Last(organizationId, orderByComparator);
	}

	/**
	* Returns the last ttdpsp task customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	*/
	public static TTDPSPTaskCustomerMap fetchByorganizationId_Last(
		long organizationId,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator) {
		return getPersistence()
				   .fetchByorganizationId_Last(organizationId, orderByComparator);
	}

	/**
	* Returns the ttdpsp task customer maps before and after the current ttdpsp task customer map in the ordered set where organizationId = &#63;.
	*
	* @param TTDPSPTaskCustomerId the primary key of the current ttdpsp task customer map
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ttdpsp task customer map
	* @throws NoSuchTTDPSPTaskCustomerMapException if a ttdpsp task customer map with the primary key could not be found
	*/
	public static TTDPSPTaskCustomerMap[] findByorganizationId_PrevAndNext(
		long TTDPSPTaskCustomerId, long organizationId,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPTaskCustomerMapException {
		return getPersistence()
				   .findByorganizationId_PrevAndNext(TTDPSPTaskCustomerId,
			organizationId, orderByComparator);
	}

	/**
	* Removes all the ttdpsp task customer maps where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	*/
	public static void removeByorganizationId(long organizationId) {
		getPersistence().removeByorganizationId(organizationId);
	}

	/**
	* Returns the number of ttdpsp task customer maps where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching ttdpsp task customer maps
	*/
	public static int countByorganizationId(long organizationId) {
		return getPersistence().countByorganizationId(organizationId);
	}

	/**
	* Returns the ttdpsp task customer map where taskId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDPSPTaskCustomerMapException} if it could not be found.
	*
	* @param taskId the task ID
	* @param organizationId the organization ID
	* @return the matching ttdpsp task customer map
	* @throws NoSuchTTDPSPTaskCustomerMapException if a matching ttdpsp task customer map could not be found
	*/
	public static TTDPSPTaskCustomerMap findBytaskId(long taskId,
		long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPTaskCustomerMapException {
		return getPersistence().findBytaskId(taskId, organizationId);
	}

	/**
	* Returns the ttdpsp task customer map where taskId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param taskId the task ID
	* @param organizationId the organization ID
	* @return the matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	*/
	public static TTDPSPTaskCustomerMap fetchBytaskId(long taskId,
		long organizationId) {
		return getPersistence().fetchBytaskId(taskId, organizationId);
	}

	/**
	* Returns the ttdpsp task customer map where taskId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param taskId the task ID
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	*/
	public static TTDPSPTaskCustomerMap fetchBytaskId(long taskId,
		long organizationId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchBytaskId(taskId, organizationId, retrieveFromCache);
	}

	/**
	* Removes the ttdpsp task customer map where taskId = &#63; and organizationId = &#63; from the database.
	*
	* @param taskId the task ID
	* @param organizationId the organization ID
	* @return the ttdpsp task customer map that was removed
	*/
	public static TTDPSPTaskCustomerMap removeBytaskId(long taskId,
		long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPTaskCustomerMapException {
		return getPersistence().removeBytaskId(taskId, organizationId);
	}

	/**
	* Returns the number of ttdpsp task customer maps where taskId = &#63; and organizationId = &#63;.
	*
	* @param taskId the task ID
	* @param organizationId the organization ID
	* @return the number of matching ttdpsp task customer maps
	*/
	public static int countBytaskId(long taskId, long organizationId) {
		return getPersistence().countBytaskId(taskId, organizationId);
	}

	/**
	* Returns the ttdpsp task customer map where TTDPSPTaskCustomerId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDPSPTaskCustomerMapException} if it could not be found.
	*
	* @param TTDPSPTaskCustomerId the ttdpsp task customer ID
	* @param organizationId the organization ID
	* @return the matching ttdpsp task customer map
	* @throws NoSuchTTDPSPTaskCustomerMapException if a matching ttdpsp task customer map could not be found
	*/
	public static TTDPSPTaskCustomerMap findByTTDPSPTaskCustomerId(
		long TTDPSPTaskCustomerId, long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPTaskCustomerMapException {
		return getPersistence()
				   .findByTTDPSPTaskCustomerId(TTDPSPTaskCustomerId,
			organizationId);
	}

	/**
	* Returns the ttdpsp task customer map where TTDPSPTaskCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param TTDPSPTaskCustomerId the ttdpsp task customer ID
	* @param organizationId the organization ID
	* @return the matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	*/
	public static TTDPSPTaskCustomerMap fetchByTTDPSPTaskCustomerId(
		long TTDPSPTaskCustomerId, long organizationId) {
		return getPersistence()
				   .fetchByTTDPSPTaskCustomerId(TTDPSPTaskCustomerId,
			organizationId);
	}

	/**
	* Returns the ttdpsp task customer map where TTDPSPTaskCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param TTDPSPTaskCustomerId the ttdpsp task customer ID
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	*/
	public static TTDPSPTaskCustomerMap fetchByTTDPSPTaskCustomerId(
		long TTDPSPTaskCustomerId, long organizationId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByTTDPSPTaskCustomerId(TTDPSPTaskCustomerId,
			organizationId, retrieveFromCache);
	}

	/**
	* Removes the ttdpsp task customer map where TTDPSPTaskCustomerId = &#63; and organizationId = &#63; from the database.
	*
	* @param TTDPSPTaskCustomerId the ttdpsp task customer ID
	* @param organizationId the organization ID
	* @return the ttdpsp task customer map that was removed
	*/
	public static TTDPSPTaskCustomerMap removeByTTDPSPTaskCustomerId(
		long TTDPSPTaskCustomerId, long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPTaskCustomerMapException {
		return getPersistence()
				   .removeByTTDPSPTaskCustomerId(TTDPSPTaskCustomerId,
			organizationId);
	}

	/**
	* Returns the number of ttdpsp task customer maps where TTDPSPTaskCustomerId = &#63; and organizationId = &#63;.
	*
	* @param TTDPSPTaskCustomerId the ttdpsp task customer ID
	* @param organizationId the organization ID
	* @return the number of matching ttdpsp task customer maps
	*/
	public static int countByTTDPSPTaskCustomerId(long TTDPSPTaskCustomerId,
		long organizationId) {
		return getPersistence()
				   .countByTTDPSPTaskCustomerId(TTDPSPTaskCustomerId,
			organizationId);
	}

	/**
	* Returns all the ttdpsp task customer maps where organizationId = &#63; and TTDPSubProcessId = &#63;.
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @return the matching ttdpsp task customer maps
	*/
	public static List<TTDPSPTaskCustomerMap> findByorgSubProcessId(
		long organizationId, long TTDPSubProcessId) {
		return getPersistence()
				   .findByorgSubProcessId(organizationId, TTDPSubProcessId);
	}

	/**
	* Returns a range of all the ttdpsp task customer maps where organizationId = &#63; and TTDPSubProcessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param start the lower bound of the range of ttdpsp task customer maps
	* @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	* @return the range of matching ttdpsp task customer maps
	*/
	public static List<TTDPSPTaskCustomerMap> findByorgSubProcessId(
		long organizationId, long TTDPSubProcessId, int start, int end) {
		return getPersistence()
				   .findByorgSubProcessId(organizationId, TTDPSubProcessId,
			start, end);
	}

	/**
	* Returns an ordered range of all the ttdpsp task customer maps where organizationId = &#63; and TTDPSubProcessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param start the lower bound of the range of ttdpsp task customer maps
	* @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ttdpsp task customer maps
	*/
	public static List<TTDPSPTaskCustomerMap> findByorgSubProcessId(
		long organizationId, long TTDPSubProcessId, int start, int end,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator) {
		return getPersistence()
				   .findByorgSubProcessId(organizationId, TTDPSubProcessId,
			start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the ttdpsp task customer maps where organizationId = &#63; and TTDPSubProcessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param start the lower bound of the range of ttdpsp task customer maps
	* @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching ttdpsp task customer maps
	*/
	public static List<TTDPSPTaskCustomerMap> findByorgSubProcessId(
		long organizationId, long TTDPSubProcessId, int start, int end,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByorgSubProcessId(organizationId, TTDPSubProcessId,
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first ttdpsp task customer map in the ordered set where organizationId = &#63; and TTDPSubProcessId = &#63;.
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ttdpsp task customer map
	* @throws NoSuchTTDPSPTaskCustomerMapException if a matching ttdpsp task customer map could not be found
	*/
	public static TTDPSPTaskCustomerMap findByorgSubProcessId_First(
		long organizationId, long TTDPSubProcessId,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPTaskCustomerMapException {
		return getPersistence()
				   .findByorgSubProcessId_First(organizationId,
			TTDPSubProcessId, orderByComparator);
	}

	/**
	* Returns the first ttdpsp task customer map in the ordered set where organizationId = &#63; and TTDPSubProcessId = &#63;.
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	*/
	public static TTDPSPTaskCustomerMap fetchByorgSubProcessId_First(
		long organizationId, long TTDPSubProcessId,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator) {
		return getPersistence()
				   .fetchByorgSubProcessId_First(organizationId,
			TTDPSubProcessId, orderByComparator);
	}

	/**
	* Returns the last ttdpsp task customer map in the ordered set where organizationId = &#63; and TTDPSubProcessId = &#63;.
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ttdpsp task customer map
	* @throws NoSuchTTDPSPTaskCustomerMapException if a matching ttdpsp task customer map could not be found
	*/
	public static TTDPSPTaskCustomerMap findByorgSubProcessId_Last(
		long organizationId, long TTDPSubProcessId,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPTaskCustomerMapException {
		return getPersistence()
				   .findByorgSubProcessId_Last(organizationId,
			TTDPSubProcessId, orderByComparator);
	}

	/**
	* Returns the last ttdpsp task customer map in the ordered set where organizationId = &#63; and TTDPSubProcessId = &#63;.
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	*/
	public static TTDPSPTaskCustomerMap fetchByorgSubProcessId_Last(
		long organizationId, long TTDPSubProcessId,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator) {
		return getPersistence()
				   .fetchByorgSubProcessId_Last(organizationId,
			TTDPSubProcessId, orderByComparator);
	}

	/**
	* Returns the ttdpsp task customer maps before and after the current ttdpsp task customer map in the ordered set where organizationId = &#63; and TTDPSubProcessId = &#63;.
	*
	* @param TTDPSPTaskCustomerId the primary key of the current ttdpsp task customer map
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ttdpsp task customer map
	* @throws NoSuchTTDPSPTaskCustomerMapException if a ttdpsp task customer map with the primary key could not be found
	*/
	public static TTDPSPTaskCustomerMap[] findByorgSubProcessId_PrevAndNext(
		long TTDPSPTaskCustomerId, long organizationId, long TTDPSubProcessId,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPTaskCustomerMapException {
		return getPersistence()
				   .findByorgSubProcessId_PrevAndNext(TTDPSPTaskCustomerId,
			organizationId, TTDPSubProcessId, orderByComparator);
	}

	/**
	* Removes all the ttdpsp task customer maps where organizationId = &#63; and TTDPSubProcessId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	*/
	public static void removeByorgSubProcessId(long organizationId,
		long TTDPSubProcessId) {
		getPersistence()
			.removeByorgSubProcessId(organizationId, TTDPSubProcessId);
	}

	/**
	* Returns the number of ttdpsp task customer maps where organizationId = &#63; and TTDPSubProcessId = &#63;.
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @return the number of matching ttdpsp task customer maps
	*/
	public static int countByorgSubProcessId(long organizationId,
		long TTDPSubProcessId) {
		return getPersistence()
				   .countByorgSubProcessId(organizationId, TTDPSubProcessId);
	}

	/**
	* Returns the ttdpsp task customer map where TTDPSubProcessId = &#63; and taskId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDPSPTaskCustomerMapException} if it could not be found.
	*
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param taskId the task ID
	* @param organizationId the organization ID
	* @return the matching ttdpsp task customer map
	* @throws NoSuchTTDPSPTaskCustomerMapException if a matching ttdpsp task customer map could not be found
	*/
	public static TTDPSPTaskCustomerMap findByTTDPSPTaskCustomerMapBy(
		long TTDPSubProcessId, long taskId, long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPTaskCustomerMapException {
		return getPersistence()
				   .findByTTDPSPTaskCustomerMapBy(TTDPSubProcessId, taskId,
			organizationId);
	}

	/**
	* Returns the ttdpsp task customer map where TTDPSubProcessId = &#63; and taskId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param taskId the task ID
	* @param organizationId the organization ID
	* @return the matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	*/
	public static TTDPSPTaskCustomerMap fetchByTTDPSPTaskCustomerMapBy(
		long TTDPSubProcessId, long taskId, long organizationId) {
		return getPersistence()
				   .fetchByTTDPSPTaskCustomerMapBy(TTDPSubProcessId, taskId,
			organizationId);
	}

	/**
	* Returns the ttdpsp task customer map where TTDPSubProcessId = &#63; and taskId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param taskId the task ID
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	*/
	public static TTDPSPTaskCustomerMap fetchByTTDPSPTaskCustomerMapBy(
		long TTDPSubProcessId, long taskId, long organizationId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByTTDPSPTaskCustomerMapBy(TTDPSubProcessId, taskId,
			organizationId, retrieveFromCache);
	}

	/**
	* Removes the ttdpsp task customer map where TTDPSubProcessId = &#63; and taskId = &#63; and organizationId = &#63; from the database.
	*
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param taskId the task ID
	* @param organizationId the organization ID
	* @return the ttdpsp task customer map that was removed
	*/
	public static TTDPSPTaskCustomerMap removeByTTDPSPTaskCustomerMapBy(
		long TTDPSubProcessId, long taskId, long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPTaskCustomerMapException {
		return getPersistence()
				   .removeByTTDPSPTaskCustomerMapBy(TTDPSubProcessId, taskId,
			organizationId);
	}

	/**
	* Returns the number of ttdpsp task customer maps where TTDPSubProcessId = &#63; and taskId = &#63; and organizationId = &#63;.
	*
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param taskId the task ID
	* @param organizationId the organization ID
	* @return the number of matching ttdpsp task customer maps
	*/
	public static int countByTTDPSPTaskCustomerMapBy(long TTDPSubProcessId,
		long taskId, long organizationId) {
		return getPersistence()
				   .countByTTDPSPTaskCustomerMapBy(TTDPSubProcessId, taskId,
			organizationId);
	}

	/**
	* Caches the ttdpsp task customer map in the entity cache if it is enabled.
	*
	* @param ttdpspTaskCustomerMap the ttdpsp task customer map
	*/
	public static void cacheResult(TTDPSPTaskCustomerMap ttdpspTaskCustomerMap) {
		getPersistence().cacheResult(ttdpspTaskCustomerMap);
	}

	/**
	* Caches the ttdpsp task customer maps in the entity cache if it is enabled.
	*
	* @param ttdpspTaskCustomerMaps the ttdpsp task customer maps
	*/
	public static void cacheResult(
		List<TTDPSPTaskCustomerMap> ttdpspTaskCustomerMaps) {
		getPersistence().cacheResult(ttdpspTaskCustomerMaps);
	}

	/**
	* Creates a new ttdpsp task customer map with the primary key. Does not add the ttdpsp task customer map to the database.
	*
	* @param TTDPSPTaskCustomerId the primary key for the new ttdpsp task customer map
	* @return the new ttdpsp task customer map
	*/
	public static TTDPSPTaskCustomerMap create(long TTDPSPTaskCustomerId) {
		return getPersistence().create(TTDPSPTaskCustomerId);
	}

	/**
	* Removes the ttdpsp task customer map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param TTDPSPTaskCustomerId the primary key of the ttdpsp task customer map
	* @return the ttdpsp task customer map that was removed
	* @throws NoSuchTTDPSPTaskCustomerMapException if a ttdpsp task customer map with the primary key could not be found
	*/
	public static TTDPSPTaskCustomerMap remove(long TTDPSPTaskCustomerId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPTaskCustomerMapException {
		return getPersistence().remove(TTDPSPTaskCustomerId);
	}

	public static TTDPSPTaskCustomerMap updateImpl(
		TTDPSPTaskCustomerMap ttdpspTaskCustomerMap) {
		return getPersistence().updateImpl(ttdpspTaskCustomerMap);
	}

	/**
	* Returns the ttdpsp task customer map with the primary key or throws a {@link NoSuchTTDPSPTaskCustomerMapException} if it could not be found.
	*
	* @param TTDPSPTaskCustomerId the primary key of the ttdpsp task customer map
	* @return the ttdpsp task customer map
	* @throws NoSuchTTDPSPTaskCustomerMapException if a ttdpsp task customer map with the primary key could not be found
	*/
	public static TTDPSPTaskCustomerMap findByPrimaryKey(
		long TTDPSPTaskCustomerId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPTaskCustomerMapException {
		return getPersistence().findByPrimaryKey(TTDPSPTaskCustomerId);
	}

	/**
	* Returns the ttdpsp task customer map with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param TTDPSPTaskCustomerId the primary key of the ttdpsp task customer map
	* @return the ttdpsp task customer map, or <code>null</code> if a ttdpsp task customer map with the primary key could not be found
	*/
	public static TTDPSPTaskCustomerMap fetchByPrimaryKey(
		long TTDPSPTaskCustomerId) {
		return getPersistence().fetchByPrimaryKey(TTDPSPTaskCustomerId);
	}

	public static java.util.Map<java.io.Serializable, TTDPSPTaskCustomerMap> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the ttdpsp task customer maps.
	*
	* @return the ttdpsp task customer maps
	*/
	public static List<TTDPSPTaskCustomerMap> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ttdpsp task customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ttdpsp task customer maps
	* @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	* @return the range of ttdpsp task customer maps
	*/
	public static List<TTDPSPTaskCustomerMap> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ttdpsp task customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ttdpsp task customer maps
	* @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ttdpsp task customer maps
	*/
	public static List<TTDPSPTaskCustomerMap> findAll(int start, int end,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the ttdpsp task customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ttdpsp task customer maps
	* @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of ttdpsp task customer maps
	*/
	public static List<TTDPSPTaskCustomerMap> findAll(int start, int end,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the ttdpsp task customer maps from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ttdpsp task customer maps.
	*
	* @return the number of ttdpsp task customer maps
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TTDPSPTaskCustomerMapPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TTDPSPTaskCustomerMapPersistence, TTDPSPTaskCustomerMapPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TTDPSPTaskCustomerMapPersistence.class);

		ServiceTracker<TTDPSPTaskCustomerMapPersistence, TTDPSPTaskCustomerMapPersistence> serviceTracker =
			new ServiceTracker<TTDPSPTaskCustomerMapPersistence, TTDPSPTaskCustomerMapPersistence>(bundle.getBundleContext(),
				TTDPSPTaskCustomerMapPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}