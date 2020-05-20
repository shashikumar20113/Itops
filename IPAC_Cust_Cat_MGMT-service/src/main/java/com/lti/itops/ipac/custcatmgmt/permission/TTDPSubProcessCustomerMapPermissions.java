/**
 * Copyright (c) 2015 lti. All rights reserved.
 */

package com.lti.itops.ipac.custcatmgmt.permission;

import com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap;
import com.lti.itops.ipac.custcatmgmt.service.TTDPSubProcessCustomerMapLocalServiceUtil;
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

public class TTDPSubProcessCustomerMapPermissions {

	public static boolean isPermissionAdmin(ThemeDisplay themeDisplay,long tTDPSubProcessCustomerId) throws SystemException, PortalException {
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
		long organizationId = TTDPSubProcessCustomerMapLocalServiceUtil.getTTDPSubProcessCustomerMap(tTDPSubProcessCustomerId).getOrganizationId();
		if (permissionChecker.hasPermission(OrganizationLocalServiceUtil.getOrganization(organizationId).getGroupId(),
						TTDPSubProcessCustomerMap.class.getName(), tTDPSubProcessCustomerId,	ActionKeys.PERMISSIONS )) {
			return true;
		} else {			
			return false;
		}
	}
}