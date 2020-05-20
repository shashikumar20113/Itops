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

import com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPTaskCustomerMapException;
import com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap;

/**
 * The persistence interface for the ttdpsp task customer map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sunprabh
 * @see com.lti.itops.ipac.custcatmgmt.service.persistence.impl.TTDPSPTaskCustomerMapPersistenceImpl
 * @see TTDPSPTaskCustomerMapUtil
 * @generated
 */
@ProviderType
public interface TTDPSPTaskCustomerMapPersistence extends BasePersistence<TTDPSPTaskCustomerMap> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TTDPSPTaskCustomerMapUtil} to access the ttdpsp task customer map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the ttdpsp task customer maps where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching ttdpsp task customer maps
	*/
	public java.util.List<TTDPSPTaskCustomerMap> findByorganizationId(
		long organizationId);

	/**
	* Returns a range of all the ttdpsp task customer maps where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of ttdpsp task customer maps
	* @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	* @return the range of matching ttdpsp task customer maps
	*/
	public java.util.List<TTDPSPTaskCustomerMap> findByorganizationId(
		long organizationId, int start, int end);

	/**
	* Returns an ordered range of all the ttdpsp task customer maps where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of ttdpsp task customer maps
	* @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ttdpsp task customer maps
	*/
	public java.util.List<TTDPSPTaskCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator);

	/**
	* Returns an ordered range of all the ttdpsp task customer maps where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of ttdpsp task customer maps
	* @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching ttdpsp task customer maps
	*/
	public java.util.List<TTDPSPTaskCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first ttdpsp task customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ttdpsp task customer map
	* @throws NoSuchTTDPSPTaskCustomerMapException if a matching ttdpsp task customer map could not be found
	*/
	public TTDPSPTaskCustomerMap findByorganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator)
		throws NoSuchTTDPSPTaskCustomerMapException;

	/**
	* Returns the first ttdpsp task customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	*/
	public TTDPSPTaskCustomerMap fetchByorganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator);

	/**
	* Returns the last ttdpsp task customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ttdpsp task customer map
	* @throws NoSuchTTDPSPTaskCustomerMapException if a matching ttdpsp task customer map could not be found
	*/
	public TTDPSPTaskCustomerMap findByorganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator)
		throws NoSuchTTDPSPTaskCustomerMapException;

	/**
	* Returns the last ttdpsp task customer map in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	*/
	public TTDPSPTaskCustomerMap fetchByorganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator);

	/**
	* Returns the ttdpsp task customer maps before and after the current ttdpsp task customer map in the ordered set where organizationId = &#63;.
	*
	* @param TTDPSPTaskCustomerId the primary key of the current ttdpsp task customer map
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ttdpsp task customer map
	* @throws NoSuchTTDPSPTaskCustomerMapException if a ttdpsp task customer map with the primary key could not be found
	*/
	public TTDPSPTaskCustomerMap[] findByorganizationId_PrevAndNext(
		long TTDPSPTaskCustomerId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator)
		throws NoSuchTTDPSPTaskCustomerMapException;

	/**
	* Removes all the ttdpsp task customer maps where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	*/
	public void removeByorganizationId(long organizationId);

	/**
	* Returns the number of ttdpsp task customer maps where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching ttdpsp task customer maps
	*/
	public int countByorganizationId(long organizationId);

	/**
	* Returns the ttdpsp task customer map where taskId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDPSPTaskCustomerMapException} if it could not be found.
	*
	* @param taskId the task ID
	* @param organizationId the organization ID
	* @return the matching ttdpsp task customer map
	* @throws NoSuchTTDPSPTaskCustomerMapException if a matching ttdpsp task customer map could not be found
	*/
	public TTDPSPTaskCustomerMap findBytaskId(long taskId, long organizationId)
		throws NoSuchTTDPSPTaskCustomerMapException;

	/**
	* Returns the ttdpsp task customer map where taskId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param taskId the task ID
	* @param organizationId the organization ID
	* @return the matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	*/
	public TTDPSPTaskCustomerMap fetchBytaskId(long taskId, long organizationId);

	/**
	* Returns the ttdpsp task customer map where taskId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param taskId the task ID
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	*/
	public TTDPSPTaskCustomerMap fetchBytaskId(long taskId,
		long organizationId, boolean retrieveFromCache);

	/**
	* Removes the ttdpsp task customer map where taskId = &#63; and organizationId = &#63; from the database.
	*
	* @param taskId the task ID
	* @param organizationId the organization ID
	* @return the ttdpsp task customer map that was removed
	*/
	public TTDPSPTaskCustomerMap removeBytaskId(long taskId, long organizationId)
		throws NoSuchTTDPSPTaskCustomerMapException;

	/**
	* Returns the number of ttdpsp task customer maps where taskId = &#63; and organizationId = &#63;.
	*
	* @param taskId the task ID
	* @param organizationId the organization ID
	* @return the number of matching ttdpsp task customer maps
	*/
	public int countBytaskId(long taskId, long organizationId);

	/**
	* Returns the ttdpsp task customer map where TTDPSPTaskCustomerId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDPSPTaskCustomerMapException} if it could not be found.
	*
	* @param TTDPSPTaskCustomerId the ttdpsp task customer ID
	* @param organizationId the organization ID
	* @return the matching ttdpsp task customer map
	* @throws NoSuchTTDPSPTaskCustomerMapException if a matching ttdpsp task customer map could not be found
	*/
	public TTDPSPTaskCustomerMap findByTTDPSPTaskCustomerId(
		long TTDPSPTaskCustomerId, long organizationId)
		throws NoSuchTTDPSPTaskCustomerMapException;

	/**
	* Returns the ttdpsp task customer map where TTDPSPTaskCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param TTDPSPTaskCustomerId the ttdpsp task customer ID
	* @param organizationId the organization ID
	* @return the matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	*/
	public TTDPSPTaskCustomerMap fetchByTTDPSPTaskCustomerId(
		long TTDPSPTaskCustomerId, long organizationId);

	/**
	* Returns the ttdpsp task customer map where TTDPSPTaskCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param TTDPSPTaskCustomerId the ttdpsp task customer ID
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	*/
	public TTDPSPTaskCustomerMap fetchByTTDPSPTaskCustomerId(
		long TTDPSPTaskCustomerId, long organizationId,
		boolean retrieveFromCache);

	/**
	* Removes the ttdpsp task customer map where TTDPSPTaskCustomerId = &#63; and organizationId = &#63; from the database.
	*
	* @param TTDPSPTaskCustomerId the ttdpsp task customer ID
	* @param organizationId the organization ID
	* @return the ttdpsp task customer map that was removed
	*/
	public TTDPSPTaskCustomerMap removeByTTDPSPTaskCustomerId(
		long TTDPSPTaskCustomerId, long organizationId)
		throws NoSuchTTDPSPTaskCustomerMapException;

	/**
	* Returns the number of ttdpsp task customer maps where TTDPSPTaskCustomerId = &#63; and organizationId = &#63;.
	*
	* @param TTDPSPTaskCustomerId the ttdpsp task customer ID
	* @param organizationId the organization ID
	* @return the number of matching ttdpsp task customer maps
	*/
	public int countByTTDPSPTaskCustomerId(long TTDPSPTaskCustomerId,
		long organizationId);

	/**
	* Returns all the ttdpsp task customer maps where organizationId = &#63; and TTDPSubProcessId = &#63;.
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @return the matching ttdpsp task customer maps
	*/
	public java.util.List<TTDPSPTaskCustomerMap> findByorgSubProcessId(
		long organizationId, long TTDPSubProcessId);

	/**
	* Returns a range of all the ttdpsp task customer maps where organizationId = &#63; and TTDPSubProcessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param start the lower bound of the range of ttdpsp task customer maps
	* @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	* @return the range of matching ttdpsp task customer maps
	*/
	public java.util.List<TTDPSPTaskCustomerMap> findByorgSubProcessId(
		long organizationId, long TTDPSubProcessId, int start, int end);

	/**
	* Returns an ordered range of all the ttdpsp task customer maps where organizationId = &#63; and TTDPSubProcessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param start the lower bound of the range of ttdpsp task customer maps
	* @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ttdpsp task customer maps
	*/
	public java.util.List<TTDPSPTaskCustomerMap> findByorgSubProcessId(
		long organizationId, long TTDPSubProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator);

	/**
	* Returns an ordered range of all the ttdpsp task customer maps where organizationId = &#63; and TTDPSubProcessId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param start the lower bound of the range of ttdpsp task customer maps
	* @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching ttdpsp task customer maps
	*/
	public java.util.List<TTDPSPTaskCustomerMap> findByorgSubProcessId(
		long organizationId, long TTDPSubProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first ttdpsp task customer map in the ordered set where organizationId = &#63; and TTDPSubProcessId = &#63;.
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ttdpsp task customer map
	* @throws NoSuchTTDPSPTaskCustomerMapException if a matching ttdpsp task customer map could not be found
	*/
	public TTDPSPTaskCustomerMap findByorgSubProcessId_First(
		long organizationId, long TTDPSubProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator)
		throws NoSuchTTDPSPTaskCustomerMapException;

	/**
	* Returns the first ttdpsp task customer map in the ordered set where organizationId = &#63; and TTDPSubProcessId = &#63;.
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	*/
	public TTDPSPTaskCustomerMap fetchByorgSubProcessId_First(
		long organizationId, long TTDPSubProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator);

	/**
	* Returns the last ttdpsp task customer map in the ordered set where organizationId = &#63; and TTDPSubProcessId = &#63;.
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ttdpsp task customer map
	* @throws NoSuchTTDPSPTaskCustomerMapException if a matching ttdpsp task customer map could not be found
	*/
	public TTDPSPTaskCustomerMap findByorgSubProcessId_Last(
		long organizationId, long TTDPSubProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator)
		throws NoSuchTTDPSPTaskCustomerMapException;

	/**
	* Returns the last ttdpsp task customer map in the ordered set where organizationId = &#63; and TTDPSubProcessId = &#63;.
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	*/
	public TTDPSPTaskCustomerMap fetchByorgSubProcessId_Last(
		long organizationId, long TTDPSubProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator);

	/**
	* Returns the ttdpsp task customer maps before and after the current ttdpsp task customer map in the ordered set where organizationId = &#63; and TTDPSubProcessId = &#63;.
	*
	* @param TTDPSPTaskCustomerId the primary key of the current ttdpsp task customer map
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ttdpsp task customer map
	* @throws NoSuchTTDPSPTaskCustomerMapException if a ttdpsp task customer map with the primary key could not be found
	*/
	public TTDPSPTaskCustomerMap[] findByorgSubProcessId_PrevAndNext(
		long TTDPSPTaskCustomerId, long organizationId, long TTDPSubProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator)
		throws NoSuchTTDPSPTaskCustomerMapException;

	/**
	* Removes all the ttdpsp task customer maps where organizationId = &#63; and TTDPSubProcessId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	*/
	public void removeByorgSubProcessId(long organizationId,
		long TTDPSubProcessId);

	/**
	* Returns the number of ttdpsp task customer maps where organizationId = &#63; and TTDPSubProcessId = &#63;.
	*
	* @param organizationId the organization ID
	* @param TTDPSubProcessId the ttdp sub process ID
	* @return the number of matching ttdpsp task customer maps
	*/
	public int countByorgSubProcessId(long organizationId, long TTDPSubProcessId);

	/**
	* Returns the ttdpsp task customer map where TTDPSubProcessId = &#63; and taskId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDPSPTaskCustomerMapException} if it could not be found.
	*
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param taskId the task ID
	* @param organizationId the organization ID
	* @return the matching ttdpsp task customer map
	* @throws NoSuchTTDPSPTaskCustomerMapException if a matching ttdpsp task customer map could not be found
	*/
	public TTDPSPTaskCustomerMap findByTTDPSPTaskCustomerMapBy(
		long TTDPSubProcessId, long taskId, long organizationId)
		throws NoSuchTTDPSPTaskCustomerMapException;

	/**
	* Returns the ttdpsp task customer map where TTDPSubProcessId = &#63; and taskId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param taskId the task ID
	* @param organizationId the organization ID
	* @return the matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	*/
	public TTDPSPTaskCustomerMap fetchByTTDPSPTaskCustomerMapBy(
		long TTDPSubProcessId, long taskId, long organizationId);

	/**
	* Returns the ttdpsp task customer map where TTDPSubProcessId = &#63; and taskId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param taskId the task ID
	* @param organizationId the organization ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	*/
	public TTDPSPTaskCustomerMap fetchByTTDPSPTaskCustomerMapBy(
		long TTDPSubProcessId, long taskId, long organizationId,
		boolean retrieveFromCache);

	/**
	* Removes the ttdpsp task customer map where TTDPSubProcessId = &#63; and taskId = &#63; and organizationId = &#63; from the database.
	*
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param taskId the task ID
	* @param organizationId the organization ID
	* @return the ttdpsp task customer map that was removed
	*/
	public TTDPSPTaskCustomerMap removeByTTDPSPTaskCustomerMapBy(
		long TTDPSubProcessId, long taskId, long organizationId)
		throws NoSuchTTDPSPTaskCustomerMapException;

	/**
	* Returns the number of ttdpsp task customer maps where TTDPSubProcessId = &#63; and taskId = &#63; and organizationId = &#63;.
	*
	* @param TTDPSubProcessId the ttdp sub process ID
	* @param taskId the task ID
	* @param organizationId the organization ID
	* @return the number of matching ttdpsp task customer maps
	*/
	public int countByTTDPSPTaskCustomerMapBy(long TTDPSubProcessId,
		long taskId, long organizationId);

	/**
	* Caches the ttdpsp task customer map in the entity cache if it is enabled.
	*
	* @param ttdpspTaskCustomerMap the ttdpsp task customer map
	*/
	public void cacheResult(TTDPSPTaskCustomerMap ttdpspTaskCustomerMap);

	/**
	* Caches the ttdpsp task customer maps in the entity cache if it is enabled.
	*
	* @param ttdpspTaskCustomerMaps the ttdpsp task customer maps
	*/
	public void cacheResult(
		java.util.List<TTDPSPTaskCustomerMap> ttdpspTaskCustomerMaps);

	/**
	* Creates a new ttdpsp task customer map with the primary key. Does not add the ttdpsp task customer map to the database.
	*
	* @param TTDPSPTaskCustomerId the primary key for the new ttdpsp task customer map
	* @return the new ttdpsp task customer map
	*/
	public TTDPSPTaskCustomerMap create(long TTDPSPTaskCustomerId);

	/**
	* Removes the ttdpsp task customer map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param TTDPSPTaskCustomerId the primary key of the ttdpsp task customer map
	* @return the ttdpsp task customer map that was removed
	* @throws NoSuchTTDPSPTaskCustomerMapException if a ttdpsp task customer map with the primary key could not be found
	*/
	public TTDPSPTaskCustomerMap remove(long TTDPSPTaskCustomerId)
		throws NoSuchTTDPSPTaskCustomerMapException;

	public TTDPSPTaskCustomerMap updateImpl(
		TTDPSPTaskCustomerMap ttdpspTaskCustomerMap);

	/**
	* Returns the ttdpsp task customer map with the primary key or throws a {@link NoSuchTTDPSPTaskCustomerMapException} if it could not be found.
	*
	* @param TTDPSPTaskCustomerId the primary key of the ttdpsp task customer map
	* @return the ttdpsp task customer map
	* @throws NoSuchTTDPSPTaskCustomerMapException if a ttdpsp task customer map with the primary key could not be found
	*/
	public TTDPSPTaskCustomerMap findByPrimaryKey(long TTDPSPTaskCustomerId)
		throws NoSuchTTDPSPTaskCustomerMapException;

	/**
	* Returns the ttdpsp task customer map with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param TTDPSPTaskCustomerId the primary key of the ttdpsp task customer map
	* @return the ttdpsp task customer map, or <code>null</code> if a ttdpsp task customer map with the primary key could not be found
	*/
	public TTDPSPTaskCustomerMap fetchByPrimaryKey(long TTDPSPTaskCustomerId);

	@Override
	public java.util.Map<java.io.Serializable, TTDPSPTaskCustomerMap> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the ttdpsp task customer maps.
	*
	* @return the ttdpsp task customer maps
	*/
	public java.util.List<TTDPSPTaskCustomerMap> findAll();

	/**
	* Returns a range of all the ttdpsp task customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ttdpsp task customer maps
	* @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	* @return the range of ttdpsp task customer maps
	*/
	public java.util.List<TTDPSPTaskCustomerMap> findAll(int start, int end);

	/**
	* Returns an ordered range of all the ttdpsp task customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ttdpsp task customer maps
	* @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ttdpsp task customer maps
	*/
	public java.util.List<TTDPSPTaskCustomerMap> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator);

	/**
	* Returns an ordered range of all the ttdpsp task customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ttdpsp task customer maps
	* @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of ttdpsp task customer maps
	*/
	public java.util.List<TTDPSPTaskCustomerMap> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the ttdpsp task customer maps from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of ttdpsp task customer maps.
	*
	* @return the number of ttdpsp task customer maps
	*/
	public int countAll();
}