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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable;
import com.lti.itops.ipac.custcatmgmt.service.base.TTDPSPCustDecisionTaskTableLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the ttdpsp cust decision task table local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.lti.itops.ipac.custcatmgmt.service.TTDPSPCustDecisionTaskTableLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sunprabh
 * @see TTDPSPCustDecisionTaskTableLocalServiceBaseImpl
 * @see com.lti.itops.ipac.custcatmgmt.service.TTDPSPCustDecisionTaskTableLocalServiceUtil
 */
public class TTDPSPCustDecisionTaskTableLocalServiceImpl
	extends TTDPSPCustDecisionTaskTableLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.lti.itops.ipac.custcatmgmt.service.TTDPSPCustDecisionTaskTableLocalServiceUtil} to access the ttdpsp cust decision task table local service.
	 */
	
	public TTDPSPCustDecisionTaskTable addTTDPSPCustDecisionTaskTable(long parentTTDPSPTaskCustomerId,long subTTDPSPTaskCustomerId, 
			boolean condition, int order) throws SystemException, PortalException {
		
		TTDPSPCustDecisionTaskTable decisionTaskTable=ttdpspCustDecisionTaskTablePersistence.create(counterLocalService
				.increment(TTDPSPCustDecisionTaskTable.class.getName()));
		decisionTaskTable.setCondition(condition);
		decisionTaskTable.setOrder(order);
		decisionTaskTable.setParentTTDPSPTaskCustomerId(parentTTDPSPTaskCustomerId);
		decisionTaskTable.setSubTTDPSPTaskCustomerId(subTTDPSPTaskCustomerId);
		
		ttdpspCustDecisionTaskTablePersistence.update(decisionTaskTable);
		return decisionTaskTable;
	}
	
	
	public List<TTDPSPCustDecisionTaskTable> getTTDPSPCustDecisionTaskTablesByParentTTDPSPTaskCustId(long parentTTDPSPTaskCustomerId) 
			throws SystemException {
		
		return ttdpspCustDecisionTaskTablePersistence.findByParentTTDPSPTaskCustomerId(parentTTDPSPTaskCustomerId);
	}
	
	public List<TTDPSPCustDecisionTaskTable> getTTDPSPCustDecisionTaskTablesBy(long parentTTDPSPTaskCustomerId, boolean condition) 
			throws SystemException {
		
		return ttdpspCustDecisionTaskTablePersistence.findByParentTTDPSPTaskCustomerIdAndCondition(parentTTDPSPTaskCustomerId,
				condition);
	}
	
	public TTDPSPCustDecisionTaskTable getTTDPSPCustDecisionTaskTableBy(long parentTTDPSPTaskCustomerId, 
			long subTTDPSPTaskCustomerId, boolean condition) throws SystemException {
		
		return ttdpspCustDecisionTaskTablePersistence.fetchByTTDPSPCustDecisionTaskTable(parentTTDPSPTaskCustomerId, 
				subTTDPSPTaskCustomerId, condition);
	}
	
}