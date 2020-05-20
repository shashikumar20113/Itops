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
 * Provides a wrapper for {@link TTDeliverableCustomerMapLocalService}.
 *
 * @author sunprabh
 * @see TTDeliverableCustomerMapLocalService
 * @generated
 */
@ProviderType
public class TTDeliverableCustomerMapLocalServiceWrapper
	implements TTDeliverableCustomerMapLocalService,
		ServiceWrapper<TTDeliverableCustomerMapLocalService> {
	public TTDeliverableCustomerMapLocalServiceWrapper(
		TTDeliverableCustomerMapLocalService ttDeliverableCustomerMapLocalService) {
		_ttDeliverableCustomerMapLocalService = ttDeliverableCustomerMapLocalService;
	}

	/**
	* Adds the tt deliverable customer map to the database. Also notifies the appropriate model listeners.
	*
	* @param ttDeliverableCustomerMap the tt deliverable customer map
	* @return the tt deliverable customer map that was added
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap addTTDeliverableCustomerMap(
		com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap ttDeliverableCustomerMap) {
		return _ttDeliverableCustomerMapLocalService.addTTDeliverableCustomerMap(ttDeliverableCustomerMap);
	}

	@Override
	public boolean addTTDeliverableCustomerMapping(long TTDeliverableId,
		long organizationId, java.util.Map<java.util.Locale, String> name,
		long companyId, long createdBy, int statusId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.exception.PortalException {
		return _ttDeliverableCustomerMapLocalService.addTTDeliverableCustomerMapping(TTDeliverableId,
			organizationId, name, companyId, createdBy, statusId);
	}

	/**
	* Creates a new tt deliverable customer map with the primary key. Does not add the tt deliverable customer map to the database.
	*
	* @param TTDeliverableCustomerId the primary key for the new tt deliverable customer map
	* @return the new tt deliverable customer map
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap createTTDeliverableCustomerMap(
		long TTDeliverableCustomerId) {
		return _ttDeliverableCustomerMapLocalService.createTTDeliverableCustomerMap(TTDeliverableCustomerId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ttDeliverableCustomerMapLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the tt deliverable customer map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param TTDeliverableCustomerId the primary key of the tt deliverable customer map
	* @return the tt deliverable customer map that was removed
	* @throws PortalException if a tt deliverable customer map with the primary key could not be found
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap deleteTTDeliverableCustomerMap(
		long TTDeliverableCustomerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ttDeliverableCustomerMapLocalService.deleteTTDeliverableCustomerMap(TTDeliverableCustomerId);
	}

	/**
	* Deletes the tt deliverable customer map from the database. Also notifies the appropriate model listeners.
	*
	* @param ttDeliverableCustomerMap the tt deliverable customer map
	* @return the tt deliverable customer map that was removed
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap deleteTTDeliverableCustomerMap(
		com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap ttDeliverableCustomerMap) {
		return _ttDeliverableCustomerMapLocalService.deleteTTDeliverableCustomerMap(ttDeliverableCustomerMap);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ttDeliverableCustomerMapLocalService.dynamicQuery();
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
		return _ttDeliverableCustomerMapLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _ttDeliverableCustomerMapLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _ttDeliverableCustomerMapLocalService.dynamicQuery(dynamicQuery,
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
		return _ttDeliverableCustomerMapLocalService.dynamicQueryCount(dynamicQuery);
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
		return _ttDeliverableCustomerMapLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap editTTDeliverableCustomerMapping(
		long TTDeliverableCustomerId,
		java.util.Map<java.util.Locale, String> name, long modifiedBy,
		int statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ttDeliverableCustomerMapLocalService.editTTDeliverableCustomerMapping(TTDeliverableCustomerId,
			name, modifiedBy, statusId);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap fetchTTDeliverableCustomerMap(
		long TTDeliverableCustomerId) {
		return _ttDeliverableCustomerMapLocalService.fetchTTDeliverableCustomerMap(TTDeliverableCustomerId);
	}

	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap> findActiveTTDeliverableCustomerMap(
		java.util.List<Long> tTDeliverableIds, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttDeliverableCustomerMapLocalService.findActiveTTDeliverableCustomerMap(tTDeliverableIds,
			organizationId);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap findByTTDeliverableId(
		long TTDeliverableId, long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDeliverableCustomerMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ttDeliverableCustomerMapLocalService.findByTTDeliverableId(TTDeliverableId,
			organizationId);
	}

	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap> findTTDeliverableCustomerMap(
		java.util.List<Long> tTDeliverableIds, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttDeliverableCustomerMapLocalService.findTTDeliverableCustomerMap(tTDeliverableIds,
			organizationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _ttDeliverableCustomerMapLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _ttDeliverableCustomerMapLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _ttDeliverableCustomerMapLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ttDeliverableCustomerMapLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the tt deliverable customer map with the primary key.
	*
	* @param TTDeliverableCustomerId the primary key of the tt deliverable customer map
	* @return the tt deliverable customer map
	* @throws PortalException if a tt deliverable customer map with the primary key could not be found
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap getTTDeliverableCustomerMap(
		long TTDeliverableCustomerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ttDeliverableCustomerMapLocalService.getTTDeliverableCustomerMap(TTDeliverableCustomerId);
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
	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap> getTTDeliverableCustomerMaps(
		int start, int end) {
		return _ttDeliverableCustomerMapLocalService.getTTDeliverableCustomerMaps(start,
			end);
	}

	/**
	* Returns the number of tt deliverable customer maps.
	*
	* @return the number of tt deliverable customer maps
	*/
	@Override
	public int getTTDeliverableCustomerMapsCount() {
		return _ttDeliverableCustomerMapLocalService.getTTDeliverableCustomerMapsCount();
	}

	@Override
	public java.util.List<Long> getUniqueTTDIDsByTTIDList(
		java.util.List<com.liferay.portal.kernel.model.Organization> projects,
		java.util.List<Long> tTechnologyIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ttDeliverableCustomerMapLocalService.getUniqueTTDIDsByTTIDList(projects,
			tTechnologyIds);
	}

	/**
	* Updates the tt deliverable customer map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ttDeliverableCustomerMap the tt deliverable customer map
	* @return the tt deliverable customer map that was updated
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap updateTTDeliverableCustomerMap(
		com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap ttDeliverableCustomerMap) {
		return _ttDeliverableCustomerMapLocalService.updateTTDeliverableCustomerMap(ttDeliverableCustomerMap);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap updateTTDeliverableCustomerMapping(
		long TTDeliverableId, long organizationId, long modifiedBy, int statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ttDeliverableCustomerMapLocalService.updateTTDeliverableCustomerMapping(TTDeliverableId,
			organizationId, modifiedBy, statusId);
	}

	@Override
	public TTDeliverableCustomerMapLocalService getWrappedService() {
		return _ttDeliverableCustomerMapLocalService;
	}

	@Override
	public void setWrappedService(
		TTDeliverableCustomerMapLocalService ttDeliverableCustomerMapLocalService) {
		_ttDeliverableCustomerMapLocalService = ttDeliverableCustomerMapLocalService;
	}

	private TTDeliverableCustomerMapLocalService _ttDeliverableCustomerMapLocalService;
}