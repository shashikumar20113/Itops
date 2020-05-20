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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for TTDPSPCustDecisionTaskTable. This utility wraps
 * {@link com.lti.itops.ipac.custcatmgmt.service.impl.TTDPSPCustDecisionTaskTableLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author sunprabh
 * @see TTDPSPCustDecisionTaskTableLocalService
 * @see com.lti.itops.ipac.custcatmgmt.service.base.TTDPSPCustDecisionTaskTableLocalServiceBaseImpl
 * @see com.lti.itops.ipac.custcatmgmt.service.impl.TTDPSPCustDecisionTaskTableLocalServiceImpl
 * @generated
 */
@ProviderType
public class TTDPSPCustDecisionTaskTableLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.lti.itops.ipac.custcatmgmt.service.impl.TTDPSPCustDecisionTaskTableLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable addTTDPSPCustDecisionTaskTable(
		long parentTTDPSPTaskCustomerId, long subTTDPSPTaskCustomerId,
		boolean condition, int order)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addTTDPSPCustDecisionTaskTable(parentTTDPSPTaskCustomerId,
			subTTDPSPTaskCustomerId, condition, order);
	}

	/**
	* Adds the ttdpsp cust decision task table to the database. Also notifies the appropriate model listeners.
	*
	* @param ttdpspCustDecisionTaskTable the ttdpsp cust decision task table
	* @return the ttdpsp cust decision task table that was added
	*/
	public static com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable addTTDPSPCustDecisionTaskTable(
		com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable) {
		return getService()
				   .addTTDPSPCustDecisionTaskTable(ttdpspCustDecisionTaskTable);
	}

	/**
	* Creates a new ttdpsp cust decision task table with the primary key. Does not add the ttdpsp cust decision task table to the database.
	*
	* @param TTDPSPCustDecisionTaskTableId the primary key for the new ttdpsp cust decision task table
	* @return the new ttdpsp cust decision task table
	*/
	public static com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable createTTDPSPCustDecisionTaskTable(
		long TTDPSPCustDecisionTaskTableId) {
		return getService()
				   .createTTDPSPCustDecisionTaskTable(TTDPSPCustDecisionTaskTableId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the ttdpsp cust decision task table with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param TTDPSPCustDecisionTaskTableId the primary key of the ttdpsp cust decision task table
	* @return the ttdpsp cust decision task table that was removed
	* @throws PortalException if a ttdpsp cust decision task table with the primary key could not be found
	*/
	public static com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable deleteTTDPSPCustDecisionTaskTable(
		long TTDPSPCustDecisionTaskTableId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .deleteTTDPSPCustDecisionTaskTable(TTDPSPCustDecisionTaskTableId);
	}

	/**
	* Deletes the ttdpsp cust decision task table from the database. Also notifies the appropriate model listeners.
	*
	* @param ttdpspCustDecisionTaskTable the ttdpsp cust decision task table
	* @return the ttdpsp cust decision task table that was removed
	*/
	public static com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable deleteTTDPSPCustDecisionTaskTable(
		com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable) {
		return getService()
				   .deleteTTDPSPCustDecisionTaskTable(ttdpspCustDecisionTaskTable);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable fetchTTDPSPCustDecisionTaskTable(
		long TTDPSPCustDecisionTaskTableId) {
		return getService()
				   .fetchTTDPSPCustDecisionTaskTable(TTDPSPCustDecisionTaskTableId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the ttdpsp cust decision task table with the primary key.
	*
	* @param TTDPSPCustDecisionTaskTableId the primary key of the ttdpsp cust decision task table
	* @return the ttdpsp cust decision task table
	* @throws PortalException if a ttdpsp cust decision task table with the primary key could not be found
	*/
	public static com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable getTTDPSPCustDecisionTaskTable(
		long TTDPSPCustDecisionTaskTableId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getTTDPSPCustDecisionTaskTable(TTDPSPCustDecisionTaskTableId);
	}

	public static com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable getTTDPSPCustDecisionTaskTableBy(
		long parentTTDPSPTaskCustomerId, long subTTDPSPTaskCustomerId,
		boolean condition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getTTDPSPCustDecisionTaskTableBy(parentTTDPSPTaskCustomerId,
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
	public static java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable> getTTDPSPCustDecisionTaskTables(
		int start, int end) {
		return getService().getTTDPSPCustDecisionTaskTables(start, end);
	}

	public static java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable> getTTDPSPCustDecisionTaskTablesBy(
		long parentTTDPSPTaskCustomerId, boolean condition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getTTDPSPCustDecisionTaskTablesBy(parentTTDPSPTaskCustomerId,
			condition);
	}

	public static java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable> getTTDPSPCustDecisionTaskTablesByParentTTDPSPTaskCustId(
		long parentTTDPSPTaskCustomerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getTTDPSPCustDecisionTaskTablesByParentTTDPSPTaskCustId(parentTTDPSPTaskCustomerId);
	}

	/**
	* Returns the number of ttdpsp cust decision task tables.
	*
	* @return the number of ttdpsp cust decision task tables
	*/
	public static int getTTDPSPCustDecisionTaskTablesCount() {
		return getService().getTTDPSPCustDecisionTaskTablesCount();
	}

	/**
	* Updates the ttdpsp cust decision task table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ttdpspCustDecisionTaskTable the ttdpsp cust decision task table
	* @return the ttdpsp cust decision task table that was updated
	*/
	public static com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable updateTTDPSPCustDecisionTaskTable(
		com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable) {
		return getService()
				   .updateTTDPSPCustDecisionTaskTable(ttdpspCustDecisionTaskTable);
	}

	public static TTDPSPCustDecisionTaskTableLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TTDPSPCustDecisionTaskTableLocalService, TTDPSPCustDecisionTaskTableLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TTDPSPCustDecisionTaskTableLocalService.class);

		ServiceTracker<TTDPSPCustDecisionTaskTableLocalService, TTDPSPCustDecisionTaskTableLocalService> serviceTracker =
			new ServiceTracker<TTDPSPCustDecisionTaskTableLocalService, TTDPSPCustDecisionTaskTableLocalService>(bundle.getBundleContext(),
				TTDPSPCustDecisionTaskTableLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}