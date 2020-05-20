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

import com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPCustDecisionTaskTableException;
import com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable;

/**
 * The persistence interface for the ttdpsp cust decision task table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sunprabh
 * @see com.lti.itops.ipac.custcatmgmt.service.persistence.impl.TTDPSPCustDecisionTaskTablePersistenceImpl
 * @see TTDPSPCustDecisionTaskTableUtil
 * @generated
 */
@ProviderType
public interface TTDPSPCustDecisionTaskTablePersistence extends BasePersistence<TTDPSPCustDecisionTaskTable> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TTDPSPCustDecisionTaskTableUtil} to access the ttdpsp cust decision task table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @return the matching ttdpsp cust decision task tables
	*/
	public java.util.List<TTDPSPCustDecisionTaskTable> findByParentTTDPSPTaskCustomerId(
		long parentTTDPSPTaskCustomerId);

	/**
	* Returns a range of all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param start the lower bound of the range of ttdpsp cust decision task tables
	* @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	* @return the range of matching ttdpsp cust decision task tables
	*/
	public java.util.List<TTDPSPCustDecisionTaskTable> findByParentTTDPSPTaskCustomerId(
		long parentTTDPSPTaskCustomerId, int start, int end);

	/**
	* Returns an ordered range of all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param start the lower bound of the range of ttdpsp cust decision task tables
	* @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ttdpsp cust decision task tables
	*/
	public java.util.List<TTDPSPCustDecisionTaskTable> findByParentTTDPSPTaskCustomerId(
		long parentTTDPSPTaskCustomerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator);

	/**
	* Returns an ordered range of all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param start the lower bound of the range of ttdpsp cust decision task tables
	* @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching ttdpsp cust decision task tables
	*/
	public java.util.List<TTDPSPCustDecisionTaskTable> findByParentTTDPSPTaskCustomerId(
		long parentTTDPSPTaskCustomerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ttdpsp cust decision task table
	* @throws NoSuchTTDPSPCustDecisionTaskTableException if a matching ttdpsp cust decision task table could not be found
	*/
	public TTDPSPCustDecisionTaskTable findByParentTTDPSPTaskCustomerId_First(
		long parentTTDPSPTaskCustomerId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator)
		throws NoSuchTTDPSPCustDecisionTaskTableException;

	/**
	* Returns the first ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ttdpsp cust decision task table, or <code>null</code> if a matching ttdpsp cust decision task table could not be found
	*/
	public TTDPSPCustDecisionTaskTable fetchByParentTTDPSPTaskCustomerId_First(
		long parentTTDPSPTaskCustomerId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator);

	/**
	* Returns the last ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ttdpsp cust decision task table
	* @throws NoSuchTTDPSPCustDecisionTaskTableException if a matching ttdpsp cust decision task table could not be found
	*/
	public TTDPSPCustDecisionTaskTable findByParentTTDPSPTaskCustomerId_Last(
		long parentTTDPSPTaskCustomerId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator)
		throws NoSuchTTDPSPCustDecisionTaskTableException;

	/**
	* Returns the last ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ttdpsp cust decision task table, or <code>null</code> if a matching ttdpsp cust decision task table could not be found
	*/
	public TTDPSPCustDecisionTaskTable fetchByParentTTDPSPTaskCustomerId_Last(
		long parentTTDPSPTaskCustomerId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator);

	/**
	* Returns the ttdpsp cust decision task tables before and after the current ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63;.
	*
	* @param TTDPSPCustDecisionTaskTableId the primary key of the current ttdpsp cust decision task table
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ttdpsp cust decision task table
	* @throws NoSuchTTDPSPCustDecisionTaskTableException if a ttdpsp cust decision task table with the primary key could not be found
	*/
	public TTDPSPCustDecisionTaskTable[] findByParentTTDPSPTaskCustomerId_PrevAndNext(
		long TTDPSPCustDecisionTaskTableId, long parentTTDPSPTaskCustomerId,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator)
		throws NoSuchTTDPSPCustDecisionTaskTableException;

	/**
	* Removes all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63; from the database.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	*/
	public void removeByParentTTDPSPTaskCustomerId(
		long parentTTDPSPTaskCustomerId);

	/**
	* Returns the number of ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @return the number of matching ttdpsp cust decision task tables
	*/
	public int countByParentTTDPSPTaskCustomerId(
		long parentTTDPSPTaskCustomerId);

	/**
	* Returns the ttdpsp cust decision task table where parentTTDPSPTaskCustomerId = &#63; and subTTDPSPTaskCustomerId = &#63; and condition = &#63; or throws a {@link NoSuchTTDPSPCustDecisionTaskTableException} if it could not be found.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param subTTDPSPTaskCustomerId the sub ttdpsp task customer ID
	* @param condition the condition
	* @return the matching ttdpsp cust decision task table
	* @throws NoSuchTTDPSPCustDecisionTaskTableException if a matching ttdpsp cust decision task table could not be found
	*/
	public TTDPSPCustDecisionTaskTable findByTTDPSPCustDecisionTaskTable(
		long parentTTDPSPTaskCustomerId, long subTTDPSPTaskCustomerId,
		boolean condition) throws NoSuchTTDPSPCustDecisionTaskTableException;

	/**
	* Returns the ttdpsp cust decision task table where parentTTDPSPTaskCustomerId = &#63; and subTTDPSPTaskCustomerId = &#63; and condition = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param subTTDPSPTaskCustomerId the sub ttdpsp task customer ID
	* @param condition the condition
	* @return the matching ttdpsp cust decision task table, or <code>null</code> if a matching ttdpsp cust decision task table could not be found
	*/
	public TTDPSPCustDecisionTaskTable fetchByTTDPSPCustDecisionTaskTable(
		long parentTTDPSPTaskCustomerId, long subTTDPSPTaskCustomerId,
		boolean condition);

	/**
	* Returns the ttdpsp cust decision task table where parentTTDPSPTaskCustomerId = &#63; and subTTDPSPTaskCustomerId = &#63; and condition = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param subTTDPSPTaskCustomerId the sub ttdpsp task customer ID
	* @param condition the condition
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching ttdpsp cust decision task table, or <code>null</code> if a matching ttdpsp cust decision task table could not be found
	*/
	public TTDPSPCustDecisionTaskTable fetchByTTDPSPCustDecisionTaskTable(
		long parentTTDPSPTaskCustomerId, long subTTDPSPTaskCustomerId,
		boolean condition, boolean retrieveFromCache);

	/**
	* Removes the ttdpsp cust decision task table where parentTTDPSPTaskCustomerId = &#63; and subTTDPSPTaskCustomerId = &#63; and condition = &#63; from the database.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param subTTDPSPTaskCustomerId the sub ttdpsp task customer ID
	* @param condition the condition
	* @return the ttdpsp cust decision task table that was removed
	*/
	public TTDPSPCustDecisionTaskTable removeByTTDPSPCustDecisionTaskTable(
		long parentTTDPSPTaskCustomerId, long subTTDPSPTaskCustomerId,
		boolean condition) throws NoSuchTTDPSPCustDecisionTaskTableException;

	/**
	* Returns the number of ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63; and subTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param subTTDPSPTaskCustomerId the sub ttdpsp task customer ID
	* @param condition the condition
	* @return the number of matching ttdpsp cust decision task tables
	*/
	public int countByTTDPSPCustDecisionTaskTable(
		long parentTTDPSPTaskCustomerId, long subTTDPSPTaskCustomerId,
		boolean condition);

	/**
	* Returns all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param condition the condition
	* @return the matching ttdpsp cust decision task tables
	*/
	public java.util.List<TTDPSPCustDecisionTaskTable> findByParentTTDPSPTaskCustomerIdAndCondition(
		long parentTTDPSPTaskCustomerId, boolean condition);

	/**
	* Returns a range of all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param condition the condition
	* @param start the lower bound of the range of ttdpsp cust decision task tables
	* @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	* @return the range of matching ttdpsp cust decision task tables
	*/
	public java.util.List<TTDPSPCustDecisionTaskTable> findByParentTTDPSPTaskCustomerIdAndCondition(
		long parentTTDPSPTaskCustomerId, boolean condition, int start, int end);

	/**
	* Returns an ordered range of all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param condition the condition
	* @param start the lower bound of the range of ttdpsp cust decision task tables
	* @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ttdpsp cust decision task tables
	*/
	public java.util.List<TTDPSPCustDecisionTaskTable> findByParentTTDPSPTaskCustomerIdAndCondition(
		long parentTTDPSPTaskCustomerId, boolean condition, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator);

	/**
	* Returns an ordered range of all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param condition the condition
	* @param start the lower bound of the range of ttdpsp cust decision task tables
	* @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching ttdpsp cust decision task tables
	*/
	public java.util.List<TTDPSPCustDecisionTaskTable> findByParentTTDPSPTaskCustomerIdAndCondition(
		long parentTTDPSPTaskCustomerId, boolean condition, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param condition the condition
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ttdpsp cust decision task table
	* @throws NoSuchTTDPSPCustDecisionTaskTableException if a matching ttdpsp cust decision task table could not be found
	*/
	public TTDPSPCustDecisionTaskTable findByParentTTDPSPTaskCustomerIdAndCondition_First(
		long parentTTDPSPTaskCustomerId, boolean condition,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator)
		throws NoSuchTTDPSPCustDecisionTaskTableException;

	/**
	* Returns the first ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param condition the condition
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ttdpsp cust decision task table, or <code>null</code> if a matching ttdpsp cust decision task table could not be found
	*/
	public TTDPSPCustDecisionTaskTable fetchByParentTTDPSPTaskCustomerIdAndCondition_First(
		long parentTTDPSPTaskCustomerId, boolean condition,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator);

	/**
	* Returns the last ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param condition the condition
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ttdpsp cust decision task table
	* @throws NoSuchTTDPSPCustDecisionTaskTableException if a matching ttdpsp cust decision task table could not be found
	*/
	public TTDPSPCustDecisionTaskTable findByParentTTDPSPTaskCustomerIdAndCondition_Last(
		long parentTTDPSPTaskCustomerId, boolean condition,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator)
		throws NoSuchTTDPSPCustDecisionTaskTableException;

	/**
	* Returns the last ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param condition the condition
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ttdpsp cust decision task table, or <code>null</code> if a matching ttdpsp cust decision task table could not be found
	*/
	public TTDPSPCustDecisionTaskTable fetchByParentTTDPSPTaskCustomerIdAndCondition_Last(
		long parentTTDPSPTaskCustomerId, boolean condition,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator);

	/**
	* Returns the ttdpsp cust decision task tables before and after the current ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	*
	* @param TTDPSPCustDecisionTaskTableId the primary key of the current ttdpsp cust decision task table
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param condition the condition
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ttdpsp cust decision task table
	* @throws NoSuchTTDPSPCustDecisionTaskTableException if a ttdpsp cust decision task table with the primary key could not be found
	*/
	public TTDPSPCustDecisionTaskTable[] findByParentTTDPSPTaskCustomerIdAndCondition_PrevAndNext(
		long TTDPSPCustDecisionTaskTableId, long parentTTDPSPTaskCustomerId,
		boolean condition,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator)
		throws NoSuchTTDPSPCustDecisionTaskTableException;

	/**
	* Removes all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63; and condition = &#63; from the database.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param condition the condition
	*/
	public void removeByParentTTDPSPTaskCustomerIdAndCondition(
		long parentTTDPSPTaskCustomerId, boolean condition);

	/**
	* Returns the number of ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	* @param condition the condition
	* @return the number of matching ttdpsp cust decision task tables
	*/
	public int countByParentTTDPSPTaskCustomerIdAndCondition(
		long parentTTDPSPTaskCustomerId, boolean condition);

	/**
	* Caches the ttdpsp cust decision task table in the entity cache if it is enabled.
	*
	* @param ttdpspCustDecisionTaskTable the ttdpsp cust decision task table
	*/
	public void cacheResult(
		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable);

	/**
	* Caches the ttdpsp cust decision task tables in the entity cache if it is enabled.
	*
	* @param ttdpspCustDecisionTaskTables the ttdpsp cust decision task tables
	*/
	public void cacheResult(
		java.util.List<TTDPSPCustDecisionTaskTable> ttdpspCustDecisionTaskTables);

	/**
	* Creates a new ttdpsp cust decision task table with the primary key. Does not add the ttdpsp cust decision task table to the database.
	*
	* @param TTDPSPCustDecisionTaskTableId the primary key for the new ttdpsp cust decision task table
	* @return the new ttdpsp cust decision task table
	*/
	public TTDPSPCustDecisionTaskTable create(
		long TTDPSPCustDecisionTaskTableId);

	/**
	* Removes the ttdpsp cust decision task table with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param TTDPSPCustDecisionTaskTableId the primary key of the ttdpsp cust decision task table
	* @return the ttdpsp cust decision task table that was removed
	* @throws NoSuchTTDPSPCustDecisionTaskTableException if a ttdpsp cust decision task table with the primary key could not be found
	*/
	public TTDPSPCustDecisionTaskTable remove(
		long TTDPSPCustDecisionTaskTableId)
		throws NoSuchTTDPSPCustDecisionTaskTableException;

	public TTDPSPCustDecisionTaskTable updateImpl(
		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable);

	/**
	* Returns the ttdpsp cust decision task table with the primary key or throws a {@link NoSuchTTDPSPCustDecisionTaskTableException} if it could not be found.
	*
	* @param TTDPSPCustDecisionTaskTableId the primary key of the ttdpsp cust decision task table
	* @return the ttdpsp cust decision task table
	* @throws NoSuchTTDPSPCustDecisionTaskTableException if a ttdpsp cust decision task table with the primary key could not be found
	*/
	public TTDPSPCustDecisionTaskTable findByPrimaryKey(
		long TTDPSPCustDecisionTaskTableId)
		throws NoSuchTTDPSPCustDecisionTaskTableException;

	/**
	* Returns the ttdpsp cust decision task table with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param TTDPSPCustDecisionTaskTableId the primary key of the ttdpsp cust decision task table
	* @return the ttdpsp cust decision task table, or <code>null</code> if a ttdpsp cust decision task table with the primary key could not be found
	*/
	public TTDPSPCustDecisionTaskTable fetchByPrimaryKey(
		long TTDPSPCustDecisionTaskTableId);

	@Override
	public java.util.Map<java.io.Serializable, TTDPSPCustDecisionTaskTable> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the ttdpsp cust decision task tables.
	*
	* @return the ttdpsp cust decision task tables
	*/
	public java.util.List<TTDPSPCustDecisionTaskTable> findAll();

	/**
	* Returns a range of all the ttdpsp cust decision task tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ttdpsp cust decision task tables
	* @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	* @return the range of ttdpsp cust decision task tables
	*/
	public java.util.List<TTDPSPCustDecisionTaskTable> findAll(int start,
		int end);

	/**
	* Returns an ordered range of all the ttdpsp cust decision task tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ttdpsp cust decision task tables
	* @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ttdpsp cust decision task tables
	*/
	public java.util.List<TTDPSPCustDecisionTaskTable> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator);

	/**
	* Returns an ordered range of all the ttdpsp cust decision task tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ttdpsp cust decision task tables
	* @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of ttdpsp cust decision task tables
	*/
	public java.util.List<TTDPSPCustDecisionTaskTable> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the ttdpsp cust decision task tables from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of ttdpsp cust decision task tables.
	*
	* @return the number of ttdpsp cust decision task tables
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}