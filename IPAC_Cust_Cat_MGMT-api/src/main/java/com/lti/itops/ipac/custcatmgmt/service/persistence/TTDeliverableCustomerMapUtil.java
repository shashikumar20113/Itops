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

import com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the tt deliverable customer map service. This utility wraps {@link com.lti.itops.ipac.custcatmgmt.service.persistence.impl.TTDeliverableCustomerMapPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sunprabh
 * @see TTDeliverableCustomerMapPersistence
 * @see com.lti.itops.ipac.custcatmgmt.service.persistence.impl.TTDeliverableCustomerMapPersistenceImpl
 * @generated
 */
@ProviderType
public class TTDeliverableCustomerMapUtil {
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
		TTDeliverableCustomerMap ttDeliverableCustomerMap) {
		getPersistence().clearCache(ttDeliverableCustomerMap);
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
	public static List<TTDeliverableCustomerMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TTDeliverableCustomerMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TTDeliverableCustomerMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TTDeliverableCustomerMap> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TTDeliverableCustomerMap update(
		TTDeliverableCustomerMap ttDeliverableCustomerMap) {
		return getPersistence().update(ttDeliverableCustomerMap);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TTDeliverableCustomerMap update(
		TTDeliverableCustomerMap ttDeliverableCustomerMap,
		ServiceContext serviceContext) {
		return getPersistence().update(ttDeliverableCustomerMap, serviceContext);
	}

	/**
	* Returns all the tt deliverable customer maps where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching tt deliverable customer maps
	*/
	public static List<TTDeliverableCustomerMap> findByorganizationId(
		long organizationId) {
		return getPersistence().findByorganizationId(organizationId);
	}

	/**
	* Returns a range of all the tt deliverable customer maps where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDeliverableCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of tt deliverable customer maps
	* @param end the upper bound of the range of tt deliverable customer maps (not inclusive)
	* @return the range of matching tt deliverable customer maps
	*/
	public static List<TTDeliverableCustomerMap> findByorganizationId(
		long organizationId, int start, int end) {
		return getPersistence().findByorganizationId(organizationId, start, end);
	}

	/**
	* Returns an ordered range of all the tt deliverable customer maps where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDeliverableCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of tt deliverable customer maps
	* @param end the upper bound of the range of tt deliverable customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tt deliverable customer maps
	*/
	public static List<TTDeliverableCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<TTDeliverableCustomerMap> orderByComparator) {
		return getPersistence()
				   .findByorganizationId(organizationId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the tt deliverable customer maps where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDeliverableCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of tt deliverable customer maps
	* @param end the upper bound of the range of tt deliverable customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tt deliverable customer maps
	*/
	public static List<TTDeliverableCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<TTDeliverableCustomerMap> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByorganizationId(organizationId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first tt deliverable customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tt deliverable customer map
	* @throws NoSuchTTDeliverableCustomerMapException if a matching tt deliverable customer map could not be found
	*/
	public static TTDeliverableCustomerMap findByorganizationId_First(
		long organizationId,
		OrderByComparator<TTDeliverableCustomerMap> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDeliverableCustomerMapException {
		return getPersistence()
				   .findByorganizationId_First(organizationId, orderByComparator);
	}

	/**
	* Returns the first tt deliverable customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tt deliverable customer map, or <code>null</code> if a matching tt deliverable customer map could not be found
	*/
	public static TTDeliverableCustomerMap fetchByorganizationId_First(
		long organizationId,
		OrderByComparator<TTDeliverableCustomerMap> orderByComparator) {
		return getPersistence()
				   .fetchByorganizationId_First(organizationId,
			orderByComparator);
	}

	/**
	* Returns the last tt deliverable customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tt deliverable customer map
	* @throws NoSuchTTDeliverableCustomerMapException if a matching tt deliverable customer map could not be found
	*/
	public static TTDeliverableCustomerMap findByorganizationId_Last(
		long organizationId,
		OrderByComparator<TTDeliverableCustomerMap> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDeliverableCustomerMapException {
		return getPersistence()
				   .findByorganizationId_Last(organizationId, orderByComparator);
	}

	/**
	* Returns the last tt deliverable customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tt deliverable customer map, or <code>null</code> if a matching tt deliverable customer map could not be found
	*/
	public static TTDeliverableCustomerMap fetchByorganizationId_Last(
		long organizationId,
		OrderByComparator<TTDeliverableCustomerMap> orderByComparator) {
		return getPersistence()
				   .fetchByorganizationId_Last(organizationId, orderByComparator);
	}

	/**
	* Returns the tt deliverable customer maps before and after the current tt deliverable customer map in the ordered set where organizationId = &#63;.
	*
	* @param TTDeliverableCustomerId the primary key of the current tt deliverable customer map
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tt deliverable customer map
	* @throws NoSuchTTDeliverableCustomerMapException if a tt deliverable customer map with the primary key could not be found
	*/
	public static TTDeliverableCustomerMap[] findByorganizationId_PrevAndNext(
		long TTDeliverableCustomerId, long organizationId,
		OrderByComparator<TTDeliverableCustomerMap> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDeliverableCustomerMapException {
		return getPersistence()
				   .findByorganizationId_PrevAndNext(TTDeliverableCustomerId,
			organizationId, orderByComparator);
	}

	/**
	* Removes all the tt deliverable customer maps where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	*/
	public static void removeByorganizationId(long organizationId) {
		getPersistence().removeByorganizationId(organizationId);
	}

	/**
	* Returns the number of tt deliverable customer maps where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching tt deliverable customer maps
	*/
	public static int countByorganizationId(long organizationId) {
		return getPersistence().countByorganizationId(organizationId);
	}

	/**
	* Returns the tt deliverable customer map where TTDeliverableId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDeliverableCustomerMapException} if it could not be found.
	*
	* @param TTDeliverableId the tt deliverable ID
	* @param organizationId the organization ID
	* @return the matching tt deliverable customer map
	* @throws NoSuchTTDeliverableCustomerMapException if a matching tt deliverable customer map could not be found
	*/
	public static TTDeliverableCustomerMap findByTTDeliverableId(
		long TTDeliverableId, long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDeliverableCustomerMapException {
		return getPersistence()
				   .findByTTDeliverableId(TTDeliverableId, organizationId);
	}

	/**
	* Returns the tt deliverable customer map where TTDeliverableId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param TTDeliverableId the tt deliverable ID
	* @param organizationId the organization ID
	* @return the matching tt deliverable customer map, or <code>null</code> if a matching tt deliverable customer map could not be found
	*/
	public static TTDeliverableCustomerMap fetchByTTDeliverableId(
		long TTDeliverableId, long organizationId) {
		return getPersistence()
				   .fetchByTTDeliverableId(TTDeliverableId, organizationId);
	}

	/**
	* Returns the tt deliverable customer map where TTDeliverableId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param TTDeliverableId the tt deliverable ID
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching tt deliverable customer map, or <code>null</code> if a matching tt deliverable customer map could not be found
	*/
	public static TTDeliverableCustomerMap fetchByTTDeliverableId(
		long TTDeliverableId, long organizationId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByTTDeliverableId(TTDeliverableId, organizationId,
			retrieveFromCache);
	}

	/**
	* Removes the tt deliverable customer map where TTDeliverableId = &#63; and organizationId = &#63; from the database.
	*
	* @param TTDeliverableId the tt deliverable ID
	* @param organizationId the organization ID
	* @return the tt deliverable customer map that was removed
	*/
	public static TTDeliverableCustomerMap removeByTTDeliverableId(
		long TTDeliverableId, long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDeliverableCustomerMapException {
		return getPersistence()
				   .removeByTTDeliverableId(TTDeliverableId, organizationId);
	}

	/**
	* Returns the number of tt deliverable customer maps where TTDeliverableId = &#63; and organizationId = &#63;.
	*
	* @param TTDeliverableId the tt deliverable ID
	* @param organizationId the organization ID
	* @return the number of matching tt deliverable customer maps
	*/
	public static int countByTTDeliverableId(long TTDeliverableId,
		long organizationId) {
		return getPersistence()
				   .countByTTDeliverableId(TTDeliverableId, organizationId);
	}

	/**
	* Returns the tt deliverable customer map where TTDeliverableCustomerId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDeliverableCustomerMapException} if it could not be found.
	*
	* @param TTDeliverableCustomerId the tt deliverable customer ID
	* @param organizationId the organization ID
	* @return the matching tt deliverable customer map
	* @throws NoSuchTTDeliverableCustomerMapException if a matching tt deliverable customer map could not be found
	*/
	public static TTDeliverableCustomerMap findByTTDeliverableCustomerId(
		long TTDeliverableCustomerId, long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDeliverableCustomerMapException {
		return getPersistence()
				   .findByTTDeliverableCustomerId(TTDeliverableCustomerId,
			organizationId);
	}

	/**
	* Returns the tt deliverable customer map where TTDeliverableCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param TTDeliverableCustomerId the tt deliverable customer ID
	* @param organizationId the organization ID
	* @return the matching tt deliverable customer map, or <code>null</code> if a matching tt deliverable customer map could not be found
	*/
	public static TTDeliverableCustomerMap fetchByTTDeliverableCustomerId(
		long TTDeliverableCustomerId, long organizationId) {
		return getPersistence()
				   .fetchByTTDeliverableCustomerId(TTDeliverableCustomerId,
			organizationId);
	}

	/**
	* Returns the tt deliverable customer map where TTDeliverableCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param TTDeliverableCustomerId the tt deliverable customer ID
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching tt deliverable customer map, or <code>null</code> if a matching tt deliverable customer map could not be found
	*/
	public static TTDeliverableCustomerMap fetchByTTDeliverableCustomerId(
		long TTDeliverableCustomerId, long organizationId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByTTDeliverableCustomerId(TTDeliverableCustomerId,
			organizationId, retrieveFromCache);
	}

	/**
	* Removes the tt deliverable customer map where TTDeliverableCustomerId = &#63; and organizationId = &#63; from the database.
	*
	* @param TTDeliverableCustomerId the tt deliverable customer ID
	* @param organizationId the organization ID
	* @return the tt deliverable customer map that was removed
	*/
	public static TTDeliverableCustomerMap removeByTTDeliverableCustomerId(
		long TTDeliverableCustomerId, long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDeliverableCustomerMapException {
		return getPersistence()
				   .removeByTTDeliverableCustomerId(TTDeliverableCustomerId,
			organizationId);
	}

	/**
	* Returns the number of tt deliverable customer maps where TTDeliverableCustomerId = &#63; and organizationId = &#63;.
	*
	* @param TTDeliverableCustomerId the tt deliverable customer ID
	* @param organizationId the organization ID
	* @return the number of matching tt deliverable customer maps
	*/
	public static int countByTTDeliverableCustomerId(
		long TTDeliverableCustomerId, long organizationId) {
		return getPersistence()
				   .countByTTDeliverableCustomerId(TTDeliverableCustomerId,
			organizationId);
	}

	/**
	* Caches the tt deliverable customer map in the entity cache if it is enabled.
	*
	* @param ttDeliverableCustomerMap the tt deliverable customer map
	*/
	public static void cacheResult(
		TTDeliverableCustomerMap ttDeliverableCustomerMap) {
		getPersistence().cacheResult(ttDeliverableCustomerMap);
	}

	/**
	* Caches the tt deliverable customer maps in the entity cache if it is enabled.
	*
	* @param ttDeliverableCustomerMaps the tt deliverable customer maps
	*/
	public static void cacheResult(
		List<TTDeliverableCustomerMap> ttDeliverableCustomerMaps) {
		getPersistence().cacheResult(ttDeliverableCustomerMaps);
	}

	/**
	* Creates a new tt deliverable customer map with the primary key. Does not add the tt deliverable customer map to the database.
	*
	* @param TTDeliverableCustomerId the primary key for the new tt deliverable customer map
	* @return the new tt deliverable customer map
	*/
	public static TTDeliverableCustomerMap create(long TTDeliverableCustomerId) {
		return getPersistence().create(TTDeliverableCustomerId);
	}

	/**
	* Removes the tt deliverable customer map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param TTDeliverableCustomerId the primary key of the tt deliverable customer map
	* @return the tt deliverable customer map that was removed
	* @throws NoSuchTTDeliverableCustomerMapException if a tt deliverable customer map with the primary key could not be found
	*/
	public static TTDeliverableCustomerMap remove(long TTDeliverableCustomerId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDeliverableCustomerMapException {
		return getPersistence().remove(TTDeliverableCustomerId);
	}

	public static TTDeliverableCustomerMap updateImpl(
		TTDeliverableCustomerMap ttDeliverableCustomerMap) {
		return getPersistence().updateImpl(ttDeliverableCustomerMap);
	}

	/**
	* Returns the tt deliverable customer map with the primary key or throws a {@link NoSuchTTDeliverableCustomerMapException} if it could not be found.
	*
	* @param TTDeliverableCustomerId the primary key of the tt deliverable customer map
	* @return the tt deliverable customer map
	* @throws NoSuchTTDeliverableCustomerMapException if a tt deliverable customer map with the primary key could not be found
	*/
	public static TTDeliverableCustomerMap findByPrimaryKey(
		long TTDeliverableCustomerId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDeliverableCustomerMapException {
		return getPersistence().findByPrimaryKey(TTDeliverableCustomerId);
	}

	/**
	* Returns the tt deliverable customer map with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param TTDeliverableCustomerId the primary key of the tt deliverable customer map
	* @return the tt deliverable customer map, or <code>null</code> if a tt deliverable customer map with the primary key could not be found
	*/
	public static TTDeliverableCustomerMap fetchByPrimaryKey(
		long TTDeliverableCustomerId) {
		return getPersistence().fetchByPrimaryKey(TTDeliverableCustomerId);
	}

	public static java.util.Map<java.io.Serializable, TTDeliverableCustomerMap> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the tt deliverable customer maps.
	*
	* @return the tt deliverable customer maps
	*/
	public static List<TTDeliverableCustomerMap> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tt deliverable customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDeliverableCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tt deliverable customer maps
	* @param end the upper bound of the range of tt deliverable customer maps (not inclusive)
	* @return the range of tt deliverable customer maps
	*/
	public static List<TTDeliverableCustomerMap> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tt deliverable customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDeliverableCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tt deliverable customer maps
	* @param end the upper bound of the range of tt deliverable customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tt deliverable customer maps
	*/
	public static List<TTDeliverableCustomerMap> findAll(int start, int end,
		OrderByComparator<TTDeliverableCustomerMap> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tt deliverable customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDeliverableCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tt deliverable customer maps
	* @param end the upper bound of the range of tt deliverable customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tt deliverable customer maps
	*/
	public static List<TTDeliverableCustomerMap> findAll(int start, int end,
		OrderByComparator<TTDeliverableCustomerMap> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the tt deliverable customer maps from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tt deliverable customer maps.
	*
	* @return the number of tt deliverable customer maps
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TTDeliverableCustomerMapPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TTDeliverableCustomerMapPersistence, TTDeliverableCustomerMapPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TTDeliverableCustomerMapPersistence.class);

		ServiceTracker<TTDeliverableCustomerMapPersistence, TTDeliverableCustomerMapPersistence> serviceTracker =
			new ServiceTracker<TTDeliverableCustomerMapPersistence, TTDeliverableCustomerMapPersistence>(bundle.getBundleContext(),
				TTDeliverableCustomerMapPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}