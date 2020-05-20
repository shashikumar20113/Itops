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
 * Provides a wrapper for {@link TTDPSubProcessCustomerMapLocalService}.
 *
 * @author sunprabh
 * @see TTDPSubProcessCustomerMapLocalService
 * @generated
 */
@ProviderType
public class TTDPSubProcessCustomerMapLocalServiceWrapper
	implements TTDPSubProcessCustomerMapLocalService,
		ServiceWrapper<TTDPSubProcessCustomerMapLocalService> {
	public TTDPSubProcessCustomerMapLocalServiceWrapper(
		TTDPSubProcessCustomerMapLocalService ttdpSubProcessCustomerMapLocalService) {
		_ttdpSubProcessCustomerMapLocalService = ttdpSubProcessCustomerMapLocalService;
	}

	/**
	* Adds the ttdp sub process customer map to the database. Also notifies the appropriate model listeners.
	*
	* @param ttdpSubProcessCustomerMap the ttdp sub process customer map
	* @return the ttdp sub process customer map that was added
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap addTTDPSubProcessCustomerMap(
		com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap) {
		return _ttdpSubProcessCustomerMapLocalService.addTTDPSubProcessCustomerMap(ttdpSubProcessCustomerMap);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap addTTDPSubProcessCustomerMapping(
		long TTDPSubProcessId, long organizationId,
		java.util.Map<java.util.Locale, String> name, long companyId,
		long createdBy, int statusId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.exception.PortalException {
		return _ttdpSubProcessCustomerMapLocalService.addTTDPSubProcessCustomerMapping(TTDPSubProcessId,
			organizationId, name, companyId, createdBy, statusId);
	}

	/**
	* Creates a new ttdp sub process customer map with the primary key. Does not add the ttdp sub process customer map to the database.
	*
	* @param TTDPSubProcessCustomerId the primary key for the new ttdp sub process customer map
	* @return the new ttdp sub process customer map
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap createTTDPSubProcessCustomerMap(
		long TTDPSubProcessCustomerId) {
		return _ttdpSubProcessCustomerMapLocalService.createTTDPSubProcessCustomerMap(TTDPSubProcessCustomerId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ttdpSubProcessCustomerMapLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the ttdp sub process customer map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param TTDPSubProcessCustomerId the primary key of the ttdp sub process customer map
	* @return the ttdp sub process customer map that was removed
	* @throws PortalException if a ttdp sub process customer map with the primary key could not be found
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap deleteTTDPSubProcessCustomerMap(
		long TTDPSubProcessCustomerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ttdpSubProcessCustomerMapLocalService.deleteTTDPSubProcessCustomerMap(TTDPSubProcessCustomerId);
	}

	/**
	* Deletes the ttdp sub process customer map from the database. Also notifies the appropriate model listeners.
	*
	* @param ttdpSubProcessCustomerMap the ttdp sub process customer map
	* @return the ttdp sub process customer map that was removed
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap deleteTTDPSubProcessCustomerMap(
		com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap) {
		return _ttdpSubProcessCustomerMapLocalService.deleteTTDPSubProcessCustomerMap(ttdpSubProcessCustomerMap);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ttdpSubProcessCustomerMapLocalService.dynamicQuery();
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
		return _ttdpSubProcessCustomerMapLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSubProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _ttdpSubProcessCustomerMapLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSubProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _ttdpSubProcessCustomerMapLocalService.dynamicQuery(dynamicQuery,
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
		return _ttdpSubProcessCustomerMapLocalService.dynamicQueryCount(dynamicQuery);
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
		return _ttdpSubProcessCustomerMapLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap editTTDPSubProcessCustomerMapping(
		long TTDPSubProcessIdCustomerId,
		java.util.Map<java.util.Locale, String> name, long modifiedBy,
		int statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ttdpSubProcessCustomerMapLocalService.editTTDPSubProcessCustomerMapping(TTDPSubProcessIdCustomerId,
			name, modifiedBy, statusId);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap fetchTTDPSubProcessCustomerMap(
		long TTDPSubProcessCustomerId) {
		return _ttdpSubProcessCustomerMapLocalService.fetchTTDPSubProcessCustomerMap(TTDPSubProcessCustomerId);
	}

	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap> findActiveTTDPSubProcessCustomerMap(
		java.util.List<Long> tTDPSubProcessIds, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttdpSubProcessCustomerMapLocalService.findActiveTTDPSubProcessCustomerMap(tTDPSubProcessIds,
			organizationId);
	}

	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap> findByOrganizationId(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttdpSubProcessCustomerMapLocalService.findByOrganizationId(organizationId);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap findByTTDPSubProcessIdAndOrgId(
		long tTDPSubProcessId, long organizationId, int statusId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSubProcessCustomerMapException {
		return _ttdpSubProcessCustomerMapLocalService.findByTTDPSubProcessIdAndOrgId(tTDPSubProcessId,
			organizationId, statusId);
	}

	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap> findTTDPSubProcessCustomerMap(
		java.util.List<Long> tTDPSubProcessIds, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttdpSubProcessCustomerMapLocalService.findTTDPSubProcessCustomerMap(tTDPSubProcessIds,
			organizationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _ttdpSubProcessCustomerMapLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _ttdpSubProcessCustomerMapLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _ttdpSubProcessCustomerMapLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ttdpSubProcessCustomerMapLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the ttdp sub process customer map with the primary key.
	*
	* @param TTDPSubProcessCustomerId the primary key of the ttdp sub process customer map
	* @return the ttdp sub process customer map
	* @throws PortalException if a ttdp sub process customer map with the primary key could not be found
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap getTTDPSubProcessCustomerMap(
		long TTDPSubProcessCustomerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ttdpSubProcessCustomerMapLocalService.getTTDPSubProcessCustomerMap(TTDPSubProcessCustomerId);
	}

	/**
	* Returns a range of all the ttdp sub process customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSubProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ttdp sub process customer maps
	* @param end the upper bound of the range of ttdp sub process customer maps (not inclusive)
	* @return the range of ttdp sub process customer maps
	*/
	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap> getTTDPSubProcessCustomerMaps(
		int start, int end) {
		return _ttdpSubProcessCustomerMapLocalService.getTTDPSubProcessCustomerMaps(start,
			end);
	}

	/**
	* Returns the number of ttdp sub process customer maps.
	*
	* @return the number of ttdp sub process customer maps
	*/
	@Override
	public int getTTDPSubProcessCustomerMapsCount() {
		return _ttdpSubProcessCustomerMapLocalService.getTTDPSubProcessCustomerMapsCount();
	}

	@Override
	public java.util.List<Long> getUniqueTTDPSPIDsByTTDPIDList(
		java.util.List<com.liferay.portal.kernel.model.Organization> projects,
		java.util.List<Long> ttdProcessIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttdpSubProcessCustomerMapLocalService.getUniqueTTDPSPIDsByTTDPIDList(projects,
			ttdProcessIds);
	}

	/**
	* Updates the ttdp sub process customer map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ttdpSubProcessCustomerMap the ttdp sub process customer map
	* @return the ttdp sub process customer map that was updated
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap updateTTDPSubProcessCustomerMap(
		com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap) {
		return _ttdpSubProcessCustomerMapLocalService.updateTTDPSubProcessCustomerMap(ttdpSubProcessCustomerMap);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap updateTTDPSubProcessCustomerMapping(
		long TTDPSubProcessId, long organizationId, long modifiedBy,
		int statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ttdpSubProcessCustomerMapLocalService.updateTTDPSubProcessCustomerMapping(TTDPSubProcessId,
			organizationId, modifiedBy, statusId);
	}

	@Override
	public TTDPSubProcessCustomerMapLocalService getWrappedService() {
		return _ttdpSubProcessCustomerMapLocalService;
	}

	@Override
	public void setWrappedService(
		TTDPSubProcessCustomerMapLocalService ttdpSubProcessCustomerMapLocalService) {
		_ttdpSubProcessCustomerMapLocalService = ttdpSubProcessCustomerMapLocalService;
	}

	private TTDPSubProcessCustomerMapLocalService _ttdpSubProcessCustomerMapLocalService;
}