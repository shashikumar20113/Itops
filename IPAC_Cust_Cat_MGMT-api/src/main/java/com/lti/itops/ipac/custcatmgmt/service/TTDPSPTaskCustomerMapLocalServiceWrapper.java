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
 * Provides a wrapper for {@link TTDPSPTaskCustomerMapLocalService}.
 *
 * @author sunprabh
 * @see TTDPSPTaskCustomerMapLocalService
 * @generated
 */
@ProviderType
public class TTDPSPTaskCustomerMapLocalServiceWrapper
	implements TTDPSPTaskCustomerMapLocalService,
		ServiceWrapper<TTDPSPTaskCustomerMapLocalService> {
	public TTDPSPTaskCustomerMapLocalServiceWrapper(
		TTDPSPTaskCustomerMapLocalService ttdpspTaskCustomerMapLocalService) {
		_ttdpspTaskCustomerMapLocalService = ttdpspTaskCustomerMapLocalService;
	}

	/**
	* Adds the ttdpsp task customer map to the database. Also notifies the appropriate model listeners.
	*
	* @param ttdpspTaskCustomerMap the ttdpsp task customer map
	* @return the ttdpsp task customer map that was added
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap addTTDPSPTaskCustomerMap(
		com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap ttdpspTaskCustomerMap) {
		return _ttdpspTaskCustomerMapLocalService.addTTDPSPTaskCustomerMap(ttdpspTaskCustomerMap);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap addTTDPSPTaskCustomerMapping(
		long taskId, long tTDPSubProcessId, long organizationId, String name,
		int taskTypeId, long companyId, long createdBy, int statusId,
		long doGroupId, long linkedTTDPSubprocessCustMapId,
		long parentTTDPSPTaskCustMapId, int taskOrderNumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.exception.PortalException {
		return _ttdpspTaskCustomerMapLocalService.addTTDPSPTaskCustomerMapping(taskId,
			tTDPSubProcessId, organizationId, name, taskTypeId, companyId,
			createdBy, statusId, doGroupId, linkedTTDPSubprocessCustMapId,
			parentTTDPSPTaskCustMapId, taskOrderNumber);
	}

	/**
	* Creates a new ttdpsp task customer map with the primary key. Does not add the ttdpsp task customer map to the database.
	*
	* @param TTDPSPTaskCustomerId the primary key for the new ttdpsp task customer map
	* @return the new ttdpsp task customer map
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap createTTDPSPTaskCustomerMap(
		long TTDPSPTaskCustomerId) {
		return _ttdpspTaskCustomerMapLocalService.createTTDPSPTaskCustomerMap(TTDPSPTaskCustomerId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ttdpspTaskCustomerMapLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the ttdpsp task customer map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param TTDPSPTaskCustomerId the primary key of the ttdpsp task customer map
	* @return the ttdpsp task customer map that was removed
	* @throws PortalException if a ttdpsp task customer map with the primary key could not be found
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap deleteTTDPSPTaskCustomerMap(
		long TTDPSPTaskCustomerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ttdpspTaskCustomerMapLocalService.deleteTTDPSPTaskCustomerMap(TTDPSPTaskCustomerId);
	}

	/**
	* Deletes the ttdpsp task customer map from the database. Also notifies the appropriate model listeners.
	*
	* @param ttdpspTaskCustomerMap the ttdpsp task customer map
	* @return the ttdpsp task customer map that was removed
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap deleteTTDPSPTaskCustomerMap(
		com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap ttdpspTaskCustomerMap) {
		return _ttdpspTaskCustomerMapLocalService.deleteTTDPSPTaskCustomerMap(ttdpspTaskCustomerMap);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ttdpspTaskCustomerMapLocalService.dynamicQuery();
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
		return _ttdpspTaskCustomerMapLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _ttdpspTaskCustomerMapLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _ttdpspTaskCustomerMapLocalService.dynamicQuery(dynamicQuery,
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
		return _ttdpspTaskCustomerMapLocalService.dynamicQueryCount(dynamicQuery);
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
		return _ttdpspTaskCustomerMapLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap editTTDPSPTaskCustomerMapping(
		long TTDPSPTaskIdCustomerId,
		java.util.Map<java.util.Locale, String> name, long companyId,
		long modifiedBy, int statusId, long doGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ttdpspTaskCustomerMapLocalService.editTTDPSPTaskCustomerMapping(TTDPSPTaskIdCustomerId,
			name, companyId, modifiedBy, statusId, doGroupId);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap fetchTTDPSPTaskCustomerMap(
		long TTDPSPTaskCustomerId) {
		return _ttdpspTaskCustomerMapLocalService.fetchTTDPSPTaskCustomerMap(TTDPSPTaskCustomerId);
	}

	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap> findActiveByOrganizationAndSubProcess(
		long organizationId, long TTDPSubProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttdpspTaskCustomerMapLocalService.findActiveByOrganizationAndSubProcess(organizationId,
			TTDPSubProcessId);
	}

	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap> findActiveByOrganizationAndSubProcessWithoutSubTask(
		long organizationId, long TTDPSubProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttdpspTaskCustomerMapLocalService.findActiveByOrganizationAndSubProcessWithoutSubTask(organizationId,
			TTDPSubProcessId);
	}

	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap> findActiveByOrganizationId(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttdpspTaskCustomerMapLocalService.findActiveByOrganizationId(organizationId);
	}

	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap> findActiveTTDPSPTaskCustomerMap(
		java.util.List<Long> ttdpspTaskIds, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttdpspTaskCustomerMapLocalService.findActiveTTDPSPTaskCustomerMap(ttdpspTaskIds,
			organizationId);
	}

	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap> findActiveTTDPSPTaskCustomerMap(
		long TTDPSubProcessId, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttdpspTaskCustomerMapLocalService.findActiveTTDPSPTaskCustomerMap(TTDPSubProcessId,
			organizationId);
	}

	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap> findActiveTTDPSPTaskCustomerMap(
		long TTDPSubProcessId, long organizationId, int taskTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttdpspTaskCustomerMapLocalService.findActiveTTDPSPTaskCustomerMap(TTDPSubProcessId,
			organizationId, taskTypeId);
	}

	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap> findActiveTTDPSPTaskCustomerMapBy(
		java.util.List<Long> ttdpapTaskCustomerIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttdpspTaskCustomerMapLocalService.findActiveTTDPSPTaskCustomerMapBy(ttdpapTaskCustomerIds);
	}

	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap> findAllActiveTTDPSPTaskCustomerMaps(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttdpspTaskCustomerMapLocalService.findAllActiveTTDPSPTaskCustomerMaps(companyId);
	}

	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap> findAllActiveTTDPSPTaskCustomerMapsWithoutSubTask(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttdpspTaskCustomerMapLocalService.findAllActiveTTDPSPTaskCustomerMapsWithoutSubTask(companyId);
	}

	@Override
	public java.util.List<Long> findAllByOrganizationAndSubProcess(
		long organizationId, long TTDPSubProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttdpspTaskCustomerMapLocalService.findAllByOrganizationAndSubProcess(organizationId,
			TTDPSubProcessId);
	}

	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap> findByOrganizationAndSubProcess(
		long organizationId, long TTDPSubProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttdpspTaskCustomerMapLocalService.findByOrganizationAndSubProcess(organizationId,
			TTDPSubProcessId);
	}

	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap> findTTDPSPTaskCustomerMapsWithoutSubTasks(
		long organizationId, long TTDPSubProcessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttdpspTaskCustomerMapLocalService.findTTDPSPTaskCustomerMapsWithoutSubTasks(organizationId,
			TTDPSubProcessId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _ttdpspTaskCustomerMapLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _ttdpspTaskCustomerMapLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _ttdpspTaskCustomerMapLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ttdpspTaskCustomerMapLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the ttdpsp task customer map with the primary key.
	*
	* @param TTDPSPTaskCustomerId the primary key of the ttdpsp task customer map
	* @return the ttdpsp task customer map
	* @throws PortalException if a ttdpsp task customer map with the primary key could not be found
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap getTTDPSPTaskCustomerMap(
		long TTDPSPTaskCustomerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ttdpspTaskCustomerMapLocalService.getTTDPSPTaskCustomerMap(TTDPSPTaskCustomerId);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap getTTDPSPTaskCustomerMapBy(
		long TTDPSubProcessId, long taskId, long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ttdpspTaskCustomerMapLocalService.getTTDPSPTaskCustomerMapBy(TTDPSubProcessId,
			taskId, organizationId);
	}

	/**
	* Returns a range of all the ttdpsp task customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ttdpsp task customer maps
	* @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	* @return the range of ttdpsp task customer maps
	*/
	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap> getTTDPSPTaskCustomerMaps(
		int start, int end) {
		return _ttdpspTaskCustomerMapLocalService.getTTDPSPTaskCustomerMaps(start,
			end);
	}

	/**
	* Returns the number of ttdpsp task customer maps.
	*
	* @return the number of ttdpsp task customer maps
	*/
	@Override
	public int getTTDPSPTaskCustomerMapsCount() {
		return _ttdpspTaskCustomerMapLocalService.getTTDPSPTaskCustomerMapsCount();
	}

	@Override
	public java.util.List<Long> getUniqueTTDPSPTIDsByTTDPSPIDList(
		java.util.List<com.liferay.portal.kernel.model.Organization> projects,
		java.util.List<Long> ttdpSubProcessIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttdpspTaskCustomerMapLocalService.getUniqueTTDPSPTIDsByTTDPSPIDList(projects,
			ttdpSubProcessIds);
	}

	/**
	* Updates the ttdpsp task customer map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ttdpspTaskCustomerMap the ttdpsp task customer map
	* @return the ttdpsp task customer map that was updated
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap updateTTDPSPTaskCustomerMap(
		com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap ttdpspTaskCustomerMap) {
		return _ttdpspTaskCustomerMapLocalService.updateTTDPSPTaskCustomerMap(ttdpspTaskCustomerMap);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap updateTTDPSPTaskCustomerMapping(
		long taskId, long TTDPSubProcessId, long organizationId,
		long modifiedBy, int statusId, long doGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ttdpspTaskCustomerMapLocalService.updateTTDPSPTaskCustomerMapping(taskId,
			TTDPSubProcessId, organizationId, modifiedBy, statusId, doGroupId);
	}

	@Override
	public TTDPSPTaskCustomerMapLocalService getWrappedService() {
		return _ttdpspTaskCustomerMapLocalService;
	}

	@Override
	public void setWrappedService(
		TTDPSPTaskCustomerMapLocalService ttdpspTaskCustomerMapLocalService) {
		_ttdpspTaskCustomerMapLocalService = ttdpspTaskCustomerMapLocalService;
	}

	private TTDPSPTaskCustomerMapLocalService _ttdpspTaskCustomerMapLocalService;
}