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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link TTDPSPTaskCustomerMap}.
 * </p>
 *
 * @author sunprabh
 * @see TTDPSPTaskCustomerMap
 * @generated
 */
@ProviderType
public class TTDPSPTaskCustomerMapWrapper implements TTDPSPTaskCustomerMap,
	ModelWrapper<TTDPSPTaskCustomerMap> {
	public TTDPSPTaskCustomerMapWrapper(
		TTDPSPTaskCustomerMap ttdpspTaskCustomerMap) {
		_ttdpspTaskCustomerMap = ttdpspTaskCustomerMap;
	}

	@Override
	public Class<?> getModelClass() {
		return TTDPSPTaskCustomerMap.class;
	}

	@Override
	public String getModelClassName() {
		return TTDPSPTaskCustomerMap.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("TTDPSPTaskCustomerId", getTTDPSPTaskCustomerId());
		attributes.put("TTDPSubProcessId", getTTDPSubProcessId());
		attributes.put("taskId", getTaskId());
		attributes.put("orderBy", getOrderBy());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("name", getName());
		attributes.put("taskTypeId", getTaskTypeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createdOn", getCreatedOn());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedOn", getModifiedOn());
		attributes.put("statusId", getStatusId());
		attributes.put("doGroupId", getDoGroupId());
		attributes.put("taskAssessmentId", getTaskAssessmentId());
		attributes.put("parentTTDPSPTaskCustMapId",
			getParentTTDPSPTaskCustMapId());
		attributes.put("linkedTTDPSubprocessCustMapId",
			getLinkedTTDPSubprocessCustMapId());
		attributes.put("taskOrderNumber", getTaskOrderNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long TTDPSPTaskCustomerId = (Long)attributes.get("TTDPSPTaskCustomerId");

		if (TTDPSPTaskCustomerId != null) {
			setTTDPSPTaskCustomerId(TTDPSPTaskCustomerId);
		}

		Long TTDPSubProcessId = (Long)attributes.get("TTDPSubProcessId");

		if (TTDPSubProcessId != null) {
			setTTDPSubProcessId(TTDPSubProcessId);
		}

		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		Integer orderBy = (Integer)attributes.get("orderBy");

		if (orderBy != null) {
			setOrderBy(orderBy);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer taskTypeId = (Integer)attributes.get("taskTypeId");

		if (taskTypeId != null) {
			setTaskTypeId(taskTypeId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date createdOn = (Date)attributes.get("createdOn");

		if (createdOn != null) {
			setCreatedOn(createdOn);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date modifiedOn = (Date)attributes.get("modifiedOn");

		if (modifiedOn != null) {
			setModifiedOn(modifiedOn);
		}

		Integer statusId = (Integer)attributes.get("statusId");

		if (statusId != null) {
			setStatusId(statusId);
		}

		Long doGroupId = (Long)attributes.get("doGroupId");

		if (doGroupId != null) {
			setDoGroupId(doGroupId);
		}

		Long taskAssessmentId = (Long)attributes.get("taskAssessmentId");

		if (taskAssessmentId != null) {
			setTaskAssessmentId(taskAssessmentId);
		}

		Long parentTTDPSPTaskCustMapId = (Long)attributes.get(
				"parentTTDPSPTaskCustMapId");

		if (parentTTDPSPTaskCustMapId != null) {
			setParentTTDPSPTaskCustMapId(parentTTDPSPTaskCustMapId);
		}

		Long linkedTTDPSubprocessCustMapId = (Long)attributes.get(
				"linkedTTDPSubprocessCustMapId");

		if (linkedTTDPSubprocessCustMapId != null) {
			setLinkedTTDPSubprocessCustMapId(linkedTTDPSubprocessCustMapId);
		}

		Integer taskOrderNumber = (Integer)attributes.get("taskOrderNumber");

		if (taskOrderNumber != null) {
			setTaskOrderNumber(taskOrderNumber);
		}
	}

	@Override
	public Object clone() {
		return new TTDPSPTaskCustomerMapWrapper((TTDPSPTaskCustomerMap)_ttdpspTaskCustomerMap.clone());
	}

	@Override
	public int compareTo(TTDPSPTaskCustomerMap ttdpspTaskCustomerMap) {
		return _ttdpspTaskCustomerMap.compareTo(ttdpspTaskCustomerMap);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return _ttdpspTaskCustomerMap.getAvailableLanguageIds();
	}

	/**
	* Returns the company ID of this ttdpsp task customer map.
	*
	* @return the company ID of this ttdpsp task customer map
	*/
	@Override
	public long getCompanyId() {
		return _ttdpspTaskCustomerMap.getCompanyId();
	}

	/**
	* Returns the created by of this ttdpsp task customer map.
	*
	* @return the created by of this ttdpsp task customer map
	*/
	@Override
	public long getCreatedBy() {
		return _ttdpspTaskCustomerMap.getCreatedBy();
	}

	/**
	* Returns the created on of this ttdpsp task customer map.
	*
	* @return the created on of this ttdpsp task customer map
	*/
	@Override
	public Date getCreatedOn() {
		return _ttdpspTaskCustomerMap.getCreatedOn();
	}

	@Override
	public String getDefaultLanguageId() {
		return _ttdpspTaskCustomerMap.getDefaultLanguageId();
	}

	/**
	* Returns the do group ID of this ttdpsp task customer map.
	*
	* @return the do group ID of this ttdpsp task customer map
	*/
	@Override
	public long getDoGroupId() {
		return _ttdpspTaskCustomerMap.getDoGroupId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _ttdpspTaskCustomerMap.getExpandoBridge();
	}

	/**
	* Returns the linked ttdp subprocess cust map ID of this ttdpsp task customer map.
	*
	* @return the linked ttdp subprocess cust map ID of this ttdpsp task customer map
	*/
	@Override
	public long getLinkedTTDPSubprocessCustMapId() {
		return _ttdpspTaskCustomerMap.getLinkedTTDPSubprocessCustMapId();
	}

	/**
	* Returns the modified by of this ttdpsp task customer map.
	*
	* @return the modified by of this ttdpsp task customer map
	*/
	@Override
	public long getModifiedBy() {
		return _ttdpspTaskCustomerMap.getModifiedBy();
	}

	/**
	* Returns the modified on of this ttdpsp task customer map.
	*
	* @return the modified on of this ttdpsp task customer map
	*/
	@Override
	public Date getModifiedOn() {
		return _ttdpspTaskCustomerMap.getModifiedOn();
	}

	/**
	* Returns the name of this ttdpsp task customer map.
	*
	* @return the name of this ttdpsp task customer map
	*/
	@Override
	public String getName() {
		return _ttdpspTaskCustomerMap.getName();
	}

	/**
	* Returns the localized name of this ttdpsp task customer map in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized name of this ttdpsp task customer map
	*/
	@Override
	public String getName(java.util.Locale locale) {
		return _ttdpspTaskCustomerMap.getName(locale);
	}

	/**
	* Returns the localized name of this ttdpsp task customer map in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this ttdpsp task customer map. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public String getName(java.util.Locale locale, boolean useDefault) {
		return _ttdpspTaskCustomerMap.getName(locale, useDefault);
	}

	/**
	* Returns the localized name of this ttdpsp task customer map in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized name of this ttdpsp task customer map
	*/
	@Override
	public String getName(String languageId) {
		return _ttdpspTaskCustomerMap.getName(languageId);
	}

	/**
	* Returns the localized name of this ttdpsp task customer map in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this ttdpsp task customer map
	*/
	@Override
	public String getName(String languageId, boolean useDefault) {
		return _ttdpspTaskCustomerMap.getName(languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _ttdpspTaskCustomerMap.getNameCurrentLanguageId();
	}

	@Override
	public String getNameCurrentValue() {
		return _ttdpspTaskCustomerMap.getNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized names of this ttdpsp task customer map.
	*
	* @return the locales and localized names of this ttdpsp task customer map
	*/
	@Override
	public Map<java.util.Locale, String> getNameMap() {
		return _ttdpspTaskCustomerMap.getNameMap();
	}

	/**
	* Returns the order by of this ttdpsp task customer map.
	*
	* @return the order by of this ttdpsp task customer map
	*/
	@Override
	public int getOrderBy() {
		return _ttdpspTaskCustomerMap.getOrderBy();
	}

	/**
	* Returns the organization ID of this ttdpsp task customer map.
	*
	* @return the organization ID of this ttdpsp task customer map
	*/
	@Override
	public long getOrganizationId() {
		return _ttdpspTaskCustomerMap.getOrganizationId();
	}

	/**
	* Returns the parent ttdpsp task cust map ID of this ttdpsp task customer map.
	*
	* @return the parent ttdpsp task cust map ID of this ttdpsp task customer map
	*/
	@Override
	public long getParentTTDPSPTaskCustMapId() {
		return _ttdpspTaskCustomerMap.getParentTTDPSPTaskCustMapId();
	}

	/**
	* Returns the primary key of this ttdpsp task customer map.
	*
	* @return the primary key of this ttdpsp task customer map
	*/
	@Override
	public long getPrimaryKey() {
		return _ttdpspTaskCustomerMap.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ttdpspTaskCustomerMap.getPrimaryKeyObj();
	}

	/**
	* Returns the status ID of this ttdpsp task customer map.
	*
	* @return the status ID of this ttdpsp task customer map
	*/
	@Override
	public int getStatusId() {
		return _ttdpspTaskCustomerMap.getStatusId();
	}

	/**
	* Returns the task assessment ID of this ttdpsp task customer map.
	*
	* @return the task assessment ID of this ttdpsp task customer map
	*/
	@Override
	public long getTaskAssessmentId() {
		return _ttdpspTaskCustomerMap.getTaskAssessmentId();
	}

	/**
	* Returns the task ID of this ttdpsp task customer map.
	*
	* @return the task ID of this ttdpsp task customer map
	*/
	@Override
	public long getTaskId() {
		return _ttdpspTaskCustomerMap.getTaskId();
	}

	/**
	* Returns the task order number of this ttdpsp task customer map.
	*
	* @return the task order number of this ttdpsp task customer map
	*/
	@Override
	public int getTaskOrderNumber() {
		return _ttdpspTaskCustomerMap.getTaskOrderNumber();
	}

	/**
	* Returns the task type ID of this ttdpsp task customer map.
	*
	* @return the task type ID of this ttdpsp task customer map
	*/
	@Override
	public int getTaskTypeId() {
		return _ttdpspTaskCustomerMap.getTaskTypeId();
	}

	/**
	* Returns the ttdpsp task customer ID of this ttdpsp task customer map.
	*
	* @return the ttdpsp task customer ID of this ttdpsp task customer map
	*/
	@Override
	public long getTTDPSPTaskCustomerId() {
		return _ttdpspTaskCustomerMap.getTTDPSPTaskCustomerId();
	}

	/**
	* Returns the ttdp sub process ID of this ttdpsp task customer map.
	*
	* @return the ttdp sub process ID of this ttdpsp task customer map
	*/
	@Override
	public long getTTDPSubProcessId() {
		return _ttdpspTaskCustomerMap.getTTDPSubProcessId();
	}

	@Override
	public int hashCode() {
		return _ttdpspTaskCustomerMap.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _ttdpspTaskCustomerMap.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _ttdpspTaskCustomerMap.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _ttdpspTaskCustomerMap.isNew();
	}

	@Override
	public void persist() {
		_ttdpspTaskCustomerMap.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {
		_ttdpspTaskCustomerMap.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {
		_ttdpspTaskCustomerMap.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ttdpspTaskCustomerMap.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this ttdpsp task customer map.
	*
	* @param companyId the company ID of this ttdpsp task customer map
	*/
	@Override
	public void setCompanyId(long companyId) {
		_ttdpspTaskCustomerMap.setCompanyId(companyId);
	}

	/**
	* Sets the created by of this ttdpsp task customer map.
	*
	* @param createdBy the created by of this ttdpsp task customer map
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_ttdpspTaskCustomerMap.setCreatedBy(createdBy);
	}

	/**
	* Sets the created on of this ttdpsp task customer map.
	*
	* @param createdOn the created on of this ttdpsp task customer map
	*/
	@Override
	public void setCreatedOn(Date createdOn) {
		_ttdpspTaskCustomerMap.setCreatedOn(createdOn);
	}

	/**
	* Sets the do group ID of this ttdpsp task customer map.
	*
	* @param doGroupId the do group ID of this ttdpsp task customer map
	*/
	@Override
	public void setDoGroupId(long doGroupId) {
		_ttdpspTaskCustomerMap.setDoGroupId(doGroupId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_ttdpspTaskCustomerMap.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_ttdpspTaskCustomerMap.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_ttdpspTaskCustomerMap.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the linked ttdp subprocess cust map ID of this ttdpsp task customer map.
	*
	* @param linkedTTDPSubprocessCustMapId the linked ttdp subprocess cust map ID of this ttdpsp task customer map
	*/
	@Override
	public void setLinkedTTDPSubprocessCustMapId(
		long linkedTTDPSubprocessCustMapId) {
		_ttdpspTaskCustomerMap.setLinkedTTDPSubprocessCustMapId(linkedTTDPSubprocessCustMapId);
	}

	/**
	* Sets the modified by of this ttdpsp task customer map.
	*
	* @param modifiedBy the modified by of this ttdpsp task customer map
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_ttdpspTaskCustomerMap.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified on of this ttdpsp task customer map.
	*
	* @param modifiedOn the modified on of this ttdpsp task customer map
	*/
	@Override
	public void setModifiedOn(Date modifiedOn) {
		_ttdpspTaskCustomerMap.setModifiedOn(modifiedOn);
	}

	/**
	* Sets the name of this ttdpsp task customer map.
	*
	* @param name the name of this ttdpsp task customer map
	*/
	@Override
	public void setName(String name) {
		_ttdpspTaskCustomerMap.setName(name);
	}

	/**
	* Sets the localized name of this ttdpsp task customer map in the language.
	*
	* @param name the localized name of this ttdpsp task customer map
	* @param locale the locale of the language
	*/
	@Override
	public void setName(String name, java.util.Locale locale) {
		_ttdpspTaskCustomerMap.setName(name, locale);
	}

	/**
	* Sets the localized name of this ttdpsp task customer map in the language, and sets the default locale.
	*
	* @param name the localized name of this ttdpsp task customer map
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setName(String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_ttdpspTaskCustomerMap.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_ttdpspTaskCustomerMap.setNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized names of this ttdpsp task customer map from the map of locales and localized names.
	*
	* @param nameMap the locales and localized names of this ttdpsp task customer map
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap) {
		_ttdpspTaskCustomerMap.setNameMap(nameMap);
	}

	/**
	* Sets the localized names of this ttdpsp task customer map from the map of locales and localized names, and sets the default locale.
	*
	* @param nameMap the locales and localized names of this ttdpsp task customer map
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap,
		java.util.Locale defaultLocale) {
		_ttdpspTaskCustomerMap.setNameMap(nameMap, defaultLocale);
	}

	@Override
	public void setNew(boolean n) {
		_ttdpspTaskCustomerMap.setNew(n);
	}

	/**
	* Sets the order by of this ttdpsp task customer map.
	*
	* @param orderBy the order by of this ttdpsp task customer map
	*/
	@Override
	public void setOrderBy(int orderBy) {
		_ttdpspTaskCustomerMap.setOrderBy(orderBy);
	}

	/**
	* Sets the organization ID of this ttdpsp task customer map.
	*
	* @param organizationId the organization ID of this ttdpsp task customer map
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_ttdpspTaskCustomerMap.setOrganizationId(organizationId);
	}

	/**
	* Sets the parent ttdpsp task cust map ID of this ttdpsp task customer map.
	*
	* @param parentTTDPSPTaskCustMapId the parent ttdpsp task cust map ID of this ttdpsp task customer map
	*/
	@Override
	public void setParentTTDPSPTaskCustMapId(long parentTTDPSPTaskCustMapId) {
		_ttdpspTaskCustomerMap.setParentTTDPSPTaskCustMapId(parentTTDPSPTaskCustMapId);
	}

	/**
	* Sets the primary key of this ttdpsp task customer map.
	*
	* @param primaryKey the primary key of this ttdpsp task customer map
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ttdpspTaskCustomerMap.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_ttdpspTaskCustomerMap.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status ID of this ttdpsp task customer map.
	*
	* @param statusId the status ID of this ttdpsp task customer map
	*/
	@Override
	public void setStatusId(int statusId) {
		_ttdpspTaskCustomerMap.setStatusId(statusId);
	}

	/**
	* Sets the task assessment ID of this ttdpsp task customer map.
	*
	* @param taskAssessmentId the task assessment ID of this ttdpsp task customer map
	*/
	@Override
	public void setTaskAssessmentId(long taskAssessmentId) {
		_ttdpspTaskCustomerMap.setTaskAssessmentId(taskAssessmentId);
	}

	/**
	* Sets the task ID of this ttdpsp task customer map.
	*
	* @param taskId the task ID of this ttdpsp task customer map
	*/
	@Override
	public void setTaskId(long taskId) {
		_ttdpspTaskCustomerMap.setTaskId(taskId);
	}

	/**
	* Sets the task order number of this ttdpsp task customer map.
	*
	* @param taskOrderNumber the task order number of this ttdpsp task customer map
	*/
	@Override
	public void setTaskOrderNumber(int taskOrderNumber) {
		_ttdpspTaskCustomerMap.setTaskOrderNumber(taskOrderNumber);
	}

	/**
	* Sets the task type ID of this ttdpsp task customer map.
	*
	* @param taskTypeId the task type ID of this ttdpsp task customer map
	*/
	@Override
	public void setTaskTypeId(int taskTypeId) {
		_ttdpspTaskCustomerMap.setTaskTypeId(taskTypeId);
	}

	/**
	* Sets the ttdpsp task customer ID of this ttdpsp task customer map.
	*
	* @param TTDPSPTaskCustomerId the ttdpsp task customer ID of this ttdpsp task customer map
	*/
	@Override
	public void setTTDPSPTaskCustomerId(long TTDPSPTaskCustomerId) {
		_ttdpspTaskCustomerMap.setTTDPSPTaskCustomerId(TTDPSPTaskCustomerId);
	}

	/**
	* Sets the ttdp sub process ID of this ttdpsp task customer map.
	*
	* @param TTDPSubProcessId the ttdp sub process ID of this ttdpsp task customer map
	*/
	@Override
	public void setTTDPSubProcessId(long TTDPSubProcessId) {
		_ttdpspTaskCustomerMap.setTTDPSubProcessId(TTDPSubProcessId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TTDPSPTaskCustomerMap> toCacheModel() {
		return _ttdpspTaskCustomerMap.toCacheModel();
	}

	@Override
	public TTDPSPTaskCustomerMap toEscapedModel() {
		return new TTDPSPTaskCustomerMapWrapper(_ttdpspTaskCustomerMap.toEscapedModel());
	}

	@Override
	public String toString() {
		return _ttdpspTaskCustomerMap.toString();
	}

	@Override
	public TTDPSPTaskCustomerMap toUnescapedModel() {
		return new TTDPSPTaskCustomerMapWrapper(_ttdpspTaskCustomerMap.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _ttdpspTaskCustomerMap.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TTDPSPTaskCustomerMapWrapper)) {
			return false;
		}

		TTDPSPTaskCustomerMapWrapper ttdpspTaskCustomerMapWrapper = (TTDPSPTaskCustomerMapWrapper)obj;

		if (Objects.equals(_ttdpspTaskCustomerMap,
					ttdpspTaskCustomerMapWrapper._ttdpspTaskCustomerMap)) {
			return true;
		}

		return false;
	}

	@Override
	public TTDPSPTaskCustomerMap getWrappedModel() {
		return _ttdpspTaskCustomerMap;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _ttdpspTaskCustomerMap.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _ttdpspTaskCustomerMap.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_ttdpspTaskCustomerMap.resetOriginalValues();
	}

	private final TTDPSPTaskCustomerMap _ttdpspTaskCustomerMap;
}