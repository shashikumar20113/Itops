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
import java.util.Set;

import com.lti.itops.ipac.custcatmgmt.exception.NoSuchTowerCustomerMapException;
import com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap;
import com.lti.itops.ipac.custcatmgmt.service.TowerCustomerMapLocalServiceUtil;
import com.lti.itops.ipac.custcatmgmt.service.base.TowerCustomerMapLocalServiceBaseImpl;
import com.lti.itops.ipac.custcatmgmt.service.persistence.TowerCustomerMapUtil;
import com.lti.itops.ipac.custcatmgmt.util.CCStatus;
import com.lti.itops.ipac.spmgmt.model.Tower;
import com.lti.itops.ipac.spmgmt.service.TowerLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.concurrent.ConcurrentHashSet;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;

/**
 * The implementation of the tower customer map local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.lti.itops.ipac.custcatmgmt.service.TowerCustomerMapLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sunprabh
 * @see TowerCustomerMapLocalServiceBaseImpl
 * @see com.lti.itops.ipac.custcatmgmt.service.TowerCustomerMapLocalServiceUtil
 */
public class TowerCustomerMapLocalServiceImpl
	extends TowerCustomerMapLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.lti.itops.ipac.custcatmgmt.service.TowerCustomerMapLocalServiceUtil} to access the tower customer map local service.
	 */
	//added for sonar fix by shashi and added this _log inside all catch blocks
	private static final Log _log = LogFactoryUtil
			.getLog(TowerCustomerMapLocalServiceImpl.class);
	
	public List<TowerCustomerMap> findActiveTowerCustomerMapByOrganizationId(long organizationId)
			throws SystemException 
	{
		Class<?> clazz = towerCustomerMapPersistence.getClass();
		ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TowerCustomerMap.class, _dynamicQueryClassLoader); 
		
		//DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TowerCustomerMap.class);
		dq.add(PropertyFactoryUtil.forName("organizationId").eq(organizationId));

		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}
		List<TowerCustomerMap> towerCustomerMaps=new ArrayList<TowerCustomerMap>();
		towerCustomerMaps = towerCustomerMapPersistence.findWithDynamicQuery(dq);
		
		return towerCustomerMaps;
	}
	
	
	public List<TowerCustomerMap> findTowerCustomerMapByOrganizationId(long organizationId) throws SystemException {
		Class<?> clazz = towerCustomerMapPersistence.getClass();
		ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TowerCustomerMap.class, _dynamicQueryClassLoader); 
		
		//DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TowerCustomerMap.class);
		dq.add(PropertyFactoryUtil.forName("organizationId").eq(organizationId));

		List<TowerCustomerMap> towerCustomerMaps=new ArrayList<TowerCustomerMap>();
		towerCustomerMaps = towerCustomerMapPersistence.findWithDynamicQuery(dq);
		
		return towerCustomerMaps;
	}
	
	
	public List<TowerCustomerMap> findActiveUserTowerCustomerByOrganization(long organizationId,long groupId)
			throws SystemException 
	{
		Class<?> clazz = towerCustomerMapPersistence.getClass();
		ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TowerCustomerMap.class, _dynamicQueryClassLoader); 
		
		//DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TowerCustomerMap.class);
		dq.add(PropertyFactoryUtil.forName("organizationId").eq(organizationId));

		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}
		List<TowerCustomerMap> towerCustomerMaps=new ArrayList<TowerCustomerMap>();
		towerCustomerMaps = towerCustomerMapPersistence.findWithDynamicQuery(dq);

		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		List<TowerCustomerMap> userTowerCustomerMaps=new ArrayList<TowerCustomerMap>();
		for(TowerCustomerMap towerCustomerMap:towerCustomerMaps)
		{
			if(permissionChecker.hasPermission(groupId, TowerCustomerMap.class.getName(),towerCustomerMap.getTowerCustomerId(),ActionKeys.VIEW)
					|| permissionChecker.hasPermission(groupId, TowerCustomerMap.class.getName(),towerCustomerMap.getTowerCustomerId(),ActionKeys.MANAGE))
			{
				userTowerCustomerMaps.add(towerCustomerMap);
			}
		}
		
		return userTowerCustomerMaps;
	}


	public List<Long> findActiveTowerCustomerTowerIds(long[] towerId) throws SystemException 
	{
		Class<?> clazz = towerCustomerMapPersistence.getClass();
		ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TowerCustomerMap.class, _dynamicQueryClassLoader); 
		
		
		//DynamicQuery dq = DynamicQueryFactoryUtil
		//		.forClass(TowerCustomerMap.class);
		dq.add(PropertyFactoryUtil.forName("towerId").in(towerId));
		dq.setProjection(ProjectionFactoryUtil.property("towerId"));

		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}
		return towerCustomerMapPersistence.findWithDynamicQuery(dq);
	}
	

	public long getTowerCustomerMapByTowerId(long towerId, long organizationId)
			throws SystemException, NoSuchTowerCustomerMapException {
		return towerCustomerMapPersistence.fetchByT_O(towerId, organizationId)
				.getTowerCustomerId();
	}
	

	public TowerCustomerMap getTowerCustomerMap(long towerId, long organizationId)
			throws SystemException, NoSuchTowerCustomerMapException {
		return towerCustomerMapPersistence.fetchByT_O(towerId, organizationId);
	}

	/*
	 * Portlet implementation class for updating TowerCustomer Mapping
	 */



	public TowerCustomerMap addTowerCustomerMapping(long towerId, long organizationId,
			String name, long companyId, long createdBy, int statusId) throws SystemException{
		TowerCustomerMap towerCustomerMap = TowerCustomerMapUtil
						.create(CounterLocalServiceUtil
								.increment(TowerCustomerMap.class.getName()));
			

		Date now=new Date();
		towerCustomerMap.setTowerId(towerId);
		towerCustomerMap.setName(name,LocaleUtil.getDefault());
		towerCustomerMap.setOrganizationId(organizationId);
		towerCustomerMap.setCompanyId(companyId);
		towerCustomerMap.setCreatedOn(now);
		towerCustomerMap.setCreatedBy(createdBy);
		towerCustomerMap.setStatusId(statusId);
		towerCustomerMap.setModifiedBy(createdBy);
		towerCustomerMap.setModifiedOn(now);

		return	TowerCustomerMapLocalServiceUtil
					.addTowerCustomerMap(towerCustomerMap);

		
	}
	


	public TowerCustomerMap updateTowerCustomerMapping(long towerId,
			long organizationId,  long modifiedBy, int statusId) throws PortalException, SystemException {
		TowerCustomerMap towerCustomerMap = TowerCustomerMapUtil.findByT_O(towerId, organizationId);
				
		Date now = new Date();
		towerCustomerMap.setStatusId(statusId);
		towerCustomerMap.setModifiedOn(now);
		towerCustomerMap.setModifiedBy(modifiedBy);

		return TowerCustomerMapLocalServiceUtil
					.updateTowerCustomerMap(towerCustomerMap);

	}

	
	
	public TowerCustomerMap editTowerCustomerMapping(long towerCustomerMapId,
			Map<Locale, String> name,  long modifiedBy, int statusId) throws PortalException, SystemException {
		TowerCustomerMap towerCustomerMap = TowerCustomerMapLocalServiceUtil
					.getTowerCustomerMap(towerCustomerMapId);
	
		Date now = new Date();
		towerCustomerMap.setNameMap(name);
		towerCustomerMap.setStatusId(statusId);
		towerCustomerMap.setModifiedOn(now);
		towerCustomerMap.setModifiedBy(modifiedBy);

		return TowerCustomerMapLocalServiceUtil
					.updateTowerCustomerMap(towerCustomerMap);

	}
	
	/*
	 * Get List of TowerCustomerMap by list of projects
	 * 
	 */
	
	public List<Long> getUniqueTCMsByProjList(List<Organization> projects) throws SystemException {
		
		List<Long> towerIds = new ArrayList<Long>();
		
		List<Long> projectIds = new ArrayList<Long>();
		
		for(Organization project : projects) {
			
			projectIds.add(project.getOrganizationId());
			
		}
		Class<?> clazz = towerCustomerMapPersistence.getClass();
		ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TowerCustomerMap.class, _dynamicQueryClassLoader); 
		
		
		//DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TowerCustomerMap.class);
		dq.add(PropertyFactoryUtil.forName("organizationId").in(projectIds));

		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}
		dq.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("towerId")));
		
		towerIds = TowerCustomerMapLocalServiceUtil.dynamicQuery(dq);
		
		return towerIds;

	}
	public TowerCustomerMap findByT_O(long towerId,long organizationId) throws NoSuchTowerCustomerMapException, SystemException
	{
		return  towerCustomerMapPersistence.findByT_O(towerId, organizationId);
		
	}
	
	/*Get the List of Distinct Customers based on towerIds */
	public Set<Long> findActiveCustomerIdsByTowerIds(long[] towerId) throws SystemException 
	{
		Class<?> clazz = towerCustomerMapPersistence.getClass();
		ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TowerCustomerMap.class, _dynamicQueryClassLoader); 
		
		/*DynamicQuery dq = DynamicQueryFactoryUtil
				.forClass(TowerCustomerMap.class);*/
		dq.add(PropertyFactoryUtil.forName("towerId").in(towerId));
		dq.setProjection(ProjectionFactoryUtil.property("organizationId"));

		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}
		
		List<Long> projectIdList= towerCustomerMapPersistence.findWithDynamicQuery(dq);
		 Set<Long> distinctCustomerIdList = new ConcurrentHashSet<Long>();
		 for(long projectId:projectIdList)
		 {
			 Organization project=null;
			try {
				project = OrganizationLocalServiceUtil.getOrganization(projectId);
				long customerId = project.getParentOrganizationId();
				distinctCustomerIdList.add(customerId);
			} catch (PortalException e) {
			
				_log.info("Unable to find active customerIds by tower Ids : "
						+ e.getMessage());
			}
			 
		 }
		
		
		
		return distinctCustomerIdList;
	}
	
	/*Get the List of customers based on tower Id*/
	public List<Organization> getCustomersByTowerId(long towerId) throws SystemException
	{
		List<Organization> customerList = new ArrayList<>();
		if(towerId!=0)
		{
		
		List<Long> projectIdList = new ArrayList<>();
		Class<?> clazz = towerCustomerMapPersistence.getClass();
		ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TowerCustomerMap.class, _dynamicQueryClassLoader); 
		
		
		/*DynamicQuery dq = DynamicQueryFactoryUtil
				.forClass(TowerCustomerMap.class);*/
		dq.add(PropertyFactoryUtil.forName("towerId").eq(towerId));
		dq.setProjection(ProjectionFactoryUtil.property("organizationId"));

		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}
		projectIdList=towerCustomerMapPersistence.findWithDynamicQuery(dq);
		for(Long projectId:projectIdList)
		{
			if(projectId!=0)
			{
			try {
				
				Organization project=OrganizationLocalServiceUtil.getOrganization(projectId);
				long customerId=project.getParentOrganizationId();
				if(customerId!=0){
				Organization customer = OrganizationLocalServiceUtil.getOrganization(customerId);
				customerList.add(customer);
			}
			} catch (PortalException e) {
				
				
				_log.info("Unable to get customers by Tower Id : "
						+ e.getMessage());
			}
			}
		}
		}
		
		return customerList;
	}
	/*Get the List of tower based on customer Id*/
	public List<Tower> getTowersByCustomerId(ThemeDisplay themeDisplay,long customerId) throws SystemException
	{
		List<Long> towerIdList = new ArrayList<>();
		List<Tower> towerList = new ArrayList<>();
		
		if(customerId!=0)
		{
		List<Organization> projectList = OrganizationLocalServiceUtil.getOrganizations(themeDisplay.getCompanyId(), customerId);
		
		
		for(Organization project:projectList)
		{
			Class<?> clazz = towerCustomerMapPersistence.getClass();
			ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
			DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TowerCustomerMap.class, _dynamicQueryClassLoader); 
			
			
			//DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TowerCustomerMap.class);
			dq.add(PropertyFactoryUtil.forName("organizationId").eq(project.getOrganizationId()));
			dq.setProjection(ProjectionFactoryUtil.property("towerId"));
			for (int statusId : CCStatus.DISABLED_STATUSES) {
				dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
			}
			towerIdList.addAll(towerCustomerMapPersistence.findWithDynamicQuery(dq));
		}
		for(Long towerId:towerIdList)
		{
			if(towerId!=0)
			{
			try {
				Tower tower =  TowerLocalServiceUtil.getTower(towerId);
				towerList.add(tower);
			} catch (PortalException e) {
				
				_log.info("Unable to get towers by customer id : "
						+ e.getMessage());
			}
			}
		}
		}
		
		return towerList;
	}
}