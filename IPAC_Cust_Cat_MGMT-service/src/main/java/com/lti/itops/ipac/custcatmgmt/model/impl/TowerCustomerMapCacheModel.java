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

import com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TowerCustomerMap in entity cache.
 *
 * @author sunprabh
 * @see TowerCustomerMap
 * @generated
 */
@ProviderType
public class TowerCustomerMapCacheModel implements CacheModel<TowerCustomerMap>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TowerCustomerMapCacheModel)) {
			return false;
		}

		TowerCustomerMapCacheModel towerCustomerMapCacheModel = (TowerCustomerMapCacheModel)obj;

		if (towerCustomerId == towerCustomerMapCacheModel.towerCustomerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, towerCustomerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{towerCustomerId=");
		sb.append(towerCustomerId);
		sb.append(", towerId=");
		sb.append(towerId);
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
	public TowerCustomerMap toEntityModel() {
		TowerCustomerMapImpl towerCustomerMapImpl = new TowerCustomerMapImpl();

		towerCustomerMapImpl.setTowerCustomerId(towerCustomerId);
		towerCustomerMapImpl.setTowerId(towerId);
		towerCustomerMapImpl.setOrganizationId(organizationId);

		if (name == null) {
			towerCustomerMapImpl.setName("");
		}
		else {
			towerCustomerMapImpl.setName(name);
		}

		towerCustomerMapImpl.setCompanyId(companyId);
		towerCustomerMapImpl.setCreatedBy(createdBy);

		if (createdOn == Long.MIN_VALUE) {
			towerCustomerMapImpl.setCreatedOn(null);
		}
		else {
			towerCustomerMapImpl.setCreatedOn(new Date(createdOn));
		}

		towerCustomerMapImpl.setModifiedBy(modifiedBy);

		if (modifiedOn == Long.MIN_VALUE) {
			towerCustomerMapImpl.setModifiedOn(null);
		}
		else {
			towerCustomerMapImpl.setModifiedOn(new Date(modifiedOn));
		}

		towerCustomerMapImpl.setStatusId(statusId);

		towerCustomerMapImpl.resetOriginalValues();

		return towerCustomerMapImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		towerCustomerId = objectInput.readLong();

		towerId = objectInput.readLong();

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
		objectOutput.writeLong(towerCustomerId);

		objectOutput.writeLong(towerId);

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

	public long towerCustomerId;
	public long towerId;
	public long organizationId;
	public String name;
	public long companyId;
	public long createdBy;
	public long createdOn;
	public long modifiedBy;
	public long modifiedOn;
	public int statusId;
}