/**
 * Copyright (c) 2015 lti. All rights reserved.
 */

package com.lti.itops.ipac.custcatmgmt.permission;

import com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap;
import com.lti.itops.ipac.custcatmgmt.service.TTDeliverableCustomerMapLocalServiceUtil;
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

public class TTDeliverableCustomerMapPermissions {

	
	
	public static boolean isPermissionAdmin(ThemeDisplay themeDisplay,long tTDeliverableCustomerId) throws SystemException, PortalException {
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
		long organizationId = TTDeliverableCustomerMapLocalServiceUtil.getTTDeliverableCustomerMap(tTDeliverableCustomerId).getOrganizationId();
		if (permissionChecker.hasPermission(OrganizationLocalServiceUtil.getOrganization(organizationId).getGroupId(),
						TTDeliverableCustomerMap.class.getName(), tTDeliverableCustomerId,	ActionKeys.PERMISSIONS )) {
			return true;
		} else {			
			return false;
		}
	}
	
}