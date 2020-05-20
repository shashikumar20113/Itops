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

import com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TTDeliverableCustomerMap in entity cache.
 *
 * @author sunprabh
 * @see TTDeliverableCustomerMap
 * @generated
 */
@ProviderType
public class TTDeliverableCustomerMapCacheModel implements CacheModel<TTDeliverableCustomerMap>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TTDeliverableCustomerMapCacheModel)) {
			return false;
		}

		TTDeliverableCustomerMapCacheModel ttDeliverableCustomerMapCacheModel = (TTDeliverableCustomerMapCacheModel)obj;

		if (TTDeliverableCustomerId == ttDeliverableCustomerMapCacheModel.TTDeliverableCustomerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, TTDeliverableCustomerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{TTDeliverableCustomerId=");
		sb.append(TTDeliverableCustomerId);
		sb.append(", TTDeliverableId=");
		sb.append(TTDeliverableId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", name=");
		sb.append(name);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TTDeliverableCustomerMap toEntityModel() {
		TTDeliverableCustomerMapImpl ttDeliverableCustomerMapImpl = new TTDeliverableCustomerMapImpl();

		ttDeliverableCustomerMapImpl.setTTDeliverableCustomerId(TTDeliverableCustomerId);
		ttDeliverableCustomerMapImpl.setTTDeliverableId(TTDeliverableId);
		ttDeliverableCustomerMapImpl.setOrganizationId(organizationId);

		if (name == null) {
			ttDeliverableCustomerMapImpl.setName("");
		}
		else {
			ttDeliverableCustomerMapImpl.setName(name);
		}

		ttDeliverableCustomerMapImpl.setCompanyId(companyId);
		ttDeliverableCustomerMapImpl.setCreatedBy(createdBy);

		if (createdOn == Long.MIN_VALUE) {
			ttDeliverableCustomerMapImpl.setCreatedOn(null);
		}
		else {
			ttDeliverableCustomerMapImpl.setCreatedOn(new Date(createdOn));
		}

		ttDeliverableCustomerMapImpl.setModifiedBy(modifiedBy);

		if (modifiedOn == Long.MIN_VALUE) {
			ttDeliverableCustomerMapImpl.setModifiedOn(null);
		}
		else {
			ttDeliverableCustomerMapImpl.setModifiedOn(new Date(modifiedOn));
		}

		ttDeliverableCustomerMapImpl.setStatusId(statusId);

		ttDeliverableCustomerMapImpl.resetOriginalValues();

		return ttDeliverableCustomerMapImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		TTDeliverableCustomerId = objectInput.readLong();

		TTDeliverableId = objectInput.readLong();

		organizationId = objectInput.readLong();
		name = objectInput.readUTF();

		companyId = objectInput.readLong();

		createdBy = objectInput.readLong();
		createdOn = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		modifiedOn = objectInput.readLong();

		statusId = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(TTDeliverableCustomerId);

		objectOutput.writeLong(TTDeliverableId);

		objectOutput.writeLong(organizationId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(createdOn);

		objectOutput.writeLong(modifiedBy);
		objectOutput.writeLong(modifiedOn);

		objectOutput.writeInt(statusId);
	}

	public long TTDeliverableCustomerId;
	public long TTDeliverableId;
	public long organizationId;
	public String name;
	public long companyId;
	public long createdBy;
	public long createdOn;
	public long modifiedBy;
	public long modifiedOn;
	public int statusId;
}