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

import com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTechnologyCustomerMapException;
import com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap;

/**
 * The persistence interface for the t technology customer map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sunprabh
 * @see com.lti.itops.ipac.custcatmgmt.service.persistence.impl.TTechnologyCustomerMapPersistenceImpl
 * @see TTechnologyCustomerMapUtil
 * @generated
 */
@ProviderType
public interface TTechnologyCustomerMapPersistence extends BasePersistence<TTechnologyCustomerMap> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TTechnologyCustomerMapUtil} to access the t technology customer map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the t technology customer maps where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching t technology customer maps
	*/
	public java.util.List<TTechnologyCustomerMap> findByorganizationId(
		long organizationId);

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
	public java.util.List<TTechnologyCustomerMap> findByorganizationId(
		long organizationId, int start, int end);

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
	public java.util.List<TTechnologyCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTechnologyCustomerMap> orderByComparator);

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
	public java.util.List<TTechnologyCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTechnologyCustomerMap> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first t technology customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t technology customer map
	* @throws NoSuchTTechnologyCustomerMapException if a matching t technology customer map could not be found
	*/
	public TTechnologyCustomerMap findByorganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTechnologyCustomerMap> orderByComparator)
		throws NoSuchTTechnologyCustomerMapException;

	/**
	* Returns the first t technology customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t technology customer map, or <code>null</code> if a matching t technology customer map could not be found
	*/
	public TTechnologyCustomerMap fetchByorganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTechnologyCustomerMap> orderByComparator);

	/**
	* Returns the last t technology customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t technology customer map
	* @throws NoSuchTTechnologyCustomerMapException if a matching t technology customer map could not be found
	*/
	public TTechnologyCustomerMap findByorganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTechnologyCustomerMap> orderByComparator)
		throws NoSuchTTechnologyCustomerMapException;

	/**
	* Returns the last t technology customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t technology customer map, or <code>null</code> if a matching t technology customer map could not be found
	*/
	public TTechnologyCustomerMap fetchByorganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTechnologyCustomerMap> orderByComparator);

	/**
	* Returns the t technology customer maps before and after the current t technology customer map in the ordered set where organizationId = &#63;.
	*
	* @param TTechnologyCustomerId the primary key of the current t technology customer map
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t technology customer map
	* @throws NoSuchTTechnologyCustomerMapException if a t technology customer map with the primary key could not be found
	*/
	public TTechnologyCustomerMap[] findByorganizationId_PrevAndNext(
		long TTechnologyCustomerId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTechnologyCustomerMap> orderByComparator)
		throws NoSuchTTechnologyCustomerMapException;

	/**
	* Removes all the t technology customer maps where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	*/
	public void removeByorganizationId(long organizationId);

	/**
	* Returns the number of t technology customer maps where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching t technology customer maps
	*/
	public int countByorganizationId(long organizationId);

	/**
	* Returns all the t technology customer maps where towerTechnologyId = &#63; and organizationId = &#63;.
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @return the matching t technology customer maps
	*/
	public java.util.List<TTechnologyCustomerMap> findByT_O(
		long towerTechnologyId, long organizationId);

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
	public java.util.List<TTechnologyCustomerMap> findByT_O(
		long towerTechnologyId, long organizationId, int start, int end);

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
	public java.util.List<TTechnologyCustomerMap> findByT_O(
		long towerTechnologyId, long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTechnologyCustomerMap> orderByComparator);

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
	public java.util.List<TTechnologyCustomerMap> findByT_O(
		long towerTechnologyId, long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTechnologyCustomerMap> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first t technology customer map in the ordered set where towerTechnologyId = &#63; and organizationId = &#63;.
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t technology customer map
	* @throws NoSuchTTechnologyCustomerMapException if a matching t technology customer map could not be found
	*/
	public TTechnologyCustomerMap findByT_O_First(long towerTechnologyId,
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTechnologyCustomerMap> orderByComparator)
		throws NoSuchTTechnologyCustomerMapException;

	/**
	* Returns the first t technology customer map in the ordered set where towerTechnologyId = &#63; and organizationId = &#63;.
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t technology customer map, or <code>null</code> if a matching t technology customer map could not be found
	*/
	public TTechnologyCustomerMap fetchByT_O_First(long towerTechnologyId,
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTechnologyCustomerMap> orderByComparator);

	/**
	* Returns the last t technology customer map in the ordered set where towerTechnologyId = &#63; and organizationId = &#63;.
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t technology customer map
	* @throws NoSuchTTechnologyCustomerMapException if a matching t technology customer map could not be found
	*/
	public TTechnologyCustomerMap findByT_O_Last(long towerTechnologyId,
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTechnologyCustomerMap> orderByComparator)
		throws NoSuchTTechnologyCustomerMapException;

	/**
	* Returns the last t technology customer map in the ordered set where towerTechnologyId = &#63; and organizationId = &#63;.
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t technology customer map, or <code>null</code> if a matching t technology customer map could not be found
	*/
	public TTechnologyCustomerMap fetchByT_O_Last(long towerTechnologyId,
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTechnologyCustomerMap> orderByComparator);

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
	public TTechnologyCustomerMap[] findByT_O_PrevAndNext(
		long TTechnologyCustomerId, long towerTechnologyId,
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTechnologyCustomerMap> orderByComparator)
		throws NoSuchTTechnologyCustomerMapException;

	/**
	* Removes all the t technology customer maps where towerTechnologyId = &#63; and organizationId = &#63; from the database.
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	*/
	public void removeByT_O(long towerTechnologyId, long organizationId);

	/**
	* Returns the number of t technology customer maps where towerTechnologyId = &#63; and organizationId = &#63;.
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @return the number of matching t technology customer maps
	*/
	public int countByT_O(long towerTechnologyId, long organizationId);

	/**
	* Returns the t technology customer map where TTechnologyCustomerId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTechnologyCustomerMapException} if it could not be found.
	*
	* @param TTechnologyCustomerId the t technology customer ID
	* @param organizationId the organization ID
	* @return the matching t technology customer map
	* @throws NoSuchTTechnologyCustomerMapException if a matching t technology customer map could not be found
	*/
	public TTechnologyCustomerMap findByTTechnologyCustomerId(
		long TTechnologyCustomerId, long organizationId)
		throws NoSuchTTechnologyCustomerMapException;

	/**
	* Returns the t technology customer map where TTechnologyCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param TTechnologyCustomerId the t technology customer ID
	* @param organizationId the organization ID
	* @return the matching t technology customer map, or <code>null</code> if a matching t technology customer map could not be found
	*/
	public TTechnologyCustomerMap fetchByTTechnologyCustomerId(
		long TTechnologyCustomerId, long organizationId);

	/**
	* Returns the t technology customer map where TTechnologyCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param TTechnologyCustomerId the t technology customer ID
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching t technology customer map, or <code>null</code> if a matching t technology customer map could not be found
	*/
	public TTechnologyCustomerMap fetchByTTechnologyCustomerId(
		long TTechnologyCustomerId, long organizationId,
		boolean retrieveFromCache);

	/**
	* Removes the t technology customer map where TTechnologyCustomerId = &#63; and organizationId = &#63; from the database.
	*
	* @param TTechnologyCustomerId the t technology customer ID
	* @param organizationId the organization ID
	* @return the t technology customer map that was removed
	*/
	public TTechnologyCustomerMap removeByTTechnologyCustomerId(
		long TTechnologyCustomerId, long organizationId)
		throws NoSuchTTechnologyCustomerMapException;

	/**
	* Returns the number of t technology customer maps where TTechnologyCustomerId = &#63; and organizationId = &#63;.
	*
	* @param TTechnologyCustomerId the t technology customer ID
	* @param organizationId the organization ID
	* @return the number of matching t technology customer maps
	*/
	public int countByTTechnologyCustomerId(long TTechnologyCustomerId,
		long organizationId);

	/**
	* Returns the t technology customer map where towerTechnologyId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTechnologyCustomerMapException} if it could not be found.
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @return the matching t technology customer map
	* @throws NoSuchTTechnologyCustomerMapException if a matching t technology customer map could not be found
	*/
	public TTechnologyCustomerMap findByTowerTechnologyId(
		long towerTechnologyId, long organizationId)
		throws NoSuchTTechnologyCustomerMapException;

	/**
	* Returns the t technology customer map where towerTechnologyId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @return the matching t technology customer map, or <code>null</code> if a matching t technology customer map could not be found
	*/
	public TTechnologyCustomerMap fetchByTowerTechnologyId(
		long towerTechnologyId, long organizationId);

	/**
	* Returns the t technology customer map where towerTechnologyId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching t technology customer map, or <code>null</code> if a matching t technology customer map could not be found
	*/
	public TTechnologyCustomerMap fetchByTowerTechnologyId(
		long towerTechnologyId, long organizationId, boolean retrieveFromCache);

	/**
	* Removes the t technology customer map where towerTechnologyId = &#63; and organizationId = &#63; from the database.
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @return the t technology customer map that was removed
	*/
	public TTechnologyCustomerMap removeByTowerTechnologyId(
		long towerTechnologyId, long organizationId)
		throws NoSuchTTechnologyCustomerMapException;

	/**
	* Returns the number of t technology customer maps where towerTechnologyId = &#63; and organizationId = &#63;.
	*
	* @param towerTechnologyId the tower technology ID
	* @param organizationId the organization ID
	* @return the number of matching t technology customer maps
	*/
	public int countByTowerTechnologyId(long towerTechnologyId,
		long organizationId);

	/**
	* Caches the t technology customer map in the entity cache if it is enabled.
	*
	* @param tTechnologyCustomerMap the t technology customer map
	*/
	public void cacheResult(TTechnologyCustomerMap tTechnologyCustomerMap);

	/**
	* Caches the t technology customer maps in the entity cache if it is enabled.
	*
	* @param tTechnologyCustomerMaps the t technology customer maps
	*/
	public void cacheResult(
		java.util.List<TTechnologyCustomerMap> tTechnologyCustomerMaps);

	/**
	* Creates a new t technology customer map with the primary key. Does not add the t technology customer map to the database.
	*
	* @param TTechnologyCustomerId the primary key for the new t technology customer map
	* @return the new t technology customer map
	*/
	public TTechnologyCustomerMap create(long TTechnologyCustomerId);

	/**
	* Removes the t technology customer map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param TTechnologyCustomerId the primary key of the t technology customer map
	* @return the t technology customer map that was removed
	* @throws NoSuchTTechnologyCustomerMapException if a t technology customer map with the primary key could not be found
	*/
	public TTechnologyCustomerMap remove(long TTechnologyCustomerId)
		throws NoSuchTTechnologyCustomerMapException;

	public TTechnologyCustomerMap updateImpl(
		TTechnologyCustomerMap tTechnologyCustomerMap);

	/**
	* Returns the t technology customer map with the primary key or throws a {@link NoSuchTTechnologyCustomerMapException} if it could not be found.
	*
	* @param TTechnologyCustomerId the primary key of the t technology customer map
	* @return the t technology customer map
	* @throws NoSuchTTechnologyCustomerMapException if a t technology customer map with the primary key could not be found
	*/
	public TTechnologyCustomerMap findByPrimaryKey(long TTechnologyCustomerId)
		throws NoSuchTTechnologyCustomerMapException;

	/**
	* Returns the t technology customer map with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param TTechnologyCustomerId the primary key of the t technology customer map
	* @return the t technology customer map, or <code>null</code> if a t technology customer map with the primary key could not be found
	*/
	public TTechnologyCustomerMap fetchByPrimaryKey(long TTechnologyCustomerId);

	@Override
	public java.util.Map<java.io.Serializable, TTechnologyCustomerMap> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the t technology customer maps.
	*
	* @return the t technology customer maps
	*/
	public java.util.List<TTechnologyCustomerMap> findAll();

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
	public java.util.List<TTechnologyCustomerMap> findAll(int start, int end);

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
	public java.util.List<TTechnologyCustomerMap> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTechnologyCustomerMap> orderByComparator);

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
	public java.util.List<TTechnologyCustomerMap> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTechnologyCustomerMap> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the t technology customer maps from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of t technology customer maps.
	*
	* @return the number of t technology customer maps
	*/
	public int countAll();
}