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

package com.lti.itops.ipac.custcatmgmt.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TTDPSPCustDecisionTaskTableLocalService}.
 *
 * @author sunprabh
 * @see TTDPSPCustDecisionTaskTableLocalService
 * @generated
 */
@ProviderType
public class TTDPSPCustDecisionTaskTableLocalServiceWrapper
	implements TTDPSPCustDecisionTaskTableLocalService,
		ServiceWrapper<TTDPSPCustDecisionTaskTableLocalService> {
	public TTDPSPCustDecisionTaskTableLocalServiceWrapper(
		TTDPSPCustDecisionTaskTableLocalService ttdpspCustDecisionTaskTableLocalService) {
		_ttdpspCustDecisionTaskTableLocalService = ttdpspCustDecisionTaskTableLocalService;
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable addTTDPSPCustDecisionTaskTable(
		long parentTTDPSPTaskCustomerId, long subTTDPSPTaskCustomerId,
		boolean condition, int order)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.exception.PortalException {
		return _ttdpspCustDecisionTaskTableLocalService.addTTDPSPCustDecisionTaskTable(parentTTDPSPTaskCustomerId,
			subTTDPSPTaskCustomerId, condition, order);
	}

	/**
	* Adds the ttdpsp cust decision task table to the database. Also notifies the appropriate model listeners.
	*
	* @param ttdpspCustDecisionTaskTable the ttdpsp cust decision task table
	* @return the ttdpsp cust decision task table that was added
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable addTTDPSPCustDecisionTaskTable(
		com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable) {
		return _ttdpspCustDecisionTaskTableLocalService.addTTDPSPCustDecisionTaskTable(ttdpspCustDecisionTaskTable);
	}

	/**
	* Creates a new ttdpsp cust decision task table with the primary key. Does not add the ttdpsp cust decision task table to the database.
	*
	* @param TTDPSPCustDecisionTaskTableId the primary key for the new ttdpsp cust decision task table
	* @return the new ttdpsp cust decision task table
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable createTTDPSPCustDecisionTaskTable(
		long TTDPSPCustDecisionTaskTableId) {
		return _ttdpspCustDecisionTaskTableLocalService.createTTDPSPCustDecisionTaskTable(TTDPSPCustDecisionTaskTableId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ttdpspCustDecisionTaskTableLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the ttdpsp cust decision task table with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param TTDPSPCustDecisionTaskTableId the primary key of the ttdpsp cust decision task table
	* @return the ttdpsp cust decision task table that was removed
	* @throws PortalException if a ttdpsp cust decision task table with the primary key could not be found
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable deleteTTDPSPCustDecisionTaskTable(
		long TTDPSPCustDecisionTaskTableId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ttdpspCustDecisionTaskTableLocalService.deleteTTDPSPCustDecisionTaskTable(TTDPSPCustDecisionTaskTableId);
	}

	/**
	* Deletes the ttdpsp cust decision task table from the database. Also notifies the appropriate model listeners.
	*
	* @param ttdpspCustDecisionTaskTable the ttdpsp cust decision task table
	* @return the ttdpsp cust decision task table that was removed
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable deleteTTDPSPCustDecisionTaskTable(
		com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable) {
		return _ttdpspCustDecisionTaskTableLocalService.deleteTTDPSPCustDecisionTaskTable(ttdpspCustDecisionTaskTable);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ttdpspCustDecisionTaskTableLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _ttdpspCustDecisionTaskTableLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _ttdpspCustDecisionTaskTableLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _ttdpspCustDecisionTaskTableLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _ttdpspCustDecisionTaskTableLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _ttdpspCustDecisionTaskTableLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable fetchTTDPSPCustDecisionTaskTable(
		long TTDPSPCustDecisionTaskTableId) {
		return _ttdpspCustDecisionTaskTableLocalService.fetchTTDPSPCustDecisionTaskTable(TTDPSPCustDecisionTaskTableId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _ttdpspCustDecisionTaskTableLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _ttdpspCustDecisionTaskTableLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _ttdpspCustDecisionTaskTableLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ttdpspCustDecisionTaskTableLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the ttdpsp cust decision task table with the primary key.
	*
	* @param TTDPSPCustDecisionTaskTableId the primary key of the ttdpsp cust decision task table
	* @return the ttdpsp cust decision task table
	* @throws PortalException if a ttdpsp cust decision task table with the primary key could not be found
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable getTTDPSPCustDecisionTaskTable(
		long TTDPSPCustDecisionTaskTableId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ttdpspCustDecisionTaskTableLocalService.getTTDPSPCustDecisionTaskTable(TTDPSPCustDecisionTaskTableId);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable getTTDPSPCustDecisionTaskTableBy(
		long parentTTDPSPTaskCustomerId, long subTTDPSPTaskCustomerId,
		boolean condition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttdpspCustDecisionTaskTableLocalService.getTTDPSPCustDecisionTaskTableBy(parentTTDPSPTaskCustomerId,
			subTTDPSPTaskCustomerId, condition);
	}

	/**
	* Returns a range of all the ttdpsp cust decision task tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ttdpsp cust decision task tables
	* @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	* @return the range of ttdpsp cust decision task tables
	*/
	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable> getTTDPSPCustDecisionTaskTables(
		int start, int end) {
		return _ttdpspCustDecisionTaskTableLocalService.getTTDPSPCustDecisionTaskTables(start,
			end);
	}

	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable> getTTDPSPCustDecisionTaskTablesBy(
		long parentTTDPSPTaskCustomerId, boolean condition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttdpspCustDecisionTaskTableLocalService.getTTDPSPCustDecisionTaskTablesBy(parentTTDPSPTaskCustomerId,
			condition);
	}

	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable> getTTDPSPCustDecisionTaskTablesByParentTTDPSPTaskCustId(
		long parentTTDPSPTaskCustomerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttdpspCustDecisionTaskTableLocalService.getTTDPSPCustDecisionTaskTablesByParentTTDPSPTaskCustId(parentTTDPSPTaskCustomerId);
	}

	/**
	* Returns the number of ttdpsp cust decision task tables.
	*
	* @return the number of ttdpsp cust decision task tables
	*/
	@Override
	public int getTTDPSPCustDecisionTaskTablesCount() {
		return _ttdpspCustDecisionTaskTableLocalService.getTTDPSPCustDecisionTaskTablesCount();
	}

	/**
	* Updates the ttdpsp cust decision task table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ttdpspCustDecisionTaskTable the ttdpsp cust decision task table
	* @return the ttdpsp cust decision task table that was updated
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable updateTTDPSPCustDecisionTaskTable(
		com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable) {
		return _ttdpspCustDecisionTaskTableLocalService.updateTTDPSPCustDecisionTaskTable(ttdpspCustDecisionTaskTable);
	}

	@Override
	public TTDPSPCustDecisionTaskTableLocalService getWrappedService() {
		return _ttdpspCustDecisionTaskTableLocalService;
	}

	@Override
	public void setWrappedService(
		TTDPSPCustDecisionTaskTableLocalService ttdpspCustDecisionTaskTableLocalService) {
		_ttdpspCustDecisionTaskTableLocalService = ttdpspCustDecisionTaskTableLocalService;
	}

	private TTDPSPCustDecisionTaskTableLocalService _ttdpspCustDecisionTaskTableLocalService;
}