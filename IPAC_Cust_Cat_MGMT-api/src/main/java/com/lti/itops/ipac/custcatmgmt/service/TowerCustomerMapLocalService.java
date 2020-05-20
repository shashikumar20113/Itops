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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.lti.itops.ipac.custcatmgmt.exception.NoSuchTowerCustomerMapException;
import com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap;
import com.lti.itops.ipac.spmgmt.model.Tower;

import java.io.Serializable;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * Provides the local service interface for TowerCustomerMap. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author sunprabh
 * @see TowerCustomerMapLocalServiceUtil
 * @see com.lti.itops.ipac.custcatmgmt.service.base.TowerCustomerMapLocalServiceBaseImpl
 * @see com.lti.itops.ipac.custcatmgmt.service.impl.TowerCustomerMapLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface TowerCustomerMapLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TowerCustomerMapLocalServiceUtil} to access the tower customer map local service. Add custom service methods to {@link com.lti.itops.ipac.custcatmgmt.service.impl.TowerCustomerMapLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the tower customer map to the database. Also notifies the appropriate model listeners.
	*
	* @param towerCustomerMap the tower customer map
	* @return the tower customer map that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public TowerCustomerMap addTowerCustomerMap(
		TowerCustomerMap towerCustomerMap);

	public TowerCustomerMap addTowerCustomerMapping(long towerId,
		long organizationId, String name, long companyId, long createdBy,
		int statusId) throws SystemException;

	/**
	* Creates a new tower customer map with the primary key. Does not add the tower customer map to the database.
	*
	* @param towerCustomerId the primary key for the new tower customer map
	* @return the new tower customer map
	*/
	@Transactional(enabled = false)
	public TowerCustomerMap createTowerCustomerMap(long towerCustomerId);

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	* Deletes the tower customer map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param towerCustomerId the primary key of the tower customer map
	* @return the tower customer map that was removed
	* @throws PortalException if a tower customer map with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public TowerCustomerMap deleteTowerCustomerMap(long towerCustomerId)
		throws PortalException;

	/**
	* Deletes the tower customer map from the database. Also notifies the appropriate model listeners.
	*
	* @param towerCustomerMap the tower customer map
	* @return the tower customer map that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public TowerCustomerMap deleteTowerCustomerMap(
		TowerCustomerMap towerCustomerMap);

	public DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	public TowerCustomerMap editTowerCustomerMapping(long towerCustomerMapId,
		Map<Locale, String> name, long modifiedBy, int statusId)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TowerCustomerMap fetchTowerCustomerMap(long towerCustomerId);

	public Set<Long> findActiveCustomerIdsByTowerIds(long[] towerId)
		throws SystemException;

	public List<TowerCustomerMap> findActiveTowerCustomerMapByOrganizationId(
		long organizationId) throws SystemException;

	public List<Long> findActiveTowerCustomerTowerIds(long[] towerId)
		throws SystemException;

	public List<TowerCustomerMap> findActiveUserTowerCustomerByOrganization(
		long organizationId, long groupId) throws SystemException;

	public TowerCustomerMap findByT_O(long towerId, long organizationId)
		throws NoSuchTowerCustomerMapException, SystemException;

	public List<TowerCustomerMap> findTowerCustomerMapByOrganizationId(
		long organizationId) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Organization> getCustomersByTowerId(long towerId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Returns the tower customer map with the primary key.
	*
	* @param towerCustomerId the primary key of the tower customer map
	* @return the tower customer map
	* @throws PortalException if a tower customer map with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TowerCustomerMap getTowerCustomerMap(long towerCustomerId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TowerCustomerMap getTowerCustomerMap(long towerId,
		long organizationId)
		throws SystemException, NoSuchTowerCustomerMapException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getTowerCustomerMapByTowerId(long towerId, long organizationId)
		throws SystemException, NoSuchTowerCustomerMapException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TowerCustomerMap> getTowerCustomerMaps(int start, int end);

	/**
	* Returns the number of tower customer maps.
	*
	* @return the number of tower customer maps
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTowerCustomerMapsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Tower> getTowersByCustomerId(ThemeDisplay themeDisplay,
		long customerId) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Long> getUniqueTCMsByProjList(List<Organization> projects)
		throws SystemException;

	/**
	* Updates the tower customer map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param towerCustomerMap the tower customer map
	* @return the tower customer map that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public TowerCustomerMap updateTowerCustomerMap(
		TowerCustomerMap towerCustomerMap);

	public TowerCustomerMap updateTowerCustomerMapping(long towerId,
		long organizationId, long modifiedBy, int statusId)
		throws PortalException, SystemException;
}