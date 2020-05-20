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

import com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSubProcessCustomerMapException;
import com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap;
import com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap;
import com.lti.itops.ipac.custcatmgmt.service.TTDPSubProcessCustomerMapLocalServiceUtil;
import com.lti.itops.ipac.custcatmgmt.service.base.TTDPSubProcessCustomerMapLocalServiceBaseImpl;
import com.lti.itops.ipac.custcatmgmt.service.persistence.TTDPSubProcessCustomerMapUtil;
import com.lti.itops.ipac.custcatmgmt.util.CCStatus;
import com.lti.itops.ipac.spmgmt.service.TTDPSubProcessMapLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Organization;

/**
 * The implementation of the ttdp sub process customer map local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.lti.itops.ipac.custcatmgmt.service.TTDPSubProcessCustomerMapLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sunprabh
 * @see TTDPSubProcessCustomerMapLocalServiceBaseImpl
 * @see com.lti.itops.ipac.custcatmgmt.service.TTDPSubProcessCustomerMapLocalServiceUtil
 */
public class TTDPSubProcessCustomerMapLocalServiceImpl
	extends TTDPSubProcessCustomerMapLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.lti.itops.ipac.custcatmgmt.service.TTDPSubProcessCustomerMapLocalServiceUtil} to access the ttdp sub process customer map local service.
	 */
	
	public TTDPSubProcessCustomerMap findByTTDPSubProcessIdAndOrgId(long tTDPSubProcessId, long organizationId, int statusId) 
			throws SystemException, NoSuchTTDPSubProcessCustomerMapException {

		return ttdpSubProcessCustomerMapPersistence.findBySubProcessCustomerMap(organizationId, tTDPSubProcessId, statusId);
	}
	
	
	public List<TTDPSubProcessCustomerMap> findActiveTTDPSubProcessCustomerMap(List<Long> tTDPSubProcessIds, long organizationId)
			throws SystemException 
	{

		if (tTDPSubProcessIds.isEmpty() || tTDPSubProcessIds == null) {
			return new ArrayList<TTDPSubProcessCustomerMap>();
		}
		Class<?> clazz = ttdpSubProcessCustomerMapPersistence.getClass();
		ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDPSubProcessCustomerMap.class, _dynamicQueryClassLoader);
	
	//	DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDPSubProcessCustomerMap.class);
		dq.add(PropertyFactoryUtil.forName("organizationId").eq(organizationId));
		dq.add(PropertyFactoryUtil.forName("TTDPSubProcessId").in(tTDPSubProcessIds));

		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}

		return ttdpSubProcessCustomerMapPersistence.findWithDynamicQuery(dq);
		
	 }
	
	public List<TTDPSubProcessCustomerMap> findTTDPSubProcessCustomerMap(List<Long> tTDPSubProcessIds, long organizationId) throws SystemException {

		if (tTDPSubProcessIds.isEmpty() || tTDPSubProcessIds == null) {
			return new ArrayList<TTDPSubProcessCustomerMap>();
		}
		Class<?> clazz = ttdpSubProcessCustomerMapPersistence.getClass();
		ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDPSubProcessCustomerMap.class, _dynamicQueryClassLoader);
	
		dq.add(PropertyFactoryUtil.forName("organizationId").eq(organizationId));
		dq.add(PropertyFactoryUtil.forName("TTDPSubProcessId").in(tTDPSubProcessIds));

		return ttdpSubProcessCustomerMapPersistence.findWithDynamicQuery(dq);
		
	 }
	
	
	/*
	 * Portlet implementation class for updating TTechnologyCustomer Mapping
	 */

	public TTDPSubProcessCustomerMap addTTDPSubProcessCustomerMapping(long TTDPSubProcessId, long organizationId,
			Map<Locale, String> name, long companyId, long createdBy, int statusId) throws SystemException, PortalException {
		TTDPSubProcessCustomerMap tTDPSubProcessCustomerMap = TTDPSubProcessCustomerMapUtil
					.create(CounterLocalServiceUtil
							.increment(TTDPSubProcessCustomerMap.class.getName()));
		Date now=new java.util.Date();
		tTDPSubProcessCustomerMap.setTTDPSubProcessId(TTDPSubProcessId);
		tTDPSubProcessCustomerMap.setOrganizationId(organizationId);
		tTDPSubProcessCustomerMap.setNameMap(name);
		tTDPSubProcessCustomerMap.setCompanyId(companyId);
		tTDPSubProcessCustomerMap.setCreatedOn(now);
		tTDPSubProcessCustomerMap.setCreatedBy(createdBy);
		tTDPSubProcessCustomerMap.setModifiedBy(createdBy);
		tTDPSubProcessCustomerMap.setModifiedOn(now);
		tTDPSubProcessCustomerMap.setStatusId(statusId);

		return 
			TTDPSubProcessCustomerMapLocalServiceUtil
					.addTTDPSubProcessCustomerMap(tTDPSubProcessCustomerMap);

		
	}


	public TTDPSubProcessCustomerMap updateTTDPSubProcessCustomerMapping(long TTDPSubProcessId,
			long organizationId, long modifiedBy,
			int statusId) throws PortalException, SystemException {

		TTDPSubProcessCustomerMap tTDPSubProcessCustomerMap = TTDPSubProcessCustomerMapUtil
					.findByTTDPSubProcessId(TTDPSubProcessId, organizationId);


		Date now = new Date();
		tTDPSubProcessCustomerMap.setStatusId(statusId);
		tTDPSubProcessCustomerMap.setModifiedOn(now);
		tTDPSubProcessCustomerMap.setModifiedBy(modifiedBy);

	return TTDPSubProcessCustomerMapLocalServiceUtil
					.updateTTDPSubProcessCustomerMap(tTDPSubProcessCustomerMap);



	}
	
	
	public TTDPSubProcessCustomerMap editTTDPSubProcessCustomerMapping(long TTDPSubProcessIdCustomerId,
			 Map<Locale, String> name,  long modifiedBy, int statusId) 
					throws PortalException, SystemException {
		TTDPSubProcessCustomerMap tTDPSubProcessCustomerMap;
		
		
			tTDPSubProcessCustomerMap = TTDPSubProcessCustomerMapLocalServiceUtil
					.getTTDPSubProcessCustomerMap(TTDPSubProcessIdCustomerId);
		
	
		
		Date now = new Date();
		tTDPSubProcessCustomerMap.setNameMap(name);
		tTDPSubProcessCustomerMap.setStatusId(statusId);
		tTDPSubProcessCustomerMap.setModifiedOn(now);
		tTDPSubProcessCustomerMap.setModifiedBy(modifiedBy);

		return 	TTDPSubProcessCustomerMapLocalServiceUtil
					.updateTTDPSubProcessCustomerMap(tTDPSubProcessCustomerMap);

	}
	/*
	 * Get Unique List of TTDPSubProcessIds by list of TTDProcessIds which are mapped to given project list
	 * 
	 */

	public List<Long> getUniqueTTDPSPIDsByTTDPIDList(List<Organization> projects,List<Long> ttdProcessIds) throws SystemException {
		
		List<Long> ttdpSubProcessIds = TTDPSubProcessMapLocalServiceUtil.getTTDPSPIdsByTTDPIds(ttdProcessIds);
		
		List<Long> projectIds = new ArrayList<Long>();
		
		for(Organization project : projects) {
			
			projectIds.add(project.getOrganizationId());
			
		}
		Class<?> clazz = ttdpSubProcessCustomerMapPersistence.getClass();
		ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDPSubProcessCustomerMap.class, _dynamicQueryClassLoader);

		//DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDPSubProcessCustomerMap.class);
		dq.add(PropertyFactoryUtil.forName("organizationId").in(projectIds));
		dq.add(PropertyFactoryUtil.forName("TTDPSubProcessId").in(ttdpSubProcessIds));
		
		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}
		dq.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("TTDPSubProcessId")));

		ttdpSubProcessIds = TTDPSubProcessCustomerMapLocalServiceUtil.dynamicQuery(dq);
		
		return ttdpSubProcessIds;
		
	}
	
	
	public List<TTDPSubProcessCustomerMap> findByOrganizationId(long organizationId)  throws SystemException {

		return ttdpSubProcessCustomerMapPersistence.findByorganizationId(organizationId);
	}
	
	
}