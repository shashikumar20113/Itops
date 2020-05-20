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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author sunprabh
 * @generated
 */
@ProviderType
public class TTDPSPCustDecisionTaskTableSoap implements Serializable {
	public static TTDPSPCustDecisionTaskTableSoap toSoapModel(
		TTDPSPCustDecisionTaskTable model) {
		TTDPSPCustDecisionTaskTableSoap soapModel = new TTDPSPCustDecisionTaskTableSoap();

		soapModel.setTTDPSPCustDecisionTaskTableId(model.getTTDPSPCustDecisionTaskTableId());
		soapModel.setSubTTDPSPTaskCustomerId(model.getSubTTDPSPTaskCustomerId());
		soapModel.setCondition(model.isCondition());
		soapModel.setOrder(model.getOrder());
		soapModel.setParentTTDPSPTaskCustomerId(model.getParentTTDPSPTaskCustomerId());

		return soapModel;
	}

	public static TTDPSPCustDecisionTaskTableSoap[] toSoapModels(
		TTDPSPCustDecisionTaskTable[] models) {
		TTDPSPCustDecisionTaskTableSoap[] soapModels = new TTDPSPCustDecisionTaskTableSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TTDPSPCustDecisionTaskTableSoap[][] toSoapModels(
		TTDPSPCustDecisionTaskTable[][] models) {
		TTDPSPCustDecisionTaskTableSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TTDPSPCustDecisionTaskTableSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TTDPSPCustDecisionTaskTableSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TTDPSPCustDecisionTaskTableSoap[] toSoapModels(
		List<TTDPSPCustDecisionTaskTable> models) {
		List<TTDPSPCustDecisionTaskTableSoap> soapModels = new ArrayList<TTDPSPCustDecisionTaskTableSoap>(models.size());

		for (TTDPSPCustDecisionTaskTable model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TTDPSPCustDecisionTaskTableSoap[soapModels.size()]);
	}

	public TTDPSPCustDecisionTaskTableSoap() {
	}

	public long getPrimaryKey() {
		return _TTDPSPCustDecisionTaskTableId;
	}

	public void setPrimaryKey(long pk) {
		setTTDPSPCustDecisionTaskTableId(pk);
	}

	public long getTTDPSPCustDecisionTaskTableId() {
		return _TTDPSPCustDecisionTaskTableId;
	}

	public void setTTDPSPCustDecisionTaskTableId(
		long TTDPSPCustDecisionTaskTableId) {
		_TTDPSPCustDecisionTaskTableId = TTDPSPCustDecisionTaskTableId;
	}

	public long getSubTTDPSPTaskCustomerId() {
		return _subTTDPSPTaskCustomerId;
	}

	public void setSubTTDPSPTaskCustomerId(long subTTDPSPTaskCustomerId) {
		_subTTDPSPTaskCustomerId = subTTDPSPTaskCustomerId;
	}

	public boolean getCondition() {
		return _condition;
	}

	public boolean isCondition() {
		return _condition;
	}

	public void setCondition(boolean condition) {
		_condition = condition;
	}

	public int getOrder() {
		return _order;
	}

	public void setOrder(int order) {
		_order = order;
	}

	public long getParentTTDPSPTaskCustomerId() {
		return _parentTTDPSPTaskCustomerId;
	}

	public void setParentTTDPSPTaskCustomerId(long parentTTDPSPTaskCustomerId) {
		_parentTTDPSPTaskCustomerId = parentTTDPSPTaskCustomerId;
	}

	private long _TTDPSPCustDecisionTaskTableId;
	private long _subTTDPSPTaskCustomerId;
	private boolean _condition;
	private int _order;
	private long _parentTTDPSPTaskCustomerId;
}