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
 * This class is a wrapper for {@link TTDPSubProcessCustomerMap}.
 * </p>
 *
 * @author sunprabh
 * @see TTDPSubProcessCustomerMap
 * @generated
 */
@ProviderType
public class TTDPSubProcessCustomerMapWrapper
	implements TTDPSubProcessCustomerMap,
		ModelWrapper<TTDPSubProcessCustomerMap> {
	public TTDPSubProcessCustomerMapWrapper(
		TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap) {
		_ttdpSubProcessCustomerMap = ttdpSubProcessCustomerMap;
	}

	@Override
	public Class<?> getModelClass() {
		return TTDPSubProcessCustomerMap.class;
	}

	@Override
	public String getModelClassName() {
		return TTDPSubProcessCustomerMap.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("TTDPSubProcessCustomerId", getTTDPSubProcessCustomerId());
		attributes.put("TTDPSubProcessId", getTTDPSubProcessId());
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
		Long TTDPSubProcessCustomerId = (Long)attributes.get(
				"TTDPSubProcessCustomerId");

		if (TTDPSubProcessCustomerId != null) {
			setTTDPSubProcessCustomerId(TTDPSubProcessCustomerId);
		}

		Long TTDPSubProcessId = (Long)attributes.get("TTDPSubProcessId");

		if (TTDPSubProcessId != null) {
			setTTDPSubProcessId(TTDPSubProcessId);
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
		return new TTDPSubProcessCustomerMapWrapper((TTDPSubProcessCustomerMap)_ttdpSubProcessCustomerMap.clone());
	}

	@Override
	public int compareTo(TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap) {
		return _ttdpSubProcessCustomerMap.compareTo(ttdpSubProcessCustomerMap);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return _ttdpSubProcessCustomerMap.getAvailableLanguageIds();
	}

	/**
	* Returns the company ID of this ttdp sub process customer map.
	*
	* @return the company ID of this ttdp sub process customer map
	*/
	@Override
	public long getCompanyId() {
		return _ttdpSubProcessCustomerMap.getCompanyId();
	}

	/**
	* Returns the created by of this ttdp sub process customer map.
	*
	* @return the created by of this ttdp sub process customer map
	*/
	@Override
	public long getCreatedBy() {
		return _ttdpSubProcessCustomerMap.getCreatedBy();
	}

	/**
	* Returns the created on of this ttdp sub process customer map.
	*
	* @return the created on of this ttdp sub process customer map
	*/
	@Override
	public Date getCreatedOn() {
		return _ttdpSubProcessCustomerMap.getCreatedOn();
	}

	@Override
	public String getDefaultLanguageId() {
		return _ttdpSubProcessCustomerMap.getDefaultLanguageId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _ttdpSubProcessCustomerMap.getExpandoBridge();
	}

	/**
	* Returns the modified by of this ttdp sub process customer map.
	*
	* @return the modified by of this ttdp sub process customer map
	*/
	@Override
	public long getModifiedBy() {
		return _ttdpSubProcessCustomerMap.getModifiedBy();
	}

	/**
	* Returns the modified on of this ttdp sub process customer map.
	*
	* @return the modified on of this ttdp sub process customer map
	*/
	@Override
	public Date getModifiedOn() {
		return _ttdpSubProcessCustomerMap.getModifiedOn();
	}

	/**
	* Returns the name of this ttdp sub process customer map.
	*
	* @return the name of this ttdp sub process customer map
	*/
	@Override
	public String getName() {
		return _ttdpSubProcessCustomerMap.getName();
	}

	/**
	* Returns the localized name of this ttdp sub process customer map in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized name of this ttdp sub process customer map
	*/
	@Override
	public String getName(java.util.Locale locale) {
		return _ttdpSubProcessCustomerMap.getName(locale);
	}

	/**
	* Returns the localized name of this ttdp sub process customer map in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this ttdp sub process customer map. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public String getName(java.util.Locale locale, boolean useDefault) {
		return _ttdpSubProcessCustomerMap.getName(locale, useDefault);
	}

	/**
	* Returns the localized name of this ttdp sub process customer map in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized name of this ttdp sub process customer map
	*/
	@Override
	public String getName(String languageId) {
		return _ttdpSubProcessCustomerMap.getName(languageId);
	}

	/**
	* Returns the localized name of this ttdp sub process customer map in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this ttdp sub process customer map
	*/
	@Override
	public String getName(String languageId, boolean useDefault) {
		return _ttdpSubProcessCustomerMap.getName(languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _ttdpSubProcessCustomerMap.getNameCurrentLanguageId();
	}

	@Override
	public String getNameCurrentValue() {
		return _ttdpSubProcessCustomerMap.getNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized names of this ttdp sub process customer map.
	*
	* @return the locales and localized names of this ttdp sub process customer map
	*/
	@Override
	public Map<java.util.Locale, String> getNameMap() {
		return _ttdpSubProcessCustomerMap.getNameMap();
	}

	/**
	* Returns the organization ID of this ttdp sub process customer map.
	*
	* @return the organization ID of this ttdp sub process customer map
	*/
	@Override
	public long getOrganizationId() {
		return _ttdpSubProcessCustomerMap.getOrganizationId();
	}

	/**
	* Returns the primary key of this ttdp sub process customer map.
	*
	* @return the primary key of this ttdp sub process customer map
	*/
	@Override
	public long getPrimaryKey() {
		return _ttdpSubProcessCustomerMap.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ttdpSubProcessCustomerMap.getPrimaryKeyObj();
	}

	/**
	* Returns the status ID of this ttdp sub process customer map.
	*
	* @return the status ID of this ttdp sub process customer map
	*/
	@Override
	public int getStatusId() {
		return _ttdpSubProcessCustomerMap.getStatusId();
	}

	/**
	* Returns the ttdp sub process customer ID of this ttdp sub process customer map.
	*
	* @return the ttdp sub process customer ID of this ttdp sub process customer map
	*/
	@Override
	public long getTTDPSubProcessCustomerId() {
		return _ttdpSubProcessCustomerMap.getTTDPSubProcessCustomerId();
	}

	/**
	* Returns the ttdp sub process ID of this ttdp sub process customer map.
	*
	* @return the ttdp sub process ID of this ttdp sub process customer map
	*/
	@Override
	public long getTTDPSubProcessId() {
		return _ttdpSubProcessCustomerMap.getTTDPSubProcessId();
	}

	@Override
	public int hashCode() {
		return _ttdpSubProcessCustomerMap.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _ttdpSubProcessCustomerMap.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _ttdpSubProcessCustomerMap.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _ttdpSubProcessCustomerMap.isNew();
	}

	@Override
	public void persist() {
		_ttdpSubProcessCustomerMap.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {
		_ttdpSubProcessCustomerMap.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {
		_ttdpSubProcessCustomerMap.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ttdpSubProcessCustomerMap.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this ttdp sub process customer map.
	*
	* @param companyId the company ID of this ttdp sub process customer map
	*/
	@Override
	public void setCompanyId(long companyId) {
		_ttdpSubProcessCustomerMap.setCompanyId(companyId);
	}

	/**
	* Sets the created by of this ttdp sub process customer map.
	*
	* @param createdBy the created by of this ttdp sub process customer map
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_ttdpSubProcessCustomerMap.setCreatedBy(createdBy);
	}

	/**
	* Sets the created on of this ttdp sub process customer map.
	*
	* @param createdOn the created on of this ttdp sub process customer map
	*/
	@Override
	public void setCreatedOn(Date createdOn) {
		_ttdpSubProcessCustomerMap.setCreatedOn(createdOn);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_ttdpSubProcessCustomerMap.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_ttdpSubProcessCustomerMap.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_ttdpSubProcessCustomerMap.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified by of this ttdp sub process customer map.
	*
	* @param modifiedBy the modified by of this ttdp sub process customer map
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_ttdpSubProcessCustomerMap.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified on of this ttdp sub process customer map.
	*
	* @param modifiedOn the modified on of this ttdp sub process customer map
	*/
	@Override
	public void setModifiedOn(Date modifiedOn) {
		_ttdpSubProcessCustomerMap.setModifiedOn(modifiedOn);
	}

	/**
	* Sets the name of this ttdp sub process customer map.
	*
	* @param name the name of this ttdp sub process customer map
	*/
	@Override
	public void setName(String name) {
		_ttdpSubProcessCustomerMap.setName(name);
	}

	/**
	* Sets the localized name of this ttdp sub process customer map in the language.
	*
	* @param name the localized name of this ttdp sub process customer map
	* @param locale the locale of the language
	*/
	@Override
	public void setName(String name, java.util.Locale locale) {
		_ttdpSubProcessCustomerMap.setName(name, locale);
	}

	/**
	* Sets the localized name of this ttdp sub process customer map in the language, and sets the default locale.
	*
	* @param name the localized name of this ttdp sub process customer map
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setName(String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_ttdpSubProcessCustomerMap.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_ttdpSubProcessCustomerMap.setNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized names of this ttdp sub process customer map from the map of locales and localized names.
	*
	* @param nameMap the locales and localized names of this ttdp sub process customer map
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap) {
		_ttdpSubProcessCustomerMap.setNameMap(nameMap);
	}

	/**
	* Sets the localized names of this ttdp sub process customer map from the map of locales and localized names, and sets the default locale.
	*
	* @param nameMap the locales and localized names of this ttdp sub process customer map
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap,
		java.util.Locale defaultLocale) {
		_ttdpSubProcessCustomerMap.setNameMap(nameMap, defaultLocale);
	}

	@Override
	public void setNew(boolean n) {
		_ttdpSubProcessCustomerMap.setNew(n);
	}

	/**
	* Sets the organization ID of this ttdp sub process customer map.
	*
	* @param organizationId the organization ID of this ttdp sub process customer map
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_ttdpSubProcessCustomerMap.setOrganizationId(organizationId);
	}

	/**
	* Sets the primary key of this ttdp sub process customer map.
	*
	* @param primaryKey the primary key of this ttdp sub process customer map
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ttdpSubProcessCustomerMap.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_ttdpSubProcessCustomerMap.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status ID of this ttdp sub process customer map.
	*
	* @param statusId the status ID of this ttdp sub process customer map
	*/
	@Override
	public void setStatusId(int statusId) {
		_ttdpSubProcessCustomerMap.setStatusId(statusId);
	}

	/**
	* Sets the ttdp sub process customer ID of this ttdp sub process customer map.
	*
	* @param TTDPSubProcessCustomerId the ttdp sub process customer ID of this ttdp sub process customer map
	*/
	@Override
	public void setTTDPSubProcessCustomerId(long TTDPSubProcessCustomerId) {
		_ttdpSubProcessCustomerMap.setTTDPSubProcessCustomerId(TTDPSubProcessCustomerId);
	}

	/**
	* Sets the ttdp sub process ID of this ttdp sub process customer map.
	*
	* @param TTDPSubProcessId the ttdp sub process ID of this ttdp sub process customer map
	*/
	@Override
	public void setTTDPSubProcessId(long TTDPSubProcessId) {
		_ttdpSubProcessCustomerMap.setTTDPSubProcessId(TTDPSubProcessId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TTDPSubProcessCustomerMap> toCacheModel() {
		return _ttdpSubProcessCustomerMap.toCacheModel();
	}

	@Override
	public TTDPSubProcessCustomerMap toEscapedModel() {
		return new TTDPSubProcessCustomerMapWrapper(_ttdpSubProcessCustomerMap.toEscapedModel());
	}

	@Override
	public String toString() {
		return _ttdpSubProcessCustomerMap.toString();
	}

	@Override
	public TTDPSubProcessCustomerMap toUnescapedModel() {
		return new TTDPSubProcessCustomerMapWrapper(_ttdpSubProcessCustomerMap.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _ttdpSubProcessCustomerMap.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TTDPSubProcessCustomerMapWrapper)) {
			return false;
		}

		TTDPSubProcessCustomerMapWrapper ttdpSubProcessCustomerMapWrapper = (TTDPSubProcessCustomerMapWrapper)obj;

		if (Objects.equals(_ttdpSubProcessCustomerMap,
					ttdpSubProcessCustomerMapWrapper._ttdpSubProcessCustomerMap)) {
			return true;
		}

		return false;
	}

	@Override
	public TTDPSubProcessCustomerMap getWrappedModel() {
		return _ttdpSubProcessCustomerMap;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _ttdpSubProcessCustomerMap.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _ttdpSubProcessCustomerMap.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_ttdpSubProcessCustomerMap.resetOriginalValues();
	}

	private final TTDPSubProcessCustomerMap _ttdpSubProcessCustomerMap;
}