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

import com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TTDPSPTaskCustomerMap in entity cache.
 *
 * @author sunprabh
 * @see TTDPSPTaskCustomerMap
 * @generated
 */
@ProviderType
public class TTDPSPTaskCustomerMapCacheModel implements CacheModel<TTDPSPTaskCustomerMap>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TTDPSPTaskCustomerMapCacheModel)) {
			return false;
		}

		TTDPSPTaskCustomerMapCacheModel ttdpspTaskCustomerMapCacheModel = (TTDPSPTaskCustomerMapCacheModel)obj;

		if (TTDPSPTaskCustomerId == ttdpspTaskCustomerMapCacheModel.TTDPSPTaskCustomerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, TTDPSPTaskCustomerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{TTDPSPTaskCustomerId=");
		sb.append(TTDPSPTaskCustomerId);
		sb.append(", TTDPSubProcessId=");
		sb.append(TTDPSubProcessId);
		sb.append(", taskId=");
		sb.append(taskId);
		sb.append(", orderBy=");
		sb.append(orderBy);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", taskTypeId=");
		sb.append(taskTypeId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createdOn=");
		sb.append(createdOn);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", modifiedOn=");
		sb.append(modifiedOn);
		sb.append(", statusId=");
		sb.append(statusId);
		sb.append(", doGroupId=");
		sb.append(doGroupId);
		sb.append(", taskAssessmentId=");
		sb.append(taskAssessmentId);
		sb.append(", parentTTDPSPTaskCustMapId=");
		sb.append(parentTTDPSPTaskCustMapId);
		sb.append(", linkedTTDPSubprocessCustMapId=");
		sb.append(linkedTTDPSubprocessCustMapId);
		sb.append(", taskOrderNumber=");
		sb.append(taskOrderNumber);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TTDPSPTaskCustomerMap toEntityModel() {
		TTDPSPTaskCustomerMapImpl ttdpspTaskCustomerMapImpl = new TTDPSPTaskCustomerMapImpl();

		ttdpspTaskCustomerMapImpl.setTTDPSPTaskCustomerId(TTDPSPTaskCustomerId);
		ttdpspTaskCustomerMapImpl.setTTDPSubProcessId(TTDPSubProcessId);
		ttdpspTaskCustomerMapImpl.setTaskId(taskId);
		ttdpspTaskCustomerMapImpl.setOrderBy(orderBy);
		ttdpspTaskCustomerMapImpl.setOrganizationId(organizationId);

		if (name == null) {
			ttdpspTaskCustomerMapImpl.setName("");
		}
		else {
			ttdpspTaskCustomerMapImpl.setName(name);
		}

		ttdpspTaskCustomerMapImpl.setTaskTypeId(taskTypeId);
		ttdpspTaskCustomerMapImpl.setCompanyId(companyId);
		ttdpspTaskCustomerMapImpl.setCreatedBy(createdBy);

		if (createdOn == Long.MIN_VALUE) {
			ttdpspTaskCustomerMapImpl.setCreatedOn(null);
		}
		else {
			ttdpspTaskCustomerMapImpl.setCreatedOn(new Date(createdOn));
		}

		ttdpspTaskCustomerMapImpl.setModifiedBy(modifiedBy);

		if (modifiedOn == Long.MIN_VALUE) {
			ttdpspTaskCustomerMapImpl.setModifiedOn(null);
		}
		else {
			ttdpspTaskCustomerMapImpl.setModifiedOn(new Date(modifiedOn));
		}

		ttdpspTaskCustomerMapImpl.setStatusId(statusId);
		ttdpspTaskCustomerMapImpl.setDoGroupId(doGroupId);
		ttdpspTaskCustomerMapImpl.setTaskAssessmentId(taskAssessmentId);
		ttdpspTaskCustomerMapImpl.setParentTTDPSPTaskCustMapId(parentTTDPSPTaskCustMapId);
		ttdpspTaskCustomerMapImpl.setLinkedTTDPSubprocessCustMapId(linkedTTDPSubprocessCustMapId);
		ttdpspTaskCustomerMapImpl.setTaskOrderNumber(taskOrderNumber);

		ttdpspTaskCustomerMapImpl.resetOriginalValues();

		return ttdpspTaskCustomerMapImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		TTDPSPTaskCustomerId = objectInput.readLong();

		TTDPSubProcessId = objectInput.readLong();

		taskId = objectInput.readLong();

		orderBy = objectInput.readInt();

		organizationId = objectInput.readLong();
		name = objectInput.readUTF();

		taskTypeId = objectInput.readInt();

		companyId = objectInput.readLong();

		createdBy = objectInput.readLong();
		createdOn = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		modifiedOn = objectInput.readLong();

		statusId = objectInput.readInt();

		doGroupId = objectInput.readLong();

		taskAssessmentId = objectInput.readLong();

		parentTTDPSPTaskCustMapId = objectInput.readLong();

		linkedTTDPSubprocessCustMapId = objectInput.readLong();

		taskOrderNumber = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(TTDPSPTaskCustomerId);

		objectOutput.writeLong(TTDPSubProcessId);

		objectOutput.writeLong(taskId);

		objectOutput.writeInt(orderBy);

		objectOutput.writeLong(organizationId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(taskTypeId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(createdOn);

		objectOutput.writeLong(modifiedBy);
		objectOutput.writeLong(modifiedOn);

		objectOutput.writeInt(statusId);

		objectOutput.writeLong(doGroupId);

		objectOutput.writeLong(taskAssessmentId);

		objectOutput.writeLong(parentTTDPSPTaskCustMapId);

		objectOutput.writeLong(linkedTTDPSubprocessCustMapId);

		objectOutput.writeInt(taskOrderNumber);
	}

	public long TTDPSPTaskCustomerId;
	public long TTDPSubProcessId;
	public long taskId;
	public int orderBy;
	public long organizationId;
	public String name;
	public int taskTypeId;
	public long companyId;
	public long createdBy;
	public long createdOn;
	public long modifiedBy;
	public long modifiedOn;
	public int statusId;
	public long doGroupId;
	public long taskAssessmentId;
	public long parentTTDPSPTaskCustMapId;
	public long linkedTTDPSubprocessCustMapId;
	public int taskOrderNumber;
}