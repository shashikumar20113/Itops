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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link TTDPSPCustDecisionTaskTable}.
 * </p>
 *
 * @author sunprabh
 * @see TTDPSPCustDecisionTaskTable
 * @generated
 */
@ProviderType
public class TTDPSPCustDecisionTaskTableWrapper
	implements TTDPSPCustDecisionTaskTable,
		ModelWrapper<TTDPSPCustDecisionTaskTable> {
	public TTDPSPCustDecisionTaskTableWrapper(
		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable) {
		_ttdpspCustDecisionTaskTable = ttdpspCustDecisionTaskTable;
	}

	@Override
	public Class<?> getModelClass() {
		return TTDPSPCustDecisionTaskTable.class;
	}

	@Override
	public String getModelClassName() {
		return TTDPSPCustDecisionTaskTable.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("TTDPSPCustDecisionTaskTableId",
			getTTDPSPCustDecisionTaskTableId());
		attributes.put("subTTDPSPTaskCustomerId", getSubTTDPSPTaskCustomerId());
		attributes.put("condition", isCondition());
		attributes.put("order", getOrder());
		attributes.put("parentTTDPSPTaskCustomerId",
			getParentTTDPSPTaskCustomerId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long TTDPSPCustDecisionTaskTableId = (Long)attributes.get(
				"TTDPSPCustDecisionTaskTableId");

		if (TTDPSPCustDecisionTaskTableId != null) {
			setTTDPSPCustDecisionTaskTableId(TTDPSPCustDecisionTaskTableId);
		}

		Long subTTDPSPTaskCustomerId = (Long)attributes.get(
				"subTTDPSPTaskCustomerId");

		if (subTTDPSPTaskCustomerId != null) {
			setSubTTDPSPTaskCustomerId(subTTDPSPTaskCustomerId);
		}

		Boolean condition = (Boolean)attributes.get("condition");

		if (condition != null) {
			setCondition(condition);
		}

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		Long parentTTDPSPTaskCustomerId = (Long)attributes.get(
				"parentTTDPSPTaskCustomerId");

		if (parentTTDPSPTaskCustomerId != null) {
			setParentTTDPSPTaskCustomerId(parentTTDPSPTaskCustomerId);
		}
	}

	@Override
	public Object clone() {
		return new TTDPSPCustDecisionTaskTableWrapper((TTDPSPCustDecisionTaskTable)_ttdpspCustDecisionTaskTable.clone());
	}

	@Override
	public int compareTo(
		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable) {
		return _ttdpspCustDecisionTaskTable.compareTo(ttdpspCustDecisionTaskTable);
	}

	/**
	* Returns the condition of this ttdpsp cust decision task table.
	*
	* @return the condition of this ttdpsp cust decision task table
	*/
	@Override
	public boolean getCondition() {
		return _ttdpspCustDecisionTaskTable.getCondition();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _ttdpspCustDecisionTaskTable.getExpandoBridge();
	}

	/**
	* Returns the order of this ttdpsp cust decision task table.
	*
	* @return the order of this ttdpsp cust decision task table
	*/
	@Override
	public int getOrder() {
		return _ttdpspCustDecisionTaskTable.getOrder();
	}

	/**
	* Returns the parent ttdpsp task customer ID of this ttdpsp cust decision task table.
	*
	* @return the parent ttdpsp task customer ID of this ttdpsp cust decision task table
	*/
	@Override
	public long getParentTTDPSPTaskCustomerId() {
		return _ttdpspCustDecisionTaskTable.getParentTTDPSPTaskCustomerId();
	}

	/**
	* Returns the primary key of this ttdpsp cust decision task table.
	*
	* @return the primary key of this ttdpsp cust decision task table
	*/
	@Override
	public long getPrimaryKey() {
		return _ttdpspCustDecisionTaskTable.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ttdpspCustDecisionTaskTable.getPrimaryKeyObj();
	}

	/**
	* Returns the sub ttdpsp task customer ID of this ttdpsp cust decision task table.
	*
	* @return the sub ttdpsp task customer ID of this ttdpsp cust decision task table
	*/
	@Override
	public long getSubTTDPSPTaskCustomerId() {
		return _ttdpspCustDecisionTaskTable.getSubTTDPSPTaskCustomerId();
	}

	/**
	* Returns the ttdpsp cust decision task table ID of this ttdpsp cust decision task table.
	*
	* @return the ttdpsp cust decision task table ID of this ttdpsp cust decision task table
	*/
	@Override
	public long getTTDPSPCustDecisionTaskTableId() {
		return _ttdpspCustDecisionTaskTable.getTTDPSPCustDecisionTaskTableId();
	}

	@Override
	public int hashCode() {
		return _ttdpspCustDecisionTaskTable.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _ttdpspCustDecisionTaskTable.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this ttdpsp cust decision task table is condition.
	*
	* @return <code>true</code> if this ttdpsp cust decision task table is condition; <code>false</code> otherwise
	*/
	@Override
	public boolean isCondition() {
		return _ttdpspCustDecisionTaskTable.isCondition();
	}

	@Override
	public boolean isEscapedModel() {
		return _ttdpspCustDecisionTaskTable.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _ttdpspCustDecisionTaskTable.isNew();
	}

	@Override
	public void persist() {
		_ttdpspCustDecisionTaskTable.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ttdpspCustDecisionTaskTable.setCachedModel(cachedModel);
	}

	/**
	* Sets whether this ttdpsp cust decision task table is condition.
	*
	* @param condition the condition of this ttdpsp cust decision task table
	*/
	@Override
	public void setCondition(boolean condition) {
		_ttdpspCustDecisionTaskTable.setCondition(condition);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_ttdpspCustDecisionTaskTable.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_ttdpspCustDecisionTaskTable.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_ttdpspCustDecisionTaskTable.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_ttdpspCustDecisionTaskTable.setNew(n);
	}

	/**
	* Sets the order of this ttdpsp cust decision task table.
	*
	* @param order the order of this ttdpsp cust decision task table
	*/
	@Override
	public void setOrder(int order) {
		_ttdpspCustDecisionTaskTable.setOrder(order);
	}

	/**
	* Sets the parent ttdpsp task customer ID of this ttdpsp cust decision task table.
	*
	* @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID of this ttdpsp cust decision task table
	*/
	@Override
	public void setParentTTDPSPTaskCustomerId(long parentTTDPSPTaskCustomerId) {
		_ttdpspCustDecisionTaskTable.setParentTTDPSPTaskCustomerId(parentTTDPSPTaskCustomerId);
	}

	/**
	* Sets the primary key of this ttdpsp cust decision task table.
	*
	* @param primaryKey the primary key of this ttdpsp cust decision task table
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ttdpspCustDecisionTaskTable.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_ttdpspCustDecisionTaskTable.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the sub ttdpsp task customer ID of this ttdpsp cust decision task table.
	*
	* @param subTTDPSPTaskCustomerId the sub ttdpsp task customer ID of this ttdpsp cust decision task table
	*/
	@Override
	public void setSubTTDPSPTaskCustomerId(long subTTDPSPTaskCustomerId) {
		_ttdpspCustDecisionTaskTable.setSubTTDPSPTaskCustomerId(subTTDPSPTaskCustomerId);
	}

	/**
	* Sets the ttdpsp cust decision task table ID of this ttdpsp cust decision task table.
	*
	* @param TTDPSPCustDecisionTaskTableId the ttdpsp cust decision task table ID of this ttdpsp cust decision task table
	*/
	@Override
	public void setTTDPSPCustDecisionTaskTableId(
		long TTDPSPCustDecisionTaskTableId) {
		_ttdpspCustDecisionTaskTable.setTTDPSPCustDecisionTaskTableId(TTDPSPCustDecisionTaskTableId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TTDPSPCustDecisionTaskTable> toCacheModel() {
		return _ttdpspCustDecisionTaskTable.toCacheModel();
	}

	@Override
	public TTDPSPCustDecisionTaskTable toEscapedModel() {
		return new TTDPSPCustDecisionTaskTableWrapper(_ttdpspCustDecisionTaskTable.toEscapedModel());
	}

	@Override
	public String toString() {
		return _ttdpspCustDecisionTaskTable.toString();
	}

	@Override
	public TTDPSPCustDecisionTaskTable toUnescapedModel() {
		return new TTDPSPCustDecisionTaskTableWrapper(_ttdpspCustDecisionTaskTable.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _ttdpspCustDecisionTaskTable.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TTDPSPCustDecisionTaskTableWrapper)) {
			return false;
		}

		TTDPSPCustDecisionTaskTableWrapper ttdpspCustDecisionTaskTableWrapper = (TTDPSPCustDecisionTaskTableWrapper)obj;

		if (Objects.equals(_ttdpspCustDecisionTaskTable,
					ttdpspCustDecisionTaskTableWrapper._ttdpspCustDecisionTaskTable)) {
			return true;
		}

		return false;
	}

	@Override
	public TTDPSPCustDecisionTaskTable getWrappedModel() {
		return _ttdpspCustDecisionTaskTable;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _ttdpspCustDecisionTaskTable.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _ttdpspCustDecisionTaskTable.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_ttdpspCustDecisionTaskTable.resetOriginalValues();
	}

	private final TTDPSPCustDecisionTaskTable _ttdpspCustDecisionTaskTable;
}