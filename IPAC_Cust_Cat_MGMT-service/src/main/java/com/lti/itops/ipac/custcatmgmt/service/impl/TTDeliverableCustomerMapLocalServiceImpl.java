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

package com.lti.itops.ipac.custcatmgmt.service.impl;

import com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDeliverableCustomerMapException;
import com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap;
import com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap;
import com.lti.itops.ipac.custcatmgmt.service.TTDeliverableCustomerMapLocalServiceUtil;
import com.lti.itops.ipac.custcatmgmt.service.base.TTDeliverableCustomerMapLocalServiceBaseImpl;
import com.lti.itops.ipac.custcatmgmt.service.persistence.TTDeliverableCustomerMapUtil;
import com.lti.itops.ipac.custcatmgmt.util.CCStatus;
import com.lti.itops.ipac.spmgmt.service.TTDeliverableMapLocalServiceUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * The implementation of the tt deliverable customer map local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.lti.itops.ipac.custcatmgmt.service.TTDeliverableCustomerMapLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sunprabh
 * @see TTDeliverableCustomerMapLocalServiceBaseImpl
 * @see com.lti.itops.ipac.custcatmgmt.service.TTDeliverableCustomerMapLocalServiceUtil
 */
public class TTDeliverableCustomerMapLocalServiceImpl
	extends TTDeliverableCustomerMapLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.lti.itops.ipac.custcatmgmt.service.TTDeliverableCustomerMapLocalServiceUtil} to access the tt deliverable customer map local service.
	 */
	
	public List<TTDeliverableCustomerMap> findActiveTTDeliverableCustomerMap(List<Long> tTDeliverableIds, long organizationId)
			throws SystemException 
	{

		if (tTDeliverableIds.isEmpty() || tTDeliverableIds == null) {
			return new ArrayList<TTDeliverableCustomerMap>();
		}
		
		Class<?> clazz = ttDeliverableCustomerMapPersistence.getClass();
		ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDeliverableCustomerMap.class, _dynamicQueryClassLoader); 

		
		//DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDeliverableCustomerMap.class);
		dq.add(PropertyFactoryUtil.forName("organizationId").eq(organizationId));
		dq.add(PropertyFactoryUtil.forName("TTDeliverableId").in(tTDeliverableIds));

		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}

		return ttDeliverableCustomerMapPersistence.findWithDynamicQuery(dq);

	 }
	
	public List<TTDeliverableCustomerMap> findTTDeliverableCustomerMap(List<Long> tTDeliverableIds, long organizationId) throws SystemException {

		if (tTDeliverableIds.isEmpty() || tTDeliverableIds == null) {
			return new ArrayList<TTDeliverableCustomerMap>();
		}
		
		Class<?> clazz = ttDeliverableCustomerMapPersistence.getClass();
		ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDeliverableCustomerMap.class, _dynamicQueryClassLoader); 

		
		dq.add(PropertyFactoryUtil.forName("organizationId").eq(organizationId));
		dq.add(PropertyFactoryUtil.forName("TTDeliverableId").in(tTDeliverableIds));

		return ttDeliverableCustomerMapPersistence.findWithDynamicQuery(dq);

	 }
	
	
	/*
	 * Portlet implementation class for updating TTechnologyCustomer Mapping
	 */


	public boolean addTTDeliverableCustomerMapping(long TTDeliverableId, long organizationId,
			Map<Locale, String> name, long companyId, long createdBy, int statusId) throws SystemException,PortalException {
		TTDeliverableCustomerMap tTDeliverableCustomerMap = TTDeliverableCustomerMapUtil
					.create(CounterLocalServiceUtil
							.increment(TTDeliverableCustomerMap.class.getName()));
		Date now = new java.util.Date();

		tTDeliverableCustomerMap.setTTDeliverableId(TTDeliverableId);
		tTDeliverableCustomerMap.setOrganizationId(organizationId);
		tTDeliverableCustomerMap.setNameMap(name);
		tTDeliverableCustomerMap.setCompanyId(companyId);
		tTDeliverableCustomerMap.setCreatedOn(now);
		tTDeliverableCustomerMap.setCreatedBy(createdBy);
		tTDeliverableCustomerMap.setModifiedBy(createdBy);
		tTDeliverableCustomerMap.setModifiedOn(now);
		tTDeliverableCustomerMap.setStatusId(statusId);

		try {
			TTDeliverableCustomerMapLocalServiceUtil
					.addTTDeliverableCustomerMap(tTDeliverableCustomerMap);

		} catch (Exception e) {
			System.out.println("Unable to create TTDeliverableCustomerMap Mapping : "
					+ e.getMessage());
			return false;
		}

		return true;
	}



	public TTDeliverableCustomerMap updateTTDeliverableCustomerMapping(long TTDeliverableId,
			long organizationId, long modifiedBy,
			int statusId) throws PortalException, SystemException {

		TTDeliverableCustomerMap tTDeliverableCustomerMap = TTDeliverableCustomerMapUtil
					.findByTTDeliverableId(TTDeliverableId, organizationId);

		Date now = new Date();
		tTDeliverableCustomerMap.setStatusId(statusId);
		tTDeliverableCustomerMap.setModifiedOn(now);
		tTDeliverableCustomerMap.setModifiedBy(modifiedBy);
		return TTDeliverableCustomerMapLocalServiceUtil
					.updateTTDeliverableCustomerMap(tTDeliverableCustomerMap);

	
	}
	
	
	

	public TTDeliverableCustomerMap editTTDeliverableCustomerMapping(long TTDeliverableCustomerId,
			Map<Locale, String> name,  long modifiedBy, int statusId) 
					throws PortalException, SystemException {
		TTDeliverableCustomerMap tTDeliverableCustomerMap = TTDeliverableCustomerMapLocalServiceUtil.getTTDeliverableCustomerMap(TTDeliverableCustomerId);
	
		
		Date now = new Date();
		tTDeliverableCustomerMap.setNameMap(name);
		tTDeliverableCustomerMap.setStatusId(statusId);
		tTDeliverableCustomerMap.setModifiedOn(now);
		tTDeliverableCustomerMap.setModifiedBy(modifiedBy);

		
		return	TTDeliverableCustomerMapLocalServiceUtil
					.updateTTDeliverableCustomerMap(tTDeliverableCustomerMap);

	}
	
	/*
	 * Get Unique List of TTDeliverableIds by list of TTechnologyIds which are mapped to given project list
	 * 
	 */

	public List<Long> getUniqueTTDIDsByTTIDList(List<Organization> projects,List<Long> tTechnologyIds) throws SystemException {
			
		List<Long> ttDeliverableIds = TTDeliverableMapLocalServiceUtil.getTTDIdsByTTIds(tTechnologyIds);
		
		List<Long> projectIds = new ArrayList<Long>();
		
		for(Organization project : projects) {
			
			projectIds.add(project.getOrganizationId());
			
		}
		Class<?> clazz = ttDeliverableCustomerMapPersistence.getClass();
		ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDeliverableCustomerMap.class, _dynamicQueryClassLoader); 

		
		//DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDeliverableCustomerMap.class);
		dq.add(PropertyFactoryUtil.forName("organizationId").in(projectIds));
		dq.add(PropertyFactoryUtil.forName("TTDeliverableId").in(ttDeliverableIds));
		
		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}
		dq.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("TTDeliverableId")));

		ttDeliverableIds = TTDeliverableCustomerMapLocalServiceUtil.dynamicQuery(dq);
		
		return ttDeliverableIds;
		
	}
	public TTDeliverableCustomerMap findByTTDeliverableId(
			long TTDeliverableId, long organizationId)
			throws NoSuchTTDeliverableCustomerMapException, SystemException {
			return ttDeliverableCustomerMapPersistence.findByTTDeliverableId(TTDeliverableId, organizationId);
		}
}