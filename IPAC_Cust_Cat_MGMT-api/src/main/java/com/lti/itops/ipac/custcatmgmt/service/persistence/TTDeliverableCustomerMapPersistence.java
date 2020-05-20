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

import com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDeliverableCustomerMapException;
import com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap;

/**
 * The persistence interface for the tt deliverable customer map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sunprabh
 * @see com.lti.itops.ipac.custcatmgmt.service.persistence.impl.TTDeliverableCustomerMapPersistenceImpl
 * @see TTDeliverableCustomerMapUtil
 * @generated
 */
@ProviderType
public interface TTDeliverableCustomerMapPersistence extends BasePersistence<TTDeliverableCustomerMap> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TTDeliverableCustomerMapUtil} to access the tt deliverable customer map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the tt deliverable customer maps where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching tt deliverable customer maps
	*/
	public java.util.List<TTDeliverableCustomerMap> findByorganizationId(
		long organizationId);

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
	public java.util.List<TTDeliverableCustomerMap> findByorganizationId(
		long organizationId, int start, int end);

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
	public java.util.List<TTDeliverableCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTDeliverableCustomerMap> orderByComparator);

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
	public java.util.List<TTDeliverableCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTDeliverableCustomerMap> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first tt deliverable customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tt deliverable customer map
	* @throws NoSuchTTDeliverableCustomerMapException if a matching tt deliverable customer map could not be found
	*/
	public TTDeliverableCustomerMap findByorganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDeliverableCustomerMap> orderByComparator)
		throws NoSuchTTDeliverableCustomerMapException;

	/**
	* Returns the first tt deliverable customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tt deliverable customer map, or <code>null</code> if a matching tt deliverable customer map could not be found
	*/
	public TTDeliverableCustomerMap fetchByorganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDeliverableCustomerMap> orderByComparator);

	/**
	* Returns the last tt deliverable customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tt deliverable customer map
	* @throws NoSuchTTDeliverableCustomerMapException if a matching tt deliverable customer map could not be found
	*/
	public TTDeliverableCustomerMap findByorganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDeliverableCustomerMap> orderByComparator)
		throws NoSuchTTDeliverableCustomerMapException;

	/**
	* Returns the last tt deliverable customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tt deliverable customer map, or <code>null</code> if a matching tt deliverable customer map could not be found
	*/
	public TTDeliverableCustomerMap fetchByorganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDeliverableCustomerMap> orderByComparator);

	/**
	* Returns the tt deliverable customer maps before and after the current tt deliverable customer map in the ordered set where organizationId = &#63;.
	*
	* @param TTDeliverableCustomerId the primary key of the current tt deliverable customer map
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tt deliverable customer map
	* @throws NoSuchTTDeliverableCustomerMapException if a tt deliverable customer map with the primary key could not be found
	*/
	public TTDeliverableCustomerMap[] findByorganizationId_PrevAndNext(
		long TTDeliverableCustomerId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDeliverableCustomerMap> orderByComparator)
		throws NoSuchTTDeliverableCustomerMapException;

	/**
	* Removes all the tt deliverable customer maps where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	*/
	public void removeByorganizationId(long organizationId);

	/**
	* Returns the number of tt deliverable customer maps where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching tt deliverable customer maps
	*/
	public int countByorganizationId(long organizationId);

	/**
	* Returns the tt deliverable customer map where TTDeliverableId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDeliverableCustomerMapException} if it could not be found.
	*
	* @param TTDeliverableId the tt deliverable ID
	* @param organizationId the organization ID
	* @return the matching tt deliverable customer map
	* @throws NoSuchTTDeliverableCustomerMapException if a matching tt deliverable customer map could not be found
	*/
	public TTDeliverableCustomerMap findByTTDeliverableId(
		long TTDeliverableId, long organizationId)
		throws NoSuchTTDeliverableCustomerMapException;

	/**
	* Returns the tt deliverable customer map where TTDeliverableId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param TTDeliverableId the tt deliverable ID
	* @param organizationId the organization ID
	* @return the matching tt deliverable customer map, or <code>null</code> if a matching tt deliverable customer map could not be found
	*/
	public TTDeliverableCustomerMap fetchByTTDeliverableId(
		long TTDeliverableId, long organizationId);

	/**
	* Returns the tt deliverable customer map where TTDeliverableId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param TTDeliverableId the tt deliverable ID
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching tt deliverable customer map, or <code>null</code> if a matching tt deliverable customer map could not be found
	*/
	public TTDeliverableCustomerMap fetchByTTDeliverableId(
		long TTDeliverableId, long organizationId, boolean retrieveFromCache);

	/**
	* Removes the tt deliverable customer map where TTDeliverableId = &#63; and organizationId = &#63; from the database.
	*
	* @param TTDeliverableId the tt deliverable ID
	* @param organizationId the organization ID
	* @return the tt deliverable customer map that was removed
	*/
	public TTDeliverableCustomerMap removeByTTDeliverableId(
		long TTDeliverableId, long organizationId)
		throws NoSuchTTDeliverableCustomerMapException;

	/**
	* Returns the number of tt deliverable customer maps where TTDeliverableId = &#63; and organizationId = &#63;.
	*
	* @param TTDeliverableId the tt deliverable ID
	* @param organizationId the organization ID
	* @return the number of matching tt deliverable customer maps
	*/
	public int countByTTDeliverableId(long TTDeliverableId, long organizationId);

	/**
	* Returns the tt deliverable customer map where TTDeliverableCustomerId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDeliverableCustomerMapException} if it could not be found.
	*
	* @param TTDeliverableCustomerId the tt deliverable customer ID
	* @param organizationId the organization ID
	* @return the matching tt deliverable customer map
	* @throws NoSuchTTDeliverableCustomerMapException if a matching tt deliverable customer map could not be found
	*/
	public TTDeliverableCustomerMap findByTTDeliverableCustomerId(
		long TTDeliverableCustomerId, long organizationId)
		throws NoSuchTTDeliverableCustomerMapException;

	/**
	* Returns the tt deliverable customer map where TTDeliverableCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param TTDeliverableCustomerId the tt deliverable customer ID
	* @param organizationId the organization ID
	* @return the matching tt deliverable customer map, or <code>null</code> if a matching tt deliverable customer map could not be found
	*/
	public TTDeliverableCustomerMap fetchByTTDeliverableCustomerId(
		long TTDeliverableCustomerId, long organizationId);

	/**
	* Returns the tt deliverable customer map where TTDeliverableCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param TTDeliverableCustomerId the tt deliverable customer ID
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching tt deliverable customer map, or <code>null</code> if a matching tt deliverable customer map could not be found
	*/
	public TTDeliverableCustomerMap fetchByTTDeliverableCustomerId(
		long TTDeliverableCustomerId, long organizationId,
		boolean retrieveFromCache);

	/**
	* Removes the tt deliverable customer map where TTDeliverableCustomerId = &#63; and organizationId = &#63; from the database.
	*
	* @param TTDeliverableCustomerId the tt deliverable customer ID
	* @param organizationId the organization ID
	* @return the tt deliverable customer map that was removed
	*/
	public TTDeliverableCustomerMap removeByTTDeliverableCustomerId(
		long TTDeliverableCustomerId, long organizationId)
		throws NoSuchTTDeliverableCustomerMapException;

	/**
	* Returns the number of tt deliverable customer maps where TTDeliverableCustomerId = &#63; and organizationId = &#63;.
	*
	* @param TTDeliverableCustomerId the tt deliverable customer ID
	* @param organizationId the organization ID
	* @return the number of matching tt deliverable customer maps
	*/
	public int countByTTDeliverableCustomerId(long TTDeliverableCustomerId,
		long organizationId);

	/**
	* Caches the tt deliverable customer map in the entity cache if it is enabled.
	*
	* @param ttDeliverableCustomerMap the tt deliverable customer map
	*/
	public void cacheResult(TTDeliverableCustomerMap ttDeliverableCustomerMap);

	/**
	* Caches the tt deliverable customer maps in the entity cache if it is enabled.
	*
	* @param ttDeliverableCustomerMaps the tt deliverable customer maps
	*/
	public void cacheResult(
		java.util.List<TTDeliverableCustomerMap> ttDeliverableCustomerMaps);

	/**
	* Creates a new tt deliverable customer map with the primary key. Does not add the tt deliverable customer map to the database.
	*
	* @param TTDeliverableCustomerId the primary key for the new tt deliverable customer map
	* @return the new tt deliverable customer map
	*/
	public TTDeliverableCustomerMap create(long TTDeliverableCustomerId);

	/**
	* Removes the tt deliverable customer map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param TTDeliverableCustomerId the primary key of the tt deliverable customer map
	* @return the tt deliverable customer map that was removed
	* @throws NoSuchTTDeliverableCustomerMapException if a tt deliverable customer map with the primary key could not be found
	*/
	public TTDeliverableCustomerMap remove(long TTDeliverableCustomerId)
		throws NoSuchTTDeliverableCustomerMapException;

	public TTDeliverableCustomerMap updateImpl(
		TTDeliverableCustomerMap ttDeliverableCustomerMap);

	/**
	* Returns the tt deliverable customer map with the primary key or throws a {@link NoSuchTTDeliverableCustomerMapException} if it could not be found.
	*
	* @param TTDeliverableCustomerId the primary key of the tt deliverable customer map
	* @return the tt deliverable customer map
	* @throws NoSuchTTDeliverableCustomerMapException if a tt deliverable customer map with the primary key could not be found
	*/
	public TTDeliverableCustomerMap findByPrimaryKey(
		long TTDeliverableCustomerId)
		throws NoSuchTTDeliverableCustomerMapException;

	/**
	* Returns the tt deliverable customer map with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param TTDeliverableCustomerId the primary key of the tt deliverable customer map
	* @return the tt deliverable customer map, or <code>null</code> if a tt deliverable customer map with the primary key could not be found
	*/
	public TTDeliverableCustomerMap fetchByPrimaryKey(
		long TTDeliverableCustomerId);

	@Override
	public java.util.Map<java.io.Serializable, TTDeliverableCustomerMap> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the tt deliverable customer maps.
	*
	* @return the tt deliverable customer maps
	*/
	public java.util.List<TTDeliverableCustomerMap> findAll();

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
	public java.util.List<TTDeliverableCustomerMap> findAll(int start, int end);

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
	public java.util.List<TTDeliverableCustomerMap> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTDeliverableCustomerMap> orderByComparator);

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
	public java.util.List<TTDeliverableCustomerMap> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTDeliverableCustomerMap> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the tt deliverable customer maps from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of tt deliverable customer maps.
	*
	* @return the number of tt deliverable customer maps
	*/
	public int countAll();
}