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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author sunprabh
 * @generated
 */
@ProviderType
public class TTechnologyCustomerMapSoap implements Serializable {
	public static TTechnologyCustomerMapSoap toSoapModel(
		TTechnologyCustomerMap model) {
		TTechnologyCustomerMapSoap soapModel = new TTechnologyCustomerMapSoap();

		soapModel.setTTechnologyCustomerId(model.getTTechnologyCustomerId());
		soapModel.setTowerTechnologyId(model.getTowerTechnologyId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setName(model.getName());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreatedOn(model.getCreatedOn());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setModifiedOn(model.getModifiedOn());
		soapModel.setStatusId(model.getStatusId());

		return soapModel;
	}

	public static TTechnologyCustomerMapSoap[] toSoapModels(
		TTechnologyCustomerMap[] models) {
		TTechnologyCustomerMapSoap[] soapModels = new TTechnologyCustomerMapSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TTechnologyCustomerMapSoap[][] toSoapModels(
		TTechnologyCustomerMap[][] models) {
		TTechnologyCustomerMapSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TTechnologyCustomerMapSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TTechnologyCustomerMapSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TTechnologyCustomerMapSoap[] toSoapModels(
		List<TTechnologyCustomerMap> models) {
		List<TTechnologyCustomerMapSoap> soapModels = new ArrayList<TTechnologyCustomerMapSoap>(models.size());

		for (TTechnologyCustomerMap model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TTechnologyCustomerMapSoap[soapModels.size()]);
	}

	public TTechnologyCustomerMapSoap() {
	}

	public long getPrimaryKey() {
		return _TTechnologyCustomerId;
	}

	public void setPrimaryKey(long pk) {
		setTTechnologyCustomerId(pk);
	}

	public long getTTechnologyCustomerId() {
		return _TTechnologyCustomerId;
	}

	public void setTTechnologyCustomerId(long TTechnologyCustomerId) {
		_TTechnologyCustomerId = TTechnologyCustomerId;
	}

	public long getTowerTechnologyId() {
		return _towerTechnologyId;
	}

	public void setTowerTechnologyId(long towerTechnologyId) {
		_towerTechnologyId = towerTechnologyId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return _createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		_createdOn = createdOn;
	}

	public long getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	public Date getModifiedOn() {
		return _modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		_modifiedOn = modifiedOn;
	}

	public int getStatusId() {
		return _statusId;
	}

	public void setStatusId(int statusId) {
		_statusId = statusId;
	}

	private long _TTechnologyCustomerId;
	private long _towerTechnologyId;
	private long _organizationId;
	private String _name;
	private long _companyId;
	private long _createdBy;
	private Date _createdOn;
	private long _modifiedBy;
	private Date _modifiedOn;
	private int _statusId;
}