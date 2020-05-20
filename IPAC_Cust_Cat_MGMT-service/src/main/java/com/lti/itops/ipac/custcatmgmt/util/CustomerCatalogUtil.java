/**
 * Copyright (c) 2016 lti. All rights reserved.
 */

package com.lti.itops.ipac.custcatmgmt.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;

/*import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;*/
import com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap;
import com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap;
import com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap;
import com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap;
import com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap;
import com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap;
import com.lti.itops.ipac.custcatmgmt.permission.CatalogActionKeys;
import com.lti.itops.ipac.custcatmgmt.permission.CustomerActionKeys;
import com.lti.itops.ipac.custcatmgmt.service.TTDPSPTaskCustomerMapLocalServiceUtil;
import com.lti.itops.ipac.custcatmgmt.service.TTDPSubProcessCustomerMapLocalServiceUtil;
import com.lti.itops.ipac.custcatmgmt.service.TTDProcessCustomerMapLocalServiceUtil;
import com.lti.itops.ipac.custcatmgmt.service.TTDeliverableCustomerMapLocalServiceUtil;
import com.lti.itops.ipac.custcatmgmt.service.TTechnologyCustomerMapLocalServiceUtil;
import com.lti.itops.ipac.custcatmgmt.service.TowerCustomerMapLocalServiceUtil;
import com.lti.itops.ipac.spmgmt.model.TTDPSubProcessMap;
import com.lti.itops.ipac.spmgmt.model.TTDProcessMap;
import com.lti.itops.ipac.spmgmt.model.TTDeliverableMap;
import com.lti.itops.ipac.spmgmt.model.TowerTechnologyMap;
import com.lti.itops.ipac.spmgmt.service.TTDPSubProcessMapLocalServiceUtil;
import com.lti.itops.ipac.spmgmt.service.TTDProcessMapLocalServiceUtil;
import com.lti.itops.ipac.spmgmt.service.TTDeliverableMapLocalServiceUtil;
import com.lti.itops.ipac.spmgmt.service.TowerTechnologyMapLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;

/**
 * @author Sunilkumar Prabhakar, Raj Kumar Kulasekaran
 */
public class CustomerCatalogUtil {
	


	public static List<Organization> getUserCustomers(ThemeDisplay themeDisplay)
			throws SystemException, PortalException {

		PermissionChecker permissionChecker = themeDisplay
				.getPermissionChecker();

		HashMap<Long, Organization> customerMap = new HashMap<Long, Organization>();

			for (Organization userOrg : OrganizationLocalServiceUtil
					.getUserOrganizations(themeDisplay.getUserId())) {
				if (userOrg.getType().equals(CustomerConstants.TYPE_CUSTOMER)) {
					if (permissionChecker.hasPermission(userOrg.getGroupId(),
							Organization.class.getName(),
							userOrg.getOrganizationId(),
							CustomerActionKeys.VIEW_SCOPE)
							|| permissionChecker.hasPermission(
									userOrg.getGroupId(),
									Organization.class.getName(),
									userOrg.getOrganizationId(),
									CustomerActionKeys.MANAGE_SCOPE)) {

						customerMap.put(userOrg.getOrganizationId(), userOrg);

					} 
				}
					else if(userOrg.getType().equals(CustomerConstants.TYPE_PROJECT))
					{
						if (permissionChecker.hasPermission(userOrg.getGroupId(),
								Organization.class.getName(),
								userOrg.getOrganizationId(),
								CustomerActionKeys.VIEW_SCOPE)
								|| permissionChecker.hasPermission(
										userOrg.getGroupId(),
										Organization.class.getName(),
										userOrg.getOrganizationId(),
										CustomerActionKeys.MANAGE_SCOPE))
										{
											customerMap.put(userOrg.getParentOrganizationId(), userOrg.getParentOrganization());
										}
										}
						}
					
		return new ArrayList<Organization>(customerMap.values());
	}

	
	
	/**
	 * Returns all active projects to which the user belongs and have scope permission based on the
	 * customer ID
	 */
	public static List<Organization> getUserCustomerProjects(
			ThemeDisplay themeDisplay, long customerId) throws SystemException,
			PortalException {

		PermissionChecker permissionChecker = themeDisplay
				.getPermissionChecker();
		List<Organization> projects = new ArrayList<Organization>();	
			for (Organization userOrg : OrganizationLocalServiceUtil
					.getUserOrganizations(themeDisplay.getUserId())) {
				if (userOrg.getType().equals(CustomerConstants.TYPE_PROJECT)
						&& userOrg.getParentOrganizationId() == customerId
						&& userOrg.getStatusId() != CustomerConstants.ORG_DEACTIVATE_STATUS) {
				
					if(permissionChecker.hasPermission(userOrg.getGroupId(),
						Organization.class.getName(),userOrg.getOrganizationId(),
						CatalogActionKeys.VIEW_SCOPE)
						|| permissionChecker.hasPermission(userOrg.getGroupId(),
								Organization.class.getName(),userOrg.getOrganizationId(),
								CatalogActionKeys.MANAGE_SCOPE)){
						
						projects.add(userOrg);
					}
					}
				}
		
		return projects;
	}
	
	/*
	 * Returns all the customer list under a company organization
	 * 
	 */
	
	public static List<Organization> getCompanyCustomers(ThemeDisplay themeDisplay,Organization companyOrg) throws SystemException,
			PortalException {
	
		return OrganizationLocalServiceUtil.search(
					themeDisplay.getCompanyId(),
					companyOrg.getOrganizationId(),
					"", CustomerConstants.TYPE_CUSTOMER, null, null, null,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
	}
	
	/*
	 * Returns all the project list under a customer
	 * 
	 */
	public static List<Organization> getCustomerProjects(ThemeDisplay themeDisplay,Organization customer) throws SystemException,
	PortalException {
	
 		return OrganizationLocalServiceUtil.search(
					themeDisplay.getCompanyId(),
					customer.getOrganizationId(),
					"", CustomerConstants.TYPE_PROJECT, null, null, null,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
	}
	
	/*
	 * Returns all the TowerCustomerMap list for the given project
	 * 
	 */
	
	public static List<TowerCustomerMap> getTowerCustomerMapsByProject(Organization project) throws SystemException,
	PortalException {
		
		return TowerCustomerMapLocalServiceUtil.findActiveTowerCustomerMapByOrganizationId(project.getOrganizationId());
		
	}
	
	/*
	 * Returns all the TTechnologyCustomerMap List for the given towerCustomerMap
	 * 
	 */
	
	public static List<TTechnologyCustomerMap> getTTechnologyCustomerMapsByTower(TowerCustomerMap tcm) throws SystemException,
	PortalException {
	
		Organization project = OrganizationLocalServiceUtil.getOrganization(tcm.getOrganizationId());
			
		List<TowerTechnologyMap> towerTechnologyMaps = TowerTechnologyMapLocalServiceUtil
					.findActiveByTowerId(tcm.getTowerId());
			
		List<Long> towerTechnologyIds = new ArrayList<Long>();
		
		for(TowerTechnologyMap towerTechnologyMap : towerTechnologyMaps){
		
			towerTechnologyIds.add(towerTechnologyMap.getTowerTechnologyId());
			
		}
	 			
		return TTechnologyCustomerMapLocalServiceUtil.getActiveTTechnologyCustomerMapByorganizationId(project.getOrganizationId(), towerTechnologyIds);
		
	}
	
	/*
	 * Returns all the TTDeliverableCustomerMap List for the given ttechnologyCustomerMap
	 * 
	 */
	
	public static List<TTDeliverableCustomerMap> getTTDeliverableCustomerMapsByTTechnology(TTechnologyCustomerMap ttcm) throws SystemException,
	PortalException {
	
		Organization project = OrganizationLocalServiceUtil.getOrganization(ttcm.getOrganizationId());
		
		List<TTDeliverableMap> ttDeliverableMaps = TTDeliverableMapLocalServiceUtil.findActiveByTowerTechnologyId(ttcm.getTowerTechnologyId());
			
		List<Long> ttDeliverableIds = new ArrayList<Long>();
		
		for(TTDeliverableMap ttDeliverableMap : ttDeliverableMaps){
		
			ttDeliverableIds.add(ttDeliverableMap.getTTDeliverableId());
			
		}
	 	
		return TTDeliverableCustomerMapLocalServiceUtil.findActiveTTDeliverableCustomerMap(ttDeliverableIds, project.getOrganizationId());
		
	}
	
	/*
	 * Returns all the TTDProcessCustomerMap List for the given ttDeliverableCustomerMap
	 * 
	 */
	
	public static List<TTDProcessCustomerMap> getTTDProcessCustomerMapsByTTDeliverable(TTDeliverableCustomerMap ttdcm) throws SystemException,
	PortalException {
	
		Organization project = OrganizationLocalServiceUtil.getOrganization(ttdcm.getOrganizationId());
	
		List<TTDProcessMap> ttdProcessMaps = TTDProcessMapLocalServiceUtil.findActiveByTTDeliverableId(ttdcm.getTTDeliverableId());
			
		List<Long> ttdProcessIds = new ArrayList<Long>();
		
		for(TTDProcessMap ttdProcessMap : ttdProcessMaps){
		
			ttdProcessIds.add(ttdProcessMap.getTTDProcessId());
			
		}
	 	
		return TTDProcessCustomerMapLocalServiceUtil.findActiveTTDProcessCustomerMap(ttdProcessIds, project.getOrganizationId());
		
	}
	
	/*
	 * Returns all the TTDPSubProcessCustomerMap List for the given ttdProcesssCustomerMap
	 * 
	 */
	
	public static List<TTDPSubProcessCustomerMap> getTTDSubProcessCustomerMapsByTTDProcess(TTDProcessCustomerMap ttdpcm) throws SystemException,
	PortalException {
	
		Organization project = OrganizationLocalServiceUtil.getOrganization(ttdpcm.getOrganizationId());
	
		List<TTDPSubProcessMap> ttdpSubprocessMaps = TTDPSubProcessMapLocalServiceUtil.findActiveByTTDProcessId(ttdpcm.getTTDProcessId());
			
		List<Long> ttdpSubprocessIds = new ArrayList<Long>();
		
		for(TTDPSubProcessMap ttdpSubprocessMap : ttdpSubprocessMaps){
		
			ttdpSubprocessIds.add(ttdpSubprocessMap.getTTDPSubProcessId());
		
		}
	 	
		return TTDPSubProcessCustomerMapLocalServiceUtil.findActiveTTDPSubProcessCustomerMap(ttdpSubprocessIds, project.getOrganizationId());
		
	}
	
	/*
	 * Returns all the TTDPSPTaskCustomerMap List for the given ttdpSubProcesssCustomerMap
	 * 
	 */
	
	public static List<TTDPSPTaskCustomerMap> getTTDSPTaskCustomerMapsByTTDPSubProcess(TTDPSubProcessCustomerMap ttdpscm) throws SystemException,
	PortalException {
	System.out.println(ttdpscm.getTTDPSubProcessCustomerId());
		Organization project = OrganizationLocalServiceUtil.getOrganization(ttdpscm.getOrganizationId());
	

	 	
		return TTDPSPTaskCustomerMapLocalServiceUtil.findActiveTTDPSPTaskCustomerMap(ttdpscm.getTTDPSubProcessId(), project.getOrganizationId());
		
	}
	
	/*
	 * Get List of projects by list of customers
	 * 
	 */
	
	public static List<Organization> getProjectsByCustList(ThemeDisplay themeDisplay,List<Organization> customers) throws SystemException, PortalException {
		
		List<Organization> projects = new ArrayList<Organization>();
		
		for(Organization customer : customers) {
			
			projects.addAll(getCustomerProjects(themeDisplay, customer));
			
		}
		
		return projects;
		
	}
	
	/*
	 * Get List of TowerCustomerMap by list of projects
	 * 
	 */
	
	public static List<Long> getUniqueTCMsByProjList(List<Organization> projects) throws SystemException {
		
		List<Long> towerIds = new ArrayList<Long>();
		
		List<Long> projectIds = new ArrayList<Long>();
		
		for(Organization project : projects) {
			
			projectIds.add(project.getOrganizationId());
			
		}
		
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TowerCustomerMap.class);
		dq.add(PropertyFactoryUtil.forName("organizationId").in(projectIds));

		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}
		dq.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("towerId")));
		
		towerIds = TowerCustomerMapLocalServiceUtil.dynamicQuery(dq);
		
		return towerIds;

	}
	
	/*
	 * Get List of TTechnologyCustomerMaps by list of TowerCustomerMaps
	 * 
	 */
	
	public static List<Long> getUniqueTTIDsByTIDList(List<Organization> projects,List<Long> towerIds) throws SystemException {
		
		List<TowerTechnologyMap> tTechnologMaps = TowerTechnologyMapLocalServiceUtil.getByTowerIds(towerIds);
		
		List<Long> tTechnologyIds = new ArrayList<Long>();
		
		List<Long> projectIds = new ArrayList<Long>();
		
		for(TowerTechnologyMap ttm : tTechnologMaps) {
			
			tTechnologyIds.add(ttm.getTowerTechnologyId());
			
		}
				
		for(Organization project : projects) {
			
			projectIds.add(project.getOrganizationId());
			
		}

		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTechnologyCustomerMap.class);
		dq.add(PropertyFactoryUtil.forName("organizationId").in(projectIds));
		dq.add(PropertyFactoryUtil.forName("towerTechnologyId").in(tTechnologyIds));
		
		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}
		dq.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("towerTechnologyId")));

		tTechnologyIds = TTechnologyCustomerMapLocalServiceUtil.dynamicQuery(dq);
		
		return tTechnologyIds;
		
	}

	/*
	 * Get Unique List of TTDeliverableIds by list of TTechnologyIds which are mapped to given project list
	 * 
	 */

	public static List<Long> getUniqueTTDIDsByTTIDList(List<Organization> projects,List<Long> tTechnologyIds) throws SystemException {
			
		List<Long> ttDeliverableIds = TTDeliverableMapLocalServiceUtil.getTTDIdsByTTIds(tTechnologyIds);
		
		List<Long> projectIds = new ArrayList<Long>();
		
		for(Organization project : projects) {
			
			projectIds.add(project.getOrganizationId());
			
		}

		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDeliverableCustomerMap.class);
		dq.add(PropertyFactoryUtil.forName("organizationId").in(projectIds));
		dq.add(PropertyFactoryUtil.forName("TTDeliverableId").in(ttDeliverableIds));
		
		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}
		dq.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("TTDeliverableId")));

		ttDeliverableIds = TTDeliverableCustomerMapLocalServiceUtil.dynamicQuery(dq);
		
		return ttDeliverableIds;
		
	}

	/*
	 * Get Unique List of TTDProcessIds by list of TTDeliverableIds which are mapped to given project list
	 * 
	 */

	public static List<Long> getUniqueTTDPIDsByTTDIDList(List<Organization> projects,List<Long> ttDeliverableIds) throws SystemException {
				
		
		List<Long> ttdProcessIds = TTDProcessMapLocalServiceUtil.getByTTDPIDsByTTDIDs(ttDeliverableIds);
		
		List<Long> projectIds = new ArrayList<Long>();
		
		for(Organization project : projects) {
			
			projectIds.add(project.getOrganizationId());
			
		}

		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDProcessCustomerMap.class);
		dq.add(PropertyFactoryUtil.forName("organizationId").in(projectIds));
		dq.add(PropertyFactoryUtil.forName("TTDProcessId").in(ttdProcessIds));
		
		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}
		dq.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("TTDProcessId")));

		ttdProcessIds = TTDProcessCustomerMapLocalServiceUtil.dynamicQuery(dq);
		
		return ttdProcessIds;
		
	}
	
	/*
	 * Get Unique List of TTDPSubProcessIds by list of TTDProcessIds which are mapped to given project list
	 * 
	 */

	public static List<Long> getUniqueTTDPSPIDsByTTDPIDList(List<Organization> projects,List<Long> ttdProcessIds) throws SystemException {
		
		List<Long> ttdpSubProcessIds = TTDPSubProcessMapLocalServiceUtil.getTTDPSPIdsByTTDPIds(ttdProcessIds);
		
		List<Long> projectIds = new ArrayList<Long>();
		
		for(Organization project : projects) {
			
			projectIds.add(project.getOrganizationId());
			
		}

		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDPSubProcessCustomerMap.class);
		dq.add(PropertyFactoryUtil.forName("organizationId").in(projectIds));
		dq.add(PropertyFactoryUtil.forName("TTDPSubProcessId").in(ttdpSubProcessIds));
		
		for (int statusId : CCStatus.DISABLED_STATUSES) {
			dq.add(PropertyFactoryUtil.forName("statusId").ne(statusId));
		}
		dq.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("TTDPSubProcessId")));

		ttdpSubProcessIds = TTDPSubProcessCustomerMapLocalServiceUtil.dynamicQuery(dq);
		
		return ttdpSubProcessIds;
		
	}
	
	/*
	 * Get Unique List of TTDPSPTaskIds by list of TTDPSubProcessIds which are mapped to given project list
	 * 
	 */

	public static List<Long> getUniqueTTDPSPTIDsByTTDPSPIDList(List<Organization> projects,List<Long> ttdpSubProcessIds) throws SystemException {
				
		
		List<Long> taskIds = new ArrayList<Long>();
		
		List<Long> projectIds = new ArrayList<Long>();
		
		for(Organization project : projects) {
			
			projectIds.add(project.getOrganizationId());
			
		}

		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TTDPSPTaskCustomerMap.class);
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
	
	/*
	 *  Get List of nodes for Customers
	 * 
	 */
	
	public static JSONArray getCustomerNodes(Organization companyOrg,ResourceResponse resourceResponse,ThemeDisplay themeDisplay) throws SystemException, PortalException {
		
		List<Organization> customers = getCompanyCustomers(themeDisplay, companyOrg);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for(Organization customer : customers) {
			
			ResourceURL portletURL = resourceResponse.createResourceURL();
    		portletURL.setParameter("id", String.valueOf(customer.getOrganizationId()));
    		portletURL.setParameter(Constants.CMD, "getChildNodesOfCustomer");
    		
    		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
    		
    		jsonObject.put("id", String.valueOf(customer.getOrganizationId()));
    		jsonObject.put("label", customer.getName());
    		jsonObject.put("cache", true);
    		jsonObject.put("children", getChildProjectNodes(customer, resourceResponse, themeDisplay));
			jsonArray.put(jsonObject);  
			
		}
		
		return jsonArray;
		
	}
	
	/*
	 * Get project child nodes for a customer
	 * 
	 */
	
	public static JSONArray getChildProjectNodes(Organization customer,ResourceResponse resourceResponse,ThemeDisplay themeDisplay) throws SystemException, PortalException {
		
		List<Organization> projects = getCustomerProjects(themeDisplay, customer);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for(Organization project : projects) {
			
			ResourceURL portletURL = resourceResponse.createResourceURL();
    		portletURL.setParameter("id", String.valueOf(project.getOrganizationId()));
    		portletURL.setParameter(Constants.CMD, "getChildNodesOfProject");
    		
    		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
    		jsonObject.put("type", "io");
    		jsonObject.put("id", String.valueOf(project.getOrganizationId()));
    		jsonObject.put("label", project.getName());
    		jsonObject.put("cache", true);
    		jsonObject.put("io", portletURL.toString());
			jsonArray.put(jsonObject);  
			
		}
		
		return jsonArray;
		
	}
	
	/*
	 * Get TowerCustomerMap child nodes for a project
	 * 
	 */
	
	public static JSONArray getChildTowerCustomerNodes(Organization project,ResourceResponse resourceResponse,ThemeDisplay themeDisplay) throws SystemException, PortalException {
		
		List<TowerCustomerMap> tcms = getTowerCustomerMapsByProject(project);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for(TowerCustomerMap tcm : tcms) {
			
			ResourceURL portletURL = resourceResponse.createResourceURL();
    		portletURL.setParameter("id", String.valueOf(tcm.getTowerCustomerId()));
    		portletURL.setParameter(Constants.CMD, "getChildNodesOfTowerCustomer");
    		
    		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
    		jsonObject.put("type", "io");
    		jsonObject.put("id", String.valueOf(tcm.getTowerCustomerId()));
    		jsonObject.put("label", tcm.getName(themeDisplay.getLocale()));
    		jsonObject.put("cache", true);
    		jsonObject.put("io", portletURL.toString());
			jsonArray.put(jsonObject);  
			
		}
		
		return jsonArray;
		
	}
	
	/*
	 * Get TTechnologyCustomerMap child nodes for a towerCustomerMap
	 * 
	 */
	
	public static JSONArray getChildTTechnologyCustomerNodes(TowerCustomerMap tcm,ResourceResponse resourceResponse,ThemeDisplay themeDisplay) throws SystemException, PortalException {
		
		List<TTechnologyCustomerMap> ttcms = getTTechnologyCustomerMapsByTower(tcm);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for(TTechnologyCustomerMap ttcm : ttcms) {
			
			ResourceURL portletURL = resourceResponse.createResourceURL();
    		portletURL.setParameter("id", String.valueOf(ttcm.getTTechnologyCustomerId()));
    		portletURL.setParameter(Constants.CMD, "getChildNodesOfTTechnologyCustomer");
    		
    		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
    		jsonObject.put("type", "io");
    		jsonObject.put("id", String.valueOf(ttcm.getTTechnologyCustomerId()));
    		jsonObject.put("label", ttcm.getName(themeDisplay.getLocale()));
    		jsonObject.put("cache", true);
    		jsonObject.put("io", portletURL.toString());
			jsonArray.put(jsonObject);  
			
		}
		
		return jsonArray;
		
	}
	/*
	 * Get TTDeliverableCustomerMap child nodes for a ttechnologyCustomerMap
	 * 
	 */
	
	public static JSONArray getChildTTDeliverableCustomerNodes(TTechnologyCustomerMap ttcm,ResourceResponse resourceResponse,ThemeDisplay themeDisplay) throws SystemException, PortalException {
		
		List<TTDeliverableCustomerMap> ttdcms = getTTDeliverableCustomerMapsByTTechnology(ttcm);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for(TTDeliverableCustomerMap ttdcm : ttdcms) {
			
			ResourceURL portletURL = resourceResponse.createResourceURL();
    		portletURL.setParameter("id", String.valueOf(ttdcm.getTTDeliverableCustomerId()));
    		portletURL.setParameter(Constants.CMD, "getChildNodesOfTTDeliverableCustomer");
    		
    		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
    		jsonObject.put("type", "io");
    		jsonObject.put("id", String.valueOf(ttdcm.getTTDeliverableCustomerId()));
    		jsonObject.put("label", ttdcm.getName(themeDisplay.getLocale()));
    		jsonObject.put("cache", true);
    		jsonObject.put("io", portletURL.toString());
			jsonArray.put(jsonObject);  
			
		}
		
		return jsonArray;
		
	}
	
	/*
	 * Get TTDProcessCustomerMap child nodes for a ttDeliverableCustomerMap
	 * 
	 */
	
	public static JSONArray getChildTTDProcessCustomerNodes(TTDeliverableCustomerMap ttdcm,ResourceResponse resourceResponse,ThemeDisplay themeDisplay) throws SystemException, PortalException {
		
		List<TTDProcessCustomerMap> ttdpcms = getTTDProcessCustomerMapsByTTDeliverable(ttdcm);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for(TTDProcessCustomerMap ttdpcm : ttdpcms) {
			
			ResourceURL portletURL = resourceResponse.createResourceURL();
    		portletURL.setParameter("id", String.valueOf(ttdpcm.getTTDProcessCustomerId()));
    		portletURL.setParameter(Constants.CMD, "getChildNodesOfTTDProcessCustomer");
    		
    		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
    		jsonObject.put("type", "io");
    		jsonObject.put("id", String.valueOf(ttdpcm.getTTDProcessCustomerId()));
    		jsonObject.put("label", ttdpcm.getName(themeDisplay.getLocale()));
    		jsonObject.put("cache", true);
    		jsonObject.put("io", portletURL.toString());
			jsonArray.put(jsonObject);  
			
		}
		
		return jsonArray;
		
	}
	
	/*
	 * Get TTDPSubProcessCustomerMap child nodes for a ttdProcessCustomerMap
	 * 
	 */
	
	public static JSONArray getChildTTDPSubProcessCustomerNodes(TTDProcessCustomerMap ttdpcm,ResourceResponse resourceResponse,ThemeDisplay themeDisplay) throws SystemException, PortalException {
		
		List<TTDPSubProcessCustomerMap> ttdpscms = getTTDSubProcessCustomerMapsByTTDProcess(ttdpcm);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for(TTDPSubProcessCustomerMap ttdpscm : ttdpscms) {
			
			ResourceURL portletURL = resourceResponse.createResourceURL();
    		portletURL.setParameter("id", String.valueOf(ttdpscm.getTTDPSubProcessCustomerId()));
    		portletURL.setParameter(Constants.CMD, "getChildNodesOfTTDPSubProcessCustomer");
    		
    		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
    		jsonObject.put("type", "io");
    		jsonObject.put("id", String.valueOf(ttdpscm.getTTDPSubProcessCustomerId()));
    		jsonObject.put("label", ttdpscm.getName(themeDisplay.getLocale()));
    		jsonObject.put("cache", true);
    		jsonObject.put("io", portletURL.toString());
			jsonArray.put(jsonObject);  
			
		}
		
		return jsonArray;
		
	}
	
	/*
	 * Get TTDPSPTaskCustomerMap child nodes for a ttdpSubProcessCustomerMap
	 * 
	 */
	
	public static JSONArray getChildTTDPSPTaskCustomerNodes(TTDPSubProcessCustomerMap ttdpscm,ResourceResponse resourceResponse,ThemeDisplay themeDisplay) throws SystemException, PortalException {
		
		List<TTDPSPTaskCustomerMap> ttdpsptcms = getTTDSPTaskCustomerMapsByTTDPSubProcess(ttdpscm);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		for(TTDPSPTaskCustomerMap ttdpsptcm : ttdpsptcms) {
			
    		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
    		
    		jsonObject.put("leaf",true); 
    		jsonObject.put("id", String.valueOf(ttdpsptcm.getTTDPSPTaskCustomerId()));
    		jsonObject.put("label", ttdpsptcm.getName(themeDisplay.getLocale()));
    		
			jsonArray.put(jsonObject);  
			
			
		}
		
		return jsonArray;
		
	}
	
}