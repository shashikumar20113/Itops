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
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTechnologyCustomerMapException;
import com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap;

import java.io.Serializable;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Provides the local service interface for TTechnologyCustomerMap. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author sunprabh
 * @see TTechnologyCustomerMapLocalServiceUtil
 * @see com.lti.itops.ipac.custcatmgmt.service.base.TTechnologyCustomerMapLocalServiceBaseImpl
 * @see com.lti.itops.ipac.custcatmgmt.service.impl.TTechnologyCustomerMapLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface TTechnologyCustomerMapLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TTechnologyCustomerMapLocalServiceUtil} to access the t technology customer map local service. Add custom service methods to {@link com.lti.itops.ipac.custcatmgmt.service.impl.TTechnologyCustomerMapLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the t technology customer map to the database. Also notifies the appropriate model listeners.
	*
	* @param tTechnologyCustomerMap the t technology customer map
	* @return the t technology customer map that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public TTechnologyCustomerMap addTTechnologyCustomerMap(
		TTechnologyCustomerMap tTechnologyCustomerMap);

	public TTechnologyCustomerMap addTTechnologyCustomerMapping(
		long towerTechnologyId, long organizationId, Map<Locale, String> name,
		long companyId, long createdBy, int statusId)
		throws SystemException, PortalException;

	/**
	* Creates a new t technology customer map with the primary key. Does not add the t technology customer map to the database.
	*
	* @param TTechnologyCustomerId the primary key for the new t technology customer map
	* @return the new t technology customer map
	*/
	@Transactional(enabled = false)
	public TTechnologyCustomerMap createTTechnologyCustomerMap(
		long TTechnologyCustomerId);

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	* Deletes the t technology customer map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param TTechnologyCustomerId the primary key of the t technology customer map
	* @return the t technology customer map that was removed
	* @throws PortalException if a t technology customer map with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public TTechnologyCustomerMap deleteTTechnologyCustomerMap(
		long TTechnologyCustomerId) throws PortalException;

	/**
	* Deletes the t technology customer map from the database. Also notifies the appropriate model listeners.
	*
	* @param tTechnologyCustomerMap the t technology customer map
	* @return the t technology customer map that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public TTechnologyCustomerMap deleteTTechnologyCustomerMap(
		TTechnologyCustomerMap tTechnologyCustomerMap);

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTechnologyCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTechnologyCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public TTechnologyCustomerMap editTTechnologyCustomerMapping(
		long TTechnologyCustomerId, long organizationId,
		Map<Locale, String> name, long modifiedBy, int statusId)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TTechnologyCustomerMap fetchTTechnologyCustomerMap(
		long TTechnologyCustomerId);

	public List<Long> findActiveTTechnologyCustomerTTechnologyIds(
		long[] towerTechnologyId) throws SystemException;

	public List<TTechnologyCustomerMap> findByT_O(long towerTechnologyId,
		long organizationId) throws SystemException;

	public TTechnologyCustomerMap findByTowerTechnologyId(
		long towerTechnologyId, long organizationId)
		throws NoSuchTTechnologyCustomerMapException, SystemException;

	public TTechnologyCustomerMap findByTTechnologyCustomerMapId(
		long TTechnologyCustomerId, long organizationId)
		throws SystemException, NoSuchTTechnologyCustomerMapException;

	public long findTTechnologyCustomerId(long towerTechnologyId,
		long organizationId)
		throws SystemException, NoSuchTTechnologyCustomerMapException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TTechnologyCustomerMap> getActiveTTechnologyCustomerMap(
		long tTechnologyCustomerId, long organizationId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TTechnologyCustomerMap> getActiveTTechnologyCustomerMapByorganizationId(
		long organizationId, List<Long> towerTechnologyIds)
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
	* Returns the t technology customer map with the primary key.
	*
	* @param TTechnologyCustomerId the primary key of the t technology customer map
	* @return the t technology customer map
	* @throws PortalException if a t technology customer map with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TTechnologyCustomerMap getTTechnologyCustomerMap(
		long TTechnologyCustomerId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TTechnologyCustomerMap> getTTechnologyCustomerMapByorganizationId(
		long organizationId, List<Long> towerTechnologyIds)
		throws SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TTechnologyCustomerMap> getTTechnologyCustomerMaps(int start,
		int end);

	/**
	* Returns the number of t technology customer maps.
	*
	* @return the number of t technology customer maps
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTTechnologyCustomerMapsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Long> getUniqueTTIDsByTIDList(List<Organization> projects,
		List<Long> towerIds) throws SystemException;

	/**
	* Updates the t technology customer map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tTechnologyCustomerMap the t technology customer map
	* @return the t technology customer map that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public TTechnologyCustomerMap updateTTechnologyCustomerMap(
		TTechnologyCustomerMap tTechnologyCustomerMap);

	public TTechnologyCustomerMap updateTTechnologyCustomerMapping(
		long TTechnologyId, long organizationId, long modifiedBy, int statusId)
		throws PortalException, SystemException;
}