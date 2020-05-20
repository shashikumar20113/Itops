/**
 * Copyright (c) 2015 lti. All rights reserved.
 */

package com.lti.itops.ipac.custcatmgmt.permission;

import com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap;
import com.lti.itops.ipac.custcatmgmt.service.TowerCustomerMapLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;


/**
 * Permission util class for customers
 */

/**
 * @author Sunilkumar Prabhakar
 */

public class TowerCustomerMapPermissions {

	
	public static boolean isPermissionAdmin(ThemeDisplay themeDisplay,long towerCustomerId) throws SystemException, PortalException {
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
		long organizationId = TowerCustomerMapLocalServiceUtil.getTowerCustomerMap(towerCustomerId).getOrganizationId();
		if (permissionChecker.hasPermission(OrganizationLocalServiceUtil.getOrganization(organizationId).getGroupId(),
					 TowerCustomerMap.class.getName(), towerCustomerId,	ActionKeys.PERMISSIONS )) {
			return true;
		} else {			
			return false;
		}
	}
	
	
	
	
	
	
	
	
}