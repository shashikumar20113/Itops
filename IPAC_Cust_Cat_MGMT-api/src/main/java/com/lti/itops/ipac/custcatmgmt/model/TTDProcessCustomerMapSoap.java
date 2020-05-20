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
public class TTDProcessCustomerMapSoap implements Serializable {
	public static TTDProcessCustomerMapSoap toSoapModel(
		TTDProcessCustomerMap model) {
		TTDProcessCustomerMapSoap soapModel = new TTDProcessCustomerMapSoap();

		soapModel.setTTDProcessCustomerId(model.getTTDProcessCustomerId());
		soapModel.setTTDProcessId(model.getTTDProcessId());
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

	public static TTDProcessCustomerMapSoap[] toSoapModels(
		TTDProcessCustomerMap[] models) {
		TTDProcessCustomerMapSoap[] soapModels = new TTDProcessCustomerMapSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TTDProcessCustomerMapSoap[][] toSoapModels(
		TTDProcessCustomerMap[][] models) {
		TTDProcessCustomerMapSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TTDProcessCustomerMapSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TTDProcessCustomerMapSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TTDProcessCustomerMapSoap[] toSoapModels(
		List<TTDProcessCustomerMap> models) {
		List<TTDProcessCustomerMapSoap> soapModels = new ArrayList<TTDProcessCustomerMapSoap>(models.size());

		for (TTDProcessCustomerMap model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TTDProcessCustomerMapSoap[soapModels.size()]);
	}

	public TTDProcessCustomerMapSoap() {
	}

	public long getPrimaryKey() {
		return _TTDProcessCustomerId;
	}

	public void setPrimaryKey(long pk) {
		setTTDProcessCustomerId(pk);
	}

	public long getTTDProcessCustomerId() {
		return _TTDProcessCustomerId;
	}

	public void setTTDProcessCustomerId(long TTDProcessCustomerId) {
		_TTDProcessCustomerId = TTDProcessCustomerId;
	}

	public long getTTDProcessId() {
		return _TTDProcessId;
	}

	public void setTTDProcessId(long TTDProcessId) {
		_TTDProcessId = TTDProcessId;
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

	private long _TTDProcessCustomerId;
	private long _TTDProcessId;
	private long _organizationId;
	private String _name;
	private long _companyId;
	private long _createdBy;
	private Date _createdOn;
	private long _modifiedBy;
	private Date _modifiedOn;
	private int _statusId;
}