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

import com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the t technology customer map service. This utility wraps {@link com.lti.itops.ipac.custcatmgmt.service.persistence.impl.TTechnologyCustomerMapPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sunprabh
 * @see TTechnologyCustomerMapPersistence
 * @see com.lti.itops.ipac.custcatmgmt.service.persistence.impl.TTechnologyCustomerMapPersistenceImpl
 * @generated
 */
@ProviderType
public class TTechnologyCustomerMapUtil {
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
	public static void clearCache(TTechnologyCustomerMap tTechnologyCustomerMap) {
		getPersistence().clearCache(tTechnologyCustomerMap);
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
	public static List<TTechnologyCustomerMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TTechnologyCustomerMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TTechnologyCustomerMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TTechnologyCustomerMap update(
		TTechnologyCustomerMap tTechnologyCustomerMap) {
		return getPersistence().update(tTechnologyCustomerMap);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TTechnologyCustomerMap update(
		TTechnologyCustomerMap tTechnologyCustomerMap,
		ServiceContext serviceContext) {
		return getPersistence().update(tTechnologyCustomerMap, serviceContext);
	}

	/**
	* Returns all the t technology customer maps where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching t technology customer maps
	*/
	public static List<TTechnologyCustomerMap> findByorganizationId(
		long organizationId) {
		return getPersistence().findByorganizationId(organizationId);
	}

	/**
	* Returns a range of all the t technology customer maps where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTechnologyCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of t technology customer maps
	* @param end the upper bound of the range of t technology customer maps (not inclusive)
	* @return the range of matching t technology customer maps
	*/
	public static List<TTechnologyCustomerMap> findByorganizationId(
		long organizationId, int start, int end) {
		return getPersistence().findByorganizationId(organizationId, start, end);
	}

	/**
	* Returns an ordered range of all the t technology customer maps where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTechnologyCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of t technology customer maps
	* @param end the upper bound of the range of t technology customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t technology customer maps
	*/
	public static List<TTechnologyCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator) {
		return getPersistence()
				   .findByorganizationId(organizationId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the t technology customer maps where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTechnologyCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of t technology customer maps
	* @param end the upper bound of the range of t technology customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching t technology customer maps
	*/
	public static List<TTechnologyCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByorganizationId(organizationId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first t technology customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t technology customer map
	* @throws NoSuchTTechnologyCustomerMapException if a matching t technology customer map could not be found
	*/
	public static TTechnologyCustomerMap findByorganizationId_First(
		long organizationId,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTechnologyCustomerMapException {
		return getPersistence()
				   .findByorganizationId_First(organizationId, orderByComparator);
	}

	/**
	* Returns the first t technology customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t technology customer map, or <code>null</code> if a matching t technology customer map could not be found
	*/
	public static TTechnologyCustomerMap fetchByorganizationId_First(
		long organizationId,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator) {
		return getPersistence()
				   .fetchByorganizationId_First(organizationId,
			orderByComparator);
	}

	/**
	* Returns the last t technology customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t technology customer map
	* @throws NoSuchTTechnologyCustomerMapException if a matching t technology customer map could not be found
	*/
	public static TTechnologyCustomerMap findByorganizationId_Last(
		long organizationId,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTechnologyCustomerMapException {
		return getPersistence()
				   .findByorganizationId_Last(organizationId, orderByComparator);
	}

	/**
	* Returns the last t technology customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t technology customer map, or <code>null</code> if a matching t technology customer map could not be found
	*/
	public static TTechnologyCustomerMap fetchByorganizationId_Last(
		long organizationId,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator) {
		return getPersistence()
				   .fetchByorganizationId_Last(organizationId, orderByComparator);
	}

	/**
	* Returns the t technology customer maps before and after the current t technology customer map in the ordered set where organizationId = &#63;.
	*
	* @param TTechnologyCustomerId the primary key of the current t technology customer map
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t technology customer map
	* @throws NoSuchTTechnologyCustomerMapException if a t technology customer map with the primary key could not be found
	*/
	public static TTechnologyCustomerMap[] findByorganizationId_PrevAndNext(
		long TTechnologyCustomerId, long organizationId,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTechnologyCustomerMapException {
		return getPersistence()
				   .findByorganizationId_PrevAndNext(TTechnologyCustomerId,
			organizationId, orderByComparator);
	}

	/**
	* Removes all the t technology customer maps where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	*/
	public static void removeByorganizationId(long organizationId) {
		getPersistence().removeByorganizationId(organizationId);
	}

	/**
	* Returns the number of t technology customer maps where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching t technology customer maps
	*/
	public static int countByorganizationId(long organizationId) {
		return getPersistence().countByorganizationId(organizationId);
	}

	/**
	* Returns all the t technology customer maps where towerTechnologyId = &#63; and organizationId = &#63;.
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @return the matching t technology customer maps
	*/
	public static List<TTechnologyCustomerMap> findByT_O(
		long towerTechnologyId, long organizationId) {
		return getPersistence().findByT_O(towerTechnologyId, organizationId);
	}

	/**
	* Returns a range of all the t technology customer maps where towerTechnologyId = &#63; and organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTechnologyCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @param start the lower bound of the range of t technology customer maps
	* @param end the upper bound of the range of t technology customer maps (not inclusive)
	* @return the range of matching t technology customer maps
	*/
	public static List<TTechnologyCustomerMap> findByT_O(
		long towerTechnologyId, long organizationId, int start, int end) {
		return getPersistence()
				   .findByT_O(towerTechnologyId, organizationId, start, end);
	}

	/**
	* Returns an ordered range of all the t technology customer maps where towerTechnologyId = &#63; and organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTechnologyCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @param start the lower bound of the range of t technology customer maps
	* @param end the upper bound of the range of t technology customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t technology customer maps
	*/
	public static List<TTechnologyCustomerMap> findByT_O(
		long towerTechnologyId, long organizationId, int start, int end,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator) {
		return getPersistence()
				   .findByT_O(towerTechnologyId, organizationId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the t technology customer maps where towerTechnologyId = &#63; and organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTechnologyCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @param start the lower bound of the range of t technology customer maps
	* @param end the upper bound of the range of t technology customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching t technology customer maps
	*/
	public static List<TTechnologyCustomerMap> findByT_O(
		long towerTechnologyId, long organizationId, int start, int end,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByT_O(towerTechnologyId, organizationId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first t technology customer map in the ordered set where towerTechnologyId = &#63; and organizationId = &#63;.
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t technology customer map
	* @throws NoSuchTTechnologyCustomerMapException if a matching t technology customer map could not be found
	*/
	public static TTechnologyCustomerMap findByT_O_First(
		long towerTechnologyId, long organizationId,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTechnologyCustomerMapException {
		return getPersistence()
				   .findByT_O_First(towerTechnologyId, organizationId,
			orderByComparator);
	}

	/**
	* Returns the first t technology customer map in the ordered set where towerTechnologyId = &#63; and organizationId = &#63;.
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t technology customer map, or <code>null</code> if a matching t technology customer map could not be found
	*/
	public static TTechnologyCustomerMap fetchByT_O_First(
		long towerTechnologyId, long organizationId,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator) {
		return getPersistence()
				   .fetchByT_O_First(towerTechnologyId, organizationId,
			orderByComparator);
	}

	/**
	* Returns the last t technology customer map in the ordered set where towerTechnologyId = &#63; and organizationId = &#63;.
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t technology customer map
	* @throws NoSuchTTechnologyCustomerMapException if a matching t technology customer map could not be found
	*/
	public static TTechnologyCustomerMap findByT_O_Last(
		long towerTechnologyId, long organizationId,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTechnologyCustomerMapException {
		return getPersistence()
				   .findByT_O_Last(towerTechnologyId, organizationId,
			orderByComparator);
	}

	/**
	* Returns the last t technology customer map in the ordered set where towerTechnologyId = &#63; and organizationId = &#63;.
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t technology customer map, or <code>null</code> if a matching t technology customer map could not be found
	*/
	public static TTechnologyCustomerMap fetchByT_O_Last(
		long towerTechnologyId, long organizationId,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator) {
		return getPersistence()
				   .fetchByT_O_Last(towerTechnologyId, organizationId,
			orderByComparator);
	}

	/**
	* Returns the t technology customer maps before and after the current t technology customer map in the ordered set where towerTechnologyId = &#63; and organizationId = &#63;.
	*
	* @param TTechnologyCustomerId the primary key of the current t technology customer map
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t technology customer map
	* @throws NoSuchTTechnologyCustomerMapException if a t technology customer map with the primary key could not be found
	*/
	public static TTechnologyCustomerMap[] findByT_O_PrevAndNext(
		long TTechnologyCustomerId, long towerTechnologyId,
		long organizationId,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTechnologyCustomerMapException {
		return getPersistence()
				   .findByT_O_PrevAndNext(TTechnologyCustomerId,
			towerTechnologyId, organizationId, orderByComparator);
	}

	/**
	* Removes all the t technology customer maps where towerTechnologyId = &#63; and organizationId = &#63; from the database.
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	*/
	public static void removeByT_O(long towerTechnologyId, long organizationId) {
		getPersistence().removeByT_O(towerTechnologyId, organizationId);
	}

	/**
	* Returns the number of t technology customer maps where towerTechnologyId = &#63; and organizationId = &#63;.
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @return the number of matching t technology customer maps
	*/
	public static int countByT_O(long towerTechnologyId, long organizationId) {
		return getPersistence().countByT_O(towerTechnologyId, organizationId);
	}

	/**
	* Returns the t technology customer map where TTechnologyCustomerId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTechnologyCustomerMapException} if it could not be found.
	*
	* @param TTechnologyCustomerId the t technology customer ID
	* @param organizationId the organization ID
	* @return the matching t technology customer map
	* @throws NoSuchTTechnologyCustomerMapException if a matching t technology customer map could not be found
	*/
	public static TTechnologyCustomerMap findByTTechnologyCustomerId(
		long TTechnologyCustomerId, long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTechnologyCustomerMapException {
		return getPersistence()
				   .findByTTechnologyCustomerId(TTechnologyCustomerId,
			organizationId);
	}

	/**
	* Returns the t technology customer map where TTechnologyCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param TTechnologyCustomerId the t technology customer ID
	* @param organizationId the organization ID
	* @return the matching t technology customer map, or <code>null</code> if a matching t technology customer map could not be found
	*/
	public static TTechnologyCustomerMap fetchByTTechnologyCustomerId(
		long TTechnologyCustomerId, long organizationId) {
		return getPersistence()
				   .fetchByTTechnologyCustomerId(TTechnologyCustomerId,
			organizationId);
	}

	/**
	* Returns the t technology customer map where TTechnologyCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param TTechnologyCustomerId the t technology customer ID
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching t technology customer map, or <code>null</code> if a matching t technology customer map could not be found
	*/
	public static TTechnologyCustomerMap fetchByTTechnologyCustomerId(
		long TTechnologyCustomerId, long organizationId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByTTechnologyCustomerId(TTechnologyCustomerId,
			organizationId, retrieveFromCache);
	}

	/**
	* Removes the t technology customer map where TTechnologyCustomerId = &#63; and organizationId = &#63; from the database.
	*
	* @param TTechnologyCustomerId the t technology customer ID
	* @param organizationId the organization ID
	* @return the t technology customer map that was removed
	*/
	public static TTechnologyCustomerMap removeByTTechnologyCustomerId(
		long TTechnologyCustomerId, long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTechnologyCustomerMapException {
		return getPersistence()
				   .removeByTTechnologyCustomerId(TTechnologyCustomerId,
			organizationId);
	}

	/**
	* Returns the number of t technology customer maps where TTechnologyCustomerId = &#63; and organizationId = &#63;.
	*
	* @param TTechnologyCustomerId the t technology customer ID
	* @param organizationId the organization ID
	* @return the number of matching t technology customer maps
	*/
	public static int countByTTechnologyCustomerId(long TTechnologyCustomerId,
		long organizationId) {
		return getPersistence()
				   .countByTTechnologyCustomerId(TTechnologyCustomerId,
			organizationId);
	}

	/**
	* Returns the t technology customer map where towerTechnologyId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTechnologyCustomerMapException} if it could not be found.
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @return the matching t technology customer map
	* @throws NoSuchTTechnologyCustomerMapException if a matching t technology customer map could not be found
	*/
	public static TTechnologyCustomerMap findByTowerTechnologyId(
		long towerTechnologyId, long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTechnologyCustomerMapException {
		return getPersistence()
				   .findByTowerTechnologyId(towerTechnologyId, organizationId);
	}

	/**
	* Returns the t technology customer map where towerTechnologyId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @return the matching t technology customer map, or <code>null</code> if a matching t technology customer map could not be found
	*/
	public static TTechnologyCustomerMap fetchByTowerTechnologyId(
		long towerTechnologyId, long organizationId) {
		return getPersistence()
				   .fetchByTowerTechnologyId(towerTechnologyId, organizationId);
	}

	/**
	* Returns the t technology customer map where towerTechnologyId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching t technology customer map, or <code>null</code> if a matching t technology customer map could not be found
	*/
	public static TTechnologyCustomerMap fetchByTowerTechnologyId(
		long towerTechnologyId, long organizationId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByTowerTechnologyId(towerTechnologyId, organizationId,
			retrieveFromCache);
	}

	/**
	* Removes the t technology customer map where towerTechnologyId = &#63; and organizationId = &#63; from the database.
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @return the t technology customer map that was removed
	*/
	public static TTechnologyCustomerMap removeByTowerTechnologyId(
		long towerTechnologyId, long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTechnologyCustomerMapException {
		return getPersistence()
				   .removeByTowerTechnologyId(towerTechnologyId, organizationId);
	}

	/**
	* Returns the number of t technology customer maps where towerTechnologyId = &#63; and organizationId = &#63;.
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @return the number of matching t technology customer maps
	*/
	public static int countByTowerTechnologyId(long towerTechnologyId,
		long organizationId) {
		return getPersistence()
				   .countByTowerTechnologyId(towerTechnologyId, organizationId);
	}

	/**
	* Caches the t technology customer map in the entity cache if it is enabled.
	*
	* @param tTechnologyCustomerMap the t technology customer map
	*/
	public static void cacheResult(
		TTechnologyCustomerMap tTechnologyCustomerMap) {
		getPersistence().cacheResult(tTechnologyCustomerMap);
	}

	/**
	* Caches the t technology customer maps in the entity cache if it is enabled.
	*
	* @param tTechnologyCustomerMaps the t technology customer maps
	*/
	public static void cacheResult(
		List<TTechnologyCustomerMap> tTechnologyCustomerMaps) {
		getPersistence().cacheResult(tTechnologyCustomerMaps);
	}

	/**
	* Creates a new t technology customer map with the primary key. Does not add the t technology customer map to the database.
	*
	* @param TTechnologyCustomerId the primary key for the new t technology customer map
	* @return the new t technology customer map
	*/
	public static TTechnologyCustomerMap create(long TTechnologyCustomerId) {
		return getPersistence().create(TTechnologyCustomerId);
	}

	/**
	* Removes the t technology customer map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param TTechnologyCustomerId the primary key of the t technology customer map
	* @return the t technology customer map that was removed
	* @throws NoSuchTTechnologyCustomerMapException if a t technology customer map with the primary key could not be found
	*/
	public static TTechnologyCustomerMap remove(long TTechnologyCustomerId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTechnologyCustomerMapException {
		return getPersistence().remove(TTechnologyCustomerId);
	}

	public static TTechnologyCustomerMap updateImpl(
		TTechnologyCustomerMap tTechnologyCustomerMap) {
		return getPersistence().updateImpl(tTechnologyCustomerMap);
	}

	/**
	* Returns the t technology customer map with the primary key or throws a {@link NoSuchTTechnologyCustomerMapException} if it could not be found.
	*
	* @param TTechnologyCustomerId the primary key of the t technology customer map
	* @return the t technology customer map
	* @throws NoSuchTTechnologyCustomerMapException if a t technology customer map with the primary key could not be found
	*/
	public static TTechnologyCustomerMap findByPrimaryKey(
		long TTechnologyCustomerId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTechnologyCustomerMapException {
		return getPersistence().findByPrimaryKey(TTechnologyCustomerId);
	}

	/**
	* Returns the t technology customer map with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param TTechnologyCustomerId the primary key of the t technology customer map
	* @return the t technology customer map, or <code>null</code> if a t technology customer map with the primary key could not be found
	*/
	public static TTechnologyCustomerMap fetchByPrimaryKey(
		long TTechnologyCustomerId) {
		return getPersistence().fetchByPrimaryKey(TTechnologyCustomerId);
	}

	public static java.util.Map<java.io.Serializable, TTechnologyCustomerMap> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the t technology customer maps.
	*
	* @return the t technology customer maps
	*/
	public static List<TTechnologyCustomerMap> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the t technology customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTechnologyCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of t technology customer maps
	* @param end the upper bound of the range of t technology customer maps (not inclusive)
	* @return the range of t technology customer maps
	*/
	public static List<TTechnologyCustomerMap> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the t technology customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTechnologyCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of t technology customer maps
	* @param end the upper bound of the range of t technology customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of t technology customer maps
	*/
	public static List<TTechnologyCustomerMap> findAll(int start, int end,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the t technology customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTechnologyCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of t technology customer maps
	* @param end the upper bound of the range of t technology customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of t technology customer maps
	*/
	public static List<TTechnologyCustomerMap> findAll(int start, int end,
		OrderByComparator<TTechnologyCustomerMap> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the t technology customer maps from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of t technology customer maps.
	*
	* @return the number of t technology customer maps
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TTechnologyCustomerMapPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TTechnologyCustomerMapPersistence, TTechnologyCustomerMapPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TTechnologyCustomerMapPersistence.class);

		ServiceTracker<TTechnologyCustomerMapPersistence, TTechnologyCustomerMapPersistence> serviceTracker =
			new ServiceTracker<TTechnologyCustomerMapPersistence, TTechnologyCustomerMapPersistence>(bundle.getBundleContext(),
				TTechnologyCustomerMapPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}