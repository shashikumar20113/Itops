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
 * This class is a wrapper for {@link TTDeliverableCustomerMap}.
 * </p>
 *
 * @author sunprabh
 * @see TTDeliverableCustomerMap
 * @generated
 */
@ProviderType
public class TTDeliverableCustomerMapWrapper implements TTDeliverableCustomerMap,
	ModelWrapper<TTDeliverableCustomerMap> {
	public TTDeliverableCustomerMapWrapper(
		TTDeliverableCustomerMap ttDeliverableCustomerMap) {
		_ttDeliverableCustomerMap = ttDeliverableCustomerMap;
	}

	@Override
	public Class<?> getModelClass() {
		return TTDeliverableCustomerMap.class;
	}

	@Override
	public String getModelClassName() {
		return TTDeliverableCustomerMap.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("TTDeliverableCustomerId", getTTDeliverableCustomerId());
		attributes.put("TTDeliverableId", getTTDeliverableId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("name", getName());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createdOn", getCreatedOn());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedOn", getModifiedOn());
		attributes.put("statusId", getStatusId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long TTDeliverableCustomerId = (Long)attributes.get(
				"TTDeliverableCustomerId");

		if (TTDeliverableCustomerId != null) {
			setTTDeliverableCustomerId(TTDeliverableCustomerId);
		}

		Long TTDeliverableId = (Long)attributes.get("TTDeliverableId");

		if (TTDeliverableId != null) {
			setTTDeliverableId(TTDeliverableId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
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
	}

	@Override
	public Object clone() {
		return new TTDeliverableCustomerMapWrapper((TTDeliverableCustomerMap)_ttDeliverableCustomerMap.clone());
	}

	@Override
	public int compareTo(TTDeliverableCustomerMap ttDeliverableCustomerMap) {
		return _ttDeliverableCustomerMap.compareTo(ttDeliverableCustomerMap);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return _ttDeliverableCustomerMap.getAvailableLanguageIds();
	}

	/**
	* Returns the company ID of this tt deliverable customer map.
	*
	* @return the company ID of this tt deliverable customer map
	*/
	@Override
	public long getCompanyId() {
		return _ttDeliverableCustomerMap.getCompanyId();
	}

	/**
	* Returns the created by of this tt deliverable customer map.
	*
	* @return the created by of this tt deliverable customer map
	*/
	@Override
	public long getCreatedBy() {
		return _ttDeliverableCustomerMap.getCreatedBy();
	}

	/**
	* Returns the created on of this tt deliverable customer map.
	*
	* @return the created on of this tt deliverable customer map
	*/
	@Override
	public Date getCreatedOn() {
		return _ttDeliverableCustomerMap.getCreatedOn();
	}

	@Override
	public String getDefaultLanguageId() {
		return _ttDeliverableCustomerMap.getDefaultLanguageId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _ttDeliverableCustomerMap.getExpandoBridge();
	}

	/**
	* Returns the modified by of this tt deliverable customer map.
	*
	* @return the modified by of this tt deliverable customer map
	*/
	@Override
	public long getModifiedBy() {
		return _ttDeliverableCustomerMap.getModifiedBy();
	}

	/**
	* Returns the modified on of this tt deliverable customer map.
	*
	* @return the modified on of this tt deliverable customer map
	*/
	@Override
	public Date getModifiedOn() {
		return _ttDeliverableCustomerMap.getModifiedOn();
	}

	/**
	* Returns the name of this tt deliverable customer map.
	*
	* @return the name of this tt deliverable customer map
	*/
	@Override
	public String getName() {
		return _ttDeliverableCustomerMap.getName();
	}

	/**
	* Returns the localized name of this tt deliverable customer map in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized name of this tt deliverable customer map
	*/
	@Override
	public String getName(java.util.Locale locale) {
		return _ttDeliverableCustomerMap.getName(locale);
	}

	/**
	* Returns the localized name of this tt deliverable customer map in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this tt deliverable customer map. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public String getName(java.util.Locale locale, boolean useDefault) {
		return _ttDeliverableCustomerMap.getName(locale, useDefault);
	}

	/**
	* Returns the localized name of this tt deliverable customer map in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized name of this tt deliverable customer map
	*/
	@Override
	public String getName(String languageId) {
		return _ttDeliverableCustomerMap.getName(languageId);
	}

	/**
	* Returns the localized name of this tt deliverable customer map in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this tt deliverable customer map
	*/
	@Override
	public String getName(String languageId, boolean useDefault) {
		return _ttDeliverableCustomerMap.getName(languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _ttDeliverableCustomerMap.getNameCurrentLanguageId();
	}

	@Override
	public String getNameCurrentValue() {
		return _ttDeliverableCustomerMap.getNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized names of this tt deliverable customer map.
	*
	* @return the locales and localized names of this tt deliverable customer map
	*/
	@Override
	public Map<java.util.Locale, String> getNameMap() {
		return _ttDeliverableCustomerMap.getNameMap();
	}

	/**
	* Returns the organization ID of this tt deliverable customer map.
	*
	* @return the organization ID of this tt deliverable customer map
	*/
	@Override
	public long getOrganizationId() {
		return _ttDeliverableCustomerMap.getOrganizationId();
	}

	/**
	* Returns the primary key of this tt deliverable customer map.
	*
	* @return the primary key of this tt deliverable customer map
	*/
	@Override
	public long getPrimaryKey() {
		return _ttDeliverableCustomerMap.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ttDeliverableCustomerMap.getPrimaryKeyObj();
	}

	/**
	* Returns the status ID of this tt deliverable customer map.
	*
	* @return the status ID of this tt deliverable customer map
	*/
	@Override
	public int getStatusId() {
		return _ttDeliverableCustomerMap.getStatusId();
	}

	/**
	* Returns the tt deliverable customer ID of this tt deliverable customer map.
	*
	* @return the tt deliverable customer ID of this tt deliverable customer map
	*/
	@Override
	public long getTTDeliverableCustomerId() {
		return _ttDeliverableCustomerMap.getTTDeliverableCustomerId();
	}

	/**
	* Returns the tt deliverable ID of this tt deliverable customer map.
	*
	* @return the tt deliverable ID of this tt deliverable customer map
	*/
	@Override
	public long getTTDeliverableId() {
		return _ttDeliverableCustomerMap.getTTDeliverableId();
	}

	@Override
	public int hashCode() {
		return _ttDeliverableCustomerMap.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _ttDeliverableCustomerMap.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _ttDeliverableCustomerMap.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _ttDeliverableCustomerMap.isNew();
	}

	@Override
	public void persist() {
		_ttDeliverableCustomerMap.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {
		_ttDeliverableCustomerMap.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {
		_ttDeliverableCustomerMap.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ttDeliverableCustomerMap.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this tt deliverable customer map.
	*
	* @param companyId the company ID of this tt deliverable customer map
	*/
	@Override
	public void setCompanyId(long companyId) {
		_ttDeliverableCustomerMap.setCompanyId(companyId);
	}

	/**
	* Sets the created by of this tt deliverable customer map.
	*
	* @param createdBy the created by of this tt deliverable customer map
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_ttDeliverableCustomerMap.setCreatedBy(createdBy);
	}

	/**
	* Sets the created on of this tt deliverable customer map.
	*
	* @param createdOn the created on of this tt deliverable customer map
	*/
	@Override
	public void setCreatedOn(Date createdOn) {
		_ttDeliverableCustomerMap.setCreatedOn(createdOn);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_ttDeliverableCustomerMap.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_ttDeliverableCustomerMap.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_ttDeliverableCustomerMap.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified by of this tt deliverable customer map.
	*
	* @param modifiedBy the modified by of this tt deliverable customer map
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_ttDeliverableCustomerMap.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified on of this tt deliverable customer map.
	*
	* @param modifiedOn the modified on of this tt deliverable customer map
	*/
	@Override
	public void setModifiedOn(Date modifiedOn) {
		_ttDeliverableCustomerMap.setModifiedOn(modifiedOn);
	}

	/**
	* Sets the name of this tt deliverable customer map.
	*
	* @param name the name of this tt deliverable customer map
	*/
	@Override
	public void setName(String name) {
		_ttDeliverableCustomerMap.setName(name);
	}

	/**
	* Sets the localized name of this tt deliverable customer map in the language.
	*
	* @param name the localized name of this tt deliverable customer map
	* @param locale the locale of the language
	*/
	@Override
	public void setName(String name, java.util.Locale locale) {
		_ttDeliverableCustomerMap.setName(name, locale);
	}

	/**
	* Sets the localized name of this tt deliverable customer map in the language, and sets the default locale.
	*
	* @param name the localized name of this tt deliverable customer map
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setName(String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_ttDeliverableCustomerMap.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_ttDeliverableCustomerMap.setNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized names of this tt deliverable customer map from the map of locales and localized names.
	*
	* @param nameMap the locales and localized names of this tt deliverable customer map
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap) {
		_ttDeliverableCustomerMap.setNameMap(nameMap);
	}

	/**
	* Sets the localized names of this tt deliverable customer map from the map of locales and localized names, and sets the default locale.
	*
	* @param nameMap the locales and localized names of this tt deliverable customer map
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap,
		java.util.Locale defaultLocale) {
		_ttDeliverableCustomerMap.setNameMap(nameMap, defaultLocale);
	}

	@Override
	public void setNew(boolean n) {
		_ttDeliverableCustomerMap.setNew(n);
	}

	/**
	* Sets the organization ID of this tt deliverable customer map.
	*
	* @param organizationId the organization ID of this tt deliverable customer map
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_ttDeliverableCustomerMap.setOrganizationId(organizationId);
	}

	/**
	* Sets the primary key of this tt deliverable customer map.
	*
	* @param primaryKey the primary key of this tt deliverable customer map
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ttDeliverableCustomerMap.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_ttDeliverableCustomerMap.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status ID of this tt deliverable customer map.
	*
	* @param statusId the status ID of this tt deliverable customer map
	*/
	@Override
	public void setStatusId(int statusId) {
		_ttDeliverableCustomerMap.setStatusId(statusId);
	}

	/**
	* Sets the tt deliverable customer ID of this tt deliverable customer map.
	*
	* @param TTDeliverableCustomerId the tt deliverable customer ID of this tt deliverable customer map
	*/
	@Override
	public void setTTDeliverableCustomerId(long TTDeliverableCustomerId) {
		_ttDeliverableCustomerMap.setTTDeliverableCustomerId(TTDeliverableCustomerId);
	}

	/**
	* Sets the tt deliverable ID of this tt deliverable customer map.
	*
	* @param TTDeliverableId the tt deliverable ID of this tt deliverable customer map
	*/
	@Override
	public void setTTDeliverableId(long TTDeliverableId) {
		_ttDeliverableCustomerMap.setTTDeliverableId(TTDeliverableId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TTDeliverableCustomerMap> toCacheModel() {
		return _ttDeliverableCustomerMap.toCacheModel();
	}

	@Override
	public TTDeliverableCustomerMap toEscapedModel() {
		return new TTDeliverableCustomerMapWrapper(_ttDeliverableCustomerMap.toEscapedModel());
	}

	@Override
	public String toString() {
		return _ttDeliverableCustomerMap.toString();
	}

	@Override
	public TTDeliverableCustomerMap toUnescapedModel() {
		return new TTDeliverableCustomerMapWrapper(_ttDeliverableCustomerMap.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _ttDeliverableCustomerMap.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TTDeliverableCustomerMapWrapper)) {
			return false;
		}

		TTDeliverableCustomerMapWrapper ttDeliverableCustomerMapWrapper = (TTDeliverableCustomerMapWrapper)obj;

		if (Objects.equals(_ttDeliverableCustomerMap,
					ttDeliverableCustomerMapWrapper._ttDeliverableCustomerMap)) {
			return true;
		}

		return false;
	}

	@Override
	public TTDeliverableCustomerMap getWrappedModel() {
		return _ttDeliverableCustomerMap;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _ttDeliverableCustomerMap.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _ttDeliverableCustomerMap.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_ttDeliverableCustomerMap.resetOriginalValues();
	}

	private final TTDeliverableCustomerMap _ttDeliverableCustomerMap;
}