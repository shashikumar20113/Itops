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
 * Provides a wrapper for {@link TowerCustomerMapLocalService}.
 *
 * @author sunprabh
 * @see TowerCustomerMapLocalService
 * @generated
 */
@ProviderType
public class TowerCustomerMapLocalServiceWrapper
	implements TowerCustomerMapLocalService,
		ServiceWrapper<TowerCustomerMapLocalService> {
	public TowerCustomerMapLocalServiceWrapper(
		TowerCustomerMapLocalService towerCustomerMapLocalService) {
		_towerCustomerMapLocalService = towerCustomerMapLocalService;
	}

	/**
	* Adds the tower customer map to the database. Also notifies the appropriate model listeners.
	*
	* @param towerCustomerMap the tower customer map
	* @return the tower customer map that was added
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap addTowerCustomerMap(
		com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap towerCustomerMap) {
		return _towerCustomerMapLocalService.addTowerCustomerMap(towerCustomerMap);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap addTowerCustomerMapping(
		long towerId, long organizationId, String name, long companyId,
		long createdBy, int statusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _towerCustomerMapLocalService.addTowerCustomerMapping(towerId,
			organizationId, name, companyId, createdBy, statusId);
	}

	/**
	* Creates a new tower customer map with the primary key. Does not add the tower customer map to the database.
	*
	* @param towerCustomerId the primary key for the new tower customer map
	* @return the new tower customer map
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap createTowerCustomerMap(
		long towerCustomerId) {
		return _towerCustomerMapLocalService.createTowerCustomerMap(towerCustomerId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _towerCustomerMapLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the tower customer map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param towerCustomerId the primary key of the tower customer map
	* @return the tower customer map that was removed
	* @throws PortalException if a tower customer map with the primary key could not be found
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap deleteTowerCustomerMap(
		long towerCustomerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _towerCustomerMapLocalService.deleteTowerCustomerMap(towerCustomerId);
	}

	/**
	* Deletes the tower customer map from the database. Also notifies the appropriate model listeners.
	*
	* @param towerCustomerMap the tower customer map
	* @return the tower customer map that was removed
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap deleteTowerCustomerMap(
		com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap towerCustomerMap) {
		return _towerCustomerMapLocalService.deleteTowerCustomerMap(towerCustomerMap);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _towerCustomerMapLocalService.dynamicQuery();
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
		return _towerCustomerMapLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TowerCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _towerCustomerMapLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TowerCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _towerCustomerMapLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _towerCustomerMapLocalService.dynamicQueryCount(dynamicQuery);
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
		return _towerCustomerMapLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap editTowerCustomerMapping(
		long towerCustomerMapId, java.util.Map<java.util.Locale, String> name,
		long modifiedBy, int statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _towerCustomerMapLocalService.editTowerCustomerMapping(towerCustomerMapId,
			name, modifiedBy, statusId);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap fetchTowerCustomerMap(
		long towerCustomerId) {
		return _towerCustomerMapLocalService.fetchTowerCustomerMap(towerCustomerId);
	}

	@Override
	public java.util.Set<Long> findActiveCustomerIdsByTowerIds(long[] towerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _towerCustomerMapLocalService.findActiveCustomerIdsByTowerIds(towerId);
	}

	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap> findActiveTowerCustomerMapByOrganizationId(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _towerCustomerMapLocalService.findActiveTowerCustomerMapByOrganizationId(organizationId);
	}

	@Override
	public java.util.List<Long> findActiveTowerCustomerTowerIds(long[] towerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _towerCustomerMapLocalService.findActiveTowerCustomerTowerIds(towerId);
	}

	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap> findActiveUserTowerCustomerByOrganization(
		long organizationId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _towerCustomerMapLocalService.findActiveUserTowerCustomerByOrganization(organizationId,
			groupId);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap findByT_O(
		long towerId, long organizationId)
		throws com.lti.itops.ipac.custcatmgmt.exception.NoSuchTowerCustomerMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return _towerCustomerMapLocalService.findByT_O(towerId, organizationId);
	}

	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap> findTowerCustomerMapByOrganizationId(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _towerCustomerMapLocalService.findTowerCustomerMapByOrganizationId(organizationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _towerCustomerMapLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.Organization> getCustomersByTowerId(
		long towerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _towerCustomerMapLocalService.getCustomersByTowerId(towerId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _towerCustomerMapLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _towerCustomerMapLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _towerCustomerMapLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the tower customer map with the primary key.
	*
	* @param towerCustomerId the primary key of the tower customer map
	* @return the tower customer map
	* @throws PortalException if a tower customer map with the primary key could not be found
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap getTowerCustomerMap(
		long towerCustomerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _towerCustomerMapLocalService.getTowerCustomerMap(towerCustomerId);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap getTowerCustomerMap(
		long towerId, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.lti.itops.ipac.custcatmgmt.exception.NoSuchTowerCustomerMapException {
		return _towerCustomerMapLocalService.getTowerCustomerMap(towerId,
			organizationId);
	}

	@Override
	public long getTowerCustomerMapByTowerId(long towerId, long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.lti.itops.ipac.custcatmgmt.exception.NoSuchTowerCustomerMapException {
		return _towerCustomerMapLocalService.getTowerCustomerMapByTowerId(towerId,
			organizationId);
	}

	/**
	* Returns a range of all the tower customer maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TowerCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tower customer maps
	* @param end the upper bound of the range of tower customer maps (not inclusive)
	* @return the range of tower customer maps
	*/
	@Override
	public java.util.List<com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap> getTowerCustomerMaps(
		int start, int end) {
		return _towerCustomerMapLocalService.getTowerCustomerMaps(start, end);
	}

	/**
	* Returns the number of tower customer maps.
	*
	* @return the number of tower customer maps
	*/
	@Override
	public int getTowerCustomerMapsCount() {
		return _towerCustomerMapLocalService.getTowerCustomerMapsCount();
	}

	@Override
	public java.util.List<com.lti.itops.ipac.spmgmt.model.Tower> getTowersByCustomerId(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
		long customerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _towerCustomerMapLocalService.getTowersByCustomerId(themeDisplay,
			customerId);
	}

	@Override
	public java.util.List<Long> getUniqueTCMsByProjList(
		java.util.List<com.liferay.portal.kernel.model.Organization> projects)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _towerCustomerMapLocalService.getUniqueTCMsByProjList(projects);
	}

	/**
	* Updates the tower customer map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param towerCustomerMap the tower customer map
	* @return the tower customer map that was updated
	*/
	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap updateTowerCustomerMap(
		com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap towerCustomerMap) {
		return _towerCustomerMapLocalService.updateTowerCustomerMap(towerCustomerMap);
	}

	@Override
	public com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap updateTowerCustomerMapping(
		long towerId, long organizationId, long modifiedBy, int statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _towerCustomerMapLocalService.updateTowerCustomerMapping(towerId,
			organizationId, modifiedBy, statusId);
	}

	@Override
	public TowerCustomerMapLocalService getWrappedService() {
		return _towerCustomerMapLocalService;
	}

	@Override
	public void setWrappedService(
		TowerCustomerMapLocalService towerCustomerMapLocalService) {
		_towerCustomerMapLocalService = towerCustomerMapLocalService;
	}

	private TowerCustomerMapLocalService _towerCustomerMapLocalService;
}