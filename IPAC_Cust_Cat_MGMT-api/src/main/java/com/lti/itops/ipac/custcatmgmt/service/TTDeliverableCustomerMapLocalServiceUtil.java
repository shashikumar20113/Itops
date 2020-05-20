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
 * Provides the local service utility for TTDeliverableCustomerMap. This utility wraps
 * {@link com.lti.itops.ipac.custcatmgmt.service.impl.TTDeliverableCustomerMapLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author sunprabh
 * @see TTDeliverableCustomerMapLocalService
 * @see com.lti.itops.ipac.custcatmgmt.service.base.TTDeliverableCustomerMapLocalServiceBaseImpl
 * @see com.lti.itops.ipac.custcatmgmt.service.impl.TTDeliverableCustomerMapLocalServiceImpl
 * @generated
 */
@ProviderType
public class TTDeliverableCustomerMapLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.lti.itops.ipac.custcatmgmt.service.impl.TTDeliverableCustomerMapLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the tt deliverable customer map to the database. Also notifies the appropriate model listeners.
	*
	* @param ttDeliverableCustomerMap the tt deliverable customer map
	* @return the tt deliverable customer map that was added
	*/
	public static com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap addTTDeliverableCustomerMap(
		com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap ttDeliverableCustomerMap) {
		return getService().addTTDeliverableCustomerMap(ttDeliverableCustomerMap);
	}

	public static boolean addTTDeliverableCustomerMapping(
		long TTDeliverableId, long organizationId,
		java.util.Map<java.util.Locale, String> name, long companyId,
		long createdBy, int statusId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addTTDeliverableCustomerMapping(TTDeliverableId,
			organizationId, name, companyId, createdBy, statusId);
	}

	/**
	* Creates a new tt deliverable customer map with the primary key. Does not add the tt deliverable customer map to the database.
	*
	* @param TTDeliverableCustomerId the primary key for the new tt deliverable customer map
	* @return the new tt deliverable customer map
	*/
	public static com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap createTTDeliverableCustomerMap(
		long TTDeliverableCustomerId) {
		return getService()
				   .createTTDeliverableCustomerMap(TTDeliverableCustomerId);
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
	* Deletes the tt deliverable customer map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param TTDeliverableCustomerId the primary key of the tt deliverable customer map
	* @return the tt deliverable customer map that was removed
	* @throws PortalException if a tt deliverable customer map with the primary key could not be found
	*/
	public static com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap deleteTTDeliverableCustomerMap(
		long TTDeliverableCustomerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .deleteTTDeliverableCustomerMap(TTDeliverableCustomerId);
	}

	/**
	* Deletes the tt deliverable customer map from the database. Also notifies the appropriate model listeners.
	*
	* @param ttDeliverableCustomerMap the tt deliverable customer map
	* @return the tt deliverable customer map that was removed
	*/
	public static com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap deleteTTDeliverableCustomerMap(
		com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap ttDeliverableCustomerMap) {
		return getService()
				   .deleteTTDeliverableCustomerMap(ttDeliverableCustomerMap);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTDeliverableCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTDeliverableCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap editTTDeliverableCustomerMapping(
		long TTDeliverableCustomerId,
		java.util.Map<java.util.Locale, String> name, long modifiedBy,
		int statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .editTTDeliverableCustomerMapping(TTDeliverableCustomerId,
			name, modifiedBy, statusId);
	}

	public static com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap fetchTTDeliverableCustomerMap(
		long TTDeliverableCustomerId) {
		return getService()
				   .fetchTTDeliverableCustomerMap(TTDeliverableCustomerId);
	}

	public static java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap> findActiveTTDeliverableCustomerMap(
		java.util.List<Long> tTDeliverableIds, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findActiveTTDeliverableCustomerMap(tTDeliverableIds,
			organizationId);
	}

	public static com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap findByTTDeliverableId(
		long TTDeliverableId, long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDeliverableCustomerMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByTTDeliverableId(TTDeliverableId, organizationId);
	}

	public static java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap> findTTDeliverableCustomerMap(
		java.util.List<Long> tTDeliverableIds, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findTTDeliverableCustomerMap(tTDeliverableIds,
			organizationId);
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
	* Returns the tt deliverable customer map with the primary key.
	*
	* @param TTDeliverableCustomerId the primary key of the tt deliverable customer map
	* @return the tt deliverable customer map
	* @throws PortalException if a tt deliverable customer map with the primary key could not be found
	*/
	public static com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap getTTDeliverableCustomerMap(
		long TTDeliverableCustomerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTTDeliverableCustomerMap(TTDeliverableCustomerId);
	}

	/**
	* Returns a range of all the tt deliverable customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTDeliverableCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tt deliverable customer maps
	* @param end the upper bound of the range of tt deliverable customer maps (not inclusive)
	* @return the range of tt deliverable customer maps
	*/
	public static java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap> getTTDeliverableCustomerMaps(
		int start, int end) {
		return getService().getTTDeliverableCustomerMaps(start, end);
	}

	/**
	* Returns the number of tt deliverable customer maps.
	*
	* @return the number of tt deliverable customer maps
	*/
	public static int getTTDeliverableCustomerMapsCount() {
		return getService().getTTDeliverableCustomerMapsCount();
	}

	public static java.util.List<Long> getUniqueTTDIDsByTTIDList(
		java.util.List<com.liferay.portal.kernel.model.Organization> projects,
		java.util.List<Long> tTechnologyIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUniqueTTDIDsByTTIDList(projects, tTechnologyIds);
	}

	/**
	* Updates the tt deliverable customer map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ttDeliverableCustomerMap the tt deliverable customer map
	* @return the tt deliverable customer map that was updated
	*/
	public static com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap updateTTDeliverableCustomerMap(
		com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap ttDeliverableCustomerMap) {
		return getService()
				   .updateTTDeliverableCustomerMap(ttDeliverableCustomerMap);
	}

	public static com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap updateTTDeliverableCustomerMapping(
		long TTDeliverableId, long organizationId, long modifiedBy, int statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateTTDeliverableCustomerMapping(TTDeliverableId,
			organizationId, modifiedBy, statusId);
	}

	public static TTDeliverableCustomerMapLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TTDeliverableCustomerMapLocalService, TTDeliverableCustomerMapLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TTDeliverableCustomerMapLocalService.class);

		ServiceTracker<TTDeliverableCustomerMapLocalService, TTDeliverableCustomerMapLocalService> serviceTracker =
			new ServiceTracker<TTDeliverableCustomerMapLocalService, TTDeliverableCustomerMapLocalService>(bundle.getBundleContext(),
				TTDeliverableCustomerMapLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}