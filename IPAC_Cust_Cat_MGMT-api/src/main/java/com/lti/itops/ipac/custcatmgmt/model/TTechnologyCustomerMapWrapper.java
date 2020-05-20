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
 * This class is a wrapper for {@link TTechnologyCustomerMap}.
 * </p>
 *
 * @author sunprabh
 * @see TTechnologyCustomerMap
 * @generated
 */
@ProviderType
public class TTechnologyCustomerMapWrapper implements TTechnologyCustomerMap,
	ModelWrapper<TTechnologyCustomerMap> {
	public TTechnologyCustomerMapWrapper(
		TTechnologyCustomerMap tTechnologyCustomerMap) {
		_tTechnologyCustomerMap = tTechnologyCustomerMap;
	}

	@Override
	public Class<?> getModelClass() {
		return TTechnologyCustomerMap.class;
	}

	@Override
	public String getModelClassName() {
		return TTechnologyCustomerMap.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("TTechnologyCustomerId", getTTechnologyCustomerId());
		attributes.put("towerTechnologyId", getTowerTechnologyId());
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
		Long TTechnologyCustomerId = (Long)attributes.get(
				"TTechnologyCustomerId");

		if (TTechnologyCustomerId != null) {
			setTTechnologyCustomerId(TTechnologyCustomerId);
		}

		Long towerTechnologyId = (Long)attributes.get("towerTechnologyId");

		if (towerTechnologyId != null) {
			setTowerTechnologyId(towerTechnologyId);
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
		return new TTechnologyCustomerMapWrapper((TTechnologyCustomerMap)_tTechnologyCustomerMap.clone());
	}

	@Override
	public int compareTo(TTechnologyCustomerMap tTechnologyCustomerMap) {
		return _tTechnologyCustomerMap.compareTo(tTechnologyCustomerMap);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return _tTechnologyCustomerMap.getAvailableLanguageIds();
	}

	/**
	* Returns the company ID of this t technology customer map.
	*
	* @return the company ID of this t technology customer map
	*/
	@Override
	public long getCompanyId() {
		return _tTechnologyCustomerMap.getCompanyId();
	}

	/**
	* Returns the created by of this t technology customer map.
	*
	* @return the created by of this t technology customer map
	*/
	@Override
	public long getCreatedBy() {
		return _tTechnologyCustomerMap.getCreatedBy();
	}

	/**
	* Returns the created on of this t technology customer map.
	*
	* @return the created on of this t technology customer map
	*/
	@Override
	public Date getCreatedOn() {
		return _tTechnologyCustomerMap.getCreatedOn();
	}

	@Override
	public String getDefaultLanguageId() {
		return _tTechnologyCustomerMap.getDefaultLanguageId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _tTechnologyCustomerMap.getExpandoBridge();
	}

	/**
	* Returns the modified by of this t technology customer map.
	*
	* @return the modified by of this t technology customer map
	*/
	@Override
	public long getModifiedBy() {
		return _tTechnologyCustomerMap.getModifiedBy();
	}

	/**
	* Returns the modified on of this t technology customer map.
	*
	* @return the modified on of this t technology customer map
	*/
	@Override
	public Date getModifiedOn() {
		return _tTechnologyCustomerMap.getModifiedOn();
	}

	/**
	* Returns the name of this t technology customer map.
	*
	* @return the name of this t technology customer map
	*/
	@Override
	public String getName() {
		return _tTechnologyCustomerMap.getName();
	}

	/**
	* Returns the localized name of this t technology customer map in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized name of this t technology customer map
	*/
	@Override
	public String getName(java.util.Locale locale) {
		return _tTechnologyCustomerMap.getName(locale);
	}

	/**
	* Returns the localized name of this t technology customer map in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this t technology customer map. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public String getName(java.util.Locale locale, boolean useDefault) {
		return _tTechnologyCustomerMap.getName(locale, useDefault);
	}

	/**
	* Returns the localized name of this t technology customer map in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized name of this t technology customer map
	*/
	@Override
	public String getName(String languageId) {
		return _tTechnologyCustomerMap.getName(languageId);
	}

	/**
	* Returns the localized name of this t technology customer map in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this t technology customer map
	*/
	@Override
	public String getName(String languageId, boolean useDefault) {
		return _tTechnologyCustomerMap.getName(languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _tTechnologyCustomerMap.getNameCurrentLanguageId();
	}

	@Override
	public String getNameCurrentValue() {
		return _tTechnologyCustomerMap.getNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized names of this t technology customer map.
	*
	* @return the locales and localized names of this t technology customer map
	*/
	@Override
	public Map<java.util.Locale, String> getNameMap() {
		return _tTechnologyCustomerMap.getNameMap();
	}

	/**
	* Returns the organization ID of this t technology customer map.
	*
	* @return the organization ID of this t technology customer map
	*/
	@Override
	public long getOrganizationId() {
		return _tTechnologyCustomerMap.getOrganizationId();
	}

	/**
	* Returns the primary key of this t technology customer map.
	*
	* @return the primary key of this t technology customer map
	*/
	@Override
	public long getPrimaryKey() {
		return _tTechnologyCustomerMap.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tTechnologyCustomerMap.getPrimaryKeyObj();
	}

	/**
	* Returns the status ID of this t technology customer map.
	*
	* @return the status ID of this t technology customer map
	*/
	@Override
	public int getStatusId() {
		return _tTechnologyCustomerMap.getStatusId();
	}

	/**
	* Returns the tower technology ID of this t technology customer map.
	*
	* @return the tower technology ID of this t technology customer map
	*/
	@Override
	public long getTowerTechnologyId() {
		return _tTechnologyCustomerMap.getTowerTechnologyId();
	}

	/**
	* Returns the t technology customer ID of this t technology customer map.
	*
	* @return the t technology customer ID of this t technology customer map
	*/
	@Override
	public long getTTechnologyCustomerId() {
		return _tTechnologyCustomerMap.getTTechnologyCustomerId();
	}

	@Override
	public int hashCode() {
		return _tTechnologyCustomerMap.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _tTechnologyCustomerMap.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _tTechnologyCustomerMap.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _tTechnologyCustomerMap.isNew();
	}

	@Override
	public void persist() {
		_tTechnologyCustomerMap.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {
		_tTechnologyCustomerMap.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {
		_tTechnologyCustomerMap.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tTechnologyCustomerMap.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this t technology customer map.
	*
	* @param companyId the company ID of this t technology customer map
	*/
	@Override
	public void setCompanyId(long companyId) {
		_tTechnologyCustomerMap.setCompanyId(companyId);
	}

	/**
	* Sets the created by of this t technology customer map.
	*
	* @param createdBy the created by of this t technology customer map
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_tTechnologyCustomerMap.setCreatedBy(createdBy);
	}

	/**
	* Sets the created on of this t technology customer map.
	*
	* @param createdOn the created on of this t technology customer map
	*/
	@Override
	public void setCreatedOn(Date createdOn) {
		_tTechnologyCustomerMap.setCreatedOn(createdOn);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_tTechnologyCustomerMap.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_tTechnologyCustomerMap.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_tTechnologyCustomerMap.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified by of this t technology customer map.
	*
	* @param modifiedBy the modified by of this t technology customer map
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_tTechnologyCustomerMap.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified on of this t technology customer map.
	*
	* @param modifiedOn the modified on of this t technology customer map
	*/
	@Override
	public void setModifiedOn(Date modifiedOn) {
		_tTechnologyCustomerMap.setModifiedOn(modifiedOn);
	}

	/**
	* Sets the name of this t technology customer map.
	*
	* @param name the name of this t technology customer map
	*/
	@Override
	public void setName(String name) {
		_tTechnologyCustomerMap.setName(name);
	}

	/**
	* Sets the localized name of this t technology customer map in the language.
	*
	* @param name the localized name of this t technology customer map
	* @param locale the locale of the language
	*/
	@Override
	public void setName(String name, java.util.Locale locale) {
		_tTechnologyCustomerMap.setName(name, locale);
	}

	/**
	* Sets the localized name of this t technology customer map in the language, and sets the default locale.
	*
	* @param name the localized name of this t technology customer map
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setName(String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_tTechnologyCustomerMap.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_tTechnologyCustomerMap.setNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized names of this t technology customer map from the map of locales and localized names.
	*
	* @param nameMap the locales and localized names of this t technology customer map
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap) {
		_tTechnologyCustomerMap.setNameMap(nameMap);
	}

	/**
	* Sets the localized names of this t technology customer map from the map of locales and localized names, and sets the default locale.
	*
	* @param nameMap the locales and localized names of this t technology customer map
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap,
		java.util.Locale defaultLocale) {
		_tTechnologyCustomerMap.setNameMap(nameMap, defaultLocale);
	}

	@Override
	public void setNew(boolean n) {
		_tTechnologyCustomerMap.setNew(n);
	}

	/**
	* Sets the organization ID of this t technology customer map.
	*
	* @param organizationId the organization ID of this t technology customer map
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_tTechnologyCustomerMap.setOrganizationId(organizationId);
	}

	/**
	* Sets the primary key of this t technology customer map.
	*
	* @param primaryKey the primary key of this t technology customer map
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tTechnologyCustomerMap.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_tTechnologyCustomerMap.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status ID of this t technology customer map.
	*
	* @param statusId the status ID of this t technology customer map
	*/
	@Override
	public void setStatusId(int statusId) {
		_tTechnologyCustomerMap.setStatusId(statusId);
	}

	/**
	* Sets the tower technology ID of this t technology customer map.
	*
	* @param towerTechnologyId the tower technology ID of this t technology customer map
	*/
	@Override
	public void setTowerTechnologyId(long towerTechnologyId) {
		_tTechnologyCustomerMap.setTowerTechnologyId(towerTechnologyId);
	}

	/**
	* Sets the t technology customer ID of this t technology customer map.
	*
	* @param TTechnologyCustomerId the t technology customer ID of this t technology customer map
	*/
	@Override
	public void setTTechnologyCustomerId(long TTechnologyCustomerId) {
		_tTechnologyCustomerMap.setTTechnologyCustomerId(TTechnologyCustomerId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TTechnologyCustomerMap> toCacheModel() {
		return _tTechnologyCustomerMap.toCacheModel();
	}

	@Override
	public TTechnologyCustomerMap toEscapedModel() {
		return new TTechnologyCustomerMapWrapper(_tTechnologyCustomerMap.toEscapedModel());
	}

	@Override
	public String toString() {
		return _tTechnologyCustomerMap.toString();
	}

	@Override
	public TTechnologyCustomerMap toUnescapedModel() {
		return new TTechnologyCustomerMapWrapper(_tTechnologyCustomerMap.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _tTechnologyCustomerMap.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TTechnologyCustomerMapWrapper)) {
			return false;
		}

		TTechnologyCustomerMapWrapper tTechnologyCustomerMapWrapper = (TTechnologyCustomerMapWrapper)obj;

		if (Objects.equals(_tTechnologyCustomerMap,
					tTechnologyCustomerMapWrapper._tTechnologyCustomerMap)) {
			return true;
		}

		return false;
	}

	@Override
	public TTechnologyCustomerMap getWrappedModel() {
		return _tTechnologyCustomerMap;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _tTechnologyCustomerMap.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _tTechnologyCustomerMap.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_tTechnologyCustomerMap.resetOriginalValues();
	}

	private final TTechnologyCustomerMap _tTechnologyCustomerMap;
}