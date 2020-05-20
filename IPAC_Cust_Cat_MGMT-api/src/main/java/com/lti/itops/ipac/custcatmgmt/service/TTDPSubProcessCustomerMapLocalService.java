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

import com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSubProcessCustomerMapException;
import com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap;

import java.io.Serializable;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Provides the local service interface for TTDPSubProcessCustomerMap. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author sunprabh
 * @see TTDPSubProcessCustomerMapLocalServiceUtil
 * @see com.lti.itops.ipac.custcatmgmt.service.base.TTDPSubProcessCustomerMapLocalServiceBaseImpl
 * @see com.lti.itops.ipac.custcatmgmt.service.impl.TTDPSubProcessCustomerMapLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface TTDPSubProcessCustomerMapLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TTDPSubProcessCustomerMapLocalServiceUtil} to access the ttdp sub process customer map local service. Add custom service methods to {@link com.lti.itops.ipac.custcatmgmt.service.impl.TTDPSubProcessCustomerMapLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the ttdp sub process customer map to the database. Also notifies the appropriate model listeners.
	*
	* @param ttdpSubProcessCustomerMap the ttdp sub process customer map
	* @return the ttdp sub process customer map that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public TTDPSubProcessCustomerMap addTTDPSubProcessCustomerMap(
		TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap);

	public TTDPSubProcessCustomerMap addTTDPSubProcessCustomerMapping(
		long TTDPSubProcessId, long organizationId, Map<Locale, String> name,
		long companyId, long createdBy, int statusId)
		throws SystemException, PortalException;

	/**
	* Creates a new ttdp sub process customer map with the primary key. Does not add the ttdp sub process customer map to the database.
	*
	* @param TTDPSubProcessCustomerId the primary key for the new ttdp sub process customer map
	* @return the new ttdp sub process customer map
	*/
	@Transactional(enabled = false)
	public TTDPSubProcessCustomerMap createTTDPSubProcessCustomerMap(
		long TTDPSubProcessCustomerId);

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	* Deletes the ttdp sub process customer map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param TTDPSubProcessCustomerId the primary key of the ttdp sub process customer map
	* @return the ttdp sub process customer map that was removed
	* @throws PortalException if a ttdp sub process customer map with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public TTDPSubProcessCustomerMap deleteTTDPSubProcessCustomerMap(
		long TTDPSubProcessCustomerId) throws PortalException;

	/**
	* Deletes the ttdp sub process customer map from the database. Also notifies the appropriate model listeners.
	*
	* @param ttdpSubProcessCustomerMap the ttdp sub process customer map
	* @return the ttdp sub process customer map that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public TTDPSubProcessCustomerMap deleteTTDPSubProcessCustomerMap(
		TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap);

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSubProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSubProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public TTDPSubProcessCustomerMap editTTDPSubProcessCustomerMapping(
		long TTDPSubProcessIdCustomerId, Map<Locale, String> name,
		long modifiedBy, int statusId) throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TTDPSubProcessCustomerMap fetchTTDPSubProcessCustomerMap(
		long TTDPSubProcessCustomerId);

	public List<TTDPSubProcessCustomerMap> findActiveTTDPSubProcessCustomerMap(
		List<Long> tTDPSubProcessIds, long organizationId)
		throws SystemException;

	public List<TTDPSubProcessCustomerMap> findByOrganizationId(
		long organizationId) throws SystemException;

	public TTDPSubProcessCustomerMap findByTTDPSubProcessIdAndOrgId(
		long tTDPSubProcessId, long organizationId, int statusId)
		throws SystemException, NoSuchTTDPSubProcessCustomerMapException;

	public List<TTDPSubProcessCustomerMap> findTTDPSubProcessCustomerMap(
		List<Long> tTDPSubProcessIds, long organizationId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

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
	* Returns the ttdp sub process customer map with the primary key.
	*
	* @param TTDPSubProcessCustomerId the primary key of the ttdp sub process customer map
	* @return the ttdp sub process customer map
	* @throws PortalException if a ttdp sub process customer map with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TTDPSubProcessCustomerMap getTTDPSubProcessCustomerMap(
		long TTDPSubProcessCustomerId) throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TTDPSubProcessCustomerMap> getTTDPSubProcessCustomerMaps(
		int start, int end);

	/**
	* Returns the number of ttdp sub process customer maps.
	*
	* @return the number of ttdp sub process customer maps
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTTDPSubProcessCustomerMapsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Long> getUniqueTTDPSPIDsByTTDPIDList(
		List<Organization> projects, List<Long> ttdProcessIds)
		throws SystemException;

	/**
	* Updates the ttdp sub process customer map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ttdpSubProcessCustomerMap the ttdp sub process customer map
	* @return the ttdp sub process customer map that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public TTDPSubProcessCustomerMap updateTTDPSubProcessCustomerMap(
		TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap);

	public TTDPSubProcessCustomerMap updateTTDPSubProcessCustomerMapping(
		long TTDPSubProcessId, long organizationId, long modifiedBy,
		int statusId) throws PortalException, SystemException;
}