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

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap;
import com.lti.itops.ipac.custcatmgmt.service.TTDPSPTaskCustomerMapLocalServiceUtil;
import com.lti.itops.ipac.custcatmgmt.service.base.TTDPSPTaskCustomerMapLocalServiceBaseImpl;
import com.lti.itops.ipac.custcatmgmt.service.persistence.TTDPSPTaskCustomerMapUtil;
import com.lti.itops.ipac.custcatmgmt.util.CCStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The implementation of the ttdpsp task customer map local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.lti.itops.ipac.custcatmgmt.service.TTDPSPTaskCustomerMapLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sunprabh
 * @see TTDPSPTaskCustomerMapLocalServiceBaseImpl
 * @see com.lti.itops.ipac.custcatmgmt.service.TTDPSPTaskCustomerMapLocalServiceUtil
 */
public class TTDPSPTaskCustomerMapLocalServiceImpl
	extends TTDPSPTaskCustomerMapLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.lti.itops.ipac.custcatmgmt.service.TTDPSPTaskCustomerMapLocalServiceUtil} to access the ttdpsp task customer map local service.
	 */
	
	public List<TTDPSPTaskCustomerMap> findActiveByOrganizationId(long organizationId) throws SystemException{
		
		Class<?> clazz = ttdpspTaskCustomerMapPersistence.getClass();
		ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDPSPTaskCustomerMap.class, _dynamicQueryClassLoader);
		
		//	DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDPSPTaskCustomerMap.class);
		dq.add(PropertyFactoryUtil.forName("organizationId").eq(organizationId));
	
		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}
	
		return ttdpspTaskCustomerMapPersistence.findWithDynamicQuery(dq);
	
	}

	public List<TTDPSPTaskCustomerMap> findActiveByOrganizationAndSubProcess(long organizationId,long TTDPSubProcessId) throws SystemException {
	
		Class<?> clazz = ttdpspTaskCustomerMapPersistence.getClass();
	    ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDPSPTaskCustomerMap.class, _dynamicQueryClassLoader);
		dq.add(PropertyFactoryUtil.forName("organizationId").eq(organizationId));
		dq.add(PropertyFactoryUtil.forName("TTDPSubProcessId").eq(TTDPSubProcessId));
		
		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}
	
		return ttdpspTaskCustomerMapPersistence.findWithDynamicQuery(dq);
	
	}
	
	public List<TTDPSPTaskCustomerMap> findByOrganizationAndSubProcess(long organizationId,long TTDPSubProcessId) throws SystemException {
		
		Class<?> clazz = ttdpspTaskCustomerMapPersistence.getClass();
	    ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDPSPTaskCustomerMap.class, _dynamicQueryClassLoader);
		dq.add(PropertyFactoryUtil.forName("organizationId").eq(organizationId));
		dq.add(PropertyFactoryUtil.forName("TTDPSubProcessId").eq(TTDPSubProcessId));
		
		return ttdpspTaskCustomerMapPersistence.findWithDynamicQuery(dq);
	
	}

	public List<Long> findAllByOrganizationAndSubProcess(long organizationId,long TTDPSubProcessId) throws SystemException {
		
		Class<?> clazz = ttdpspTaskCustomerMapPersistence.getClass();
	    ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDPSPTaskCustomerMap.class, _dynamicQueryClassLoader);
		dq.add(PropertyFactoryUtil.forName("organizationId").eq(organizationId));
		dq.add(PropertyFactoryUtil.forName("TTDPSubProcessId").eq(TTDPSubProcessId));
		dq.setProjection(ProjectionFactoryUtil.property("taskId"));
		
		return ttdpspTaskCustomerMapPersistence.findWithDynamicQuery(dq);
		
	}

	public List<TTDPSPTaskCustomerMap> findActiveTTDPSPTaskCustomerMap(long TTDPSubProcessId, long organizationId)
			throws SystemException {
	
		Class<?> clazz = ttdpspTaskCustomerMapPersistence.getClass();
	    ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
	
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDPSPTaskCustomerMap.class, _dynamicQueryClassLoader);
		dq.add(PropertyFactoryUtil.forName("organizationId").eq(organizationId));
		dq.add(PropertyFactoryUtil.forName("TTDPSubProcessId").eq(TTDPSubProcessId));
	
		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}
	
		return ttdpspTaskCustomerMapPersistence.findWithDynamicQuery(dq);
		
	 }

	public List<TTDPSPTaskCustomerMap> findActiveTTDPSPTaskCustomerMap(long TTDPSubProcessId, long organizationId, int taskTypeId) throws SystemException{
	
		Class<?> clazz = ttdpspTaskCustomerMapPersistence.getClass();
	    ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDPSPTaskCustomerMap.class, _dynamicQueryClassLoader);
		dq.add(PropertyFactoryUtil.forName("organizationId").eq(organizationId));
		dq.add(PropertyFactoryUtil.forName("TTDPSubProcessId").eq(TTDPSubProcessId));
		dq.add(PropertyFactoryUtil.forName("taskTypeId").eq(taskTypeId));
	
		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}
	
		return ttdpspTaskCustomerMapPersistence.findWithDynamicQuery(dq);
		
	 }


	/*
	 * Portlet implementation class for updating TTechnologyCustomer Mapping
	 */
	
	public TTDPSPTaskCustomerMap addTTDPSPTaskCustomerMapping(long taskId, long tTDPSubProcessId ,long organizationId,
			String name, int taskTypeId, long companyId, long createdBy, int statusId,long doGroupId,
			long linkedTTDPSubprocessCustMapId, long parentTTDPSPTaskCustMapId,  int taskOrderNumber ) throws SystemException,PortalException {
		TTDPSPTaskCustomerMap tTDPSPTaskCustomerMap = TTDPSPTaskCustomerMapUtil
					.create(CounterLocalServiceUtil
							.increment(TTDPSPTaskCustomerMap.class.getName()));
		Date now=new java.util.Date();
		tTDPSPTaskCustomerMap.setTaskId(taskId);
		tTDPSPTaskCustomerMap.setTTDPSubProcessId(tTDPSubProcessId);
		tTDPSPTaskCustomerMap.setOrganizationId(organizationId);
		tTDPSPTaskCustomerMap.setName(name,LocaleUtil.getDefault());
		tTDPSPTaskCustomerMap.setTaskTypeId(taskTypeId);
		tTDPSPTaskCustomerMap.setCompanyId(companyId);
		tTDPSPTaskCustomerMap.setCreatedOn(now);
		tTDPSPTaskCustomerMap.setCreatedBy(createdBy);
		tTDPSPTaskCustomerMap.setModifiedBy(createdBy);
		tTDPSPTaskCustomerMap.setModifiedOn(now);
		tTDPSPTaskCustomerMap.setStatusId(statusId);
		tTDPSPTaskCustomerMap.setDoGroupId(doGroupId);
		
		tTDPSPTaskCustomerMap.setLinkedTTDPSubprocessCustMapId(linkedTTDPSubprocessCustMapId);
		tTDPSPTaskCustomerMap.setParentTTDPSPTaskCustMapId(parentTTDPSPTaskCustMapId);
		tTDPSPTaskCustomerMap.setTaskOrderNumber(taskOrderNumber);
		
		return TTDPSPTaskCustomerMapLocalServiceUtil
					.addTTDPSPTaskCustomerMap(tTDPSPTaskCustomerMap);
	
		
	}
	
	
	public TTDPSPTaskCustomerMap updateTTDPSPTaskCustomerMapping(long taskId, long TTDPSubProcessId,
			long organizationId, long modifiedBy,
			int statusId,long doGroupId) throws PortalException, SystemException {
	
		TTDPSPTaskCustomerMap tTDPSPTaskCustomerMap =TTDPSPTaskCustomerMapUtil
					.findBytaskId(taskId, organizationId);
	
		
	
		Date now = new Date();
		tTDPSPTaskCustomerMap.setStatusId(statusId);
		tTDPSPTaskCustomerMap.setModifiedOn(now);
		tTDPSPTaskCustomerMap.setModifiedBy(modifiedBy);
		tTDPSPTaskCustomerMap.setDoGroupId(doGroupId);
		return 	TTDPSPTaskCustomerMapLocalServiceUtil
					.updateTTDPSPTaskCustomerMap(tTDPSPTaskCustomerMap);
	
	
	
	}
	
	
	
	public TTDPSPTaskCustomerMap editTTDPSPTaskCustomerMapping(long TTDPSPTaskIdCustomerId,
			 Map<Locale, String> name, long companyId, long modifiedBy, int statusId,long doGroupId) 
					throws PortalException, SystemException {
		TTDPSPTaskCustomerMap tTDPSPTaskCustomerMap = TTDPSPTaskCustomerMapLocalServiceUtil
					.getTTDPSPTaskCustomerMap(TTDPSPTaskIdCustomerId);
		
		Date now = new Date();
		tTDPSPTaskCustomerMap.setNameMap(name);
		tTDPSPTaskCustomerMap.setStatusId(statusId);
		tTDPSPTaskCustomerMap.setModifiedOn(now);
		tTDPSPTaskCustomerMap.setModifiedBy(modifiedBy);
		tTDPSPTaskCustomerMap.setDoGroupId(doGroupId);
		return TTDPSPTaskCustomerMapLocalServiceUtil
					.updateTTDPSPTaskCustomerMap(tTDPSPTaskCustomerMap);
	
		
	}
	/*
	 * Get Unique List of TTDPSPTaskIds by list of TTDPSubProcessIds which are mapped to given project list
	 * 
	 */
	
	public List<Long> getUniqueTTDPSPTIDsByTTDPSPIDList(List<Organization> projects,List<Long> ttdpSubProcessIds) throws SystemException {
				
		
		List<Long> taskIds = new ArrayList<Long>();
		
		List<Long> projectIds = new ArrayList<Long>();
		
		for(Organization project : projects) {
			
			projectIds.add(project.getOrganizationId());
			
		}
		
		Class<?> clazz = ttdpspTaskCustomerMapPersistence.getClass();
	    ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
	
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDPSPTaskCustomerMap.class, _dynamicQueryClassLoader);
		dq.add(PropertyFactoryUtil.forName("organizationId").in(projectIds));
		dq.add(PropertyFactoryUtil.forName("TTDPSubProcessId").in(ttdpSubProcessIds));
		//dq.add(PropertyFactoryUtil.forName("taskId").in(taskIds));
		
		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}
	//	dq.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("TTDPSubProcessId")));
	
		dq.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("taskId")));
		
		taskIds = TTDPSPTaskCustomerMapLocalServiceUtil.dynamicQuery(dq);
		
		return taskIds;
		
	}

	//added by surendra
	public List<TTDPSPTaskCustomerMap> findActiveTTDPSPTaskCustomerMap(List<Long> ttdpspTaskIds, long organizationId)
	           throws SystemException {
	
	     if (ttdpspTaskIds.isEmpty() || ttdpspTaskIds == null) {
	           return new ArrayList<TTDPSPTaskCustomerMap>();
	     }
	     Class<?> clazz = ttdpspTaskCustomerMapPersistence.getClass();
	     ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
	     DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDPSPTaskCustomerMap.class, _dynamicQueryClassLoader);
	
	     dq.add(PropertyFactoryUtil.forName("organizationId").eq(organizationId));
	     dq.add(PropertyFactoryUtil.forName("TTDPSubProcessId").in(ttdpspTaskIds)); 
	
	     for (int statusId : CCStatus.DISABLED_STATUSES) {
	           dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
	     }
	
	     return ttdpspTaskCustomerMapPersistence.findWithDynamicQuery(dq);
	
	}
	
	/*
	public List<TTDPSPTaskCustomerMap> findActiveTTDPSPTaskCustomerMapSubTask(long parentTTDPSPTaskCustMapId,
			boolean decision) throws SystemException{
		
		return ttdpspTaskCustomerMapPersistence.findBySubTask(parentTTDPSPTaskCustMapId, decision, CCStatus.ACTIVE_STATUS);
	}
	*/
	
	public List<TTDPSPTaskCustomerMap> findActiveByOrganizationAndSubProcessWithoutSubTask(long organizationId,long TTDPSubProcessId) throws SystemException {
		
		Class<?> clazz = ttdpspTaskCustomerMapPersistence.getClass();
	    ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDPSPTaskCustomerMap.class, _dynamicQueryClassLoader);
		dq.add(PropertyFactoryUtil.forName("organizationId").eq(organizationId));
		dq.add(PropertyFactoryUtil.forName("TTDPSubProcessId").eq(TTDPSubProcessId));
		dq.add(PropertyFactoryUtil.forName("parentTTDPSPTaskCustMapId").eq(0l));
		
		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}

		return ttdpspTaskCustomerMapPersistence.findWithDynamicQuery(dq);
		
	}
	
	public List<TTDPSPTaskCustomerMap> findTTDPSPTaskCustomerMapsWithoutSubTasks(long organizationId,
			long TTDPSubProcessId) throws SystemException {
		
		Class<?> clazz = ttdpspTaskCustomerMapPersistence.getClass();
	    ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDPSPTaskCustomerMap.class, _dynamicQueryClassLoader);
		dq.add(PropertyFactoryUtil.forName("organizationId").eq(organizationId));
		dq.add(PropertyFactoryUtil.forName("TTDPSubProcessId").eq(TTDPSubProcessId));
		dq.add(PropertyFactoryUtil.forName("parentTTDPSPTaskCustMapId").eq(0l));

		return ttdpspTaskCustomerMapPersistence.findWithDynamicQuery(dq);
		
	}
	
	public List<TTDPSPTaskCustomerMap> findAllActiveTTDPSPTaskCustomerMapsWithoutSubTask(long companyId) throws SystemException {
		
		Class<?> clazz = ttdpspTaskCustomerMapPersistence.getClass();
	    ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDPSPTaskCustomerMap.class, _dynamicQueryClassLoader);
		dq.add(PropertyFactoryUtil.forName("companyId").eq(companyId));
		dq.add(PropertyFactoryUtil.forName("parentTTDPSPTaskCustMapId").eq(0l));
		
		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}

		return ttdpspTaskCustomerMapPersistence.findWithDynamicQuery(dq);
		
	}
	
	public List<TTDPSPTaskCustomerMap> findAllActiveTTDPSPTaskCustomerMaps(long companyId) throws SystemException {
		
		Class<?> clazz = ttdpspTaskCustomerMapPersistence.getClass();
	    ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDPSPTaskCustomerMap.class, _dynamicQueryClassLoader);
		dq.add(PropertyFactoryUtil.forName("companyId").eq(companyId));
		
		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}

		return ttdpspTaskCustomerMapPersistence.findWithDynamicQuery(dq);
		
	}
	
	public TTDPSPTaskCustomerMap getTTDPSPTaskCustomerMapBy(long TTDPSubProcessId, long taskId, 
			long organizationId) throws PortalException, SystemException {
		
		return ttdpspTaskCustomerMapPersistence.fetchByTTDPSPTaskCustomerMapBy(TTDPSubProcessId, taskId, organizationId);
	}
	
	public List<TTDPSPTaskCustomerMap> findActiveTTDPSPTaskCustomerMapBy(List<Long> ttdpapTaskCustomerIds)
	           throws SystemException {
	
	     if ( ttdpapTaskCustomerIds == null || ttdpapTaskCustomerIds.isEmpty()  ) {
	           return new ArrayList<TTDPSPTaskCustomerMap>();
	     }
	     Class<?> clazz = ttdpspTaskCustomerMapPersistence.getClass();
	     ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
	     DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDPSPTaskCustomerMap.class, _dynamicQueryClassLoader);
	
	     dq.add(PropertyFactoryUtil.forName("TTDPSPTaskCustomerId").in(ttdpapTaskCustomerIds)); 
	
	     for (int statusId : CCStatus.DISABLED_STATUSES) {
	           dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
	     }
	
	     return ttdpspTaskCustomerMapPersistence.findWithDynamicQuery(dq);
	
	}
	


}