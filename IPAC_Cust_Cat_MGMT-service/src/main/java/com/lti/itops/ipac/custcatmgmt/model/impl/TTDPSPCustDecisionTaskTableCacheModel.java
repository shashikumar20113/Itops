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

package com.lti.itops.ipac.custcatmgmt.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TTDPSPCustDecisionTaskTable in entity cache.
 *
 * @author sunprabh
 * @see TTDPSPCustDecisionTaskTable
 * @generated
 */
@ProviderType
public class TTDPSPCustDecisionTaskTableCacheModel implements CacheModel<TTDPSPCustDecisionTaskTable>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TTDPSPCustDecisionTaskTableCacheModel)) {
			return false;
		}

		TTDPSPCustDecisionTaskTableCacheModel ttdpspCustDecisionTaskTableCacheModel =
			(TTDPSPCustDecisionTaskTableCacheModel)obj;

		if (TTDPSPCustDecisionTaskTableId == ttdpspCustDecisionTaskTableCacheModel.TTDPSPCustDecisionTaskTableId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, TTDPSPCustDecisionTaskTableId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{TTDPSPCustDecisionTaskTableId=");
		sb.append(TTDPSPCustDecisionTaskTableId);
		sb.append(", subTTDPSPTaskCustomerId=");
		sb.append(subTTDPSPTaskCustomerId);
		sb.append(", condition=");
		sb.append(condition);
		sb.append(", order=");
		sb.append(order);
		sb.append(", parentTTDPSPTaskCustomerId=");
		sb.append(parentTTDPSPTaskCustomerId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TTDPSPCustDecisionTaskTable toEntityModel() {
		TTDPSPCustDecisionTaskTableImpl ttdpspCustDecisionTaskTableImpl = new TTDPSPCustDecisionTaskTableImpl();

		ttdpspCustDecisionTaskTableImpl.setTTDPSPCustDecisionTaskTableId(TTDPSPCustDecisionTaskTableId);
		ttdpspCustDecisionTaskTableImpl.setSubTTDPSPTaskCustomerId(subTTDPSPTaskCustomerId);
		ttdpspCustDecisionTaskTableImpl.setCondition(condition);
		ttdpspCustDecisionTaskTableImpl.setOrder(order);
		ttdpspCustDecisionTaskTableImpl.setParentTTDPSPTaskCustomerId(parentTTDPSPTaskCustomerId);

		ttdpspCustDecisionTaskTableImpl.resetOriginalValues();

		return ttdpspCustDecisionTaskTableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		TTDPSPCustDecisionTaskTableId = objectInput.readLong();

		subTTDPSPTaskCustomerId = objectInput.readLong();

		condition = objectInput.readBoolean();

		order = objectInput.readInt();

		parentTTDPSPTaskCustomerId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(TTDPSPCustDecisionTaskTableId);

		objectOutput.writeLong(subTTDPSPTaskCustomerId);

		objectOutput.writeBoolean(condition);

		objectOutput.writeInt(order);

		objectOutput.writeLong(parentTTDPSPTaskCustomerId);
	}

	public long TTDPSPCustDecisionTaskTableId;
	public long subTTDPSPTaskCustomerId;
	public boolean condition;
	public int order;
	public long parentTTDPSPTaskCustomerId;
}