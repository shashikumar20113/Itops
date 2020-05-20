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
 * This class is a wrapper for {@link TowerCustomerMap}.
 * </p>
 *
 * @author sunprabh
 * @see TowerCustomerMap
 * @generated
 */
@ProviderType
public class TowerCustomerMapWrapper implements TowerCustomerMap,
	ModelWrapper<TowerCustomerMap> {
	public TowerCustomerMapWrapper(TowerCustomerMap towerCustomerMap) {
		_towerCustomerMap = towerCustomerMap;
	}

	@Override
	public Class<?> getModelClass() {
		return TowerCustomerMap.class;
	}

	@Override
	public String getModelClassName() {
		return TowerCustomerMap.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("towerCustomerId", getTowerCustomerId());
		attributes.put("towerId", getTowerId());
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
		Long towerCustomerId = (Long)attributes.get("towerCustomerId");

		if (towerCustomerId != null) {
			setTowerCustomerId(towerCustomerId);
		}

		Long towerId = (Long)attributes.get("towerId");

		if (towerId != null) {
			setTowerId(towerId);
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
		return new TowerCustomerMapWrapper((TowerCustomerMap)_towerCustomerMap.clone());
	}

	@Override
	public int compareTo(TowerCustomerMap towerCustomerMap) {
		return _towerCustomerMap.compareTo(towerCustomerMap);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return _towerCustomerMap.getAvailableLanguageIds();
	}

	/**
	* Returns the company ID of this tower customer map.
	*
	* @return the company ID of this tower customer map
	*/
	@Override
	public long getCompanyId() {
		return _towerCustomerMap.getCompanyId();
	}

	/**
	* Returns the created by of this tower customer map.
	*
	* @return the created by of this tower customer map
	*/
	@Override
	public long getCreatedBy() {
		return _towerCustomerMap.getCreatedBy();
	}

	/**
	* Returns the created on of this tower customer map.
	*
	* @return the created on of this tower customer map
	*/
	@Override
	public Date getCreatedOn() {
		return _towerCustomerMap.getCreatedOn();
	}

	@Override
	public String getDefaultLanguageId() {
		return _towerCustomerMap.getDefaultLanguageId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _towerCustomerMap.getExpandoBridge();
	}

	/**
	* Returns the modified by of this tower customer map.
	*
	* @return the modified by of this tower customer map
	*/
	@Override
	public long getModifiedBy() {
		return _towerCustomerMap.getModifiedBy();
	}

	/**
	* Returns the modified on of this tower customer map.
	*
	* @return the modified on of this tower customer map
	*/
	@Override
	public Date getModifiedOn() {
		return _towerCustomerMap.getModifiedOn();
	}

	/**
	* Returns the name of this tower customer map.
	*
	* @return the name of this tower customer map
	*/
	@Override
	public String getName() {
		return _towerCustomerMap.getName();
	}

	/**
	* Returns the localized name of this tower customer map in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized name of this tower customer map
	*/
	@Override
	public String getName(java.util.Locale locale) {
		return _towerCustomerMap.getName(locale);
	}

	/**
	* Returns the localized name of this tower customer map in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this tower customer map. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public String getName(java.util.Locale locale, boolean useDefault) {
		return _towerCustomerMap.getName(locale, useDefault);
	}

	/**
	* Returns the localized name of this tower customer map in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized name of this tower customer map
	*/
	@Override
	public String getName(String languageId) {
		return _towerCustomerMap.getName(languageId);
	}

	/**
	* Returns the localized name of this tower customer map in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this tower customer map
	*/
	@Override
	public String getName(String languageId, boolean useDefault) {
		return _towerCustomerMap.getName(languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _towerCustomerMap.getNameCurrentLanguageId();
	}

	@Override
	public String getNameCurrentValue() {
		return _towerCustomerMap.getNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized names of this tower customer map.
	*
	* @return the locales and localized names of this tower customer map
	*/
	@Override
	public Map<java.util.Locale, String> getNameMap() {
		return _towerCustomerMap.getNameMap();
	}

	/**
	* Returns the organization ID of this tower customer map.
	*
	* @return the organization ID of this tower customer map
	*/
	@Override
	public long getOrganizationId() {
		return _towerCustomerMap.getOrganizationId();
	}

	/**
	* Returns the primary key of this tower customer map.
	*
	* @return the primary key of this tower customer map
	*/
	@Override
	public long getPrimaryKey() {
		return _towerCustomerMap.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _towerCustomerMap.getPrimaryKeyObj();
	}

	/**
	* Returns the status ID of this tower customer map.
	*
	* @return the status ID of this tower customer map
	*/
	@Override
	public int getStatusId() {
		return _towerCustomerMap.getStatusId();
	}

	/**
	* Returns the tower customer ID of this tower customer map.
	*
	* @return the tower customer ID of this tower customer map
	*/
	@Override
	public long getTowerCustomerId() {
		return _towerCustomerMap.getTowerCustomerId();
	}

	/**
	* Returns the tower ID of this tower customer map.
	*
	* @return the tower ID of this tower customer map
	*/
	@Override
	public long getTowerId() {
		return _towerCustomerMap.getTowerId();
	}

	@Override
	public int hashCode() {
		return _towerCustomerMap.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _towerCustomerMap.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _towerCustomerMap.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _towerCustomerMap.isNew();
	}

	@Override
	public void persist() {
		_towerCustomerMap.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {
		_towerCustomerMap.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {
		_towerCustomerMap.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_towerCustomerMap.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this tower customer map.
	*
	* @param companyId the company ID of this tower customer map
	*/
	@Override
	public void setCompanyId(long companyId) {
		_towerCustomerMap.setCompanyId(companyId);
	}

	/**
	* Sets the created by of this tower customer map.
	*
	* @param createdBy the created by of this tower customer map
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_towerCustomerMap.setCreatedBy(createdBy);
	}

	/**
	* Sets the created on of this tower customer map.
	*
	* @param createdOn the created on of this tower customer map
	*/
	@Override
	public void setCreatedOn(Date createdOn) {
		_towerCustomerMap.setCreatedOn(createdOn);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_towerCustomerMap.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_towerCustomerMap.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_towerCustomerMap.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified by of this tower customer map.
	*
	* @param modifiedBy the modified by of this tower customer map
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_towerCustomerMap.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified on of this tower customer map.
	*
	* @param modifiedOn the modified on of this tower customer map
	*/
	@Override
	public void setModifiedOn(Date modifiedOn) {
		_towerCustomerMap.setModifiedOn(modifiedOn);
	}

	/**
	* Sets the name of this tower customer map.
	*
	* @param name the name of this tower customer map
	*/
	@Override
	public void setName(String name) {
		_towerCustomerMap.setName(name);
	}

	/**
	* Sets the localized name of this tower customer map in the language.
	*
	* @param name the localized name of this tower customer map
	* @param locale the locale of the language
	*/
	@Override
	public void setName(String name, java.util.Locale locale) {
		_towerCustomerMap.setName(name, locale);
	}

	/**
	* Sets the localized name of this tower customer map in the language, and sets the default locale.
	*
	* @param name the localized name of this tower customer map
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setName(String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_towerCustomerMap.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_towerCustomerMap.setNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized names of this tower customer map from the map of locales and localized names.
	*
	* @param nameMap the locales and localized names of this tower customer map
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap) {
		_towerCustomerMap.setNameMap(nameMap);
	}

	/**
	* Sets the localized names of this tower customer map from the map of locales and localized names, and sets the default locale.
	*
	* @param nameMap the locales and localized names of this tower customer map
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap,
		java.util.Locale defaultLocale) {
		_towerCustomerMap.setNameMap(nameMap, defaultLocale);
	}

	@Override
	public void setNew(boolean n) {
		_towerCustomerMap.setNew(n);
	}

	/**
	* Sets the organization ID of this tower customer map.
	*
	* @param organizationId the organization ID of this tower customer map
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_towerCustomerMap.setOrganizationId(organizationId);
	}

	/**
	* Sets the primary key of this tower customer map.
	*
	* @param primaryKey the primary key of this tower customer map
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_towerCustomerMap.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_towerCustomerMap.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status ID of this tower customer map.
	*
	* @param statusId the status ID of this tower customer map
	*/
	@Override
	public void setStatusId(int statusId) {
		_towerCustomerMap.setStatusId(statusId);
	}

	/**
	* Sets the tower customer ID of this tower customer map.
	*
	* @param towerCustomerId the tower customer ID of this tower customer map
	*/
	@Override
	public void setTowerCustomerId(long towerCustomerId) {
		_towerCustomerMap.setTowerCustomerId(towerCustomerId);
	}

	/**
	* Sets the tower ID of this tower customer map.
	*
	* @param towerId the tower ID of this tower customer map
	*/
	@Override
	public void setTowerId(long towerId) {
		_towerCustomerMap.setTowerId(towerId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TowerCustomerMap> toCacheModel() {
		return _towerCustomerMap.toCacheModel();
	}

	@Override
	public TowerCustomerMap toEscapedModel() {
		return new TowerCustomerMapWrapper(_towerCustomerMap.toEscapedModel());
	}

	@Override
	public String toString() {
		return _towerCustomerMap.toString();
	}

	@Override
	public TowerCustomerMap toUnescapedModel() {
		return new TowerCustomerMapWrapper(_towerCustomerMap.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _towerCustomerMap.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TowerCustomerMapWrapper)) {
			return false;
		}

		TowerCustomerMapWrapper towerCustomerMapWrapper = (TowerCustomerMapWrapper)obj;

		if (Objects.equals(_towerCustomerMap,
					towerCustomerMapWrapper._towerCustomerMap)) {
			return true;
		}

		return false;
	}

	@Override
	public TowerCustomerMap getWrappedModel() {
		return _towerCustomerMap;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _towerCustomerMap.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _towerCustomerMap.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_towerCustomerMap.resetOriginalValues();
	}

	private final TowerCustomerMap _towerCustomerMap;
}