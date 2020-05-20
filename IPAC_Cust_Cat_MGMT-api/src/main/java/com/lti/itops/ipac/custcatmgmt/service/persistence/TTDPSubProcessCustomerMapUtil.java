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

import com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the ttdp sub process customer map service. This utility wraps {@link com.lti.itops.ipac.custcatmgmt.service.persistence.impl.TTDPSubProcessCustomerMapPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sunprabh
 * @see TTDPSubProcessCustomerMapPersistence
 * @see com.lti.itops.ipac.custcatmgmt.service.persistence.impl.TTDPSubProcessCustomerMapPersistenceImpl
 * @generated
 */
@ProviderType
public class TTDPSubProcessCustomerMapUtil {
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
		TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap) {
		getPersistence().clearCache(ttdpSubProcessCustomerMap);
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
	public static List<TTDPSubProcessCustomerMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TTDPSubProcessCustomerMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TTDPSubProcessCustomerMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TTDPSubProcessCustomerMap update(
		TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap) {
		return getPersistence().update(ttdpSubProcessCustomerMap);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TTDPSubProcessCustomerMap update(
		TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap,
		ServiceContext serviceContext) {
		return getPersistence().update(ttdpSubProcessCustomerMap, serviceContext);
	}

	/**
	* Returns all the ttdp sub process customer maps where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching ttdp sub process customer maps
	*/
	public static List<TTDPSubProcessCustomerMap> findByorganizationId(
		long organizationId) {
		return getPersistence().findByorganizationId(organizationId);
	}

	/**
	* Returns a range of all the ttdp sub process customer maps where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSubProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of ttdp sub process customer maps
	* @param end the upper bound of the range of ttdp sub process customer maps (not inclusive)
	* @return the range of matching ttdp sub process customer maps
	*/
	public static List<TTDPSubProcessCustomerMap> findByorganizationId(
		long organizationId, int start, int end) {
		return getPersistence().findByorganizationId(organizationId, start, end);
	}

	/**
	* Returns an ordered range of all the ttdp sub process customer maps where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSubProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of ttdp sub process customer maps
	* @param end the upper bound of the range of ttdp sub process customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ttdp sub process customer maps
	*/
	public static List<TTDPSubProcessCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator) {
		return getPersistence()
				   .findByorganizationId(organizationId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the ttdp sub process customer maps where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSubProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of ttdp sub process customer maps
	* @param end the upper bound of the range of ttdp sub process customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching ttdp sub process customer maps
	*/
	public static List<TTDPSubProcessCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByorganizationId(organizationId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first ttdp sub process customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ttdp sub process customer map
	* @throws NoSuchTTDPSubProcessCustomerMapException if a matching ttdp sub process customer map could not be found
	*/
	public static TTDPSubProcessCustomerMap findByorganizationId_First(
		long organizationId,
		OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSubProcessCustomerMapException {
		return getPersistence()
				   .findByorganizationId_First(organizationId, orderByComparator);
	}

	/**
	* Returns the first ttdp sub process customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ttdp sub process customer map, or <code>null</code> if a matching ttdp sub process customer map could not be found
	*/
	public static TTDPSubProcessCustomerMap fetchByorganizationId_First(
		long organizationId,
		OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator) {
		return getPersistence()
				   .fetchByorganizationId_First(organizationId,
			orderByComparator);
	}

	/**
	* Returns the last ttdp sub process customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ttdp sub process customer map
	* @throws NoSuchTTDPSubProcessCustomerMapException if a matching ttdp sub process customer map could not be found
	*/
	public static TTDPSubProcessCustomerMap findByorganizationId_Last(
		long organizationId,
		OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSubProcessCustomerMapException {
		return getPersistence()
				   .findByorganizationId_Last(organizationId, orderByComparator);
	}

	/**
	* Returns the last ttdp sub process customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ttdp sub process customer map, or <code>null</code> if a matching ttdp sub process customer map could not be found
	*/
	public static TTDPSubProcessCustomerMap fetchByorganizationId_Last(
		long organizationId,
		OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator) {
		return getPersistence()
				   .fetchByorganizationId_Last(organizationId, orderByComparator);
	}

	/**
	* Returns the ttdp sub process customer maps before and after the current ttdp sub process customer map in the ordered set where organizationId = &#63;.
	*
	* @param TTDPSubProcessCustomerId the primary key of the current ttdp sub process customer map
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ttdp sub process customer map
	* @throws NoSuchTTDPSubProcessCustomerMapException if a ttdp sub process customer map with the primary key could not be found
	*/
	public static TTDPSubProcessCustomerMap[] findByorganizationId_PrevAndNext(
		long TTDPSubProcessCustomerId, long organizationId,
		OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSubProcessCustomerMapException {
		return getPersistence()
				   .findByorganizationId_PrevAndNext(TTDPSubProcessCustomerId,
			organizationId, orderByComparator);
	}

	/**
	* Removes all the ttdp sub process customer maps where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	*/
	public static void removeByorganizationId(long organizationId) {
		getPersistence().removeByorganizationId(organizationId);
	}

	/**
	* Returns the number of ttdp sub process customer maps where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching ttdp sub process customer maps
	*/
	public static int countByorganizationId(long organizationId) {
		return getPersistence().countByorganizationId(organizationId);
	}

	/**
	* Returns the ttdp sub process customer map where TTDPSubProcessId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDPSubProcessCustomerMapException} if it could not be found.
	*
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param organizationId the organization ID
	* @return the matching ttdp sub process customer map
	* @throws NoSuchTTDPSubProcessCustomerMapException if a matching ttdp sub process customer map could not be found
	*/
	public static TTDPSubProcessCustomerMap findByTTDPSubProcessId(
		long TTDPSubProcessId, long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSubProcessCustomerMapException {
		return getPersistence()
				   .findByTTDPSubProcessId(TTDPSubProcessId, organizationId);
	}

	/**
	* Returns the ttdp sub process customer map where TTDPSubProcessId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param organizationId the organization ID
	* @return the matching ttdp sub process customer map, or <code>null</code> if a matching ttdp sub process customer map could not be found
	*/
	public static TTDPSubProcessCustomerMap fetchByTTDPSubProcessId(
		long TTDPSubProcessId, long organizationId) {
		return getPersistence()
				   .fetchByTTDPSubProcessId(TTDPSubProcessId, organizationId);
	}

	/**
	* Returns the ttdp sub process customer map where TTDPSubProcessId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching ttdp sub process customer map, or <code>null</code> if a matching ttdp sub process customer map could not be found
	*/
	public static TTDPSubProcessCustomerMap fetchByTTDPSubProcessId(
		long TTDPSubProcessId, long organizationId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByTTDPSubProcessId(TTDPSubProcessId, organizationId,
			retrieveFromCache);
	}

	/**
	* Removes the ttdp sub process customer map where TTDPSubProcessId = &#63; and organizationId = &#63; from the database.
	*
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param organizationId the organization ID
	* @return the ttdp sub process customer map that was removed
	*/
	public static TTDPSubProcessCustomerMap removeByTTDPSubProcessId(
		long TTDPSubProcessId, long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSubProcessCustomerMapException {
		return getPersistence()
				   .removeByTTDPSubProcessId(TTDPSubProcessId, organizationId);
	}

	/**
	* Returns the number of ttdp sub process customer maps where TTDPSubProcessId = &#63; and organizationId = &#63;.
	*
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param organizationId the organization ID
	* @return the number of matching ttdp sub process customer maps
	*/
	public static int countByTTDPSubProcessId(long TTDPSubProcessId,
		long organizationId) {
		return getPersistence()
				   .countByTTDPSubProcessId(TTDPSubProcessId, organizationId);
	}

	/**
	* Returns the ttdp sub process customer map where TTDPSubProcessCustomerId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDPSubProcessCustomerMapException} if it could not be found.
	*
	* @param TTDPSubProcessCustomerId the ttdp sub process customer ID
	* @param organizationId the organization ID
	* @return the matching ttdp sub process customer map
	* @throws NoSuchTTDPSubProcessCustomerMapException if a matching ttdp sub process customer map could not be found
	*/
	public static TTDPSubProcessCustomerMap findByTTDPSubProcessCustomerId(
		long TTDPSubProcessCustomerId, long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSubProcessCustomerMapException {
		return getPersistence()
				   .findByTTDPSubProcessCustomerId(TTDPSubProcessCustomerId,
			organizationId);
	}

	/**
	* Returns the ttdp sub process customer map where TTDPSubProcessCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param TTDPSubProcessCustomerId the ttdp sub process customer ID
	* @param organizationId the organization ID
	* @return the matching ttdp sub process customer map, or <code>null</code> if a matching ttdp sub process customer map could not be found
	*/
	public static TTDPSubProcessCustomerMap fetchByTTDPSubProcessCustomerId(
		long TTDPSubProcessCustomerId, long organizationId) {
		return getPersistence()
				   .fetchByTTDPSubProcessCustomerId(TTDPSubProcessCustomerId,
			organizationId);
	}

	/**
	* Returns the ttdp sub process customer map where TTDPSubProcessCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param TTDPSubProcessCustomerId the ttdp sub process customer ID
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching ttdp sub process customer map, or <code>null</code> if a matching ttdp sub process customer map could not be found
	*/
	public static TTDPSubProcessCustomerMap fetchByTTDPSubProcessCustomerId(
		long TTDPSubProcessCustomerId, long organizationId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByTTDPSubProcessCustomerId(TTDPSubProcessCustomerId,
			organizationId, retrieveFromCache);
	}

	/**
	* Removes the ttdp sub process customer map where TTDPSubProcessCustomerId = &#63; and organizationId = &#63; from the database.
	*
	* @param TTDPSubProcessCustomerId the ttdp sub process customer ID
	* @param organizationId the organization ID
	* @return the ttdp sub process customer map that was removed
	*/
	public static TTDPSubProcessCustomerMap removeByTTDPSubProcessCustomerId(
		long TTDPSubProcessCustomerId, long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSubProcessCustomerMapException {
		return getPersistence()
				   .removeByTTDPSubProcessCustomerId(TTDPSubProcessCustomerId,
			organizationId);
	}

	/**
	* Returns the number of ttdp sub process customer maps where TTDPSubProcessCustomerId = &#63; and organizationId = &#63;.
	*
	* @param TTDPSubProcessCustomerId the ttdp sub process customer ID
	* @param organizationId the organization ID
	* @return the number of matching ttdp sub process customer maps
	*/
	public static int countByTTDPSubProcessCustomerId(
		long TTDPSubProcessCustomerId, long organizationId) {
		return getPersistence()
				   .countByTTDPSubProcessCustomerId(TTDPSubProcessCustomerId,
			organizationId);
	}

	/**
	* Returns the ttdp sub process customer map where organizationId = &#63; and TTDPSubProcessId = &#63; and statusId = &#63; or throws a {@link NoSuchTTDPSubProcessCustomerMapException} if it could not be found.
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param statusId the status ID
	* @return the matching ttdp sub process customer map
	* @throws NoSuchTTDPSubProcessCustomerMapException if a matching ttdp sub process customer map could not be found
	*/
	public static TTDPSubProcessCustomerMap findBySubProcessCustomerMap(
		long organizationId, long TTDPSubProcessId, int statusId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSubProcessCustomerMapException {
		return getPersistence()
				   .findBySubProcessCustomerMap(organizationId,
			TTDPSubProcessId, statusId);
	}

	/**
	* Returns the ttdp sub process customer map where organizationId = &#63; and TTDPSubProcessId = &#63; and statusId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param statusId the status ID
	* @return the matching ttdp sub process customer map, or <code>null</code> if a matching ttdp sub process customer map could not be found
	*/
	public static TTDPSubProcessCustomerMap fetchBySubProcessCustomerMap(
		long organizationId, long TTDPSubProcessId, int statusId) {
		return getPersistence()
				   .fetchBySubProcessCustomerMap(organizationId,
			TTDPSubProcessId, statusId);
	}

	/**
	* Returns the ttdp sub process customer map where organizationId = &#63; and TTDPSubProcessId = &#63; and statusId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param statusId the status ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching ttdp sub process customer map, or <code>null</code> if a matching ttdp sub process customer map could not be found
	*/
	public static TTDPSubProcessCustomerMap fetchBySubProcessCustomerMap(
		long organizationId, long TTDPSubProcessId, int statusId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchBySubProcessCustomerMap(organizationId,
			TTDPSubProcessId, statusId, retrieveFromCache);
	}

	/**
	* Removes the ttdp sub process customer map where organizationId = &#63; and TTDPSubProcessId = &#63; and statusId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param statusId the status ID
	* @return the ttdp sub process customer map that was removed
	*/
	public static TTDPSubProcessCustomerMap removeBySubProcessCustomerMap(
		long organizationId, long TTDPSubProcessId, int statusId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSubProcessCustomerMapException {
		return getPersistence()
				   .removeBySubProcessCustomerMap(organizationId,
			TTDPSubProcessId, statusId);
	}

	/**
	* Returns the number of ttdp sub process customer maps where organizationId = &#63; and TTDPSubProcessId = &#63; and statusId = &#63;.
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param statusId the status ID
	* @return the number of matching ttdp sub process customer maps
	*/
	public static int countBySubProcessCustomerMap(long organizationId,
		long TTDPSubProcessId, int statusId) {
		return getPersistence()
				   .countBySubProcessCustomerMap(organizationId,
			TTDPSubProcessId, statusId);
	}

	/**
	* Caches the ttdp sub process customer map in the entity cache if it is enabled.
	*
	* @param ttdpSubProcessCustomerMap the ttdp sub process customer map
	*/
	public static void cacheResult(
		TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap) {
		getPersistence().cacheResult(ttdpSubProcessCustomerMap);
	}

	/**
	* Caches the ttdp sub process customer maps in the entity cache if it is enabled.
	*
	* @param ttdpSubProcessCustomerMaps the ttdp sub process customer maps
	*/
	public static void cacheResult(
		List<TTDPSubProcessCustomerMap> ttdpSubProcessCustomerMaps) {
		getPersistence().cacheResult(ttdpSubProcessCustomerMaps);
	}

	/**
	* Creates a new ttdp sub process customer map with the primary key. Does not add the ttdp sub process customer map to the database.
	*
	* @param TTDPSubProcessCustomerId the primary key for the new ttdp sub process customer map
	* @return the new ttdp sub process customer map
	*/
	public static TTDPSubProcessCustomerMap create(
		long TTDPSubProcessCustomerId) {
		return getPersistence().create(TTDPSubProcessCustomerId);
	}

	/**
	* Removes the ttdp sub process customer map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param TTDPSubProcessCustomerId the primary key of the ttdp sub process customer map
	* @return the ttdp sub process customer map that was removed
	* @throws NoSuchTTDPSubProcessCustomerMapException if a ttdp sub process customer map with the primary key could not be found
	*/
	public static TTDPSubProcessCustomerMap remove(
		long TTDPSubProcessCustomerId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSubProcessCustomerMapException {
		return getPersistence().remove(TTDPSubProcessCustomerId);
	}

	public static TTDPSubProcessCustomerMap updateImpl(
		TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap) {
		return getPersistence().updateImpl(ttdpSubProcessCustomerMap);
	}

	/**
	* Returns the ttdp sub process customer map with the primary key or throws a {@link NoSuchTTDPSubProcessCustomerMapException} if it could not be found.
	*
	* @param TTDPSubProcessCustomerId the primary key of the ttdp sub process customer map
	* @return the ttdp sub process customer map
	* @throws NoSuchTTDPSubProcessCustomerMapException if a ttdp sub process customer map with the primary key could not be found
	*/
	public static TTDPSubProcessCustomerMap findByPrimaryKey(
		long TTDPSubProcessCustomerId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSubProcessCustomerMapException {
		return getPersistence().findByPrimaryKey(TTDPSubProcessCustomerId);
	}

	/**
	* Returns the ttdp sub process customer map with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param TTDPSubProcessCustomerId the primary key of the ttdp sub process customer map
	* @return the ttdp sub process customer map, or <code>null</code> if a ttdp sub process customer map with the primary key could not be found
	*/
	public static TTDPSubProcessCustomerMap fetchByPrimaryKey(
		long TTDPSubProcessCustomerId) {
		return getPersistence().fetchByPrimaryKey(TTDPSubProcessCustomerId);
	}

	public static java.util.Map<java.io.Serializable, TTDPSubProcessCustomerMap> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the ttdp sub process customer maps.
	*
	* @return the ttdp sub process customer maps
	*/
	public static List<TTDPSubProcessCustomerMap> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ttdp sub process customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSubProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ttdp sub process customer maps
	* @param end the upper bound of the range of ttdp sub process customer maps (not inclusive)
	* @return the range of ttdp sub process customer maps
	*/
	public static List<TTDPSubProcessCustomerMap> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ttdp sub process customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSubProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ttdp sub process customer maps
	* @param end the upper bound of the range of ttdp sub process customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ttdp sub process customer maps
	*/
	public static List<TTDPSubProcessCustomerMap> findAll(int start, int end,
		OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the ttdp sub process customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSubProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ttdp sub process customer maps
	* @param end the upper bound of the range of ttdp sub process customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of ttdp sub process customer maps
	*/
	public static List<TTDPSubProcessCustomerMap> findAll(int start, int end,
		OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the ttdp sub process customer maps from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ttdp sub process customer maps.
	*
	* @return the number of ttdp sub process customer maps
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TTDPSubProcessCustomerMapPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TTDPSubProcessCustomerMapPersistence, TTDPSubProcessCustomerMapPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TTDPSubProcessCustomerMapPersistence.class);

		ServiceTracker<TTDPSubProcessCustomerMapPersistence, TTDPSubProcessCustomerMapPersistence> serviceTracker =
			new ServiceTracker<TTDPSubProcessCustomerMapPersistence, TTDPSubProcessCustomerMapPersistence>(bundle.getBundleContext(),
				TTDPSubProcessCustomerMapPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}