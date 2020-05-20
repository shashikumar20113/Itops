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
public class TTDPSPTaskCustomerMapSoap implements Serializable {
	public static TTDPSPTaskCustomerMapSoap toSoapModel(
		TTDPSPTaskCustomerMap model) {
		TTDPSPTaskCustomerMapSoap soapModel = new TTDPSPTaskCustomerMapSoap();

		soapModel.setTTDPSPTaskCustomerId(model.getTTDPSPTaskCustomerId());
		soapModel.setTTDPSubProcessId(model.getTTDPSubProcessId());
		soapModel.setTaskId(model.getTaskId());
		soapModel.setOrderBy(model.getOrderBy());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setName(model.getName());
		soapModel.setTaskTypeId(model.getTaskTypeId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreatedOn(model.getCreatedOn());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setModifiedOn(model.getModifiedOn());
		soapModel.setStatusId(model.getStatusId());
		soapModel.setDoGroupId(model.getDoGroupId());
		soapModel.setTaskAssessmentId(model.getTaskAssessmentId());
		soapModel.setParentTTDPSPTaskCustMapId(model.getParentTTDPSPTaskCustMapId());
		soapModel.setLinkedTTDPSubprocessCustMapId(model.getLinkedTTDPSubprocessCustMapId());
		soapModel.setTaskOrderNumber(model.getTaskOrderNumber());

		return soapModel;
	}

	public static TTDPSPTaskCustomerMapSoap[] toSoapModels(
		TTDPSPTaskCustomerMap[] models) {
		TTDPSPTaskCustomerMapSoap[] soapModels = new TTDPSPTaskCustomerMapSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TTDPSPTaskCustomerMapSoap[][] toSoapModels(
		TTDPSPTaskCustomerMap[][] models) {
		TTDPSPTaskCustomerMapSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TTDPSPTaskCustomerMapSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TTDPSPTaskCustomerMapSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TTDPSPTaskCustomerMapSoap[] toSoapModels(
		List<TTDPSPTaskCustomerMap> models) {
		List<TTDPSPTaskCustomerMapSoap> soapModels = new ArrayList<TTDPSPTaskCustomerMapSoap>(models.size());

		for (TTDPSPTaskCustomerMap model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TTDPSPTaskCustomerMapSoap[soapModels.size()]);
	}

	public TTDPSPTaskCustomerMapSoap() {
	}

	public long getPrimaryKey() {
		return _TTDPSPTaskCustomerId;
	}

	public void setPrimaryKey(long pk) {
		setTTDPSPTaskCustomerId(pk);
	}

	public long getTTDPSPTaskCustomerId() {
		return _TTDPSPTaskCustomerId;
	}

	public void setTTDPSPTaskCustomerId(long TTDPSPTaskCustomerId) {
		_TTDPSPTaskCustomerId = TTDPSPTaskCustomerId;
	}

	public long getTTDPSubProcessId() {
		return _TTDPSubProcessId;
	}

	public void setTTDPSubProcessId(long TTDPSubProcessId) {
		_TTDPSubProcessId = TTDPSubProcessId;
	}

	public long getTaskId() {
		return _taskId;
	}

	public void setTaskId(long taskId) {
		_taskId = taskId;
	}

	public int getOrderBy() {
		return _orderBy;
	}

	public void setOrderBy(int orderBy) {
		_orderBy = orderBy;
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

	public int getTaskTypeId() {
		return _taskTypeId;
	}

	public void setTaskTypeId(int taskTypeId) {
		_taskTypeId = taskTypeId;
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

	public long getDoGroupId() {
		return _doGroupId;
	}

	public void setDoGroupId(long doGroupId) {
		_doGroupId = doGroupId;
	}

	public long getTaskAssessmentId() {
		return _taskAssessmentId;
	}

	public void setTaskAssessmentId(long taskAssessmentId) {
		_taskAssessmentId = taskAssessmentId;
	}

	public long getParentTTDPSPTaskCustMapId() {
		return _parentTTDPSPTaskCustMapId;
	}

	public void setParentTTDPSPTaskCustMapId(long parentTTDPSPTaskCustMapId) {
		_parentTTDPSPTaskCustMapId = parentTTDPSPTaskCustMapId;
	}

	public long getLinkedTTDPSubprocessCustMapId() {
		return _linkedTTDPSubprocessCustMapId;
	}

	public void setLinkedTTDPSubprocessCustMapId(
		long linkedTTDPSubprocessCustMapId) {
		_linkedTTDPSubprocessCustMapId = linkedTTDPSubprocessCustMapId;
	}

	public int getTaskOrderNumber() {
		return _taskOrderNumber;
	}

	public void setTaskOrderNumber(int taskOrderNumber) {
		_taskOrderNumber = taskOrderNumber;
	}

	private long _TTDPSPTaskCustomerId;
	private long _TTDPSubProcessId;
	private long _taskId;
	private int _orderBy;
	private long _organizationId;
	private String _name;
	private int _taskTypeId;
	private long _companyId;
	private long _createdBy;
	private Date _createdOn;
	private long _modifiedBy;
	private Date _modifiedOn;
	private int _statusId;
	private long _doGroupId;
	private long _taskAssessmentId;
	private long _parentTTDPSPTaskCustMapId;
	private long _linkedTTDPSubprocessCustMapId;
	private int _taskOrderNumber;
}