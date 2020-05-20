/**
 * Copyright (c) 2016 lti. All rights reserved.
 */

package com.lti.itops.ipac.custcatmgmt.permission;

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
public class CatalogPermission {


	

	/**
	 * Checks if the user has view permission for the Customer Catalog
	 * @throws PortalException 
	 * @throws SystemException 
	 */
	public static boolean isCustomerCompleteViewer(ThemeDisplay themeDisplay,
			Organization customer) throws PortalException, SystemException {
		PermissionChecker permissionChecker = themeDisplay
				.getPermissionChecker();

		if (permissionChecker.hasPermission(customer.getParentOrganization().getGroupId(),
				Organization.class.getName(), customer.getParentOrganizationId(),
				CatalogActionKeys.VIEW_SCOPE)
				|| permissionChecker.hasPermission(customer.getParentOrganization().getGroupId(),
						Organization.class.getName(), customer.getParentOrganizationId(),
						CatalogActionKeys.MANAGE_SCOPE)
				|| permissionChecker.hasPermission(customer.getGroupId(),
						Organization.class.getName(),
						customer.getOrganizationId(),
						CatalogActionKeys.VIEW_SCOPE)
				|| permissionChecker.hasPermission(customer.getGroupId(),
						Organization.class.getName(),
						customer.getOrganizationId(),
						CatalogActionKeys.MANAGE_SCOPE)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isCustomerCompleteManager(ThemeDisplay themeDisplay,
			Organization customer) throws PortalException, SystemException {
		PermissionChecker permissionChecker = themeDisplay
				.getPermissionChecker();

		if (permissionChecker.hasPermission(customer.getParentOrganization().getGroupId(),
						Organization.class.getName(), customer.getParentOrganizationId(),
						CatalogActionKeys.MANAGE_SCOPE)
				|| permissionChecker.hasPermission(customer.getGroupId(),
						Organization.class.getName(),
						customer.getOrganizationId(),
						CatalogActionKeys.MANAGE_SCOPE)) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean isCompanyCompleteViewer(ThemeDisplay themeDisplay,Organization companyOrg) throws PortalException,SystemException {
		
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
		
		if (permissionChecker.hasPermission(
				companyOrg.getGroupId(), Organization.class.getName(),
				companyOrg.getOrganizationId(),
				CatalogActionKeys.VIEW_SCOPE ) || permissionChecker.hasPermission(
						companyOrg.getGroupId(), Organization.class.getName(),
						companyOrg.getOrganizationId(),
						CatalogActionKeys.MANAGE_SCOPE )) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	public static boolean isProjectCompleteViewer(ThemeDisplay themeDisplay,
			Organization project) throws PortalException, SystemException {
		PermissionChecker permissionChecker = themeDisplay
				.getPermissionChecker();

		if (permissionChecker.hasPermission(project.getGroupId(),
						Organization.class.getName(),
						project.getOrganizationId(),
						CatalogActionKeys.VIEW_SCOPE)
				|| permissionChecker.hasPermission(project.getGroupId(),
						Organization.class.getName(),
						project.getOrganizationId(),
						CatalogActionKeys.MANAGE_SCOPE) || CatalogPermission.isCustomerCompleteViewer(themeDisplay, project.getParentOrganization())) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isProjectCompleteManager(ThemeDisplay themeDisplay,
			Organization project) throws PortalException, SystemException {
		PermissionChecker permissionChecker = themeDisplay
				.getPermissionChecker();

		if ( permissionChecker.hasPermission(project.getGroupId(),
						Organization.class.getName(),
						project.getOrganizationId(),
						CatalogActionKeys.MANAGE_SCOPE) || CatalogPermission.isCustomerCompleteManager(themeDisplay, project.getParentOrganization())) {
			return true;
		} else {
			return false;
		}
	}
	
}