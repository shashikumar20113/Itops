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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.lti.itops.ipac.custcatmgmt.exception.NoSuchTowerCustomerMapException;
import com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap;

/**
 * The persistence interface for the tower customer map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sunprabh
 * @see com.lti.itops.ipac.custcatmgmt.service.persistence.impl.TowerCustomerMapPersistenceImpl
 * @see TowerCustomerMapUtil
 * @generated
 */
@ProviderType
public interface TowerCustomerMapPersistence extends BasePersistence<TowerCustomerMap> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TowerCustomerMapUtil} to access the tower customer map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the tower customer maps where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching tower customer maps
	*/
	public java.util.List<TowerCustomerMap> findByorganization(
		long organizationId);

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
	public java.util.List<TowerCustomerMap> findByorganization(
		long organizationId, int start, int end);

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
	public java.util.List<TowerCustomerMap> findByorganization(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TowerCustomerMap> orderByComparator);

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
	public java.util.List<TowerCustomerMap> findByorganization(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TowerCustomerMap> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first tower customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tower customer map
	* @throws NoSuchTowerCustomerMapException if a matching tower customer map could not be found
	*/
	public TowerCustomerMap findByorganization_First(long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TowerCustomerMap> orderByComparator)
		throws NoSuchTowerCustomerMapException;

	/**
	* Returns the first tower customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tower customer map, or <code>null</code> if a matching tower customer map could not be found
	*/
	public TowerCustomerMap fetchByorganization_First(long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TowerCustomerMap> orderByComparator);

	/**
	* Returns the last tower customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tower customer map
	* @throws NoSuchTowerCustomerMapException if a matching tower customer map could not be found
	*/
	public TowerCustomerMap findByorganization_Last(long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TowerCustomerMap> orderByComparator)
		throws NoSuchTowerCustomerMapException;

	/**
	* Returns the last tower customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tower customer map, or <code>null</code> if a matching tower customer map could not be found
	*/
	public TowerCustomerMap fetchByorganization_Last(long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TowerCustomerMap> orderByComparator);

	/**
	* Returns the tower customer maps before and after the current tower customer map in the ordered set where organizationId = &#63;.
	*
	* @param towerCustomerId the primary key of the current tower customer map
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tower customer map
	* @throws NoSuchTowerCustomerMapException if a tower customer map with the primary key could not be found
	*/
	public TowerCustomerMap[] findByorganization_PrevAndNext(
		long towerCustomerId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TowerCustomerMap> orderByComparator)
		throws NoSuchTowerCustomerMapException;

	/**
	* Removes all the tower customer maps where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	*/
	public void removeByorganization(long organizationId);

	/**
	* Returns the number of tower customer maps where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching tower customer maps
	*/
	public int countByorganization(long organizationId);

	/**
	* Returns the tower customer map where towerId = &#63; and organizationId = &#63; or throws a {@link NoSuchTowerCustomerMapException} if it could not be found.
	*
	* @param towerId the tower ID
	* @param organizationId the organization ID
	* @return the matching tower customer map
	* @throws NoSuchTowerCustomerMapException if a matching tower customer map could not be found
	*/
	public TowerCustomerMap findByT_O(long towerId, long organizationId)
		throws NoSuchTowerCustomerMapException;

	/**
	* Returns the tower customer map where towerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param towerId the tower ID
	* @param organizationId the organization ID
	* @return the matching tower customer map, or <code>null</code> if a matching tower customer map could not be found
	*/
	public TowerCustomerMap fetchByT_O(long towerId, long organizationId);

	/**
	* Returns the tower customer map where towerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param towerId the tower ID
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching tower customer map, or <code>null</code> if a matching tower customer map could not be found
	*/
	public TowerCustomerMap fetchByT_O(long towerId, long organizationId,
		boolean retrieveFromCache);

	/**
	* Removes the tower customer map where towerId = &#63; and organizationId = &#63; from the database.
	*
	* @param towerId the tower ID
	* @param organizationId the organization ID
	* @return the tower customer map that was removed
	*/
	public TowerCustomerMap removeByT_O(long towerId, long organizationId)
		throws NoSuchTowerCustomerMapException;

	/**
	* Returns the number of tower customer maps where towerId = &#63; and organizationId = &#63;.
	*
	* @param towerId the tower ID
	* @param organizationId the organization ID
	* @return the number of matching tower customer maps
	*/
	public int countByT_O(long towerId, long organizationId);

	/**
	* Caches the tower customer map in the entity cache if it is enabled.
	*
	* @param towerCustomerMap the tower customer map
	*/
	public void cacheResult(TowerCustomerMap towerCustomerMap);

	/**
	* Caches the tower customer maps in the entity cache if it is enabled.
	*
	* @param towerCustomerMaps the tower customer maps
	*/
	public void cacheResult(java.util.List<TowerCustomerMap> towerCustomerMaps);

	/**
	* Creates a new tower customer map with the primary key. Does not add the tower customer map to the database.
	*
	* @param towerCustomerId the primary key for the new tower customer map
	* @return the new tower customer map
	*/
	public TowerCustomerMap create(long towerCustomerId);

	/**
	* Removes the tower customer map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param towerCustomerId the primary key of the tower customer map
	* @return the tower customer map that was removed
	* @throws NoSuchTowerCustomerMapException if a tower customer map with the primary key could not be found
	*/
	public TowerCustomerMap remove(long towerCustomerId)
		throws NoSuchTowerCustomerMapException;

	public TowerCustomerMap updateImpl(TowerCustomerMap towerCustomerMap);

	/**
	* Returns the tower customer map with the primary key or throws a {@link NoSuchTowerCustomerMapException} if it could not be found.
	*
	* @param towerCustomerId the primary key of the tower customer map
	* @return the tower customer map
	* @throws NoSuchTowerCustomerMapException if a tower customer map with the primary key could not be found
	*/
	public TowerCustomerMap findByPrimaryKey(long towerCustomerId)
		throws NoSuchTowerCustomerMapException;

	/**
	* Returns the tower customer map with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param towerCustomerId the primary key of the tower customer map
	* @return the tower customer map, or <code>null</code> if a tower customer map with the primary key could not be found
	*/
	public TowerCustomerMap fetchByPrimaryKey(long towerCustomerId);

	@Override
	public java.util.Map<java.io.Serializable, TowerCustomerMap> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the tower customer maps.
	*
	* @return the tower customer maps
	*/
	public java.util.List<TowerCustomerMap> findAll();

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
	public java.util.List<TowerCustomerMap> findAll(int start, int end);

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
	public java.util.List<TowerCustomerMap> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TowerCustomerMap> orderByComparator);

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
	public java.util.List<TowerCustomerMap> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TowerCustomerMap> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the tower customer maps from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of tower customer maps.
	*
	* @return the number of tower customer maps
	*/
	public int countAll();
}