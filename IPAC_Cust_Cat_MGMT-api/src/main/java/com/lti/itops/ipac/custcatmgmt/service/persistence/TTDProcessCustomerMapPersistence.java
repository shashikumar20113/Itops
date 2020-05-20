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

import com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDProcessCustomerMapException;
import com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap;

/**
 * The persistence interface for the ttd process customer map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sunprabh
 * @see com.lti.itops.ipac.custcatmgmt.service.persistence.impl.TTDProcessCustomerMapPersistenceImpl
 * @see TTDProcessCustomerMapUtil
 * @generated
 */
@ProviderType
public interface TTDProcessCustomerMapPersistence extends BasePersistence<TTDProcessCustomerMap> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TTDProcessCustomerMapUtil} to access the ttd process customer map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the ttd process customer maps where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching ttd process customer maps
	*/
	public java.util.List<TTDProcessCustomerMap> findByorganizationId(
		long organizationId);

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
	public java.util.List<TTDProcessCustomerMap> findByorganizationId(
		long organizationId, int start, int end);

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
	public java.util.List<TTDProcessCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTDProcessCustomerMap> orderByComparator);

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
	public java.util.List<TTDProcessCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTDProcessCustomerMap> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first ttd process customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ttd process customer map
	* @throws NoSuchTTDProcessCustomerMapException if a matching ttd process customer map could not be found
	*/
	public TTDProcessCustomerMap findByorganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDProcessCustomerMap> orderByComparator)
		throws NoSuchTTDProcessCustomerMapException;

	/**
	* Returns the first ttd process customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ttd process customer map, or <code>null</code> if a matching ttd process customer map could not be found
	*/
	public TTDProcessCustomerMap fetchByorganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDProcessCustomerMap> orderByComparator);

	/**
	* Returns the last ttd process customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ttd process customer map
	* @throws NoSuchTTDProcessCustomerMapException if a matching ttd process customer map could not be found
	*/
	public TTDProcessCustomerMap findByorganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDProcessCustomerMap> orderByComparator)
		throws NoSuchTTDProcessCustomerMapException;

	/**
	* Returns the last ttd process customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ttd process customer map, or <code>null</code> if a matching ttd process customer map could not be found
	*/
	public TTDProcessCustomerMap fetchByorganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDProcessCustomerMap> orderByComparator);

	/**
	* Returns the ttd process customer maps before and after the current ttd process customer map in the ordered set where organizationId = &#63;.
	*
	* @param TTDProcessCustomerId the primary key of the current ttd process customer map
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ttd process customer map
	* @throws NoSuchTTDProcessCustomerMapException if a ttd process customer map with the primary key could not be found
	*/
	public TTDProcessCustomerMap[] findByorganizationId_PrevAndNext(
		long TTDProcessCustomerId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDProcessCustomerMap> orderByComparator)
		throws NoSuchTTDProcessCustomerMapException;

	/**
	* Removes all the ttd process customer maps where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	*/
	public void removeByorganizationId(long organizationId);

	/**
	* Returns the number of ttd process customer maps where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching ttd process customer maps
	*/
	public int countByorganizationId(long organizationId);

	/**
	* Returns the ttd process customer map where TTDProcessId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDProcessCustomerMapException} if it could not be found.
	*
	* @param TTDProcessId the ttd process ID
	* @param organizationId the organization ID
	* @return the matching ttd process customer map
	* @throws NoSuchTTDProcessCustomerMapException if a matching ttd process customer map could not be found
	*/
	public TTDProcessCustomerMap findByTTDProcessId(long TTDProcessId,
		long organizationId) throws NoSuchTTDProcessCustomerMapException;

	/**
	* Returns the ttd process customer map where TTDProcessId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param TTDProcessId the ttd process ID
	* @param organizationId the organization ID
	* @return the matching ttd process customer map, or <code>null</code> if a matching ttd process customer map could not be found
	*/
	public TTDProcessCustomerMap fetchByTTDProcessId(long TTDProcessId,
		long organizationId);

	/**
	* Returns the ttd process customer map where TTDProcessId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param TTDProcessId the ttd process ID
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching ttd process customer map, or <code>null</code> if a matching ttd process customer map could not be found
	*/
	public TTDProcessCustomerMap fetchByTTDProcessId(long TTDProcessId,
		long organizationId, boolean retrieveFromCache);

	/**
	* Removes the ttd process customer map where TTDProcessId = &#63; and organizationId = &#63; from the database.
	*
	* @param TTDProcessId the ttd process ID
	* @param organizationId the organization ID
	* @return the ttd process customer map that was removed
	*/
	public TTDProcessCustomerMap removeByTTDProcessId(long TTDProcessId,
		long organizationId) throws NoSuchTTDProcessCustomerMapException;

	/**
	* Returns the number of ttd process customer maps where TTDProcessId = &#63; and organizationId = &#63;.
	*
	* @param TTDProcessId the ttd process ID
	* @param organizationId the organization ID
	* @return the number of matching ttd process customer maps
	*/
	public int countByTTDProcessId(long TTDProcessId, long organizationId);

	/**
	* Returns the ttd process customer map where TTDProcessCustomerId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDProcessCustomerMapException} if it could not be found.
	*
	* @param TTDProcessCustomerId the ttd process customer ID
	* @param organizationId the organization ID
	* @return the matching ttd process customer map
	* @throws NoSuchTTDProcessCustomerMapException if a matching ttd process customer map could not be found
	*/
	public TTDProcessCustomerMap findByTTDProcessCustomerId(
		long TTDProcessCustomerId, long organizationId)
		throws NoSuchTTDProcessCustomerMapException;

	/**
	* Returns the ttd process customer map where TTDProcessCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param TTDProcessCustomerId the ttd process customer ID
	* @param organizationId the organization ID
	* @return the matching ttd process customer map, or <code>null</code> if a matching ttd process customer map could not be found
	*/
	public TTDProcessCustomerMap fetchByTTDProcessCustomerId(
		long TTDProcessCustomerId, long organizationId);

	/**
	* Returns the ttd process customer map where TTDProcessCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param TTDProcessCustomerId the ttd process customer ID
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching ttd process customer map, or <code>null</code> if a matching ttd process customer map could not be found
	*/
	public TTDProcessCustomerMap fetchByTTDProcessCustomerId(
		long TTDProcessCustomerId, long organizationId,
		boolean retrieveFromCache);

	/**
	* Removes the ttd process customer map where TTDProcessCustomerId = &#63; and organizationId = &#63; from the database.
	*
	* @param TTDProcessCustomerId the ttd process customer ID
	* @param organizationId the organization ID
	* @return the ttd process customer map that was removed
	*/
	public TTDProcessCustomerMap removeByTTDProcessCustomerId(
		long TTDProcessCustomerId, long organizationId)
		throws NoSuchTTDProcessCustomerMapException;

	/**
	* Returns the number of ttd process customer maps where TTDProcessCustomerId = &#63; and organizationId = &#63;.
	*
	* @param TTDProcessCustomerId the ttd process customer ID
	* @param organizationId the organization ID
	* @return the number of matching ttd process customer maps
	*/
	public int countByTTDProcessCustomerId(long TTDProcessCustomerId,
		long organizationId);

	/**
	* Returns the ttd process customer map where organizationId = &#63; and TTDProcessId = &#63; and statusId = &#63; or throws a {@link NoSuchTTDProcessCustomerMapException} if it could not be found.
	*
	* @param organizationId the organization ID
	* @param TTDProcessId the ttd process ID
	* @param statusId the status ID
	* @return the matching ttd process customer map
	* @throws NoSuchTTDProcessCustomerMapException if a matching ttd process customer map could not be found
	*/
	public TTDProcessCustomerMap findByProcessCustomerMap(long organizationId,
		long TTDProcessId, int statusId)
		throws NoSuchTTDProcessCustomerMapException;

	/**
	* Returns the ttd process customer map where organizationId = &#63; and TTDProcessId = &#63; and statusId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param organizationId the organization ID
	* @param TTDProcessId the ttd process ID
	* @param statusId the status ID
	* @return the matching ttd process customer map, or <code>null</code> if a matching ttd process customer map could not be found
	*/
	public TTDProcessCustomerMap fetchByProcessCustomerMap(
		long organizationId, long TTDProcessId, int statusId);

	/**
	* Returns the ttd process customer map where organizationId = &#63; and TTDProcessId = &#63; and statusId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param organizationId the organization ID
	* @param TTDProcessId the ttd process ID
	* @param statusId the status ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching ttd process customer map, or <code>null</code> if a matching ttd process customer map could not be found
	*/
	public TTDProcessCustomerMap fetchByProcessCustomerMap(
		long organizationId, long TTDProcessId, int statusId,
		boolean retrieveFromCache);

	/**
	* Removes the ttd process customer map where organizationId = &#63; and TTDProcessId = &#63; and statusId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @param TTDProcessId the ttd process ID
	* @param statusId the status ID
	* @return the ttd process customer map that was removed
	*/
	public TTDProcessCustomerMap removeByProcessCustomerMap(
		long organizationId, long TTDProcessId, int statusId)
		throws NoSuchTTDProcessCustomerMapException;

	/**
	* Returns the number of ttd process customer maps where organizationId = &#63; and TTDProcessId = &#63; and statusId = &#63;.
	*
	* @param organizationId the organization ID
	* @param TTDProcessId the ttd process ID
	* @param statusId the status ID
	* @return the number of matching ttd process customer maps
	*/
	public int countByProcessCustomerMap(long organizationId,
		long TTDProcessId, int statusId);

	/**
	* Caches the ttd process customer map in the entity cache if it is enabled.
	*
	* @param ttdProcessCustomerMap the ttd process customer map
	*/
	public void cacheResult(TTDProcessCustomerMap ttdProcessCustomerMap);

	/**
	* Caches the ttd process customer maps in the entity cache if it is enabled.
	*
	* @param ttdProcessCustomerMaps the ttd process customer maps
	*/
	public void cacheResult(
		java.util.List<TTDProcessCustomerMap> ttdProcessCustomerMaps);

	/**
	* Creates a new ttd process customer map with the primary key. Does not add the ttd process customer map to the database.
	*
	* @param TTDProcessCustomerId the primary key for the new ttd process customer map
	* @return the new ttd process customer map
	*/
	public TTDProcessCustomerMap create(long TTDProcessCustomerId);

	/**
	* Removes the ttd process customer map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param TTDProcessCustomerId the primary key of the ttd process customer map
	* @return the ttd process customer map that was removed
	* @throws NoSuchTTDProcessCustomerMapException if a ttd process customer map with the primary key could not be found
	*/
	public TTDProcessCustomerMap remove(long TTDProcessCustomerId)
		throws NoSuchTTDProcessCustomerMapException;

	public TTDProcessCustomerMap updateImpl(
		TTDProcessCustomerMap ttdProcessCustomerMap);

	/**
	* Returns the ttd process customer map with the primary key or throws a {@link NoSuchTTDProcessCustomerMapException} if it could not be found.
	*
	* @param TTDProcessCustomerId the primary key of the ttd process customer map
	* @return the ttd process customer map
	* @throws NoSuchTTDProcessCustomerMapException if a ttd process customer map with the primary key could not be found
	*/
	public TTDProcessCustomerMap findByPrimaryKey(long TTDProcessCustomerId)
		throws NoSuchTTDProcessCustomerMapException;

	/**
	* Returns the ttd process customer map with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param TTDProcessCustomerId the primary key of the ttd process customer map
	* @return the ttd process customer map, or <code>null</code> if a ttd process customer map with the primary key could not be found
	*/
	public TTDProcessCustomerMap fetchByPrimaryKey(long TTDProcessCustomerId);

	@Override
	public java.util.Map<java.io.Serializable, TTDProcessCustomerMap> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the ttd process customer maps.
	*
	* @return the ttd process customer maps
	*/
	public java.util.List<TTDProcessCustomerMap> findAll();

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
	public java.util.List<TTDProcessCustomerMap> findAll(int start, int end);

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
	public java.util.List<TTDProcessCustomerMap> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTDProcessCustomerMap> orderByComparator);

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
	public java.util.List<TTDProcessCustomerMap> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTDProcessCustomerMap> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the ttd process customer maps from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of ttd process customer maps.
	*
	* @return the number of ttd process customer maps
	*/
	public int countAll();
}