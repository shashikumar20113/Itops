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
 * The extended model interface for the TTDPSPTaskCustomerMap service. Represents a row in the &quot;IPAC_CUST_CAT_MGMT_TTDPSPTaskCustomerMap&quot; database table, with each column mapped to a property of this class.
 *
 * @author sunprabh
 * @see TTDPSPTaskCustomerMapModel
 * @see com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSPTaskCustomerMapImpl
 * @see com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSPTaskCustomerMapModelImpl
 * @generated
 */
@ImplementationClassName("com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSPTaskCustomerMapImpl")
@ProviderType
public interface TTDPSPTaskCustomerMap extends TTDPSPTaskCustomerMapModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSPTaskCustomerMapImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TTDPSPTaskCustomerMap, Long> TTDPSP_TASK_CUSTOMER_ID_ACCESSOR =
		new Accessor<TTDPSPTaskCustomerMap, Long>() {
			@Override
			public Long get(TTDPSPTaskCustomerMap ttdpspTaskCustomerMap) {
				return ttdpspTaskCustomerMap.getTTDPSPTaskCustomerId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TTDPSPTaskCustomerMap> getTypeClass() {
				return TTDPSPTaskCustomerMap.class;
			}
		};
}