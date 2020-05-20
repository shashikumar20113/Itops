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

import com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the tower customer map service. This utility wraps {@link com.lti.itops.ipac.custcatmgmt.service.persistence.impl.TowerCustomerMapPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sunprabh
 * @see TowerCustomerMapPersistence
 * @see com.lti.itops.ipac.custcatmgmt.service.persistence.impl.TowerCustomerMapPersistenceImpl
 * @generated
 */
@ProviderType
public class TowerCustomerMapUtil {
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
	public static void clearCache(TowerCustomerMap towerCustomerMap) {
		getPersistence().clearCache(towerCustomerMap);
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
	public static List<TowerCustomerMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TowerCustomerMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TowerCustomerMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TowerCustomerMap> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TowerCustomerMap update(TowerCustomerMap towerCustomerMap) {
		return getPersistence().update(towerCustomerMap);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TowerCustomerMap update(TowerCustomerMap towerCustomerMap,
		ServiceContext serviceContext) {
		return getPersistence().update(towerCustomerMap, serviceContext);
	}

	/**
	* Returns all the tower customer maps where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching tower customer maps
	*/
	public static List<TowerCustomerMap> findByorganization(long organizationId) {
		return getPersistence().findByorganization(organizationId);
	}

	/**
	* Returns a range of all the tower customer maps where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TowerCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of tower customer maps
	* @param end the upper bound of the range of tower customer maps (not inclusive)
	* @return the range of matching tower customer maps
	*/
	public static List<TowerCustomerMap> findByorganization(
		long organizationId, int start, int end) {
		return getPersistence().findByorganization(organizationId, start, end);
	}

	/**
	* Returns an ordered range of all the tower customer maps where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TowerCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of tower customer maps
	* @param end the upper bound of the range of tower customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tower customer maps
	*/
	public static List<TowerCustomerMap> findByorganization(
		long organizationId, int start, int end,
		OrderByComparator<TowerCustomerMap> orderByComparator) {
		return getPersistence()
				   .findByorganization(organizationId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the tower customer maps where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TowerCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of tower customer maps
	* @param end the upper bound of the range of tower customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tower customer maps
	*/
	public static List<TowerCustomerMap> findByorganization(
		long organizationId, int start, int end,
		OrderByComparator<TowerCustomerMap> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByorganization(organizationId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first tower customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tower customer map
	* @throws NoSuchTowerCustomerMapException if a matching tower customer map could not be found
	*/
	public static TowerCustomerMap findByorganization_First(
		long organizationId,
		OrderByComparator<TowerCustomerMap> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTowerCustomerMapException {
		return getPersistence()
				   .findByorganization_First(organizationId, orderByComparator);
	}

	/**
	* Returns the first tower customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tower customer map, or <code>null</code> if a matching tower customer map could not be found
	*/
	public static TowerCustomerMap fetchByorganization_First(
		long organizationId,
		OrderByComparator<TowerCustomerMap> orderByComparator) {
		return getPersistence()
				   .fetchByorganization_First(organizationId, orderByComparator);
	}

	/**
	* Returns the last tower customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tower customer map
	* @throws NoSuchTowerCustomerMapException if a matching tower customer map could not be found
	*/
	public static TowerCustomerMap findByorganization_Last(
		long organizationId,
		OrderByComparator<TowerCustomerMap> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTowerCustomerMapException {
		return getPersistence()
				   .findByorganization_Last(organizationId, orderByComparator);
	}

	/**
	* Returns the last tower customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tower customer map, or <code>null</code> if a matching tower customer map could not be found
	*/
	public static TowerCustomerMap fetchByorganization_Last(
		long organizationId,
		OrderByComparator<TowerCustomerMap> orderByComparator) {
		return getPersistence()
				   .fetchByorganization_Last(organizationId, orderByComparator);
	}

	/**
	* Returns the tower customer maps before and after the current tower customer map in the ordered set where organizationId = &#63;.
	*
	* @param towerCustomerId the primary key of the current tower customer map
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tower customer map
	* @throws NoSuchTowerCustomerMapException if a tower customer map with the primary key could not be found
	*/
	public static TowerCustomerMap[] findByorganization_PrevAndNext(
		long towerCustomerId, long organizationId,
		OrderByComparator<TowerCustomerMap> orderByComparator)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTowerCustomerMapException {
		return getPersistence()
				   .findByorganization_PrevAndNext(towerCustomerId,
			organizationId, orderByComparator);
	}

	/**
	* Removes all the tower customer maps where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	*/
	public static void removeByorganization(long organizationId) {
		getPersistence().removeByorganization(organizationId);
	}

	/**
	* Returns the number of tower customer maps where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching tower customer maps
	*/
	public static int countByorganization(long organizationId) {
		return getPersistence().countByorganization(organizationId);
	}

	/**
	* Returns the tower customer map where towerId = &#63; and organizationId = &#63; or throws a {@link NoSuchTowerCustomerMapException} if it could not be found.
	*
	* @param towerId the tower ID
	* @param organizationId the organization ID
	* @return the matching tower customer map
	* @throws NoSuchTowerCustomerMapException if a matching tower customer map could not be found
	*/
	public static TowerCustomerMap findByT_O(long towerId, long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTowerCustomerMapException {
		return getPersistence().findByT_O(towerId, organizationId);
	}

	/**
	* Returns the tower customer map where towerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param towerId the tower ID
	* @param organizationId the organization ID
	* @return the matching tower customer map, or <code>null</code> if a matching tower customer map could not be found
	*/
	public static TowerCustomerMap fetchByT_O(long towerId, long organizationId) {
		return getPersistence().fetchByT_O(towerId, organizationId);
	}

	/**
	* Returns the tower customer map where towerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param towerId the tower ID
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching tower customer map, or <code>null</code> if a matching tower customer map could not be found
	*/
	public static TowerCustomerMap fetchByT_O(long towerId,
		long organizationId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByT_O(towerId, organizationId, retrieveFromCache);
	}

	/**
	* Removes the tower customer map where towerId = &#63; and organizationId = &#63; from the database.
	*
	* @param towerId the tower ID
	* @param organizationId the organization ID
	* @return the tower customer map that was removed
	*/
	public static TowerCustomerMap removeByT_O(long towerId, long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTowerCustomerMapException {
		return getPersistence().removeByT_O(towerId, organizationId);
	}

	/**
	* Returns the number of tower customer maps where towerId = &#63; and organizationId = &#63;.
	*
	* @param towerId the tower ID
	* @param organizationId the organization ID
	* @return the number of matching tower customer maps
	*/
	public static int countByT_O(long towerId, long organizationId) {
		return getPersistence().countByT_O(towerId, organizationId);
	}

	/**
	* Caches the tower customer map in the entity cache if it is enabled.
	*
	* @param towerCustomerMap the tower customer map
	*/
	public static void cacheResult(TowerCustomerMap towerCustomerMap) {
		getPersistence().cacheResult(towerCustomerMap);
	}

	/**
	* Caches the tower customer maps in the entity cache if it is enabled.
	*
	* @param towerCustomerMaps the tower customer maps
	*/
	public static void cacheResult(List<TowerCustomerMap> towerCustomerMaps) {
		getPersistence().cacheResult(towerCustomerMaps);
	}

	/**
	* Creates a new tower customer map with the primary key. Does not add the tower customer map to the database.
	*
	* @param towerCustomerId the primary key for the new tower customer map
	* @return the new tower customer map
	*/
	public static TowerCustomerMap create(long towerCustomerId) {
		return getPersistence().create(towerCustomerId);
	}

	/**
	* Removes the tower customer map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param towerCustomerId the primary key of the tower customer map
	* @return the tower customer map that was removed
	* @throws NoSuchTowerCustomerMapException if a tower customer map with the primary key could not be found
	*/
	public static TowerCustomerMap remove(long towerCustomerId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTowerCustomerMapException {
		return getPersistence().remove(towerCustomerId);
	}

	public static TowerCustomerMap updateImpl(TowerCustomerMap towerCustomerMap) {
		return getPersistence().updateImpl(towerCustomerMap);
	}

	/**
	* Returns the tower customer map with the primary key or throws a {@link NoSuchTowerCustomerMapException} if it could not be found.
	*
	* @param towerCustomerId the primary key of the tower customer map
	* @return the tower customer map
	* @throws NoSuchTowerCustomerMapException if a tower customer map with the primary key could not be found
	*/
	public static TowerCustomerMap findByPrimaryKey(long towerCustomerId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTowerCustomerMapException {
		return getPersistence().findByPrimaryKey(towerCustomerId);
	}

	/**
	* Returns the tower customer map with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param towerCustomerId the primary key of the tower customer map
	* @return the tower customer map, or <code>null</code> if a tower customer map with the primary key could not be found
	*/
	public static TowerCustomerMap fetchByPrimaryKey(long towerCustomerId) {
		return getPersistence().fetchByPrimaryKey(towerCustomerId);
	}

	public static java.util.Map<java.io.Serializable, TowerCustomerMap> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the tower customer maps.
	*
	* @return the tower customer maps
	*/
	public static List<TowerCustomerMap> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tower customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TowerCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tower customer maps
	* @param end the upper bound of the range of tower customer maps (not inclusive)
	* @return the range of tower customer maps
	*/
	public static List<TowerCustomerMap> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tower customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TowerCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tower customer maps
	* @param end the upper bound of the range of tower customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tower customer maps
	*/
	public static List<TowerCustomerMap> findAll(int start, int end,
		OrderByComparator<TowerCustomerMap> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tower customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TowerCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tower customer maps
	* @param end the upper bound of the range of tower customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tower customer maps
	*/
	public static List<TowerCustomerMap> findAll(int start, int end,
		OrderByComparator<TowerCustomerMap> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the tower customer maps from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tower customer maps.
	*
	* @return the number of tower customer maps
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TowerCustomerMapPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TowerCustomerMapPersistence, TowerCustomerMapPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TowerCustomerMapPersistence.class);

		ServiceTracker<TowerCustomerMapPersistence, TowerCustomerMapPersistence> serviceTracker =
			new ServiceTracker<TowerCustomerMapPersistence, TowerCustomerMapPersistence>(bundle.getBundleContext(),
				TowerCustomerMapPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}