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
 * Provides the local service utility for TTDProcessCustomerMap. This utility wraps
 * {@link com.lti.itops.ipac.custcatmgmt.service.impl.TTDProcessCustomerMapLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author sunprabh
 * @see TTDProcessCustomerMapLocalService
 * @see com.lti.itops.ipac.custcatmgmt.service.base.TTDProcessCustomerMapLocalServiceBaseImpl
 * @see com.lti.itops.ipac.custcatmgmt.service.impl.TTDProcessCustomerMapLocalServiceImpl
 * @generated
 */
@ProviderType
public class TTDProcessCustomerMapLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.lti.itops.ipac.custcatmgmt.service.impl.TTDProcessCustomerMapLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the ttd process customer map to the database. Also notifies the appropriate model listeners.
	*
	* @param ttdProcessCustomerMap the ttd process customer map
	* @return the ttd process customer map that was added
	*/
	public static com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap addTTDProcessCustomerMap(
		com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap ttdProcessCustomerMap) {
		return getService().addTTDProcessCustomerMap(ttdProcessCustomerMap);
	}

	public static com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap addTTDProcessCustomerMapping(
		long TTDProcessId, long organizationId,
		java.util.Map<java.util.Locale, String> name, long companyId,
		long createdBy, int statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addTTDProcessCustomerMapping(TTDProcessId, organizationId,
			name, companyId, createdBy, statusId);
	}

	/**
	* Creates a new ttd process customer map with the primary key. Does not add the ttd process customer map to the database.
	*
	* @param TTDProcessCustomerId the primary key for the new ttd process customer map
	* @return the new ttd process customer map
	*/
	public static com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap createTTDProcessCustomerMap(
		long TTDProcessCustomerId) {
		return getService().createTTDProcessCustomerMap(TTDProcessCustomerId);
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
	* Deletes the ttd process customer map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param TTDProcessCustomerId the primary key of the ttd process customer map
	* @return the ttd process customer map that was removed
	* @throws PortalException if a ttd process customer map with the primary key could not be found
	*/
	public static com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap deleteTTDProcessCustomerMap(
		long TTDProcessCustomerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteTTDProcessCustomerMap(TTDProcessCustomerId);
	}

	/**
	* Deletes the ttd process customer map from the database. Also notifies the appropriate model listeners.
	*
	* @param ttdProcessCustomerMap the ttd process customer map
	* @return the ttd process customer map that was removed
	*/
	public static com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap deleteTTDProcessCustomerMap(
		com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap ttdProcessCustomerMap) {
		return getService().deleteTTDProcessCustomerMap(ttdProcessCustomerMap);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTDProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTDProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap editTTDProcessCustomerMapping(
		long TTDProcessIdCustomerId, long organizationId,
		java.util.Map<java.util.Locale, String> name, long companyId,
		long modifiedBy, int statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .editTTDProcessCustomerMapping(TTDProcessIdCustomerId,
			organizationId, name, companyId, modifiedBy, statusId);
	}

	public static com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap fetchTTDProcessCustomerMap(
		long TTDProcessCustomerId) {
		return getService().fetchTTDProcessCustomerMap(TTDProcessCustomerId);
	}

	public static java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap> findActiveTTDProcessCustomerMap(
		java.util.List<Long> tTDProcessIds, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findActiveTTDProcessCustomerMap(tTDProcessIds,
			organizationId);
	}

	public static com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap findByTTDProcessIdAndOrgId(
		long tTDProcessId, long organizationId, int statusId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDProcessCustomerMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByTTDProcessIdAndOrgId(tTDProcessId, organizationId,
			statusId);
	}

	public static java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap> findTTDProcessCustomerMap(
		java.util.List<Long> tTDProcessIds, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findTTDProcessCustomerMap(tTDProcessIds, organizationId);
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
	* Returns the ttd process customer map with the primary key.
	*
	* @param TTDProcessCustomerId the primary key of the ttd process customer map
	* @return the ttd process customer map
	* @throws PortalException if a ttd process customer map with the primary key could not be found
	*/
	public static com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap getTTDProcessCustomerMap(
		long TTDProcessCustomerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTTDProcessCustomerMap(TTDProcessCustomerId);
	}

	/**
	* Returns a range of all the ttd process customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTDProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ttd process customer maps
	* @param end the upper bound of the range of ttd process customer maps (not inclusive)
	* @return the range of ttd process customer maps
	*/
	public static java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap> getTTDProcessCustomerMaps(
		int start, int end) {
		return getService().getTTDProcessCustomerMaps(start, end);
	}

	/**
	* Returns the number of ttd process customer maps.
	*
	* @return the number of ttd process customer maps
	*/
	public static int getTTDProcessCustomerMapsCount() {
		return getService().getTTDProcessCustomerMapsCount();
	}

	public static java.util.List<Long> getUniqueTTDPIDsByTTDIDList(
		java.util.List<com.liferay.portal.kernel.model.Organization> projects,
		java.util.List<Long> ttDeliverableIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getUniqueTTDPIDsByTTDIDList(projects, ttDeliverableIds);
	}

	/**
	* Updates the ttd process customer map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ttdProcessCustomerMap the ttd process customer map
	* @return the ttd process customer map that was updated
	*/
	public static com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap updateTTDProcessCustomerMap(
		com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap ttdProcessCustomerMap) {
		return getService().updateTTDProcessCustomerMap(ttdProcessCustomerMap);
	}

	public static com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap updateTTDProcessCustomerMapping(
		long TTDProcessId, long organizationId, long modifiedBy, int statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateTTDProcessCustomerMapping(TTDProcessId,
			organizationId, modifiedBy, statusId);
	}

	public static TTDProcessCustomerMapLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TTDProcessCustomerMapLocalService, TTDProcessCustomerMapLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TTDProcessCustomerMapLocalService.class);

		ServiceTracker<TTDProcessCustomerMapLocalService, TTDProcessCustomerMapLocalService> serviceTracker =
			new ServiceTracker<TTDProcessCustomerMapLocalService, TTDProcessCustomerMapLocalService>(bundle.getBundleContext(),
				TTDProcessCustomerMapLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}