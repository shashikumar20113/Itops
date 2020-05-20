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

import com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the ttd process customer map service. This utility wraps {@link com.lti.itops.ipac.custcatmgmt.service.persistence.impl.TTDProcessCustomerMapPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sunprabh
 * @see TTDProcessCustomerMapPersistence
 * @see com.lti.itops.ipac.custcatmgmt.service.persistence.impl.TTDProcessCustomerMapPersistenceImpl
 * @generated
 */
@ProviderType
public class TTDProcessCustomerMapUtil {
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
	public static void clearCache(TTDProcessCustomerMap ttdProcessCustomerMap) {
		getPersistence().clearCache(ttdProcessCustomerMap);
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
	public static List<TTDProcessCustomerMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TTDProcessCustomerMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TTDProcessCustomerMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TTDProcessCustomerMap> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TTDProcessCustomerMap update(
		TTDProcessCustomerMap ttdProcessCustomerMap) {
		return getPersistence().update(ttdProcessCustomerMap);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TTDProcessCustomerMap update(
		TTDProcessCustomerMap ttdProcessCustomerMap,
		ServiceContext serviceContext) {
		return getPersistence().update(ttdProcessCustomerMap, serviceContext);
	}

	/**
	* Returns all the ttd process customer maps where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching ttd process customer maps
	*/
	public static List<TTDProcessCustomerMap> findByorganizationId(
		long organizationId) {
		return getPersistence().findByorganizationId(organizationId);
	}

	/**
	* Returns a range of all the ttd process customer maps where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of ttd process customer maps
	* @param end the upper bound of the range of ttd process customer maps (not inclusive)
	* @return the range of matching ttd process customer maps
	*/
	public static List<TTDProcessCustomerMap> findByorganizationId(
		long organizationId, int start, int end) {
		return getPersistence().findByorganizationId(organizationId, start, end);
	}

	/**
	* Returns an ordered range of all the ttd process customer maps where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of ttd process customer maps
	* @param end the upper bound of the range of ttd process customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ttd process customer maps
	*/
	public static List<TTDProcessCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<TTDProcessCustomerMap> orderByComparator) {
		return getPersistence()
				   .findByorganizationId(organizationId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the ttd process customer maps where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of ttd process customer maps
	* @param end the upper bound of the range of ttd process customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching ttd process customer maps
	*/
	public static List<TTDProcessCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<TTDProcessCustomerMap> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByorganizationId(organizationId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first ttd process customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ttd process customer map
	* @throws NoSuchTTDProcessCustomerMapException if a matching ttd process customer map could not be found
	*/
	public static TTDProcessCustomerMap findByorganizationId_First(
		long organizationId,
		OrderByComparator<TTDProcessCustomerMap> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDProcessCustomerMapException {
		return getPersistence()
				   .findByorganizationId_First(organizationId, orderByComparator);
	}

	/**
	* Returns the first ttd process customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ttd process customer map, or <code>null</code> if a matching ttd process customer map could not be found
	*/
	public static TTDProcessCustomerMap fetchByorganizationId_First(
		long organizationId,
		OrderByComparator<TTDProcessCustomerMap> orderByComparator) {
		return getPersistence()
				   .fetchByorganizationId_First(organizationId,
			orderByComparator);
	}

	/**
	* Returns the last ttd process customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ttd process customer map
	* @throws NoSuchTTDProcessCustomerMapException if a matching ttd process customer map could not be found
	*/
	public static TTDProcessCustomerMap findByorganizationId_Last(
		long organizationId,
		OrderByComparator<TTDProcessCustomerMap> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDProcessCustomerMapException {
		return getPersistence()
				   .findByorganizationId_Last(organizationId, orderByComparator);
	}

	/**
	* Returns the last ttd process customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ttd process customer map, or <code>null</code> if a matching ttd process customer map could not be found
	*/
	public static TTDProcessCustomerMap fetchByorganizationId_Last(
		long organizationId,
		OrderByComparator<TTDProcessCustomerMap> orderByComparator) {
		return getPersistence()
				   .fetchByorganizationId_Last(organizationId, orderByComparator);
	}

	/**
	* Returns the ttd process customer maps before and after the current ttd process customer map in the ordered set where organizationId = &#63;.
	*
	* @param TTDProcessCustomerId the primary key of the current ttd process customer map
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ttd process customer map
	* @throws NoSuchTTDProcessCustomerMapException if a ttd process customer map with the primary key could not be found
	*/
	public static TTDProcessCustomerMap[] findByorganizationId_PrevAndNext(
		long TTDProcessCustomerId, long organizationId,
		OrderByComparator<TTDProcessCustomerMap> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDProcessCustomerMapException {
		return getPersistence()
				   .findByorganizationId_PrevAndNext(TTDProcessCustomerId,
			organizationId, orderByComparator);
	}

	/**
	* Removes all the ttd process customer maps where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	*/
	public static void removeByorganizationId(long organizationId) {
		getPersistence().removeByorganizationId(organizationId);
	}

	/**
	* Returns the number of ttd process customer maps where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching ttd process customer maps
	*/
	public static int countByorganizationId(long organizationId) {
		return getPersistence().countByorganizationId(organizationId);
	}

	/**
	* Returns the ttd process customer map where TTDProcessId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDProcessCustomerMapException} if it could not be found.
	*
	* @param TTDProcessId the ttd process ID
	* @param organizationId the organization ID
	* @return the matching ttd process customer map
	* @throws NoSuchTTDProcessCustomerMapException if a matching ttd process customer map could not be found
	*/
	public static TTDProcessCustomerMap findByTTDProcessId(long TTDProcessId,
		long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDProcessCustomerMapException {
		return getPersistence().findByTTDProcessId(TTDProcessId, organizationId);
	}

	/**
	* Returns the ttd process customer map where TTDProcessId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param TTDProcessId the ttd process ID
	* @param organizationId the organization ID
	* @return the matching ttd process customer map, or <code>null</code> if a matching ttd process customer map could not be found
	*/
	public static TTDProcessCustomerMap fetchByTTDProcessId(long TTDProcessId,
		long organizationId) {
		return getPersistence().fetchByTTDProcessId(TTDProcessId, organizationId);
	}

	/**
	* Returns the ttd process customer map where TTDProcessId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param TTDProcessId the ttd process ID
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching ttd process customer map, or <code>null</code> if a matching ttd process customer map could not be found
	*/
	public static TTDProcessCustomerMap fetchByTTDProcessId(long TTDProcessId,
		long organizationId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByTTDProcessId(TTDProcessId, organizationId,
			retrieveFromCache);
	}

	/**
	* Removes the ttd process customer map where TTDProcessId = &#63; and organizationId = &#63; from the database.
	*
	* @param TTDProcessId the ttd process ID
	* @param organizationId the organization ID
	* @return the ttd process customer map that was removed
	*/
	public static TTDProcessCustomerMap removeByTTDProcessId(
		long TTDProcessId, long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDProcessCustomerMapException {
		return getPersistence()
				   .removeByTTDProcessId(TTDProcessId, organizationId);
	}

	/**
	* Returns the number of ttd process customer maps where TTDProcessId = &#63; and organizationId = &#63;.
	*
	* @param TTDProcessId the ttd process ID
	* @param organizationId the organization ID
	* @return the number of matching ttd process customer maps
	*/
	public static int countByTTDProcessId(long TTDProcessId, long organizationId) {
		return getPersistence().countByTTDProcessId(TTDProcessId, organizationId);
	}

	/**
	* Returns the ttd process customer map where TTDProcessCustomerId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDProcessCustomerMapException} if it could not be found.
	*
	* @param TTDProcessCustomerId the ttd process customer ID
	* @param organizationId the organization ID
	* @return the matching ttd process customer map
	* @throws NoSuchTTDProcessCustomerMapException if a matching ttd process customer map could not be found
	*/
	public static TTDProcessCustomerMap findByTTDProcessCustomerId(
		long TTDProcessCustomerId, long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDProcessCustomerMapException {
		return getPersistence()
				   .findByTTDProcessCustomerId(TTDProcessCustomerId,
			organizationId);
	}

	/**
	* Returns the ttd process customer map where TTDProcessCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param TTDProcessCustomerId the ttd process customer ID
	* @param organizationId the organization ID
	* @return the matching ttd process customer map, or <code>null</code> if a matching ttd process customer map could not be found
	*/
	public static TTDProcessCustomerMap fetchByTTDProcessCustomerId(
		long TTDProcessCustomerId, long organizationId) {
		return getPersistence()
				   .fetchByTTDProcessCustomerId(TTDProcessCustomerId,
			organizationId);
	}

	/**
	* Returns the ttd process customer map where TTDProcessCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param TTDProcessCustomerId the ttd process customer ID
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching ttd process customer map, or <code>null</code> if a matching ttd process customer map could not be found
	*/
	public static TTDProcessCustomerMap fetchByTTDProcessCustomerId(
		long TTDProcessCustomerId, long organizationId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByTTDProcessCustomerId(TTDProcessCustomerId,
			organizationId, retrieveFromCache);
	}

	/**
	* Removes the ttd process customer map where TTDProcessCustomerId = &#63; and organizationId = &#63; from the database.
	*
	* @param TTDProcessCustomerId the ttd process customer ID
	* @param organizationId the organization ID
	* @return the ttd process customer map that was removed
	*/
	public static TTDProcessCustomerMap removeByTTDProcessCustomerId(
		long TTDProcessCustomerId, long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDProcessCustomerMapException {
		return getPersistence()
				   .removeByTTDProcessCustomerId(TTDProcessCustomerId,
			organizationId);
	}

	/**
	* Returns the number of ttd process customer maps where TTDProcessCustomerId = &#63; and organizationId = &#63;.
	*
	* @param TTDProcessCustomerId the ttd process customer ID
	* @param organizationId the organization ID
	* @return the number of matching ttd process customer maps
	*/
	public static int countByTTDProcessCustomerId(long TTDProcessCustomerId,
		long organizationId) {
		return getPersistence()
				   .countByTTDProcessCustomerId(TTDProcessCustomerId,
			organizationId);
	}

	/**
	* Returns the ttd process customer map where organizationId = &#63; and TTDProcessId = &#63; and statusId = &#63; or throws a {@link NoSuchTTDProcessCustomerMapException} if it could not be found.
	*
	* @param organizationId the organization ID
	* @param TTDProcessId the ttd process ID
	* @param statusId the status ID
	* @return the matching ttd process customer map
	* @throws NoSuchTTDProcessCustomerMapException if a matching ttd process customer map could not be found
	*/
	public static TTDProcessCustomerMap findByProcessCustomerMap(
		long organizationId, long TTDProcessId, int statusId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDProcessCustomerMapException {
		return getPersistence()
				   .findByProcessCustomerMap(organizationId, TTDProcessId,
			statusId);
	}

	/**
	* Returns the ttd process customer map where organizationId = &#63; and TTDProcessId = &#63; and statusId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param organizationId the organization ID
	* @param TTDProcessId the ttd process ID
	* @param statusId the status ID
	* @return the matching ttd process customer map, or <code>null</code> if a matching ttd process customer map could not be found
	*/
	public static TTDProcessCustomerMap fetchByProcessCustomerMap(
		long organizationId, long TTDProcessId, int statusId) {
		return getPersistence()
				   .fetchByProcessCustomerMap(organizationId, TTDProcessId,
			statusId);
	}

	/**
	* Returns the ttd process customer map where organizationId = &#63; and TTDProcessId = &#63; and statusId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param organizationId the organization ID
	* @param TTDProcessId the ttd process ID
	* @param statusId the status ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching ttd process customer map, or <code>null</code> if a matching ttd process customer map could not be found
	*/
	public static TTDProcessCustomerMap fetchByProcessCustomerMap(
		long organizationId, long TTDProcessId, int statusId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByProcessCustomerMap(organizationId, TTDProcessId,
			statusId, retrieveFromCache);
	}

	/**
	* Removes the ttd process customer map where organizationId = &#63; and TTDProcessId = &#63; and statusId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @param TTDProcessId the ttd process ID
	* @param statusId the status ID
	* @return the ttd process customer map that was removed
	*/
	public static TTDProcessCustomerMap removeByProcessCustomerMap(
		long organizationId, long TTDProcessId, int statusId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDProcessCustomerMapException {
		return getPersistence()
				   .removeByProcessCustomerMap(organizationId, TTDProcessId,
			statusId);
	}

	/**
	* Returns the number of ttd process customer maps where organizationId = &#63; and TTDProcessId = &#63; and statusId = &#63;.
	*
	* @param organizationId the organization ID
	* @param TTDProcessId the ttd process ID
	* @param statusId the status ID
	* @return the number of matching ttd process customer maps
	*/
	public static int countByProcessCustomerMap(long organizationId,
		long TTDProcessId, int statusId) {
		return getPersistence()
				   .countByProcessCustomerMap(organizationId, TTDProcessId,
			statusId);
	}

	/**
	* Caches the ttd process customer map in the entity cache if it is enabled.
	*
	* @param ttdProcessCustomerMap the ttd process customer map
	*/
	public static void cacheResult(TTDProcessCustomerMap ttdProcessCustomerMap) {
		getPersistence().cacheResult(ttdProcessCustomerMap);
	}

	/**
	* Caches the ttd process customer maps in the entity cache if it is enabled.
	*
	* @param ttdProcessCustomerMaps the ttd process customer maps
	*/
	public static void cacheResult(
		List<TTDProcessCustomerMap> ttdProcessCustomerMaps) {
		getPersistence().cacheResult(ttdProcessCustomerMaps);
	}

	/**
	* Creates a new ttd process customer map with the primary key. Does not add the ttd process customer map to the database.
	*
	* @param TTDProcessCustomerId the primary key for the new ttd process customer map
	* @return the new ttd process customer map
	*/
	public static TTDProcessCustomerMap create(long TTDProcessCustomerId) {
		return getPersistence().create(TTDProcessCustomerId);
	}

	/**
	* Removes the ttd process customer map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param TTDProcessCustomerId the primary key of the ttd process customer map
	* @return the ttd process customer map that was removed
	* @throws NoSuchTTDProcessCustomerMapException if a ttd process customer map with the primary key could not be found
	*/
	public static TTDProcessCustomerMap remove(long TTDProcessCustomerId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDProcessCustomerMapException {
		return getPersistence().remove(TTDProcessCustomerId);
	}

	public static TTDProcessCustomerMap updateImpl(
		TTDProcessCustomerMap ttdProcessCustomerMap) {
		return getPersistence().updateImpl(ttdProcessCustomerMap);
	}

	/**
	* Returns the ttd process customer map with the primary key or throws a {@link NoSuchTTDProcessCustomerMapException} if it could not be found.
	*
	* @param TTDProcessCustomerId the primary key of the ttd process customer map
	* @return the ttd process customer map
	* @throws NoSuchTTDProcessCustomerMapException if a ttd process customer map with the primary key could not be found
	*/
	public static TTDProcessCustomerMap findByPrimaryKey(
		long TTDProcessCustomerId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDProcessCustomerMapException {
		return getPersistence().findByPrimaryKey(TTDProcessCustomerId);
	}

	/**
	* Returns the ttd process customer map with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param TTDProcessCustomerId the primary key of the ttd process customer map
	* @return the ttd process customer map, or <code>null</code> if a ttd process customer map with the primary key could not be found
	*/
	public static TTDProcessCustomerMap fetchByPrimaryKey(
		long TTDProcessCustomerId) {
		return getPersistence().fetchByPrimaryKey(TTDProcessCustomerId);
	}

	public static java.util.Map<java.io.Serializable, TTDProcessCustomerMap> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the ttd process customer maps.
	*
	* @return the ttd process customer maps
	*/
	public static List<TTDProcessCustomerMap> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ttd process customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ttd process customer maps
	* @param end the upper bound of the range of ttd process customer maps (not inclusive)
	* @return the range of ttd process customer maps
	*/
	public static List<TTDProcessCustomerMap> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ttd process customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ttd process customer maps
	* @param end the upper bound of the range of ttd process customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ttd process customer maps
	*/
	public static List<TTDProcessCustomerMap> findAll(int start, int end,
		OrderByComparator<TTDProcessCustomerMap> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the ttd process customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ttd process customer maps
	* @param end the upper bound of the range of ttd process customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of ttd process customer maps
	*/
	public static List<TTDProcessCustomerMap> findAll(int start, int end,
		OrderByComparator<TTDProcessCustomerMap> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the ttd process customer maps from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ttd process customer maps.
	*
	* @return the number of ttd process customer maps
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TTDProcessCustomerMapPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TTDProcessCustomerMapPersistence, TTDProcessCustomerMapPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TTDProcessCustomerMapPersistence.class);

		ServiceTracker<TTDProcessCustomerMapPersistence, TTDProcessCustomerMapPersistence> serviceTracker =
			new ServiceTracker<TTDProcessCustomerMapPersistence, TTDProcessCustomerMapPersistence>(bundle.getBundleContext(),
				TTDProcessCustomerMapPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}