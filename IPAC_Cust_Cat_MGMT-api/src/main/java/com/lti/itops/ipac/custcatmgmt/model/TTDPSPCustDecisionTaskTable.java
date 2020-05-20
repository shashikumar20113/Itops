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

package com.lti.itops.ipac.custcatmgmt.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the TTDPSPCustDecisionTaskTable service. Represents a row in the &quot;IPAC_CUST_CAT_MGMT_TTDPSPCustDecisionTaskTable&quot; database table, with each column mapped to a property of this class.
 *
 * @author sunprabh
 * @see TTDPSPCustDecisionTaskTableModel
 * @see com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSPCustDecisionTaskTableImpl
 * @see com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSPCustDecisionTaskTableModelImpl
 * @generated
 */
@ImplementationClassName("com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSPCustDecisionTaskTableImpl")
@ProviderType
public interface TTDPSPCustDecisionTaskTable
	extends TTDPSPCustDecisionTaskTableModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSPCustDecisionTaskTableImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TTDPSPCustDecisionTaskTable, Long> TTDPSP_CUST_DECISION_TASK_TABLE_ID_ACCESSOR =
		new Accessor<TTDPSPCustDecisionTaskTable, Long>() {
			@Override
			public Long get(
				TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable) {
				return ttdpspCustDecisionTaskTable.getTTDPSPCustDecisionTaskTableId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TTDPSPCustDecisionTaskTable> getTypeClass() {
				return TTDPSPCustDecisionTaskTable.class;
			}
		};
}