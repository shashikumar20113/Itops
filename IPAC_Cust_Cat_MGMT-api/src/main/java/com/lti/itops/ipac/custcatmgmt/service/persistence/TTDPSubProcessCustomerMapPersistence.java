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

import com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSubProcessCustomerMapException;
import com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap;

/**
 * The persistence interface for the ttdp sub process customer map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sunprabh
 * @see com.lti.itops.ipac.custcatmgmt.service.persistence.impl.TTDPSubProcessCustomerMapPersistenceImpl
 * @see TTDPSubProcessCustomerMapUtil
 * @generated
 */
@ProviderType
public interface TTDPSubProcessCustomerMapPersistence extends BasePersistence<TTDPSubProcessCustomerMap> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TTDPSubProcessCustomerMapUtil} to access the ttdp sub process customer map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the ttdp sub process customer maps where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching ttdp sub process customer maps
	*/
	public java.util.List<TTDPSubProcessCustomerMap> findByorganizationId(
		long organizationId);

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
	public java.util.List<TTDPSubProcessCustomerMap> findByorganizationId(
		long organizationId, int start, int end);

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
	public java.util.List<TTDPSubProcessCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator);

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
	public java.util.List<TTDPSubProcessCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first ttdp sub process customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ttdp sub process customer map
	* @throws NoSuchTTDPSubProcessCustomerMapException if a matching ttdp sub process customer map could not be found
	*/
	public TTDPSubProcessCustomerMap findByorganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator)
		throws NoSuchTTDPSubProcessCustomerMapException;

	/**
	* Returns the first ttdp sub process customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ttdp sub process customer map, or <code>null</code> if a matching ttdp sub process customer map could not be found
	*/
	public TTDPSubProcessCustomerMap fetchByorganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator);

	/**
	* Returns the last ttdp sub process customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ttdp sub process customer map
	* @throws NoSuchTTDPSubProcessCustomerMapException if a matching ttdp sub process customer map could not be found
	*/
	public TTDPSubProcessCustomerMap findByorganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator)
		throws NoSuchTTDPSubProcessCustomerMapException;

	/**
	* Returns the last ttdp sub process customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ttdp sub process customer map, or <code>null</code> if a matching ttdp sub process customer map could not be found
	*/
	public TTDPSubProcessCustomerMap fetchByorganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator);

	/**
	* Returns the ttdp sub process customer maps before and after the current ttdp sub process customer map in the ordered set where organizationId = &#63;.
	*
	* @param TTDPSubProcessCustomerId the primary key of the current ttdp sub process customer map
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ttdp sub process customer map
	* @throws NoSuchTTDPSubProcessCustomerMapException if a ttdp sub process customer map with the primary key could not be found
	*/
	public TTDPSubProcessCustomerMap[] findByorganizationId_PrevAndNext(
		long TTDPSubProcessCustomerId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator)
		throws NoSuchTTDPSubProcessCustomerMapException;

	/**
	* Removes all the ttdp sub process customer maps where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	*/
	public void removeByorganizationId(long organizationId);

	/**
	* Returns the number of ttdp sub process customer maps where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching ttdp sub process customer maps
	*/
	public int countByorganizationId(long organizationId);

	/**
	* Returns the ttdp sub process customer map where TTDPSubProcessId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDPSubProcessCustomerMapException} if it could not be found.
	*
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param organizationId the organization ID
	* @return the matching ttdp sub process customer map
	* @throws NoSuchTTDPSubProcessCustomerMapException if a matching ttdp sub process customer map could not be found
	*/
	public TTDPSubProcessCustomerMap findByTTDPSubProcessId(
		long TTDPSubProcessId, long organizationId)
		throws NoSuchTTDPSubProcessCustomerMapException;

	/**
	* Returns the ttdp sub process customer map where TTDPSubProcessId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param organizationId the organization ID
	* @return the matching ttdp sub process customer map, or <code>null</code> if a matching ttdp sub process customer map could not be found
	*/
	public TTDPSubProcessCustomerMap fetchByTTDPSubProcessId(
		long TTDPSubProcessId, long organizationId);

	/**
	* Returns the ttdp sub process customer map where TTDPSubProcessId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching ttdp sub process customer map, or <code>null</code> if a matching ttdp sub process customer map could not be found
	*/
	public TTDPSubProcessCustomerMap fetchByTTDPSubProcessId(
		long TTDPSubProcessId, long organizationId, boolean retrieveFromCache);

	/**
	* Removes the ttdp sub process customer map where TTDPSubProcessId = &#63; and organizationId = &#63; from the database.
	*
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param organizationId the organization ID
	* @return the ttdp sub process customer map that was removed
	*/
	public TTDPSubProcessCustomerMap removeByTTDPSubProcessId(
		long TTDPSubProcessId, long organizationId)
		throws NoSuchTTDPSubProcessCustomerMapException;

	/**
	* Returns the number of ttdp sub process customer maps where TTDPSubProcessId = &#63; and organizationId = &#63;.
	*
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param organizationId the organization ID
	* @return the number of matching ttdp sub process customer maps
	*/
	public int countByTTDPSubProcessId(long TTDPSubProcessId,
		long organizationId);

	/**
	* Returns the ttdp sub process customer map where TTDPSubProcessCustomerId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDPSubProcessCustomerMapException} if it could not be found.
	*
	* @param TTDPSubProcessCustomerId the ttdp sub process customer ID
	* @param organizationId the organization ID
	* @return the matching ttdp sub process customer map
	* @throws NoSuchTTDPSubProcessCustomerMapException if a matching ttdp sub process customer map could not be found
	*/
	public TTDPSubProcessCustomerMap findByTTDPSubProcessCustomerId(
		long TTDPSubProcessCustomerId, long organizationId)
		throws NoSuchTTDPSubProcessCustomerMapException;

	/**
	* Returns the ttdp sub process customer map where TTDPSubProcessCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param TTDPSubProcessCustomerId the ttdp sub process customer ID
	* @param organizationId the organization ID
	* @return the matching ttdp sub process customer map, or <code>null</code> if a matching ttdp sub process customer map could not be found
	*/
	public TTDPSubProcessCustomerMap fetchByTTDPSubProcessCustomerId(
		long TTDPSubProcessCustomerId, long organizationId);

	/**
	* Returns the ttdp sub process customer map where TTDPSubProcessCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param TTDPSubProcessCustomerId the ttdp sub process customer ID
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching ttdp sub process customer map, or <code>null</code> if a matching ttdp sub process customer map could not be found
	*/
	public TTDPSubProcessCustomerMap fetchByTTDPSubProcessCustomerId(
		long TTDPSubProcessCustomerId, long organizationId,
		boolean retrieveFromCache);

	/**
	* Removes the ttdp sub process customer map where TTDPSubProcessCustomerId = &#63; and organizationId = &#63; from the database.
	*
	* @param TTDPSubProcessCustomerId the ttdp sub process customer ID
	* @param organizationId the organization ID
	* @return the ttdp sub process customer map that was removed
	*/
	public TTDPSubProcessCustomerMap removeByTTDPSubProcessCustomerId(
		long TTDPSubProcessCustomerId, long organizationId)
		throws NoSuchTTDPSubProcessCustomerMapException;

	/**
	* Returns the number of ttdp sub process customer maps where TTDPSubProcessCustomerId = &#63; and organizationId = &#63;.
	*
	* @param TTDPSubProcessCustomerId the ttdp sub process customer ID
	* @param organizationId the organization ID
	* @return the number of matching ttdp sub process customer maps
	*/
	public int countByTTDPSubProcessCustomerId(long TTDPSubProcessCustomerId,
		long organizationId);

	/**
	* Returns the ttdp sub process customer map where organizationId = &#63; and TTDPSubProcessId = &#63; and statusId = &#63; or throws a {@link NoSuchTTDPSubProcessCustomerMapException} if it could not be found.
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param statusId the status ID
	* @return the matching ttdp sub process customer map
	* @throws NoSuchTTDPSubProcessCustomerMapException if a matching ttdp sub process customer map could not be found
	*/
	public TTDPSubProcessCustomerMap findBySubProcessCustomerMap(
		long organizationId, long TTDPSubProcessId, int statusId)
		throws NoSuchTTDPSubProcessCustomerMapException;

	/**
	* Returns the ttdp sub process customer map where organizationId = &#63; and TTDPSubProcessId = &#63; and statusId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param statusId the status ID
	* @return the matching ttdp sub process customer map, or <code>null</code> if a matching ttdp sub process customer map could not be found
	*/
	public TTDPSubProcessCustomerMap fetchBySubProcessCustomerMap(
		long organizationId, long TTDPSubProcessId, int statusId);

	/**
	* Returns the ttdp sub process customer map where organizationId = &#63; and TTDPSubProcessId = &#63; and statusId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param statusId the status ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching ttdp sub process customer map, or <code>null</code> if a matching ttdp sub process customer map could not be found
	*/
	public TTDPSubProcessCustomerMap fetchBySubProcessCustomerMap(
		long organizationId, long TTDPSubProcessId, int statusId,
		boolean retrieveFromCache);

	/**
	* Removes the ttdp sub process customer map where organizationId = &#63; and TTDPSubProcessId = &#63; and statusId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param statusId the status ID
	* @return the ttdp sub process customer map that was removed
	*/
	public TTDPSubProcessCustomerMap removeBySubProcessCustomerMap(
		long organizationId, long TTDPSubProcessId, int statusId)
		throws NoSuchTTDPSubProcessCustomerMapException;

	/**
	* Returns the number of ttdp sub process customer maps where organizationId = &#63; and TTDPSubProcessId = &#63; and statusId = &#63;.
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param statusId the status ID
	* @return the number of matching ttdp sub process customer maps
	*/
	public int countBySubProcessCustomerMap(long organizationId,
		long TTDPSubProcessId, int statusId);

	/**
	* Caches the ttdp sub process customer map in the entity cache if it is enabled.
	*
	* @param ttdpSubProcessCustomerMap the ttdp sub process customer map
	*/
	public void cacheResult(TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap);

	/**
	* Caches the ttdp sub process customer maps in the entity cache if it is enabled.
	*
	* @param ttdpSubProcessCustomerMaps the ttdp sub process customer maps
	*/
	public void cacheResult(
		java.util.List<TTDPSubProcessCustomerMap> ttdpSubProcessCustomerMaps);

	/**
	* Creates a new ttdp sub process customer map with the primary key. Does not add the ttdp sub process customer map to the database.
	*
	* @param TTDPSubProcessCustomerId the primary key for the new ttdp sub process customer map
	* @return the new ttdp sub process customer map
	*/
	public TTDPSubProcessCustomerMap create(long TTDPSubProcessCustomerId);

	/**
	* Removes the ttdp sub process customer map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param TTDPSubProcessCustomerId the primary key of the ttdp sub process customer map
	* @return the ttdp sub process customer map that was removed
	* @throws NoSuchTTDPSubProcessCustomerMapException if a ttdp sub process customer map with the primary key could not be found
	*/
	public TTDPSubProcessCustomerMap remove(long TTDPSubProcessCustomerId)
		throws NoSuchTTDPSubProcessCustomerMapException;

	public TTDPSubProcessCustomerMap updateImpl(
		TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap);

	/**
	* Returns the ttdp sub process customer map with the primary key or throws a {@link NoSuchTTDPSubProcessCustomerMapException} if it could not be found.
	*
	* @param TTDPSubProcessCustomerId the primary key of the ttdp sub process customer map
	* @return the ttdp sub process customer map
	* @throws NoSuchTTDPSubProcessCustomerMapException if a ttdp sub process customer map with the primary key could not be found
	*/
	public TTDPSubProcessCustomerMap findByPrimaryKey(
		long TTDPSubProcessCustomerId)
		throws NoSuchTTDPSubProcessCustomerMapException;

	/**
	* Returns the ttdp sub process customer map with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param TTDPSubProcessCustomerId the primary key of the ttdp sub process customer map
	* @return the ttdp sub process customer map, or <code>null</code> if a ttdp sub process customer map with the primary key could not be found
	*/
	public TTDPSubProcessCustomerMap fetchByPrimaryKey(
		long TTDPSubProcessCustomerId);

	@Override
	public java.util.Map<java.io.Serializable, TTDPSubProcessCustomerMap> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the ttdp sub process customer maps.
	*
	* @return the ttdp sub process customer maps
	*/
	public java.util.List<TTDPSubProcessCustomerMap> findAll();

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
	public java.util.List<TTDPSubProcessCustomerMap> findAll(int start, int end);

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
	public java.util.List<TTDPSubProcessCustomerMap> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator);

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
	public java.util.List<TTDPSubProcessCustomerMap> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the ttdp sub process customer maps from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of ttdp sub process customer maps.
	*
	* @return the number of ttdp sub process customer maps
	*/
	public int countAll();
}