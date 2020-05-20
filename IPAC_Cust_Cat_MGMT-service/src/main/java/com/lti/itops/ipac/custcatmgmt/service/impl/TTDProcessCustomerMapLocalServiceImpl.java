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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDProcessCustomerMapException;
import com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap;
import com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap;
import com.lti.itops.ipac.custcatmgmt.service.TTDProcessCustomerMapLocalServiceUtil;
import com.lti.itops.ipac.custcatmgmt.service.base.TTDProcessCustomerMapLocalServiceBaseImpl;
import com.lti.itops.ipac.custcatmgmt.service.persistence.TTDProcessCustomerMapUtil;
import com.lti.itops.ipac.custcatmgmt.util.CCStatus;
import com.lti.itops.ipac.spmgmt.service.TTDProcessMapLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Organization;

/**
 * The implementation of the ttd process customer map local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.lti.itops.ipac.custcatmgmt.service.TTDProcessCustomerMapLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sunprabh
 * @see TTDProcessCustomerMapLocalServiceBaseImpl
 * @see com.lti.itops.ipac.custcatmgmt.service.TTDProcessCustomerMapLocalServiceUtil
 */
public class TTDProcessCustomerMapLocalServiceImpl
	extends TTDProcessCustomerMapLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.lti.itops.ipac.custcatmgmt.service.TTDProcessCustomerMapLocalServiceUtil} to access the ttd process customer map local service.
	 */
	public TTDProcessCustomerMap findByTTDProcessIdAndOrgId(long tTDProcessId, long organizationId, int statusId) 
			throws NoSuchTTDProcessCustomerMapException, SystemException {

		return ttdProcessCustomerMapPersistence.findByProcessCustomerMap(
				organizationId, tTDProcessId, statusId);
	}
	
	public List<TTDProcessCustomerMap> findActiveTTDProcessCustomerMap(List<Long> tTDProcessIds, long organizationId)
			throws SystemException 
	{

		if (tTDProcessIds.isEmpty() || tTDProcessIds == null) {
			return new ArrayList<TTDProcessCustomerMap>();
		}
		Class<?> clazz = ttdProcessCustomerMapPersistence.getClass();
		ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDProcessCustomerMap.class, _dynamicQueryClassLoader);
		//DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDProcessCustomerMap.class);
		dq.add(PropertyFactoryUtil.forName("organizationId").eq(organizationId));
		dq.add(PropertyFactoryUtil.forName("TTDProcessId").in(tTDProcessIds));

		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}

		return ttdProcessCustomerMapPersistence.findWithDynamicQuery(dq);
		
	 }
	
	public List<TTDProcessCustomerMap> findTTDProcessCustomerMap(List<Long> tTDProcessIds, long organizationId) throws SystemException {

		if (tTDProcessIds.isEmpty() || tTDProcessIds == null) {
			return new ArrayList<TTDProcessCustomerMap>();
		}
		Class<?> clazz = ttdProcessCustomerMapPersistence.getClass();
		ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDProcessCustomerMap.class, _dynamicQueryClassLoader);
		dq.add(PropertyFactoryUtil.forName("organizationId").eq(organizationId));
		dq.add(PropertyFactoryUtil.forName("TTDProcessId").in(tTDProcessIds));

		return ttdProcessCustomerMapPersistence.findWithDynamicQuery(dq);
		
	 }
	
	
	/*
	 * Portlet implementation class for updating TTechnologyCustomer Mapping
	 */

	public TTDProcessCustomerMap addTTDProcessCustomerMapping(long TTDProcessId, long organizationId,
			Map<Locale, String> name, long companyId, long createdBy, int statusId) throws PortalException,SystemException {
		TTDProcessCustomerMap tTDProcessCustomerMap = TTDProcessCustomerMapUtil
					.create(CounterLocalServiceUtil
							.increment(TTDProcessCustomerMap.class.getName()));
		Date now=new Date();
		tTDProcessCustomerMap.setTTDProcessId(TTDProcessId);
		tTDProcessCustomerMap.setOrganizationId(organizationId);
		tTDProcessCustomerMap.setNameMap(name);
		tTDProcessCustomerMap.setCompanyId(companyId);
		tTDProcessCustomerMap.setCreatedOn(now);
		tTDProcessCustomerMap.setCreatedBy(createdBy);
		tTDProcessCustomerMap.setModifiedBy(createdBy);
		tTDProcessCustomerMap.setModifiedOn(now);
		tTDProcessCustomerMap.setStatusId(statusId);

		return TTDProcessCustomerMapLocalServiceUtil
					.addTTDProcessCustomerMap(tTDProcessCustomerMap);

		
	}


	public TTDProcessCustomerMap updateTTDProcessCustomerMapping(long TTDProcessId,
			long organizationId, long modifiedBy,
			int statusId) throws PortalException, SystemException {

		TTDProcessCustomerMap tTDProcessCustomerMap =TTDProcessCustomerMapUtil
					.findByTTDProcessId(TTDProcessId, organizationId);
		Date now = new Date();
		tTDProcessCustomerMap.setStatusId(statusId);
		tTDProcessCustomerMap.setModifiedOn(now);
		tTDProcessCustomerMap.setModifiedBy(modifiedBy);
		return	TTDProcessCustomerMapLocalServiceUtil
					.updateTTDProcessCustomerMap(tTDProcessCustomerMap);


	}
	
	
	
	public TTDProcessCustomerMap editTTDProcessCustomerMapping(long TTDProcessIdCustomerId,
			long organizationId, Map<Locale, String> name, long companyId, long modifiedBy, int statusId) 
					throws PortalException, SystemException {
		TTDProcessCustomerMap tTDProcessCustomerMap = TTDProcessCustomerMapLocalServiceUtil
					.getTTDProcessCustomerMap(TTDProcessIdCustomerId);
		
		
		Date now = new Date();
		tTDProcessCustomerMap.setNameMap(name);
		tTDProcessCustomerMap.setStatusId(statusId);
		tTDProcessCustomerMap.setModifiedOn(now);
		tTDProcessCustomerMap.setModifiedBy(modifiedBy);

			return TTDProcessCustomerMapLocalServiceUtil
					.updateTTDProcessCustomerMap(tTDProcessCustomerMap);

	}
	
	/*
	 * Get Unique List of TTDProcessIds by list of TTDeliverableIds which are mapped to given project list
	 * 
	 */

	public List<Long> getUniqueTTDPIDsByTTDIDList(List<Organization> projects,List<Long> ttDeliverableIds) throws SystemException {
				
		
		List<Long> ttdProcessIds = TTDProcessMapLocalServiceUtil.getByTTDPIDsByTTDIDs(ttDeliverableIds);
		
		List<Long> projectIds = new ArrayList<Long>();
		
		for(Organization project : projects) {
			
			projectIds.add(project.getOrganizationId());
			
		}
		Class<?> clazz = ttdProcessCustomerMapPersistence.getClass();
		ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDProcessCustomerMap.class, _dynamicQueryClassLoader);
		
		//DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDProcessCustomerMap.class);
		dq.add(PropertyFactoryUtil.forName("organizationId").in(projectIds));
		dq.add(PropertyFactoryUtil.forName("TTDProcessId").in(ttdProcessIds));
		
		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}
		dq.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("TTDProcessId")));

		ttdProcessIds = TTDProcessCustomerMapLocalServiceUtil.dynamicQuery(dq);
		
		return ttdProcessIds;
		
	}
	
}