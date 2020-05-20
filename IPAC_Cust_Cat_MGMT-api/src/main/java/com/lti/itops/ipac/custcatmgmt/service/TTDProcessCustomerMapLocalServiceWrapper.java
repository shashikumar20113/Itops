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
 * Provides a wrapper for {@link TTDProcessCustomerMapLocalService}.
 *
 * @author sunprabh
 * @see TTDProcessCustomerMapLocalService
 * @generated
 */
@ProviderType
public class TTDProcessCustomerMapLocalServiceWrapper
	implements TTDProcessCustomerMapLocalService,
		ServiceWrapper<TTDProcessCustomerMapLocalService> {
	public TTDProcessCustomerMapLocalServiceWrapper(
		TTDProcessCustomerMapLocalService ttdProcessCustomerMapLocalService) {
		_ttdProcessCustomerMapLocalService = ttdProcessCustomerMapLocalService;
	}

	/**
	* Adds the ttd process customer map to the database. Also notifies the appropriate model listeners.
	*
	* @param ttdProcessCustomerMap the ttd process customer map
	* @return the ttd process customer map that was added
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap addTTDProcessCustomerMap(
		com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap ttdProcessCustomerMap) {
		return _ttdProcessCustomerMapLocalService.addTTDProcessCustomerMap(ttdProcessCustomerMap);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap addTTDProcessCustomerMapping(
		long TTDProcessId, long organizationId,
		java.util.Map<java.util.Locale, String> name, long companyId,
		long createdBy, int statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ttdProcessCustomerMapLocalService.addTTDProcessCustomerMapping(TTDProcessId,
			organizationId, name, companyId, createdBy, statusId);
	}

	/**
	* Creates a new ttd process customer map with the primary key. Does not add the ttd process customer map to the database.
	*
	* @param TTDProcessCustomerId the primary key for the new ttd process customer map
	* @return the new ttd process customer map
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap createTTDProcessCustomerMap(
		long TTDProcessCustomerId) {
		return _ttdProcessCustomerMapLocalService.createTTDProcessCustomerMap(TTDProcessCustomerId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ttdProcessCustomerMapLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the ttd process customer map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param TTDProcessCustomerId the primary key of the ttd process customer map
	* @return the ttd process customer map that was removed
	* @throws PortalException if a ttd process customer map with the primary key could not be found
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap deleteTTDProcessCustomerMap(
		long TTDProcessCustomerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ttdProcessCustomerMapLocalService.deleteTTDProcessCustomerMap(TTDProcessCustomerId);
	}

	/**
	* Deletes the ttd process customer map from the database. Also notifies the appropriate model listeners.
	*
	* @param ttdProcessCustomerMap the ttd process customer map
	* @return the ttd process customer map that was removed
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap deleteTTDProcessCustomerMap(
		com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap ttdProcessCustomerMap) {
		return _ttdProcessCustomerMapLocalService.deleteTTDProcessCustomerMap(ttdProcessCustomerMap);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ttdProcessCustomerMapLocalService.dynamicQuery();
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
		return _ttdProcessCustomerMapLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _ttdProcessCustomerMapLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _ttdProcessCustomerMapLocalService.dynamicQuery(dynamicQuery,
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
		return _ttdProcessCustomerMapLocalService.dynamicQueryCount(dynamicQuery);
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
		return _ttdProcessCustomerMapLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap editTTDProcessCustomerMapping(
		long TTDProcessIdCustomerId, long organizationId,
		java.util.Map<java.util.Locale, String> name, long companyId,
		long modifiedBy, int statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ttdProcessCustomerMapLocalService.editTTDProcessCustomerMapping(TTDProcessIdCustomerId,
			organizationId, name, companyId, modifiedBy, statusId);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap fetchTTDProcessCustomerMap(
		long TTDProcessCustomerId) {
		return _ttdProcessCustomerMapLocalService.fetchTTDProcessCustomerMap(TTDProcessCustomerId);
	}

	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap> findActiveTTDProcessCustomerMap(
		java.util.List<Long> tTDProcessIds, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttdProcessCustomerMapLocalService.findActiveTTDProcessCustomerMap(tTDProcessIds,
			organizationId);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap findByTTDProcessIdAndOrgId(
		long tTDProcessId, long organizationId, int statusId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDProcessCustomerMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ttdProcessCustomerMapLocalService.findByTTDProcessIdAndOrgId(tTDProcessId,
			organizationId, statusId);
	}

	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap> findTTDProcessCustomerMap(
		java.util.List<Long> tTDProcessIds, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttdProcessCustomerMapLocalService.findTTDProcessCustomerMap(tTDProcessIds,
			organizationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _ttdProcessCustomerMapLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _ttdProcessCustomerMapLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _ttdProcessCustomerMapLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ttdProcessCustomerMapLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the ttd process customer map with the primary key.
	*
	* @param TTDProcessCustomerId the primary key of the ttd process customer map
	* @return the ttd process customer map
	* @throws PortalException if a ttd process customer map with the primary key could not be found
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap getTTDProcessCustomerMap(
		long TTDProcessCustomerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ttdProcessCustomerMapLocalService.getTTDProcessCustomerMap(TTDProcessCustomerId);
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
	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap> getTTDProcessCustomerMaps(
		int start, int end) {
		return _ttdProcessCustomerMapLocalService.getTTDProcessCustomerMaps(start,
			end);
	}

	/**
	* Returns the number of ttd process customer maps.
	*
	* @return the number of ttd process customer maps
	*/
	@Override
	public int getTTDProcessCustomerMapsCount() {
		return _ttdProcessCustomerMapLocalService.getTTDProcessCustomerMapsCount();
	}

	@Override
	public java.util.List<Long> getUniqueTTDPIDsByTTDIDList(
		java.util.List<com.liferay.portal.kernel.model.Organization> projects,
		java.util.List<Long> ttDeliverableIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttdProcessCustomerMapLocalService.getUniqueTTDPIDsByTTDIDList(projects,
			ttDeliverableIds);
	}

	/**
	* Updates the ttd process customer map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ttdProcessCustomerMap the ttd process customer map
	* @return the ttd process customer map that was updated
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap updateTTDProcessCustomerMap(
		com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap ttdProcessCustomerMap) {
		return _ttdProcessCustomerMapLocalService.updateTTDProcessCustomerMap(ttdProcessCustomerMap);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap updateTTDProcessCustomerMapping(
		long TTDProcessId, long organizationId, long modifiedBy, int statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ttdProcessCustomerMapLocalService.updateTTDProcessCustomerMapping(TTDProcessId,
			organizationId, modifiedBy, statusId);
	}

	@Override
	public TTDProcessCustomerMapLocalService getWrappedService() {
		return _ttdProcessCustomerMapLocalService;
	}

	@Override
	public void setWrappedService(
		TTDProcessCustomerMapLocalService ttdProcessCustomerMapLocalService) {
		_ttdProcessCustomerMapLocalService = ttdProcessCustomerMapLocalService;
	}

	private TTDProcessCustomerMapLocalService _ttdProcessCustomerMapLocalService;
}