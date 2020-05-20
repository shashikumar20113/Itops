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
 * The extended model interface for the TTechnologyCustomerMap service. Represents a row in the &quot;IPAC_CUST_CAT_MGMT_TTechnologyCustomerMap&quot; database table, with each column mapped to a property of this class.
 *
 * @author sunprabh
 * @see TTechnologyCustomerMapModel
 * @see com.lti.itops.ipac.custcatmgmt.model.impl.TTechnologyCustomerMapImpl
 * @see com.lti.itops.ipac.custcatmgmt.model.impl.TTechnologyCustomerMapModelImpl
 * @generated
 */
@ImplementationClassName("com.lti.itops.ipac.custcatmgmt.model.impl.TTechnologyCustomerMapImpl")
@ProviderType
public interface TTechnologyCustomerMap extends TTechnologyCustomerMapModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTechnologyCustomerMapImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TTechnologyCustomerMap, Long> T_TECHNOLOGY_CUSTOMER_ID_ACCESSOR =
		new Accessor<TTechnologyCustomerMap, Long>() {
			@Override
			public Long get(TTechnologyCustomerMap tTechnologyCustomerMap) {
				return tTechnologyCustomerMap.getTTechnologyCustomerId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TTechnologyCustomerMap> getTypeClass() {
				return TTechnologyCustomerMap.class;
			}
		};
}