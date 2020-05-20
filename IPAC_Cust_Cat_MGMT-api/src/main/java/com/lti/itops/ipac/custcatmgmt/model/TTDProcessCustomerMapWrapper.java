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
 * This class is a wrapper for {@link TTDProcessCustomerMap}.
 * </p>
 *
 * @author sunprabh
 * @see TTDProcessCustomerMap
 * @generated
 */
@ProviderType
public class TTDProcessCustomerMapWrapper implements TTDProcessCustomerMap,
	ModelWrapper<TTDProcessCustomerMap> {
	public TTDProcessCustomerMapWrapper(
		TTDProcessCustomerMap ttdProcessCustomerMap) {
		_ttdProcessCustomerMap = ttdProcessCustomerMap;
	}

	@Override
	public Class<?> getModelClass() {
		return TTDProcessCustomerMap.class;
	}

	@Override
	public String getModelClassName() {
		return TTDProcessCustomerMap.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("TTDProcessCustomerId", getTTDProcessCustomerId());
		attributes.put("TTDProcessId", getTTDProcessId());
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
		Long TTDProcessCustomerId = (Long)attributes.get("TTDProcessCustomerId");

		if (TTDProcessCustomerId != null) {
			setTTDProcessCustomerId(TTDProcessCustomerId);
		}

		Long TTDProcessId = (Long)attributes.get("TTDProcessId");

		if (TTDProcessId != null) {
			setTTDProcessId(TTDProcessId);
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
		return new TTDProcessCustomerMapWrapper((TTDProcessCustomerMap)_ttdProcessCustomerMap.clone());
	}

	@Override
	public int compareTo(TTDProcessCustomerMap ttdProcessCustomerMap) {
		return _ttdProcessCustomerMap.compareTo(ttdProcessCustomerMap);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return _ttdProcessCustomerMap.getAvailableLanguageIds();
	}

	/**
	* Returns the company ID of this ttd process customer map.
	*
	* @return the company ID of this ttd process customer map
	*/
	@Override
	public long getCompanyId() {
		return _ttdProcessCustomerMap.getCompanyId();
	}

	/**
	* Returns the created by of this ttd process customer map.
	*
	* @return the created by of this ttd process customer map
	*/
	@Override
	public long getCreatedBy() {
		return _ttdProcessCustomerMap.getCreatedBy();
	}

	/**
	* Returns the created on of this ttd process customer map.
	*
	* @return the created on of this ttd process customer map
	*/
	@Override
	public Date getCreatedOn() {
		return _ttdProcessCustomerMap.getCreatedOn();
	}

	@Override
	public String getDefaultLanguageId() {
		return _ttdProcessCustomerMap.getDefaultLanguageId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _ttdProcessCustomerMap.getExpandoBridge();
	}

	/**
	* Returns the modified by of this ttd process customer map.
	*
	* @return the modified by of this ttd process customer map
	*/
	@Override
	public long getModifiedBy() {
		return _ttdProcessCustomerMap.getModifiedBy();
	}

	/**
	* Returns the modified on of this ttd process customer map.
	*
	* @return the modified on of this ttd process customer map
	*/
	@Override
	public Date getModifiedOn() {
		return _ttdProcessCustomerMap.getModifiedOn();
	}

	/**
	* Returns the name of this ttd process customer map.
	*
	* @return the name of this ttd process customer map
	*/
	@Override
	public String getName() {
		return _ttdProcessCustomerMap.getName();
	}

	/**
	* Returns the localized name of this ttd process customer map in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized name of this ttd process customer map
	*/
	@Override
	public String getName(java.util.Locale locale) {
		return _ttdProcessCustomerMap.getName(locale);
	}

	/**
	* Returns the localized name of this ttd process customer map in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this ttd process customer map. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public String getName(java.util.Locale locale, boolean useDefault) {
		return _ttdProcessCustomerMap.getName(locale, useDefault);
	}

	/**
	* Returns the localized name of this ttd process customer map in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized name of this ttd process customer map
	*/
	@Override
	public String getName(String languageId) {
		return _ttdProcessCustomerMap.getName(languageId);
	}

	/**
	* Returns the localized name of this ttd process customer map in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this ttd process customer map
	*/
	@Override
	public String getName(String languageId, boolean useDefault) {
		return _ttdProcessCustomerMap.getName(languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _ttdProcessCustomerMap.getNameCurrentLanguageId();
	}

	@Override
	public String getNameCurrentValue() {
		return _ttdProcessCustomerMap.getNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized names of this ttd process customer map.
	*
	* @return the locales and localized names of this ttd process customer map
	*/
	@Override
	public Map<java.util.Locale, String> getNameMap() {
		return _ttdProcessCustomerMap.getNameMap();
	}

	/**
	* Returns the organization ID of this ttd process customer map.
	*
	* @return the organization ID of this ttd process customer map
	*/
	@Override
	public long getOrganizationId() {
		return _ttdProcessCustomerMap.getOrganizationId();
	}

	/**
	* Returns the primary key of this ttd process customer map.
	*
	* @return the primary key of this ttd process customer map
	*/
	@Override
	public long getPrimaryKey() {
		return _ttdProcessCustomerMap.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ttdProcessCustomerMap.getPrimaryKeyObj();
	}

	/**
	* Returns the status ID of this ttd process customer map.
	*
	* @return the status ID of this ttd process customer map
	*/
	@Override
	public int getStatusId() {
		return _ttdProcessCustomerMap.getStatusId();
	}

	/**
	* Returns the ttd process customer ID of this ttd process customer map.
	*
	* @return the ttd process customer ID of this ttd process customer map
	*/
	@Override
	public long getTTDProcessCustomerId() {
		return _ttdProcessCustomerMap.getTTDProcessCustomerId();
	}

	/**
	* Returns the ttd process ID of this ttd process customer map.
	*
	* @return the ttd process ID of this ttd process customer map
	*/
	@Override
	public long getTTDProcessId() {
		return _ttdProcessCustomerMap.getTTDProcessId();
	}

	@Override
	public int hashCode() {
		return _ttdProcessCustomerMap.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _ttdProcessCustomerMap.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _ttdProcessCustomerMap.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _ttdProcessCustomerMap.isNew();
	}

	@Override
	public void persist() {
		_ttdProcessCustomerMap.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {
		_ttdProcessCustomerMap.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {
		_ttdProcessCustomerMap.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ttdProcessCustomerMap.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this ttd process customer map.
	*
	* @param companyId the company ID of this ttd process customer map
	*/
	@Override
	public void setCompanyId(long companyId) {
		_ttdProcessCustomerMap.setCompanyId(companyId);
	}

	/**
	* Sets the created by of this ttd process customer map.
	*
	* @param createdBy the created by of this ttd process customer map
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_ttdProcessCustomerMap.setCreatedBy(createdBy);
	}

	/**
	* Sets the created on of this ttd process customer map.
	*
	* @param createdOn the created on of this ttd process customer map
	*/
	@Override
	public void setCreatedOn(Date createdOn) {
		_ttdProcessCustomerMap.setCreatedOn(createdOn);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_ttdProcessCustomerMap.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_ttdProcessCustomerMap.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_ttdProcessCustomerMap.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified by of this ttd process customer map.
	*
	* @param modifiedBy the modified by of this ttd process customer map
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_ttdProcessCustomerMap.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified on of this ttd process customer map.
	*
	* @param modifiedOn the modified on of this ttd process customer map
	*/
	@Override
	public void setModifiedOn(Date modifiedOn) {
		_ttdProcessCustomerMap.setModifiedOn(modifiedOn);
	}

	/**
	* Sets the name of this ttd process customer map.
	*
	* @param name the name of this ttd process customer map
	*/
	@Override
	public void setName(String name) {
		_ttdProcessCustomerMap.setName(name);
	}

	/**
	* Sets the localized name of this ttd process customer map in the language.
	*
	* @param name the localized name of this ttd process customer map
	* @param locale the locale of the language
	*/
	@Override
	public void setName(String name, java.util.Locale locale) {
		_ttdProcessCustomerMap.setName(name, locale);
	}

	/**
	* Sets the localized name of this ttd process customer map in the language, and sets the default locale.
	*
	* @param name the localized name of this ttd process customer map
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setName(String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_ttdProcessCustomerMap.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_ttdProcessCustomerMap.setNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized names of this ttd process customer map from the map of locales and localized names.
	*
	* @param nameMap the locales and localized names of this ttd process customer map
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap) {
		_ttdProcessCustomerMap.setNameMap(nameMap);
	}

	/**
	* Sets the localized names of this ttd process customer map from the map of locales and localized names, and sets the default locale.
	*
	* @param nameMap the locales and localized names of this ttd process customer map
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap,
		java.util.Locale defaultLocale) {
		_ttdProcessCustomerMap.setNameMap(nameMap, defaultLocale);
	}

	@Override
	public void setNew(boolean n) {
		_ttdProcessCustomerMap.setNew(n);
	}

	/**
	* Sets the organization ID of this ttd process customer map.
	*
	* @param organizationId the organization ID of this ttd process customer map
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_ttdProcessCustomerMap.setOrganizationId(organizationId);
	}

	/**
	* Sets the primary key of this ttd process customer map.
	*
	* @param primaryKey the primary key of this ttd process customer map
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ttdProcessCustomerMap.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_ttdProcessCustomerMap.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status ID of this ttd process customer map.
	*
	* @param statusId the status ID of this ttd process customer map
	*/
	@Override
	public void setStatusId(int statusId) {
		_ttdProcessCustomerMap.setStatusId(statusId);
	}

	/**
	* Sets the ttd process customer ID of this ttd process customer map.
	*
	* @param TTDProcessCustomerId the ttd process customer ID of this ttd process customer map
	*/
	@Override
	public void setTTDProcessCustomerId(long TTDProcessCustomerId) {
		_ttdProcessCustomerMap.setTTDProcessCustomerId(TTDProcessCustomerId);
	}

	/**
	* Sets the ttd process ID of this ttd process customer map.
	*
	* @param TTDProcessId the ttd process ID of this ttd process customer map
	*/
	@Override
	public void setTTDProcessId(long TTDProcessId) {
		_ttdProcessCustomerMap.setTTDProcessId(TTDProcessId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TTDProcessCustomerMap> toCacheModel() {
		return _ttdProcessCustomerMap.toCacheModel();
	}

	@Override
	public TTDProcessCustomerMap toEscapedModel() {
		return new TTDProcessCustomerMapWrapper(_ttdProcessCustomerMap.toEscapedModel());
	}

	@Override
	public String toString() {
		return _ttdProcessCustomerMap.toString();
	}

	@Override
	public TTDProcessCustomerMap toUnescapedModel() {
		return new TTDProcessCustomerMapWrapper(_ttdProcessCustomerMap.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _ttdProcessCustomerMap.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TTDProcessCustomerMapWrapper)) {
			return false;
		}

		TTDProcessCustomerMapWrapper ttdProcessCustomerMapWrapper = (TTDProcessCustomerMapWrapper)obj;

		if (Objects.equals(_ttdProcessCustomerMap,
					ttdProcessCustomerMapWrapper._ttdProcessCustomerMap)) {
			return true;
		}

		return false;
	}

	@Override
	public TTDProcessCustomerMap getWrappedModel() {
		return _ttdProcessCustomerMap;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _ttdProcessCustomerMap.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _ttdProcessCustomerMap.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_ttdProcessCustomerMap.resetOriginalValues();
	}

	private final TTDProcessCustomerMap _ttdProcessCustomerMap;
}