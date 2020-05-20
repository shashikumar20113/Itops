/**
 * Copyright (c) 2016 lti. All rights reserved.
 */

package com.lti.itops.ipac.custcatmgmt.permission;


import com.lti.itops.ipac.custcatmgmt.util.CustomerConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.theme.ThemeDisplay;


/**
 * Permission util class for customer catalog
 */

/**
 * @author Sunilkumar Prabhakar, Raj Kumar Kulasekaran
 */
public class ProjectCatalogPermission {


	

	/**
	 * Checks if the user has view permission for the project Catalog
	 * @throws PortalException 
	 * @throws SystemException 
	 */
	public static boolean isProjectCatalogViewer(ThemeDisplay themeDisplay,
			Organization project) throws PortalException, SystemException {
		PermissionChecker permissionChecker = themeDisplay
				.getPermissionChecker();

		if (  project.getType().equalsIgnoreCase(CustomerConstants.TYPE_PROJECT)  && (permissionChecker.hasPermission(project.getGroupId(),
						Organization.class.getName(),
						project.getOrganizationId(),
						CatalogActionKeys.VIEW_SCOPE)
				|| permissionChecker.hasPermission(project.getGroupId(),
						Organization.class.getName(),
						project.getOrganizationId(),
						CatalogActionKeys.MANAGE_SCOPE) || CatalogPermission.isCustomerCompleteViewer(themeDisplay, project.getParentOrganization()))) {
			return true;
		} else if(project.getType().equalsIgnoreCase(CustomerConstants.TYPE_COMPANY)  && (permissionChecker.hasPermission(project.getGroupId(),
				Organization.class.getName(),
				project.getOrganizationId(),
				CatalogActionKeys.VIEW_SCOPE)
		|| permissionChecker.hasPermission(project.getGroupId(),
				Organization.class.getName(),
				project.getOrganizationId(),
				CatalogActionKeys.MANAGE_SCOPE) )) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean isProjectCatalogManager(ThemeDisplay themeDisplay,
			Organization project) throws PortalException, SystemException {
		PermissionChecker permissionChecker = themeDisplay
				.getPermissionChecker();

		if ( project.getType().equalsIgnoreCase(CustomerConstants.TYPE_PROJECT)  && (  permissionChecker.hasPermission(project.getGroupId(),
						Organization.class.getName(),
						project.getOrganizationId(),
						CatalogActionKeys.MANAGE_SCOPE) || CatalogPermission.isCustomerCompleteManager(themeDisplay, project.getParentOrganization()))) {
			return true;
		} else if(project.getType().equalsIgnoreCase(CustomerConstants.TYPE_COMPANY)  && ( permissionChecker.hasPermission(project.getGroupId(),
				Organization.class.getName(),
				project.getOrganizationId(),
				CatalogActionKeys.MANAGE_SCOPE) ))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}