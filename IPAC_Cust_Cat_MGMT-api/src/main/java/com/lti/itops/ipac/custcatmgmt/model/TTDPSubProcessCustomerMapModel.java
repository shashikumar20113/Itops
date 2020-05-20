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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the TTDPSubProcessCustomerMap service. Represents a row in the &quot;IPAC_CUST_CAT_MGMT_TTDPSubProcessCustomerMap&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSubProcessCustomerMapModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSubProcessCustomerMapImpl}.
 * </p>
 *
 * @author sunprabh
 * @see TTDPSubProcessCustomerMap
 * @see com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSubProcessCustomerMapImpl
 * @see com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSubProcessCustomerMapModelImpl
 * @generated
 */
@ProviderType
public interface TTDPSubProcessCustomerMapModel extends BaseModel<TTDPSubProcessCustomerMap>,
	LocalizedModel, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ttdp sub process customer map model instance should use the {@link TTDPSubProcessCustomerMap} interface instead.
	 */

	/**
	 * Returns the primary key of this ttdp sub process customer map.
	 *
	 * @return the primary key of this ttdp sub process customer map
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ttdp sub process customer map.
	 *
	 * @param primaryKey the primary key of this ttdp sub process customer map
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ttdp sub process customer ID of this ttdp sub process customer map.
	 *
	 * @return the ttdp sub process customer ID of this ttdp sub process customer map
	 */
	public long getTTDPSubProcessCustomerId();

	/**
	 * Sets the ttdp sub process customer ID of this ttdp sub process customer map.
	 *
	 * @param TTDPSubProcessCustomerId the ttdp sub process customer ID of this ttdp sub process customer map
	 */
	public void setTTDPSubProcessCustomerId(long TTDPSubProcessCustomerId);

	/**
	 * Returns the ttdp sub process ID of this ttdp sub process customer map.
	 *
	 * @return the ttdp sub process ID of this ttdp sub process customer map
	 */
	public long getTTDPSubProcessId();

	/**
	 * Sets the ttdp sub process ID of this ttdp sub process customer map.
	 *
	 * @param TTDPSubProcessId the ttdp sub process ID of this ttdp sub process customer map
	 */
	public void setTTDPSubProcessId(long TTDPSubProcessId);

	/**
	 * Returns the organization ID of this ttdp sub process customer map.
	 *
	 * @return the organization ID of this ttdp sub process customer map
	 */
	public long getOrganizationId();

	/**
	 * Sets the organization ID of this ttdp sub process customer map.
	 *
	 * @param organizationId the organization ID of this ttdp sub process customer map
	 */
	public void setOrganizationId(long organizationId);

	/**
	 * Returns the name of this ttdp sub process customer map.
	 *
	 * @return the name of this ttdp sub process customer map
	 */
	public String getName();

	/**
	 * Returns the localized name of this ttdp sub process customer map in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this ttdp sub process customer map
	 */
	@AutoEscape
	public String getName(Locale locale);

	/**
	 * Returns the localized name of this ttdp sub process customer map in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this ttdp sub process customer map. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized name of this ttdp sub process customer map in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this ttdp sub process customer map
	 */
	@AutoEscape
	public String getName(String languageId);

	/**
	 * Returns the localized name of this ttdp sub process customer map in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this ttdp sub process customer map
	 */
	@AutoEscape
	public String getName(String languageId, boolean useDefault);

	@AutoEscape
	public String getNameCurrentLanguageId();

	@AutoEscape
	public String getNameCurrentValue();

	/**
	 * Returns a map of the locales and localized names of this ttdp sub process customer map.
	 *
	 * @return the locales and localized names of this ttdp sub process customer map
	 */
	public Map<Locale, String> getNameMap();

	/**
	 * Sets the name of this ttdp sub process customer map.
	 *
	 * @param name the name of this ttdp sub process customer map
	 */
	public void setName(String name);

	/**
	 * Sets the localized name of this ttdp sub process customer map in the language.
	 *
	 * @param name the localized name of this ttdp sub process customer map
	 * @param locale the locale of the language
	 */
	public void setName(String name, Locale locale);

	/**
	 * Sets the localized name of this ttdp sub process customer map in the language, and sets the default locale.
	 *
	 * @param name the localized name of this ttdp sub process customer map
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setName(String name, Locale locale, Locale defaultLocale);

	public void setNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized names of this ttdp sub process customer map from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this ttdp sub process customer map
	 */
	public void setNameMap(Map<Locale, String> nameMap);

	/**
	 * Sets the localized names of this ttdp sub process customer map from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this ttdp sub process customer map
	 * @param defaultLocale the default locale
	 */
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale);

	/**
	 * Returns the company ID of this ttdp sub process customer map.
	 *
	 * @return the company ID of this ttdp sub process customer map
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this ttdp sub process customer map.
	 *
	 * @param companyId the company ID of this ttdp sub process customer map
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the created by of this ttdp sub process customer map.
	 *
	 * @return the created by of this ttdp sub process customer map
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this ttdp sub process customer map.
	 *
	 * @param createdBy the created by of this ttdp sub process customer map
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the created on of this ttdp sub process customer map.
	 *
	 * @return the created on of this ttdp sub process customer map
	 */
	public Date getCreatedOn();

	/**
	 * Sets the created on of this ttdp sub process customer map.
	 *
	 * @param createdOn the created on of this ttdp sub process customer map
	 */
	public void setCreatedOn(Date createdOn);

	/**
	 * Returns the modified by of this ttdp sub process customer map.
	 *
	 * @return the modified by of this ttdp sub process customer map
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this ttdp sub process customer map.
	 *
	 * @param modifiedBy the modified by of this ttdp sub process customer map
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns the modified on of this ttdp sub process customer map.
	 *
	 * @return the modified on of this ttdp sub process customer map
	 */
	public Date getModifiedOn();

	/**
	 * Sets the modified on of this ttdp sub process customer map.
	 *
	 * @param modifiedOn the modified on of this ttdp sub process customer map
	 */
	public void setModifiedOn(Date modifiedOn);

	/**
	 * Returns the status ID of this ttdp sub process customer map.
	 *
	 * @return the status ID of this ttdp sub process customer map
	 */
	public int getStatusId();

	/**
	 * Sets the status ID of this ttdp sub process customer map.
	 *
	 * @param statusId the status ID of this ttdp sub process customer map
	 */
	public void setStatusId(int statusId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public String[] getAvailableLanguageIds();

	@Override
	public String getDefaultLanguageId();

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException;

	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	@Override
	public Object clone();

	@Override
	public int compareTo(TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap);

	@Override
	public int hashCode();

	@Override
	public CacheModel<TTDPSubProcessCustomerMap> toCacheModel();

	@Override
	public TTDPSubProcessCustomerMap toEscapedModel();

	@Override
	public TTDPSubProcessCustomerMap toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}