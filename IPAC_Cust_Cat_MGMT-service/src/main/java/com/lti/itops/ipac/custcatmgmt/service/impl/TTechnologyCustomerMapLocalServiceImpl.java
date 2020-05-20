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

import com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTechnologyCustomerMapException;
import com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap;
import com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap;
import com.lti.itops.ipac.custcatmgmt.service.TTechnologyCustomerMapLocalServiceUtil;
import com.lti.itops.ipac.custcatmgmt.service.base.TTechnologyCustomerMapLocalServiceBaseImpl;
import com.lti.itops.ipac.custcatmgmt.service.persistence.TTechnologyCustomerMapUtil;
import com.lti.itops.ipac.custcatmgmt.util.CCStatus;
import com.lti.itops.ipac.spmgmt.model.TowerTechnologyMap;
import com.lti.itops.ipac.spmgmt.service.TowerTechnologyMapLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Organization;

/**
 * The implementation of the t technology customer map local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.lti.itops.ipac.custcatmgmt.service.TTechnologyCustomerMapLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sunprabh
 * @see TTechnologyCustomerMapLocalServiceBaseImpl
 * @see com.lti.itops.ipac.custcatmgmt.service.TTechnologyCustomerMapLocalServiceUtil
 */
public class TTechnologyCustomerMapLocalServiceImpl
	extends TTechnologyCustomerMapLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.lti.itops.ipac.custcatmgmt.service.TTechnologyCustomerMapLocalServiceUtil} to access the t technology customer map local service.
	 */
	public List<TTechnologyCustomerMap> findByT_O(long towerTechnologyId, 
			long organizationId)
			throws SystemException {

		return tTechnologyCustomerMapPersistence.findByT_O(towerTechnologyId, organizationId);
		
	}
	
	
	public long findTTechnologyCustomerId(long towerTechnologyId, 
			long organizationId)
			throws SystemException, NoSuchTTechnologyCustomerMapException {

		return tTechnologyCustomerMapPersistence.findByTowerTechnologyId(towerTechnologyId, organizationId).getTTechnologyCustomerId();
		
	}
	
	public TTechnologyCustomerMap findByTTechnologyCustomerMapId(long TTechnologyCustomerId, 
			long organizationId)
			throws SystemException, NoSuchTTechnologyCustomerMapException {

		return tTechnologyCustomerMapPersistence.findByTTechnologyCustomerId(TTechnologyCustomerId, organizationId);
		
	}
	

	public List<Long> findActiveTTechnologyCustomerTTechnologyIds(long[] towerTechnologyId) throws SystemException 
	{
		Class<?> clazz = tTechnologyCustomerMapPersistence.getClass();
		ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTechnologyCustomerMap.class, _dynamicQueryClassLoader);

		/*DynamicQuery dq = DynamicQueryFactoryUtil
				.forClass(TTechnologyCustomerMap.class);*/
		dq.add(PropertyFactoryUtil.forName("towerTechnologyId").in(towerTechnologyId));
		dq.setProjection(ProjectionFactoryUtil.property("towerId"));

		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}
		return tTechnologyCustomerMapPersistence.findWithDynamicQuery(dq);
	}
	
	
	/*
	 * Method to get the list of TTechnologyCustomerMap based on OrganizationId and towerTechnologyIds
	 */
	public List<TTechnologyCustomerMap> getActiveTTechnologyCustomerMapByorganizationId(long organizationId, List<Long> towerTechnologyIds)
			throws SystemException{
		Class<?> clazz = tTechnologyCustomerMapPersistence.getClass();
		ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTechnologyCustomerMap.class, _dynamicQueryClassLoader);
	
		/*DynamicQuery dq = DynamicQueryFactoryUtil
				.forClass(TTechnologyCustomerMap.class);
*/		dq.add(PropertyFactoryUtil.forName("towerTechnologyId").in(towerTechnologyIds));
		dq.add(PropertyFactoryUtil.forName("organizationId").eq(organizationId));
		
		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}
		
		List<TTechnologyCustomerMap> technologyCustomerMap = TTechnologyCustomerMapUtil.findWithDynamicQuery(dq);
		
		return technologyCustomerMap;
	}
	
	/*
	 * Method to get the list of TTechnologyCustomerMap based on OrganizationId and towerTechnologyIds
	 */
	public List<TTechnologyCustomerMap> getTTechnologyCustomerMapByorganizationId(long organizationId, List<Long> towerTechnologyIds)
			throws SystemException{
		Class<?> clazz = tTechnologyCustomerMapPersistence.getClass();
		ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTechnologyCustomerMap.class, _dynamicQueryClassLoader);
	
		dq.add(PropertyFactoryUtil.forName("towerTechnologyId").in(towerTechnologyIds));
		dq.add(PropertyFactoryUtil.forName("organizationId").eq(organizationId));
		
		List<TTechnologyCustomerMap> technologyCustomerMap = TTechnologyCustomerMapUtil.findWithDynamicQuery(dq);
		
		return technologyCustomerMap;
	}
	

	public List<TTechnologyCustomerMap> getActiveTTechnologyCustomerMap(long tTechnologyCustomerId, 
			long organizationId) throws SystemException{
		Class<?> clazz = tTechnologyCustomerMapPersistence.getClass();
		ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTechnologyCustomerMap.class, _dynamicQueryClassLoader);
	
		/*DynamicQuery dq = DynamicQueryFactoryUtil
				.forClass(TTechnologyCustomerMap.class);*/
		dq.add(PropertyFactoryUtil.forName("organizationId").eq(organizationId));
		dq.add(PropertyFactoryUtil.forName("TTechnologyCustomerId").eq(tTechnologyCustomerId));
		
		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}
		
		List<TTechnologyCustomerMap> technologyCustomerMap = TTechnologyCustomerMapUtil.findWithDynamicQuery(dq);
		
		return technologyCustomerMap;
	}
	

	/*
	 * Portlet implementation class for updating TTechnologyCustomer Mapping
	 */


	public TTechnologyCustomerMap addTTechnologyCustomerMapping(long towerTechnologyId, long organizationId,
			Map<Locale, String> name, long companyId, long createdBy, int statusId) throws SystemException, PortalException {
		TTechnologyCustomerMap tTechnologyCustomerMap = null;
		
	

			tTechnologyCustomerMap = TTechnologyCustomerMapUtil
					.create(CounterLocalServiceUtil
							.increment(TTechnologyCustomerMap.class.getName()));

		Date now=new Date();
		tTechnologyCustomerMap.setTowerTechnologyId(towerTechnologyId);
		tTechnologyCustomerMap.setOrganizationId(organizationId);
		tTechnologyCustomerMap.setNameMap(name);
		tTechnologyCustomerMap.setCompanyId(companyId);
		tTechnologyCustomerMap.setCreatedOn(now);
		tTechnologyCustomerMap.setCreatedBy(createdBy);
		tTechnologyCustomerMap.setStatusId(statusId);
		tTechnologyCustomerMap.setModifiedBy(createdBy);
		tTechnologyCustomerMap.setModifiedOn(now);
		return TTechnologyCustomerMapLocalServiceUtil
					.addTTechnologyCustomerMap(tTechnologyCustomerMap);

	}


	public TTechnologyCustomerMap updateTTechnologyCustomerMapping(long TTechnologyId,
			long organizationId,long modifiedBy,
			int statusId) throws PortalException, SystemException {

		TTechnologyCustomerMap tTechnologyCustomerMap = null;

	


			tTechnologyCustomerMap = TTechnologyCustomerMapUtil
					.findByTowerTechnologyId(TTechnologyId, organizationId);

		

		Date now = new Date();
		tTechnologyCustomerMap.setStatusId(statusId);
		tTechnologyCustomerMap.setModifiedOn(now);
		tTechnologyCustomerMap.setModifiedBy(modifiedBy);

		return TTechnologyCustomerMapLocalServiceUtil
					.updateTTechnologyCustomerMap(tTechnologyCustomerMap);

		

	}
	
	
	
	public TTechnologyCustomerMap editTTechnologyCustomerMapping(long TTechnologyCustomerId,
			long organizationId, Map<Locale, String> name,  long modifiedBy, int statusId) 
					throws PortalException, SystemException {
		TTechnologyCustomerMap tTechnologyCustomerMap;
		
		

			tTechnologyCustomerMap = TTechnologyCustomerMapLocalServiceUtil
					.getTTechnologyCustomerMap(TTechnologyCustomerId);
		
		Date now = new Date();
		tTechnologyCustomerMap.setNameMap(name);
		tTechnologyCustomerMap.setStatusId(statusId);
		tTechnologyCustomerMap.setModifiedOn(now);
		tTechnologyCustomerMap.setModifiedBy(modifiedBy);

		return TTechnologyCustomerMapLocalServiceUtil
					.updateTTechnologyCustomerMap(tTechnologyCustomerMap);

		
	}
	
	/*
	 * Get List of TTechnologyCustomerMaps by list of TowerCustomerMaps
	 * 
	 */
	
	public List<Long> getUniqueTTIDsByTIDList(List<Organization> projects,List<Long> towerIds) throws SystemException {
		
		List<TowerTechnologyMap> tTechnologMaps = TowerTechnologyMapLocalServiceUtil.getByTowerIds(towerIds);
		
		List<Long> tTechnologyIds = new ArrayList<Long>();
		
		List<Long> projectIds = new ArrayList<Long>();
		
		for(TowerTechnologyMap ttm : tTechnologMaps) {
			
			tTechnologyIds.add(ttm.getTowerTechnologyId());
			
		}
				
		for(Organization project : projects) {
			
			projectIds.add(project.getOrganizationId());
			
		}
		Class<?> clazz = tTechnologyCustomerMapPersistence.getClass();
		ClassLoader _dynamicQueryClassLoader = clazz.getClassLoader();
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTechnologyCustomerMap.class, _dynamicQueryClassLoader);
	
		//DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTechnologyCustomerMap.class);
		dq.add(PropertyFactoryUtil.forName("organizationId").in(projectIds));
		dq.add(PropertyFactoryUtil.forName("towerTechnologyId").in(tTechnologyIds));
		
		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}
		dq.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("towerTechnologyId")));

		tTechnologyIds = TTechnologyCustomerMapLocalServiceUtil.dynamicQuery(dq);
		
		return tTechnologyIds;
		
	}

	public TTechnologyCustomerMap findByTowerTechnologyId(long towerTechnologyId,long organizationId) throws NoSuchTTechnologyCustomerMapException, SystemException{
		
		return tTechnologyCustomerMapPersistence.findByTowerTechnologyId(towerTechnologyId, organizationId);
		
	}
	
}