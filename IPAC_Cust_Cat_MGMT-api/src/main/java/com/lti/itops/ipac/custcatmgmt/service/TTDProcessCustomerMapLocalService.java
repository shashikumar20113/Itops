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

import com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDProcessCustomerMapException;
import com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap;

import java.io.Serializable;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Provides the local service interface for TTDProcessCustomerMap. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author sunprabh
 * @see TTDProcessCustomerMapLocalServiceUtil
 * @see com.lti.itops.ipac.custcatmgmt.service.base.TTDProcessCustomerMapLocalServiceBaseImpl
 * @see com.lti.itops.ipac.custcatmgmt.service.impl.TTDProcessCustomerMapLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface TTDProcessCustomerMapLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TTDProcessCustomerMapLocalServiceUtil} to access the ttd process customer map local service. Add custom service methods to {@link com.lti.itops.ipac.custcatmgmt.service.impl.TTDProcessCustomerMapLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the ttd process customer map to the database. Also notifies the appropriate model listeners.
	*
	* @param ttdProcessCustomerMap the ttd process customer map
	* @return the ttd process customer map that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public TTDProcessCustomerMap addTTDProcessCustomerMap(
		TTDProcessCustomerMap ttdProcessCustomerMap);

	public TTDProcessCustomerMap addTTDProcessCustomerMapping(
		long TTDProcessId, long organizationId, Map<Locale, String> name,
		long companyId, long createdBy, int statusId)
		throws PortalException, SystemException;

	/**
	* Creates a new ttd process customer map with the primary key. Does not add the ttd process customer map to the database.
	*
	* @param TTDProcessCustomerId the primary key for the new ttd process customer map
	* @return the new ttd process customer map
	*/
	@Transactional(enabled = false)
	public TTDProcessCustomerMap createTTDProcessCustomerMap(
		long TTDProcessCustomerId);

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	* Deletes the ttd process customer map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param TTDProcessCustomerId the primary key of the ttd process customer map
	* @return the ttd process customer map that was removed
	* @throws PortalException if a ttd process customer map with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public TTDProcessCustomerMap deleteTTDProcessCustomerMap(
		long TTDProcessCustomerId) throws PortalException;

	/**
	* Deletes the ttd process customer map from the database. Also notifies the appropriate model listeners.
	*
	* @param ttdProcessCustomerMap the ttd process customer map
	* @return the ttd process customer map that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public TTDProcessCustomerMap deleteTTDProcessCustomerMap(
		TTDProcessCustomerMap ttdProcessCustomerMap);

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTDProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTDProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public TTDProcessCustomerMap editTTDProcessCustomerMapping(
		long TTDProcessIdCustomerId, long organizationId,
		Map<Locale, String> name, long companyId, long modifiedBy, int statusId)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TTDProcessCustomerMap fetchTTDProcessCustomerMap(
		long TTDProcessCustomerId);

	public List<TTDProcessCustomerMap> findActiveTTDProcessCustomerMap(
		List<Long> tTDProcessIds, long organizationId)
		throws SystemException;

	public TTDProcessCustomerMap findByTTDProcessIdAndOrgId(long tTDProcessId,
		long organizationId, int statusId)
		throws NoSuchTTDProcessCustomerMapException, SystemException;

	public List<TTDProcessCustomerMap> findTTDProcessCustomerMap(
		List<Long> tTDProcessIds, long organizationId)
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
	* Returns the ttd process customer map with the primary key.
	*
	* @param TTDProcessCustomerId the primary key of the ttd process customer map
	* @return the ttd process customer map
	* @throws PortalException if a ttd process customer map with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TTDProcessCustomerMap getTTDProcessCustomerMap(
		long TTDProcessCustomerId) throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TTDProcessCustomerMap> getTTDProcessCustomerMaps(int start,
		int end);

	/**
	* Returns the number of ttd process customer maps.
	*
	* @return the number of ttd process customer maps
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTTDProcessCustomerMapsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Long> getUniqueTTDPIDsByTTDIDList(List<Organization> projects,
		List<Long> ttDeliverableIds) throws SystemException;

	/**
	* Updates the ttd process customer map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ttdProcessCustomerMap the ttd process customer map
	* @return the ttd process customer map that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public TTDProcessCustomerMap updateTTDProcessCustomerMap(
		TTDProcessCustomerMap ttdProcessCustomerMap);

	public TTDProcessCustomerMap updateTTDProcessCustomerMapping(
		long TTDProcessId, long organizationId, long modifiedBy, int statusId)
		throws PortalException, SystemException;
}