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
 * Provides the local service utility for TTechnologyCustomerMap. This utility wraps
 * {@link com.lti.itops.ipac.custcatmgmt.service.impl.TTechnologyCustomerMapLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author sunprabh
 * @see TTechnologyCustomerMapLocalService
 * @see com.lti.itops.ipac.custcatmgmt.service.base.TTechnologyCustomerMapLocalServiceBaseImpl
 * @see com.lti.itops.ipac.custcatmgmt.service.impl.TTechnologyCustomerMapLocalServiceImpl
 * @generated
 */
@ProviderType
public class TTechnologyCustomerMapLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.lti.itops.ipac.custcatmgmt.service.impl.TTechnologyCustomerMapLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the t technology customer map to the database. Also notifies the appropriate model listeners.
	*
	* @param tTechnologyCustomerMap the t technology customer map
	* @return the t technology customer map that was added
	*/
	public static com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap addTTechnologyCustomerMap(
		com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap tTechnologyCustomerMap) {
		return getService().addTTechnologyCustomerMap(tTechnologyCustomerMap);
	}

	public static com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap addTTechnologyCustomerMapping(
		long towerTechnologyId, long organizationId,
		java.util.Map<java.util.Locale, String> name, long companyId,
		long createdBy, int statusId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addTTechnologyCustomerMapping(towerTechnologyId,
			organizationId, name, companyId, createdBy, statusId);
	}

	/**
	* Creates a new t technology customer map with the primary key. Does not add the t technology customer map to the database.
	*
	* @param TTechnologyCustomerId the primary key for the new t technology customer map
	* @return the new t technology customer map
	*/
	public static com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap createTTechnologyCustomerMap(
		long TTechnologyCustomerId) {
		return getService().createTTechnologyCustomerMap(TTechnologyCustomerId);
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
	* Deletes the t technology customer map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param TTechnologyCustomerId the primary key of the t technology customer map
	* @return the t technology customer map that was removed
	* @throws PortalException if a t technology customer map with the primary key could not be found
	*/
	public static com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap deleteTTechnologyCustomerMap(
		long TTechnologyCustomerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteTTechnologyCustomerMap(TTechnologyCustomerId);
	}

	/**
	* Deletes the t technology customer map from the database. Also notifies the appropriate model listeners.
	*
	* @param tTechnologyCustomerMap the t technology customer map
	* @return the t technology customer map that was removed
	*/
	public static com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap deleteTTechnologyCustomerMap(
		com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap tTechnologyCustomerMap) {
		return getService().deleteTTechnologyCustomerMap(tTechnologyCustomerMap);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTechnologyCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTechnologyCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap editTTechnologyCustomerMapping(
		long TTechnologyCustomerId, long organizationId,
		java.util.Map<java.util.Locale, String> name, long modifiedBy,
		int statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .editTTechnologyCustomerMapping(TTechnologyCustomerId,
			organizationId, name, modifiedBy, statusId);
	}

	public static com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap fetchTTechnologyCustomerMap(
		long TTechnologyCustomerId) {
		return getService().fetchTTechnologyCustomerMap(TTechnologyCustomerId);
	}

	public static java.util.List<Long> findActiveTTechnologyCustomerTTechnologyIds(
		long[] towerTechnologyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findActiveTTechnologyCustomerTTechnologyIds(towerTechnologyId);
	}

	public static java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap> findByT_O(
		long towerTechnologyId, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByT_O(towerTechnologyId, organizationId);
	}

	public static com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap findByTowerTechnologyId(
		long towerTechnologyId, long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTechnologyCustomerMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByTowerTechnologyId(towerTechnologyId, organizationId);
	}

	public static com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap findByTTechnologyCustomerMapId(
		long TTechnologyCustomerId, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTechnologyCustomerMapException {
		return getService()
				   .findByTTechnologyCustomerMapId(TTechnologyCustomerId,
			organizationId);
	}

	public static long findTTechnologyCustomerId(long towerTechnologyId,
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTechnologyCustomerMapException {
		return getService()
				   .findTTechnologyCustomerId(towerTechnologyId, organizationId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap> getActiveTTechnologyCustomerMap(
		long tTechnologyCustomerId, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getActiveTTechnologyCustomerMap(tTechnologyCustomerId,
			organizationId);
	}

	public static java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap> getActiveTTechnologyCustomerMapByorganizationId(
		long organizationId, java.util.List<Long> towerTechnologyIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getActiveTTechnologyCustomerMapByorganizationId(organizationId,
			towerTechnologyIds);
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
	* Returns the t technology customer map with the primary key.
	*
	* @param TTechnologyCustomerId the primary key of the t technology customer map
	* @return the t technology customer map
	* @throws PortalException if a t technology customer map with the primary key could not be found
	*/
	public static com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap getTTechnologyCustomerMap(
		long TTechnologyCustomerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTTechnologyCustomerMap(TTechnologyCustomerId);
	}

	public static java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap> getTTechnologyCustomerMapByorganizationId(
		long organizationId, java.util.List<Long> towerTechnologyIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getTTechnologyCustomerMapByorganizationId(organizationId,
			towerTechnologyIds);
	}

	/**
	* Returns a range of all the t technology customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTechnologyCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of t technology customer maps
	* @param end the upper bound of the range of t technology customer maps (not inclusive)
	* @return the range of t technology customer maps
	*/
	public static java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap> getTTechnologyCustomerMaps(
		int start, int end) {
		return getService().getTTechnologyCustomerMaps(start, end);
	}

	/**
	* Returns the number of t technology customer maps.
	*
	* @return the number of t technology customer maps
	*/
	public static int getTTechnologyCustomerMapsCount() {
		return getService().getTTechnologyCustomerMapsCount();
	}

	public static java.util.List<Long> getUniqueTTIDsByTIDList(
		java.util.List<com.liferay.portal.kernel.model.Organization> projects,
		java.util.List<Long> towerIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUniqueTTIDsByTIDList(projects, towerIds);
	}

	/**
	* Updates the t technology customer map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tTechnologyCustomerMap the t technology customer map
	* @return the t technology customer map that was updated
	*/
	public static com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap updateTTechnologyCustomerMap(
		com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap tTechnologyCustomerMap) {
		return getService().updateTTechnologyCustomerMap(tTechnologyCustomerMap);
	}

	public static com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap updateTTechnologyCustomerMapping(
		long TTechnologyId, long organizationId, long modifiedBy, int statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateTTechnologyCustomerMapping(TTechnologyId,
			organizationId, modifiedBy, statusId);
	}

	public static TTechnologyCustomerMapLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TTechnologyCustomerMapLocalService, TTechnologyCustomerMapLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TTechnologyCustomerMapLocalService.class);

		ServiceTracker<TTechnologyCustomerMapLocalService, TTechnologyCustomerMapLocalService> serviceTracker =
			new ServiceTracker<TTechnologyCustomerMapLocalService, TTechnologyCustomerMapLocalService>(bundle.getBundleContext(),
				TTechnologyCustomerMapLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}