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
public class TowerCustomerMapSoap implements Serializable {
	public static TowerCustomerMapSoap toSoapModel(TowerCustomerMap model) {
		TowerCustomerMapSoap soapModel = new TowerCustomerMapSoap();

		soapModel.setTowerCustomerId(model.getTowerCustomerId());
		soapModel.setTowerId(model.getTowerId());
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

	public static TowerCustomerMapSoap[] toSoapModels(TowerCustomerMap[] models) {
		TowerCustomerMapSoap[] soapModels = new TowerCustomerMapSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TowerCustomerMapSoap[][] toSoapModels(
		TowerCustomerMap[][] models) {
		TowerCustomerMapSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TowerCustomerMapSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TowerCustomerMapSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TowerCustomerMapSoap[] toSoapModels(
		List<TowerCustomerMap> models) {
		List<TowerCustomerMapSoap> soapModels = new ArrayList<TowerCustomerMapSoap>(models.size());

		for (TowerCustomerMap model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TowerCustomerMapSoap[soapModels.size()]);
	}

	public TowerCustomerMapSoap() {
	}

	public long getPrimaryKey() {
		return _towerCustomerId;
	}

	public void setPrimaryKey(long pk) {
		setTowerCustomerId(pk);
	}

	public long getTowerCustomerId() {
		return _towerCustomerId;
	}

	public void setTowerCustomerId(long towerCustomerId) {
		_towerCustomerId = towerCustomerId;
	}

	public long getTowerId() {
		return _towerId;
	}

	public void setTowerId(long towerId) {
		_towerId = towerId;
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

	private long _towerCustomerId;
	private long _towerId;
	private long _organizationId;
	private String _name;
	private long _companyId;
	private long _createdBy;
	private Date _createdOn;
	private long _modifiedBy;
	private Date _modifiedOn;
	private int _statusId;
}